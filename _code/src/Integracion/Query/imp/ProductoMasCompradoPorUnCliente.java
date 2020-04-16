/**
 * 
 */
package Integracion.Query.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Integracion.Conexion.ConexionDAO;
import Integracion.Query.Query;
import Integracion.Query.TQuery;
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
public class ProductoMasCompradoPorUnCliente implements Query {
	/** 
	* (non-Javadoc)
	* @see Query#execute(Object Parameter1)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public Object execute(Object parametro) {
		ArrayList<TProducto> listaProductos = new ArrayList<>();
		TProducto tProducto = null;
		
		int idCliente = ((TQuery) parametro).getIdCliente();
		
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
				Statement statement1 = connection.createStatement();
				Statement statement2 = connection.createStatement();
				
				String query = "SELECT producto.* FROM producto"
							+ " JOIN lineaVenta ON producto.id = lineaVenta.idProducto"
							+ " JOIN venta ON venta.idVenta = lineaVenta.idVenta"
							+ " WHERE venta.idCliente = " + idCliente
							+ " GROUP BY lineaVenta.idProducto HAVING SUM(lineaVenta.cantidad) = "
							+ "( SELECT SUM(lineaVenta.cantidad) max_suma FROM lineaVenta "
							+ " JOIN venta ON venta.idVenta = lineaVenta.idVenta "
							+ "WHERE venta.idCliente = " + idCliente 
							+ " GROUP BY lineaVenta.idProducto ORDER BY max_suma DESC LIMIT 1 )";
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
				
				if (bilbao)
					connection.close();
				
				} catch (SQLException e) {
					tProducto = null;
				}
			
			}

		return listaProductos;
	}
}