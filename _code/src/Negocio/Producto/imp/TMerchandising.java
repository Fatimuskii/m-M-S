/**
 * 
 */
package Negocio.Producto.imp;

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
public class TMerchandising extends TProducto {
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private Tipo tipo;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param idProducto
	* @param nombre
	* @param precio
	* @param stock
	* @param activo
	* @param tipo
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TMerchandising(int idProducto, String nombre, float precio, int stock, boolean activo, Tipo tipo) {
		super(idProducto, nombre, precio, stock, activo);
		this.tipo=tipo;
	}
	
	public TMerchandising(String nombre, float precio, int stock, boolean activo, Tipo tipo) {
		super(nombre, precio, stock, activo);
		this.tipo=tipo;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param Parameter1
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Tipo getTipo() {
		return this.tipo;
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @param tipo
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public void setTipo(Tipo tipo) {
		this.tipo=tipo;
	}
}