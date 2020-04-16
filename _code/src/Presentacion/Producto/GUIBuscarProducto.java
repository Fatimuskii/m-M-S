/**
 * 
 */
package Presentacion.Producto;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Producto.imp.TJuegoDeMesa;
import Negocio.Producto.imp.TMerchandising;
import Negocio.Producto.imp.TProducto;
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
public class GUIBuscarProducto extends GUIProducto{

	
	private static final long serialVersionUID = -1352730600756691892L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textEdad;
	private JTextField textJugadores;
	private JTextField textStock;
	private JTextField textTipo;
	private JLabel lblEdadRecomendada;
	private JLabel lblNumeroJugadores;
	private JLabel lblTipo;
	private JLabel lblActivo;
	private JLabel lblInactivo;
	

	public GUIBuscarProducto(){
		super();
		
		initGUI();
	}
	
	private void initGUI(){
		setTitle("Buscar Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblIdProducto = new JLabel("Id Producto:");
		lblIdProducto.setBounds(10, 23, 90, 14);
		contentPane.add(lblIdProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 50, 424, 2);
		contentPane.add(separator);
		
		textId = new JTextField();
		textId.setBounds(140, 20, 150, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id;
					id = Integer.parseInt(textId.getText());
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Información errónea (Id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_PRODUCTO, id));
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscar.setBounds(330, 19, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 67, 90, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 98, 90, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 129, 90, 14);
		contentPane.add(lblStock);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(140, 64, 150, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setBounds(140, 95, 150, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textStock = new JTextField();
		textStock.setEditable(false);
		textStock.setBounds(140, 126, 150, 20);
		contentPane.add(textStock);
		textStock.setColumns(10);
		
		lblEdadRecomendada = new JLabel("Edad Recomendada:");
		lblEdadRecomendada.setBounds(10, 160, 120, 14);
		contentPane.add(lblEdadRecomendada);
		
		lblNumeroJugadores = new JLabel("Número Jugadores:");
		lblNumeroJugadores.setBounds(10, 191, 120, 14);
		contentPane.add(lblNumeroJugadores);
		
		textEdad = new JTextField();
		textEdad.setEditable(false);
		textEdad.setBounds(140, 157, 150, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		textJugadores = new JTextField();
		textJugadores.setEditable(false);
		textJugadores.setBounds(140, 188, 150, 20);
		contentPane.add(textJugadores);
		textJugadores.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAceptar.setBounds(330, 237, 89, 23);
		contentPane.add(btnAceptar);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 160, 120, 14);
		contentPane.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setEditable(false);
		textTipo.setBounds(140, 157, 150, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(10, 224, 120, 14);
		contentPane.add(lblEstado);
		
		lblActivo = new JLabel("Activo");
		lblActivo.setForeground(Color.GREEN);
		lblActivo.setBounds(140, 224, 120, 14);
		contentPane.add(lblActivo);
		
		lblInactivo = new JLabel("Inactivo");
		lblInactivo.setForeground(Color.RED);
		lblInactivo.setBounds(140, 224, 120, 14);
		contentPane.add(lblInactivo);
	}
	
	
	public void clearData() {
		textId.setText("");
		textNombre.setText("");
		textPrecio.setText("");
		textEdad.setText("");
		textJugadores.setText("");
		textStock.setText("");
		textTipo.setText("");
		textJugadores.setVisible(false);
		textEdad.setVisible(false);
		textTipo.setVisible(false);
		lblEdadRecomendada.setVisible(false);
		lblNumeroJugadores.setVisible(false);
		lblTipo.setVisible(false);
		
		lblActivo.setVisible(false);
		lblInactivo.setVisible(false);
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.BUSCAR_PRODUCTO_OK:
			TProducto tProducto = (TProducto)contexto.getDato();
			
			textNombre.setText(tProducto.getNombre());
			textPrecio.setText(tProducto.getPrecio()+"");
			textStock.setText(tProducto.getStock()+"");
			if(tProducto instanceof TJuegoDeMesa){
				textEdad.setText(((TJuegoDeMesa) tProducto).getEdadRecomendada()+"");
				textJugadores.setText(((TJuegoDeMesa) tProducto).getNumJugadores()+"");
				textJugadores.setVisible(true);
				textEdad.setVisible(true);
				textTipo.setVisible(false);
				lblEdadRecomendada.setVisible(true);
				lblNumeroJugadores.setVisible(true);
				lblTipo.setVisible(false);
			}
			if(tProducto instanceof TMerchandising){
				textTipo.setText(((TMerchandising) tProducto).getTipo()+"");
				textJugadores.setVisible(false);
				textEdad.setVisible(false);
				textTipo.setVisible(true);
				lblEdadRecomendada.setVisible(false);
				lblNumeroJugadores.setVisible(false);
				lblTipo.setVisible(true);
			}
			
			if(tProducto.getActivo()){
				lblActivo.setVisible(true);
				lblInactivo.setVisible(false);
			}
			else{
				lblActivo.setVisible(false);
				lblInactivo.setVisible(true);
			}
			break;
		case Events.BUSCAR_PRODUCTO_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el producto");
			break;
		}
		
	}
}