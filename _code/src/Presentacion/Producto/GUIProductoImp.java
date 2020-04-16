/**
 * 
 */
package Presentacion.Producto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Controlador.Controlador;

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
public class GUIProductoImp extends GUIProducto {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private GUIAltaProducto gUIAltaProducto;
	private GUIBajaProducto gUIBajaProducto;
	private GUIModificarProducto gUIModificarProducto;
	private GUIBuscarProducto gUIBuscarProducto;
	private GUIListarProductos gUIListarProductos;
	private GUIBuscarProductosPorPrecio gUIbuscarProductosPorPrecio;
	private GUIProductoMasCompradoPorUnCliente gUIProductoMasCompradoPorUnCliente;
	
	private JPanel contentPane;
	JButton btnAltaProducto;
	JButton btnBajaProducto;
	JButton btnModificarProducto;
	JButton btnBuscarProducto;
	JButton btnListarProductos;
	JButton btnBuscarProductoPrecio;
	JButton btnBuscarProductosMasCompradoCliente;
	
	
	public GUIProductoImp(){
		super();
		
		gUIAltaProducto = new GUIAltaProducto();
		gUIBajaProducto = new GUIBajaProducto();
		gUIModificarProducto = new GUIModificarProducto();
		gUIBuscarProducto = new GUIBuscarProducto();
		gUIListarProductos = new GUIListarProductos();
		gUIbuscarProductosPorPrecio = new GUIBuscarProductosPorPrecio();
		gUIProductoMasCompradoPorUnCliente = new GUIProductoMasCompradoPorUnCliente(); 
		
		setResizable(false);
		initGUI();
	}
		
		
	private void initGUI() {
		this.setTitle("PRODUCTOS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170,230,100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAltaProducto = new JButton("Alta Producto");
		btnAltaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAltaProducto.clearData();
				gUIAltaProducto.setVisible(true); 
			}
		});
		btnAltaProducto.setBounds(10, 11, 200, 45);
		contentPane.add(btnAltaProducto);
		
		btnBajaProducto = new JButton("Baja Producto");
		btnBajaProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBajaProducto.clearData(); 
				gUIBajaProducto.setVisible(true); 
			}
		});
		btnBajaProducto.setBounds(224, 11, 200, 45);
		contentPane.add(btnBajaProducto);
		
		btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModificarProducto.clearData();
				gUIModificarProducto.setVisible(true);
			}
		});
		btnModificarProducto.setBounds(10, 67, 200, 45);
		contentPane.add(btnModificarProducto);
		
		btnBuscarProducto = new JButton("Buscar Producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBuscarProducto.clearData();
				gUIBuscarProducto.setVisible(true);
			}
		});
		btnBuscarProducto.setBounds(224, 67, 200, 45);
		contentPane.add(btnBuscarProducto);
		
		btnListarProductos = new JButton("Listar Productos");
		btnListarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIListarProductos.clearData();
				gUIListarProductos.setVisible(true);
				Controlador.getInstance().accion(new Contexto(Events.LISTAR_PRODUCTOS, null));
				gUIListarProductos.toFront();
			}
		});
		btnListarProductos.setBounds(10, 123, 200, 45);
		contentPane.add(btnListarProductos);
		
		btnBuscarProductoPrecio = new JButton("Buscar Producto por Precio");
		btnBuscarProductoPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIbuscarProductosPorPrecio.clearData();
				gUIbuscarProductosPorPrecio.setVisible(true);
			}
		});
		btnBuscarProductoPrecio.setBounds(224, 123, 200, 45);
		contentPane.add(btnBuscarProductoPrecio);
		
		btnBuscarProductosMasCompradoCliente = new JButton("Buscar Productos más comprados por un Cliente");
		btnBuscarProductosMasCompradoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIProductoMasCompradoPorUnCliente.clearData();
				gUIProductoMasCompradoPorUnCliente.setVisible(true);
			}
		});
		btnBuscarProductosMasCompradoCliente.setBounds(10, 179, 414, 45);
		contentPane.add(btnBuscarProductosMasCompradoCliente);
	}


	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_PRODUCTO_OK:
			gUIAltaProducto.actualizar(contexto);
			break;
		case Events.ALTA_PRODUCTO_KO:
			gUIAltaProducto.actualizar(contexto);
			break;
		case Events.LISTAR_PRODUCTOS_OK:
			gUIListarProductos.actualizar(contexto);
			break;
		case Events.LISTAR_PRODUCTOS_KO:
			gUIListarProductos.actualizar(contexto);
			break;
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_OK:
			gUIProductoMasCompradoPorUnCliente.actualizar(contexto);
			break;
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_KO:
			gUIProductoMasCompradoPorUnCliente.actualizar(contexto);
			break;
		case Events.BUSCAR_PRODUCTOS_POR_PRECIO_OK:
			gUIbuscarProductosPorPrecio.actualizar(contexto);
			break;
		case Events.BUSCAR_PRODUCTOS_POR_PRECIO_KO:
			gUIbuscarProductosPorPrecio.actualizar(contexto);
			break;
		case Events.BAJA_PRODUCTO_OK:
			gUIBajaProducto.actualizar(contexto);
			break;
		case Events.BAJA_PRODUCTO_KO:
			gUIBajaProducto.actualizar(contexto);
			break;
		case Events.BUSCAR_PRODUCTO_OK:
			gUIBuscarProducto.actualizar(contexto);
			break;
		case Events.BUSCAR_PRODUCTO_KO:
			gUIBuscarProducto.actualizar(contexto);
			break;
		case Events.BUSCAR_MODIFICAR_PRODUCTO_OK:
			gUIModificarProducto.actualizar(contexto);
			break;
		case Events.BUSCAR_MODIFICAR_PRODUCTO_KO:
			gUIModificarProducto.actualizar(contexto);
			break;
		case Events.MODIFICAR_PRODUCTO_OK:
			gUIModificarProducto.actualizar(contexto);
			break;
		case Events.MODIFICAR_PRODUCTO_KO:
			gUIModificarProducto.actualizar(contexto);
			break;
		}
		
	}
}