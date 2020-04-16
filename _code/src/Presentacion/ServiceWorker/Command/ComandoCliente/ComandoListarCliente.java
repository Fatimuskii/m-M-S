/**
 * 
 */
package Presentacion.ServiceWorker.Command.ComandoCliente;

import java.util.ArrayList;

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
public class ComandoListarCliente implements Command {
	@Override
	public Contexto ejecutar(Object dato) {
	ArrayList<TCliente> clientes = FactoriaSA.getInstance().crearSACliente().listarCliente();
		
		if(clientes != null){
			return new Contexto(Events.LISTAR_CLIENTE_OK, clientes);
		}
		else{
			return new Contexto(Events.LISTAR_CLIENTE_KO, clientes);
		}

	}
}