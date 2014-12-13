package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JLabel;
import javax.swing.JButton;



import clases.BaseDeDatos;
import clases.Usuario;
import clases.UsuariosBD;

//clase principal
public class EntraORegistrate extends JFrame{
  public static Usuario usu;
	JFrame frame;
	private JTextField textFieldNick;
	private JTextField textFieldContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection conexionBd = BaseDeDatos.initBD("db/BDMinijuego.sqlite");
					EntraORegistrate window = new EntraORegistrate();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Error al establecer la conexion");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EntraORegistrate() {
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
		
		JLabel lblMinijuegos = new JLabel("Minijuegos");
		lblMinijuegos.setForeground(Color.DARK_GRAY);
		lblMinijuegos.setFont(new Font("Showcard Gothic", Font.PLAIN, 44));
		lblMinijuegos.setBounds(90, 22, 284, 48);
		frame.getContentPane().add(lblMinijuegos);
		
		JLabel lblEntar = new JLabel("Entrar:");
		lblEntar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEntar.setBounds(61, 97, 82, 14);
		frame.getContentPane().add(lblEntar);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(113, 133, 190, 20);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(113, 170, 190, 20);
		frame.getContentPane().add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNick.setBounds(26, 136, 46, 14);
		frame.getContentPane().add(lblNick);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContraseña.setBounds(26, 173, 77, 14);
		frame.getContentPane().add(lblContraseña);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(315, 151, 89, 23);
		frame.getContentPane().add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio del programa");
				//primero busco a ver si está el usuario registrado
				 usu = UsuariosBD.buscarUsuariosBD(textFieldNick.getText(), textFieldContraseña.getText()); 
				if(usu!=null){
					EligeMinijuego a=new EligeMinijuego();
					a.frame.setVisible(true);
				}
				//si no está registrado
				else{
					//JOptionPane que muestre en pantalla mensaje de error
					JOptionPane.showMessageDialog( null, "Error al introducir los campos.");
					System.out.println("Error. El nick y la contraseña no coinciden con los de ningún usuario.");
				}
		}
	});
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(277, 227, 107, 23);
		frame.getContentPane().add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				//Entrar a menú de Nuevo Usuario
				Registro a=new Registro();
				a.frame.setVisible(true);
			}
		});
}
}
