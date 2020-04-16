/**
 * 
 */
package Presentacion.ServiceWorker.Command.ComandoProducto;

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
public class ComandoModificarProducto implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		TProducto tProducto = (TProducto) dato;
		
		int id = FactoriaSA.getInstance().crearSAProducto().modificarProducto(tProducto);
		if(id > 0)
			return new Contexto(Events.MODIFICAR_PRODUCTO_OK, id);
		else
			return new Contexto(Events.MODIFICAR_PRODUCTO_KO, id);
	}
}