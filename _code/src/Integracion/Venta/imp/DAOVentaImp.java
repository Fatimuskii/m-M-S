/**
 * 
 */
package Integracion.Venta.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Integracion.Conexion.ConexionDAO;
import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionManager.TransactionManager;
import Integracion.Venta.DAOVenta;
import Negocio.Venta.imp.LineaVenta;
import Negocio.Venta.imp.TVenta;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Ana Álava Papí
 * @author Óscar Canive Huguet
 * @author David Domínguez Gutiérrez
 * @author Fátima García Delgado
 * @author Marina Lozano Lahuerta
 * @author Paula Sánchez de la Nieta Gómez
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DAOVentaImp implements DAOVenta {
	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#altaVenta(TVenta tVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int altaVenta(TVenta tVenta) {
		int idVenta = -100;
		boolean bilbao = false;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();

		} else {
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "INSERT INTO venta (idCliente, fecha, precioTotal, activo)" + " VALUES ("
						+ tVenta.getIdCliente() + ", '" + tVenta.getFecha() + "', " + tVenta.getprecioTotal() + ", " + 0
						+ ");";
				statement.executeUpdate(query);
				query = "SELECT last_insert_id() as last_id from venta";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					idVenta = resultSet.getInt("last_id");
					HashMap<Integer, LineaVenta> lineaVentas = tVenta.getLineaVentas();
					Collection<LineaVenta> values = lineaVentas.values();
					Iterator<LineaVenta> iterator = values.iterator();
					LineaVenta lineaVenta;
					while (iterator.hasNext()) {
						lineaVenta = iterator.next();
						query = "INSERT INTO lineaVenta (idVenta,idProducto,cantidad,precioTotal_prod)" + " VALUES ("
								+ idVenta + ", " + lineaVenta.getIdProducto() + ", " + lineaVenta.getCantidad() + ", "
								+ lineaVenta.getPrecio() + ");";
						statement.executeUpdate(query);
					}
				}

				statement.close();
				if (bilbao) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				idVenta = -100;
			}
		}

		return idVenta;

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#buscarVenta(int idVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta buscarVenta(int idVenta) {
		// begin-user-code
		boolean bilbao = false;
		String concurrencia = " FOR UPDATE";
		TVenta tVenta = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();

		} else {
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "SELECT * FROM venta WHERE idVenta=" + idVenta;
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					HashMap<Integer, LineaVenta> lineaVentas = new HashMap<>();
					tVenta = new TVenta(idVenta, resultSet.getInt("idCliente"), resultSet.getDate("fecha"),
							resultSet.getFloat("precioTotal"), lineaVentas, false);
					query = "SELECT * FROM lineaVenta WHERE idVenta=" + idVenta;
					if (!bilbao)
						query += concurrencia;
					resultSet = statement.executeQuery(query);
					LineaVenta lineaVenta;
					while (resultSet.next()) {
						lineaVenta = new LineaVenta(idVenta, resultSet.getInt("idProducto"),
								resultSet.getInt("cantidad"), resultSet.getFloat("precioTotal_prod"));
						lineaVentas.put(lineaVenta.getIdProducto(), lineaVenta);
					}
				}
				
				statement.close();
				if (bilbao) {
					connection.close();
				}

			} catch (SQLException e) {
				tVenta = null;
			}
		}

		return tVenta;

		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#modificarVenta(TVenta tVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarVenta(TVenta tVenta) {
		// begin-user-code
		int id = -100;
		boolean bilbao = false;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		} else {
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}

		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				String query = "UPDATE venta SET " + " " + "fecha='" + tVenta.getFecha() + "'," + "precioTotal='"
						+ tVenta.getprecioTotal() + "' " + "WHERE idVenta=" + tVenta.getIdVenta() + ";";
				statement.executeUpdate(query);
				HashMap<Integer, LineaVenta> lineaVentas = tVenta.getLineaVentas();
				Collection<LineaVenta> values = lineaVentas.values();
				Iterator<LineaVenta> iterator = values.iterator();
				LineaVenta lineaVenta;
				while (iterator.hasNext()) {
					lineaVenta = iterator.next();
					query = "UPDATE lineaVenta SET " + "cantidad=" + lineaVenta.getCantidad() + ", "
							+ "precioTotal_prod=" + lineaVenta.getPrecio() + " " + "WHERE idVenta="
							+ tVenta.getIdVenta() + " AND idProducto=" + lineaVenta.getIdProducto();
					statement.executeUpdate(query);
				}
				id = tVenta.getIdVenta();
				
				statement.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				id = -100;
			}
		}
		// end-user-code
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOVenta#listarVentas()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TVenta> listarVentas() {
		// begin-user-code

		ArrayList<TVenta> listaVentas = new ArrayList<>();
		boolean bilbao = false;
		String concurrencia = " FOR UPDATE";

		TVenta tVenta = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.getTransaction();
		Connection connection = null;

		if (transaction != null) {
			connection = (Connection) transaction.getResource();
		} else {
			bilbao = true;
			ConexionDAO c = ConexionDAO.getInstance();
			connection = c.getConexion();
		}

		if (connection != null) {
			try {
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				String query = "SELECT * FROM venta";
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet1 = statement1.executeQuery(query);
				ResultSet resultSet2;
				HashMap<Integer, LineaVenta> lineaVentas;
				while (resultSet1.next()) {
					lineaVentas = new HashMap<>();
					tVenta = new TVenta(resultSet1.getInt("idVenta"), resultSet1.getInt("idCliente"),
							resultSet1.getDate("fecha"), resultSet1.getFloat("precioTotal"), lineaVentas, false);
					query = "SELECT * FROM lineaVenta WHERE idVenta=" + tVenta.getIdVenta();
					resultSet2 = statement2.executeQuery(query);
					LineaVenta lineaVenta;
					while (resultSet2.next()) {
						lineaVenta = new LineaVenta(resultSet2.getInt("idVenta"), resultSet2.getInt("cantidad"),
								resultSet2.getFloat("precioTotal_prod"));
						lineaVentas.put(lineaVenta.getIdProducto(), lineaVenta);
					}
					listaVentas.add(tVenta);
				}
				
				statement1.close();
				statement2.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				tVenta = null;
			}
		}
		return listaVentas;
	}
	// end-user-code
}