package Presentacion.ServiceWorker.Command.ComandoDepartamento;

import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoCalcularNominasDepartamento implements Command {

	@Override
	public Contexto ejecutar(Object dato) {
	
		int idDepartamento = (int) dato;
		
		float suma = FactoriaSA.getInstance().crearSADepartamento().calcularNominas(idDepartamento);
		
		if(suma >= 0){
			return new Contexto(Events.CALCULAR_NOMINAS_DEPARTAMENTO_OK, suma);
		}
		else{
			return new Contexto(Events.CALCULAR_NOMINAS_DEPARTAMENTO_KO,suma );
		}
	}

}
