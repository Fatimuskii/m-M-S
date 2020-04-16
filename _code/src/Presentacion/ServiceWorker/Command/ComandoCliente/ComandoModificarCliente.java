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
* @author Ana Álava Papí
* @author Óscar Canive Huguet
* @author David Domínguez Gutiérrez
* @author Fátima García Delgado
* @author Marina Lozano Lahuerta
* @author Paula Sánchez de la Nieta Gómez
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class ComandoModificarCliente implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		int id = FactoriaSA.getInstance().crearSACliente().modificarCliente((TCliente) dato);
		
		if(id > 0){
			return new Contexto(Events.MODIFICAR_CLIENTE_OK, id);
		}
		else{
			return new Contexto(Events.MODIFICAR_CLIENTE_KO, id);
		}
	}
}