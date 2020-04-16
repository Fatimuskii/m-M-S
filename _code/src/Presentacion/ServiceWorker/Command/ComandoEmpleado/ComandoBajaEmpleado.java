package Presentacion.ServiceWorker.Command.ComandoEmpleado;

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
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/


public class ComandoBajaEmpleado implements Command{
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Contexto ejecutar(Object dato) {

		int id = FactoriaSA.getInstance().crearSAEmpleado().bajaEmpleado((int)dato);
		
		if(id > 0){
			return new Contexto(Events.BAJA_EMPLEADO_OK, id);
		}
		else{
			return new Contexto(Events.BAJA_EMPLEADO_KO, id);
		}
	}
}
