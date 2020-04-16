package Presentacion.Departamento;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Controlador.Controlador;

public class GUIDepartamentoImp extends GUIDepartamento {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane text_idDept;

	// GUIS
	private GUIAltaDepartamento gUIAltaDepartamento;
	private GUIBuscarDepartamento gUIBuscarDepartamento;
	private GUIListarDepartamentos gUIListarDepartamentos;
	private GUIModificarDepartamento gUIModificarDepartamento;
	private GUICalcularNominasDepartamento gUICalcularNominasDepartamento;

	public GUIDepartamentoImp() {
		super();
		setResizable(false);

		this.gUIAltaDepartamento = new GUIAltaDepartamento();
		this.gUIBuscarDepartamento = new GUIBuscarDepartamento();
		this.gUIListarDepartamentos = new GUIListarDepartamentos();
		this.gUIModificarDepartamento = new GUIModificarDepartamento();
		this.gUICalcularNominasDepartamento = new GUICalcularNominasDepartamento();
		this.initGUI();

	}

	public void initGUI() {

		setTitle("Departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMenuDeDepartamento = new JLabel("MENU DE DEPARTAMENTO");
		lblMenuDeDepartamento.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMenuDeDepartamento.setBounds(116, 11, 238, 23);
		contentPane.add(lblMenuDeDepartamento);

		text_idDept = new JTextPane();
		text_idDept.setBounds(38, 57, 182, 57);
		contentPane.add(text_idDept);

		JButton btnBuscar = new JButton("Buscar Departamento");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!text_idDept.getText().equals("")) {
					try {
						int id = Integer.parseInt(text_idDept.getText());
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_DEPARTAMENTO, id));

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un Id en la caja de texto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnBuscar.setBounds(230, 57, 182, 23);
		contentPane.add(btnBuscar);

		JButton btnModificarDepartamento = new JButton("Modificar Departamento");
		btnModificarDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!text_idDept.getText().equals("")) {
					try {
						int id = Integer.parseInt(text_idDept.getText());
						gUIModificarDepartamento.limpiar();
						gUIModificarDepartamento.setId(id);
						gUIModificarDepartamento.setVisible(true);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un Id en la caja de texto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnModificarDepartamento.setBounds(230, 91, 182, 23);
		contentPane.add(btnModificarDepartamento);

		JButton btnAltaDepartamento = new JButton("Alta Departamento");
		btnAltaDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gUIAltaDepartamento.limpiar();
				gUIAltaDepartamento.setVisible(true);
			}

		});
		btnAltaDepartamento.setBounds(38, 150, 182, 23);
		contentPane.add(btnAltaDepartamento);

		JButton btnDarDeBaja = new JButton("Baja Departamento");
		btnDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!text_idDept.getText().equals("")) {
					try {
						int id = Integer.parseInt(text_idDept.getText());
						Controlador.getInstance().accion(new Contexto(Events.BAJA_DEPARTAMENTO, id));

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un Id en la caja de texto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnDarDeBaja.setBounds(230, 150, 182, 23);
		contentPane.add(btnDarDeBaja);

		JButton btnListarDepartamentos = new JButton("Listar Departamentos");
		btnListarDepartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Controlador.getInstance().accion(new Contexto(Events.LISTAR_DEPARTAMENTOS, null));
			}

		});
		btnListarDepartamentos.setBounds(38, 198, 182, 23);
		contentPane.add(btnListarDepartamentos);

		JButton btnCalcularNominas = new JButton("Calcular Nominas");
		btnCalcularNominas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!text_idDept.getText().equals("")) {
					try {
						int id = Integer.parseInt(text_idDept.getText());
						gUICalcularNominasDepartamento.limpiar();
						gUICalcularNominasDepartamento.setVisible(true);
						
						Controlador.getInstance().accion(new Contexto(Events.CALCULAR_NOMINAS_DEPARTAMENTO, id));

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Error en la introducción del id. Tipo error " + ex.getMessage(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca un Id en la caja de texto", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		btnCalcularNominas.setBounds(230, 198, 182, 23);
		contentPane.add(btnCalcularNominas);

	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		switch (contexto.getEvento()) {
		case Events.ALTA_DEPARTAMENTO_OK:
		case Events.ALTA_DEPARTAMENTO_KO:
			gUIAltaDepartamento.actualizar(contexto);
			break;
		case Events.BAJA_DEPARTAMENTO_OK:
			JOptionPane.showMessageDialog(new JFrame(), contexto.getDato(), "Baja Departamento",
					JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			break;
		case Events.BAJA_DEPARTAMENTO_KO:
			JOptionPane.showMessageDialog(new JFrame(), contexto.getDato(), "Error", JOptionPane.ERROR_MESSAGE);
			this.dispose();
			break;

		case Events.BUSCAR_DEPARTAMENTO_OK:
			gUIBuscarDepartamento.limpiar();
			gUIBuscarDepartamento.actualizar(contexto);
			gUIBuscarDepartamento.setVisible(true);
			break;
		case Events.BUSCAR_DEPARTAMENTO_KO:
			JOptionPane.showMessageDialog(new JFrame(), contexto.getDato(), "Error", JOptionPane.ERROR_MESSAGE);
			this.dispose();
			break;
		case Events.LISTAR_DEPARTAMENTO_OK:
			gUIListarDepartamentos.limpiar();
			gUIListarDepartamentos.actualizar(contexto);
			gUIListarDepartamentos.setVisible(true);
			break;
		case Events.LISTAR_DEPARTAMENTO_KO:
			gUIListarDepartamentos.limpiar();
			gUIListarDepartamentos.actualizar(contexto);
			break;

		case Events.MODIFICAR_DEPARTAMENTO_OK:
			gUIModificarDepartamento.dispose();
			JOptionPane.showMessageDialog(null, "Departamento con id: " + contexto.getDato() + " modificado.");
			break;

		case Events.MODIFICAR_DEPARTAMENTO_KO:
			gUIModificarDepartamento.dispose();
			JOptionPane.showMessageDialog(new JFrame(), contexto.getDato(), "Error en la modificación",
					JOptionPane.ERROR_MESSAGE);
			break;
		
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO_OK:
			gUICalcularNominasDepartamento.limpiar();
			gUICalcularNominasDepartamento.actualizar(contexto);
			gUICalcularNominasDepartamento.setVisible(true);
			break;
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO_KO:
			gUICalcularNominasDepartamento.limpiar();
			gUICalcularNominasDepartamento.actualizar(contexto);
			break;
		}

	}

}
