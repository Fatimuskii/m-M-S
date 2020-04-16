package Presentacion.Venta;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

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
public class GUIDevolucion extends JFrame implements GUI {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_idVenta;
	private JTextField textField_IdProd;
	private JTextField textField_cantidad;
	
	
	
	public  GUIDevolucion(){
		super();
		contentPane = new JPanel();
		setResizable(false);
		initGUI();
	}
	
	
	public void initGUI(){
		setTitle("Devolucion ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 223);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdVenta = new JLabel("Id Venta:");
		lblIdVenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdVenta.setForeground(Color.RED);
		lblIdVenta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdVenta.setBounds(30, 26, 216, 14);
		contentPane.add(lblIdVenta);
		
		JLabel lblIdProductoA = new JLabel("Id Producto a devolver:");
		lblIdProductoA.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdProductoA.setForeground(Color.RED);
		lblIdProductoA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdProductoA.setBounds(30, 59, 216, 14);
		contentPane.add(lblIdProductoA);
		
		JLabel lblCantidadADevolver = new JLabel("Cantidad a devolver");
		lblCantidadADevolver.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCantidadADevolver.setForeground(Color.RED);
		lblCantidadADevolver.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCantidadADevolver.setBounds(30, 92, 216, 14);
		contentPane.add(lblCantidadADevolver);
		
		textField_idVenta = new JTextField();
		textField_idVenta.setBounds(266, 25, 86, 20);
		contentPane.add(textField_idVenta);
		textField_idVenta.setColumns(10);
		
		textField_IdProd = new JTextField();
		textField_IdProd.setColumns(10);
		textField_IdProd.setBounds(266, 58, 86, 20);
		contentPane.add(textField_IdProd);
		
		textField_cantidad = new JTextField();
		textField_cantidad.setColumns(10);
		textField_cantidad.setBounds(266, 91, 86, 20);
		contentPane.add(textField_cantidad);
		
		JButton btnDevolver = new JButton("DEVOLVER");
		btnDevolver.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDevolver.setForeground(Color.BLACK);
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int idVenta=Integer.parseInt(textField_idVenta.getText());
				int idProducto= Integer.parseInt(textField_IdProd.getText());
				int cantidad = Integer.parseInt(textField_cantidad.getText());
				
				int []datos={ idVenta, idProducto, cantidad};
				
				Controlador.getInstance().accion(new Contexto(Events.DEVOLUCION, datos));
			}
		});
		btnDevolver.setBounds(229, 145, 126, 31);
		contentPane.add(btnDevolver);
		
	}
	
	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.DEVOLUCION_OK:
			JOptionPane.showMessageDialog(new JFrame(), "Devolucion hecha a venta con id : " + contexto.getDato(), "Devolucion",
					JOptionPane.INFORMATION_MESSAGE);
			dispose();
			
			break;
		case Events.DEVOLUCION_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Error en la devolucioon: " + contexto.getDato(), "Devolucion",
					JOptionPane.ERROR_MESSAGE);
			dispose();
			break;
		}
		
	
		
	}
	
	public void limpiarGUI(){
		textField_idVenta.setText("");
		textField_IdProd.setText("");
		textField_cantidad.setText("");
	}

}
