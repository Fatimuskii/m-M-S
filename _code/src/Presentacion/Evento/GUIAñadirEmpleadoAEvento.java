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

import Negocio.Evento.imp.TParticipa;
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
* @author Paula Sánchez de la Nieta Gómez* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
*/
public class GUIAñadirEmpleadoAEvento extends GUIEvento{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3092670744738847188L;
	
	private JTextField textEvento;
	private JTextField textEmpleado;

	private JPanel contentPane;
	
	public GUIAñadirEmpleadoAEvento(){
		super();
		
		initGUI();
	}
	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	private void initGUI() {
		setTitle("Añadir Empleado a Evento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdEmpleado = new JLabel("Id Empleado:");
		lblIdEmpleado.setBounds(30, 40, 100, 14);
		contentPane.add(lblIdEmpleado);
		
		JLabel lblIdEvento = new JLabel("Id Evento:");
		lblIdEvento.setBounds(30, 110, 100, 14);
		contentPane.add(lblIdEvento);
		
		textEmpleado = new JTextField();
		textEmpleado.setBounds(150, 37, 274, 20);
		contentPane.add(textEmpleado);
		textEmpleado.setColumns(10);
		
		textEvento = new JTextField();
		textEvento.setBounds(150, 107, 274, 20);
		contentPane.add(textEvento);
		textEvento.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(230, 227, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int empleado = Integer.parseInt(textEmpleado.getText());
					int evento = Integer.parseInt(textEvento.getText());
					if (empleado <= 0 || evento <= 0)
						JOptionPane.showMessageDialog(new JFrame(), "Los Id's tienen que ser mayores que 0", "Error",
								JOptionPane.ERROR_MESSAGE);
					
					TParticipa tParticipa = new TParticipa(evento, empleado, true);

					Controlador.getInstance().accion(new Contexto(Events.AÑADIR_EMPLEADO_EVENTO, tParticipa));

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(335, 227, 89, 23);
		contentPane.add(btnAceptar);
	}

	/** 
	* <!-- begin-UML-doc -->
	* <!-- end-UML-doc -->
	* @generated "UML a JPA (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	*/
	public void clearData() {
		textEvento.setText("");
		textEmpleado.setText("");
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.AÑADIR_EMPLEADO_EVENTO_OK:
			JOptionPane.showMessageDialog(null, "Empleado "+ " añadido al Evento " );
			this.dispose();
			break;
		case Events.AÑADIR_EMPLEADO_EVENTO_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El evento no existe");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "El empleado no existe");
			}
			else if((int)contexto.getDato() == -3){
				JOptionPane.showMessageDialog(null, "El evento no está activo");
			}
			else if((int)contexto.getDato() == -4){
				JOptionPane.showMessageDialog(null, "El empleado no está activo");
			}
			else if((int)contexto.getDato() == -5){
				JOptionPane.showMessageDialog(null, "El empleado ya está asignado al evento");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al añadir el empleado al evento");
			}
			break;
		}

	}
}