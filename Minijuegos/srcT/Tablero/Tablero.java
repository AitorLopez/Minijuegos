package Tablero;

import interfaces.Constantes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Figura.Figura;
import Figura.Figura.Piezas;

public class Tablero extends JPanel implements ActionListener, Constantes  {
	/*
	 * Es el objeto JPanel donde se va a pintar las piezas en movimiento. 
	 * El control del juego se realiza a travÃ©s de un objeto Timer de java swing 
	 * que activa el mÃ©todo actionPerformed cada n segundos. 
	 */
	
	public int NUMPIEZAS = 9;
	public int NIVEL = 600; 
	Timer timer;
	boolean terminaCaer = false;
	boolean starp = false;
	boolean pausa = false;
	int Lineas = 0;
	int posX = 0; //posicion del eje de abscisas en el tablero lÃ³gico
	int posY = 0; //posicion del eje de ordenadas en el tablero lÃ³gico
	private Tetris fparent; 
	JLabel puntuacion;
	Figura posPieza; //tipo de pieza (para saber la figura activa)
	Piezas[] tablero;

	// El timer sirve para aÃ±adir un retraso entre cada actualizaciÃ³n del
	// tablero
	public Tablero(Tetris parent) {
		fparent = parent; 
		setFocusable(true);
		posPieza = new Figura();
		timer = new Timer(NIVEL, this); // DEPENDIENDO DEL NIVEL VARIARÃ� EL VALOR DEL TIMER
		puntuacion = parent.obtenerPuntuacion();
		tablero = new Piezas[ANCHO * ALTO];
		addKeyListener(new control());
		limpiaTablero();
	}

	// Este mÃ©todo comprueba si la pieza terminÃ³ de caer para crear otra pieza.
	// Si no ha caÃ­do, la pieza que va cayendo baja una lÃ­nea
	public void actionPerformed(ActionEvent e) {
		if (terminaCaer) {
			terminaCaer = false;
			piezaNueva();
		} else {
			bajaUna();
		}
	}

	int anchoCelda() {
		return (int) getSize().getWidth() / ANCHO; //Te da el tamaÃ±o en ancho de una pieza en pÃ­xeles
	}

	int altoCelda() {
		return (int) getSize().getHeight() / ALTO; //TamaÃ±o en alto de una pieza en pÃ­xeles
	}

	Piezas formaEn(int x, int y) { //MÃ©todo para conocer la posiciÃ³n de la figura en el array tablero
		return tablero[(y * ANCHO) + x];
	}

	// terminaCaer sirve para saber si la pieza ha llegado hasta abajo y se
	// ocupa de crear una nueva
	// Lineas es un contador para saber cuantas lineas ha elimiando el jugador
	// (la puntuaciÃ³n)
	public void start() {
		if (pausa)
			return;
		starp = true;
		terminaCaer = false;
		Lineas = 0;
		limpiaTablero();
		piezaNueva();
		timer.start();
	}

	// MenÃº de pausa del juego, si pulsas P, se pausa.
	public void pausa() {
		if (!starp)
			return;
		pausa = !pausa;
		if (pausa) {
			timer.stop();
			puntuacion.setText("pausa");
		} else {
			timer.start();
			puntuacion.setText(String.valueOf(Lineas)); //traduce el String de puntuaciÃ³n a un valor entero
		}
		/*
		 * Ejecuta el mÃ©todo sobrescrito paint(â€¦) que es el encargado de 
		 * repintar la nueva situaciÃ³n del juego en el JPanel.
		 */
		repaint();
	}

	// Todos los cuadros de las figuras que hay llegado al fondo se guardan en el
	// tablero lÃ³gico
	// Este mÃ©todo se encarga de pintar el tablero lÃ³gico en el lienzo o cambas (el JPanel)
	public void paint(Graphics g) {
		super.paint(g);
		
		//prueba para que se visualice en consola el nÃºmero de piezas que hay en el tablero lÃ³gico
		 /*int contador=0;
        for( int i =0; i<tablero.length; i++){
        	if(tablero[i] != Piezas.nada){
        		contador++;
        		
        		
        	}
        }
        System.out.println(contador);
        */
		Dimension tamano = getSize();
		int topeTableroA = (int) tamano.getHeight() - ALTO * altoCelda();
		for (int i = 0; i < ALTO; ++i) {
			for (int j = 0; j < ANCHO; ++j) {
				Piezas forma = formaEn(j, ALTO - i - 1);
				if (forma != Piezas.nada)
					dibuja(g, 0 + j * anchoCelda(), topeTableroA + i
							* altoCelda(), forma);
			}
		}
		// Pinta la pieza que va cayendo
		if (posPieza.obtenerFigura() != Piezas.nada) {
			for (int i = 0; i < 4; ++i) {
				int x = posX + posPieza.x(i);
				int y = posY - posPieza.y(i);
				dibuja(g, 0 + x * anchoCelda(), topeTableroA + (ALTO - y - 1)
						* altoCelda(), posPieza.obtenerFigura());
			}
		}
	}




	private void bajaUna() {
		if (!mueve(posPieza, posX, posY - 1))
			bajaPieza();
	}

	// llena el tablero con piezas vacias
	public void limpiaTablero() { //nuevo
		for (int i = 0; i < ALTO * ANCHO; ++i)
			tablero[i] = Piezas.nada;
	}

	// pone la pieza que va cayendo en el tablero logico.
	// Ese tablero contiene los cuadros de las piezas que han terminado de caer y
	// las que estan
	// cortadas por que se han borrado lineas.
	// Cuando la pieza termina de caer es necesario comprobar si se pueden
	// quitar lineas del tablero
	private void bajaPieza() {
		for (int i = 0; i < 4; ++i) {
			int x = posX + posPieza.x(i);
			int y = posY - posPieza.y(i);
			tablero[(y * ANCHO) + x] = posPieza.obtenerFigura();
		}
		quitaLinea();
		if (!terminaCaer)
			piezaNueva();
	}

	// Crea una pieza nueva por medio de un random para que salgan piezas al
	// azar.
	// Tambien comprueba si la pieza se puede mover al principio. Si no se puede
	// se termina el juego
	private void piezaNueva() {
		posPieza.ponerFiguraRnd(NUMPIEZAS);
		posX = ANCHO / 2 + 1;
		posY = ALTO - 1 + posPieza.minY();
		if (!mueve(posPieza, posX, posY)) {
			posPieza.ponerFigura(Piezas.nada);
			timer.stop();
			starp = false;
			JOptionPane mensaje = new JOptionPane();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            mensaje.setLocation(screenSize.width / 2 - mensaje.getSize().width / 2, screenSize.height / 2 - mensaje.getSize().height / 2);
            mensaje.showMessageDialog(null, "!!! PERDISTE !!!", "Aviso", JOptionPane.ERROR_MESSAGE);
			
			
			fparent.elJugar.setEnabled(true);
			fparent.elPausar.setEnabled(false);
			fparent.elNivelBasico.setEnabled(true);
			fparent.elNivelMedio.setEnabled(true);
			fparent.elNivelExperto.setEnabled(true);
			fparent.elTerminar.setEnabled(false);
		}
	}

	// Con este mÃ©todo se mueven las piezas. Devuelve falso si la pieza ha llegado a los
	// limites del tablero o si esta junto a otra pieza que ya esta en el tablero
	private boolean mueve(Figura piezaNueva, int nuevaX, int nuevaY) {
		for (int i = 0; i < 4; ++i) {
			int x = nuevaX + piezaNueva.x(i);
			int y = nuevaY - piezaNueva.y(i);
			if (x < 0 || x >= ANCHO || y < 0 || y >= ALTO)
				return false;
			if (formaEn(x, y) != Piezas.nada)
				return false;
		}
		posPieza = piezaNueva;
		posX = nuevaX;
		posY = nuevaY;
		repaint();
		return true;
	}

	// Elimina las lineas completas y las suma a la puntuacion
	private void quitaLinea() {
		int numFilasLlenas = 0;
		for (int i = ALTO - 1; i >= 0; --i) {
			boolean lineaLLena = true;
			for (int j = 0; j < ANCHO; ++j) {
				if (formaEn(j, i) == Piezas.nada) {
					lineaLLena = false;
					break;
				}
			}
			if (lineaLLena) {
				++numFilasLlenas;
				for (int k = i; k < ALTO - 1; ++k) {
					for (int j = 0; j < ANCHO; ++j)
						tablero[(k * ANCHO) + j] = formaEn(j, k + 1);
				}
			}
		}
		if (numFilasLlenas > 0) {
			Lineas += numFilasLlenas;
			puntuacion.setText(String.valueOf(Lineas));
			terminaCaer = true;
			posPieza.ponerFigura(Piezas.nada);
			repaint();
		}
	}

	// Todas las piezas tienen 4 celdas y son de diferentes colores
	private void dibuja(Graphics g, int x, int y, Piezas figura) {
		Color colores[] = { new Color(5, 5, 5), new Color(204, 102, 102),
				new Color(102, 204, 102), new Color(23, 102, 204),
				new Color(204, 204, 42), new Color(204, 102, 204),
				new Color(102, 204, 204), new Color(218, 170, 0),
				new Color(140, 80, 60),
				new Color(123, 150, 34), new Color(237, 110, 90),
				};
		Color color = colores[figura.ordinal()];
		g.setColor(color);
		g.fillRect(x + 1, y + 1, anchoCelda() - 2, altoCelda() - 2);
	
	}

	// Se definen los controles del teclado: p para poner pausa, flecha izquierda
	// mueve pieza a la izquierda
	// flecha derecha mueve pieza a la derecha y flecha abajo baja la pieza
	// idos posiciones hacia abajo, hasta que tope con otra figura
	class control extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (!starp || posPieza.obtenerFigura() == Piezas.nada) {
				return;
			}
			int keycode = e.getKeyCode();
			if (keycode == 'p' || keycode == 'P') {
				pausa();
				if(pausa){
					fparent.elPausar.setText("Reanudar");
					
				}
				else{
					fparent.elPausar.setText("Pausa");
					
				}
				
				return;
			}
			if (pausa)
				return;
			switch (keycode) {
			case KeyEvent.VK_LEFT:
				mueve(posPieza, posX - 1, posY);
				break;
			case KeyEvent.VK_RIGHT:
				mueve(posPieza, posX + 1, posY);
				break;
			case KeyEvent.VK_DOWN:
				
				mueve(posPieza, posX , posY -2);
				break;
			case KeyEvent.VK_UP:
				mueve(posPieza.rotar(), posX, posY);
				break;
			}
		}
	}

}
