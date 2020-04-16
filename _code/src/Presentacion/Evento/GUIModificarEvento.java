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
import javax.swing.JSeparator;
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
public class GUIModificarEvento extends GUIEvento{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 8811190809783299792L;

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textAforo;
	private JTextField textDireccion;

	private int idEvento;

	public GUIModificarEvento(){
		super();
		
		initGUI();
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(60, 88, 90, 14);
		contentPane.add(lblNombre);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(60, 134, 90, 14);
		contentPane.add(lblDireccion);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(60, 182, 90, 14);
		contentPane.add(lblAforo);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(160, 85, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
				

		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setBounds(160, 131, 150, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textAforo = new JTextField();
		textAforo.setEditable(false);
		textAforo.setBounds(160, 179, 150, 20);
		contentPane.add(textAforo);
		textAforo.setColumns(10);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre, direccion;
					int aforo;
					boolean error = false;

					nombre = textNombre.getText();
					direccion = textDireccion.getText();
					aforo = Integer.parseInt(textAforo.getText());

					if (nombre.equals("") || direccion.equals("") || aforo <= 0) {
						error = true;
					}
					
					if (error) {
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						TEvento tEvento = new TEvento(idEvento, nombre, direccion, aforo, true);
						Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_EVENTO, tEvento));
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setBounds(330, 237, 89, 23);
		contentPane.add(btnModificar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 61, 414, 2);
		contentPane.add(separator);
		
		textId = new JTextField();
		textId.setBounds(160, 23, 150, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblId = new JLabel("IdEvento:");
		lblId.setBounds(60, 26, 90, 14);
		contentPane.add(lblId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textId.getText());
					idEvento = id;
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Información errónea (Id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_MODIFICAR_EVENTO, id));
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(330, 22, 89, 23);
		contentPane.add(btnBuscar);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textId.setText("");
		textNombre.setText("");
		textAforo.setText("");
		textDireccion.setText("");
		
		textNombre.setEditable(false);
		textAforo.setEditable(false);
		textDireccion.setEditable(false);
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.BUSCAR_MODIFICAR_EVENTO_OK:
			TEvento evento = (TEvento) contexto.getDato();
			textNombre.setText(evento.getNombre());
			textAforo.setText(evento.getAforo()+"");
			textDireccion.setText(evento.getDireccion());
			
			textNombre.setEditable(true);
			textAforo.setEditable(true);
			textDireccion.setEditable(true);
			break;
		case Events.BUSCAR_MODIFICAR_EVENTO_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el evento");
			break;
		case Events.MODIFICAR_EVENTO_OK:
			JOptionPane.showMessageDialog(null, "Evento " + contexto.getDato() + " modificado correctamente.");
			this.dispose();
			break;
		case Events.MODIFICAR_EVENTO_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El evento no existe");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "El evento no está activo");
			}
			else if((int)contexto.getDato() == -3){
				JOptionPane.showMessageDialog(null, "Ya existe un evento con ese nombre");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al modificar el evento");
			}
			
			break;
		}
	}
}