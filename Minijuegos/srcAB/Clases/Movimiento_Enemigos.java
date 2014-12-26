package Clases;

import Interfaz.Juego;

/**
 *
 * @author Asier Salsidua
 * @email  asier.salsidua@opendeusto.es
 */

public class Movimiento_Enemigos extends Thread {

    private int velocidad;
    private static int puntos;
    private boolean energia;
    private Enemigo enemigos[]=new Enemigo[5];

    public Movimiento_Enemigos() {
        velocidad = 5;
        puntos = 0;
        ocultarTubos();
    }

    private static synchronized void sumarPuntos() {
        int enemigo1 = Juego.jEnemigo1.getLocation().x;
        int enemigo2 = Juego.jEnemigo2.getLocation().x;
        if (enemigo1 == 90) {
            puntos = puntos + 1;
            Juego.jPuntuacion.setText(puntos + "");
        } else if (enemigo2 == 90) {
            puntos = puntos + 1;
            Juego.jPuntuacion.setText(puntos + "");
        }
    }

    @Override
    public void run() {
        int x1 = Juego.jEnemigo1.getLocation().x;
        int x2 = Juego.jEnemigo2.getLocation().x;
        int x3 = Juego.jEnergia.getLocation().x;
        while (true) {
            try {
                Thread.sleep(getVelocidad());
                x1--;
                x2--;
                x3--;
                Juego.jEnemigo1.setLocation(x1, 400);
                Juego.jEnemigo2.setLocation(x2, 400);
                Juego.jEnergia.setLocation(x3,400);
                if (x1 <= -51) {
                    x1 = generarPosicionAleatoria(425);
                }
                if (x2 <= -51) {
                    x2 = x1+425;
                }
                if (x3 <= -51) {
                    x3 = generarPosicionAleatoria(10000);
                }
                sumarPuntos();
            } catch (InterruptedException ex) {
                System.out.println("problema al mover los tubos " + ex);
            }
        }
    }

    private void ocultarTubos() {
        Juego.jEnemigo1.setLocation(460, 1000);
        Juego.jEnemigo2.setLocation(700, 1000);
        Juego.jEnergia.setLocation(1500,1000);
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    public void setVelocidad(int v){
    	velocidad=v;
    }

    private int generarPosicionAleatoria(int num) {
        int numero = (int) (Math.random() * 425+num);
        return numero;
    }

}
