/**
 * 
 */
package Integracion.Transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Integracion.Conexion.ConexionDAO;

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
public class TransactionMySQL implements Transaction {
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private Connection conexion;

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#start()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void start() {
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/mandms", "root", "");
			conexion = ConexionDAO.getInstance().getConexion();
			conexion.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#commit()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void commit() {
		try {
			conexion.commit();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#rollBack()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void rollBack() {
		try {
			conexion.rollback();
			conexion.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see Transaction#getResource()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public Object getResource() {
		return conexion;
	}
}