package Presentacion.ServiceWorker.Command.ComandoVenta;

import java.util.ArrayList;

import Negocio.Factoria.FactoriaSA;
import Negocio.Venta.imp.TVenta;
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
public class ComandoListarVentas implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		ArrayList<TVenta> ventas = FactoriaSA.getInstance().crearSAVenta().listarVentas();

		if (ventas != null) {
			return new Contexto(Events.LISTAR_VENTAS_OK, ventas);
		} else {
			return new Contexto(Events.LISTAR_VENTAS_KO, null);
		}
	}

}
