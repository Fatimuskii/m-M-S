/**
 * 
 */
package Integracion.Query.imp;

import Integracion.Query.FactoriaQuery;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Ana �lava Pap�
* @author �scar Canive Huguet
* @author David Dom�nguez Guti�rrez
* @author F�tima Garc�a Delgado
* @author Marina Lozano Lahuerta
* @author Paula S�nchez de la Nieta G�mez
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