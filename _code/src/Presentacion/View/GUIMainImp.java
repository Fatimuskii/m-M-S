/**
 * 
 */
package Presentacion.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.*;

import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.Cliente.GUIClienteImp;
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
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIMainImp extends GUIMain {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	public GUIMainImp() {
		super();
		contentPane = new JPanel();
		
		contentPane.setVisible(true);
		new GUIClienteImp();
		setResizable(false);
		iniciarGUI();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private void iniciarGUI() {
		// begin-user-code

		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 455, 410);

		contentPane.setBackground(new Color(225, 157, 147)); // si queremos
																// cambiar el
																// color seria
																// aqui con
																// codigo RGB
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// CABECERA

		JLabel lblMenuPrincipal = new JLabel("MENU PRINCIPAL");
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenuPrincipal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMenuPrincipal.setBounds(128, 11, 186, 23);
		contentPane.add(lblMenuPrincipal);

		// Clientes
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientes.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblClientes.setBounds(30, 165, 120, 14);
		contentPane.add(lblClientes);

		JButton btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.CREAR_GUI_CLIENTE, null));
			}
		});
		btnClientes.setBounds(30, 45, 120, 109);
		btnClientes.setIcon(new ImageIcon(new ImageIcon("imagenes//clientes.png")
				.getImage().getScaledInstance(btnClientes.getWidth(), btnClientes.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(btnClientes);

		

		// Productos
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblProductos.setBounds(167, 165, 120, 14);
		contentPane.add(lblProductos);

		JButton btnProductos = new JButton("PRODUCTOS");
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.CREAR_GUI_PRODUCTO, null));
			}
		});
		btnProductos.setBounds(167, 45, 120, 109);
		btnProductos.setIcon(new ImageIcon(new ImageIcon("imagenes//productos.png") // aqui irá dir de
				// la imagen
.getImage().getScaledInstance(btnClientes.getWidth(), btnClientes.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(btnProductos);

		// Ventas

		JLabel lblVentas = new JLabel("Ventas");
		lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentas.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblVentas.setBounds(297, 165, 120, 14);
		contentPane.add(lblVentas);

		JButton btnVentas = new JButton("VENTAS");
		btnVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.CREAR_GUI_VENTA, null));
			}
		});

		btnVentas.setBounds(297, 45, 120, 109);
		btnVentas.setIcon(new ImageIcon(new ImageIcon("imagenes//ventas.png") // aqui irá dir de
				// la imagen
.getImage().getScaledInstance(btnClientes.getWidth(), btnClientes.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(btnVentas);
		
		
		// EMPLEADOS
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblEmpleados.setBounds(30, 325, 120, 14);
		contentPane.add(lblEmpleados);
		
		JButton btbEmpleados = new JButton("EMPLEADOS");
		btbEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.CREAR_GUI_EMPLEADO, null));
			}
		});
		btbEmpleados.setBounds(30, 205, 120, 109);
		btbEmpleados.setIcon(new ImageIcon(new ImageIcon("imagenes//empleados.png") // aqui irá dir de
				// la imagen
.getImage().getScaledInstance(btbEmpleados.getWidth(), btbEmpleados.getHeight(), Image.SCALE_DEFAULT)));
		
		contentPane.add(btbEmpleados);
		
		
		
		// EVENTOS
		
		JLabel lblEventos = new JLabel("Eventos");
		lblEventos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventos.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblEventos.setBounds(167, 325, 120, 14);
		contentPane.add(lblEventos);
		
		JButton btnEventos = new JButton("EVENTOS");
		btnEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.CREAR_GUI_EVENTO, null));
			}
		});
		btnEventos.setBounds(167, 205, 120, 109);
		btnEventos.setIcon(new ImageIcon(new ImageIcon("imagenes//calendario.png") // aqui irá dir de
				// la imagen
.getImage().getScaledInstance(btnEventos.getWidth(), btnEventos.getHeight(), Image.SCALE_DEFAULT)));
		contentPane.add(btnEventos);
		
		
		// DEPARTAMENTOS
		JLabel lblDepartamentos = new JLabel("Departamentos");
		lblDepartamentos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepartamentos.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 14));
		lblDepartamentos.setBounds(297, 325, 120, 14);
		contentPane.add(lblDepartamentos);
		

		JButton btnDepartamentos = new JButton("DEPARTAMENTOS");
		btnDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.CREAR_GUI_DEPARTAMENTO, null));
			}
		});
		
		btnDepartamentos.setBounds(297, 205, 120, 109);
		btnDepartamentos.setIcon(new ImageIcon(new ImageIcon("imagenes//departamentos.png") // aqui irá dir de
				// la imagen
.getImage().getScaledInstance(btnDepartamentos.getWidth(), btnDepartamentos.getHeight(), Image.SCALE_DEFAULT)));
		
		contentPane.add(btnDepartamentos);
		
	}

	@Override
	public void actualizar(Contexto contexto) {
		iniciarGUI();
	}
}