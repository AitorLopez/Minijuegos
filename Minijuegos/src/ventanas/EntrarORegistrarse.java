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

//donde llamo a a�adirUsaurioABD(), try-catch del main()??
public class EntrarORegistrarse extends JFrame{

	JFrame frame;
	private JTextField textFieldNick;
	private JTextField textFieldContrase�a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connection conexionBd = BaseDeDatos.initBD("db/BDMinijuego.sqlite");
					EntrarORegistrarse window = new EntrarORegistrarse();
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
	public EntrarORegistrarse() {
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
		lblMinijuegos.setForeground(Color.RED);
		lblMinijuegos.setFont(new Font("Sitka Small", Font.PLAIN, 44));
		lblMinijuegos.setBounds(90, 23, 247, 45);
		frame.getContentPane().add(lblMinijuegos);
		
		JLabel lblEntar = new JLabel("Entrar:");
		lblEntar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEntar.setBounds(61, 97, 82, 14);
		frame.getContentPane().add(lblEntar);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(113, 133, 190, 20);
		frame.getContentPane().add(textFieldNick);
		textFieldNick.setColumns(10);
		
		textFieldContrase�a = new JTextField();
		textFieldContrase�a.setBounds(113, 170, 190, 20);
		frame.getContentPane().add(textFieldContrase�a);
		textFieldContrase�a.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNick.setBounds(26, 136, 46, 14);
		frame.getContentPane().add(lblNick);
		
		JLabel lblContrase�a = new JLabel("Contrase\u00F1a:");
		lblContrase�a.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrase�a.setBounds(26, 173, 77, 14);
		frame.getContentPane().add(lblContrase�a);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(277, 227, 107, 23);
		frame.getContentPane().add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				//Entrar a men� de Nuevo Usuario
				NuevoUsuario a=new NuevoUsuario();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(315, 151, 89, 23);
		frame.getContentPane().add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio del programa");
				//primero busco a ver si est� el usuario registrado
				Usuario usu = UsuariosBD.buscarUsuariosBD(textFieldNick.getText(), textFieldContrase�a.getText()); 
				if(usu!=null){
					TresMinijuegos a=new TresMinijuegos();
					a.frame.setVisible(true);
				}
				//si no est� registrado
				else{
					//JOptionPane que muestre en pantalla mensaje de error
					JOptionPane.showMessageDialog( null, "Error al introducir los campos.");
					System.out.println("Error. El nick y la contrase�a no coinciden con los de ning�n usuario.");
				}
		}
	});
}
}
