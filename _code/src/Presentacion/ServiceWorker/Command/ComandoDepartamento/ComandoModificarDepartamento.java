package Presentacion.ServiceWorker.Command.ComandoDepartamento;

import Negocio.Departamento.imp.TDepartamento;
import Negocio.Factoria.FactoriaSA;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;

public class ComandoModificarDepartamento implements Command {

	@Override
	public Contexto ejecutar(Object dato) {

		TDepartamento tDepartamento = (TDepartamento) dato;

		int IdDpto = FactoriaSA.getInstance().crearSADepartamento().modificarDepartamento(tDepartamento);

		if (IdDpto > 0) {
			return new Contexto(Events.MODIFICAR_DEPARTAMENTO_OK, IdDpto);
		}

		else {
			String mensaje="";
			if (IdDpto==-1){
				mensaje= "Persistence error: PersistenceException";
			}
			else if (IdDpto==-2){
				mensaje= "Error entitTransaction";
			}
			else if (IdDpto==-3){
				mensaje= "El departamento indicado no existe";
			}
			else if (IdDpto==-4){
				mensaje= "Departamento está dado de baja";
			}
			else if (IdDpto==-5){
				mensaje= "El departamento tiene empleados";
			}
			else{ 
				mensaje= "Error al dar de baja el departamento";
			}
			return new Contexto(Events.MODIFICAR_DEPARTAMENTO_KO, mensaje);
		}
	}

}
