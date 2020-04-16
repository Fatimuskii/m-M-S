package Presentacion.Departamento;

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

import Negocio.Departamento.imp.TDepartamento;
import Presentacion.Contexto;
import Presentacion.Events;

public class GUIListarDepartamentos extends GUIDepartamento {

	

	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Nombre", "Num Empleados"};
	private DefaultTableModel tableModel;
	private JTable table;
	private static final long serialVersionUID = 1L;

	public GUIListarDepartamentos(){
		super();
		setResizable(false);
		initGUI();
	}
	
	
	
	
	private void initGUI() {
		
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



	public void limpiar(){
		initGUI();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.LISTAR_DEPARTAMENTO_OK:
			 ArrayList<TDepartamento> res = (ArrayList<TDepartamento>) contexto.getDato();
			if(res.size()==0){
				JOptionPane.showMessageDialog(null, "No hay departamnetos en la base de datos");
			}
			for (int i = 0; i < res.size(); i++) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
							res.get(i).getIdDepartamento(),
							res.get(i).getNombre(),
							res.get(i).getNumPersonas()});
				}
				
			table.setModel(tableModel);
			break;
			
		case Events.LISTAR_DEPARTAMENTO_KO:
			JOptionPane.showMessageDialog(null, "Error al listar los departamentos", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		
		}

	}
}
