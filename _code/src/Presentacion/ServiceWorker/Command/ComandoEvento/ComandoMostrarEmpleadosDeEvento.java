package Presentacion.ServiceWorker.Command.ComandoEvento;

import java.util.List;

import Negocio.Evento.imp.TParticipa;
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
public class ComandoMostrarEmpleadosDeEvento implements Command{

	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Contexto ejecutar(Object dato) {
		List<TParticipa> empleadosEvento = FactoriaSA.getInstance().crearSAEvento().mostrarEmpleadosdeEvento((int)dato);
		
		if(empleadosEvento != null){
			return new Contexto(Events.MOSTRAR_EMPLEADOS_EVENTO_OK, empleadosEvento);
		}
		else{
			return new Contexto(Events.MOSTRAR_EMPLEADOS_EVENTO_KO, empleadosEvento);
		}
	}
}
