package Presentacion.Empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Departamento.imp.Departamento;
import Negocio.Departamento.imp.TDepartamento;
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

public class GUIAltaEmpleado extends GUIEmpleado {

	private static final long serialVersionUID = -4956741787151705240L;
	private JPanel contentPane;
	private JTextField textNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textPlus;
	private JTextField textDNI;
	private JTextField textTelefono;
	private JTextField textSueldoBase;
	private JTextField textNumHoras;
	private JTextField textDepartamento;
	private JLabel lblNumHoras;
	private JLabel lblPlus;
	private JLabel lblNombre;
	private JLabel lblDNI;
	private JRadioButton rdbtnTiempoCompleto;
	private JRadioButton rdbtnTiempoParcial;

	public GUIAltaEmpleado() {
		super();
		setResizable(false);
		initGUI();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */

	public void initGUI() {
		setTitle("Alta Empleado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 16, 94, 14);
		contentPane.add(lblNombre);

		lblDNI = new JLabel("DNI (9 caracteres):");
		lblDNI.setBounds(10, 53, 110, 14);
		contentPane.add(lblDNI);

		JLabel lblStock = new JLabel("Telefono:");
		lblStock.setBounds(10, 89, 94, 14);
		contentPane.add(lblStock);

		JLabel lblSueldo = new JLabel("Sueldo Base:");
		lblSueldo.setBounds(10, 125, 94, 14);
		contentPane.add(lblSueldo);

		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(10, 161, 94, 14);
		contentPane.add(lblDepartamento);

		lblPlus = new JLabel("Plus:");
		lblPlus.setBounds(20, 223, 118, 14);
		contentPane.add(lblPlus);
		lblPlus.setVisible(false);

		textPlus = new JTextField();
		textPlus.setBounds(150, 220, 86, 20);
		contentPane.add(textPlus);
		textPlus.setColumns(10);
		textPlus.setVisible(false);

		lblNumHoras = new JLabel("Numero de horas:");
		lblNumHoras.setBounds(15, 223, 118, 14);
		contentPane.add(lblNumHoras);
		lblNumHoras.setVisible(false);

		textNumHoras = new JTextField();
		textNumHoras.setBounds(150, 220, 86, 20);
		contentPane.add(textNumHoras);
		textNumHoras.setColumns(10);
		textNumHoras.setVisible(false);

		textNombre = new JTextField();
		textNombre.setBounds(150, 8, 310, 30);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textDNI = new JTextField();
		textDNI.setBounds(150, 45, 310, 30);
		contentPane.add(textDNI);
		textDNI.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setBounds(150, 81, 310, 30);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		textSueldoBase = new JTextField();
		textSueldoBase.setBounds(150, 117, 310, 30);
		contentPane.add(textSueldoBase);
		textSueldoBase.setColumns(10);

		textDepartamento = new JTextField();
		textDepartamento.setBounds(150, 153, 310, 30);
		contentPane.add(textDepartamento);
		textDepartamento.setColumns(10);

		rdbtnTiempoCompleto = new JRadioButton("Tiempo Completo");
		rdbtnTiempoCompleto.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lblPlus.setVisible(true);
				textPlus.setVisible(true);
				textNumHoras.setVisible(false);
				lblNumHoras.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnTiempoCompleto);
		rdbtnTiempoCompleto.setBounds(54, 190, 165, 23);
		contentPane.add(rdbtnTiempoCompleto);

		rdbtnTiempoParcial = new JRadioButton("Tiempo Parcial");
		rdbtnTiempoParcial.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lblPlus.setVisible(false);
				textPlus.setVisible(false);
				textNumHoras.setVisible(true);
				lblNumHoras.setVisible(true);
			}
		});
		buttonGroup.add(rdbtnTiempoParcial);
		rdbtnTiempoParcial.setBounds(249, 190, 120, 23);
		contentPane.add(rdbtnTiempoParcial);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textNombre.getText();
					String DNI = textDNI.getText();
					String telefono = textTelefono.getText();
					Float sueldoBase = Float.parseFloat(textSueldoBase.getText());
					int departamento = Integer.parseInt(textDepartamento.getText());
					TDepartamento dept = new TDepartamento(departamento, "", 0, true);
					int numHoras = 0;
					Float plus = 0.0f;
					boolean error = false;

					if (DNI.length() != 9) {
						JOptionPane.showMessageDialog(new JFrame(), "El DNI debe tener 9 caracteres", "Error",
								JOptionPane.ERROR_MESSAGE);
						error = true;
					}

					if (nombre.equals("") || telefono.equals("") || sueldoBase.equals("")) {
						JOptionPane.showMessageDialog(new JFrame(), "No puede haber campos vacíos", "Error",
								JOptionPane.ERROR_MESSAGE);
						error = true;
					}

					if (sueldoBase < 0) {
						JOptionPane.showMessageDialog(new JFrame(), "El sueldo no puede ser negativo", "Error",
								JOptionPane.ERROR_MESSAGE);
						error = true;
					}

					if (rdbtnTiempoCompleto.isSelected()) {
						plus = Float.parseFloat(textPlus.getText());
						if (plus < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Plus no puede ser negativo", "Error",
									JOptionPane.ERROR_MESSAGE);
							error = true;
						}

					} else if (rdbtnTiempoParcial.isSelected()) {
						numHoras = Integer.parseInt(textNumHoras.getText());
						if (numHoras < 0) {
							JOptionPane.showMessageDialog(new JFrame(), "Número de horas no puede ser negativo",
									"Error", JOptionPane.ERROR_MESSAGE);
							error = true;
						}
					}
					if (!error) {
						if (rdbtnTiempoCompleto.isSelected()) {
							TEmpleadoTiempoCompleto tTiempoCompleto = new TEmpleadoTiempoCompleto(DNI, nombre, telefono,
									sueldoBase, true, new Departamento(dept), plus);
							Controlador.getInstance().accion(new Contexto(Events.ALTA_EMPLEADO, tTiempoCompleto));
						} else if (rdbtnTiempoParcial.isSelected()) {
							TEmpleadoTiempoParcial tTiempoParcial = new TEmpleadoTiempoParcial(DNI, nombre, telefono,
									sueldoBase, true, new Departamento(dept), numHoras);
							Controlador.getInstance().accion(new Contexto(Events.ALTA_EMPLEADO, tTiempoParcial));
						}
					}

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(335, 250, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(222, 250, 89, 23);
		contentPane.add(btnSalir);

	}

	public void clearData() {
		lblPlus.setVisible(false);
		lblNumHoras.setVisible(false);
		textPlus.setVisible(false);
		textNumHoras.setVisible(false);

		rdbtnTiempoCompleto.setSelected(false);
		rdbtnTiempoParcial.setSelected(false);

		textNombre.setText("");
		buttonGroup.clearSelection();
		textPlus.setText("");
		textDNI.setText("");
		textTelefono.setText("");
		textNumHoras.setText("");
		textSueldoBase.setText("");
		textDepartamento.setText("");

	}

	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.ALTA_EMPLEADO_OK:
			JOptionPane.showMessageDialog(null, "Empleado " + contexto.getDato() + " dado de alta.");
			this.dispose();
			break;
		case Events.ALTA_EMPLEADO_KO:

			if ((int) contexto.getDato() == -2)
				JOptionPane.showMessageDialog(null, "Ya existe un empleado con ese DNI");

			else if ((int) contexto.getDato() == -1)
				JOptionPane.showMessageDialog(null, "No se ha encontrado el departamento");

			else
				JOptionPane.showMessageDialog(null, "No se puede reactivar un empleado de distinto tipo");

			break;
		}
	}

}
