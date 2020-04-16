package Presentacion.Venta;

import java.awt.Font;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Producto.imp.TProducto;
import Negocio.Venta.imp.LineaVenta;
import Negocio.Venta.imp.TMostrarFactura;
import Presentacion.Contexto;
import Presentacion.View.GUI;

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
public class GUIMostrarFactura extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TMostrarFactura factura = null;
	private JPanel contentPane;
	private DefaultTableModel model;
	private Object[] columnNames = { "#", "IdProducto", "Producto", "Cantidad", "Precio/Unidad", "Total" };

	private JTable tablaLineaVentas;
	JLabel Id_venta;
	JLabel nombreCliente;
	JLabel cliente_dni;
	JLabel precioVenta;
	JLabel fecha;
	JScrollPane scrollPane;

	public GUIMostrarFactura() {
		super();
		contentPane = new JPanel();
		setResizable(false);
		initGUI();

	}

	public void initGUI() {
		setTitle("Factura");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFacturaDeVenta = new JLabel("FACTURA DE VENTA CON ID: ");
		lblFacturaDeVenta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblFacturaDeVenta.setBounds(35, 29, 242, 14);
		contentPane.add(lblFacturaDeVenta);

		Id_venta = new JLabel("");
		Id_venta.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		Id_venta.setBounds(287, 31, 46, 14);
		contentPane.add(Id_venta);

		JLabel lblCliente = new JLabel("Cliente: ");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCliente.setBounds(35, 73, 55, 14);
		contentPane.add(lblCliente);

		nombreCliente = new JLabel("");
		nombreCliente.setFont(new Font("Tahoma", Font.ITALIC, 12));
		nombreCliente.setBounds(100, 73, 77, 14);
		contentPane.add(nombreCliente);

		JLabel lblConDni = new JLabel("con DNI:");
		lblConDni.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConDni.setBounds(187, 73, 60, 14);
		contentPane.add(lblConDni);

		cliente_dni = new JLabel("");
		cliente_dni.setFont(new Font("Tahoma", Font.ITALIC, 12));
		cliente_dni.setBounds(257, 74, 90, 14);
		contentPane.add(cliente_dni);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 112, 284, 127);
		contentPane.add(scrollPane);

		tablaLineaVentas = new JTable();
		scrollPane.setViewportView(tablaLineaVentas);
		model = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.setColumnIdentifiers(columnNames);
		tablaLineaVentas.setModel(model);

		JLabel lblTotalPagado = new JLabel("Total pagado:");
		lblTotalPagado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalPagado.setBounds(128, 259, 91, 14);
		contentPane.add(lblTotalPagado);

		precioVenta = new JLabel("");
		precioVenta.setFont(new Font("Tahoma", Font.ITALIC, 12));
		precioVenta.setBounds(229, 259, 60, 14);
		contentPane.add(precioVenta);

		JLabel lblFechaDeCompra = new JLabel("Fecha de compra:");
		lblFechaDeCompra.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblFechaDeCompra.setBounds(26, 293, 99, 14);
		contentPane.add(lblFechaDeCompra);

		fecha = new JLabel("");
		fecha.setFont(new Font("Tahoma", Font.ITALIC, 12));
		fecha.setBounds(128, 293, 91, 14);
		contentPane.add(fecha);
	}

	@Override
	public void actualizar(Contexto contexto) {
		factura = (TMostrarFactura) contexto.getDato();

		
		Id_venta.setText("" + factura.gettVenta().getIdVenta());
		nombreCliente.setText(factura.gettCLiente().getNombre());
		cliente_dni.setText(factura.gettCLiente().getDNI());
		precioVenta.setText(factura.gettVenta().getprecioTotal() + " €");
		fecha.setText(factura.gettVenta().getFecha().toString());
		HashMap<Integer, LineaVenta> lineas = factura.getLineaVentas();
		Collection<LineaVenta> values = lineas.values();
		Iterator<LineaVenta> iterator = values.iterator();

		LineaVenta linea;
		int i = 0;
		float precioUnitario=0;
		while (iterator.hasNext()) {
			linea = iterator.next();
			
			TProducto producto = factura.gettProductos().get(i);
			if(linea.getCantidad()>0){
				precioUnitario = linea.getPrecio()/linea.getCantidad();
				model.insertRow(model.getRowCount(), new Object[] { model.getRowCount() + 1, linea.getIdProducto(),
						producto.getNombre(), linea.getCantidad(), precioUnitario, linea.getPrecio() });
			}

			
			++i;
		}

	}

	public void limpiarGUI() {
		Id_venta.setText("");
		nombreCliente.setText("");
		cliente_dni.setText("");
		precioVenta.setText("");
		tablaLineaVentas = new JTable();
		scrollPane.setViewportView(tablaLineaVentas);
		model = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.setColumnIdentifiers(columnNames);
		tablaLineaVentas.setModel(model);

		fecha.setText("");
	}

}
