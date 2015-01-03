package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.UsuariosBD;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopTenGeneral {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopTenGeneral window = new TopTenGeneral();
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
	public TopTenGeneral() {
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
		
		JLabel lblTopTenGeneral = new JLabel("TOP TEN GENERAL");
		lblTopTenGeneral.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblTopTenGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblTopTenGeneral.setBounds(130, 11, 184, 14);
		frame.getContentPane().add(lblTopTenGeneral);
		
		JLabel label_1 = new JLabel("1.");
		label_1.setBounds(42, 36, 17, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("2.");
		label_2.setBounds(42, 50, 17, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("3.");
		label_3.setBounds(42, 61, 17, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("4.");
		label_4.setBounds(42, 86, 17, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("5.");
		label_5.setBounds(42, 98, 17, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("6.");
		label_6.setBounds(42, 111, 17, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("7.");
		label_7.setBounds(42, 123, 17, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("8.");
		label_8.setBounds(42, 140, 17, 14);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("9.");
		label_9.setBounds(42, 148, 17, 14);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("10.");
		label_10.setBounds(42, 165, 17, 14);
		frame.getContentPane().add(label_10);
		
		JLabel lblScore = new JLabel(""+UsuariosBD.topTenGeneralPuntuacion());
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(88, 36, 184, 145);
		frame.getContentPane().add(lblScore);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(171, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblNicks = new JLabel(""+UsuariosBD.topTenGeneralNick());
		lblNicks.setHorizontalAlignment(SwingConstants.CENTER);
		lblNicks.setBounds(297, 36, 112, 145);
		frame.getContentPane().add(lblNicks);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EstadiGeneral a=new EstadiGeneral();
				a.frame.setVisible(true);
			}
		});
	}
}
