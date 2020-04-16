/**
 * 
 */
package Presentacion.Evento;

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
* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUIBajaEvento extends GUIEvento{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6277234608869831146L;

	private JPanel contentPane;
	private JTextField textField;

	public GUIBajaEvento(){
		super();
		
		initGUI();
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
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
					int idEvento;
					
					idEvento = Integer.parseInt(textField.getText());
					
					if(idEvento <= 0){
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea (id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
						Controlador.getInstance().accion(new Contexto(Events.BAJA_EVENTO, idEvento));
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

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textField.setText("");
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.BAJA_EVENTO_OK:
			JOptionPane.showMessageDialog(null, "Evento " + contexto.getDato() + " dado de baja correctamente.");
			this.dispose();
			break;
			
		case Events.BAJA_EVENTO_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El evento indicado no existe");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "El evento indicado ya está dado de baja");
			}
			else if((int)contexto.getDato() == -3){
				JOptionPane.showMessageDialog(null, "El evento indicado tiene algún empleado asignado");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al dar de baja el evento");
			}
			break;
		}
		
	}
}