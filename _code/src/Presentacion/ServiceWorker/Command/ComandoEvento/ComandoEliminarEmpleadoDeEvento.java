/**
 * 
 */
package Presentacion.ServiceWorker.Command.ComandoEvento;

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
* @author Paula Sánchez de la Nieta Gómez* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class ComandoEliminarEmpleadoDeEvento implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Contexto ejecutar(Object dato) {
		TParticipa tParticipa = (TParticipa) dato;
		int res = FactoriaSA.getInstance().crearSAEvento().eliminarEmpleadoDeEvento(tParticipa);

		if(res > 0){
			return new Contexto(Events.ELIMINAR_EMPLEADO_EVENTO_OK, res);
		}
		else{
			return new Contexto(Events.ELIMINAR_EMPLEADO_EVENTO_KO, res);
		}
	}
}