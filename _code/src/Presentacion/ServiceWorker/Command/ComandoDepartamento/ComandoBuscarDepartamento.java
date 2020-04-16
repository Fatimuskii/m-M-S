package Presentacion.ServiceWorker.Command.ComandoDepartamento;

import Negocio.Departamento.imp.TDepartamento;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoBuscarDepartamento implements Command{
	/** 
	* (non-Javadoc)
	* @see Command#ejecutar(Object dato)
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	@Override
	public Contexto ejecutar(Object dato) {
		// TODO Auto-generated method stub
		
		int idDepartamento = (int) dato;
		
		TDepartamento tDepartamento = FactoriaSA.getInstance().crearSADepartamento().buscarDepartamento(idDepartamento);
		
		if (tDepartamento !=null) 
			return new Contexto(Events.BUSCAR_DEPARTAMENTO_OK, tDepartamento);
		else
			return new Contexto(Events.BUSCAR_DEPARTAMENTO_KO, idDepartamento);
		}
}
