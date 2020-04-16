/**
 * 
 */
package Integracion.Transaction.TransactionFactory;

import Integracion.Transaction.Transaction;
import Integracion.Transaction.TransactionMySQL;

/** 
* <!-- begin-UML-doc -->
* <!-- end-UML-doc -->
* @author Ana �lava Pap�
* @author �scar Canive Huguet
* @author David Dom�nguez Guti�rrez
* @author F�tima Garc�a Delgado
* @author Marina Lozano Lahuerta
* @author Paula S�nchez de la Nieta G�mez
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class TransactionFactoryImp extends TransactionFactory{
	
	@Override
	public Transaction crearTransaction() {
		return new TransactionMySQL();
	}
}