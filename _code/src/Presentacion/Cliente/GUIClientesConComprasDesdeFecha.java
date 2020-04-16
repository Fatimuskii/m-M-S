/**
 * 
 */
package Presentacion.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Integracion.Query.TQuery;
import Negocio.Cliente.imp.TCliente;
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
public class GUIClientesConComprasDesdeFecha extends GUICliente{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Nombre", "DNI", "email", "telefono"};
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField textField;
	
	public GUIClientesConComprasDesdeFecha(){
		super();
		initGUI();
	}
	
	@SuppressWarnings("serial")
	private void initGUI(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 49, 614, 177);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column){
				return false;
			}
		};
		
		tableModel.setColumnCount(0);

		for (int i = 0; i < columnNames.length; ++i) {
			tableModel.addColumn(columnNames[i]);
		}
		
		table.setModel(tableModel);
		
		JLabel lblFecha = new JLabel("Fecha (yyyy-mm-dd):");
		lblFecha.setBounds(244, 11, 136, 14);
		contentPane.add(lblFecha);
		
		textField = new JTextField();
		textField.setBounds(390, 8, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 614, 2);
		contentPane.add(separator);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					java.sql.Date fecha;
					fecha = Date.valueOf(textField.getText());
					
					TQuery tQuery = new TQuery(fecha);
					clearData();
					Controlador.getInstance().accion(new Contexto(Events.CLIENTES_CON_COMPRAS_DESDE_FECHA, tQuery));
				
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(533, 7, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(504, 227, 120, 23);
		contentPane.add(btnAceptar);
	}
	
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
		table.setEnabled(false);
		this.textField.setText("");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA_OK:
			tableModel.setRowCount(0);
			table.setEnabled(true);
			ArrayList<TCliente> clientes = (ArrayList<TCliente>) contexto.getDato();
			if(clientes.size()==0){
				JOptionPane.showMessageDialog(null, "No hay clientes con compras desde la fecha indicada");
			}
			for (int i = 0; i < clientes.size(); i++) {

				tableModel.insertRow(i, new Object[] { 
						i+1,
						clientes.get(i).getIdCliente(),
						clientes.get(i).getNombre(),
						clientes.get(i).getDNI(),
						clientes.get(i).getEmail(),
						clientes.get(i).getTelefono()
						});
				

			}
			table.setModel(tableModel);
			break;
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar los clientes", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		}
		
	}
}