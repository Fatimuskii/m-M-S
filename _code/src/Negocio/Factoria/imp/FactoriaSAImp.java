/**
 * 
 */
package Negocio.Factoria.imp;

import Negocio.Cliente.SACliente;
import Negocio.Cliente.imp.SAClienteImp;
import Negocio.Departamento.SADepartamento;
import Negocio.Departamento.imp.SADepartamentoImp;
import Negocio.Empleado.SAEmpleado;
import Negocio.Empleado.imp.SAEmpleadoImp;
import Negocio.Evento.SAEvento;
import Negocio.Evento.imp.SAEventoImp;
import Negocio.Factoria.FactoriaSA;
import Negocio.Producto.SAProducto;
import Negocio.Producto.imp.SAProductoImp;
import Negocio.Venta.SAVenta;
import Negocio.Venta.imp.SAVentaImp;

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
public class FactoriaSAImp extends FactoriaSA {

	@Override
	public SAProducto crearSAProducto() {
		return new SAProductoImp();
	}

	@Override
	public SACliente crearSACliente() {
		return new SAClienteImp();
	}

	@Override
	public SAVenta crearSAVenta() {
		return new SAVentaImp();
	}
	
	@Override
	public SADepartamento crearSADepartamento(){
		return new SADepartamentoImp();
	}

	@Override
	public SAEmpleado crearSAEmpleado() {
		return new SAEmpleadoImp();
	}

	@Override
	public SAEvento crearSAEvento() {
		return new SAEventoImp();
	}
}