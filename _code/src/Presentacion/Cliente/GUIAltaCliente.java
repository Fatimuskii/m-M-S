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
import javax.swing.SwingConstants;

import Negocio.Cliente.imp.TCliente;
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
public class GUIAltaCliente extends GUICliente {

	private static final long serialVersionUID = 1L;
	
	private JTextField nombre;
	private JTextField dni;
	private JTextField telefono;
	private JTextField email;
	private JPanel panelPrincipal;

	/**
	 * Create the panel.
	 */
	public GUIAltaCliente(){
		super();
		panelPrincipal = new JPanel();
		this.setFocusable(true);
		initGUI();
	}
	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panelPrincipal.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(50, 63, 60, 14);
		panelPrincipal.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(50, 103, 60, 14);
		panelPrincipal.add(lblDni);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(50, 143, 60, 14);
		panelPrincipal.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("E-Mail");
		lblEmail.setBounds(50, 183, 60, 14);
		panelPrincipal.add(lblEmail);
		
		nombre = new JTextField();
		nombre.setBounds(130, 60, 96, 20);
		panelPrincipal.add(nombre);
		nombre.setColumns(10);
		
		dni = new JTextField();
		dni.setBounds(130, 100, 96, 20);
		panelPrincipal.add(dni);
		dni.setColumns(10);
		
		telefono = new JTextField();
		telefono.setBounds(130, 140, 96, 20);
		panelPrincipal.add(telefono);
		telefono.setColumns(10);
		
		email = new JTextField();
		email.setBounds(130, 180, 96, 20);
		panelPrincipal.add(email);
		email.setColumns(10);
		
		JLabel lblAltaDeUn = new JLabel("Alta de un cliente");
		lblAltaDeUn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAltaDeUn.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUn.setBounds(150, 11, 144, 14);
		panelPrincipal.add(lblAltaDeUn);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(300, 223, 89, 23);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!camposVacios()){
					if(checkDNI(dni.getText())){
					Controlador.getInstance().accion(new Contexto(Events.ALTA_CLIENTE,new TCliente(nombre.getText(),telefono.getText(),email.getText(), dni.getText(), true)));
					
					}
					else JOptionPane.showMessageDialog(new JFrame(), "El DNI debe contener 9 caracteres");
				}
				else JOptionPane.showMessageDialog(new JFrame(), "Debes rellenar todos los campos");
			}
		});
		panelPrincipal.add(btnFinalizar);
	
		add(panelPrincipal);

	}
	
	private boolean camposVacios(){
		if(nombre.getText().isEmpty()||dni.getText().isEmpty()||telefono.getText().isEmpty()||email.getText().isEmpty())
			return true;
		else return false;
	}
	
	private boolean checkDNI(String dni){
		if(dni.length()<9 || dni.length()>9)
			return false;
		else return true;
	}
	
	public void clearData() {
		nombre.setText("");
		dni.setText("");
		telefono.setText("");
		email.setText("");
	}
	

	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_CLIENTE_OK:
			JOptionPane.showMessageDialog(null, "Cliente " + contexto.getDato() + " dado de alta.");
			this.dispose();
			break;
		case Events.ALTA_CLIENTE_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El cliente ya existe.");
			}
			else
				JOptionPane.showMessageDialog(null, "Error al dar de alta al cliente");
			break;
		}
	}
}


