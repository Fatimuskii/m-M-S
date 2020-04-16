package Presentacion.ServiceWorker.Command.ComandoEvento;

import Negocio.Evento.imp.TEvento;
import Negocio.Factoria.FactoriaSA;
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
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class ComandoModificarEventoBuscar implements Command{

	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Contexto ejecutar(Object dato) {
		TEvento tEvento = null;
		tEvento = FactoriaSA.getInstance().crearSAEvento().buscarEvento((int)dato);
		
		if(tEvento != null){
			return new Contexto(Events.BUSCAR_MODIFICAR_EVENTO_OK, tEvento);
		}
		else{
			return new Contexto(Events.BUSCAR_MODIFICAR_EVENTO_KO, tEvento);
		}
	}

}
