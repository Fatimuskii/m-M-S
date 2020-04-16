/**
 * 
 */
package Integracion.Factoria.imp;

import Integracion.Cliente.DAOCliente;
import Integracion.Cliente.imp.DAOClienteImp;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Producto.DAOProducto;
import Integracion.Producto.imp.DAOProductoImp;
import Integracion.Venta.DAOVenta;
import Integracion.Venta.imp.DAOVentaImp;

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
public class FactoriaIntegracionImp extends FactoriaIntegracion {
	/** 
	* (non-Javadoc)
	* @see FactoriaIntegracion#crearDAOCliente()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DAOCliente crearDAOCliente() {
		return new DAOClienteImp();
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaIntegracion#crearDAOProducto()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DAOProducto crearDAOProducto() {
		return new DAOProductoImp();
	}

	/** 
	* (non-Javadoc)
	* @see FactoriaIntegracion#crearDAOVenta()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public DAOVenta crearDAOVenta() {
		return new DAOVentaImp();
	}
}