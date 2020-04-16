package Presentacion.ServiceWorker.Command.ComandoVenta;

import Negocio.Factoria.FactoriaSA;
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
public class ComandoDevolucionVenta implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		int[] datos = (int[]) dato;
		int devolucion = FactoriaSA.getInstance().crearSAVenta().devolver(datos[0], datos[1], datos[2]);

		if (devolucion > 0) {
			return new Contexto(Events.DEVOLUCION_OK, devolucion);

		} else
			return new Contexto(Events.DEVOLUCION_KO, devolucion);
	}

}
