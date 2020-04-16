package Presentacion.ServiceWorker.Command.ComandoProducto;

import java.util.ArrayList;

import Negocio.Factoria.FactoriaSA;
import Negocio.Producto.imp.TProducto;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;
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
public class ComandoBuscarProductosPorPrecio implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		ArrayList<TProducto> productos = FactoriaSA.getInstance().crearSAProducto().buscarProductosporPrecio((float)dato);
		
		if(productos != null){
			return new Contexto(Events.BUSCAR_PRODUCTOS_POR_PRECIO_OK, productos);
		}
		else{
			return new Contexto(Events.BUSCAR_PRODUCTOS_POR_PRECIO_KO, productos);
		}
	}

}
