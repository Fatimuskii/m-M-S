/**
 * 
 */
package Presentacion.Venta;

import javax.swing.JFrame;

import Negocio.Venta.imp.TVenta;
import Presentacion.Contexto;
import Presentacion.View.GUI;

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
public abstract class GUIVenta extends JFrame implements GUI {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	private static GUIVenta instance;

	public static GUIVenta getInstance() {
		// begin-user-code

		if (instance == null) {

			instance = new GUIVentaImp();

		}
		return instance;
		// end-user-code
	}

	public abstract TVenta getVentaActual();

	public abstract void setVenta(TVenta tventa);

	public abstract void actualizar(Contexto contexto);
}