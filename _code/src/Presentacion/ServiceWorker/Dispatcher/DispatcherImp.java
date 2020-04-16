/**
 * 
 */
package Presentacion.ServiceWorker.Dispatcher;

import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.Cliente.GUICliente;
import Presentacion.Departamento.GUIDepartamento;
import Presentacion.Empleado.GUIEmpleado;
import Presentacion.Evento.GUIEvento;
import Presentacion.Producto.GUIProducto;
import Presentacion.Venta.GUIVenta;
import Presentacion.View.GUIMain;

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
public class DispatcherImp extends Dispatcher {

	@Override
	public void generarVista(Contexto contexto) {
		int evento = contexto.getEvento();

		switch (evento) {

		case Events.GUI_PRINCIPAL:
			GUIMain.getInstance();
			break;

		// Producto
		case Events.CREAR_GUI_PRODUCTO:
			GUIProducto.getInstance().setVisible(true);
			break;
		case Events.ALTA_PRODUCTO_OK:
		case Events.ALTA_PRODUCTO_KO:
		case Events.LISTAR_PRODUCTOS_OK:
		case Events.LISTAR_PRODUCTOS_KO:
		case Events.BUSCAR_PRODUCTOS_POR_PRECIO_OK:
		case Events.BUSCAR_PRODUCTOS_POR_PRECIO_KO:
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_OK:
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_KO:
		case Events.BAJA_PRODUCTO_OK:
		case Events.BAJA_PRODUCTO_KO:
		case Events.BUSCAR_PRODUCTO_OK:
		case Events.BUSCAR_PRODUCTO_KO:
		case Events.BUSCAR_MODIFICAR_PRODUCTO_OK:
		case Events.BUSCAR_MODIFICAR_PRODUCTO_KO:
		case Events.MODIFICAR_PRODUCTO_OK:
		case Events.MODIFICAR_PRODUCTO_KO:
			GUIProducto.getInstance().actualizar(contexto);
			break;
			
		// Cliente
		case Events.CREAR_GUI_CLIENTE:
			GUICliente.getInstance().setVisible(true);
			break;
		case Events.ALTA_CLIENTE_OK:
		case Events.ALTA_CLIENTE_KO:
		case Events.BAJA_CLIENTE_OK:
		case Events.BAJA_CLIENTE_KO:
		case Events.MODIFICAR_CLIENTE_OK:
		case Events.MODIFICAR_CLIENTE_KO:
		case Events.MODIFICAR_CLIENTE_BUSCAR_OK:
		case Events.MODIFICAR_CLIENTE_BUSCAR_KO:
		case Events.BUSCAR_CLIENTE_OK:
		case Events.BUSCAR_CLIENTE_KO:
		case Events.LISTAR_CLIENTE_OK:
		case Events.LISTAR_CLIENTE_KO:
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA_OK:
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA_KO:
			GUICliente.getInstance().actualizar(contexto);
			break;	

		// Venta
		case Events.CREAR_GUI_VENTA:
			GUIVenta.getInstance().setVisible(true);
			break;
		case Events.ABRIR_VENTA_OK:
		case Events.ABRIR_VENTA_KO:
		case Events.BUSCAR_VENTA_OK:
		case Events.BUSCAR_VENTA_KO:
		case Events.LISTAR_VENTAS_OK:
		case Events.LISTAR_VENTAS_KO:
		case Events.MODIFICAR_VENTA_OK:
		case Events.MODIFICAR_VENTA_KO:
		case Events.CERRAR_VENTA_OK:
		case Events.CERRAR_VENTA_KO:
		case Events.DEVOLUCION_OK:
		case Events.DEVOLUCION_KO:
		case Events.MOSTRAR_FACTURA_OK:
		case Events.MOSTRAR_FACTURA_KO:
			GUIVenta.getInstance().actualizar(contexto);
			break;
			
		
			
		// Departamento
		case Events.CREAR_GUI_DEPARTAMENTO:
			GUIDepartamento.getInstance().setVisible(true);
			break;
		case Events.ALTA_DEPARTAMENTO_OK:
		case Events.ALTA_DEPARTAMENTO_KO:
		case Events.BAJA_DEPARTAMENTO_OK:
		case Events.BAJA_DEPARTAMENTO_KO:
		case Events.BUSCAR_DEPARTAMENTO_OK:
		case Events.BUSCAR_DEPARTAMENTO_KO:
		case Events.LISTAR_DEPARTAMENTO_OK:
		case Events.LISTAR_DEPARTAMENTO_KO:
		case Events.MODIFICAR_DEPARTAMENTO_OK:
		case Events.MODIFICAR_DEPARTAMENTO_KO:
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO_OK:
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO_KO:
			GUIDepartamento.getInstance().actualizar(contexto);
			break;
			
		//Empleado	
		case Events.CREAR_GUI_EMPLEADO:
			GUIEmpleado.getInstance().setVisible(true);
			break;
		case Events.ALTA_EMPLEADO_OK:
		case Events.ALTA_EMPLEADO_KO:
		case Events.BAJA_EMPLEADO_OK:
		case Events.BAJA_EMPLEADO_KO:
		case Events.BUSCAR_EMPLEADO_OK:
		case Events.BUSCAR_EMPLEADO_KO:
		case Events.MODIFICAR_EMPLEADO_OK:
		case Events.MODIFICAR_EMPLEADO_KO:
		case Events.LISTAR_EMPLEADO_OK:
		case Events.LISTAR_EMPLEADO_KO:
		case Events.BUSCAR_MODIFICAR_EMPLEADO_OK:
		case Events.BUSCAR_MODIFICAR_EMPLEADO_KO:
		case Events.BUSCAR_EMPLEADO_POR_DNI_OK:
		case Events.BUSCAR_EMPLEADO_POR_DNI_KO:
			GUIEmpleado.getInstance().actualizar(contexto);
			break;
		
		//Evento
		case Events.CREAR_GUI_EVENTO:
			GUIEvento.getInstance().setVisible(true);
			break;
		case Events.ALTA_EVENTO_OK:
		case Events.ALTA_EVENTO_KO:
		case Events.BAJA_EVENTO_OK:
		case Events.BAJA_EVENTO_KO:
		case Events.BUSCAR_EVENTO_OK:
		case Events.BUSCAR_EVENTO_KO:
		case Events.BUSCAR_MODIFICAR_EVENTO_OK:
		case Events.BUSCAR_MODIFICAR_EVENTO_KO:
		case Events.MODIFICAR_EVENTO_OK:
		case Events.MODIFICAR_EVENTO_KO:
		case Events.LISTAR_EVENTOS_OK:
		case Events.LISTAR_EVENTOS_KO:
		case Events.MOSTRAR_EMPLEADOS_EVENTO_OK:
		case Events.MOSTRAR_EMPLEADOS_EVENTO_KO:
		case Events.AÑADIR_EMPLEADO_EVENTO_OK:
		case Events.AÑADIR_EMPLEADO_EVENTO_KO:
		case Events.ELIMINAR_EMPLEADO_EVENTO_OK:
		case Events.ELIMINAR_EMPLEADO_EVENTO_KO:
			GUIEvento.getInstance().actualizar(contexto);
			break;
		}

	}

}