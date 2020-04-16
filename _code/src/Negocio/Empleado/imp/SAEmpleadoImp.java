/**
 * 
 */
package Negocio.Empleado.imp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import Negocio.Departamento.imp.Departamento;
import Negocio.Empleado.SAEmpleado;
import Negocio.Evento.imp.Participa;


/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Ana Álava Papí
* @author Óscar Canive Huguet
* @author David Domínguez Gutiérrez
* @author Fátima García Delgado
* @author Marina Lozano Lahuerta
* @author Paula Sánchez de la Nieta Gómez
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class SAEmpleadoImp implements SAEmpleado {
	/** 
	* (non-Javadoc)
	* @see SAEmpleado#altaEmpleado()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	public int altaEmpleado(TEmpleado tEmpleado){
		int id=-1;
		try{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
		EntityManager entitymanager = emfactory.createEntityManager();
		EntityTransaction entitytransaction = entitymanager.getTransaction();
		entitytransaction.begin();
		Departamento dep = entitymanager.find(Departamento.class, tEmpleado.getDepartamento().getIdDepartamento());
		if(dep!=null && dep.getActivo()){
			TypedQuery<Empleado> query = entitymanager
					.createNamedQuery("Negocio.Empleado.imp.Empleado.findByDNI", Empleado.class)
					.setParameter("DNI", tEmpleado.getDNI());
			List<Empleado> res = query.getResultList();
			if(res.size()==0){
				tEmpleado.setActivo(true);
				dep.setNumeroPersonas(dep.getNumeroPersonas()+1);
				if(tEmpleado instanceof TEmpleadoTiempoCompleto){
					EmpleadoTiempoCompleto emp=new EmpleadoTiempoCompleto((TEmpleadoTiempoCompleto)tEmpleado);
					entitymanager.persist(emp);
					entitytransaction.commit();
					id = emp.getId(); // resultado del alta empleado
				}
				else{
					EmpleadoTiempoParcial emp=new EmpleadoTiempoParcial((TEmpleadoTiempoParcial)tEmpleado);
					entitymanager.persist(emp);
					entitytransaction.commit();
					id = emp.getId(); // resultado del alta empleado
				}
			}
			else if(!res.get(0).getActivo()){
				if((res.get(0) instanceof EmpleadoTiempoCompleto && tEmpleado instanceof TEmpleadoTiempoCompleto) 
						|| (res.get(0) instanceof EmpleadoTiempoParcial && tEmpleado instanceof TEmpleadoTiempoParcial)){
					res.get(0).setActivo(true);
					res.get(0).setDNI(tEmpleado.getDNI());
					res.get(0).setNombre(tEmpleado.getNombre());
					res.get(0).setTelefono(tEmpleado.getTelefono());
					res.get(0).setSueldoBase(tEmpleado.getSueldoBase());
					if(res.get(0) instanceof EmpleadoTiempoCompleto){
						((EmpleadoTiempoCompleto)res.get(0)).setPluses(((TEmpleadoTiempoCompleto)tEmpleado).getPluses());
						id=res.get(0).getId();
					}
					else{
						((EmpleadoTiempoParcial)res.get(0)).setNumHoras(((TEmpleadoTiempoParcial)tEmpleado).getNumHoras());
						id=res.get(0).getId();
					}
					dep.setNumeroPersonas(dep.getNumeroPersonas()+1);
					entitytransaction.commit();
				}
				else{
					//El que existe dado de baja no concuerda en tipo
					id=-3;
					entitytransaction.rollback();
					
				}
			}
			else{
				//Ya hay uno con el mismo dni dado de alta
				id=-2;
				entitytransaction.rollback();
			}
		}
		else{
			id=-1;//departamento no existe o no esta activo
			entitytransaction.rollback();
		}
		}catch(PersistenceException ex){
			id=-100;
		}
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAEmpleado#bajaEmpleado()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int bajaEmpleado(int idEmpleado) {
		int id = -100;
		
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();
			Empleado emp = entitymanager.find(Empleado.class, idEmpleado);
			if (emp != null) { // Empleado existe
				if (emp.getActivo()) { // el Empleado está activo
					TypedQuery<Participa> query = entitymanager
							.createNamedQuery("Negocio.Evento.imp.Participa.findByempleado", Participa.class)
							.setParameter("empleado", emp);
					List<Participa> res = query.getResultList();
					if(res.size()==0){
					emp.setActivo(false);
					Departamento dep = entitymanager.find(Departamento.class, emp.getDepartamento().getIdDepartamento());
					dep.setNumeroPersonas(dep.getNumeroPersonas()-1);
					
					entitytransaction.commit();
					id = idEmpleado;
					}
					else{//el empleado tiene eventos activos
						id=-3;
						entitytransaction.rollback();
					}
				}
				else { //Empleado ya está desactivado
					id = -2;
					entitytransaction.rollback();
				}
			}
			else{//Empleado no existe
				id = -1;
				entitytransaction.rollback();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
			id = -100;
		}

		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAEmpleado#modificarEmpleado()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int modificarEmpleado(TEmpleado tEmpleado) {
		int id = -100;
		if (tEmpleado != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				Empleado emp = entitymanager.find(Empleado.class, tEmpleado.getId());
				Departamento dep = entitymanager.find(Departamento.class, tEmpleado.getDepartamento().getIdDepartamento());
				if(dep!=null && dep.getActivo()){
					if (emp != null) { // Existe Empleado
						if (emp.getActivo()) { // Empleado activo
							TypedQuery<Empleado> query = entitymanager
									.createNamedQuery("Negocio.Empleado.imp.Empleado.findByDNI", Empleado.class)
									.setParameter("DNI", tEmpleado.getDNI());
							List<Empleado> res = query.getResultList();
							if(res.size()==0 || res.get(0).getId() == emp.getId()){
								emp.setDNI(tEmpleado.getDNI());
								emp.setNombre(tEmpleado.getNombre());
								emp.setSueldoBase(tEmpleado.getSueldoBase());
								emp.setTelefono(tEmpleado.getTelefono());
								emp.getDepartamento().setNumeroPersonas(emp.getDepartamento().getNumeroPersonas()-1);
								dep = entitymanager.find(Departamento.class, tEmpleado.getDepartamento().getIdDepartamento());
								dep.setNumeroPersonas(dep.getNumeroPersonas()+1);
								emp.setDepartamento(dep);
								if(tEmpleado instanceof TEmpleadoTiempoCompleto){
									((EmpleadoTiempoCompleto)emp).setPluses(((TEmpleadoTiempoCompleto)tEmpleado).getPluses());
								}
								else{
									((EmpleadoTiempoParcial)emp).setNumHoras(((TEmpleadoTiempoParcial)tEmpleado).getNumHoras());
								}
								
								entitytransaction.commit();
								id = tEmpleado.getId();
							}
							else{//dni ya esta en uso
								id = -1;
								entitytransaction.rollback();
							}
						}
						else { //El Empleado no está activo
							id = -2;
							entitytransaction.rollback();
						}
					} else {//El empleado no existe
						id = -3;
						entitytransaction.rollback();
					}
				}
				else{
					id= -4;
					entitytransaction.rollback();
				}
				entitymanager.close();
				emfactory.close();
			} catch (PersistenceException ex) {
				id = -100;
			}
		}
		return id;
	}
	/** 
	* (non-Javadoc)
	* @see SAEmpleado#buscarEmpleado()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleado buscarEmpleado(int idEmpleado) {
		TEmpleado tEmp = null;

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
		try {
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			Empleado emp = entitymanager.find(Empleado.class, idEmpleado);

			if (emp == null) // no existe
				entitytransaction.rollback();
			else{
				tEmp = emp.toTransfer();
				entitytransaction.commit();
			}
			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {
			tEmp=null;
		}

		return tEmp;
	}

	/** 
	* (non-Javadoc)
	* @see SAEmpleado#listarEmpleados()
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public List<TEmpleado> listarEmpleados() {
		List<Empleado> lista = null;
		List<TEmpleado> listaempleados=new ArrayList<TEmpleado>();
		try {
			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
			EntityManager entitymanager = emfactory.createEntityManager();
			EntityTransaction entitytransaction = entitymanager.getTransaction();
			entitytransaction.begin();

			TypedQuery<Empleado> query = entitymanager.createNamedQuery("Negocio.Empleado.imp.Empleado.findByactivo", Empleado.class).setParameter("activo",true);
			lista = query.getResultList();
			for(int i = 0; i < lista.size(); ++i) {
				listaempleados.add(lista.get(i).toTransfer());
			}
			entitytransaction.commit();

			entitymanager.close();
			emfactory.close();
		} catch (PersistenceException ex) {}

		return listaempleados;
	}
	
	public TEmpleado buscarEmpleadoActivoPorDNI(String dni){
		boolean encontrado=false;
		TEmpleado tEmpleado = null;
		if (dni != null) {
			try {
				EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mandms");
				EntityManager entitymanager = emfactory.createEntityManager();
				EntityTransaction entitytransaction = entitymanager.getTransaction();
				entitytransaction.begin();
				TypedQuery<Empleado> query = entitymanager
						.createNamedQuery("Negocio.Empleado.imp.Empleado.findByDNI", Empleado.class)
						.setParameter("DNI", dni);
				List<Empleado> res = query.getResultList();
				if(res.size()>0){
					int i=0;
					while(!encontrado && i<res.size()){
						if(res.get(i).getActivo()){
							encontrado=true;
							tEmpleado=res.get(0).toTransfer();
						}
						++i;//**
					}
				}
				else{//no hay empleado con ese dni
					tEmpleado=null;
				}
			}catch (PersistenceException ex) {
				tEmpleado= null;
			}
		}
		return tEmpleado;
			
	}

}