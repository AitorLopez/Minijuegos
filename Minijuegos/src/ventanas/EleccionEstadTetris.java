package ventanas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EleccionEstadTetris {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleccionEstadTetris window = new EleccionEstadTetris();
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
	public EleccionEstadTetris() {
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
		
		JLabel lblEligeQueEstadstica = new JLabel("Elige que estad\u00EDstica quieres consultar:");
		lblEligeQueEstadstica.setBounds(26, 41, 277, 35);
		frame.getContentPane().add(lblEligeQueEstadstica);
		
		JRadioButton rdbtnPorJugador = new JRadioButton("Por jugador");
		rdbtnPorJugador.setBackground(Color.CYAN);
		rdbtnPorJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstadJugadorTetris a=new EstadJugadorTetris();
				a.frame.setVisible(true);
			}
		});
		rdbtnPorJugador.setBounds(40, 93, 109, 23);
		frame.getContentPane().add(rdbtnPorJugador);
		
		JRadioButton rdbtnMundial = new JRadioButton("Mundial");
		rdbtnMundial.setBackground(Color.CYAN);
		rdbtnMundial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstadMundialTetris a=new EstadMundialTetris();
				a.frame.setVisible(true);
				
			}
		});
		rdbtnMundial.setBounds(40, 147, 109, 23);
		frame.getContentPane().add(rdbtnMundial);
	
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				OpcTetris a=new OpcTetris();
				a.frame.setVisible(true);
			}
		});
		}
}

