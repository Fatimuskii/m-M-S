/**
 * 
 */
package Integracion.Query.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import Integracion.Conexion.ConexionDAO;
import Integracion.Query.Query;
import Integracion.Query.TQuery;
import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionManager.TransactionManager;
import Negocio.Cliente.imp.TCliente;


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
public class ClientesConComprasDesdeFecha implements Query {
	/** 
	* (non-Javadoc)
	* @see Query#execute(Object Parameter1)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object execute(Object parameter) {
		ArrayList<TCliente> listaClientes = new ArrayList<>();
		TCliente tCliente = null;
		
		Date fechaCompra = ((TQuery) parameter).getFecha();
		
		String concurrencia = " FOR UPDATE";
		boolean bilbao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		} else { //"DAO de Bilbao"
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
		if (connection != null) {

			try {
				Statement statement = connection.createStatement();
				String query = "SELECT cliente.* FROM cliente"
							+ " JOIN venta  ON cliente.idCliente = venta.idCliente"
							+ " WHERE venta.fecha >='" + fechaCompra
							+ "' GROUP BY venta.idCliente";
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet = statement.executeQuery(query);
				
				
				while(resultSet.next()) {
					tCliente = new TCliente(
							resultSet.getInt("idCliente"),
							resultSet.getString("nombre"),
							resultSet.getString("telefono"),
							resultSet.getString("email"),
							resultSet.getString("dni"),
							resultSet.getBoolean("activo")
							);
					
					listaClientes.add(tCliente);
					}
				
				if (bilbao)
					connection.close();
				
				} catch (SQLException e) {
					tCliente = null;
				}
			
			}

		return listaClientes;
	}
}