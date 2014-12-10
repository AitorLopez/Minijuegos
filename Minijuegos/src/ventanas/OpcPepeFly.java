package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class OpcPepeFly extends JFrame{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcPepeFly window = new OpcPepeFly();
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
	public OpcPepeFly() {
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
		
		JLabel lblPepeFly = new JLabel("PEPE FLY");
		lblPepeFly.setHorizontalAlignment(SwingConstants.CENTER);
		lblPepeFly.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblPepeFly.setBounds(135, 31, 158, 23);
		frame.getContentPane().add(lblPepeFly);
		
		JButton btnNuevaPartida = new JButton("Jugar nueva partida");
		btnNuevaPartida.setBounds(39, 97, 158, 39);
		frame.getContentPane().add(btnNuevaPartida);
		
		JButton btnEstadisticas = new JButton("Estad\u00EDsticas");
		btnEstadisticas.setBounds(39, 171, 158, 39);
		frame.getContentPane().add(btnEstadisticas);
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				EleccionEstadPepeFly a=new EleccionEstadPepeFly();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnVerDemo = new JButton("Ver demo");
		btnVerDemo.setBounds(243, 97, 158, 39);
		frame.getContentPane().add(btnVerDemo);
		
		JButton btnDescripcion = new JButton("Descripci\u00F3n");
		btnDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Abrir descripcion");
				DescripcionPepeFly a=new DescripcionPepeFly();
				a.frame.setVisible(true);
			}
		});
		btnDescripcion.setBounds(243, 171, 158, 39);
		frame.getContentPane().add(btnDescripcion);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(173, 227, 89, 23);
		frame.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				TresMinijuegos a=new TresMinijuegos();
				a.frame.setVisible(true);
			}
		});
	}

	}


