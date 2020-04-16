/**
 * 
 */
package Presentacion.ServiceWorker.Command.FactoriaComando;

import Presentacion.Events;
import Presentacion.ServiceWorker.Command.Command;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoAltaCliente;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoBajaCliente;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoBuscarCliente;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoBuscarClienteDNI;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoListarCliente;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoModificarCliente;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoModificarClienteBuscar;
import Presentacion.ServiceWorker.Command.ComandoCliente.ComandoMostrarClientesConComprasDesdeFecha;
import Presentacion.ServiceWorker.Command.ComandoDepartamento.ComandoAltaDepartamento;
import Presentacion.ServiceWorker.Command.ComandoDepartamento.ComandoBajaDepartamento;
import Presentacion.ServiceWorker.Command.ComandoDepartamento.ComandoBuscarDepartamento;
import Presentacion.ServiceWorker.Command.ComandoDepartamento.ComandoCalcularNominasDepartamento;
import Presentacion.ServiceWorker.Command.ComandoDepartamento.ComandoListarDepartamento;
import Presentacion.ServiceWorker.Command.ComandoDepartamento.ComandoModificarDepartamento;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoAltaEmpleado;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoBajaEmpleado;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoBuscarEmpleado;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoBuscarEmpleadoPorDNI;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoListarEmpleado;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoModificarEmpleado;
import Presentacion.ServiceWorker.Command.ComandoEmpleado.ComandoModificarEmpleadoBuscar;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoAltaEvento;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoAñadirEmpleadoAEvento;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoBajaEvento;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoBuscarEvento;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoEliminarEmpleadoDeEvento;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoListarEventos;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoModificarEvento;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoModificarEventoBuscar;
import Presentacion.ServiceWorker.Command.ComandoEvento.ComandoMostrarEmpleadosDeEvento;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoAltaProducto;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoBajaProducto;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoBuscarProducto;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoBuscarProductosPorPrecio;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoListarProductos;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoModificarProducto;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoModificarProductoBuscar;
import Presentacion.ServiceWorker.Command.ComandoProducto.ComandoProductoMasCompradoPorUnCliente;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoAbrirVenta;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoBuscarVenta;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoCerrarVenta;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoDevolucionVenta;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoListarVentas;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoModificarVenta;
import Presentacion.ServiceWorker.Command.ComandoVenta.ComandoMostrarFactura;

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
public class FactoriaComandoImp extends FactoriaComando {

	@Override
	public Command generarCommand(int event) {
		switch (event) {
		// PRODUCTO
		case Events.ALTA_PRODUCTO:
			return new ComandoAltaProducto();
		case Events.BAJA_PRODUCTO:
			return new ComandoBajaProducto();
		case Events.BUSCAR_PRODUCTO:
			return new ComandoBuscarProducto();
		case Events.LISTAR_PRODUCTOS:
			return new ComandoListarProductos();
		case Events.MODIFICAR_PRODUCTO:
			return new ComandoModificarProducto();
		case Events.BUSCAR_MODIFICAR_PRODUCTO:
			return new ComandoModificarProductoBuscar();
		case Events.BUSCAR_PRODUCTOS_POR_PRECIO:
			return new ComandoBuscarProductosPorPrecio();
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE:
			return new ComandoProductoMasCompradoPorUnCliente();

		// VENTA
		case Events.ABRIR_VENTA:
			return new ComandoAbrirVenta();
		case Events.CERRAR_VENTA:
			return new ComandoCerrarVenta();
		case Events.BUSCAR_VENTA:
			return new ComandoBuscarVenta();
		case Events.LISTAR_VENTAS:
			return new ComandoListarVentas();
		case Events.MODIFICAR_VENTA:
			return new ComandoModificarVenta();
		case Events.DEVOLUCION:
			return new ComandoDevolucionVenta();
		case Events.MOSTRAR_FACTURA:
			return new ComandoMostrarFactura();
			

		// CLIENTE
		case Events.ALTA_CLIENTE:
			return new ComandoAltaCliente();
		case Events.BAJA_CLIENTE:
			return new ComandoBajaCliente();
		case Events.MODIFICAR_CLIENTE:
			return new ComandoModificarCliente();
		case Events.BUSCAR_CLIENTE:
			return new ComandoBuscarCliente();
		case Events.BUSCAR_CLIENTE_DNI:
			return new ComandoBuscarClienteDNI();
		case Events.LISTAR_CLIENTE:
			return new ComandoListarCliente();
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA:
			return new ComandoMostrarClientesConComprasDesdeFecha();
		case Events.MODIFICAR_CLIENTE_BUSCAR:
			return new ComandoModificarClienteBuscar();
		
		//DEPARTAMENTO
		case Events.ALTA_DEPARTAMENTO:
			return new ComandoAltaDepartamento();
		case Events.BAJA_DEPARTAMENTO:
			return new ComandoBajaDepartamento();
		case Events.BUSCAR_DEPARTAMENTO:
			return new ComandoBuscarDepartamento();
		case Events.LISTAR_DEPARTAMENTOS:
			return new ComandoListarDepartamento();
		case Events.MODIFICAR_DEPARTAMENTO:
			return new ComandoModificarDepartamento();
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO:
			return new ComandoCalcularNominasDepartamento();
		
		//EMPLEADO
		case Events.ALTA_EMPLEADO:
			return new ComandoAltaEmpleado();
		case Events.BAJA_EMPLEADO:
			return new ComandoBajaEmpleado();
		case Events.LISTAR_EMPLEADO:
			return new ComandoListarEmpleado();
		case Events.BUSCAR_EMPLEADO:
			return new ComandoBuscarEmpleado();
		case Events.MODIFICAR_EMPLEADO:
			return new ComandoModificarEmpleado();
		case Events.BUSCAR_MODIFICAR_EMPLEADO:
			return new ComandoModificarEmpleadoBuscar();
		case Events.BUSCAR_EMPLEADO_POR_DNI:
			return new ComandoBuscarEmpleadoPorDNI();
		//falta BUSCAR_DEPARTAMENTO_EMPLEADO??
			
		//EVENTO
		case Events.ALTA_EVENTO:
			return new ComandoAltaEvento();
		case Events.BAJA_EVENTO:
			return new ComandoBajaEvento();
		case Events.BUSCAR_EVENTO:
			return new ComandoBuscarEvento();
		case Events.BUSCAR_MODIFICAR_EVENTO:
			return new ComandoModificarEventoBuscar();
		case Events.MODIFICAR_EVENTO:
			return new ComandoModificarEvento();
		case Events.LISTAR_EVENTOS:
			return new ComandoListarEventos();
		case Events.MOSTRAR_EMPLEADOS_EVENTO:
			return new ComandoMostrarEmpleadosDeEvento();
		case Events.AÑADIR_EMPLEADO_EVENTO:
			return new ComandoAñadirEmpleadoAEvento();
		case Events.ELIMINAR_EMPLEADO_EVENTO:
			return new ComandoEliminarEmpleadoDeEvento();
			
		default:
			return null;
		}

	}
}