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

import Negocio.Evento.imp.TEvento;
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
public class GUIAltaEvento extends GUIEvento{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6470913067140281130L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textAforo;

	public GUIAltaEvento(){
		super();
		
		setResizable(false);
		initGUI();
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setTitle("Alta Evento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 16, 94, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(10, 85, 94, 14);
		contentPane.add(lblDireccion);
		
		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(10, 154, 94, 14);
		contentPane.add(lblAforo);
		
		textNombre = new JTextField();
		textNombre.setBounds(114, 8, 310, 30);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textNombre.getText();
					String direccion = textDireccion.getText();
					int aforo = Integer.parseInt(textAforo.getText());
					
					boolean error = false;
					if (nombre.equals("") || direccion.equals("") || aforo < 0) {
						error = true;
					}

					if (error) {
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						TEvento tEvento = new TEvento(nombre, direccion, aforo, true);
						Controlador.getInstance().accion(new Contexto(Events.ALTA_EVENTO, tEvento));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(335, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(222, 227, 89, 23);
		contentPane.add(btnSalir);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(114, 77, 310, 30);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);
		
		textAforo = new JTextField();
		textAforo.setBounds(114, 146, 310, 30);
		contentPane.add(textAforo);
		textAforo.setColumns(10);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textNombre.setText("");
		textDireccion.setText("");
		textAforo.setText("");
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_EVENTO_OK:
			JOptionPane.showMessageDialog(null, "Evento " + contexto.getDato() + " dado de alta.");
			this.dispose();
			break;
		case Events.ALTA_EVENTO_KO:
			if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "Ya existe un evento con ese nombre");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al crear el evento");
			}
			break;
		}
	}
}