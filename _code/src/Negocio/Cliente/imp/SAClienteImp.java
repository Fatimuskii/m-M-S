/**
 * 
 */
package Negocio.Cliente.imp;

import java.util.ArrayList;

import Integracion.Cliente.DAOCliente;
import Integracion.Factoria.FactoriaIntegracion;
import Integracion.Query.FactoriaQuery;
import Integracion.Query.TQuery;
import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionManager.TransactionManager;
import Negocio.Cliente.SACliente;

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
public class SAClienteImp implements SACliente {
	/** 
	* (non-Javadoc)
	* @see SACliente#altaCliente(TCLiente tCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int altaCliente(TCliente tCliente) {
		int id = -1;
		
		
		if (tCliente != null) {

			TransactionManager transactionManager = TransactionManager.getInstance();
			Transaction transaction = transactionManager.createTransaction();
			transaction.start();
	
			FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
			DAOCliente daoCliente = factoriaIntegracion.crearDAOCliente();

			TCliente tClienteExiste = daoCliente.buscarClienteDNI(tCliente.getDNI());
			
			tCliente.setActivo(true);

			if(tClienteExiste == null){
				id = daoCliente.altaCliente(tCliente);
				if(id == -100)
					transaction.rollBack();
				else
					transaction.commit();
			}
			else {
				if(!tClienteExiste.getActivo()){
					tCliente.setIdCliente(tClienteExiste.getIdCliente());
					id = daoCliente.modificarCliente(tCliente);
					
					if(id==-100)
						transaction.rollBack();
					else
						transaction.commit();
				}
				else{
					transaction.rollBack();
				}
			}

			transactionManager.deleteTransaction();
		}
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SACliente#bajaCliente(Integer idCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int bajaCliente(int idCliente) {
		int id = -1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();

		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		DAOCliente daoCliente = factoriaIntegracion.crearDAOCliente();

		TCliente tClienteExiste = daoCliente.buscarCliente(idCliente);

		if (tClienteExiste == null) {
			transaction.rollBack();
		} else {
			if(tClienteExiste.getActivo()){
			id = daoCliente.bajaCliente(idCliente);
			if (id == -100)
				transaction.rollBack();
			else
				transaction.commit();
			} else {
				transaction.rollBack();
				id = -2;
			}
		}

		transactionManager.deleteTransaction();

		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SACliente#modificarCliente(TCLiente tCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public int modificarCliente(TCliente tCliente) {
		int id = -1;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		FactoriaIntegracion factoriaIntegracion = FactoriaIntegracion.getInstance();
		DAOCliente daoCliente = factoriaIntegracion.crearDAOCliente();

		TCliente tClienteExiste = daoCliente.buscarCliente(tCliente.getIdCliente());

		if (tClienteExiste == null) {
			transaction.rollBack();
		} else {
			if(tClienteExiste.getActivo()){
				TCliente tModificar = daoCliente.buscarClienteDNI(tCliente.getDNI());
				if(tModificar == null){ //El DNI no existe
					id = daoCliente.modificarCliente(tCliente);
					
					if (id == -100)
						transaction.rollBack();
					else
						transaction.commit();
				} else { //El DNI existe
					if(tClienteExiste.getIdCliente() == tModificar.getIdCliente()){
						id = daoCliente.modificarCliente(tCliente);
						
						if (id == -100)
							transaction.rollBack();
						else
							transaction.commit();
					} else { //DNI repetido
						transaction.rollBack();
						id = -2;
						}
					}
				} else {
				transaction.rollBack();
				id = -3;
				}
			} 
		
		transactionManager.deleteTransaction();
		
		return id;
	}

	/** 
	* (non-Javadoc)
	* @see SACliente#buscarCliente(Integer idCliente)
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public TCliente buscarCliente(int idCliente) {
		TCliente tCliente = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().crearDAOCliente();
		tCliente = daoCliente.buscarCliente(idCliente);
		
		if(tCliente == null)
			transaction.rollBack();
		else
			transaction.commit();
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return tCliente;
	}

	/** 
	* (non-Javadoc)
	* @see SACliente#listarCliente()
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	public ArrayList<TCliente> listarCliente() {
		ArrayList<TCliente> listaClientes = null;
		
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		DAOCliente daoCliente  = FactoriaIntegracion.getInstance().crearDAOCliente();
		listaClientes = daoCliente.listarCliente();
		transaction.commit();
		
		transactionManager.deleteTransaction();
		return listaClientes;
	}

	@Override
	public TCliente buscarClienteDNI(String DNI) {
		TCliente cliente = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		DAOCliente daoCliente = FactoriaIntegracion.getInstance().crearDAOCliente();
		cliente = daoCliente.buscarClienteDNI(DNI);
		transaction.commit();
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return cliente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TCliente> ClientesConComprasDesdeFecha(TQuery tQuery) {
		ArrayList<TCliente> clientes = null;
		
		//Crear transacción
		TransactionManager transactionManager = TransactionManager.getInstance();
		Transaction transaction = transactionManager.createTransaction();
		transaction.start();
		
		FactoriaQuery factoriaQuery = FactoriaQuery.getInstance();
		clientes =  (ArrayList<TCliente>) factoriaQuery.crearClientesConComprasDesdeFecha().execute(tQuery);
		transaction.commit();
	
		
		//Eliminar transacción
		transactionManager.deleteTransaction();
		return clientes;
	}

}