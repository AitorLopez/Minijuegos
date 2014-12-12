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

public class DescripTetris extends JFrame{

	//¡¡¡¡FALTA POR COMPLETAR EL JTEXTAREA¡¡¡¡
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DescripTetris window = new DescripTetris();
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
	public DescripTetris() {
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
		
		JLabel lblDescripcionAngryBull = new JLabel("Descripcion Tetris");
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
		textArea.setText("Versión del mítico tetris, haciendo referencia al tema principal de la aplicación.");
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				OpcionesTetris a=new OpcionesTetris();
				a.frame.setVisible(true);
			}
		});
	}
}
