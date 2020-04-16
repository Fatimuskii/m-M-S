package Presentacion.ServiceWorker.Command.ComandoDepartamento;

import java.util.List;

import Negocio.Departamento.imp.TDepartamento;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoListarDepartamento implements Command{

	@Override
	public Contexto ejecutar(Object dato) {
		
		List<TDepartamento> listaDepartamentos = FactoriaSA.getInstance().crearSADepartamento().listarDepartamentos();
		
		if(listaDepartamentos!=null){
			return new Contexto(Events.LISTAR_DEPARTAMENTO_OK, listaDepartamentos);
		}
		
		else{
			// CONTROLAR ERRORES***
			return new Contexto(Events.LISTAR_DEPARTAMENTO_KO, "No hay datos");
		}
	}

}
