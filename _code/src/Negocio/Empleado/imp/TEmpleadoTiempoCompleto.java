package Negocio.Empleado.imp;

import Negocio.Departamento.imp.Departamento;

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
public class TEmpleadoTiempoCompleto extends TEmpleado{
	
	private Float pluses;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoTiempoCompleto(String DNI, String nombre, String telefono, Float sueldoBase, Boolean activo,Departamento departamento, Float pluses) {
		super(DNI, nombre, telefono, sueldoBase, activo, departamento);
		this.pluses = pluses;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoTiempoCompleto(int id, String DNI, String nombre, String telefono, Float sueldoBase, Boolean activo,Departamento departamento, Float pluses) {
		super(id, DNI, nombre, telefono, sueldoBase, activo, departamento);
		this.pluses = pluses;
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
	
}
