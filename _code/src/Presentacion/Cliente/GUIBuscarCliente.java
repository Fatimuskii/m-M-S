/**
 * 
 */
package Presentacion.Cliente;

import java.awt.Color;
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

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Ana Álava Papí
 * @author Óscar Canive Huguet
 * @author David Domínguez Gutiérrez
 * @author Fátima García Delgado
 * @author Marina Lozano Lahuerta
 * @author Paula Sánchez de la Nieta Gómez
 * @generated "UML a Java
 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class GUIBuscarCliente extends GUICliente {

	private static final long serialVersionUID = 1L;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textDNI;
	private JTextField textEmail;
	private boolean window;

	private String id;
	private JLabel lblActivo;
	private JLabel lblInactivo;

	public GUIBuscarCliente() {
		super();
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(60, 67, 90, 14);
		contentPane.add(lblNombre);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(60, 98, 90, 14);
		contentPane.add(lblTelefono);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(60, 129, 90, 14);
		contentPane.add(lblEmail);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(60, 160, 120, 14);
		contentPane.add(lblDNI);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(160, 64, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setBounds(160, 95, 150, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setBounds(160, 126, 150, 20);
		contentPane.add(textEmail);
		textEmail.setColumns(10);

		textDNI = new JTextField();
		textDNI.setEditable(false);
		textDNI.setBounds(160, 157, 150, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(330, 237, 89, 23);
		contentPane.add(btnAceptar);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(60, 188, 90, 14);
		contentPane.add(lblEstado);
		
		lblActivo = new JLabel("Activo");
		lblActivo.setForeground(Color.GREEN);
		lblActivo.setBounds(160, 188, 120, 14);
		contentPane.add(lblActivo);
		
		lblInactivo = new JLabel("Inactivo");
		lblInactivo.setForeground(Color.RED);
		lblInactivo.setBounds(160, 188, 120, 14);
		contentPane.add(lblInactivo);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void clearData() {
		textNombre.setText("");
		textEmail.setText("");
		textTelefono.setText("");
		textDNI.setText("");
		
		lblActivo.setVisible(false);
		lblInactivo.setVisible(false);
	}

	public boolean getWindow() {
		return window;
	}

	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.BUSCAR_CLIENTE_OK:
			TCliente tCliente = (TCliente) contexto.getDato();
			
			window = true;
			textNombre.setText(tCliente.getNombre());
			textTelefono.setText(tCliente.getTelefono() + "");
			textEmail.setText(tCliente.getEmail() + "");
			textDNI.setText(tCliente.getDNI() + "");

			if(tCliente.getActivo()){
				lblActivo.setVisible(true);
				lblInactivo.setVisible(false);
			}
			else{
				lblActivo.setVisible(false);
				lblInactivo.setVisible(true);
			}
			
			break;
		case Events.BUSCAR_CLIENTE_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el cliente");
			window = false;
			break;
		}
	}
}