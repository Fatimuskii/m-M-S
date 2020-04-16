package Presentacion.Empleado;

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

import Negocio.Empleado.imp.TEmpleado;
import Negocio.Empleado.imp.TEmpleadoTiempoCompleto;
import Negocio.Empleado.imp.TEmpleadoTiempoParcial;
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

public class GUIListarEmpleado extends GUIEmpleado{

	private static final long serialVersionUID = 1L;

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	
	private JPanel contentPane;
	
	private String[]columnNames ={"#", "Id", "DNI", "Nombre", "Telefono", "Sueldo Base", "Plus", "Número de horas", "Departamento"};
	private DefaultTableModel tableModel;
	private JTable table;

	
	public GUIListarEmpleado() {
		super();
		initGUI();
	}
	
	private void initGUI(){
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 820, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 800, 205);
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
		
		case Events.LISTAR_EMPLEADO_OK:
			ArrayList<TEmpleado> res = (ArrayList<TEmpleado>) contexto.getDato();
			if(res.size() == 0)
				JOptionPane.showMessageDialog(null, "No existen empleados");
			
			for (int i = 0; i < res.size(); i++) {

				if (res.get(i) instanceof TEmpleadoTiempoCompleto) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
							res.get(i).getId(),
							res.get(i).getDNI(),
							res.get(i).getNombre(),
							res.get(i).getTelefono(),
							res.get(i).getSueldoBase(),
							((TEmpleadoTiempoCompleto)res.get(i)).getPluses(),
							"-",
							res.get(i).getDepartamento().getIdDepartamento()});
				}
				else if (res.get(i) instanceof TEmpleadoTiempoParcial){
					tableModel.insertRow(i, new Object[] 
							{ i+1,
								res.get(i).getId(),
								res.get(i).getDNI(),
								res.get(i).getNombre(),
								res.get(i).getTelefono(),
								res.get(i).getSueldoBase(),
							"-",
							((TEmpleadoTiempoParcial)res.get(i)).getNumHoras(),
							res.get(i).getDepartamento().getIdDepartamento()});
				}
				
			}
			table.setModel(tableModel);
			break;
			
		case Events.LISTAR_EMPLEADO_KO:
			JOptionPane.showMessageDialog(null, "Error al listar los empleados", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}
}
