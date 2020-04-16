package Presentacion.ServiceWorker.Command.ComandoVenta;

import Negocio.Factoria.FactoriaSA;
import Negocio.Venta.imp.TVenta;
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
public class ComandoBuscarVenta implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		
		TVenta tVenta = FactoriaSA.getInstance().crearSAVenta().buscarVenta((int)dato);

		if (tVenta!=null){
			return new Contexto(Events.BUSCAR_VENTA_OK, tVenta);
		}
		else{
			return new Contexto(Events.BUSCAR_VENTA_KO, (int)dato);
		}
	}

}
