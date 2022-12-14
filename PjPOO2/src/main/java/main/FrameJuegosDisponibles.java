/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import javax.swing.JOptionPane;
import juego1.FrameJuego1;
//import juego3.MultiMath;


import juego2.FrameJuego2;





import login.JLogin;

import interfaces.iJugador;
import interfaces.iCentroJuego;
import interfaces.iJuego;
import interfaces.iRegistro;
import juego1.Juego1;
import juego2.Juego2;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * JFrame del Centro de Juegos
 *
 * @author Deivid
 */
public class FrameJuegosDisponibles extends javax.swing.JFrame implements iCentroJuego {

    private ArrayList<iJuego> juegoDisponibles = new ArrayList<iJuego>();
    private ArrayList<iRegistro> historial = new ArrayList<iRegistro>();
    public static iJugador jugador;

    /**
     * Creates new form FrameJuegosDisponibles
     */
    public FrameJuegosDisponibles() {

        this.historial = Registro.obtenerRegistros();
        juegoDisponibles.add(Juego2.getInstancia());
        initComponents();
        //juegoDisponibles.add(new FrameJuego1());

    }

    /**
     * Indica los datos del nombre del jugador y el titulo de juegos disponibles
     *
     * * @param jugadorAct la instancia del jugador que se encuentra logueado
     */
    public void iniciar(iJugador jugadorAct) {
        this.jugador = jugadorAct;
        if (jugador.getNombre().equals("")) {
            jLabel1.setText("JUEGOS DISPONIBLES");
        } else {
            jLabel1.setText("BIENVENIDO " + jugador.getNombre().toUpperCase());
        }
        this.setVisible(true);
    }

    /**
     * Recupera el registro histórico de partidas para todos los usuarios y
     * sobre un mismo tipo de juego.
     *
     * @param tipoJuego tipo de juego
     * @return listado de registros de partidas realizadas.
     */
    public ArrayList<iRegistro> getRegistros(iJuego tipoJuego) {
        ArrayList<iRegistro> registros = new ArrayList<iRegistro>();

        for (iRegistro r : this.historial) {
            if (r.getJuego().getNombre().equals(tipoJuego.getNombre())) {
                registros.add(r);
            }
        }
        return registros;
    }

    /**
     * Listado de juegos disponibles en el centro de juegos
     *
     * @return listado de juegos
     */
    public ArrayList<iJuego> getJuegosDisponibles() {
        return this.juegoDisponibles;

    }

    /**
     * Agrega al arraylist de registros un nuevo registro.
     *
     * * @param registro el nuevo registro a agregar
     */
    public void agregarRegistro(iRegistro registro) {
        historial.add(registro);
        for (iRegistro reg : historial) {
            System.out.println(reg.getJugador().getNombre() + " " + reg.getPuntaje() + " " + reg.getEstadoFinalizado() + " " + reg.getInicio().format(DateTimeFormatter.ISO_DATE) + " " + reg.getSegundosTotalesPartida() + " Segundos");
        }
    }

    /**
     * Ordena el arraylist por puntaje
     *
     * @param registros Ordena un arraylist por puntaje
     */
    public void ordenadoXPuntaje(ArrayList<iRegistro> registros) {
        registros.sort((iRegistro x, iRegistro y) -> y.getPuntaje() - x.getPuntaje());

        for (int x = 0; x < 10; x++) {
            if (x < registros.size()) {
                iRegistro r = registros.get(x);
                txt_estadisticas.append(
                        "\n | Nombre Usuario: " + r.getJugador().getNombre()
                        + " | Puntaje: " + r.getPuntaje()
                        + " | Inicio: " + r.getInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        + " | Final: " + r.getFinalizacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n"
                );
            }
        }
    }

    /**
     * Ordena el arraylist por fecha
     *
     * @param listaRegistros Ordena un arraylist por fechas
     */
    public void ordenadoXFecha(ArrayList<iRegistro> listaRegistros) {
        int juegos = 0;
        int horasJugadas = 0;
        for (iRegistro registro : listaRegistros) {
            if (registro.getJugador().getNombre().equals(jugador.getNombre())) {
                juegos++;
                horasJugadas += registro.getSegundosTotalesPartida();
                txt_estadisticas.append(
                        "\nPuntaje: " + registro.getPuntaje()
                        + " | Inicio: " + registro.getInicio().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        + " | Final: " + registro.getFinalizacion().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                        + " | Tiempo: " + registro.getSegundosTotalesPartida() + " Segundos"
                        + " | Finalizada: " + registro.getEstadoFinalizado() + "\n"
                );

            }
        }
        lbl_partidasJugadas.setText("Partidas Jugadas: " + juegos);
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
        lbl_partidasJugadas = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_generales2 = new javax.swing.JButton();
        btn_personales2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_estadisticas = new javax.swing.JTextArea();
        btn_generales1 = new javax.swing.JButton();
        btn_personales1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_tiempoDiario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INICIO");
        setResizable(false);

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

        lbl_partidasJugadas.setBackground(new java.awt.Color(255, 255, 255));
        lbl_partidasJugadas.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        lbl_partidasJugadas.setForeground(new java.awt.Color(71, 110, 110));
        lbl_partidasJugadas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

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
        jButton3.setText("ADIVINAR PAIS");
        jButton3.setToolTipText("El jugador debe intentar adivinar la palabra escondida sugiriendo letras con una cantidad de intentos limitados.");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(71, 110, 110));
        jButton4.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setToolTipText("Este juego es sorpresa, creado por otros compañeros del curso.");
        jButton4.setLabel("JUEGO 3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_generales2.setBackground(new java.awt.Color(71, 110, 110));
        btn_generales2.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        btn_generales2.setForeground(new java.awt.Color(255, 255, 255));
        btn_generales2.setText("Generales");
        btn_generales2.setToolTipText("El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego");
        btn_generales2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generales2ActionPerformed(evt);
            }
        });

        btn_personales2.setBackground(new java.awt.Color(71, 110, 110));
        btn_personales2.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        btn_personales2.setForeground(new java.awt.Color(255, 255, 255));
        btn_personales2.setText("Personales");
        btn_personales2.setToolTipText("El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego");
        btn_personales2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_personales2ActionPerformed(evt);
            }
        });

        txt_estadisticas.setBackground(new java.awt.Color(255, 255, 255));
        txt_estadisticas.setColumns(20);
        txt_estadisticas.setFont(new java.awt.Font("JetBrains Mono", 0, 12)); // NOI18N
        txt_estadisticas.setForeground(new java.awt.Color(255, 255, 255));
        txt_estadisticas.setRows(5);
        txt_estadisticas.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txt_estadisticas.setEnabled(false);
        txt_estadisticas.setSelectedTextColor(new java.awt.Color(255, 255, 255));
        txt_estadisticas.setSelectionColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txt_estadisticas);

        btn_generales1.setBackground(new java.awt.Color(71, 110, 110));
        btn_generales1.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        btn_generales1.setForeground(new java.awt.Color(255, 255, 255));
        btn_generales1.setText("Generales");
        btn_generales1.setToolTipText("El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego");
        btn_generales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generales1ActionPerformed(evt);
            }
        });

        btn_personales1.setBackground(new java.awt.Color(71, 110, 110));
        btn_personales1.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        btn_personales1.setForeground(new java.awt.Color(255, 255, 255));
        btn_personales1.setText("Personales");
        btn_personales1.setToolTipText("El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego");
        btn_personales1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_personales1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(71, 110, 110));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Disfruta de los juegos disponibles");

        lbl_tiempoDiario.setBackground(new java.awt.Color(255, 255, 255));
        lbl_tiempoDiario.setFont(new java.awt.Font("Swis721 Ex BT", 0, 14)); // NOI18N
        lbl_tiempoDiario.setForeground(new java.awt.Color(71, 110, 110));
        lbl_tiempoDiario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(251, 251, 251))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_generales1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(btn_generales2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_personales2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_personales1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_partidasJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_tiempoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_personales1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_generales1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_generales2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_personales2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_partidasJugadas)
                    .addComponent(lbl_tiempoDiario))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(110, 110, 110)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(439, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Juego1.getInstancia().iniciarPartida(jugador, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Desea salir del programa?") == 0) {
            super.dispose();
            ProyectoPOO.guardarDatos();
            Registro.guardarRegistros(this.historial);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //super.dispose();
        Juego2.getInstancia().iniciarPartida(jugador, this);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_generales2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generales2ActionPerformed

        lbl_partidasJugadas.setText("");
        Color colorVerde = new Color(71, 110, 110);
        txt_estadisticas.setBackground(colorVerde);
        txt_estadisticas.setForeground(Color.WHITE);
        txt_estadisticas.setText("");
        ordenadoXPuntaje(getRegistros(Juego2.getInstancia()));
    }//GEN-LAST:event_btn_generales2ActionPerformed

    private void btn_personales2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_personales2ActionPerformed
        lbl_partidasJugadas.setText("");
        Color colorVerde = new Color(71, 110, 110);
        txt_estadisticas.setBackground(colorVerde);
        txt_estadisticas.setForeground(Color.WHITE);
        txt_estadisticas.setText("");
        ordenadoXFecha(getRegistros(Juego2.getInstancia()));
    }//GEN-LAST:event_btn_personales2ActionPerformed

    private void btn_generales1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generales1ActionPerformed
        lbl_partidasJugadas.setText("");
        Color colorVerde = new Color(71, 110, 110);
        txt_estadisticas.setBackground(colorVerde);
        txt_estadisticas.setForeground(Color.WHITE);
        txt_estadisticas.setText("");
        ordenadoXPuntaje(getRegistros(Juego1.getInstancia()));
    }//GEN-LAST:event_btn_generales1ActionPerformed

    private void btn_personales1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_personales1ActionPerformed
        lbl_partidasJugadas.setText("");
        Color colorVerde = new Color(71, 110, 110);
        txt_estadisticas.setBackground(colorVerde);
        txt_estadisticas.setForeground(Color.WHITE);
        txt_estadisticas.setText("");
        ordenadoXFecha(getRegistros(Juego1.getInstancia()));
    }//GEN-LAST:event_btn_personales1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //MultiMath juego = new MultiMath();
        //juego.iniciarPartida(jugador, this);
        
    
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrameJuegosDisponibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJuegosDisponibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJuegosDisponibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJuegosDisponibles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJuegosDisponibles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generales1;
    private javax.swing.JButton btn_generales2;
    private javax.swing.JButton btn_personales1;
    private javax.swing.JButton btn_personales2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_partidasJugadas;
    private javax.swing.JLabel lbl_tiempoDiario;
    private javax.swing.JTextArea txt_estadisticas;
    // End of variables declaration//GEN-END:variables
}
