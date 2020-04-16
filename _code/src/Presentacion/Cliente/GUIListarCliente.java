/**
 * 
 */
package Presentacion.Cliente;

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

import Negocio.Cliente.imp.TCliente;
import Presentacion.Contexto;
import Presentacion.Events;

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
public class GUIListarCliente extends GUICliente {

	private static final long serialVersionUID = 1L;


	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPanel contentPane;
	
	private String[]columnNames ={"#", "Id", "Nombre", "Telefono", "Email", "DNI"};
	private DefaultTableModel tableModel;
	private JTable table;

	
	public GUIListarCliente() {
		super();
		initGUI();
	}
	
	private void initGUI(){
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
		table = new JTable();
		scrollPane.setViewportView(table);
		
		tableModel = new DefaultTableModel(){

			private static final long serialVersionUID = 1L;

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
	}
	
	@SuppressWarnings("unchecked")
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.LISTAR_CLIENTE_OK:
			ArrayList<TCliente> res = (ArrayList<TCliente>) contexto.getDato();
			if(res.size()==0){
				JOptionPane.showMessageDialog(null, "No hay clientes en la base de datos");
			}
			for (int i = 0; i < res.size(); i++) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
							res.get(i).getIdCliente(),
							res.get(i).getNombre(),
							res.get(i).getTelefono(),
							res.get(i).getEmail(),
							res.get(i).getDNI()});
				}
				
			table.setModel(tableModel);
			break;
			
		case Events.LISTAR_CLIENTE_KO:
			JOptionPane.showMessageDialog(null, "Error al listar los clientes", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}