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
public class TEmpleado {

	private int id;
	private String DNI;
	private String nombre;
	private String telefono;
	private Float sueldoBase;
	private Boolean activo;
	private Departamento departamento;
	
	public TEmpleado(String DNI, String nombre, String telefono, Float sueldoBase, Boolean activo, Departamento departamento){
		this.DNI = DNI;
		this.nombre =nombre;
		this.telefono =telefono;
		this.sueldoBase = sueldoBase;
		this.activo = activo;
		this.departamento = departamento;
	}
	
	public TEmpleado(int id, String DNI, String nombre, String telefono, Float sueldoBase, Boolean activo, Departamento departamento){
		this.id = id;
		this.DNI = DNI;
		this.nombre =nombre;
		this.telefono =telefono;
		this.sueldoBase = sueldoBase;
		this.activo = activo;
		this.departamento=departamento;
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

	public Departamento getDepartamento() {
		// TODO Auto-generated method stub
		return this.departamento;
	}
	public void setDepartamento(Departamento departamento){
		this.departamento=departamento;
	}
}
