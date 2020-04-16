/**
 * 
 */
package Presentacion.Evento;

import javax.swing.JFrame;

import Presentacion.Contexto;
import Presentacion.View.GUI;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author Ana Álava Papí
 * @author Óscar Canive Huguet
 * @author David Domínguez Gutiérrez
 * @author Fátima García Delgado
 * @author Marina Lozano Lahuerta
 * @author Paula Sánchez de la Nieta Gómez
 * @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */
public abstract class GUIEvento extends JFrame implements GUI{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1130883703620818596L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private static GUIEvento instance;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @return
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public static GUIEvento getInstance() {
		if(instance == null){
			instance = new GUIEventoImp();
		}
		return instance;
	}

	@Override
	public abstract void actualizar(Contexto contexto);
}