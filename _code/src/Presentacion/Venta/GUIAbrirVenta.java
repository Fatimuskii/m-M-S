/**
 * 
 */
package Presentacion.Venta;

import java.awt.Font;
import java.awt.SystemColor;
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
import Presentacion.View.GUI;

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
@SuppressWarnings("serial")
public class GUIAbrirVenta extends JFrame implements GUI {

	private JPanel contentPane;
	private JTextField textField_IdCliente;

	public GUIAbrirVenta() {
		super();
		contentPane = new JPanel();
		// contentPane.setVisible(true);
		setResizable(false);
		initGUI();
	}

	public void initGUI() {

		setTitle("Abrir venta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 147);
		contentPane.setBackground(SystemColor.scrollbar);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIntroducirElId = new JLabel("Introduzca el Id del cliente:");
		lblIntroducirElId.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIntroducirElId.setBounds(50, 30, 226, 29);
		contentPane.add(lblIntroducirElId);

		textField_IdCliente = new JTextField();
		textField_IdCliente.setBounds(275, 30, 86, 29);
		contentPane.add(textField_IdCliente);
		textField_IdCliente.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField_IdCliente.getText().equals("")) {

					try {
						int idCliente = Integer.parseInt(textField_IdCliente.getText());
						Controlador.getInstance().accion(new Contexto(Events.ABRIR_VENTA, idCliente));
						dispose();

					} catch (Exception ex) {

						JOptionPane.showMessageDialog(new JFrame(), "Error en la introducción del id", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un id", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAceptar.setBounds(368, 68, 107, 29);
		contentPane.add(btnAceptar);
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
	}

	public void limpiarGUI() {
		this.textField_IdCliente.setText("");
	}

}