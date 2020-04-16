/**
 * 
 */
package Negocio.Empleado.imp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import java.util.List;
import Negocio.Evento.imp.Participa;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.persistence.NamedQueries;
import Negocio.Departamento.imp.Departamento;
import javax.persistence.ManyToOne;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;

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
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@NamedQueries({
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findByid", query = "select obj from Empleado obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findByparticipa", query = "select obj from Empleado obj where :participa MEMBER OF obj.participa "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findByDNI", query = "select obj from Empleado obj where :DNI = obj.DNI "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findBynombre", query = "select obj from Empleado obj where :nombre = obj.nombre "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findBytelefono", query = "select obj from Empleado obj where :telefono = obj.telefono "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findBysueldoBase", query = "select obj from Empleado obj where :sueldoBase = obj.sueldoBase "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findByactivo", query = "select obj from Empleado obj where :activo = obj.activo "),
		@NamedQuery(name = "Negocio.Empleado.imp.Empleado.findBydepartamento", query = "select obj from Empleado obj where :departamento = obj.departamento and obj.activo = true") })
public abstract class Empleado implements Serializable {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static final long serialVersionUID = 0;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@OneToMany(mappedBy = "empleado")
	private List<Participa> participa;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String DNI;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String nombre;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private String telefono;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Float sueldoBase;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private Boolean activo;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@ManyToOne
	private Departamento departamento;

	@Version
	private int version;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Empleado() {
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param TEmpleado tEmpleado
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Empleado(TEmpleado tEmpleado) {
		this.DNI = tEmpleado.getDNI();
		this.nombre = tEmpleado.getNombre();
		this.telefono = tEmpleado.getTelefono();
		this.sueldoBase = tEmpleado.getSueldoBase();
		this.activo = tEmpleado.getActivo();
		this.departamento= tEmpleado.getDepartamento();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Float getSueldoBase() {
		return this.sueldoBase;
	}

	public void setSueldoBase(Float sueldoBase) {
		this.sueldoBase =sueldoBase;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Departamento getDepartamento(){
		return this.departamento;
	}
	public void setDepartamento(Departamento departamento){
		this.departamento=departamento;
	}
	
	public TEmpleado toTransfer(){
		if(this instanceof EmpleadoTiempoCompleto)
			return new TEmpleadoTiempoCompleto(id, DNI, nombre, telefono, sueldoBase, activo, departamento, ((EmpleadoTiempoCompleto)this).getPluses());
		else
			return new TEmpleadoTiempoParcial(id, DNI, nombre, telefono, sueldoBase, activo, departamento, ((EmpleadoTiempoParcial)this).getNumHoras());
	}
	
	public abstract Float calcularNominas();
}