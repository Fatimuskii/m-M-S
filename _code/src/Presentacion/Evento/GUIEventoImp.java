/**
 * 
 */
package Presentacion.Evento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
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
public class GUIEventoImp extends GUIEvento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8199450460558298423L;
	
	private GUIAltaEvento gUIAltaEvento;
	private GUIBajaEvento gUIBajaEvento;
	private GUIBuscarEvento gUIBuscarEvento;
	private GUIModificarEvento gUIModificarEvento;
	private GUIListarEventos gUIListarEventos;
	private GUIMostrarEmpleadosDeEvento gUIMostrarEmpleadosDeEvento;
	private GUIAñadirEmpleadoAEvento gUIAñadirEmpleadoaEvento;
	private GUIEliminarEmpleadoDeEvento gUIEliminarEmpleadoDeEvento;
	
	private JPanel contentPane;

	public GUIEventoImp(){
		super();

		gUIModificarEvento = new GUIModificarEvento();
		gUIBuscarEvento = new GUIBuscarEvento();
		gUIBajaEvento = new GUIBajaEvento();
		gUIAltaEvento = new GUIAltaEvento();
		gUIListarEventos = new GUIListarEventos();
		gUIMostrarEmpleadosDeEvento = new GUIMostrarEmpleadosDeEvento();
		gUIAñadirEmpleadoaEvento = new GUIAñadirEmpleadoAEvento();
		gUIEliminarEmpleadoDeEvento = new GUIEliminarEmpleadoDeEvento();
		setResizable(false);
		initGUI();
	}

	/**
	 * <!-- begin-UML-doc --> <!-- end-UML-doc -->
	 * 
	 * @generated "UML a JPA
	 *            (com.ibm.xtools.transform.uml2.ejb3.java.jpa.internal.UML2JPATransform)"
	 */
	private void initGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAltaEvento = new JButton("Alta Evento");
		btnAltaEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAltaEvento.clearData();
				gUIAltaEvento.setVisible(true);
			}
		});
		btnAltaEvento.setBounds(10, 11, 200, 45);
		contentPane.add(btnAltaEvento);

		JButton btnBajaEvento = new JButton("Baja Evento");
		btnBajaEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBajaEvento.clearData();
				gUIBajaEvento.setVisible(true);
			}
		});
		btnBajaEvento.setBounds(224, 11, 200, 45);
		contentPane.add(btnBajaEvento);

		JButton btnModificarEvento = new JButton("Modificar Evento");
		btnModificarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIModificarEvento.clearData();
				gUIModificarEvento.setVisible(true);
			}
		});
		btnModificarEvento.setBounds(10, 67, 200, 45);
		contentPane.add(btnModificarEvento);

		JButton btnBuscarEvento = new JButton("Buscar Evento");
		btnBuscarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIBuscarEvento.clearData();
				gUIBuscarEvento.setVisible(true);
			}
		});
		btnBuscarEvento.setBounds(224, 67, 200, 45);
		contentPane.add(btnBuscarEvento);

		JButton btnListarAnadirEmpleado = new JButton("Añadir Empleado a Evento");
		btnListarAnadirEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAñadirEmpleadoaEvento.clearData();
				gUIAñadirEmpleadoaEvento.setVisible(true);
			}
		});
		btnListarAnadirEmpleado.setBounds(10, 123, 200, 45);
		contentPane.add(btnListarAnadirEmpleado);

		JButton btnBuscarEliminarEmpleado = new JButton("Eliminar Empleado de Evento");
		btnBuscarEliminarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIEliminarEmpleadoDeEvento.clearData();
				gUIEliminarEmpleadoDeEvento.setVisible(true);
			}
		});
		btnBuscarEliminarEmpleado.setBounds(224, 123, 200, 45);
		contentPane.add(btnBuscarEliminarEmpleado);

		JButton btnListarEventos = new JButton("Listar Eventos");
		btnListarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIListarEventos.clearData();
				gUIListarEventos.setVisible(true);
				Controlador.getInstance().accion(new Contexto(Events.LISTAR_EVENTOS, null));
				gUIListarEventos.toFront();
			}
		});
		btnListarEventos.setBounds(10, 179, 200, 45);
		contentPane.add(btnListarEventos);
		
		JButton btnMostrarEmplDeEvento = new JButton("Empleados de Evento");
		btnMostrarEmplDeEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIMostrarEmpleadosDeEvento.clearData();
				gUIMostrarEmpleadosDeEvento.setVisible(true);
			}
		});
		btnMostrarEmplDeEvento.setBounds(224, 179, 200, 45);
		contentPane.add(btnMostrarEmplDeEvento);
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_EVENTO_OK:
		case Events.ALTA_EVENTO_KO:
			gUIAltaEvento.actualizar(contexto);
			break;
		case Events.BAJA_EVENTO_OK:
		case Events.BAJA_EVENTO_KO:
			gUIBajaEvento.actualizar(contexto);
			break;
		case Events.BUSCAR_EVENTO_OK:
		case Events.BUSCAR_EVENTO_KO:
			gUIBuscarEvento.actualizar(contexto);
			break;
		case Events.BUSCAR_MODIFICAR_EVENTO_OK:
		case Events.BUSCAR_MODIFICAR_EVENTO_KO:
			
		case Events.MODIFICAR_EVENTO_OK:
		case Events.MODIFICAR_EVENTO_KO:
			gUIModificarEvento.actualizar(contexto);
			break;
		case Events.LISTAR_EVENTOS_OK:
		case Events.LISTAR_EVENTOS_KO:
			gUIListarEventos.actualizar(contexto);
			break;
		case Events.MOSTRAR_EMPLEADOS_EVENTO_OK:
		case Events.MOSTRAR_EMPLEADOS_EVENTO_KO:
			gUIMostrarEmpleadosDeEvento.actualizar(contexto);
			break;
		case Events.AÑADIR_EMPLEADO_EVENTO_OK:
		case Events.AÑADIR_EMPLEADO_EVENTO_KO:
			gUIAñadirEmpleadoaEvento.actualizar(contexto);
			break;
		case Events.ELIMINAR_EMPLEADO_EVENTO_OK:
		case Events.ELIMINAR_EMPLEADO_EVENTO_KO:
			gUIEliminarEmpleadoDeEvento.actualizar(contexto);
			break;
		}

	}
}