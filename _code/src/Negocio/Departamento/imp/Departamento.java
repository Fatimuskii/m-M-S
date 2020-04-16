
package Negocio.Departamento.imp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import Negocio.Empleado.imp.Empleado;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import java.util.List;

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
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Departamento.imp.Departamento.findByidDepartamento", query = "select obj from Departamento obj where :idDepartamento = obj.idDepartamento "),		
		@NamedQuery(name = "Negocio.Departamento.imp.Departamento.findBynombre", query = "select obj from Departamento obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Negocio.Departamento.imp.Departamento.findBynumPersonas", query = "select obj from Departamento obj where :numPersonas = obj.numPersonas "),
		@NamedQuery(name = "Negocio.Departamento.imp.Departamento.findByactivo", query = "select obj from Departamento obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Departamento.imp.Departamento.findAll", query= "select obj from Departamento obj where obj.activo = 1"),})
public class Departamento implements Serializable {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private static final long serialVersionUID = 0;

	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDepartamento;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	
	@Version
	private int version;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private String nombre;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private int numPersonas;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private boolean activo;
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	public Departamento() {
	}


	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param Dpto
	 */
	public Departamento(TDepartamento Dpto) {
		this.idDepartamento=Dpto.getIdDepartamento();
		this.nombre= Dpto.getNombre();
		this.numPersonas= Dpto.getNumPersonas();		
		this.activo= Dpto.getActivo();
	}
	
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 */
	@OneToMany(mappedBy = "departamento")
	private List<Empleado> empleados;
	

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int getIdDepartamento() {
		// begin-user-code
		return this.idDepartamento;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param idDepartamento
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setIdDepartamento(int idDepartamento) {
		// begin-user-code
		this.idDepartamento= idDepartamento;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public String getNombre() {
		// begin-user-code
		return this.nombre;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param nombre
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setNombre(String nombre) {
		// begin-user-code
		this.nombre= nombre;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public int getNumeroPersonas() {
		// begin-user-code
		return this.numPersonas;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param numPersonas
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setNumeroPersonas(int numPersonas) {
		// begin-user-code
		this.numPersonas= numPersonas;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public boolean getActivo() {
		// begin-user-code
		return this.activo;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param activo
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public void setActivo(boolean activo) {
		// begin-user-code
		this.activo= activo;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	public List<Empleado> getEmpleados() {
		// begin-user-code
		return this.empleados;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @param listaEmpleados
	 */
	public void setEmpleados(List <Empleado>listaEmpleados) {
		// begin-user-code
		this.empleados= listaEmpleados;
		// end-user-code
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @return
	 */
	public TDepartamento toTransfer() {
		// begin-user-code		
		TDepartamento dept= new TDepartamento(this.idDepartamento, this.nombre, this.numPersonas, this.activo);
		return dept;
		// end-user-code
	}
}