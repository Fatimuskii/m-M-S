/**
 * 
 */
package Presentacion.ServiceWorker.Command.ComandoProducto;

import java.util.ArrayList;

import Integracion.Query.TQuery;
import Negocio.Factoria.FactoriaSA;
import Negocio.Producto.imp.TProducto;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

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
public class ComandoProductoMasCompradoPorUnCliente implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		ArrayList<TProducto> productos = FactoriaSA.getInstance().
				crearSAProducto().buscarProductoMasCompradoPorUnCliente((TQuery)dato);
		
		if(productos != null){
			return new Contexto(Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_OK, productos);
		}
		else{
			return new Contexto(Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_KO, productos);
		}
	}
}