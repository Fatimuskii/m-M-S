/**
 * 
 */
package Presentacion.Venta;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Venta.imp.TVenta;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Controlador.Controlador;
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
public class GUIMostrarVenta extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	JLabel label_IdVenta;
	JLabel label_idCliente;
	JLabel label_fecha;
	JLabel label_precioTotal;
	private TVenta ventaSeleccionada = null;

	private GUIMostrarFactura gUIMostrarFactura;

	public GUIMostrarVenta() {
		super();
		contentPane = new JPanel();
		// contentPane.setVisible(true);
		gUIMostrarFactura= new GUIMostrarFactura();
		setResizable(false);
		initGUI();
	}

	public void initGUI() {

		setType(Type.POPUP);
		setTitle("Venta");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 254, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDatosDeVenta = new JLabel("DATOS DE VENTA");
		lblDatosDeVenta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDeVenta.setBounds(41, 31, 150, 14);
		contentPane.add(lblDatosDeVenta);

		JLabel lblIdVenta = new JLabel("Id Venta: ");
		lblIdVenta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdVenta.setBounds(41, 69, 84, 14);
		contentPane.add(lblIdVenta);

		label_IdVenta = new JLabel("");
		label_IdVenta.setBounds(135, 71, 56, 14);
		contentPane.add(label_IdVenta);

		JLabel lblIdCliente = new JLabel("Id Cliente:");
		lblIdCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdCliente.setBounds(41, 99, 84, 14);
		contentPane.add(lblIdCliente);

		label_idCliente = new JLabel("");
		label_idCliente.setBounds(137, 101, 54, 14);
		contentPane.add(label_idCliente);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setBounds(41, 124, 73, 14);
		contentPane.add(lblFecha);

		label_fecha = new JLabel("");
		label_fecha.setBounds(108, 126, 83, 14);
		contentPane.add(label_fecha);

		JLabel lblPrecio = new JLabel("Total:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecio.setBounds(41, 149, 46, 14);
		contentPane.add(lblPrecio);

		label_precioTotal = new JLabel("");
		label_precioTotal.setBounds(118, 149, 73, 14);
		contentPane.add(label_precioTotal);

		JButton btnVerFactura = new JButton("Ver Factura");
		btnVerFactura.setBounds(65, 189, 101, 29);
		btnVerFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance()
						.accion(new Contexto(Events.MOSTRAR_FACTURA, getVentaSeleccionada().getIdVenta()));
			}
		});
		contentPane.add(btnVerFactura);

	}

	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case (Events.BUSCAR_VENTA_OK):
			ventaSeleccionada = (TVenta) contexto.getDato();

			String id = Integer.toString(ventaSeleccionada.getIdVenta());
			String idCli = Integer.toString(ventaSeleccionada.getIdCliente());
			String fecha = ventaSeleccionada.getFecha().toString();
			String precio = Double.toString(ventaSeleccionada.getprecioTotal());

			label_IdVenta.setText(id);
			label_idCliente.setText(idCli);
			label_fecha.setText(fecha);
			label_precioTotal.setText(precio + "€");
			break;
		case (Events.BUSCAR_VENTA_KO):
			JOptionPane.showMessageDialog(new JFrame(), "Vaya, algo ha ido mal. No se puede mostrar los datos",
					"Mostrar Venta", JOptionPane.ERROR_MESSAGE);
			break;
		case (Events.MOSTRAR_FACTURA_OK):
			gUIMostrarFactura.limpiarGUI();
			gUIMostrarFactura.actualizar(contexto);
			gUIMostrarFactura.setVisible(true);
			break;
		case(Events.MOSTRAR_FACTURA_KO):
			gUIMostrarFactura.limpiarGUI();
		JOptionPane.showMessageDialog(new JFrame(), "Vaya, algo ha ido mal. No se ha podido generar la factura",
				"Mostrar Factura", JOptionPane.ERROR_MESSAGE);
		
		}

	}

	public TVenta getVentaSeleccionada() {
		return this.ventaSeleccionada;
	}

	public void limpiarGUI() {
		label_IdVenta.setText("");
		label_idCliente.setText("");
		label_fecha.setText("");
		label_precioTotal.setText("");
	}

}
