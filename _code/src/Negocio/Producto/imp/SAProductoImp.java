/**
 * 
 */
package Negocio.Producto.imp;

import java.util.ArrayList;

import Integracion.Cliente.DAOCliente;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Producto.DAOProducto;
import Integracion.Query.FactoriaQuery;
import Integracion.Query.TQuery;
import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionManager.TransactionManager;
import Negocio.Cliente.imp.TCliente;
import Negocio.Producto.SAProducto;

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
public class SAProductoImp implements SAProducto {
	/** 
	* (non-Javadoc)
	* @see SAProducto#altaProducto(TProducto tProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaProducto(TProducto tProducto) {
		int id = -1; //Producto existe
		
		
		if (tProducto != null) {
			// Crear transacción
			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaction = transactionManager.createTransaction();
			transaction.start();
			// DAOProducto
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();

			TProducto tProductoExiste = daoProducto.buscarProductoNombre(tProducto.getNombre());
			
			tProducto.setActivo(true);

			if(tProductoExiste == null){//El producto no existe
				id = daoProducto.altaProducto(tProducto);
				if(id == -100){
					transaction.rollBack();
				}
				else{
					transaction.commit();
				}
			}
			else{//El producto existe
				if(!tProductoExiste.getActivo()){//No está activo

					if ((tProductoExiste instanceof TJuegoDeMesa && tProducto instanceof TJuegoDeMesa)
							|| tProductoExiste instanceof TMerchandising && tProducto instanceof TMerchandising) {
						tProducto.setIdProducto(tProductoExiste.getIdProducto());
						id = daoProducto.modificarProducto(tProducto);
						if (id == -100) {
							transaction.rollBack();
						} else {
							transaction.commit();
						}
					} else {
						transaction.rollBack();
						id = -2;
					}
				}
				else{ //El producto está activo
					transaction.rollBack();
				}
			}
			// Eliminar transacción
			transactionManager.deleteTransaction();
		}
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAProducto#bajaProducto(int idProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int bajaProducto(int idProducto) {
		int id = -1; // Producto no existe
		
		// Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();

		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();

		TProducto tProductoExiste = daoProducto.buscarProducto(idProducto);

		if (tProductoExiste == null) {//Producto no existe
			transaction.rollBack();
		} else { // Producto existe
			if (tProductoExiste.getActivo()) {
				id = daoProducto.bajaProducto(idProducto);
				if (id == -100)
					transaction.rollBack();
				else
					transaction.commit();
			} else {
				transaction.rollBack();
				id = -2; // Producto ya está desactivado
			}
		}

		// Eliminar transacción
		transactionManager.deleteTransaction();

		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAProducto#modificarProducto(TProducto tProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int modificarProducto(TProducto tProducto) {
		
		int id = -1; //Producto no existe
		// Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		// DAOProducto
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		DAOProducto daoProducto = factoriaIntegracion.crearDAOProducto();

		TProducto tProductoExiste = daoProducto.buscarProducto(tProducto.getIdProducto());

		if (tProductoExiste == null) {// Producto no existe
			transaction.rollBack();
		} else { // Sí existe
			if (tProductoExiste.getActivo()) { // Producto Activo
				TProducto tModificar = daoProducto.buscarProductoNombre(tProducto.getNombre());
				if (tModificar == null) {
					id = daoProducto.modificarProducto(tProducto);
					if (id == -100) {
						transaction.rollBack();
					} else {
						transaction.commit();
					}
				} else {//El nombre está en la base de datos
					if(tProductoExiste.getIdProducto() == tModificar.getIdProducto()){
						id = daoProducto.modificarProducto(tProducto);
						if (id == -100) {
							transaction.rollBack();
						} else {
							transaction.commit();
						}
					} else {
						id = -2;// Ya existe un producto con ese nombre
						transaction.rollBack();
					}
				}
			} else {
				id = -3;// Producto no activo
				transaction.rollBack();
			}

		}

		
		// Eliminar transacción
		transactionManager.deleteTransaction();
		
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SAProducto#buscarProducto(int idProducto)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TProducto buscarProducto(int idProducto) {
		TProducto tProducto = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		DAOProducto daoProducto = FactoriaIntegracion.getInstance().crearDAOProducto();
		tProducto = daoProducto.buscarProducto(idProducto);
		
		if(tProducto == null)
			transaction.rollBack();
		else
			transaction.commit();
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		
		return tProducto;

}

	/** 
	* (non-Javadoc)
	* @see SAProducto#listarProductos()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProducto> listarProductos() {
		ArrayList<TProducto> productos = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		
		transaction.start();
		DAOProducto daoProducto = FactoriaIntegracion.getInstance().crearDAOProducto();
		productos = daoProducto.listarProductos();
		transaction.commit();
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return productos;
	}

	/** 
	* (non-Javadoc)
	* @see SAProducto#buscarProductosporPrecio(float precio)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TProducto> buscarProductosporPrecio(float precio) {
		ArrayList<TProducto> productos = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		
		transaction.start();
		DAOProducto daoProducto = FactoriaIntegracion.getInstance().crearDAOProducto();
		productos = daoProducto.buscarProductosporPrecio(precio);
		transaction.commit();
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return productos;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<TProducto> buscarProductoMasCompradoPorUnCliente(TQuery tQuery) {
		ArrayList<TProducto> productos = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		
		transaction.start();
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().crearDAOCliente();
		TCliente tCliente = daoCliente.buscarCliente(tQuery.getIdCliente());
		if(tCliente == null){
			transaction.rollBack();
		}
		else{
			FactoriaQuery factoriaQuery = FactoriaQuery.getInstance();
			productos =  (ArrayList<TProducto>) factoriaQuery.crearProductoMasCompradoPorUnCliente().execute(tQuery);
			transaction.commit();
		}
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return productos;
	}
	
}