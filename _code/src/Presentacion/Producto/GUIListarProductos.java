/**
 * 
 */
package Presentacion.Producto;

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

import Negocio.Producto.imp.TJuegoDeMesa;
import Negocio.Producto.imp.TMerchandising;
import Negocio.Producto.imp.TProducto;
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
public class GUIListarProductos extends GUIProducto{

	private static final long serialVersionUID = -4565412898517547227L;
	private JPanel contentPane;
	private String[]columnNames ={"#", "Id", "Nombre", "Precio", "Stock", "Edad Recomendada", "Numero Jugadores", "Tipo"};
	private DefaultTableModel tableModel;
	private JTable table;
	
	public GUIListarProductos(){
		super();
		initGUI();
	}
	
	private void initGUI() {
		setTitle("Listar Productos");
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

			private static final long serialVersionUID = -401148371436941435L;

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
	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.LISTAR_PRODUCTOS_OK:
			
			ArrayList<TProducto> res = (ArrayList<TProducto>) contexto.getDato();
			if(res.size() == 0)
				JOptionPane.showMessageDialog(null, "No existen productos");
			
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
			
		case Events.LISTAR_PRODUCTOS_KO:
			JOptionPane.showMessageDialog(null, "Error al listar los productos", "Error listar", JOptionPane.ERROR_MESSAGE);
			break;
		}
		
	}
}