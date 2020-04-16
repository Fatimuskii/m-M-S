/**
 * 
 */
package Integracion.Producto.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.Conexion.ConexionDAO;
import Integracion.Producto.DAOProducto;
import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionManager.TransactionManager;
import Negocio.Producto.imp.TJuegoDeMesa;
import Negocio.Producto.imp.TMerchandising;
import Negocio.Producto.imp.TProducto;
import Negocio.Producto.imp.Tipo;

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
public class DAOProductoImp implements DAOProducto {
	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#altaProducto(TProducto tProducto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int altaProducto(TProducto tProducto) {
		// begin-user-code
		int id = -100;
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
				
				String query = "INSERT INTO producto (nombre, precio, stock, activo)" + " VALUES ('"
						+ tProducto.getNombre() + "', " 
						+ tProducto.getPrecio() + ", " 
						+ tProducto.getStock() + ", "
						+ (tProducto.getActivo() ? 1 : 0) + ");";
				statement.executeUpdate(query);
				query = "SELECT last_insert_id() as last_id from producto";
				ResultSet resultSet = statement.executeQuery(query);
				if (resultSet.next()) {
					id = resultSet.getInt("last_id");
					if (tProducto instanceof TJuegoDeMesa) {
						query = "INSERT INTO juegoDeMesa (id,edadRecomendada, numJugadores)" + " VALUES (" 
								+ id + ", "
								+ ((TJuegoDeMesa) tProducto).getEdadRecomendada() + ", " 
								+ ((TJuegoDeMesa) tProducto).getNumJugadores() + ");";
						statement.executeUpdate(query);
					} else {
						query = "INSERT INTO merchandising (id, tipo)" + " VALUES (" 
								+ id + ", '"
								+ ((TMerchandising) tProducto).getTipo() + "');";
						statement.executeUpdate(query);
					}
				}
				statement.close();
				if (bilbao) {
					connection.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				id = -100;
			}
		}

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#bajaProducto(int idProducto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int bajaProducto(int idProducto) {
		int res = -100;
		boolean bilbao = false;

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
				String query = "UPDATE producto SET activo = 0 WHERE id=" + idProducto;
				statement.executeUpdate(query);
				res = idProducto;

				statement.close();
				if (bilbao)
					connection.close();
				
			} catch (SQLException e) {
				res = -100;
			}
		}

		return res;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#modificarProducto(TProducto tProducto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int modificarProducto(TProducto tProducto) {
		int id = -100;
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
				String query = "UPDATE producto SET " 
						+ "nombre='" + tProducto.getNombre() + "', " 
						+ "precio=" + tProducto.getPrecio() + ", " 
						+ "stock=" + tProducto.getStock() + ", " 
						+ "activo=" + (tProducto.getActivo() ? 1 : 0) + " "
						+ "WHERE id =" + tProducto.getIdProducto();
				statement.executeUpdate(query);
				
				if (tProducto instanceof TJuegoDeMesa) {
					query = "UPDATE juegoDeMesa SET " 
							+ "edadRecomendada=" + ((TJuegoDeMesa) tProducto).getEdadRecomendada() + ", "
							+ "numJugadores=" + ((TJuegoDeMesa) tProducto).getNumJugadores() + " " 
							+ "WHERE id=" + tProducto.getIdProducto();
					statement.executeUpdate(query);
				} else {
					query = "UPDATE merchandising SET " + "tipo='"
							+ ((TMerchandising) tProducto).getTipo() + "' " 
							+ "WHERE id=" + tProducto.getIdProducto();
					statement.executeUpdate(query);
				}
				id = tProducto.getIdProducto();
				
				statement.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				id = -100;
			}
		}

		
		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#buscarProducto(int idProducto)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TProducto buscarProducto(int idProducto) {
		TProducto tProducto = null;
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
				String query = "SELECT * FROM producto WHERE id=" + idProducto;
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					TProducto tProductoLeido = new TProducto(
							idProducto,
							resultSet.getString("nombre"),
							resultSet.getFloat("precio"),
							resultSet.getInt("stock"),
							resultSet.getBoolean("activo")
							);
					query = "SELECT * FROM juegoDeMesa WHERE id=" + idProducto;
					if (!bilbao)
						query += concurrencia;
					resultSet = statement.executeQuery(query);
					if(resultSet.next()) {
						tProducto = new TJuegoDeMesa(
								resultSet.getInt("id"),
								tProductoLeido.getNombre(),
								tProductoLeido.getPrecio(),
								tProductoLeido.getStock(),
								tProductoLeido.getActivo(),
								resultSet.getInt("edadRecomendada"),
								resultSet.getInt("numJugadores")
							);
					} else {
						query = "SELECT * FROM merchandising WHERE id=" + idProducto;
						if (!bilbao)
							query += concurrencia;
						resultSet = statement.executeQuery(query);
						if (resultSet.next()) {
							tProducto = new TMerchandising(
									resultSet.getInt("id"),
									tProductoLeido.getNombre(),
									tProductoLeido.getPrecio(),
									tProductoLeido.getStock(),
									tProductoLeido.getActivo(),
									Tipo.parse(resultSet.getString("tipo"))
									);
						}
					}
				}

				statement.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				tProducto = null;
			}
		}

		return tProducto;
	}

	
	public TProducto buscarProductoNombre(String nombre) {
		TProducto tProducto = null;
		String concurrencia = " FOR UPDATE";
		boolean bilbao = false;
		
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
				String query = "SELECT * FROM producto WHERE nombre='" + nombre + "'";
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet = statement.executeQuery(query);
				if(resultSet.next()) {
					TProducto tProductoLeido = new TProducto(
							resultSet.getInt("id"),
							resultSet.getString("nombre"),
							resultSet.getFloat("precio"),
							resultSet.getInt("stock"),
							resultSet.getBoolean("activo")
							);
					query = "SELECT * FROM juegoDeMesa WHERE id=" + tProductoLeido.getIdProducto();
					if (!bilbao)
						query += concurrencia;
					resultSet = statement.executeQuery(query);
					if(resultSet.next()) {
						tProducto = new TJuegoDeMesa(
								resultSet.getInt("id"),
								tProductoLeido.getNombre(),
								tProductoLeido.getPrecio(),
								tProductoLeido.getStock(),
								tProductoLeido.getActivo(),
								resultSet.getInt("edadRecomendada"),
								resultSet.getInt("numJugadores")
							);
					} else {
						query = "SELECT * FROM merchandising WHERE id=" + tProductoLeido.getIdProducto();
						if (!bilbao)
							query += concurrencia;
						resultSet = statement.executeQuery(query);
						if (resultSet.next()) {
							tProducto = new TMerchandising(
									resultSet.getInt("id"),
									tProductoLeido.getNombre(),
									tProductoLeido.getPrecio(),
									tProductoLeido.getStock(),
									tProductoLeido.getActivo(),
									Tipo.parse(resultSet.getString("tipo"))
									);
						}
					}
				}

				statement.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				tProducto = null;
			}
		}

		return tProducto;
	}
	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#listarProductos()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TProducto> listarProductos() {
		ArrayList<TProducto> listaProductos = new ArrayList<>();
		TProducto tProducto = null;

		String concurrencia = " FOR UPDATE";
		boolean bilbao = false;
		
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
		if(connection!=null) {
			try {
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				String query = "SELECT * FROM producto WHERE activo=1";
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet1 = statement1.executeQuery(query);
				ResultSet resultSet2;
				TProducto tProductoLeido;
				while(resultSet1.next()) {
					tProductoLeido = new TProducto(
							resultSet1.getInt("id"),
							resultSet1.getString("nombre"),
							resultSet1.getFloat("precio"),
							resultSet1.getInt("stock"),
							resultSet1.getBoolean("activo")
							);
					
					query = "SELECT * FROM juegoDeMesa WHERE id=" + tProductoLeido.getIdProducto();
					if (!bilbao)
						query += concurrencia;
					resultSet2 = statement2.executeQuery(query);
					if(resultSet2.next()) {
						tProducto = new TJuegoDeMesa(
								resultSet2.getInt("id"),
								tProductoLeido.getNombre(),
								tProductoLeido.getPrecio(),
								tProductoLeido.getStock(),
								tProductoLeido.getActivo(),
								resultSet2.getInt("edadRecomendada"),
								resultSet2.getInt("numJugadores")
								);
					} else {
						query = "SELECT * FROM merchandising WHERE id=" + resultSet1.getInt("id");
						if (!bilbao)
							query += concurrencia;
						resultSet2 = statement2.executeQuery(query);
						if(resultSet2.next()) {
							tProducto = new TMerchandising(
									resultSet2.getInt("id"),
									tProductoLeido.getNombre(),
									tProductoLeido.getPrecio(),
									tProductoLeido.getStock(),
									tProductoLeido.getActivo(),
									Tipo.parse(resultSet2.getString("tipo"))
							);
						}
					}
					listaProductos.add(tProducto);

				}

				statement1.close();
				statement2.close();
				if (bilbao)
					connection.close();
			} catch (SQLException e) {
				tProducto = null;
			}
			
		}
		return listaProductos;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see DAOProducto#buscarProductosporPrecio(float precio)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TProducto> buscarProductosporPrecio(float precio) {
		ArrayList<TProducto> listaProductos = new ArrayList<>();
		TProducto tProducto = null;

		String concurrencia = " FOR UPDATE";
		boolean bilbao = false;
		
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
		if(connection!=null) {
			try {
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				String query = "SELECT * FROM producto WHERE activo=1 AND precio <= " + precio;
				if (!bilbao)
					query += concurrencia;
				ResultSet resultSet1 = statement1.executeQuery(query);
				ResultSet resultSet2;
				TProducto tProductoLeido;
				while(resultSet1.next()) {
					tProductoLeido = new TProducto(
							resultSet1.getInt("id"),
							resultSet1.getString("nombre"),
							resultSet1.getFloat("precio"),
							resultSet1.getInt("stock"),
							resultSet1.getBoolean("activo")
							);
					query = "SELECT * FROM juegoDeMesa WHERE id=" + resultSet1.getInt("id");
					if (!bilbao)
						query += concurrencia;
					resultSet2 = statement2.executeQuery(query);
					if(resultSet2.next()) {
						tProducto = new TJuegoDeMesa(
								resultSet2.getInt("id"),
								tProductoLeido.getNombre(),
								tProductoLeido.getPrecio(),
								tProductoLeido.getStock(),
								tProductoLeido.getActivo(),
								resultSet2.getInt("edadRecomendada"),
								resultSet2.getInt("numJugadores")
								);
					} else {
						query = "SELECT * FROM merchandising WHERE id=" + resultSet1.getInt("id");
						if (!bilbao)
							query += concurrencia;
						resultSet2 = statement2.executeQuery(query);
						if(resultSet2.next()) {
							tProducto = new TMerchandising(
									resultSet2.getInt("id"),
									tProductoLeido.getNombre(),
									tProductoLeido.getPrecio(),
									tProductoLeido.getStock(),
									tProductoLeido.getActivo(),
									Tipo.parse(resultSet2.getString("tipo"))
									);
						}
					}
					listaProductos.add(tProducto);
				}

				statement1.close();
				statement2.close();
				if (bilbao)
					connection.close();

			} catch (SQLException e) {
				tProducto = null;
			}

		}
		return listaProductos;
	}
	
}