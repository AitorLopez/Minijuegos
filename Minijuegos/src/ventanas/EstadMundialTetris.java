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

public class EstadMundialTetris {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadMundialTetris window = new EstadMundialTetris();
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
	public EstadMundialTetris() {
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
		
		JLabel lblEstadisticaMundial = new JLabel("Estad\u00EDsticas Mundiales Tetris");
		lblEstadisticaMundial.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEstadisticaMundial.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticaMundial.setBounds(64, 28, 294, 29);
		frame.getContentPane().add(lblEstadisticaMundial);
		
		JLabel lblRecordMundial = new JLabel("Record Mundial:");
		lblRecordMundial.setBounds(61, 85, 94, 14);
		frame.getContentPane().add(lblRecordMundial);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		
/*	JLabel lblRecord = new JLabel(UsuariosBD.recordMundialPartidaTetris(1));
		lblRecord.setBackground(new Color(0, 255, 0));
		lblRecord.setBounds(165, 85, 179, 14);
		frame.getContentPane().add(lblRecord);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EleccionEstadTetris a=new EleccionEstadTetris();
				a.frame.setVisible(true);
			}
		});*/
	}
}
