package Presentacion.ServiceWorker.Command.ComandoVenta;

import Negocio.Factoria.FactoriaSA;
import Negocio.Venta.imp.TMostrarFactura;
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
public class ComandoMostrarFactura  implements Command{

	@Override
	public Contexto ejecutar(Object dato) {
		TMostrarFactura factura = FactoriaSA.getInstance().crearSAVenta().mostrarFacturaTotal((int)dato);
		
		if (factura !=null)
			return new Contexto(Events.MOSTRAR_FACTURA_OK,factura);
		else
			return new Contexto(Events.MOSTRAR_FACTURA_KO,null);
	}

}
