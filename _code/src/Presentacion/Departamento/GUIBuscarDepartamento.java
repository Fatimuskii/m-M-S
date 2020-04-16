package Presentacion.Departamento;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Negocio.Departamento.imp.TDepartamento;
import Presentacion.Contexto;
import Presentacion.Events;

public class GUIBuscarDepartamento extends GUIDepartamento {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;

	JLabel IdDepartamento_label;
	JLabel nombre_label;
	JLabel numPersonas_label;
	JLabel activo_label;

	public GUIBuscarDepartamento() {
		super();
		setResizable(false);
		initGUI();
	}

	public void initGUI() {

		setTitle("Informacion de departamento");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 275);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDatosDelDepartamento = new JLabel("DATOS DEL DEPARTAMENTO: ");
		lblDatosDelDepartamento.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosDelDepartamento.setBounds(43, 32, 272, 14);
		contentPane.add(lblDatosDelDepartamento);

		JLabel lblIdentificador = new JLabel("Identificador: ");
		lblIdentificador.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdentificador.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdentificador.setBounds(43, 75, 166, 14);
		contentPane.add(lblIdentificador);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(43, 108, 166, 14);
		contentPane.add(lblNombre);

		JLabel lblNumeroDeEmpleados = new JLabel("Numero de empleados:");
		lblNumeroDeEmpleados.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumeroDeEmpleados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumeroDeEmpleados.setBounds(43, 139, 166, 14);
		contentPane.add(lblNumeroDeEmpleados);

		JLabel lblEstado = new JLabel("Estado: ");
		lblEstado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEstado.setBounds(43, 170, 166, 14);
		contentPane.add(lblEstado);

		// DATOS EN SI

		IdDepartamento_label = new JLabel("");
		IdDepartamento_label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		IdDepartamento_label.setBounds(237, 75, 135, 14);
		contentPane.add(IdDepartamento_label);

		nombre_label = new JLabel("");
		nombre_label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		nombre_label.setBounds(237, 108, 135, 14);
		contentPane.add(nombre_label);

		numPersonas_label = new JLabel("");
		numPersonas_label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		numPersonas_label.setBounds(237, 139, 135, 14);
		contentPane.add(numPersonas_label);

		activo_label = new JLabel("");
		activo_label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		activo_label.setBounds(237, 170, 135, 14);
		contentPane.add(activo_label);
	}

	public void limpiar() {
		initGUI();
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		TDepartamento dpto = (TDepartamento)contexto.getDato();
		switch (contexto.getEvento()) {
		case Events.BUSCAR_DEPARTAMENTO_OK:
			this.IdDepartamento_label.setText(""+dpto.getIdDepartamento());
			this.nombre_label.setText(dpto.getNombre());
			this.numPersonas_label.setText(""+dpto.getNumPersonas());
			this.activo_label.setText(""+ dpto.getActivo()); // OJO **
			break;
		
		}
	}
}
