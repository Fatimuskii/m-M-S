package Presentacion.ServiceWorker.Command.ComandoVenta;

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
public class ComandoCerrarVenta implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		TVenta ventaActual = (TVenta) dato;

		int idVentaNueva = FactoriaSA.getInstance().crearSAVenta().cerrarVenta(ventaActual);

		if (idVentaNueva > 0 || idVentaNueva == -4) {
			return new Contexto(Events.CERRAR_VENTA_OK, idVentaNueva);

		} else {
			String error = "";

			if (idVentaNueva == -8)
				error = "Problema en la actualizacion en la bbdd de producto";
			else if (idVentaNueva == -7)
				error = "No hay suficiente stock para algún producto";
			else if (idVentaNueva == -6)
				error = "Producto no existe en la bbdd";
			/*
			 * else if (idVentaNueva == -4) error =
			 * "Error en linea de Venta (null) o vacia";
			 */
			else if (idVentaNueva == -3)
				error = "Error en la creación de la transaccion. ";
			else if (idVentaNueva == -2)
				error = "Esta venta ya está cerrada. ";
			else if (idVentaNueva == -100)
				error = "Error en la venta Actual";
			else
				error = "Error al cerrar la venta";
			
			return new Contexto(Events.CERRAR_VENTA_KO, error);
		}
	}

}
