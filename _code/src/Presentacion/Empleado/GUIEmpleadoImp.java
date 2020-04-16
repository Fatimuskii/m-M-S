package Presentacion.Empleado;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class GUIEmpleadoImp extends GUIEmpleado {

private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textBuscarID;
	private JTextField textBuscarDNI;
	
	private GUIAltaEmpleado guiAltaEmpleado;
	private GUIBajaEmpleado guiBajaEmpleado;
	private GUIModificarEmpleado guiModificarEmpleado;
	private GUIListarEmpleado guiListarEmpleado;
	private GUIBuscarEmpleado guiBuscarEmpleado;
	
	public GUIEmpleadoImp() {
		super();
		this.contentPane = new JPanel();
		
		this.guiAltaEmpleado = new GUIAltaEmpleado();
		this.guiBajaEmpleado = new GUIBajaEmpleado();
		this.guiModificarEmpleado = new GUIModificarEmpleado();
		this.guiListarEmpleado = new GUIListarEmpleado();
		this.guiBuscarEmpleado = new GUIBuscarEmpleado();
		this.setFocusable(true);
		initGUI();
	}
	
	
	public void initGUI() {
		setTitle("EMPLEADOS");

		setBounds(100, 100, 450, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255,255,153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMenuDeCliente = new JLabel("MENU DE EMPLEADO");
		lblMenuDeCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenuDeCliente.setBounds(137, 18, 200, 14);
		panel.add(lblMenuDeCliente);
		
		//ALTA
		JButton btnAltaEmpleado = new JButton("Alta");
		btnAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiAltaEmpleado.clearData();
				guiAltaEmpleado.setVisible(true);
			}
		});
		
		btnAltaEmpleado.setBounds(30, 66, 89, 23);
		panel.add(btnAltaEmpleado);
		
		
		//BAJA
		JButton btnBajaEmpleado = new JButton("Baja");
		btnBajaEmpleado.setBounds(172, 66, 89, 23);
		btnBajaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiBajaEmpleado.clearData();
				guiBajaEmpleado.setVisible(true);
			}
		});
		panel.add(btnBajaEmpleado);
		
		
		//MODIFICAR
		JButton btnModificarEmpleado = new JButton("Modificar");
		btnModificarEmpleado.setBounds(312, 66, 89, 23);
		btnModificarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiModificarEmpleado.clearData();
				guiModificarEmpleado.setVisible(true);
			}
		});
		panel.add(btnModificarEmpleado);
		
		
		//LISTAR TODOS
		JButton listarTodos = new JButton("Listar todos");
		listarTodos.setBounds(297, 194, 102, 23);
		listarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiListarEmpleado.clearData();
				guiListarEmpleado.setVisible(true);
				Controlador.getInstance().accion(new Contexto(Events.LISTAR_EMPLEADO, null));
				guiListarEmpleado.toFront();
			}
		});
		panel.add(listarTodos);
		
		
		textBuscarDNI = new JTextField();
		textBuscarDNI.setBounds(136, 164, 151, 20);
		textBuscarDNI.setColumns(10);
		panel.add(textBuscarDNI);
	
		//BUSCAR POR DNI
		JButton buscarDNI = new JButton("Buscar");
		buscarDNI.setBounds(297, 163, 89, 23);
		buscarDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String dni = textBuscarDNI.getText();
					if(dni.length() == 9){
						guiBuscarEmpleado.clearData();
						guiBuscarEmpleado.setDNI(textBuscarDNI.getText());
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_EMPLEADO_POR_DNI, dni));
						
						if(guiBuscarEmpleado.getWindow())
							guiBuscarEmpleado.setVisible(true);
						}
						else{
							JOptionPane.showMessageDialog(new JFrame(),
									"Información errónea (DNI tiene que contener 9 caracteres)", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		panel.add(buscarDNI);
		

		textBuscarID = new JTextField();
		textBuscarID.setBounds(136, 135, 151, 20);
		textBuscarID.setColumns(10);
		panel.add(textBuscarID);

		
		//BUSCAR POR ID
		JButton btnBuscarID = new JButton("Buscar");
		btnBuscarID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						int id = Integer.parseInt(textBuscarID.getText());
						if(id > 0){
							guiBuscarEmpleado.clearData();
							guiBuscarEmpleado.setId(textBuscarID.getText());
							Controlador.getInstance().accion(new Contexto(Events.BUSCAR_EMPLEADO, id));
							
							if(guiBuscarEmpleado.getWindow())
								guiBuscarEmpleado.setVisible(true);
							}
							else{
								JOptionPane.showMessageDialog(new JFrame(),
										"Información errónea (Id tiene que ser mayor que 0)", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
						}
				}
			});
		btnBuscarID.setBounds(297, 134, 89, 23);
		panel.add(btnBuscarID);
		
		JLabel lblBuscarPorId = new JLabel("Buscar por ID");
		lblBuscarPorId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarPorId.setBounds(30, 137, 85, 14);
		panel.add(lblBuscarPorId);
		
		JLabel lblBuscarPorDNI = new JLabel("Buscar por DNI");
		lblBuscarPorDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBuscarPorDNI.setBounds(30, 167, 85, 14);
		panel.add(lblBuscarPorDNI);
	}
	
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_EMPLEADO_OK:
			guiAltaEmpleado.actualizar(contexto);
			break;
		case Events.ALTA_EMPLEADO_KO:
			guiAltaEmpleado.actualizar(contexto);
			break;
		case Events.BAJA_EMPLEADO_OK:
			guiBajaEmpleado.actualizar(contexto);
			break;
		case Events.BAJA_EMPLEADO_KO:
			guiBajaEmpleado.actualizar(contexto);
			break;
		case Events.MODIFICAR_EMPLEADO_OK:
			guiModificarEmpleado.actualizar(contexto);
			break;
		case Events.MODIFICAR_EMPLEADO_KO:
			guiModificarEmpleado.actualizar(contexto);
			break;
		case Events.BUSCAR_EMPLEADO_OK:
			guiBuscarEmpleado.actualizar(contexto);
			break;
		case Events.BUSCAR_EMPLEADO_KO:
			guiBuscarEmpleado.actualizar(contexto);
			break;
		case Events.BUSCAR_EMPLEADO_POR_DNI_OK:
			guiBuscarEmpleado.actualizar(contexto);
			break;
		case Events.BUSCAR_EMPLEADO_POR_DNI_KO:
			guiBuscarEmpleado.actualizar(contexto);
			break;
		case Events.LISTAR_EMPLEADO_OK:
			guiListarEmpleado.actualizar(contexto);
			break;
		case Events.LISTAR_EMPLEADO_KO:
			guiListarEmpleado.actualizar(contexto);
			break;
		case Events.BUSCAR_MODIFICAR_EMPLEADO_OK:
			guiModificarEmpleado.actualizar(contexto);
			break;
		case Events.BUSCAR_MODIFICAR_EMPLEADO_KO:
			guiModificarEmpleado.actualizar(contexto);
			break;
		}
	}

}
