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

public class OpcionesAngryBull extends JFrame{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcionesAngryBull window = new OpcionesAngryBull();
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
	public OpcionesAngryBull() {
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
		
		JLabel lblAngryBull = new JLabel("ANGRY BULL");
		lblAngryBull.setHorizontalAlignment(SwingConstants.CENTER);
		lblAngryBull.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblAngryBull.setBounds(135, 31, 158, 23);
		frame.getContentPane().add(lblAngryBull);
		
		JButton btnNuevaPartida = new JButton("Jugar nueva partida");
		btnNuevaPartida.setBounds(39, 97, 158, 39);
		frame.getContentPane().add(btnNuevaPartida);
		
		JButton btnEstadisticas = new JButton("Estad\u00EDsticas");
		btnEstadisticas.setBounds(39, 171, 158, 39);
		frame.getContentPane().add(btnEstadisticas);
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				ElegirEstadAngryBull a=new ElegirEstadAngryBull();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnVerDemo = new JButton("Ver demo");
		btnVerDemo.setBounds(243, 97, 158, 39);
		frame.getContentPane().add(btnVerDemo);
		
		JButton btnDescripcion = new JButton("Descripci\u00F3n");
		btnDescripcion.setBounds(243, 171, 158, 39);
		frame.getContentPane().add(btnDescripcion);
		btnDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Abrir descripcion");
				DescripAngryBull a=new DescripAngryBull();
				a.frame.setVisible(true);
			}
		});
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(173, 227, 89, 23);
		frame.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EligeMinijuego a=new EligeMinijuego();
				a.frame.setVisible(true);
			}
		});
	}

}
