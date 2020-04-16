package Presentacion.Cliente;

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
public class GUIClienteImp extends GUICliente {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField buscarID;
	
	private GUIAltaCliente guiAltaCliente;
	private GUIBajaCliente guiBajaCliente;
	private GUIModificarCliente guiModificarCliente;
	private GUIListarCliente guiListarCliente;
	private GUIBuscarCliente guiBuscarClienteID;
	private GUIClientesConComprasDesdeFecha gUIClientesConComprasDesdeFecha;
	
	
	public GUIClienteImp() {
		super();
		this.contentPane = new JPanel();
		this.guiAltaCliente = new GUIAltaCliente();
		this.guiBajaCliente = new GUIBajaCliente();
		this.guiModificarCliente = new GUIModificarCliente();
		this.guiListarCliente = new GUIListarCliente();
		this.guiBuscarClienteID = new GUIBuscarCliente();
		this.gUIClientesConComprasDesdeFecha = new GUIClientesConComprasDesdeFecha();
		this.setFocusable(true);
		initGUI();
	}
	
	
	public void initGUI() {
		setTitle("CLIENTES");

		setBounds(100, 100, 450, 300);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170,230,100));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMenuDeCliente = new JLabel("MENU DE CLIENTE");
		lblMenuDeCliente.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblMenuDeCliente.setBounds(137, 18, 171, 14);
		panel.add(lblMenuDeCliente);
		
		//ALTA
		JButton btnAltaCliente = new JButton("Alta");
		btnAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiAltaCliente.clearData();
				guiAltaCliente.setVisible(true);
			}
		});
		
		btnAltaCliente.setBounds(30, 66, 89, 23);
		panel.add(btnAltaCliente);
		
		
		//BAJA
		JButton btnBajaCliente = new JButton("Baja");
		btnBajaCliente.setBounds(172, 66, 89, 23);
		btnBajaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiBajaCliente.clearData();
				guiBajaCliente.setVisible(true);
			}
		});
		panel.add(btnBajaCliente);
		
		
		//MODIFICAR
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(312, 66, 89, 23);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiModificarCliente.clearData();
				guiModificarCliente.setVisible(true);
			}
		});
		panel.add(btnModificar);
		
		
		//LISTAR TODOS
		JButton listarTodos = new JButton("Listar todos");
		listarTodos.setBounds(297, 163, 102, 23);
		listarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				guiListarCliente.clearData();
				guiListarCliente.setVisible(true);
				Controlador.getInstance().accion(new Contexto(Events.LISTAR_CLIENTE, null));
				guiListarCliente.toFront();
			}
		});
		panel.add(listarTodos);
			
		
		//ClientesConComprasDesdeFecha
		JButton btnClComprDesdeFecha = new JButton("Buscar clientes con compras desde una fecha");
		btnClComprDesdeFecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					gUIClientesConComprasDesdeFecha.clearData();
					gUIClientesConComprasDesdeFecha.setVisible(true);
					
				}
			});
		btnClComprDesdeFecha.setBounds(67, 217, 306, 23);
		panel.add(btnClComprDesdeFecha);
		
		
		buscarID = new JTextField();
		buscarID.setBounds(136, 135, 151, 20);
		buscarID.setColumns(10);
		panel.add(buscarID);

		
		//BUSCAR POR ID
		JButton btnBuscarID = new JButton("Buscar");
		btnBuscarID.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						int id = Integer.parseInt(buscarID.getText());
						if(id > 0){
							guiBuscarClienteID.clearData();
							guiBuscarClienteID.setId(buscarID.getText());
							Controlador.getInstance().accion(new Contexto(Events.BUSCAR_CLIENTE, id));
							
							if(guiBuscarClienteID.getWindow())
								guiBuscarClienteID.setVisible(true);
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
	}
	
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_CLIENTE_OK:
			guiAltaCliente.actualizar(contexto);
			break;
		case Events.ALTA_CLIENTE_KO:
			guiAltaCliente.actualizar(contexto);
			break;
		case Events.BAJA_CLIENTE_OK:
			guiBajaCliente.actualizar(contexto);
			break;
		case Events.BAJA_CLIENTE_KO:
			guiBajaCliente.actualizar(contexto);
			break;
		case Events.MODIFICAR_CLIENTE_OK:
			guiModificarCliente.actualizar(contexto);
			break;
		case Events.MODIFICAR_CLIENTE_KO:
			guiModificarCliente.actualizar(contexto);
			break;
		case Events.BUSCAR_CLIENTE_OK:
			guiBuscarClienteID.actualizar(contexto);
			break;
		case Events.BUSCAR_CLIENTE_KO:
			guiBuscarClienteID.actualizar(contexto);
			break;
		case Events.LISTAR_CLIENTE_OK:
			guiListarCliente.actualizar(contexto);
			break;
		case Events.LISTAR_CLIENTE_KO:
			guiListarCliente.actualizar(contexto);
			break;
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA_OK:
			gUIClientesConComprasDesdeFecha.actualizar(contexto);
			break;
		case Events.CLIENTES_CON_COMPRAS_DESDE_FECHA_KO:
			gUIClientesConComprasDesdeFecha.actualizar(contexto);
			break;
		case Events.MODIFICAR_CLIENTE_BUSCAR_OK:
			guiModificarCliente.actualizar(contexto);
			break;
		case Events.MODIFICAR_CLIENTE_BUSCAR_KO:
			guiModificarCliente.actualizar(contexto);
			break;
		}
	}
}
