package Presentacion.Departamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Departamento.imp.TDepartamento;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Controlador.Controlador;

public class GUIAltaDepartamento extends GUIDepartamento {

	/**
	 * 
	 */

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField textField_nombreDept;
	public GUIAltaDepartamento() {
		super();
		setResizable(false);
		initGUI();
	}

	public void initGUI() {
		setTitle("Alta Departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 449, 188);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel nombreDepto = new JLabel("Nombre de Dpto.:");
		nombreDepto.setBounds(29, 28, 142, 22);
		contentPane.add(nombreDepto);

		textField_nombreDept = new JTextField();
		textField_nombreDept.setBounds(178, 29, 201, 20);
		contentPane.add(textField_nombreDept);
		textField_nombreDept.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nombreDept = textField_nombreDept.getText().toUpperCase();

				if (nombreDept.equals("")) {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un nombre", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					TDepartamento departamento = new TDepartamento(nombreDept, 0, true);
					Controlador.getInstance().accion(new Contexto(Events.ALTA_DEPARTAMENTO, departamento));
				}
			}
		});
		btnAceptar.setBounds(302, 108, 99, 30);
		contentPane.add(btnAceptar);

	}

	public void limpiar() {
		initGUI();
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		switch (contexto.getEvento()) {
		case Events.ALTA_DEPARTAMENTO_OK:
			JOptionPane.showMessageDialog(null, "Departamento con id: " + contexto.getDato() + " dado de alta.");
			this.dispose();
			break;
		case Events.ALTA_DEPARTAMENTO_KO:
			JOptionPane.showMessageDialog(new JFrame(), contexto.getDato(), "Error", JOptionPane.ERROR_MESSAGE);
			this.dispose();
			break;
		}
	}

}
