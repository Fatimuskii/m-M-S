package Presentacion.Departamento;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import Negocio.Departamento.imp.TDepartamento;
import Presentacion.Contexto;
import Presentacion.Events;
import Presentacion.ServiceWorker.Controlador.Controlador;

public class GUIModificarDepartamento extends GUIDepartamento{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblIdDepartamento;
	private JTextField nuevoNombre_TextField;
	private int idDepartamento;
	
	public GUIModificarDepartamento(){
		super();
		setResizable(false);
		initGUI();
	}

	private void initGUI() {
		setTitle("Modificar Departamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 448, 242);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIdDepartamento = new JLabel("ID Departamento: ");
		lblIdDepartamento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIdDepartamento.setBounds(53, 56, 269, 14);
		contentPane.add(lblIdDepartamento);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombre.setBounds(53, 89, 87, 14);
		contentPane.add(lblNombre);
		
		nuevoNombre_TextField = new JTextField();
		nuevoNombre_TextField.setBounds(141, 86, 181, 20);
		contentPane.add(nuevoNombre_TextField);
		nuevoNombre_TextField.setColumns(10);
		
		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nuevoNombre= nuevoNombre_TextField.getText().toUpperCase();
				int idActual = getId();
				TDepartamento nuevoTDpto= new TDepartamento(idActual,nuevoNombre,0,true);
				Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_DEPARTAMENTO, nuevoTDpto));
				
			}
		});
		btnAceptar.setBounds(279, 133, 110, 33);
		contentPane.add(btnAceptar);
		
	}

	public void limpiar() {
		this.initGUI();
	}

	@Override
	public void actualizar(Contexto contexto) {
		// TODO Auto-generated method stub
		
		
	}

	public void setId(int id) {
		this.idDepartamento = id;
		String texto = lblIdDepartamento.getText();
		this.lblIdDepartamento.setText(texto + " " + id); 
	}
	public int getId(){
		return this.idDepartamento;
		
	}

}
