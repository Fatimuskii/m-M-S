package Integracion.Conexion.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Integracion.Conexion.ConexionDAO;
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
public class ConexionDAOImp extends ConexionDAO {
	private Connection conexion;

	public Connection getConexion() {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mandms", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conexion;
	}

	public void close() {

		try {
			if (conexion != null && !conexion.isClosed()) {
				conexion.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}
}
