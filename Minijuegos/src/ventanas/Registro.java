package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JButton;

import clases.BaseDeDatos;
import clases.Usuario;
import clases.UsuariosBD;


//A�adir funcionalidad al boton Salir

public class Registro extends JFrame{

	JFrame frame;
	private JTextField textFieldNick;
	private JTextField textFieldContrase�a;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection conexionBd = BaseDeDatos.initBD("BDMinijuego.sqlite");
					Registro window = new Registro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNuevoUsuario = new JLabel("Nuevo usuario");
		lblNuevoUsuario.setForeground(Color.DARK_GRAY);
		lblNuevoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoUsuario.setFont(new Font("Source Sans Pro Semibold", Font.PLAIN, 19));
		lblNuevoUsuario.setBounds(116, 11, 184, 29);
		frame.getContentPane().add(lblNuevoUsuario);
		
		JLabel lblNick = new JLabel("Nick: ");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNick.setBounds(24, 81, 58, 21);
		frame.getContentPane().add(lblNick);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(68, 100, 107, 20);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a:");
		lblContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblContrase�a.setBounds(24, 132, 101, 21);
		frame.getContentPane().add(lblContrase�a);
		
		textFieldContrase�a = new JTextField();
		textFieldContrase�a.setBounds(68, 164, 107, 20);
		frame.getContentPane().add(textFieldContrase�a);
		textFieldContrase�a.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNombre.setBounds(237, 51, 70, 14);
		frame.getContentPane().add(lblNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(303, 76, 121, 20);
		frame.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblApellidos.setBounds(237, 111, 81, 21);
		frame.getContentPane().add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(303, 132, 121, 20);
		frame.getContentPane().add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		JLabel lblCorreo = new JLabel("Correo electr\u00F3nico: ");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCorreo.setBounds(237, 167, 126, 14);
		frame.getContentPane().add(lblCorreo);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(303, 196, 121, 20);
		frame.getContentPane().add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		JButton btnRegistro = new JButton("Registro");
		btnRegistro.setBounds(105, 227, 89, 23);
		frame.getContentPane().add(btnRegistro);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*Falta por poner error por JTextField vacio
				 * Introducir nuevo usuario en la BD
				 */
				System.out.println("Inicio del registro");
					Usuario usu = UsuariosBD.a�adirUsuariosBD(textFieldNick.getText(), textFieldContrase�a.getText(), textFieldNombre.getText(),textFieldApellidos.getText(),textFieldCorreo.getText()); 
					if(usu!=null){
						//meter si el nick no est� repetido
						//usu = UsuariosBD.a�adirUsuariosBD(textFieldNick.getText(), textFieldContrase�a.getText(), textFieldNombre.getText(),textFieldApellidos.getText(),textFieldCorreo.getText());
						EligeMinijuego a=new EligeMinijuego();
						a.frame.setVisible(true);
						System.out.println("Usuario a�adido a la Base de Datos");
						System.out.println("Registro completado");
					}
					//si el nick est� repetido o JTextField vac�o
					else{
						//JOptionPane que muestre en pantalla mensaje de error
						JOptionPane.showMessageDialog( null, "Error.El nick ya existe o alguno de los campos est� vac�o.");
						System.out.println("Error. El nick del usuario ya existe o alguno de los campos est� vac�o.");
					}
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(237, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Atras");
				EntraORegistrate a=new EntraORegistrate();
				a.frame.setVisible(true);
			}
		});
	}
}
