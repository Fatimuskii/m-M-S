/**
 * 
 */
package Integracion.Transaction.TransactionFactory;

import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionMySQL;

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
public class TransactionFactoryImp extends TransactionFactory{
	
	@Override
	public Transaction crearTransaction() {
		return new TransactionMySQL();
	}
}