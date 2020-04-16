package Presentacion.Empleado;

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

import Negocio.Departamento.imp.Departamento;
import Negocio.Departamento.imp.TDepartamento;
import Negocio.Empleado.imp.TEmpleado;
import Negocio.Empleado.imp.TEmpleadoTiempoCompleto;
import Negocio.Empleado.imp.TEmpleadoTiempoParcial;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Controlador.Controlador;

/**
 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
 * 
 * @author Ana Álava Papí
 * @author Óscar Canive Huguet
 * @author David Domínguez Gutiérrez
 * @author Fátima García Delgado
 * @author Marina Lozano Lahuerta
 * @author Paula Sánchez de la Nieta Gómez
 * @generated "UML a JPA
 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */

public class GUIModificarEmpleado extends GUIEmpleado {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textSueldoBase;
	private JTextField textId;
	private JTextField textDNI;
	private JTextField textPlus;
	private JTextField textNumHoras;
	private JTextField textDepartamento;
	private JLabel lblPlus;
	private JLabel lblNumHoras;
	private JButton btnFinalizar;
	private JLabel lblModificarUnEmpleado;
	private int idEmpleado;
	private TEmpleado tEmpleado;

	public GUIModificarEmpleado() {
		super();
		contentPane = new JPanel();
		this.setFocusable(true);
		initGUI();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	public void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
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

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTelefono.setBounds(54, 124, 53, 14);
		panel.add(lblTelefono);

		JLabel lblSueldoBase = new JLabel("Sueldo Base");
		lblSueldoBase.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSueldoBase.setBounds(54, 157, 73, 14);
		panel.add(lblSueldoBase);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartamento.setBounds(54, 190, 83, 14);
		panel.add(lblDepartamento);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(54, 223, 53, 14);
		panel.add(lblDNI);

		lblPlus = new JLabel("Plus");
		lblPlus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlus.setBounds(54, 256, 53, 14);
		panel.add(lblPlus);

		lblNumHoras = new JLabel("Número de horas");
		lblNumHoras.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumHoras.setBounds(54, 256, 100, 14);
		panel.add(lblNumHoras);

		textNombre = new JTextField();
		textNombre.setBounds(163, 89, 96, 20);
		textNombre.setEditable(false);
		panel.add(textNombre);
		textNombre.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(163, 122, 96, 20);
		textTelefono.setEditable(false);
		panel.add(textTelefono);

		textSueldoBase = new JTextField();
		textSueldoBase.setColumns(10);
		textSueldoBase.setBounds(163, 155, 96, 20);
		textSueldoBase.setEditable(false);
		panel.add(textSueldoBase);

		textDepartamento = new JTextField();
		textDepartamento.setColumns(10);
		textDepartamento.setBounds(163, 188, 96, 20);
		textDepartamento.setEditable(false);
		panel.add(textDepartamento);

		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(163, 221, 96, 20);
		textDNI.setEditable(false);
		panel.add(textDNI);

		textPlus = new JTextField();
		textPlus.setColumns(10);
		textPlus.setBounds(163, 254, 96, 20);
		textPlus.setEditable(false);
		panel.add(textPlus);

		textNumHoras = new JTextField();
		textNumHoras.setColumns(10);
		textNumHoras.setBounds(163, 254, 96, 20);
		textNumHoras.setEditable(false);
		panel.add(textNumHoras);

		lblModificarUnEmpleado = new JLabel("Modificar un empleado");
		lblModificarUnEmpleado.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblModificarUnEmpleado.setBounds(145, 11, 180, 20);
		panel.add(lblModificarUnEmpleado);

		JLabel lblID = new JLabel("Introduzca un ID");
		lblID.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblID.setBounds(110, 50, 100, 14);
		panel.add(lblID);

		textId = new JTextField();
		textId.setBounds(215, 48, 96, 20);
		panel.add(textId);
		textId.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(320, 46, 75, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					idEmpleado = Integer.parseInt(textId.getText());

					if (idEmpleado < 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Información errónea (Id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_MODIFICAR_EMPLEADO, idEmpleado));

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnBuscar);

		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(315, 280, 89, 23);
		btnFinalizar.setEnabled(false);
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int numHoras = 0;
					Float plus = 0.0f;

					String nombre = textNombre.getText();
					Float sueldoBase = Float.parseFloat(textSueldoBase.getText());
					String telefono = textTelefono.getText();
					int idDepartamento = Integer.parseInt(textDepartamento.getText());
					String DNI = textDNI.getText();

					if (nombre.equals("") || telefono.equals("") || sueldoBase.equals(""))
						JOptionPane.showMessageDialog(new JFrame(), "No puede haber campos vacíos", "Error",
								JOptionPane.ERROR_MESSAGE);

					if (sueldoBase < 0)
						JOptionPane.showMessageDialog(new JFrame(), "El sueldo no puede ser negativo", "Error",
								JOptionPane.ERROR_MESSAGE);

					if (DNI.length() != 9)
						JOptionPane.showMessageDialog(new JFrame(), "El DNI debe tener 9 caracteres", "Error",
								JOptionPane.ERROR_MESSAGE);

					if (tEmpleado instanceof TEmpleadoTiempoCompleto) {
						plus = Float.parseFloat(textPlus.getText());
						if (plus < 0)
							JOptionPane.showMessageDialog(new JFrame(), "Plus no puede ser negativo", "Error",
									JOptionPane.ERROR_MESSAGE);
					}
					if (tEmpleado instanceof TEmpleadoTiempoParcial) {
						numHoras = Integer.parseInt(textNumHoras.getText());
						if (numHoras < 0)
							JOptionPane.showMessageDialog(new JFrame(), "Número de horas no puede ser negativo",
									"Error", JOptionPane.ERROR_MESSAGE);
					}
					TDepartamento dept = new TDepartamento(idDepartamento, "", 0,
							true);/*
									 * una vez añadido el text pane de
									 * modificacion de departamento se cambia el
									 * 1 por el departamento de entrada
									 */

					if (tEmpleado instanceof TEmpleadoTiempoCompleto) {
						TEmpleadoTiempoCompleto tEmpleadoNuevo = new TEmpleadoTiempoCompleto(idEmpleado, DNI, nombre,
								textTelefono.getText(), sueldoBase, true, new Departamento(dept), plus);
						Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_EMPLEADO, tEmpleadoNuevo));
					}
					if (tEmpleado instanceof TEmpleadoTiempoParcial) {
						TEmpleadoTiempoParcial tEmpleadoNuevo = new TEmpleadoTiempoParcial(idEmpleado, DNI, nombre,
								textTelefono.getText(), sueldoBase, true, new Departamento(dept), numHoras);
						Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_EMPLEADO, tEmpleadoNuevo));
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnFinalizar);
		panel.add(btnFinalizar);

	}

	public void clearData() {
		textNombre.setText("");
		textTelefono.setText("");
		textSueldoBase.setText("");
		textId.setText("");
		textPlus.setText("");
		textNumHoras.setText("");
		textDepartamento.setText("");
		textDNI.setText("");

		lblPlus.setVisible(false);
		lblNumHoras.setVisible(false);
		textNombre.setEditable(false);
		textTelefono.setEditable(false);
		textSueldoBase.setEditable(false);
		textDepartamento.setEditable(false);
		textDNI.setEditable(false);
		textPlus.setVisible(false);
		textNumHoras.setVisible(false);
	}

	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.MODIFICAR_EMPLEADO_OK:
			JOptionPane.showMessageDialog(null, "Empleado " + contexto.getDato() + " modificado con éxito.");
			this.dispose();
			break;
		case Events.MODIFICAR_EMPLEADO_KO:
			if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "El DNI ya existe");

			else if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "El empleado no está activo");

			else if ((int) contexto.getDato() == -3)
				JOptionPane.showMessageDialog(null, "El empleado no existe");

			else
				JOptionPane.showMessageDialog(null, "No se ha encontrado el departamento");

			break;
		case Events.BUSCAR_MODIFICAR_EMPLEADO_OK:
			tEmpleado = (TEmpleado) contexto.getDato();

			textNombre.setText(tEmpleado.getNombre());
			textTelefono.setText(tEmpleado.getTelefono());
			textSueldoBase.setText(tEmpleado.getSueldoBase() + "");
			textDepartamento.setText(tEmpleado.getDepartamento().getIdDepartamento() + "");
			textDNI.setText(tEmpleado.getDNI() + "");

			btnFinalizar.setEnabled(true);
			textNombre.setEditable(true);
			textTelefono.setEditable(true);
			textSueldoBase.setEditable(true);
			textDepartamento.setEditable(true);
			textDNI.setEditable(true);

			if (tEmpleado instanceof TEmpleadoTiempoCompleto) {
				lblPlus.setVisible(true);
				textPlus.setVisible(true);
				textPlus.setEditable(true);
				textPlus.setText(((TEmpleadoTiempoCompleto) tEmpleado).getPluses() + "");
				textNumHoras.setVisible(false);
				lblNumHoras.setVisible(false);
			}

			if (tEmpleado instanceof TEmpleadoTiempoParcial) {
				textNumHoras.setVisible(true);
				textNumHoras.setEditable(true);
				lblNumHoras.setVisible(true);
				textNumHoras.setText(((TEmpleadoTiempoParcial) tEmpleado).getNumHoras() + "");
				lblPlus.setVisible(false);
				textPlus.setVisible(false);
			}

			break;
		case Events.BUSCAR_MODIFICAR_EMPLEADO_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el empleado");
			break;
		}
	}
}
