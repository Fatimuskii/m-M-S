/**
 * 
 */
package Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
public class GUIBajaProducto extends GUIProducto{


	private static final long serialVersionUID = -4950685863639637571L;
	private JPanel contentPane;
	private JTextField textField;

	public GUIBajaProducto(){
		super();
		
		initGUI();
	}
	
	private void initGUI(){
		setTitle("Baja Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnDarDeBaja = new JButton("Dar de baja");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idProducto;
					
					idProducto = Integer.parseInt(textField.getText());
					
					if(idProducto <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea (id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						Controlador.getInstance().accion(new Contexto(Events.BAJA_PRODUCTO, idProducto));
					}
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDarDeBaja.setBounds(161, 140, 120, 40);
		contentPane.add(btnDarDeBaja);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(110, 80, 55, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(177, 77, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	public void clearData() {
		textField.setText("");
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.BAJA_PRODUCTO_OK:
			JOptionPane.showMessageDialog(null, "Producto " + contexto.getDato() + " dado de baja correctamente.");
			this.dispose();
			break;
		case Events.BAJA_PRODUCTO_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El producto indicado no existe");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "El producto indicado ya está dado de baja");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al dar de baja el producto");
			}
			break;
		}
		
	}
}