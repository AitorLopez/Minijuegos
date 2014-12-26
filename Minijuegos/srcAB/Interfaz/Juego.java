package Interfaz;

import Clases.Movimiento_Toro;
import Clases.Movimiento_Enemigos;

import java.awt.Color;
import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Asier Salsidua
 * @email  asier.salsidua@opendeusto.es
 */

public class Juego extends javax.swing.JFrame {

    public static JLabel jToro;
    public static JLabel jLabel2;
    public static JLabel jLabel3;
    public static JLabel jLabel4;
    private final JPanel jPanel1;
    public static JLabel jPuntuacion;
    public JLabel jSuelo;
    public static JLabel jEnemigo1;
    public static JLabel jEnemigo2;
    public static JLabel jEnergia;
    public static JLabel panelImage1;
    private Movimiento_Toro mvnt_Toro;
    private Movimiento_Enemigos mvnt_Enemigos;
    private boolean empezar = false;
    private Puntuacion puntuacion;
    private final Login login;
    private JPanel panel1;
    private JPanel panel2;
    public String nombre;
    static public boolean con_exitosa = false;
    Point posicionToro;
    public String ruta = "";
    int velocidad = 5;

    public Juego() {
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelImage1 = new javax.swing.JLabel();
        jSuelo = new javax.swing.JLabel();
        jPuntuacion = new javax.swing.JLabel();
        jToro = new javax.swing.JLabel();
        jEnemigo1 = new javax.swing.JLabel();
        jEnemigo2 = new javax.swing.JLabel();
        jEnergia = new javax.swing.JLabel();
        initComponents();
        this.setLocationRelativeTo(null);
        vistaObjetos(false);
        login = new Login();
        mostrarLogin();
        EventosExternos();
        this.setTitle("Angry Bull");
        puntuacion = new Puntuacion(this);
        posicionToro = jToro.getLocation();
        this.jPanel1.setSize(400, 607);
    }
    
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MAPA_NRO1.png")));
        panelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelImage1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
            	panelImage1MouseReleased(evt);
            }
        
        });
        panelImage1.setLayout(null);

        jSuelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/piso.png")));

        javax.swing.GroupLayout jSueloLayout = new javax.swing.GroupLayout(jSuelo);
        jSuelo.setLayout(jSueloLayout);
        jSueloLayout.setHorizontalGroup(
                jSueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 580, Short.MAX_VALUE)
        );
        jSueloLayout.setVerticalGroup(
                jSueloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 180, Short.MAX_VALUE)
        );

        panelImage1.add(jSuelo);
        jSuelo.setBounds(-130, 470, 580, 180);

        jPuntuacion.setFont(new java.awt.Font("Tahoma", 1, 40));
        jPuntuacion.setForeground(new java.awt.Color(255, 255, 255));
        jPuntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPuntuacion.setText("0");
        panelImage1.add(jPuntuacion);
        jPuntuacion.setBounds(0, 10, 400, 49);

        jToro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pezRojo1.png")));
        panelImage1.add(jToro);
        jToro.setBounds(70, 448, 34, 24);

        jEnemigo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tubo_2.png")));
        panelImage1.add(jEnemigo1);
        jEnemigo1.setBounds(70, 280, 52, 320);

        jEnemigo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tubo_2.png")));
        panelImage1.add(jEnemigo2);
        jEnemigo2.setBounds(290, 280, 52, 320);
        
        jEnergia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/pezRojo1.png")));
        panelImage1.add(jEnergia);
        jEnergia.setBounds(100000, 280, 34, 24);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }
    
    private void panelImage1MousePressed(java.awt.event.MouseEvent evt) {
        if (empezar) {
        	this.mvnt_Toro.setSaltar(true);
            jToro.requestFocus(true);
        }
    }
    
    private void panelImage1MouseReleased(java.awt.event.MouseEvent evt) {
       if (empezar) {
        	this.mvnt_Toro.setCaer(true);
            jToro.requestFocus(true);
        }
   }

    private void EventosExternos() {
        login.jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        nombre = this.login.jTextField1.getText();
        this.panel1.setVisible(false);
        Empezar();
        vistaObjetos(true);
    }

    public void Empezar() {
        mvnt_Enemigos = new Movimiento_Enemigos();
        mvnt_Toro = new Movimiento_Toro(this);
        mvnt_Enemigos.start();
        mvnt_Toro.start();
        empezar = true;
        jToro.requestFocus();
        this.setTitle("Angry Bull - " + nombre);
    }

    public boolean validarChoqueEnemigo() {
    	boolean caida=false;
        Point loclz_Toro = jToro.getLocation();
        Point enemigo1 = jEnemigo1.getLocation();
        Point enemigo2 = jEnemigo2.getLocation();        
        if (loclz_Toro.x > (enemigo1.x - 32) && loclz_Toro.x < ((enemigo1.x - 32) + 82) && loclz_Toro.y > (enemigo1.y - 22)) {
            this.mvnt_Enemigos.stop();
            this.mvnt_Toro.setSaltar(false);
            empezar = false;
            caida=true;
        } else if (loclz_Toro.x > (enemigo2.x - 32) && loclz_Toro.x < ((enemigo2.x - 32) + 82) && loclz_Toro.y > (enemigo2.y - 22)) {
            this.mvnt_Enemigos.stop();
            this.mvnt_Toro.setSaltar(false);
            empezar = false;
            caida=true;
        }
        return caida;
    }

    private void vistaObjetos(boolean accion) {
        jToro.setVisible(accion);
        jEnemigo1.setVisible(accion);
        jEnemigo2.setVisible(accion);
        jEnergia.setVisible(accion);
        jPuntuacion.setVisible(accion);
    }

    public synchronized void ValidarChoque() {
        int y = jToro.getLocation().y;
        if (y == 448) {
            GamerOver gamerover = new GamerOver(this, true);
            try {
                Thread hilo = new Thread() {
                    public void run() {
                        mvnt_Enemigos.stop();
                        Movimiento_Toro.detenethilo = true;
                        stop();
                    }
                };
                hilo.start();
            } catch (Exception e) {
            }
            gamerover.setVisible(true);
        }
    }

    public void mostrarPuntuacion() {
        vistaObjetos(false);
        panel2 = new JPanel();
        panel2.setBounds(0, 0, this.getWidth(), 550);
        panel2.add(puntuacion);
        puntuacion.setBounds(0, 0, panel2.getWidth(), panel2.getHeight());
        panelImage1.add(panel2);
        panel2.setBackground(new Color(255, 255, 153));
        puntuacion.setVisible(true);
        puntuacion.mostrar();
        panel2.setVisible(true);
    }

    public void EmpezarNuevo() {
        jToro.setLocation(posicionToro);
        jPuntuacion.setText("0");
        this.panel2.setVisible(false);
        Empezar();
        vistaObjetos(true);
        puntuacion = new Puntuacion(this);
    }

    private void mostrarLogin() {
        panel1 = new JPanel();
        panel1.setBounds(10, 200, 380, 140);
        panel1.add(login);
        login.setBounds(0, 0, panel1.getWidth(), panel1.getHeight());
        panelImage1.add(panel1);
        panel1.setBackground(new Color(255, 255, 153));
        login.setVisible(true);
        panel1.setVisible(true);
    }

}
