package ventanas;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.Usuario;
import clases.UsuariosBD;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.JTextField;

public class EstadiJugadorAngryBull {

	JFrame frame;
	private JTextField textField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstadiJugadorAngryBull window = new EstadiJugadorAngryBull();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EstadiJugadorAngryBull() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEstadisticaUsuario = new JLabel("Estad\u00EDsticas Angry Bull");
		lblEstadisticaUsuario.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblEstadisticaUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstadisticaUsuario.setBounds(90, 29, 267, 29);
		frame.getContentPane().add(lblEstadisticaUsuario);
		
		JLabel lblRecordUsuario = new JLabel("Record usuario:");
		lblRecordUsuario.setBounds(20, 85, 94, 14);
		frame.getContentPane().add(lblRecordUsuario);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		JLabel lblRecord = new JLabel(""+UsuariosBD.recordPersonalJuego(3,EntraORegistrate.usu.getNick()));
		lblRecord.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecord.setBounds(236, 85, 121, 14);
		frame.getContentPane().add(lblRecord);
		
		JLabel lblNewLabel = new JLabel(""+UsuariosBD.ultimaFechaUsuarioJuega(3,EntraORegistrate.usu.getNick()));
		lblNewLabel.setBounds(228, 179, 165, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblFecha = new JLabel("Fecha de la \u00FAltima partida jugada:");
		lblFecha.setBounds(20, 179, 198, 14);
		frame.getContentPane().add(lblFecha);
		
		JLabel lblVisualizaFecha = new JLabel("");
		lblVisualizaFecha.setBounds(301, 120, 46, 14);
		frame.getContentPane().add(lblVisualizaFecha);
		
		JLabel lblCompararRecordCon = new JLabel("Comparar record con otro usuario");
		lblCompararRecordCon.setBounds(20, 120, 239, 14);
		frame.getContentPane().add(lblCompararRecordCon);
		
		textField = new JTextField();
		textField.setBounds(196, 137, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCompararGrafico = new JButton("Comparar");
		btnCompararGrafico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ComparaRecordsAngryBull a= new ComparaRecordsAngryBull(EntraORegistrate.usu.getNick(), textField.getText(), 2);
				a.frame.setVisible(true);
			}
		});
		btnCompararGrafico.setBounds(324, 136, 100, 23);
		frame.getContentPane().add(btnCompararGrafico);
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Salir");
				ElegirEstadAngryBull a=new ElegirEstadAngryBull();
				a.frame.setVisible(true);
			}
		});
	}
}