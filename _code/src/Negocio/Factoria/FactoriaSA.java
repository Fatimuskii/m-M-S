/**
 * 
 */
package Negocio.Factoria;

import Negocio.Cliente.SACliente;
import Negocio.Departamento.SADepartamento;
import Negocio.Empleado.SAEmpleado;
import Negocio.Evento.SAEvento;
import Negocio.Factoria.imp.FactoriaSAImp;
import Negocio.Producto.SAProducto;
import Negocio.Venta.SAVenta;

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
public abstract class FactoriaSA {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private static FactoriaSA instance;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public synchronized static FactoriaSA getInstance() {
		if(instance == null){
			instance = new FactoriaSAImp();
		}
		return instance;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public abstract SAProducto crearSAProducto();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public abstract SACliente crearSACliente();

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public abstract SAVenta crearSAVenta();

	public abstract SADepartamento crearSADepartamento();
	
	public abstract SAEmpleado crearSAEmpleado();
	
	public abstract SAEvento crearSAEvento();
}