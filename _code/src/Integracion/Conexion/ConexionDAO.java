package Integracion.Conexion;

import java.sql.Connection;

import Integracion.Conexion.imp.ConexionDAOImp;
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
public abstract class ConexionDAO {
	private static ConexionDAO instance;

	public static ConexionDAO getInstance() {
		if (instance == null) {
			instance = new ConexionDAOImp();
		}
		return instance;
	}

	public abstract Connection getConexion();
}
