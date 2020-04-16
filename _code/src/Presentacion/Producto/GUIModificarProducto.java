/**
 * 
 */
package Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import Negocio.Producto.imp.Tipo;
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
public class GUIModificarProducto extends GUIProducto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3544475956378616643L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textStock;
	private JTextField textEdad;
	private JTextField textJugadores;
	private JLabel lblTipo;
	private JComboBox<Tipo> comboBox;
	private JLabel lblNumeroJugadores;
	private JLabel lblEdadRecomendada;
	private int idProducto;
	private TProducto tProducto;

	public GUIModificarProducto(){
		super();
		
		initGUI();
	}
	
	
	private void initGUI(){
		setTitle("Modificar Producto");
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
					idProducto = id;
					if (id <= 0) {
						JOptionPane.showMessageDialog(new JFrame(),
								"Información errónea (Id tiene que ser mayor que 0)", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else
						Controlador.getInstance().accion(new Contexto(Events.BUSCAR_MODIFICAR_PRODUCTO, id));
				}
				catch(Exception ex){
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
		textEdad.setBounds(140, 157, 150, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		
		textJugadores = new JTextField();
		textJugadores.setBounds(140, 188, 150, 20);
		contentPane.add(textJugadores);
		textJugadores.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre;
					int stock, edad = 0, numJugadores = 0;
					float precio;
					Tipo tipo = null;
					boolean error = false;

					nombre = textNombre.getText();
					precio = Float.parseFloat(textPrecio.getText());
					stock = Integer.parseInt(textStock.getText());

					if (nombre.equals("") || precio < 0 || stock < 0) {
						error = true;
					}
					if (tProducto instanceof TJuegoDeMesa) {
						edad = Integer.parseInt(textEdad.getText());
						numJugadores = Integer.parseInt(textJugadores.getText());

						if (edad < 0 || numJugadores < 0) {
							error = true;
						}
					}
					if (tProducto instanceof TMerchandising) {
						tipo = (Tipo) comboBox.getSelectedItem();
						if (tipo == null) {
							error = true;
						}
					}
					if (error) {
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (tProducto instanceof TJuegoDeMesa) {
							TJuegoDeMesa tProductoNuevo = new TJuegoDeMesa(idProducto, nombre, precio, stock, true,
									edad, numJugadores);
							Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_PRODUCTO, tProductoNuevo));
						}
						if (tProducto instanceof TMerchandising) {
							TMerchandising tProductoNuevo = new TMerchandising(idProducto, nombre, precio, stock, true, tipo);
							Controlador.getInstance().accion(new Contexto(Events.MODIFICAR_PRODUCTO, tProductoNuevo));
						}

					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnModificar.setBounds(330, 237, 89, 23);
		contentPane.add(btnModificar);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 160, 120, 14);
		contentPane.add(lblTipo);
		
		comboBox = new JComboBox<Tipo>();
		comboBox.setModel(new DefaultComboBoxModel<Tipo>(Tipo.values()));
		comboBox.setBounds(140, 156, 150, 22);
		contentPane.add(comboBox);
	}
	
	public void clearData() {
		textId.setText("");
		textNombre.setText("");
		textPrecio.setText("");
		textStock.setText("");
		textEdad.setText("");
		textJugadores.setText("");
		
		textNombre.setEditable(false);
		textPrecio.setEditable(false);
		textStock.setEditable(false);
		
		lblNumeroJugadores.setVisible(false);
		lblEdadRecomendada.setVisible(false);
		textEdad.setVisible(false);
		textJugadores.setVisible(false);
		comboBox.setVisible(false);
		lblTipo.setVisible(false);
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.MODIFICAR_PRODUCTO_OK:
			JOptionPane.showMessageDialog(null, "Producto " + contexto.getDato() + " modificado correctamente.");
			this.dispose();
			break;
		case Events.MODIFICAR_PRODUCTO_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "El producto no existe");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
			}
			else if((int)contexto.getDato() == -3){
				JOptionPane.showMessageDialog(null, "El producto no está activo");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al modificar el producto");
			}
			
			break;
		case Events.BUSCAR_MODIFICAR_PRODUCTO_OK:
			tProducto = (TProducto) contexto.getDato();
			textNombre.setEditable(true);
			textPrecio.setEditable(true);
			textStock.setEditable(true);
			
			textNombre.setText(tProducto.getNombre());
			textPrecio.setText(tProducto.getPrecio()+"");
			textStock.setText(tProducto.getStock()+"");
			
			if(tProducto instanceof TJuegoDeMesa){	
				lblNumeroJugadores.setVisible(true);
				lblEdadRecomendada.setVisible(true);
				textEdad.setVisible(true);
				textJugadores.setVisible(true);
				
				textEdad.setText(((TJuegoDeMesa) tProducto).getEdadRecomendada()+"");
				textJugadores.setText(((TJuegoDeMesa) tProducto).getNumJugadores()+"");
				comboBox.setVisible(false);
				lblTipo.setVisible(false);
			}
			if(tProducto instanceof TMerchandising){
				lblNumeroJugadores.setVisible(false);
				lblEdadRecomendada.setVisible(false);
				textEdad.setVisible(false);
				textJugadores.setVisible(false);
				comboBox.setVisible(true);
				lblTipo.setVisible(true);
			}
			break;
		case Events.BUSCAR_MODIFICAR_PRODUCTO_KO:
			JOptionPane.showMessageDialog(null, "Error al buscar el producto");
			break;
		}
		
	}
}