/**
 * 
 */
package Presentacion.Venta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Venta.imp.TVenta;
import Presentacion.Contexto;
import Presentacion.Events;
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
public class GUIListarVentas extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Object[] columnNames = { "Fecha", "ID Venta", "ID Cliente", "Precio total" };

	private JTable tabla;
	private DefaultTableModel tableModel;

	public GUIListarVentas() {
		super();
		contentPane = new JPanel();
		// contentPane.setVisible(true);
		setResizable(false);
		initGUI();
	}

	public void initGUI() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 614, 205);
		contentPane.add(scrollPane);
		tabla = new JTable();
		scrollPane.setViewportView(tabla);

		tableModel = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		tableModel.setColumnCount(0);

		tableModel.setColumnIdentifiers(columnNames);
		tabla.setModel(tableModel);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(504, 227, 120, 23);
		contentPane.add(btnAceptar);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.LISTAR_VENTAS_OK:
			ArrayList<TVenta> res = (ArrayList<TVenta>) contexto.getDato();

			for (int i = 0; i < res.size(); i++) {
				tableModel.insertRow(i, new Object[] { res.get(i).getFecha().toString(), res.get(i).getIdVenta(),
						res.get(i).getIdCliente(), res.get(i).getprecioTotal()});
			}
			tabla.setModel(tableModel);
			break;
		case Events.LISTAR_VENTAS_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Vaya, algo ha ido mal...", "Listar Ventas",
					JOptionPane.ERROR_MESSAGE);
			break;
		}
		

	}

	public void limpiarGUI() {
		initGUI();
	}

}