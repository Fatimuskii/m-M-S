/**
 * 
 */
package Presentacion.Evento;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Negocio.Evento.imp.TEvento;
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
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUIListarEventos extends GUIEvento{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 608081194963493921L;
	
	private JPanel contentPane;
	private JTable table;
	private String[] columnNames = { "#", "IdEvento", "Nombre","Direccion", "Aforo" };
	private DefaultTableModel tableModel;

	public GUIListarEventos(){
		super();
		initGUI();
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 604, 208);
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
		btnAceptar.setBounds(504, 237, 120, 23);
		contentPane.add(btnAceptar);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		tableModel.setRowCount(0);
		table.setModel(tableModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.LISTAR_EVENTOS_OK:

			List<TEvento> res = (List<TEvento>) contexto.getDato();
			if (res.size() == 0)
				JOptionPane.showMessageDialog(null, "No existen eventos");

			for (int i = 0; i < res.size(); i++) {

				tableModel.insertRow(i, new Object[] { i + 1, res.get(i).getId(), res.get(i).getNombre(),
						res.get(i).getDireccion(), res.get(i).getAforo() });

			}
			table.setModel(tableModel);
			break;

		case Events.LISTAR_EVENTOS_KO:
			JOptionPane.showMessageDialog(null, "Error al listar los eventos", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}