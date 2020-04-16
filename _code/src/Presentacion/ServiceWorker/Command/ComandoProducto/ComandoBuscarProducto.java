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
* @author Ana �lava Pap�
* @author �scar Canive Huguet
* @author David Dom�nguez Guti�rrez
* @author F�tima Garc�a Delgado
* @author Marina Lozano Lahuerta
* @author Paula S�nchez de la Nieta G�mez
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ComandoBuscarProducto implements Command {
	
	@Override
	public Contexto ejecutar(Object dato) {
		TProducto tProducto = FactoriaSA.getInstance().crearSAProducto().buscarProducto((int)dato);
		
		if(tProducto != null){
			return new Contexto(Events.BUSCAR_PRODUCTO_OK, tProducto);
		}
		else{
			return new Contexto(Events.BUSCAR_PRODUCTO_KO, tProducto);
		}
	}
}