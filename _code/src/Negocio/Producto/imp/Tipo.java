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
public enum Tipo {
	FIGURA("FIGURA"), POSTER("POSTER"), CAMISETA("CAMISETA");

	private String parameterName;

	private Tipo(String param) {
		parameterName = param;
	}

	public static Tipo parse(String param) {

		for (Tipo t : Tipo.values()) {
			if (t.parameterName.equals(param)) {
				return t;
			}
		}
		return null;
	}
	
	public String getString(){
		return this.parameterName;
	}
}