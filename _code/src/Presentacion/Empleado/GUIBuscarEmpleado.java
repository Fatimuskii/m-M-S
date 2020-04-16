package Presentacion.Empleado;

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

import Negocio.Empleado.imp.TEmpleado;
import Negocio.Empleado.imp.TEmpleadoTiempoCompleto;
import Negocio.Empleado.imp.TEmpleadoTiempoParcial;
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
 * @generated "UML a JPA
 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
 */

public class GUIBuscarEmpleado extends GUIEmpleado {

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
	private JTextField textSueldoBase;
	private JTextField textDepartamento;
	private JTextField textPlus;
	private JTextField textNumHoras;
	private JLabel lblPlus;
	private JLabel lblDepartamento;
	private JLabel lblNumHoras;
	private boolean window;

	private String id;
	private String dni;
	private JLabel lblActivo;
	private JLabel lblInactivo;

	public GUIBuscarEmpleado() {
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
		lblNombre.setBounds(60, 27, 90, 14);
		contentPane.add(lblNombre);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(60, 58, 90, 14);
		contentPane.add(lblDNI);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(60, 89, 90, 14);
		contentPane.add(lblTelefono);

		JLabel lblSueldoBase = new JLabel("Sueldo Base:");
		lblSueldoBase.setBounds(60, 120, 90, 14);
		contentPane.add(lblSueldoBase);

		lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(60, 151, 120, 14);
		contentPane.add(lblDepartamento);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(180, 24, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		textDNI = new JTextField();
		textDNI.setEditable(false);
		textDNI.setBounds(180, 55, 150, 20);
		contentPane.add(textDNI);
		textDNI.setColumns(10);

		textTelefono = new JTextField();
		textTelefono.setEditable(false);
		textTelefono.setBounds(180, 86, 150, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);

		textSueldoBase = new JTextField();
		textSueldoBase.setEditable(false);
		textSueldoBase.setBounds(180, 117, 150, 20);
		contentPane.add(textSueldoBase);
		textSueldoBase.setColumns(10);
		
		textDepartamento = new JTextField();
		textDepartamento.setEditable(false);
		textDepartamento.setBounds(180, 148, 150, 20);
		contentPane.add(textDepartamento);
		textDepartamento.setColumns(10);
		
		lblPlus = new JLabel("Plus:");
		lblPlus.setBounds(60, 181, 120, 14);
		contentPane.add(lblPlus);

		lblNumHoras = new JLabel("Número de horas:");
		lblNumHoras.setBounds(60, 181, 120, 14);
		contentPane.add(lblNumHoras);

		textPlus = new JTextField();
		textPlus.setEditable(false);
		textPlus.setBounds(180, 178, 150, 20);
		contentPane.add(textPlus);
		textPlus.setColumns(10);

		textNumHoras = new JTextField();
		textNumHoras.setEditable(false);
		textNumHoras.setBounds(180, 178, 150, 20);
		contentPane.add(textNumHoras);
		textNumHoras.setColumns(10);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(330, 237, 89, 23);
		contentPane.add(btnAceptar);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(60, 210, 90, 14);
		contentPane.add(lblEstado);

		lblActivo = new JLabel("Activo");
		lblActivo.setForeground(Color.GREEN);
		lblActivo.setBounds(160, 210, 120, 14);
		contentPane.add(lblActivo);

		lblInactivo = new JLabel("Inactivo");
		lblInactivo.setForeground(Color.RED);
		lblInactivo.setBounds(160, 210, 120, 14);
		contentPane.add(lblInactivo);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDNI() {
		return this.dni;
	}

	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public void clearData() {
		textNombre.setText("");
		textSueldoBase.setText("");
		textTelefono.setText("");
		textDNI.setText("");
		textPlus.setText("");
		textNumHoras.setText("");
		textDepartamento.setText("");
		textPlus.setVisible(false);
		textNumHoras.setVisible(false);
		
		lblPlus.setVisible(false);
		lblNumHoras.setVisible(false);
		lblActivo.setVisible(false);
		lblInactivo.setVisible(false);
	}

	public boolean getWindow() {
		return window;
	}

	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {
		case Events.BUSCAR_EMPLEADO_OK:
			TEmpleado tEmpleado = (TEmpleado) contexto.getDato();
			window = true;

			textNombre.setText(tEmpleado.getNombre());
			textTelefono.setText(tEmpleado.getTelefono() + "");
			textSueldoBase.setText(tEmpleado.getSueldoBase() + "");
			textDNI.setText(tEmpleado.getDNI() + "");
			textDepartamento.setText(tEmpleado.getDepartamento().getIdDepartamento()+"");

			if (tEmpleado instanceof TEmpleadoTiempoCompleto) {
				textPlus.setText(((TEmpleadoTiempoCompleto)tEmpleado).getPluses()+"");
				textPlus.setVisible(true);
				lblPlus.setVisible(true);
				textNumHoras.setVisible(false);
				lblNumHoras.setVisible(false);
				
			}
			if (tEmpleado instanceof TEmpleadoTiempoParcial) {
				textNumHoras.setText(((TEmpleadoTiempoParcial)tEmpleado).getNumHoras()+"");
				textPlus.setVisible(false);
				lblPlus.setVisible(false);
				textNumHoras.setVisible(true);
				lblNumHoras.setVisible(true);
			}
			
			if (tEmpleado.getActivo()) {
				lblActivo.setVisible(true);
				lblInactivo.setVisible(false);
			} else {
				lblActivo.setVisible(false);
				lblInactivo.setVisible(true);
			}

			break;
		case Events.BUSCAR_EMPLEADO_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el empleado");
			window = false;
			break;
			
		case Events.BUSCAR_EMPLEADO_POR_DNI_OK:
			TEmpleado tEmpleado2 = (TEmpleado) contexto.getDato();
			window = true;

			textNombre.setText(tEmpleado2.getNombre());
			textTelefono.setText(tEmpleado2.getTelefono() + "");
			textSueldoBase.setText(tEmpleado2.getSueldoBase() + "");
			textDNI.setText(tEmpleado2.getDNI() + "");
			textDepartamento.setText(tEmpleado2.getDepartamento().getIdDepartamento()+"");

			if (tEmpleado2 instanceof TEmpleadoTiempoCompleto) {
				textPlus.setText(((TEmpleadoTiempoCompleto)tEmpleado2).getPluses()+"");
				textPlus.setVisible(true);
				lblPlus.setVisible(true);
				textNumHoras.setVisible(false);
				lblNumHoras.setVisible(false);
				
			}
			if (tEmpleado2 instanceof TEmpleadoTiempoParcial) {
				textNumHoras.setText(((TEmpleadoTiempoParcial)tEmpleado2).getNumHoras()+"");
				textPlus.setVisible(false);
				lblPlus.setVisible(false);
				textNumHoras.setVisible(true);
				lblNumHoras.setVisible(true);
			}
			
			if (tEmpleado2.getActivo()) {
				lblActivo.setVisible(true);
				lblInactivo.setVisible(false);
			} else {
				lblActivo.setVisible(false);
				lblInactivo.setVisible(true);
			}

			break;
		case Events.BUSCAR_EMPLEADO_POR_DNI_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el empleado");
			window = false;
			break;
		}
	}

}
