package Tablero;

import interfaces.Constantes;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//EN ESTA CLASE SE DEFINE LA VISUALIZACIÓN Y LA FUNCIONALIDAD DE LA VENTANA 
// Y DE SUS COMPONENTES, Y SE CREA EL MAIN PARA PODER UTILIZAR EL JUEGO.
public class Tetris extends JFrame implements Constantes {
	
	private Tablero tab;
	JLabel puntuacion;
	public JMenuItem elJugar;
	public JMenuItem elPausar;
	public JMenuItem elTerminar;
	public JMenuItem elNivelBasico;
	public JMenuItem elNivelMedio;
	public JMenuItem elNivelExperto;
	public int NIVEL = 600;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	private ImageIcon icon4;
	private ImageIcon icon5;
	private ImageIcon icon6;
	private ImageIcon icon7;
	private ImageIcon icon8;
	private JMenu menuAyuda;
	private JMenuItem elAyuda;
	private JMenuItem elSalir;
	
	public Tetris() {
		puntuacion = new JLabel(" 0");
		getContentPane().add(puntuacion, BorderLayout.SOUTH);
		tab = new Tablero(this);
		getContentPane().add(tab);
		
		
		setSize(200, 400);
		setTitle("Tetris");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		 icon1 = new ImageIcon(getClass().getResource("../imagenes/jugar.png"));
		 icon2 = new ImageIcon(getClass().getResource("../imagenes/terminar.png"));
		 icon3 = new ImageIcon(getClass().getResource("../imagenes/exit.png"));
		 icon4 = new ImageIcon(getClass().getResource("../imagenes/intro.png"));
		 icon5 = new ImageIcon(getClass().getResource("../imagenes/verde.png"));
		 icon6 = new ImageIcon(getClass().getResource("../imagenes/violeta.png"));
		 icon7 = new ImageIcon(getClass().getResource("../imagenes/rojo.png"));
		 icon8 = new ImageIcon(getClass().getResource("../imagenes/gris.png"));
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setMnemonic('A');
		menuBar.add(menuArchivo);

		elJugar = new JMenuItem("Jugar");
		elJugar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		elJugar.setMnemonic('J');
		elJugar.setEnabled(true);
		elJugar.setActionCommand("jugar");
		elJugar.setIcon(icon1);
		menuArchivo.add(elJugar);
		
		elPausar = new JMenuItem("Pausa");
		elPausar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		elPausar.setMnemonic('P');
		elPausar.setEnabled(false);
		elPausar.setActionCommand("pausa");
		elPausar.setIcon(icon4);
		menuArchivo.add(elPausar);
		
		elTerminar = new JMenuItem("Terminar");
		elTerminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		elTerminar.setMnemonic('T');
		elTerminar.setEnabled(false);
		elTerminar.setActionCommand("terminar");
		elTerminar.setIcon(icon2);
		menuArchivo.add(elTerminar);
		
		
		JMenu menuNivel = new JMenu("Nivel");
		menuArchivo.setMnemonic('N');
		
		
		menuBar.add(menuNivel);
		elNivelBasico = new JMenuItem("Básico");
		elNivelBasico.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		elNivelBasico.setMnemonic('B');
		elNivelBasico.setEnabled(true);
		elNivelBasico.setActionCommand("básico");
		elNivelBasico.setIcon(icon5);
		menuNivel.add(elNivelBasico);
		
		elNivelMedio = new JMenuItem("Medio");
		elNivelMedio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		elNivelMedio.setMnemonic('M');
		elNivelMedio.setEnabled(true);
		elNivelMedio.setActionCommand("medio");
		elNivelMedio.setIcon(icon8);
		menuNivel.add(elNivelMedio);
		
		elNivelExperto = new JMenuItem("Experto");
		elNivelExperto.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		elNivelExperto.setMnemonic('E');
		elNivelExperto.setEnabled(true);
		elNivelExperto.setActionCommand("experto");
		elNivelExperto.setIcon(icon7);
		menuNivel.add(elNivelExperto);
		
		menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);
		
		elAyuda = new JMenuItem("Ayuda");
		elAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		menuAyuda.add(elAyuda);
		
		elAyuda.setMnemonic('J');
		elAyuda.setEnabled(true);
		elAyuda.setActionCommand("ayuda");
		elAyuda.setIcon(icon4);
		menuAyuda.add(elAyuda);
		
		elSalir = new JMenuItem("Salir");
		elSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				actionMenu(arg0);
			}
		});
		
		
		elSalir.setMnemonic('S');
		elSalir.setEnabled(true);
		elSalir.setActionCommand("salir");
		elSalir.setIcon(icon3);
		menuArchivo.add(elSalir);
		
		
		
	}

	public JLabel obtenerPuntuacion() {
		return puntuacion;
	}
	
	public void actionMenu(ActionEvent e){
		
		if(e.getActionCommand().equalsIgnoreCase("jugar")){
			
			elJugar.setEnabled(false);
			elPausar.setEnabled(true);
			elTerminar.setEnabled(true);
			elNivelBasico.setEnabled(false);
			elNivelMedio.setEnabled(false);
			elNivelExperto.setEnabled(false);
			puntuacion.setText("0");
			tab.start();
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("pausa")){
			
			tab.pausa();
			if(tab.pausa){
				elPausar.setText("Reanudar");
				
			}
			else{
				elPausar.setText("Pausa");
				
			}
		}
		
		if(e.getActionCommand().equalsIgnoreCase("terminar")){
			
			tab.timer.stop();
			tab.limpiaTablero();
			elJugar.setEnabled(true);
			elPausar.setEnabled(false);
			elTerminar.setEnabled(false);
			elNivelBasico.setEnabled(true);
			elNivelMedio.setEnabled(true);
			elNivelExperto.setEnabled(true);
			
				
			
		}
		
		if(e.getActionCommand().equalsIgnoreCase("experto")){
			
			tab.NIVEL = EXPERTO;
			tab.timer = new Timer(tab.NIVEL, tab);
			elNivelExperto.setIcon(icon8);
			elNivelMedio.setIcon(icon6);
			elNivelBasico.setIcon(icon5);
			tab.NUMPIEZAS = 7;
		}
		
		if(e.getActionCommand().equalsIgnoreCase("medio")){
			
			tab.NIVEL = MEDIO;
			tab.timer = new Timer(tab.NIVEL, tab);
			elNivelMedio.setIcon(icon8);
			elNivelExperto.setIcon(icon7);
			elNivelBasico.setIcon(icon5);
			tab.NUMPIEZAS = 9;
		}
		
		if(e.getActionCommand().equalsIgnoreCase("básico")){
			
			tab.NIVEL = BASICO;
			tab.timer = new Timer(tab.NIVEL, tab);
			elNivelBasico.setIcon(icon8);
			elNivelMedio.setIcon(icon6);
			elNivelExperto.setIcon(icon7);
			tab.NUMPIEZAS = 10;
		}
		
		if(e.getActionCommand().equalsIgnoreCase("ayuda")){
			
			Ayuda menuAyuda = new Ayuda(this);
			if(!tab.pausa){
				tab.pausa();
				elPausar.setText("Reanudar");
			}
			
			menuAyuda.setVisible(true);
		}
		
		if(e.getActionCommand().equalsIgnoreCase("salir")){
			
			tab.timer.stop();
			this.dispose();
			
		}
			
			
		
		
		
		
	}

	//Pone el juego en marcha
	public static void main(String[] args) {
		Tetris juego = new Tetris();
		juego.setVisible(true);
	}

}
