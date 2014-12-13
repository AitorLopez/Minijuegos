package Figura;

import java.util.*;
import java.lang.*;

public class Figura {
	
	 	public enum Piezas { nada, zeta, ese, linea, tee , cuadro, ele, otraele, semiele, medialinea, minilinea };
	    private Piezas piezaFigura;
	    private int coordenadas[][];  //Dimensiones : [4][2] En el array coordenadas se guardan los cuatro pares de coordenadas necesarios para representar a cada pieza de cuatro cuadros
	    private int[][][] coordenadasTablero; //Dimensiones : [8]-->Una posicion para cada matriz [4][2] las ocho matrices de coordenadas de cada una de las ocho piezas.
	    public int nPiezas = 9; //Ponemos 9 piezas standar, ya que empezamos en el nivel medio
	    //Constructor con las coordenadas de la pieza en el tablero
	    public Figura()
	        {
	        coordenadas = new int[4][2];
	        ponerFigura(Piezas.nada);
	        }
	    //Todos los posibles valores de coordenadas para las piezas
	  
	    public void ponerFigura(Piezas Figura)
	        {
	        coordenadasTablero = new int[][][]
	           
	        	    { { 
		            	{ 0, 0 }, { 0, 0 },   { 0, 0 },   { 0, 0 } 
		              },
		              { 
		            	  { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 }
		              },
		              { 
		            	  { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } 
		              }, 
		              { 
		            	  { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2  } 
		              },
		              { 
		            	  { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 }
		              },
		              { 
		            	  { 0, 0 },   { 1, 0 },   { 1, 1 },   { 0, 1 } 
		              },
		              { 
		            	  { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } 
		              }, 
		              {
		            	  { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 }
		              },
		              {
		            	  { 0, -1 },  { 0, 0 },  { -1, 0 },   { 0, 0 }
		              },
		              {
		            	  { 0, -1 },  { 0, 0 },  { 0, 1 },   { 0, 0 }
		              },
		              {
		            	  { 0, -1 },  { 0, 0 },  { 0, -1 },   { 0, 0 }
		              }
		            };
	        for (int i = 0; i < 4 ; i++)
	            {
	            for (int j = 0; j < 2; ++j)
	                {
	                coordenadas[i][j] = coordenadasTablero[Figura.ordinal()][i][j];   //El método ordinal() devuelve la posición actual del objeto pieza
	                }
	            }
	        piezaFigura = Figura;
	        }
	    private void ponX(int index, int x)
	        {
	        coordenadas[index][0] = x;
	        }
	    private void ponY(int index, int y)
	        {
	        coordenadas[index][1] = y;
	        }
	    public int x(int index) 
	        {
	        return coordenadas[index][0];
	        }
	    public int y(int index) 
	        {
	        return coordenadas[index][1];
	        }
	    public Piezas obtenerFigura()
	        {
	        return piezaFigura;
	        }
	    public void ponerFiguraRnd(int np)  //Este método pone una figura aleatoria entre la primera del enum y nPiezas.
	        {
	    	nPiezas=np;	
	        Random r = new Random();
	        int x = Math.abs(r.nextInt()) % nPiezas + 1;
	        System.out.println(x);
	        Piezas[] values = Piezas.values();
	        ponerFigura(values[x]);
	        }
	    public int minX()
	        {
	        int m = coordenadas[0][0];
	        for (int i=0; i < 4; i++)
	            {
	            m = Math.min(m, coordenadas[i][0]);
	            }
	        return m;
	        }
	    public int minY()
	        {
	        int m = coordenadas[0][1];
	        for (int i=0; i < 4; i++)
	            {
	            m = Math.min(m, coordenadas[i][1]);
	            }
	        return m;
	        }
	 
	    /*
	     * 	El método rotar() se ocupa de rotar las figuras
	     * 	Como tenemos ocho piezas guardamos en el array coordenadasTablero las ocho matrices de coordenadas de cada una de las ocho piezas.
			Las piezas giran en sentido inverso a las agujas del reloj, menos el cuadrado y la pieza nula que no giran.
		 	El sistema para girar una pieza, cuando pulsamos la tecla “up”, consiste en cambiar cada par de coordenadas de la siguiente forma:
			La nueva coordenada X es la antigua coordenada Y.
			La nueva coordenada Y es la antigua coordenada X cambiada de signo.
			Por ejemplo: la rotación de la pieza “ele” sería:
			(-1, -1)  (0, -1) (0, 0) (0, 1)
			(-1, 1)  (-1, 0) (0, 0) (1, 0)
			(1, 1)  (0, 1) (0, 0) (0, -1)
			(1, -1)  (1, 0) (0, 0) (-1, 0)

	     */
	    public Figura rotar()
	        {
	        if (piezaFigura == Piezas.cuadro)
	            return this;
	        Figura resultado = new Figura();
	        resultado.piezaFigura = piezaFigura;
	        for (int i = 0; i < 4; ++i)
	            {
	            resultado.ponX(i, y(i));
	            resultado.ponY(i, -x(i));
	            }
	        return resultado;
	        }

}
