/**
 * 
 */
package Negocio.Departamento.imp;

import Negocio.Departamento.SADepartamento;
import Negocio.Empleado.imp.Empleado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
public class SADepartamentoImp implements SADepartamento {
	/**
	 * (non-Javadoc)
	 * 
	 * @see SADepartamento#altaDepartamento(TDepartamento departamento)
	 * @!generated "UML a JPA
	 *             (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	public int altaDepartamento(TDepartamento tDpto) {
		// begin-user-code
		int idDepartamento = -1;
		if (tDpto != null) {
			try {
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("mandms");
				EntityManager em = emf.createEntityManager();
				EntityTransaction entitytransaction = em.getTransaction();
				entitytransaction.begin();
				TypedQuery<Departamento> query = em
						.createNamedQuery("Negocio.Departamento.imp.Departamento.findBynombre", Departamento.class)
						.setParameter("nombre", tDpto.getNombre());
				List<Departamento> res = query.getResultList();

				// Si el departamento no existe-> se crea nuevo
				if (res.isEmpty()) {
					Departamento nuevoDpto = new Departamento(tDpto);
					nuevoDpto.setActivo(true);
					em.persist(nuevoDpto);
					entitytransaction.commit();
					idDepartamento = nuevoDpto.getIdDepartamento();

				} else { // ya existe el departamento
					Departamento result = res.get(0); // cogemos el departamento
														// que devuelve la
														// consulta
					if (result.getActivo()) { // Si el depto está ya activo
						idDepartamento = -3;
						entitytransaction.rollback();
					} else {
						result.setActivo(true);
						result.setNombre(tDpto.getNombre());
						result.setNumeroPersonas(tDpto.getNumPersonas());
						entitytransaction.commit();
						idDepartamento = result.getIdDepartamento();
					}
				}
				em.close();
				emf.close();
			} catch (PersistenceException ex) {
				idDepartamento = -2;
			}
		}

		return idDepartamento;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SADepartamento#bajaDepartamento(Object idDepartamento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int bajaDepartamento(int idDepartamento) {
		// begin-user-code
		int idDpto = -1;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mandms");
			EntityManager em = emf.createEntityManager();
			EntityTransaction entitytransaction = em.getTransaction();
			entitytransaction.begin();

			Departamento resultado = em.find(Departamento.class, idDepartamento);

			if (resultado != null) {
				if (resultado.getActivo()) {
					if (resultado.getNumeroPersonas() == 0) { // no tiene
																// empleados
						resultado.setActivo(false);
						entitytransaction.commit();
						idDpto = resultado.getIdDepartamento();
					} else {
						idDpto = -5; // Error tiene empleados
						entitytransaction.rollback();
					}
				} else {
					idDpto = -4;
					entitytransaction.rollback(); // departamento ya esta
													// dado de baja
				}
			} else {
				idDpto = -3; // Departamento dado no existe
				entitytransaction.rollback();
			}
			em.close();
			emf.close();
		} catch (PersistenceException e) {
			idDpto = -2; // error de Persistence
		}
		return idDpto;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SADepartamento#buscarDepartamento(int idDepartamento)
	 */
	public TDepartamento buscarDepartamento(int idDepartamento) {
		// begin-user-code
		Departamento dpto = null;
		TDepartamento tDpto = null;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mandms");
			EntityManager em = emf.createEntityManager();
			EntityTransaction entitytransaction = em.getTransaction();
			entitytransaction.begin();
			dpto = em.find(Departamento.class, idDepartamento);

			if (dpto != null) {
				tDpto = dpto.toTransfer();
				entitytransaction.commit();
			} else {
				tDpto = null;
				entitytransaction.rollback();
			}

			em.close();
			emf.close();
		} catch (PersistenceException e) {
			tDpto = null;
		}

		return tDpto;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SADepartamento#modificarDepartamento(Departamento departamento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int modificarDepartamento(TDepartamento tDepartamento) {
		// begin-user-code

		int idDepartamento = -1;

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mandms");
			EntityManager em = emf.createEntityManager();
			EntityTransaction entityTransaction = em.getTransaction();

			if (entityTransaction != null) {
				entityTransaction.begin();

				Departamento dept = em.find(Departamento.class, tDepartamento.getIdDepartamento());

				if (dept != null) {
					if (dept.getActivo()) {
						TypedQuery<Departamento> res = em
								.createNamedQuery("Negocio.Departamento.imp.Departamento.findBynombre",
										Departamento.class)
								.setParameter("nombre", tDepartamento.getNombre());

						if (res.getResultList().isEmpty() || res.getResultList().get(0)
								.getIdDepartamento() == tDepartamento.getIdDepartamento()) {

							dept.setNombre(tDepartamento.getNombre());

							entityTransaction.commit();
							idDepartamento = tDepartamento.getIdDepartamento();

						} else {
							idDepartamento = -5;
							entityTransaction.rollback();
						}
					} else {
						idDepartamento = -4;
						entityTransaction.rollback();
					}

				} else {
					idDepartamento = -3;
					entityTransaction.rollback();
				}
			} 

			em.close();
			emf.close();
		} catch (PersistenceException e) {
			idDepartamento = -1; // errot de Persistence
		}
		return idDepartamento;

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SADepartamento#listarDepartamentos()
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<TDepartamento> listarDepartamentos() {

		List<TDepartamento> listaDepartamentos = new ArrayList<TDepartamento>();

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mandms");
			EntityManager em = emf.createEntityManager();
			EntityTransaction entityTransaction = em.getTransaction();

			if (entityTransaction != null) {
				entityTransaction.begin();

				TypedQuery<Departamento> query = em.createNamedQuery("Negocio.Departamento.imp.Departamento.findAll",
						Departamento.class);
				List<Departamento> lista = query.getResultList();

				// No hay departamentos
				if (lista.isEmpty()) {
					listaDepartamentos = null;
					entityTransaction.rollback();
				}
				// la lista no está vacía
				else {
					for (Departamento dpto : lista) {
						TDepartamento tDpto = dpto.toTransfer();
						listaDepartamentos.add(tDpto);
					}

					entityTransaction.commit();
				}
			}

			em.close();
			emf.close();
		} catch (PersistenceException e) {
			listaDepartamentos = null;
		}

		return listaDepartamentos;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SADepartamento#calcularNominas(int idDepartamento)
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public float calcularNominas(int idDepartamento) {
		// begin-user-code
		float suma = 0;
		
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mandms");
			EntityManager em = emf.createEntityManager();
			EntityTransaction entityTransaction = em.getTransaction();
			
			if(entityTransaction!=null){
				entityTransaction.begin();
				Departamento dept = em.find(Departamento.class, idDepartamento, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if (dept != null){//El departamento existe
					if(dept.getActivo()) { //El departamento está activo

						TypedQuery<Empleado> query = em
								.createNamedQuery("Negocio.Empleado.imp.Empleado.findBydepartamento", Empleado.class);
						query.setParameter("departamento", dept);
						List<Empleado> empleados = query.getResultList();
						for (Empleado e : empleados) {
							suma += e.calcularNominas();
						}
						entityTransaction.commit();
					}
					else{ //El departamento no está activo
						suma = -4;
						entityTransaction.rollback();
					}
				} else{ //El departamento no existe
					suma = -3;
					entityTransaction.rollback();
				}
			}
			
			em.close();
			emf.close();
			
		} catch (PersistenceException e) {
			suma = -1; // error de Persistence
		}

		return suma;

	}
}
