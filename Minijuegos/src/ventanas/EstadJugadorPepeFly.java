package ventanas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;

public class EstadJugadorPepeFly {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadJugadorTetris window = new EstadJugadorTetris();
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
	public EstadJugadorPepeFly() {
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
		
		JLabel lblEstadisticas = new JLabel("Estad\u00EDsticas");
		lblEstadisticas.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticas.setBounds(119, 29, 191, 29);
		frame.getContentPane().add(lblEstadisticas);
		
		JLabel lblRecordUsuario = new JLabel("Record usuario:");
		lblRecordUsuario.setBounds(61, 85, 94, 14);
		frame.getContentPane().add(lblRecordUsuario);
		
		JLabel lblPartidasGanadas = new JLabel("Partidas ganadas: ");
		lblPartidasGanadas.setBounds(61, 122, 94, 14);
		frame.getContentPane().add(lblPartidasGanadas);
		
		JLabel lblPorcentajeVictorias = new JLabel("Porcentaje victorias: ");
		lblPorcentajeVictorias.setBounds(61, 161, 150, 14);
		frame.getContentPane().add(lblPorcentajeVictorias);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				EleccionEstadPepeFly a=new EleccionEstadPepeFly();
				a.frame.setVisible(true);
			}
		});
	}
}
