package Integracion.Conexion;

import java.sql.Connection;

import Integracion.Conexion.imp.ConexionDAOImp;
/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Ana Álava Papí
* @author Óscar Canive Huguet
* @author David Domínguez Gutiérrez
* @author Fátima García Delgado
* @author Marina Lozano Lahuerta
* @author Paula Sánchez de la Nieta Gómez
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
