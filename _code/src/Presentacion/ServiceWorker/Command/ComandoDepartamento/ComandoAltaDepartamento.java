package Presentacion.ServiceWorker.Command.ComandoDepartamento;

import Negocio.Departamento.imp.TDepartamento;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoAltaDepartamento implements Command {

	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@Override
	public Contexto ejecutar(Object dato) {
		TDepartamento dpt = (TDepartamento) dato;

		int IdDepartamento = FactoriaSA.getInstance().crearSADepartamento().altaDepartamento(dpt);
		
		if(IdDepartamento > 0){
			return new Contexto(Events.ALTA_DEPARTAMENTO_OK, IdDepartamento);
		}
		else{
			//Controlar mensajes de Error**
			String mensaje="";
			if (IdDepartamento==-2){
				mensaje= "Error en la base de datos";
			}
			else 
				if (IdDepartamento ==-3){
				mensaje= "Ya existe un departamento con ese nombre";
			}
			else{
				mensaje="Error al dar de alta el departamento";
			}
			return new Contexto(Events.ALTA_DEPARTAMENTO_KO,mensaje );
		}
	}
}
