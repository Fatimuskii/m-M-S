package Presentacion.Departamento;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Presentacion.Contexto;
import Presentacion.Events;

public class GUICalcularNominasDepartamento extends GUIDepartamento {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	
	JLabel calculoNominas_label;

	public GUICalcularNominasDepartamento() {
		super();
		setResizable(false);
		initGUI();
	}

	private void initGUI() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblClculoDeLa = new JLabel("Cálculo de la Nomina del departamento");
		lblClculoDeLa.setBounds(23, 25, 234, 32);
		contentPane.add(lblClculoDeLa);

		calculoNominas_label = new JLabel("");
		calculoNominas_label.setFont(new Font("Tahoma", Font.ITALIC, 12));
		calculoNominas_label.setBounds(33, 70, 134, 32);
		contentPane.add(calculoNominas_label);

		JLabel label = new JLabel("€");
		label.setBounds(201, 78, 56, 16);
		contentPane.add(label);
	}

	public void limpiar() {
		initGUI();
	}

	@Override
	public void actualizar(Contexto contexto) {
		float suma = (float)contexto.getDato();
		switch (contexto.getEvento()) {
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO_OK:
			this.calculoNominas_label.setText(""+suma);
			break;
		case Events.CALCULAR_NOMINAS_DEPARTAMENTO_KO:
			if((float)contexto.getDato() == -3){
				JOptionPane.showMessageDialog(null, "El departamento no existe");
			}
			else if((float)contexto.getDato() == -4){
				JOptionPane.showMessageDialog(null, "El departamento no está activo");
			}
			else{
			JOptionPane.showMessageDialog(new JFrame(), contexto.getDato(), "Error", JOptionPane.ERROR_MESSAGE);
			}
			this.dispose();
			break;
		}

	}

}
