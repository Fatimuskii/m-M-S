package Presentacion.Departamento;

import javax.swing.JFrame;

import Presentacion.Contexto;
import Presentacion.View.GUI;

public abstract class GUIDepartamento extends JFrame implements GUI {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GUIDepartamento instance;
	
	
	public static GUIDepartamento getInstance(){
		
		if(instance == null)
			instance= new GUIDepartamentoImp();
		
		return instance; 
	}
	
	public abstract void actualizar(Contexto contexto);
}

