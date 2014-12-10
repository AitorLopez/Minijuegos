package ventanas;

import java.awt.EventQueue;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Color;

public class OpcTetris extends JFrame{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcTetris window = new OpcTetris();
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
	public OpcTetris() {
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
		
		JLabel lblTetris = new JLabel("TETRIS");
		lblTetris.setHorizontalAlignment(SwingConstants.CENTER);
		lblTetris.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		lblTetris.setBounds(134, 32, 158, 23);
		frame.getContentPane().add(lblTetris);
		
		JButton btnNuevaPartida = new JButton("Jugar nueva partida");
		btnNuevaPartida.setBounds(39, 97, 158, 39);
		frame.getContentPane().add(btnNuevaPartida);
		
		JButton btnEstadisticas = new JButton("Estad\u00EDsticas");
		btnEstadisticas.setBounds(39, 171, 158, 39);
		frame.getContentPane().add(btnEstadisticas);
		btnEstadisticas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Inicio de registro");
				EleccionEstadTetris a=new EleccionEstadTetris();
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
				DescripcionTetris a=new DescripcionTetris();
				a.frame.setVisible(true);
			}
		});
		
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
