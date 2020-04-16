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
public class TEmpleadoTiempoParcial extends TEmpleado{

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
	public TEmpleadoTiempoParcial(String DNI, String nombre, String telefono, Float sueldoBase, Boolean activo,Departamento departamento, int numHoras) {
		super(DNI, nombre, telefono, sueldoBase, activo, departamento);
		this.numHoras = numHoras;
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public TEmpleadoTiempoParcial(int id, String DNI, String nombre, String telefono, Float sueldoBase, Boolean activo, Departamento departamento, int numHoras) {
		super(id, DNI, nombre, telefono, sueldoBase, activo,departamento);
		this.numHoras = numHoras;
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
}
