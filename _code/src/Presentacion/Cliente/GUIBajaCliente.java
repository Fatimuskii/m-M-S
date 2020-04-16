/**
 * 
 */
package Presentacion.Cliente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
public class GUIBajaCliente extends GUICliente{

	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPanel panelPrincipal;
	private JTextField id_Cliente;

	/**
	 * Create the panel.
	 */
	public GUIBajaCliente() {
		super();
		panelPrincipal = new JPanel();
		this.setFocusable(true);
		initGUI();

	}

	private void initGUI(){
		panelPrincipal.setLayout(null);
		
		JLabel lblIdcliente = new JLabel("Id del Cliente");
		setBounds(100, 100, 450, 200);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelPrincipal.add(lblIdcliente);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(150, 64, 50, 20);
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		panelPrincipal.add(lblId);
		
		id_Cliente = new JTextField();
		id_Cliente.setBounds(174, 65, 105, 20);
		panelPrincipal.add(id_Cliente);
		id_Cliente.setColumns(10);
		
		JButton btnDarBaja = new JButton("Dar baja");
		btnDarBaja.setBounds(182, 125, 89, 23);
		btnDarBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				int id = Integer.parseInt(id_Cliente.getText());
				
					if(id<0){
						JOptionPane.showMessageDialog(new JFrame(),
								"El ID tiene que ser mayor que 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
					else{
					int option = JOptionPane.showOptionDialog(new JFrame(),
							"¿Estás seguro?", "Quit",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.YES_NO_OPTION, null, null, null);
					if (option == JOptionPane.YES_OPTION){
						Controlador.getInstance().accion(new Contexto(Events.BAJA_CLIENTE,id));
						
					}
					else dispose();
					}
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panelPrincipal.add(btnDarBaja);
	
		JLabel lblDarDeBaja = new JLabel("Dar de baja a un cliente");
		lblDarDeBaja.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDarDeBaja.setBounds(140, 11, 200, 14);
		panelPrincipal.add(lblDarDeBaja);
		
		add(panelPrincipal);
	}
	
	public void clearData() {
		id_Cliente.setText("");
	}
	
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.BAJA_CLIENTE_OK:
			JOptionPane.showMessageDialog(null, "Cliente " + contexto.getDato() + " dado de baja.");
			this.dispose();
			break;
		case Events.BAJA_CLIENTE_KO:
			if((int)contexto.getDato()==-1){
				JOptionPane.showMessageDialog(null, "El cliente no existe");
			}
			else if((int)contexto.getDato()==-2){
				JOptionPane.showMessageDialog(null, "El cliente ya está dado de baja");
			}
			else
				JOptionPane.showMessageDialog(null, "Error al dar de baja al cliente");

			break;
		}
	}
}