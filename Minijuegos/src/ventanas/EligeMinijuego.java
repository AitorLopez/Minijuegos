package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EligeMinijuego extends JFrame{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EligeMinijuego window = new EligeMinijuego();
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
	public EligeMinijuego() {
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
		
		JLabel lblEligeMinijuego = new JLabel("Elige minijuego");
		lblEligeMinijuego.setFont(new Font("Matura MT Script Capitals", Font.PLAIN, 17));
		lblEligeMinijuego.setHorizontalAlignment(SwingConstants.CENTER);
		lblEligeMinijuego.setBounds(79, 11, 262, 42);
		frame.getContentPane().add(lblEligeMinijuego);
		
		JButton btnAngryBull = new JButton("Angry Bull");
		btnAngryBull.setBounds(146, 64, 135, 23);
		frame.getContentPane().add(btnAngryBull);
		btnAngryBull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Abrir menú Angry Bull");
				OpcionesAngryBull a=new OpcionesAngryBull();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnPepeFly = new JButton("Pepe Fly");
		btnPepeFly.setBounds(146, 102, 135, 23);
		frame.getContentPane().add(btnPepeFly);
		btnPepeFly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Abrir menú Pepe Fly");
				OpcionesPepeFly a=new OpcionesPepeFly();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnTetris = new JButton("Tetris");
		btnTetris.setBounds(146, 140, 135, 23);
		frame.getContentPane().add(btnTetris);
		btnTetris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Abrir menú Tetris");
				OpcionesTetris a=new OpcionesTetris();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(171, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EntraORegistrate a=new EntraORegistrate();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnEstadGenerales = new JButton("Estad. Generales");
		btnEstadGenerales.setBounds(146, 179, 135, 23);
		frame.getContentPane().add(btnEstadGenerales);
		btnEstadGenerales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EstadiGeneral a=new EstadiGeneral();
				a.frame.setVisible(true);
			}
		});

	}
}
