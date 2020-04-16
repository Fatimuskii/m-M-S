/**
 * 
 */
package Integracion.Query.imp;

import Integracion.Query.FactoriaQuery;

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
public class FactoriaQueryImp extends FactoriaQuery {
	/** 
	* (non-Javadoc)
	* @see FactoriaQuery#ProductoMasCompradoPorUnCliente()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ProductoMasCompradoPorUnCliente crearProductoMasCompradoPorUnCliente() {
		return new ProductoMasCompradoPorUnCliente();
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaQuery#ClientesConComprasDesdeFecha()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ClientesConComprasDesdeFecha crearClientesConComprasDesdeFecha() {
		return new ClientesConComprasDesdeFecha();
	}
}