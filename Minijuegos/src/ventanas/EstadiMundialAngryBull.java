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

public class EstadiMundialAngryBull{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadiMundialAngryBull window = new EstadiMundialAngryBull();
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
	public EstadiMundialAngryBull() {
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
		
		JLabel lblRankingMundial = new JLabel("TOP 10 MUNDIAL ANGRY BULL");
		lblRankingMundial.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblRankingMundial.setHorizontalAlignment(SwingConstants.CENTER);
		lblRankingMundial.setBounds(64, 28, 313, 29);
		frame.getContentPane().add(lblRankingMundial);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				ElegirEstadAngryBull a=new ElegirEstadAngryBull();
				a.frame.setVisible(true);
			}
		});
		
		/*JLabel lblRecord = new JLabel(UsuariosBD.recordMundialPartida(1));
		lblRecord.setBackground(new Color(0, 255, 0));
		lblRecord.setBounds(165, 85, 179, 14);
		frame.getContentPane().add(lblRecord);*/
		
	}
}
