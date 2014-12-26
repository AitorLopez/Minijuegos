package Clases;

import Interfaz.Juego;

/**
 *
 * @author Asier Salsidua
 * @email  asier.salsidua@opendeusto.es
 */

public class Movimiento_Toro extends Thread {

    private int velocidad;
    private boolean saltar;
    private boolean caer;
    private final Juego parent;
    public static boolean detenethilo;

    public Movimiento_Toro(Juego parent) {
        this.velocidad = 5;
        this.parent = parent;
    }

    @Override
    public void run() {
        detenethilo = false;
        double tiempo_caida = 5.5;
        while (true) {
            if (detenethilo) {
                break;
            }
            int x = Juego.jToro.getLocation().x;
            int y = Juego.jToro.getLocation().y;
            try {
            	setCaer(false);
            	if (!isSaltar()&&Juego.jToro.getLocation().y!=448) {
                    Thread.sleep(getVelocidad());
                    Juego.jToro.setLocation(x, (y + (int)((Math.sin(tiempo_caida)+Math.cos(tiempo_caida))*2)));
                    tiempo_caida += 0.05;
            	}
            	else if (!isSaltar()&&Juego.jToro.getLocation().y!=448)
            		Thread.sleep(getVelocidad());
            	else if(isSaltar()&&Juego.jToro.getLocation().y!=448)
            		setSaltar(false);
            	else if(isSaltar()&&Juego.jToro.getLocation().y==448){
            		tiempo_caida=5.5;
            		saltar();
            	}
            	if(parent.validarChoqueEnemigo()){
            		while(Juego.jToro.getLocation().y!=448){
            			Thread.sleep(getVelocidad());
            			y = Juego.jToro.getLocation().y;
            			Juego.jToro.setLocation(x, (y + 1));
            		}	
            		parent.ValidarChoque();
            	}
            } catch (InterruptedException e) {
                    System.out.println("Ocurrio un problema " + e);
                }
        } 
    }

    public void saltar() {
        double tiempo_salto = 2.4;
        while (true) {
            int y = Juego.jToro.getLocation().y;
            int x = Juego.jToro.getLocation().x;
            try {
                Thread.sleep(getVelocidad());
                    tiempo_salto += 0.05;
                    if (tiempo_salto < 5.45) 
                        Juego.jToro.setLocation(x, (y + (int)((Math.sin(tiempo_salto)+Math.cos(tiempo_salto))*2)));
                    else if (tiempo_salto >= 5.5 && isCaer()){
                    	setSaltar(false);
                    	break;
                    } else if (tiempo_salto >= 10) {
                        setSaltar(false);
                        break;
                    }  
                    if (parent.validarChoqueEnemigo())
                    	break;
            } catch (InterruptedException e) {
                System.out.println("Ocurrio un error " + e);
            }
        }
        
    } 
    
    public boolean isSaltar() {
        return saltar;
    }

    public void setSaltar(boolean saltar) {
        this.saltar = saltar;
    }
    
    public boolean isCaer() {
		return caer;
	}

	public void setCaer(boolean caer) {
		this.caer = caer;
	}
	
    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public boolean isDetenethilo() {
        return detenethilo;
    }

}
