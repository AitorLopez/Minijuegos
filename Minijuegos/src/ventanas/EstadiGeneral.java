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

public class EstadiGeneral {

	JFrame frame;
	private JLabel lblMayorRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadiGeneral window = new EstadiGeneral();
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
	public EstadiGeneral() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEstadsticasGenerales = new JLabel("ESTAD\u00CDSTICAS GENERALES");
		lblEstadsticasGenerales.setFont(new Font("Gill Sans Ultra Bold Condensed", Font.PLAIN, 13));
		lblEstadsticasGenerales.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadsticasGenerales.setBounds(95, 11, 240, 37);
		frame.getContentPane().add(lblEstadsticasGenerales);
		
		JLabel lblMinijuegoMasUsado = new JLabel("Minijuego que m\u00E1s has usado:");
		lblMinijuegoMasUsado.setBounds(24, 66, 203, 14);
		frame.getContentPane().add(lblMinijuegoMasUsado);
		
		JLabel lblJuegasMasA = new JLabel("");
		lblJuegasMasA.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuegasMasA.setBounds(237, 66, 158, 14);
		frame.getContentPane().add(lblJuegasMasA);
		
		JLabel lblMinijuegoConMayorRecord = new JLabel("Minijuego con mayor record:");
		lblMinijuegoConMayorRecord.setBounds(24, 106, 203, 14);
		frame.getContentPane().add(lblMinijuegoConMayorRecord);
		
		lblMayorRecord = new JLabel(""+UsuariosBD.JuegoMasUtilizado(EntraORegistrate.usu.getNick()));
		lblMayorRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblMayorRecord.setBounds(236, 106, 170, 14);
		frame.getContentPane().add(lblMayorRecord);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnTopTen = new JButton("Top Ten");
		btnTopTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TopTenGeneral a=new TopTenGeneral();
				a.frame.setVisible(true);	
			}
		});
		btnTopTen.setBounds(40, 155, 89, 23);
		frame.getContentPane().add(btnTopTen);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(171, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EligeMinijuego a=new EligeMinijuego();
				a.frame.setVisible(true);
			}
		});
	}
}
