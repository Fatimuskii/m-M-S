/**
 * 
 */
package Presentacion.Venta;

import javax.swing.border.EmptyBorder;

import Negocio.Venta.imp.TVenta;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
* @generated "UML a Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
*/
public class GUIVentaImp extends GUIVenta {
	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIAbrirVenta gUIAbrirVenta;

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIModificarVenta gUIModificarVenta;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIMostrarVenta gUIMostrarVenta;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIListarVentas gUIListarVentas;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	private GUIDevolucion gUIDevolucion;

	private TVenta tVentaActual;
	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a Java
	 *            (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */

	JButton btnAbrirNuevaVenta;
	JButton btnCerrarUnaVenta;
	JButton btnListarVentas;
	JButton btnAadirquitarProductos;
	JButton btnBuscarVenta;
	JButton btnDevolucinDeUn;
	//
	JPanel contentPane;

	public GUIVentaImp() {

		super();
		gUIAbrirVenta = new GUIAbrirVenta();
		gUIMostrarVenta = new GUIMostrarVenta();
		gUIListarVentas = new GUIListarVentas();
		gUIDevolucion = new GUIDevolucion();

		contentPane = new JPanel();
		setResizable(false);
		initGUI();
	}

	public void initGUI() {

		setTitle("VENTA");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 346);

		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuDeVenta = new JLabel("MENU DE VENTA");
		lblMenuDeVenta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenuDeVenta.setBounds(137, 33, 171, 14);
		contentPane.add(lblMenuDeVenta);

		// Abrir venta
		btnAbrirNuevaVenta = new JButton("Abrir nueva venta");
		btnAbrirNuevaVenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAbrirNuevaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAbrirVenta.limpiarGUI();
				gUIAbrirVenta.setVisible(true);
			}
		});
		btnAbrirNuevaVenta.setBounds(50, 76, 171, 40);
		contentPane.add(btnAbrirNuevaVenta);

		// Cerrar venta
		btnCerrarUnaVenta = new JButton("Cerrar venta");
		btnCerrarUnaVenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCerrarUnaVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TVenta ventaAbierta = getVentaActual();
				Controlador.getInstance().accion(new Contexto(Events.CERRAR_VENTA, ventaAbierta));
			}
		});
		btnCerrarUnaVenta.setBounds(231, 76, 171, 40);
		contentPane.add(btnCerrarUnaVenta);

		// Listar
		btnListarVentas = new JButton("Listar Ventas");
		btnListarVentas.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnListarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getInstance().accion(new Contexto(Events.LISTAR_VENTAS, null));
			}
		});
		btnListarVentas.setBounds(50, 133, 171, 40);
		contentPane.add(btnListarVentas);

		// Añadir/quitar productos

		btnAadirquitarProductos = new JButton("A\u00F1adir/Quitar Productos ");
		btnAadirquitarProductos.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnAadirquitarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModificarVenta = new GUIModificarVenta(tVentaActual);
				gUIModificarVenta.limpiarGUI();
				gUIModificarVenta.setVisible(true);
			}
		});
		btnAadirquitarProductos.setBounds(231, 133, 171, 40);
		contentPane.add(btnAadirquitarProductos);

		// Busqueda de venta por ID.

		JLabel lblIdVenta = new JLabel("Id Venta:");
		lblIdVenta.setBounds(50, 207, 60, 14);
		contentPane.add(lblIdVenta);

		JTextField textIdVenta = new JTextField();
		textIdVenta.setBounds(120, 199, 101, 30);
		contentPane.add(textIdVenta);
		textIdVenta.setColumns(10);

		btnBuscarVenta = new JButton("Buscar venta");
		btnBuscarVenta.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnBuscarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textIdVenta.getText().equals("")) {

					try {
						int idVenta = Integer.parseInt(textIdVenta.getText());
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_VENTA, idVenta));

					} catch (Exception ex) {
						System.out.println(ex.getMessage());
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un id para buscar", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarVenta.setBounds(231, 194, 171, 40);
		contentPane.add(btnBuscarVenta);
		setBotonesVentaAbierta(false);

		btnDevolucinDeUn = new JButton("Devoluci\u00F3n de un producto");
		btnDevolucinDeUn.setForeground(Color.RED);
		btnDevolucinDeUn.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDevolucinDeUn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIDevolucion.limpiarGUI();
				gUIDevolucion.setVisible(true);
			}
		});
		btnDevolucinDeUn.setBounds(231, 255, 171, 40);
		contentPane.add(btnDevolucinDeUn);

	}

	// Botones inactivos mientras que no haya un venta activa/abierta
	public void setBotonesVentaAbierta(boolean estado) {

		this.btnCerrarUnaVenta.setEnabled(estado);
		this.btnAadirquitarProductos.setEnabled(estado);
	}

	@Override
	public TVenta getVentaActual() {
		return this.tVentaActual;
	}

	@Override
	public void setVenta(TVenta tventa) {
		this.tVentaActual = tventa;
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch (contexto.getEvento()) {

		case Events.ABRIR_VENTA_OK:
			this.tVentaActual = (TVenta) contexto.getDato();
			this.btnAbrirNuevaVenta.setEnabled(false);
			setBotonesVentaAbierta(true);
			JOptionPane.showMessageDialog(new JFrame(), "Se ha abierto un nueva Venta", "Abrir Venta",
					JOptionPane.INFORMATION_MESSAGE);

			break;
		case Events.ABRIR_VENTA_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Vaya, algo ha ido mal...", "Abrir Venta",
					JOptionPane.ERROR_MESSAGE);
			this.btnAbrirNuevaVenta.setEnabled(true);
			setBotonesVentaAbierta(false);
			break;

		case Events.BUSCAR_VENTA_OK:
			gUIMostrarVenta.limpiarGUI();
			gUIMostrarVenta.actualizar(contexto);
			gUIMostrarVenta.setVisible(true);
			break;

		case Events.BUSCAR_VENTA_KO:
			gUIMostrarVenta.limpiarGUI();
			gUIMostrarVenta.actualizar(contexto);
			break;
		case Events.LISTAR_VENTAS_OK:
			gUIListarVentas.limpiarGUI();
			gUIListarVentas.actualizar(contexto);
			gUIListarVentas.setVisible(true);
			break;

		case Events.LISTAR_VENTAS_KO:
			gUIListarVentas.limpiarGUI();
			gUIListarVentas.actualizar(contexto);
			break;

		case Events.MODIFICAR_VENTA_OK:
			gUIModificarVenta.limpiarGUI();
			gUIModificarVenta.actualizar(contexto);
			gUIModificarVenta.setVisible(true);
			break;
		case Events.MODIFICAR_VENTA_KO:
			gUIModificarVenta.limpiarGUI();
			gUIModificarVenta.actualizar(contexto);
			gUIModificarVenta.setVisible(true);
			break;
		case Events.CERRAR_VENTA_OK:
			this.btnAbrirNuevaVenta.setEnabled(true);
			setBotonesVentaAbierta(false);
			if ((int) contexto.getDato() == -4)
				JOptionPane.showMessageDialog(new JFrame(), "Se ha cancelado la venta.", "Cerrar Venta",
						JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(new JFrame(), "Se ha creado la venta con id:" + (int) contexto.getDato(),
						"Cerrar Venta", JOptionPane.INFORMATION_MESSAGE);
			break;
		case Events.CERRAR_VENTA_KO:
			JOptionPane.showMessageDialog(new JFrame(), "Error: " + contexto.getDato(), "Cerrar Venta",
					JOptionPane.ERROR_MESSAGE);
			break;
		case Events.DEVOLUCION_OK:
			gUIDevolucion.limpiarGUI();
			gUIDevolucion.actualizar(contexto);

			break;
		case Events.DEVOLUCION_KO:
			gUIDevolucion.limpiarGUI();
			gUIDevolucion.actualizar(contexto);

			break;

		case Events.MOSTRAR_FACTURA_OK:
			gUIMostrarVenta.actualizar(contexto);
			break;
		case Events.MOSTRAR_FACTURA_KO:
			gUIMostrarVenta.actualizar(contexto);
			break;

		}

	}

	/*
	 * switch (contexto.getEvento()) { case Events.ABRIR_VENTA_OK:
	 * JOptionPane.showMessageDialog(new JFrame(),
	 * "Se ha abierto un nueva Venta", "Abrir Venta",
	 * JOptionPane.INFORMATION_MESSAGE); break; case Events.ABRIR_VENTA_KO:
	 * JOptionPane.showMessageDialog(new JFrame(), "Vaya, algo ha ido mal...",
	 * "Abrir Venta", JOptionPane.ERROR_MESSAGE); break; }
	 * 
	 */

}