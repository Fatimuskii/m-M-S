/**
 * 
 */
package Integracion.Transaction.TransactionManager;

import java.util.concurrent.ConcurrentHashMap;

import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionFactory.TransactionFactory;

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
public class TransactionManagerImp extends TransactionManager{
	
	private ConcurrentHashMap<Thread, Transaction> transactions;
	
	public TransactionManagerImp(){
		transactions = new ConcurrentHashMap<Thread, Transaction>();
	}
	

	@Override
	public Transaction createTransaction() {
		Transaction transaction = null;
		if(transactions != null){
			TransactionFactory transactionFactory = TransactionFactory.getInstance();
			transaction = transactionFactory.crearTransaction();
			
			transactions.put(Thread.currentThread(), transaction);
		}
		return transaction;
	}

	@Override
	public void deleteTransaction() {
		if(transactions != null){
			transactions.remove(Thread.currentThread());
		}
	}

	@Override
	public Transaction getTransaction() {
		Transaction transaction = null;
		
		if(transactions != null){
			transaction = transactions.get(Thread.currentThread());
		}
		return transaction;
	}
}