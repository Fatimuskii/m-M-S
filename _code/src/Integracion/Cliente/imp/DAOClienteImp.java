/**
 * 
 */
package Integracion.Cliente.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.Cliente.DAOCliente;
import Integracion.Conexion.ConexionDAO;
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
public class DAOClienteImp implements DAOCliente {
	/** 
	* (non-Javadoc)
	* @see DAOCliente#altaCliente(TCLiente tCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaCliente(TCliente tCliente) {
		int id = -100;
		boolean bilbao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance(); 
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;
		
		if(transaction!=null){
			connection = (Connection) transaction.getResource();
		}
		else { //"DAO de Bilbao"
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
			if(connection != null){
				try {
					
					Statement statement = connection.createStatement();
					statement.executeUpdate("INSERT INTO cliente (nombre, DNI, email, telefono, activo)" + "VALUES" + "('" 
					+ tCliente.getNombre() + "', '" 
					+ tCliente.getDNI() + "', '" 
					+ tCliente.getEmail() + "', '" 
					+ tCliente.getTelefono() + "', "
					+ 1 + ");");

					String query = "SELECT last_insert_id() as last_id from cliente";
					ResultSet resultSet = statement.executeQuery(query);
					if (resultSet.next())
						id=resultSet.getInt("last_id");
					
					statement.close();
					if (bilbao)
						connection.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					id = -100;
				}
			}
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see DAOCliente#bajaCliente(Integer idCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int bajaCliente(int idCliente) {
		boolean bilbao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance(); 
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;
		
		if(transaction!=null){
			connection = (Connection) transaction.getResource();
		}
		else { // "DAO de Bilbao"
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
			if(connection != null){
				try {
					Statement statement = connection.createStatement();
					statement.executeUpdate("UPDATE cliente SET activo= 0  WHERE idCliente=" + idCliente);
					
					statement.close();
					if (bilbao)
						connection.close(); 
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					idCliente = -1;
					}
			}
		
		return idCliente;
	}

	/** 
	* (non-Javadoc)
	* @see DAOCliente#modificarCliente(TCLiente tCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int modificarCliente(TCliente tCliente) {
		int id = -1;
		boolean bilbao = false;
		
		TransactionManager transactionManager = TransactionManager.getInstance(); 
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;
		
		if(transaction!=null){
			connection = (Connection) transaction.getResource();
		}
		else { //"DAO de Bilbao"
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
			if(connection != null){
				try {
					Statement statement = connection.createStatement();
					statement.executeUpdate("UPDATE cliente SET "
					+ "nombre='" + tCliente.getNombre() + "', "  
					+ "DNI='" + tCliente.getDNI() + "', " 
					+ "telefono='" + tCliente.getTelefono() + "', " 
					+ "email='" + tCliente.getEmail() + "', " 
					+ "activo=" + (tCliente.getActivo() ? 1: 0) + " " 
					+ "WHERE idCliente= " + tCliente.getIdCliente());
					
					id = tCliente.getIdCliente();
					
					statement.close();
					if (bilbao)
						connection.close();
					
				} catch (SQLException e) {
					System.out.println(e.getMessage());
					id = -1;
					}
				}
			
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see DAOCliente#buscarCliente(Integer idCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TCliente buscarCliente(int idCliente) {
		TCliente tCliente = null;
		boolean bilbao = false;
		String concurrencia = " FOR UPDATE";
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		} else { // "DAO de Bilbao"
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();				
				String query = "SELECT * FROM cliente WHERE idCliente=" + idCliente;
				
				if(!bilbao)
					query += concurrencia;
				
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					tCliente = new TCliente(
							resultSet.getInt("idCliente"),	
							resultSet.getString("nombre"),
							resultSet.getString("telefono"),
							resultSet.getString("email"),
							resultSet.getString("DNI"),
							resultSet.getBoolean("activo")
							);
				}

				statement.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				tCliente = null;
			}
		}

		return tCliente;
	}
	
	public TCliente buscarClienteDNI(String dni){
		TCliente tCliente = null;
		boolean bilbao = false;
		String concurrencia = " FOR UPDATE";
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		} else { // "DAO de Bilbao"
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM cliente WHERE DNI = '" + dni + "'" ;
				
				if(!bilbao)
					query += concurrencia;
				
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					tCliente = new TCliente(
							resultSet.getInt("idCliente"),
							resultSet.getString("nombre"),
							resultSet.getString("telefono"),
							resultSet.getString("email"),
							dni,
							resultSet.getBoolean("activo")
							);
				}

				statement.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				tCliente = null;
			}
		}

		return tCliente;
	}

	/** 
	* (non-Javadoc)
	* @see DAOCliente#listarCliente()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public  ArrayList<TCliente> listarCliente() {
		 ArrayList<TCliente> listarClientes = new  ArrayList<>();
		 TCliente tCliente = null;
		 boolean bilbao = false;
		 String concurrencia = " FOR UPDATE";
		 
		 TransactionManager transactionManager = TransactionManager.getInstance(); 
			Transaction transaction = transactionManager.getTransaction();
			Connection connection = null;
			
			if(transaction!=null){
				connection = (Connection) transaction.getResource();
			}
			else { // "DAO de Bilbao"
				bilbao = true;
				ConexionDAO c = ConexionDAO.getInstance();
				connection = c.getConexion();
			}
				if(connection != null){
					try {
						Statement statement = connection.createStatement();
						
						String query = "SELECT * FROM cliente WHERE activo=1";
						ResultSet resultSet = statement.executeQuery(query);
						
						if (!bilbao)
							query += concurrencia;
						
						while(resultSet.next()){
							tCliente = new TCliente(
									resultSet.getInt("idCliente"),
									resultSet.getString("nombre"),
									resultSet.getString("telefono"),
									resultSet.getString("email"),
									resultSet.getString("DNI"),
									resultSet.getBoolean("activo")
									);
							listarClientes.add(tCliente);
						}
						
						statement.close();
						if (bilbao)
							connection.close(); 
						
					} catch (SQLException e) {
						System.out.println(e.getMessage());
						tCliente = null;
						}
				}
				
		return listarClientes;
	}

}