/**
 * 
 */
package Presentacion.Cliente;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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
public class GUIModificarCliente extends GUICliente{

	private static final long serialVersionUID = 1L;
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	*/
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField dni;
	private JTextField telefono;
	private JTextField email;
	private JTextField id;
	private JButton btnFinalizar;
	private JLabel lblModificarUnCliente;
	private int idCliente;
	private TCliente tCliente;
	
	public GUIModificarCliente(){
		super();
		contentPane = new JPanel();
		this.setFocusable(true);
		initGUI();
	}
	
	
	public void initGUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(54, 91, 53, 14);
		panel.add(lblNombre);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setBounds(54, 124, 53, 14);
		panel.add(lblDni);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(54, 157, 53, 14);
		panel.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(54, 190, 53, 14);
		panel.add(lblEmail);
		
		nombre = new JTextField();
		nombre.setBounds(133, 89, 96, 20);
		nombre.setEditable(false);
		panel.add(nombre);
		nombre.setColumns(10);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(133, 122, 96, 20);
		dni.setEditable(false);
		panel.add(dni);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(133, 155, 96, 20);
		telefono.setEditable(false);
		panel.add(telefono);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(133, 188, 96, 20);
		email.setEditable(false);
		panel.add(email);
		
		lblModificarUnCliente = new JLabel("Modificar un cliente");
		lblModificarUnCliente.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModificarUnCliente.setBounds(145, 11, 160, 14);
		panel.add(lblModificarUnCliente);
		
		JLabel lblID = new JLabel("Introduzca un ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setBounds(110, 50, 100, 14);
		panel.add(lblID);
		
		id = new JTextField();
		id.setBounds(215, 48, 96, 20);
		panel.add(id);
		id.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(320, 46, 75, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					idCliente = Integer.parseInt(id.getText());
					
					if(idCliente < 0){
							JOptionPane.showMessageDialog(new JFrame(),
									"Información errónea (Id tiene que ser mayor que 0)", "Error",
									JOptionPane.ERROR_MESSAGE);
					}
					else
					Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_CLIENTE_BUSCAR,idCliente));
					
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnBuscar);
		
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(300, 217, 89, 23);
		btnFinalizar.setEnabled(false);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(checkDNI(dni.getText())){
					TCliente tClienteModificado = new TCliente(idCliente, nombre.getText(), telefono.getText(), email.getText(), dni.getText(), true);

					Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_CLIENTE,tClienteModificado));
					
					}
					else JOptionPane.showMessageDialog(new JFrame(), "El DNI debe contener 9 caracteres");
					
				}
				catch(Exception ex){
					System.out.println(ex.getMessage());
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnFinalizar);
		panel.add(btnFinalizar);

	}
	
	private boolean checkDNI(String dni){
		if(dni.length()<9 || dni.length()>9)
			return false;
		else return true;
	}

	public void clearData() {
		nombre.setText("");
		telefono.setText("");
		email.setText("");
		dni.setText("");
		id.setText("");
		
		nombre.setEditable(false);
		telefono.setEditable(false);
		email.setEditable(false);
		dni.setEditable(false);
	}
	
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.MODIFICAR_CLIENTE_OK:
			JOptionPane.showMessageDialog(null, "Cliente " + contexto.getDato() + " modificado con éxito.");
			this.dispose();
			break;
		case Events.MODIFICAR_CLIENTE_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El cliente no existe");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese DNI");
			}
			else if((int)contexto.getDato() == -3){
				JOptionPane.showMessageDialog(null, "El cliente no está activo");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al modificar el cliente");
			}

			break;
		case Events.MODIFICAR_CLIENTE_BUSCAR_OK:
			tCliente = (TCliente) contexto.getDato();
			
			nombre.setText(tCliente.getNombre());
			telefono.setText(tCliente.getTelefono());
			email.setText(tCliente.getEmail());
			dni.setText(tCliente.getDNI());		
			
			btnFinalizar.setEnabled(true);
			nombre.setEditable(true);
			telefono.setEditable(true);
			email.setEditable(true);
			dni.setEditable(true);
			
			break;
		case Events.MODIFICAR_CLIENTE_BUSCAR_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el cliente");
			break;
		}
	}
}