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

import javax.swing.JPanel;





import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import clases.UsuariosBD;

public class ComparaRecordsAngryBull {

	JFrame frame;
	String nick1, nick2;
	int idJuego;
	/**
	 * Launch the application.
	 */
	/*
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
	}*/

	/**
	 * Create the application.
	 * @param idJuego 
	 * @param nickJugador2 
	 * @param nickJugador1 
	 */
	public ComparaRecordsAngryBull(String nickJugador1, String nickJugador2, int idJuego) {
		nick1=nickJugador1;
		nick2=nickJugador2;
		this.idJuego=idJuego;
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
		
		JLabel lblComparacion = new JLabel("COMPARACI\u00D3N DE RECORDS TETRIS");
		lblComparacion.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		lblComparacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblComparacion.setBounds(58, 11, 310, 29);
		frame.getContentPane().add(lblComparacion);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(170, 227, 89, 23);
		frame.getContentPane().add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 51, 355, 169);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 292, 173);
		panel.add(lblNewLabel);
		btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Salir");
			EstadiJugadorTetris a=new EstadiJugadorTetris();
			a.frame.setVisible(true);
		}
		});
		
		/*creamos el grafico*/
		
		 JFreeChart barra = null;
		 
	     DefaultCategoryDataset datos;   
	     datos = new DefaultCategoryDataset();
	     HashMap<String, Integer> datosBd= UsuariosBD.obtenerPuntuacionesEstadistica(idJuego, nick1, nick2);
	     
	     datos.setValue(datosBd.get(nick1).intValue(), nick1, "");
	     datos.setValue(datosBd.get(nick2).intValue(), nick2, "");
	        
	        
	        
	        barra = ChartFactory.createBarChart3D("Estadistica tetris", "Usuarios","Puntuación máxima",datos,PlotOrientation.VERTICAL,true,true,true);
	        BufferedImage graficoBarra=barra.createBufferedImage(panel.getWidth(), panel.getHeight());

	        lblNewLabel.setSize(panel.getSize());
	        lblNewLabel.setIcon(new ImageIcon(graficoBarra));

	        panel.updateUI();

		
		}
}	
