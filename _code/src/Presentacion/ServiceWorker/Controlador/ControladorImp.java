/**
 * 
 */
package Presentacion.ServiceWorker.Controlador;

import Presentacion.Contexto;
import Presentacion.ServiceWorker.Command.Command;
import Presentacion.ServiceWorker.Command.FactoriaComando.FactoriaComando;
import Presentacion.ServiceWorker.Dispatcher.Dispatcher;

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
public class ControladorImp extends Controlador {

	@Override
	public void accion(Contexto contexto) {
		//Genera comando
		FactoriaComando factoriaComando = FactoriaComando.getInstance();
		Command command = factoriaComando.generarCommand(contexto.getEvento());
		
		Contexto cont = null;
		
		if(command != null) {
			
			cont = command.ejecutar(contexto.getDato());
		
			Dispatcher.getInstance().generarVista(cont);
		
		} else {
			
			Dispatcher.getInstance().generarVista(contexto);
	
		}

	}
}