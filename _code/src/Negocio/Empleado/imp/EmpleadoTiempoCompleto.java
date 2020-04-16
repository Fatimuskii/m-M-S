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
		@NamedQuery(name = "Negocio.Empleado.imp.EmpleadoTiempoCompleto.findByid", query = "select obj from EmpleadoTiempoCompleto obj where :id = obj.id "),
		@NamedQuery(name = "Negocio.Empleado.imp.EmpleadoTiempoCompleto.findBypluses", query = "select obj from EmpleadoTiempoCompleto obj where :pluses = obj.pluses ") })
public class EmpleadoTiempoCompleto extends Empleado implements Serializable {
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
	private Float pluses;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public EmpleadoTiempoCompleto() {
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public EmpleadoTiempoCompleto(TEmpleadoTiempoCompleto tEmpleadoTiempoCompleto) {
		super(tEmpleadoTiempoCompleto);
		this.pluses = tEmpleadoTiempoCompleto.getPluses();
	}
	

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public Float getPluses() {
		return this.pluses;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param pluses
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void setPluses(Float pluses) {
		this.pluses = pluses;
	}

	
	public TEmpleadoTiempoCompleto toTransfer() {
		return new TEmpleadoTiempoCompleto(this.getId(), this.getDNI(), this.getNombre(), this.getTelefono(), this.getSueldoBase(), this.getActivo(),this.getDepartamento(), this.pluses);
	}

	@Override
	public Float calcularNominas() {
		return this.getSueldoBase() + this.pluses;
	}
	
	
}