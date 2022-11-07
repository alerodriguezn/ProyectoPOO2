/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectopoo.juego1;

import com.mycompany.proyectopoo.interfaces.iJuego;
import com.mycompany.proyectopoo.interfaces.iJugador;



import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.Random;
import javax.swing.JButton;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class FrameJuego1 extends javax.swing.JFrame implements iJuego {

    public static String jugadorGanador;
    public static int puntaje = 0;
    public static ArrayList<JButton> camposJuego;
    public static boolean juegoIniciado = false;
    public static boolean juegoEnProgreso = false;
    public static String tituloJuego = "Tic Tac Toe";
    public static String descripcionJuego = "El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego";
    private LocalDateTime inicioFechaHora;
    private LocalDateTime finFechaHora;
    private iJugador jugador;
    private boolean estadoFinalizacion = false;
    
    /**
     * Creates new form FrameJuego1
     */
    public FrameJuego1() {
        initComponents();
        camposJuego = new ArrayList<JButton>(Arrays.asList(jButton5, jButton7, jButton8, jButton9, jButton11, jButton10, jButton12, jButton14, jButton13));
        jButton5.setBackground(Color.WHITE);
        jButton7.setBackground(Color.WHITE);
        jButton8.setBackground(Color.WHITE);
        jButton9.setBackground(Color.WHITE);
        jButton10.setBackground(Color.WHITE);
        jButton11.setBackground(Color.WHITE);
        jButton12.setBackground(Color.WHITE);
        jButton13.setBackground(Color.WHITE);
        jButton14.setBackground(Color.WHITE);
    }

    /**
     * Limpia los campos del juego
     */
    public void limpiarJuego() {
        juegoEnProgreso = false;
        jButton5.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        jButton10.setText("");
        jButton11.setText("");
        jButton12.setText("");
        jButton13.setText("");
        jButton14.setText("");
        jButton5.setBackground(Color.WHITE);
        jButton7.setBackground(Color.WHITE);
        jButton8.setBackground(Color.WHITE);
        jButton9.setBackground(Color.WHITE);
        jButton10.setBackground(Color.WHITE);
        jButton11.setBackground(Color.WHITE);
        jButton12.setBackground(Color.WHITE);
        jButton13.setBackground(Color.WHITE);
        jButton14.setBackground(Color.WHITE);
    }
    
   

    /**
     * Valida si hubo un gane y nos devuelve true o false y se guardan los datos
     */
    public boolean validarGane(String simbolo, String jugador) {
        boolean horizontal1 = ((simbolo.equals(jButton5.getText())) && (simbolo.equals(jButton7.getText())) && (simbolo.equals(jButton8.getText())));
        boolean horizontal2 = ((simbolo.equals(jButton9.getText())) && (simbolo.equals(jButton10.getText())) && (simbolo.equals(jButton11.getText())));
        boolean horizontal3 = ((simbolo.equals(jButton12.getText())) && (simbolo.equals(jButton14.getText())) && (simbolo.equals(jButton13.getText())));
        boolean vertical1 = ((simbolo.equals(jButton5.getText())) && (simbolo.equals(jButton9.getText())) && (simbolo.equals(jButton12.getText())));
        boolean vertical2 = ((simbolo.equals(jButton11.getText())) && (simbolo.equals(jButton7.getText())) && (simbolo.equals(jButton14.getText())));
        boolean vertical3 = ((simbolo.equals(jButton8.getText())) && (simbolo.equals(jButton10.getText())) && (simbolo.equals(jButton13.getText())));
        boolean diagonal1 = ((simbolo.equals(jButton5.getText())) && (simbolo.equals(jButton11.getText())) && (simbolo.equals(jButton13.getText())));
        boolean diagonal2 = ((simbolo.equals(jButton12.getText())) && (simbolo.equals(jButton11.getText())) && (simbolo.equals(jButton8.getText())));
        if (horizontal1 || horizontal2 || horizontal3 || vertical1 || vertical2 || vertical3 || diagonal1 || diagonal2) {
            jugadorGanador = jugador;
            Color colorGanador = Color.WHITE;
            if(simbolo.equals("O")){
                colorGanador = Color.RED;
            }else if(simbolo.equals("X")){
                colorGanador = Color.GREEN;
            }
            if(horizontal1)
            {
                jButton5.setBackground(colorGanador);
                jButton7.setBackground(colorGanador);
                jButton8.setBackground(colorGanador);
            }
            if(horizontal2)
            {
                jButton9.setBackground(colorGanador);
                jButton10.setBackground(colorGanador);
                jButton11.setBackground(colorGanador);
            }
            if(horizontal3)
            {
                jButton12.setBackground(colorGanador);
                jButton14.setBackground(colorGanador);
                jButton13.setBackground(colorGanador);
            }
            if(vertical1)
            {
                jButton5.setBackground(colorGanador);
                jButton9.setBackground(colorGanador);
                jButton12.setBackground(colorGanador);
            }
            if(vertical2)
            {
                jButton11.setBackground(colorGanador);
                jButton7.setBackground(colorGanador);
                jButton14.setBackground(colorGanador);
            }
            if(vertical3)
            {
                jButton13.setBackground(colorGanador);
                jButton10.setBackground(colorGanador);
                jButton8.setBackground(colorGanador);
            }
            if(diagonal1)
            {
                jButton11.setBackground(colorGanador);
                jButton5.setBackground(colorGanador);
                jButton13.setBackground(colorGanador);
            }
            if(diagonal2)
            {
                jButton12.setBackground(colorGanador);
                jButton11.setBackground(colorGanador);
                jButton8.setBackground(colorGanador);
            }
            return true;
        }   
        return false;
    }

    public void actualizarInterfaz() {
        if (juegoIniciado) {
            jLabel4.setText("Puntaje Total: " + puntaje);
        }
        if (juegoEnProgreso) {
            jButton6.setText("Rendirse");
        } else {
            jButton6.setText("Salir");
        }
    }

    /**
     * Funcion para obtener numeros aleatorios entre rangos de numeros
     *
     * @param min El valor inicial del rango
     * @param max El valor final del rango
     */
    public static int rand(int min, int max) {
        if (min > max || (max - min + 1 > Integer.MAX_VALUE)) {
            throw new IllegalArgumentException("Rango no valido");
        }

        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * Funcion para que el robot haga su jugada en el tik tak toe
     */
    public void turnoRobot() {
        //Vemos SI el robot tiene una posicion disponible para jugar.
        boolean posicionLibre = false;

        for (JButton boton : camposJuego) {
            if (boton.getText().equals("")) {
                posicionLibre = true;
                break;
            }
        }

        if (posicionLibre) {
            while (true) {
                int posicionAleatoria = rand(0, 8);
                if (camposJuego.get(posicionAleatoria).getText().equals("")) {
                    camposJuego.get(posicionAleatoria).setText("O");
                    if (validarGane("O", "")) {
                        juegoEnProgreso = false;
                        JOptionPane.showMessageDialog(jPanel1, "Derrota! Puntos Obtenidos: 0");
                        limpiarJuego();
                        actualizarInterfaz();
                    }
                    break;
                }
            }
        } else {
            juegoEnProgreso = false;
            JOptionPane.showMessageDialog(jPanel1, "Empate! Puntos Obtenidos: 5");
            puntaje += 5;
            limpiarJuego();
            actualizarInterfaz();
        }
    }

    /**
     * Accion para cuando se da click en algun boton durante el juego
     */
    public void accionJugada(JButton boton) {
        juegoIniciado = true;
        juegoEnProgreso = true;
        if(this.inicioFechaHora == null)
        {
            this.inicioFechaHora = LocalDateTime.now();
        }
        actualizarInterfaz();
        if (boton.getText().equals("")) {
            boton.setText("X");
            if (validarGane("X", "Nombre Usuario")) {
                juegoEnProgreso = false;
                JOptionPane.showMessageDialog(jPanel1, "Victoria! Puntos Obtenidos: 10");
                limpiarJuego();
                puntaje += 10;
                this.finFechaHora = LocalDateTime.now();
                //jugador.registrarPuntaje(puntaje, this);
                actualizarInterfaz();
            } else {
                turnoRobot();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Swis721 Ex BT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 110, 110));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIENVENIDO \"NOMBRE USUARIO\"");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(71, 110, 110));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("JUEGOS DISPONIBLES");

        jButton1.setBackground(new java.awt.Color(71, 110, 110));
        jButton1.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("TIK TAK TOE");
        jButton1.setToolTipText("El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(71, 110, 110));
        jButton3.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("AHORCADO");
        jButton3.setToolTipText("El jugador debe intentar adivinar la palabra escondida sugiriendo letras con una cantidad de intentos limitados.");

        jButton4.setBackground(new java.awt.Color(71, 110, 110));
        jButton4.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setToolTipText("Este juego es sorpresa, creado por otros compañeros del curso.");
        jButton4.setLabel("JUEGO 3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TIK TAK TOE");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentResized(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Swis721 Ex BT", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 110, 110));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TIK TAK TOE");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 110, 110));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Suma Puntos Jugando al Tik Tak Toe");

        jButton6.setBackground(new java.awt.Color(255, 0, 0));
        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Salir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(71, 110, 110));

        jButton5.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(71, 110, 110));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton8.setForeground(new java.awt.Color(71, 110, 110));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton7.setForeground(new java.awt.Color(71, 110, 110));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton9.setForeground(new java.awt.Color(71, 110, 110));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton13.setForeground(new java.awt.Color(71, 110, 110));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(71, 110, 110));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton11.setForeground(new java.awt.Color(71, 110, 110));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton14.setForeground(new java.awt.Color(71, 110, 110));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Sitka Text", 0, 24)); // NOI18N
        jButton12.setForeground(new java.awt.Color(71, 110, 110));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(343, 343, 343))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Desea salir del programa?") == 0) {
            super.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jPanel2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentResized

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        accionJugada(jButton12);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        accionJugada(jButton14);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        accionJugada(jButton11);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        accionJugada(jButton10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        accionJugada(jButton13);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        accionJugada(jButton9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        accionJugada(jButton7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        accionJugada(jButton8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        accionJugada(jButton5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jButton6.getText().equals("Rendirse")) {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer rendirte? Perderás todos tus puntos!") == 0) {
                puntaje = 0;
                super.dispose();
            }
        } else if (jButton6.getText().equals("Salir")) {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de querer salir?") == 0) {
                
                /*
                try {
                    jugador.registrarPuntaje(puntaje, this);
                    ProyectoPOO.actualizarDatos(jugador.getNombre(), puntaje);
                } catch (IOException ex) {
                    Logger.getLogger(FrameJuego1.class.getName()).log(Level.SEVERE, null, ex);
                }
                */
                estadoFinalizacion=true;
                
                jugador.registrarPuntaje(this.puntaje,this);
                        
                                         
                //System.out.println("Puntaje: "+this.getPuntaje());
                //System.out.println("Segundos: "+this.getSegundosTotalesPartida());
                //System.out.println("Descripcion: "+this.getDescripcion());
                //System.out.println("Finalizacion: "+this.getFinalizacion());
                //System.out.println("Nombre: "+this.getNombre());
                //System.out.println("Inicio: "+this.getInicio());
                //System.out.println("Nombre Jugador: "+this.getJugador().getNombre());
                
                super.dispose();
                //new FrameJuegosDisponibles().iniciar(null);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    // Interfaces
    
    public void iniciarPartida(iJugador jugador){   
        this.jugador = jugador;
        this.setVisible(true);
    }
    
    public void terminarPartida() {     
        super.dispose();
    }

    public String getNombre() {
        return tituloJuego;
    }

    public String getDescripcion() {
        return descripcionJuego;
    }
    
    /*
    
    public LocalDateTime getInicio(){
        return inicioFechaHora;
    }

    public LocalDateTime getFinalizacion(){
        return finFechaHora;
    }

    public void setInicio(LocalDateTime fechaHora)
    {
        this.inicioFechaHora = fechaHora;
    }
    
    public void setFinalizacion(LocalDateTime fechaHora){
        this.finFechaHora = fechaHora;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public int getSegundosTotalesPartida(){
        return (int) ChronoUnit.SECONDS.between(inicioFechaHora, finFechaHora);
    }
    
    public boolean getEstadoFinalizado(){
        return estadoFinalizacion;
    }
    
    public iJugador getJugador(){
        return jugador;
    }
    */
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameJuego1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJuego1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJuego1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJuego1.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJuego1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
