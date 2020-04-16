/**
 * 
 */
package Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import Negocio.Producto.imp.TJuegoDeMesa;
import Negocio.Producto.imp.TMerchandising;
import Negocio.Producto.imp.TProducto;
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
public class GUIProductoMasCompradoPorUnCliente extends GUIProducto{
	
	private static final long serialVersionUID = 5430690733528906068L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Nombre", "Precio", "Stock", "Edad Recomendada", "Numero Jugadores", "Tipo"};
	private DefaultTableModel tableModel;
	private JTable table;
	private JTextField textField;
	
	public GUIProductoMasCompradoPorUnCliente(){
		super();
		initGUI();
	}
	
	@SuppressWarnings("serial")
	private void initGUI(){
		setTitle("Productos Mas Comprados Por Un Cliente");
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
		
		JLabel lblId = new JLabel("Id cliente:");
		lblId.setBounds(280, 11, 100, 14);
		contentPane.add(lblId);
		
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
					int id;
					id = Integer.parseInt(textField.getText());
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Información errónea (Id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else{
						TQuery tQuery = new TQuery(id);
						Controlador.getInstance().accion(new Contexto(Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE, tQuery));
					}
				} catch (NumberFormatException ex) {
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
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_OK:
			tableModel.setRowCount(0);
			table.setEnabled(true);
			ArrayList<TProducto> res = (ArrayList<TProducto>) contexto.getDato();
			if(res.size() == 0){
				
				JOptionPane.showMessageDialog(null, "No existen productos comprados por el cliente indicado");
				}
			for (int i = 0; i < res.size(); i++) {

				if (res.get(i) instanceof TJuegoDeMesa) {
					tableModel.insertRow(i,
							new Object[] 
							{ i+1,
							res.get(i).getIdProducto(),
							res.get(i).getNombre(),
							res.get(i).getPrecio(),
							res.get(i).getStock(),
							((TJuegoDeMesa)res.get(i)).getEdadRecomendada(),
							((TJuegoDeMesa)res.get(i)).getNumJugadores(),
							"-"});
				}
				else if (res.get(i) instanceof TMerchandising){
					tableModel.insertRow(i, new Object[] 
							{ i+1,
							res.get(i).getIdProducto(),
							res.get(i).getNombre(),
							res.get(i).getPrecio(),
							res.get(i).getStock(),
							"-",
							"-",
							((TMerchandising)res.get(i)).getTipo()});
				}
				
			}
			table.setModel(tableModel);
			break;
		case Events.PRODUCTO_MAS_COMPRADO_POR_CLIENTE_KO:
			JOptionPane.showMessageDialog(null, "El cliente no existe", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		}
		
	}
}