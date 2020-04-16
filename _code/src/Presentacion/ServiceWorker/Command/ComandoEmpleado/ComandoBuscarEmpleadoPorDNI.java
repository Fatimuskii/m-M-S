package Presentacion.ServiceWorker.Command.ComandoEmpleado;

import Negocio.Empleado.imp.TEmpleado;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoBuscarEmpleadoPorDNI implements Command{
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Contexto ejecutar(Object dato) {
		TEmpleado empleado = FactoriaSA.getInstance().crearSAEmpleado().buscarEmpleadoActivoPorDNI((String)dato);
		
		if(empleado != null){
			return new Contexto(Events.BUSCAR_EMPLEADO_POR_DNI_OK, empleado);
		}
		else{
			return new Contexto(Events.BUSCAR_EMPLEADO_POR_DNI_KO, empleado);
		}
	}
}
