package ventanas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.UsuariosBD;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class EstadiMundialPepeFly{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadiMundialPepeFly window = new EstadiMundialPepeFly();
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
	public EstadiMundialPepeFly() {
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
		
		JLabel lblRankingMundial = new JLabel("TOP 5 MUNDIAL PEPE FLY");
		lblRankingMundial.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblRankingMundial.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankingMundial.setBounds(64, 28, 313, 29);
		frame.getContentPane().add(lblRankingMundial);
		
		JLabel lblTop1 = new JLabel("1.");
		lblTop1.setBounds(86, 68, 18, 14);
		frame.getContentPane().add(lblTop1);
		
		JLabel lblTop2 = new JLabel("2.");
		lblTop2.setBounds(86, 82, 18, 14);
		frame.getContentPane().add(lblTop2);
		
		JLabel lblTop3 = new JLabel("3.");
		lblTop3.setBounds(86, 102, 18, 14);
		frame.getContentPane().add(lblTop3);
		
		JLabel lblTop4 = new JLabel("4.");
		lblTop4.setBounds(86, 117, 18, 14);
		frame.getContentPane().add(lblTop4);
		
		JLabel lblTop5 = new JLabel("5.");
		lblTop5.setBounds(86, 127, 18, 14);
		frame.getContentPane().add(lblTop5);
		
		JLabel lblScoresTopTen = new JLabel(""+UsuariosBD.topTenJuegoPuntuacion(2));
		lblScoresTopTen.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoresTopTen.setBounds(139, 68, 89, 134);
		frame.getContentPane().add(lblScoresTopTen);
		
		JLabel lblTop6 = new JLabel("6.");
		lblTop6.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop6.setBounds(86, 142, 18, 14);
		frame.getContentPane().add(lblTop6);
		
		JLabel lblTop7 = new JLabel("7.");
		lblTop7.setBounds(86, 152, 18, 14);
		frame.getContentPane().add(lblTop7);
		
		JLabel lblTop8 = new JLabel("8.");
		lblTop8.setBounds(86, 167, 18, 14);
		frame.getContentPane().add(lblTop8);
		
		JLabel lblTop9 = new JLabel("9.");
		lblTop9.setBounds(86, 177, 18, 14);
		frame.getContentPane().add(lblTop9);
		
		JLabel lblTop10 = new JLabel("10.");
		lblTop10.setBounds(86, 192, 18, 14);
		frame.getContentPane().add(lblTop10);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				ElegirEstadPepeFly a=new ElegirEstadPepeFly();
				a.frame.setVisible(true);
			}
		});
		
	}
}
