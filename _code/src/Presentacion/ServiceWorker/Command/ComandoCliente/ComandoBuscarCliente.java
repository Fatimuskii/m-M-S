/**
 * 
 */
package Presentacion.ServiceWorker.Command.ComandoCliente;

import Negocio.Cliente.imp.TCliente;
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
public class ComandoBuscarCliente implements Command {
	/** 
	* (non-Javadoc)
	* @see Command#execute()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	
	@Override
	public Contexto ejecutar(Object dato) {
		TCliente tCliente = FactoriaSA.getInstance().crearSACliente().buscarCliente((int)dato);
		
		if(tCliente != null){
			return new Contexto(Events.BUSCAR_CLIENTE_OK, tCliente);
		}
		else{
			return new Contexto(Events.BUSCAR_CLIENTE_KO, tCliente);
		}
	}
}