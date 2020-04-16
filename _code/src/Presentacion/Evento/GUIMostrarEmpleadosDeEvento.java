package Presentacion.Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Negocio.Evento.imp.TParticipa;
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
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUIMostrarEmpleadosDeEvento extends GUIEvento {

		
		/**
	 * 
	 */
	private static final long serialVersionUID = 7421469210491903977L;
	private JPanel contentPane;
	private JTable table;
	private String[] columnNames = { "#", "IdEvento", "idEmpleado" };
	private DefaultTableModel tableModel;
	private JTextField textField;

	public GUIMostrarEmpleadosDeEvento(){
		super();
		initGUI();
	}
	
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	@SuppressWarnings("serial")
	private void initGUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 45, 604, 174);
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
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(504, 237, 120, 23);
		contentPane.add(btnSalir);
		
		textField = new JTextField();
		textField.setBounds(385, 14, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idEvento = Integer.parseInt(textField.getText());
					
					if(idEvento <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea (id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						Controlador.getInstance().accion(new Contexto(Events.MOSTRAR_EMPLEADOS_EVENTO, idEvento));
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(504, 13, 120, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblIdEvento = new JLabel("Id Evento:");
		lblIdEvento.setBounds(270, 17, 105, 14);
		contentPane.add(lblIdEvento);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textField.setText("");
		tableModel.setRowCount(0);
		table.setModel(tableModel);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.MOSTRAR_EMPLEADOS_EVENTO_OK:

			List<TParticipa> res = (List<TParticipa>) contexto.getDato();
			if (res.size() == 0)
				JOptionPane.showMessageDialog(null, "No hay empleados en el evento seleccionado");
			System.out.println(res.size());
			for (int i = 0; i < res.size(); i++) {

				tableModel.insertRow(i, new Object[] { i + 1, res.get(i).getEvento(), res.get(i).getEmpleado() });

			}
			table.setModel(tableModel);
			break;

		case Events.MOSTRAR_EMPLEADOS_EVENTO_KO:
			JOptionPane.showMessageDialog(null, "Error al listar los empleados del evento", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

}
