/**
 * 
 */
package Presentacion.Venta;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Venta.imp.LineaVenta;
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
public class GUIModificarVenta extends JFrame implements GUI {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TVenta ventaActual;
	private JTable tabla;
	private DefaultTableModel model;
	private JTextField textField_idProd;
	private Object[] columnNames = { "#", "IdProducto", "Cantidad" };
	private JSpinner spinner;

	public GUIModificarVenta(TVenta tVentaActual) {
		super();
		contentPane = new JPanel();
		this.ventaActual = tVentaActual;
		textField_idProd = new JTextField();
		setResizable(false);
		initGUI();
	}

	public void initGUI() {

		setTitle("A\u00F1adir/quitar productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 290);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblProductosEnVenta = new JLabel("Productos en Venta actual:");
		lblProductosEnVenta.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProductosEnVenta.setBounds(51, 19, 192, 14);
		contentPane.add(lblProductosEnVenta);

		// Tablaa ---

		limpiarTablaActual();
		HashMap<Integer, LineaVenta> lineas = this.ventaActual.getLineaVentas();
		Collection<LineaVenta> values = lineas.values();
		Iterator<LineaVenta> iterator = values.iterator();
		LineaVenta linea;
		while (iterator.hasNext()) {

			linea = iterator.next();
			model.insertRow(model.getRowCount(),
					new Object[] { model.getRowCount() + 1, linea.getIdProducto(), linea.getCantidad() });

		}

		// ---
		// Producto Informacion
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdProducto.setBounds(381, 86, 82, 14);
		contentPane.add(lblIdProducto);

		textField_idProd = new JTextField();
		textField_idProd.setBounds(469, 85, 45, 20);
		contentPane.add(textField_idProd);
		textField_idProd.setColumns(10);

		// Cantidad Informacion
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(381, 125, 82, 14);
		contentPane.add(lblCantidad);

		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
		spinner.setBounds(469, 124, 45, 20);
		contentPane.add(spinner);

		// Boton Confirmar
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField_idProd.getText().equals("")) {

					try {
						int cantidad = (int) spinner.getValue();
						int idProduc = Integer.parseInt(textField_idProd.getText());
						int[] data = { idProduc, cantidad };
						Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_VENTA, data));
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un id producto", "Error",
							JOptionPane.ERROR_MESSAGE);
			}

		});
		btnConfirmar.setBounds(432, 203, 107, 25);
		contentPane.add(btnConfirmar);
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtrs.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAtrs.setBounds(340, 203, 82, 25);
		contentPane.add(btnAtrs);
	}

	@Override
	public void actualizar(Contexto contexto) {

		switch (contexto.getEvento()) {
		case Events.MODIFICAR_VENTA_OK:
			limpiarTablaActual();
			HashMap<Integer, LineaVenta> lineas = this.ventaActual.getLineaVentas();
			Collection<LineaVenta> values = lineas.values();
			Iterator<LineaVenta> iterator = values.iterator();
			LineaVenta linea;
			while (iterator.hasNext()) {

				linea = iterator.next();
				model.insertRow(model.getRowCount(),
						new Object[] { model.getRowCount() + 1, linea.getIdProducto(), linea.getCantidad(), });
			}

			tabla.setModel(model);
			break;
		case Events.MODIFICAR_VENTA_KO:
			JOptionPane.showMessageDialog(new JFrame(),
					"Vaya, algo ha ido mal. Comprueba si el producto seleccionado existe.", "Modificar Ventas",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	public void limpiarGUI() {
		// limpiarTablaActual();
		textField_idProd.setText("");
		spinner.setValue(0);

	}

	public void limpiarTablaActual() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 61, 298, 158);
		contentPane.add(scrollPane);
		tabla = new JTable();
		scrollPane.setViewportView(tabla);

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
		tabla.setModel(model);

	}
}