/**
 * 
 */
package Presentacion.Evento;

import java.awt.Color;
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
public class GUIBuscarEvento extends GUIEvento{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8178081086747428930L;
	
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JLabel lblActivo;
	private JLabel lblInactivo;
	private JTextField textAforo;
	private JTextField textDireccion;

	public GUIBuscarEvento(){
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
		lblNombre.setBounds(60, 67, 90, 14);
		contentPane.add(lblNombre);

		JLabel lblDireccion = new JLabel("Dirección:");
		lblDireccion.setBounds(60, 113, 90, 14);
		contentPane.add(lblDireccion);

		JLabel lblAforo = new JLabel("Aforo:");
		lblAforo.setBounds(60, 160, 90, 14);
		contentPane.add(lblAforo);

		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(160, 64, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textDireccion = new JTextField();
		textDireccion.setEditable(false);
		textDireccion.setBounds(160, 110, 150, 20);
		contentPane.add(textDireccion);
		textDireccion.setColumns(10);

		textAforo = new JTextField();
		textAforo.setEditable(false);
		textAforo.setBounds(160, 157, 150, 20);
		contentPane.add(textAforo);
		textAforo.setColumns(10);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(330, 237, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(60, 200, 90, 14);
		contentPane.add(lblEstado);
		
		lblActivo = new JLabel("Activo");
		lblActivo.setForeground(Color.GREEN);
		lblActivo.setBounds(160, 200, 120, 14);
		contentPane.add(lblActivo);
		
		lblInactivo = new JLabel("Inactivo");
		lblInactivo.setForeground(Color.RED);
		lblInactivo.setBounds(160, 200, 120, 14);
		contentPane.add(lblInactivo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 54, 414, 2);
		contentPane.add(separator);
		
		textId = new JTextField();
		textId.setBounds(160, 23, 150, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblId = new JLabel("Id evento:");
		lblId.setBounds(60, 26, 90, 14);
		contentPane.add(lblId);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textId.getText());
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Información errónea (Id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_EVENTO, id));
				}
				catch(NumberFormatException ex){
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
		
		lblActivo.setVisible(false);
		lblInactivo.setVisible(false);
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.BUSCAR_EVENTO_OK:
			TEvento evento = (TEvento)contexto.getDato();
			
			textNombre.setText(evento.getNombre());
			textAforo.setText(evento.getAforo()+"");
			textDireccion.setText(evento.getDireccion());
			
			if(evento.getActivo()){
				lblActivo.setVisible(true);
				lblInactivo.setVisible(false);
			}
			else{
				lblActivo.setVisible(false);
				lblInactivo.setVisible(true);
			}
			break;
		case Events.BUSCAR_EVENTO_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el producto");
			break;
		}
	}
}