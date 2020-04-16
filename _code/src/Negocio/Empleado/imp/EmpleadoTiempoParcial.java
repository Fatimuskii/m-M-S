/**
 * 
 */
package Negocio.Empleado.imp;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.NamedQuery;

import javax.persistence.NamedQueries;

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
		@NamedQuery(name = "Negocio.Empleado.imp.EmpleadoTiempoParcial.findByid", query = "select obj from EmpleadoTiempoParcial obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Empleado.imp.EmpleadoTiempoParcial.findBynumHoras", query = "select obj from EmpleadoTiempoParcial obj where :numHoras = obj.numHoras ") })
public class EmpleadoTiempoParcial extends Empleado implements Serializable {
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
	private int numHoras;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public EmpleadoTiempoParcial() {
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public EmpleadoTiempoParcial(TEmpleadoTiempoParcial tEmpleadoTiempoParcial) {
		super(tEmpleadoTiempoParcial);
		this.numHoras = tEmpleadoTiempoParcial.getNumHoras();
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public int getNumHoras() {
		return this.numHoras;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param numHoras
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setNumHoras(int numHoras) {
		this.numHoras = numHoras;
	}

	
	public TEmpleadoTiempoParcial toTransfer() {
		return new TEmpleadoTiempoParcial(this.getId(), this.getDNI(), this.getNombre(), this.getTelefono(), this.getSueldoBase(), this.getActivo(),this.getDepartamento(), this.numHoras);
	}
	@Override
	public Float calcularNominas() {
		return this.getSueldoBase();
	}
	
}