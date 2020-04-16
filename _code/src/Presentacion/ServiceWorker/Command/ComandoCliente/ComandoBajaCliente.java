/**
 * 
 */
package Presentacion.ServiceWorker.Command.ComandoCliente;

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
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ComandoBajaCliente implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/

	@Override
	public Contexto ejecutar(Object dato) {
		int id = FactoriaSA.getInstance().crearSACliente().bajaCliente((int)dato);

		if(id > 0)
			return new Contexto(Events.BAJA_CLIENTE_OK, id);
		else
			return new Contexto(Events.BAJA_CLIENTE_KO, id);
	}
}