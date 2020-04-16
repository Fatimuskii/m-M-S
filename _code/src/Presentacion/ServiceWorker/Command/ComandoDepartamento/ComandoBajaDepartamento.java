package Presentacion.ServiceWorker.Command.ComandoDepartamento;

import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoBajaDepartamento implements Command {

	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	@Override
	public Contexto ejecutar(Object dato) {
		// TODO Auto-generated method stub
		
		int idDepartamento = (int) dato;
		
		int IdDpto = FactoriaSA.getInstance().crearSADepartamento().bajaDepartamento(idDepartamento);
		
		if(IdDpto > 0){
			return new Contexto(Events.BAJA_DEPARTAMENTO_OK, IdDpto);
		}
		
		else{
			//Controlar mensajes de Error**
			String mensaje="";
			if (IdDpto==-2){
				mensaje= "Persistence error: PersistenceException";
			}
			else if (IdDpto==-3){
				mensaje= "El departamento indicado no existe";
			}
			else if (IdDpto==-4){
				mensaje= "Departamento ya dado de baja";
			}
			else if (IdDpto==-5){
				mensaje= "El departamento tiene empleados";
			}
			else{ 
				mensaje= "Error al dar de baja el departamento";
			}
			return new Contexto(Events.BAJA_DEPARTAMENTO_KO, mensaje );
		}
		
	}

}
