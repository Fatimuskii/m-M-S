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
public class ComandoModificarVenta implements Command{

	
	@Override
	public Contexto ejecutar(Object dato) {
		int [] datos= (int[]) dato;
		TVenta tVenta = FactoriaSA.getInstance().crearSAVenta().modificarVenta(datos[0], datos[1]);
		
		if (tVenta !=null)
			return new Contexto(Events.MODIFICAR_VENTA_OK,tVenta);
		else
			return new Contexto(Events.MODIFICAR_VENTA_KO,null);
	}

}


