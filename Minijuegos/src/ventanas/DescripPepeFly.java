package ventanas;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.DropMode;
import java.awt.Color;

public class DescripPepeFly extends JFrame{

	/**
	 * 
	 */
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DescripPepeFly window = new DescripPepeFly();
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
	public DescripPepeFly() {
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
		frame.setSize(500,300);
		
		JLabel lblDescripcionAngryBull = new JLabel("Descripcion Pepe Fly");
		lblDescripcionAngryBull.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcionAngryBull.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcionAngryBull.setBounds(124, 11, 176, 28);
		frame.getContentPane().add(lblDescripcionAngryBull);
		
		/*
		 * Uso el TextArea para que el texto me pueda salir en un párrafo, en las JLabel aparece en una línea
		 *así que no me servía pra poder escribir la descripción
		 */
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setBackground(Color.CYAN);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Modern No. 20", Font.PLAIN, 13));
		textArea.setBounds(31, 58, 404, 161);
		frame.getContentPane().add(textArea);
		textArea.setText("El usuario controlará a un fajo de billetes que están en un sobre,"
				+ " cada toque de pantalla es un salto del sobre, el cual no puede ni tocar el suelo ni el techo."
				+ " El objetivo del usuario consiste en esquivar las manos de los políticos corruptos que pretenden"
				+ " hacerse con el dinero y llegar al objetivo, que haría que la partida se ganase."
				);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				OpcionesPepeFly a=new OpcionesPepeFly();
				a.frame.setVisible(true);
			}
		});
	}
}
