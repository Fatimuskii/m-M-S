
package Negocio.Venta.imp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import Integracion.Cliente.DAOCliente;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Producto.DAOProducto;
import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionManager.TransactionManager;
import Integracion.Venta.DAOVenta;
import Negocio.Cliente.imp.TCliente;
import Negocio.Producto.imp.TProducto;
import Negocio.Venta.SAVenta;
import Presentacion.Venta.GUIVenta;

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
public class SAVentaImp implements SAVenta {
	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#abrirVenta(int idCliente)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public TVenta abrirVenta(int idCliente) {

		TVenta nuevaVenta = null;

		// begin-user-code

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();

			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			DAOCliente dAOCliente = factoriaIntegracion.crearDAOCliente();

			TCliente tCliente = dAOCliente.buscarCliente(idCliente);
			if (tCliente != null) {

				boolean active = tCliente.getActivo();

				if (active) {
					nuevaVenta = new TVenta(idCliente);
				}
			} else {
				transaction.rollBack();
			}

			
		}
		transactionManager.deleteTransaction();
		return nuevaVenta;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#cerrarVenta(TVenta tVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public int cerrarVenta(TVenta tVenta) {
		// begin-user-code

		int idVenta = -100;
		if (tVenta != null) { // no se deberia contemplar este caso, pero lo
								// comprobamos
			boolean activo = tVenta.getActivo();

			if (activo) { // tb deberia estar activa, pero comprobamos tb
				TransactionManager transactionManager = TransactionManager.getInstance();
				Transaction transaction = transactionManager.createTransaction();

				if (transaction != null) {
					transaction.start();

					HashMap<Integer, LineaVenta> lineaVentas = tVenta.getLineaVentas();

					if (!lineaVentas.isEmpty()) {
						FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
						DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();

						// Para usar lineas de venta de la VentaActual
						Collection<LineaVenta> collectionLineasDeVenta = lineaVentas.values();
						Iterator<LineaVenta> iterator = collectionLineasDeVenta.iterator();
						LineaVenta lineaVenta;

						float precioTotal = 0;
						while (iterator.hasNext()) {

							lineaVenta = iterator.next();

							TProducto tProducto_enLineaVenta = daoProducto.buscarProducto(lineaVenta.getIdProducto());

							// si existe el prod
							if (tProducto_enLineaVenta != null) {
								// productos no activo, o la cantidad que se
								// quiere es mayor al stock de ese producto
								if (lineaVenta.getCantidad() <= tProducto_enLineaVenta.getStock()) {

									// hay que actualizar el stock del producto
									int stockFinal = tProducto_enLineaVenta.getStock() - lineaVenta.getCantidad();
									tProducto_enLineaVenta.setStock(stockFinal);

									int resultadoActualizarProd = daoProducto.modificarProducto(tProducto_enLineaVenta);

									// Si no hay algun problema en actualizar
									// bbdd
									if (resultadoActualizarProd > 0) {
										// precio del producto
										float precioProducto = tProducto_enLineaVenta.getPrecio();
										// precio de la linea será ->
										// precioProducto
										// * cantidad
										lineaVenta.setPrecio(precioProducto * lineaVenta.getCantidad());
										float precioLinea = lineaVenta.getPrecio();

										precioTotal += precioLinea;
										tVenta.setprecioTotal(precioTotal);
									} else {
										lineaVentas.remove(lineaVenta.getIdProducto());
										idVenta = -8;
										transaction.rollBack();
									}

								} else {
									lineaVentas.remove(lineaVenta.getIdProducto());
									idVenta = -7;
								}
							} else {// Si producto no existe-> se elimina de la
									// lista
								lineaVentas.remove(lineaVenta.getIdProducto());
								idVenta = -6;
								transaction.rollBack();
							}

						}

						if (!lineaVentas.isEmpty()) {

							Calendar calendar = Calendar.getInstance();
							long timeInMillis = calendar.getTimeInMillis();
							Date fecha = new Date(timeInMillis);

							tVenta.setFecha(fecha);
							tVenta.setActivo(false);

							DAOVenta daoVenta = factoriaIntegracion.crearDAOVenta();
							idVenta = daoVenta.altaVenta(tVenta);

							if (idVenta < 0)
								transaction.rollBack();
							else
								transaction.commit();
						} else {
							transaction.rollBack();
						}

					} else {
						idVenta = -4;
						transaction.rollBack();
					}

				} else
					idVenta = -3;

				transactionManager.deleteTransaction();

			} else
				idVenta = -2;

		} // idVenta=-100;

		return idVenta;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#devolverProducto(int idVenta, int idProducto, int cantidad)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta modificarVenta(int idProducto, int cantidad) {
		// begin-user-code

		TVenta ventaAct = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			// cojo la venta actual
			GUIVenta guiVenta = GUIVenta.getInstance();
			ventaAct = guiVenta.getVentaActual();

			if (ventaAct != null) {

				DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();
				TProducto tProducto = daoProducto.buscarProducto(idProducto);

				if (tProducto != null && tProducto.getActivo()) {

					HashMap<Integer, LineaVenta> lineaV = ventaAct.getLineaVentas();
					boolean estaProducto = lineaV.containsKey(idProducto);

					// producto no esta en la ventaActual cantidada tiene que
					// ser >0
					if (!estaProducto) {
						LineaVenta lineaVAux = new LineaVenta(idProducto, cantidad, 0);
						lineaV.put(idProducto, lineaVAux);
					}

					// Producto en la linea de venta (de la venta actual)
					else {
						// Si ha puesto un 0 == quitar de la linea de venta
						// actual
						if (cantidad == 0) {
							lineaV.remove(idProducto);
						} else {
							LineaVenta lineaVAux = lineaV.get(idProducto);
							lineaVAux.setCantidad(cantidad);
							lineaV.put(idProducto, lineaVAux);
						}
					}
					ventaAct.setLineaVentas(lineaV);
					guiVenta.setVenta(ventaAct);
					transaction.commit();

				} else {
					transaction.rollBack();
				}

			}
			transactionManager.deleteTransaction();

		}

		return ventaAct;

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#buscarVenta(int idVenta)
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public TVenta buscarVenta(int idVenta) {
		// begin-user-code
		TVenta tVenta = null;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			DAOVenta daoVenta = factoriaIntegracion.crearDAOVenta();
			tVenta = daoVenta.buscarVenta(idVenta);
			if (tVenta == null)
				transaction.rollBack();
			else
				transaction.commit();
		}

		transactionManager.deleteTransaction();

		return tVenta;
		// end-user-code
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#listarVentas()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public ArrayList<TVenta> listarVentas() {
		// begin-user-code

		ArrayList<TVenta> ventas = null;
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {
			transaction.start();
			DAOVenta daoVenta = FactoriaIntegracion.getInstance().crearDAOVenta();
			ventas = daoVenta.listarVentas();
			transaction.commit();
		}

		// Eliminar transacción
		transactionManager.deleteTransaction();

		return ventas;
		// end-user-code
	}

	// end-user-code

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#buscarFacturaTotal()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	@Override
	public int devolver(int idVenta, int idProducto, int cantidad) {

		int id = -100;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		if (transaction != null) {
			transaction.start();
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			DAOVenta daoVenta = factoriaIntegracion.crearDAOVenta();
			TVenta tVenta = daoVenta.buscarVenta(idVenta);

			if (tVenta != null) {
				DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();
				TProducto tProducto = daoProducto.buscarProducto(idProducto);

				if (tProducto != null && tProducto.getActivo()) {

					HashMap<Integer, LineaVenta> lineaVentas = tVenta.getLineaVentas();
					LineaVenta lineaVenta = lineaVentas.get(idProducto);

					if (lineaVenta != null) {

						int unidadesVenta = lineaVenta.getCantidad();

						if (unidadesVenta >= cantidad) {

							float precioLineaVenta = lineaVenta.getPrecio();

							lineaVenta.setCantidad(unidadesVenta - cantidad);
							lineaVenta.setPrecio(precioLineaVenta - (precioLineaVenta / unidadesVenta) * cantidad);

							int stock = tProducto.getStock();

							tProducto.setStock(stock + cantidad);
							id = daoProducto.modificarProducto(tProducto);

							if (id != -100) {

								float precioTotal = tVenta.getprecioTotal();

								tVenta.setprecioTotal(precioTotal - (precioLineaVenta / unidadesVenta) * cantidad);
								id = daoVenta.modificarVenta(tVenta);
								if (id == -100)
									transaction.rollBack();
								else
									transaction.commit();
							} else
								transaction.rollBack();
						} else {
							id = -11;
							transaction.rollBack();
						}
					} else {
						id = -10;
						transaction.rollBack();
					}
				} else {
					id = -9;
					transaction.rollBack();
				}
			} else {
				id = -8;
				transaction.rollBack();
			}
		}

		transactionManager.deleteTransaction();

		return id;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see SAVenta#buscarFacturaTotal()
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	public TMostrarFactura mostrarFacturaTotal(int idVenta) {
		TMostrarFactura factura = null;

		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();

		if (transaction != null) {

			transaction.start();

			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			DAOVenta daoVenta = factoriaIntegracion.crearDAOVenta();
			TVenta tVenta = daoVenta.buscarVenta(idVenta);

			if (tVenta == null)
				transaction.rollBack();
			else {
				DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();
				ArrayList<TProducto> productos = new ArrayList<TProducto>();

				DAOCliente daoClientes = factoriaIntegracion.crearDAOCliente();
				TCliente cliente = daoClientes.buscarCliente(tVenta.getIdCliente());

				HashMap<Integer, LineaVenta> lineaVentas = tVenta.getLineaVentas();
				// Para usar lineas de venta de la VentaActual
				Collection<LineaVenta> collectionLineasDeVenta = lineaVentas.values();
				Iterator<LineaVenta> iterator = collectionLineasDeVenta.iterator();
				LineaVenta lineaV;

				while (iterator.hasNext()) {
					lineaV = iterator.next();
					TProducto tProducto_enLineaVenta = daoProducto.buscarProducto(lineaV.getIdProducto());

					if (tProducto_enLineaVenta != null)
						productos.add(tProducto_enLineaVenta);

				}

				if (cliente == null || lineaVentas == null || productos.isEmpty()) {
					transaction.rollBack();
				} else {
					factura = new TMostrarFactura(cliente, productos, tVenta);
					transaction.commit();
				}

			}
		}

		transactionManager.deleteTransaction();

		return factura;
	}

}