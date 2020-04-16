/**
 * 
 */
package Presentacion;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Ana Álava Papí
 * @author Óscar Canive Huguet
 * @author David Domínguez Gutiérrez
 * @author Fátima García Delgado
 * @author Marina Lozano Lahuerta
 * @author Paula Sánchez de la Nieta Gómez
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class Events {

	public static final int GUI_PRINCIPAL = 100;

	public static final int CREAR_GUI_CLIENTE = 200;
	public static final int CREAR_GUI_PRODUCTO = 300;
	public static final int CREAR_GUI_VENTA = 400;
	public static final int CREAR_GUI_EMPLEADO = 500;
	public static final int CREAR_GUI_EVENTO = 600;
	public static final int CREAR_GUI_DEPARTAMENTO = 700;

	// PRODUCTO
	public static final int ALTA_PRODUCTO = 301;
	public static final int BAJA_PRODUCTO = 302;
	public static final int BUSCAR_MODIFICAR_PRODUCTO = 303;
	public static final int MODIFICAR_PRODUCTO = 304;
	public static final int BUSCAR_PRODUCTO = 305;
	public static final int LISTAR_PRODUCTOS = 306;
	public static final int BUSCAR_PRODUCTOS_POR_PRECIO = 307;
	public static final int PRODUCTO_MAS_COMPRADO_POR_CLIENTE = 308;

	public static final int ALTA_PRODUCTO_OK = 309;
	public static final int ALTA_PRODUCTO_KO = 310;
	public static final int BAJA_PRODUCTO_OK = 311;
	public static final int BAJA_PRODUCTO_KO = 312;
	public static final int BUSCAR_MODIFICAR_PRODUCTO_OK = 313;
	public static final int BUSCAR_MODIFICAR_PRODUCTO_KO = 314;
	public static final int MODIFICAR_PRODUCTO_OK = 315;
	public static final int MODIFICAR_PRODUCTO_KO = 316;
	public static final int BUSCAR_PRODUCTO_OK = 317;
	public static final int BUSCAR_PRODUCTO_KO = 318;
	public static final int LISTAR_PRODUCTOS_OK = 319;
	public static final int LISTAR_PRODUCTOS_KO = 320;
	public static final int BUSCAR_PRODUCTOS_POR_PRECIO_OK = 321;
	public static final int BUSCAR_PRODUCTOS_POR_PRECIO_KO = 322;
	public static final int PRODUCTO_MAS_COMPRADO_POR_CLIENTE_OK = 323;
	public static final int PRODUCTO_MAS_COMPRADO_POR_CLIENTE_KO = 324;

	// VENTA
	public static final int ALTA_VENTA = 401;
	public static final int MODIFICAR_VENTA = 402;
	public static final int BUSCAR_VENTA = 403;
	public static final int LISTAR_VENTAS = 404;
	public static final int ABRIR_VENTA = 405;
	public static final int CERRAR_VENTA = 406;
	public static final int DEVOLUCION = 407;
	public static final int MOSTRAR_FACTURA = 408;

	public static final int ABRIR_VENTA_OK = 410;
	public static final int ABRIR_VENTA_KO = 411;
	public static final int CERRAR_VENTA_OK = 412;
	public static final int CERRAR_VENTA_KO = 413;
	public static final int BUSCAR_VENTA_OK = 414;
	public static final int BUSCAR_VENTA_KO = 415;
	public static final int MODIFICAR_VENTA_OK = 416;
	public static final int MODIFICAR_VENTA_KO = 417;
	public static final int LISTAR_VENTAS_OK = 418;
	public static final int LISTAR_VENTAS_KO = 419;
	public static final int DEVOLUCION_OK = 420;
	public static final int DEVOLUCION_KO = 421;
	public static final int MOSTRAR_FACTURA_OK = 422;
	public static final int MOSTRAR_FACTURA_KO = 423;

	// CLIENTE
	public static final int ALTA_CLIENTE = 501;
	public static final int BAJA_CLIENTE = 502;
	public static final int MODIFICAR_CLIENTE = 503;
	public static final int BUSCAR_CLIENTE_ID = 504;
	public static final int LISTAR_CLIENTE = 505;
	public static final int BUSCAR_CLIENTE_DNI = 506;
	public static final int BUSCAR_CLIENTE = 507;
	public static final int CLIENTES_CON_COMPRAS_DESDE_FECHA = 508;
	public static final int MODIFICAR_CLIENTE_BUSCAR = 509;

	public static final int MODIFICAR_CLIENTE_OK = 511;
	public static final int MODIFICAR_CLIENTE_KO = 512;
	public static final int BAJA_CLIENTE_OK = 513;
	public static final int BAJA_CLIENTE_KO = 514;
	public static final int BUSCAR_CLIENTE_OK = 515;
	public static final int BUSCAR_CLIENTE_KO = 516;
	public static final int LISTAR_CLIENTE_OK = 517;
	public static final int LISTAR_CLIENTE_KO = 518;
	public static final int CLIENTES_CON_COMPRAS_DESDE_FECHA_OK = 519;
	public static final int CLIENTES_CON_COMPRAS_DESDE_FECHA_KO = 520;
	public static final int BUSCAR_CLIENTE_DNI_OK = 521;
	public static final int BUSCAR_CLIENTE_DNI_KO = 522;
	public static final int ALTA_CLIENTE_OK = 523;
	public static final int ALTA_CLIENTE_KO = 524;
	public static final int MODIFICAR_CLIENTE_BUSCAR_OK = 525;
	public static final int MODIFICAR_CLIENTE_BUSCAR_KO = 526;

	// EMPLEADO
	public static final int ALTA_EMPLEADO = 801;
	public static final int BAJA_EMPLEADO = 802;
	public static final int BUSCAR_EMPLEADO = 803;
	public static final int BUSCAR_MODIFICAR_EMPLEADO = 804;
	public static final int MODIFICAR_EMPLEADO = 805;
	public static final int LISTAR_EMPLEADO = 806;
	public static final int BUSCAR_DEPARTAMENTO_EMPLEADO = 807;
	public static final int BUSCAR_EMPLEADO_POR_DNI = 808;

	public static final int ALTA_EMPLEADO_OK = 820;
	public static final int ALTA_EMPLEADO_KO = 821;
	public static final int BAJA_EMPLEADO_OK = 822;
	public static final int BAJA_EMPLEADO_KO = 823;
	public static final int BUSCAR_EMPLEADO_OK = 824;
	public static final int BUSCAR_EMPLEADO_KO = 825;
	public static final int BUSCAR_MODIFICAR_EMPLEADO_OK = 826;
	public static final int BUSCAR_MODIFICAR_EMPLEADO_KO = 827;
	public static final int MODIFICAR_EMPLEADO_OK = 828;
	public static final int MODIFICAR_EMPLEADO_KO = 829;
	public static final int LISTAR_EMPLEADO_OK = 830;
	public static final int LISTAR_EMPLEADO_KO = 831;
	public static final int BUSCAR_DEPARTAMENTO_EMPLEADO_OK = 832;
	public static final int BUSCAR_DEPARTAMENTO_EMPLEADO_KO = 833;
	public static final int BUSCAR_EMPLEADO_POR_DNI_OK = 834;
	public static final int BUSCAR_EMPLEADO_POR_DNI_KO = 835;

	// EVENTO
	public static final int ALTA_EVENTO = 601;
	public static final int BAJA_EVENTO = 602;
	public static final int BUSCAR_EVENTO = 603;
	public static final int BUSCAR_MODIFICAR_EVENTO = 604;
	public static final int MODIFICAR_EVENTO = 605;
	public static final int LISTAR_EVENTOS = 606;
	public static final int AÑADIR_EMPLEADO_EVENTO = 607;
	public static final int ELIMINAR_EMPLEADO_EVENTO = 608;
	public static final int MOSTRAR_EMPLEADOS_EVENTO = 609;

	public static final int ALTA_EVENTO_OK = 620;
	public static final int ALTA_EVENTO_KO = 621;
	public static final int BAJA_EVENTO_OK = 622;
	public static final int BAJA_EVENTO_KO = 623;
	public static final int BUSCAR_EVENTO_OK = 624;
	public static final int BUSCAR_EVENTO_KO = 625;
	public static final int BUSCAR_MODIFICAR_EVENTO_OK = 626;
	public static final int BUSCAR_MODIFICAR_EVENTO_KO = 627;
	public static final int MODIFICAR_EVENTO_OK = 628;
	public static final int MODIFICAR_EVENTO_KO = 629;
	public static final int LISTAR_EVENTOS_OK = 630;
	public static final int LISTAR_EVENTOS_KO = 631;
	public static final int AÑADIR_EMPLEADO_EVENTO_OK = 632;
	public static final int AÑADIR_EMPLEADO_EVENTO_KO = 633;
	public static final int ELIMINAR_EMPLEADO_EVENTO_OK = 634;
	public static final int ELIMINAR_EMPLEADO_EVENTO_KO = 635;
	public static final int MOSTRAR_EMPLEADOS_EVENTO_OK = 636;
	public static final int MOSTRAR_EMPLEADOS_EVENTO_KO = 637;

	// DEPARTAMENTO
	public static final int ALTA_DEPARTAMENTO = 701;
	public static final int BAJA_DEPARTAMENTO = 702;
	public static final int BUSCAR_DEPARTAMENTO = 703;
	public static final int LISTAR_DEPARTAMENTOS = 704;
	public static final int MODIFICAR_DEPARTAMENTO = 705;
	public static final int CALCULAR_NOMINAS_DEPARTAMENTO = 706;

	public static final int ALTA_DEPARTAMENTO_OK = 710;
	public static final int ALTA_DEPARTAMENTO_KO = 711;
	public static final int BAJA_DEPARTAMENTO_OK = 712;
	public static final int BAJA_DEPARTAMENTO_KO = 713;
	public static final int BUSCAR_DEPARTAMENTO_OK = 714;
	public static final int BUSCAR_DEPARTAMENTO_KO = 715;
	public static final int LISTAR_DEPARTAMENTO_OK = 716;
	public static final int LISTAR_DEPARTAMENTO_KO = 717;
	public static final int MODIFICAR_DEPARTAMENTO_OK = 718;
	public static final int MODIFICAR_DEPARTAMENTO_KO = 719;
	public static final int CALCULAR_NOMINAS_DEPARTAMENTO_OK = 720;
	public static final int CALCULAR_NOMINAS_DEPARTAMENTO_KO = 721;

}