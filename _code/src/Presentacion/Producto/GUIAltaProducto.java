/**
 * 
 */
package Presentacion.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Negocio.Producto.imp.TJuegoDeMesa;
import Negocio.Producto.imp.TMerchandising;
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
public class GUIAltaProducto extends GUIProducto{

	private static final long serialVersionUID = -4956741787151705240L;
	private JPanel contentPane;
	private JTextField textNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textEdad;
	private JTextField textJugadores;
	private JTextField textPrecio;
	private JTextField textStock;
	private JComboBox<Tipo> comboBox;
	private JLabel lblTipo;
	private JLabel lblEdadRecomendada;
	private JLabel lblNumeroJugadores;
	private JRadioButton rdbtnJuegoDeMesa;
	private JRadioButton rdbtnMerchandising;
	
	
	public GUIAltaProducto(){
		super();
		
		setResizable(false);
		initGUI();
	}

	public void initGUI(){
		setTitle("Alta Producto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 16, 94, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 53, 94, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 89, 94, 14);
		contentPane.add(lblStock);
		
		lblEdadRecomendada = new JLabel("Edad Recomendada:");
		lblEdadRecomendada.setBounds(10, 157, 118, 14);
		contentPane.add(lblEdadRecomendada);
		lblEdadRecomendada.setVisible(false);
		lblNumeroJugadores = new JLabel("Numero Jugadores:");
		lblNumeroJugadores.setBounds(10, 193, 118, 14);
		contentPane.add(lblNumeroJugadores);
		lblNumeroJugadores.setVisible(false);
		
		textEdad = new JTextField();
		textEdad.setBounds(145, 154, 86, 20);
		contentPane.add(textEdad);
		textEdad.setColumns(10);
		textEdad.setVisible(false);
		
		textJugadores = new JTextField();
		textJugadores.setBounds(145, 190, 86, 20);
		contentPane.add(textJugadores);
		textJugadores.setColumns(10);
		textJugadores.setVisible(false);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 168, 46, 14);
		contentPane.add(lblTipo);
		
		comboBox = new JComboBox<Tipo>();
		comboBox.setModel(new DefaultComboBoxModel<Tipo>(Tipo.values()));
		comboBox.setBounds(114, 164, 94, 22);
		contentPane.add(comboBox);
		
		comboBox.setVisible(false);
    	lblTipo.setVisible(false);
		rdbtnJuegoDeMesa = new JRadioButton("Juego de Mesa");
		rdbtnJuegoDeMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	lblEdadRecomendada.setVisible(true);
            	lblNumeroJugadores.setVisible(true);
            	textEdad.setVisible(true);
            	textJugadores.setVisible(true);
            	comboBox.setVisible(false);
            	lblTipo.setVisible(false);
            }
        });
		buttonGroup.add(rdbtnJuegoDeMesa);
		rdbtnJuegoDeMesa.setBounds(54, 117, 165, 23);
		contentPane.add(rdbtnJuegoDeMesa);
		
		
		rdbtnMerchandising = new JRadioButton("Merchandising");
		rdbtnMerchandising.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	lblEdadRecomendada.setVisible(false);
            	lblNumeroJugadores.setVisible(false);
            	textEdad.setVisible(false);
            	textJugadores.setVisible(false);
            	comboBox.setVisible(true);
            	lblTipo.setVisible(true);
            }
        });
		buttonGroup.add(rdbtnMerchandising);
		rdbtnMerchandising.setBounds(249, 117, 109, 23);
		contentPane.add(rdbtnMerchandising);
		
		textNombre = new JTextField();
		textNombre.setBounds(114, 8, 310, 30);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
					boolean error = false;
					String nombre = textNombre.getText();
					Float precio = Float.parseFloat(textPrecio.getText());
					int stock = Integer.parseInt(textStock.getText());
					int edad = 0;
					int jugadores = 0;
					Tipo tipo = null;
					
					if(nombre.equals("") || precio < 0 || stock < 0){
						error = true;
					}
					
					if(rdbtnJuegoDeMesa.isSelected()){
						edad = Integer.parseInt(textEdad.getText());
						jugadores = Integer.parseInt(textJugadores.getText());

						if (edad < 0 || jugadores < 0) {
							error = true;
						}
					} else if (rdbtnMerchandising.isSelected()) {
						tipo = (Tipo) comboBox.getSelectedItem();

						if (tipo == null) {
							error = true;
						}
					}
					if (error) {
						JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (rdbtnJuegoDeMesa.isSelected()) {
							TJuegoDeMesa tJuegoDeMesa = new TJuegoDeMesa(nombre, precio, stock, true, edad, jugadores);
							Controlador.getInstance().accion(new Contexto(Events.ALTA_PRODUCTO, tJuegoDeMesa));
						} else if (rdbtnMerchandising.isSelected()) {
							TMerchandising tMerchandising = new TMerchandising(nombre, precio, stock, true, tipo);
							Controlador.getInstance().accion(new Contexto(Events.ALTA_PRODUCTO, tMerchandising));
						}

					}
					
					
					
				}
				catch(NumberFormatException ex){
					JOptionPane.showMessageDialog(new JFrame(), "Información errónea", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAceptar.setBounds(335, 227, 89, 23);
		contentPane.add(btnAceptar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(222, 227, 89, 23);
		contentPane.add(btnSalir);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(114, 45, 310, 30);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textStock = new JTextField();
		textStock.setBounds(114, 81, 310, 30);
		contentPane.add(textStock);
		textStock.setColumns(10);
	}

	public void clearData() {
		lblEdadRecomendada.setVisible(false);
    	lblNumeroJugadores.setVisible(false);
    	textEdad.setVisible(false);
    	textJugadores.setVisible(false);
    	comboBox.setVisible(false);
    	lblTipo.setVisible(false);
    	
    	rdbtnJuegoDeMesa.setSelected(false);
    	rdbtnMerchandising.setSelected(false);
    	
    	textNombre.setText("");
    	buttonGroup.clearSelection();
    	textEdad.setText("");
    	textJugadores.setText("");
    	textPrecio.setText("");
    	textStock.setText("");
	}

	@Override
	public void actualizar(Contexto contexto) {
		switch(contexto.getEvento()){
		case Events.ALTA_PRODUCTO_OK:
			JOptionPane.showMessageDialog(null, "Producto " + contexto.getDato() + " dado de alta.");
			this.dispose();
			break;
		case Events.ALTA_PRODUCTO_KO:
			if((int)contexto.getDato() == -1){
				JOptionPane.showMessageDialog(null, "Ya existe un producto con ese nombre");
			}
			else if((int)contexto.getDato() == -2){
				JOptionPane.showMessageDialog(null, "No se puede reactivar un producto de distinto tipo");
			}
			else{
				JOptionPane.showMessageDialog(null, "Error al crear el producto");
			}
			
			break;
		}
	}
}