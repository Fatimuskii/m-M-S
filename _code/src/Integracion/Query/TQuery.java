package Integracion.Query;

import java.sql.Date;
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
public class TQuery {
	private int idCliente;
	private Date fecha;
	
	public TQuery(int idCliente, Date fecha){
		this.idCliente =idCliente;
		this.fecha = fecha;
	}
	
	public TQuery(int idCliente){
		this.idCliente =idCliente;
		this.fecha = null;
	}
	
	public TQuery(Date fecha) {
		this.idCliente = 0;
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setMes(Date fecha) {
		this.fecha = fecha;
	}
}
