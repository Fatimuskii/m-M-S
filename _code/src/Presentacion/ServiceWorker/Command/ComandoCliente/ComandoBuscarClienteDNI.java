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
public class ComandoBuscarClienteDNI implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
		TCliente tCliente = FactoriaSA.getInstance().crearSACliente().buscarClienteDNI((String)dato);
		
		if(tCliente != null){
			return new Contexto(Events.BUSCAR_CLIENTE_DNI_OK, tCliente);
		}
		else{
			return new Contexto(Events.BUSCAR_CLIENTE_DNI_KO, tCliente);
		}
	}
}
