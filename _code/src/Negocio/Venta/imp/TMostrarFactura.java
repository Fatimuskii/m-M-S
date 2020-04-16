/**
 * 
 */
package Negocio.Venta.imp;

import java.util.ArrayList;
import java.util.HashMap;

import Negocio.Cliente.imp.TCliente;
import Negocio.Producto.imp.TProducto;

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
public class TMostrarFactura {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private TCliente tCLiente;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private ArrayList <TProducto> tProductos;
	
	private HashMap<Integer, LineaVenta> lineaVentas;
	
	private TVenta tVenta;
	
	public TMostrarFactura(TCliente tCliente, ArrayList <TProducto> tProducto, TVenta tVenta){
		this.tCLiente= tCliente;
		this.tProductos= tProducto;
		this.tVenta= tVenta;
		this.lineaVentas=tVenta.getLineaVentas();
		
	}

	public TCliente gettCLiente() {
		return tCLiente;
	}

	public void settCLiente(TCliente tCLiente) {
		this.tCLiente = tCLiente;
	}

	public ArrayList<TProducto> gettProductos() {
		return tProductos;
	}

	public void settProductos(ArrayList<TProducto> tProductos) {
		this.tProductos = tProductos;
	}

	public HashMap<Integer, LineaVenta> getLineaVentas() {
		return lineaVentas;
	}

	public void setLineaVentas(HashMap<Integer, LineaVenta> lineaVentas) {
		this.lineaVentas = lineaVentas;
	}

	public TVenta gettVenta() {
		return tVenta;
	}

	public void settVenta(TVenta tVenta) {
		this.tVenta = tVenta;
	}
	
	
	

}