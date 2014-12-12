package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComparaRecordsPepeFly {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComparaRecordsTetris window = new ComparaRecordsTetris();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public ComparaRecordsPepeFly() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().setForeground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JLabel lblComparacion = new JLabel("COMPARACI\u00D3N DE RECORDS PEPE FLY");
		lblComparacion.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblComparacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblComparacion.setBounds(58, 11, 310, 29);
		frame.getContentPane().add(lblComparacion);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Salir");
			EstadiJugadorPepeFly a=new EstadiJugadorPepeFly();
			a.frame.setVisible(true);
		}
		});
	}
}