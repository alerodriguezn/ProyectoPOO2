/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectopoo.juego2;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author navar
 */
public class FrameJuego2 extends javax.swing.JFrame {

    private Juego2 juego2;
    private int vidas;
    private int puntaje;
    private int numeroLetras;
    private String paisNombre;
    private String pista;

    /**
     * Creates new form FrameJuego2
     */
    public FrameJuego2() {
        this.juego2 = Juego2.getInstancia();
        juego2.getPaises();
        juego2.setPais();
        this.paisNombre = this.juego2.getPais();
        this.pista = this.juego2.getPista();
        this.puntaje = 0;
        this.vidas = 7;
        initComponents();
        iniciarJuego();
        // hola mundo
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jFileChooser1 = new javax.swing.JFileChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane2 = new javax.swing.JEditorPane();
        lbl_vidas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_respuesta = new javax.swing.JTextField();
        lbl_pistas = new javax.swing.JLabel();
        btn_comprobar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_paisAdivinar = new javax.swing.JTextField();
        lbl_puntos = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("jRadioButtonMenuItem2");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jFormattedTextField1.setText("jFormattedTextField1");

        jScrollPane1.setViewportView(jEditorPane1);

        jScrollPane2.setViewportView(jEditorPane2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_vidas.setFont(new java.awt.Font("Swis721 Ex BT", 1, 24)); // NOI18N
        lbl_vidas.setForeground(new java.awt.Color(255, 0, 51));
        lbl_vidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_vidas.setText("7");

        jLabel4.setFont(new java.awt.Font("Swis721 Ex BT", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(71, 110, 110));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Adivina el pais 🏳️ ");

        jLabel5.setFont(new java.awt.Font("Swis721 Ex BT", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("❤ Vidas :️");

        lbl_pistas.setFont(new java.awt.Font("Swis721 Ex BT", 1, 14)); // NOI18N
        lbl_pistas.setForeground(new java.awt.Color(71, 110, 110));
        lbl_pistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_pistas.setText("Aqui van las pistas");

        btn_comprobar.setBackground(new java.awt.Color(71, 110, 110));
        btn_comprobar.setFont(new java.awt.Font("Swis721 Ex BT", 1, 12)); // NOI18N
        btn_comprobar.setForeground(new java.awt.Color(255, 255, 255));
        btn_comprobar.setText("Comprobar");
        btn_comprobar.setToolTipText("El jugador que logre colocar tres marcas respectivas en una fila horizontal, vertical o diagonal gana el juego");
        btn_comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_comprobarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Swis721 Ex BT", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(71, 110, 110));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Escriba su respuesta:");

        txt_paisAdivinar.setFont(new java.awt.Font("JetBrains Mono", 0, 24)); // NOI18N
        txt_paisAdivinar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_paisAdivinar.setEnabled(false);
        txt_paisAdivinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_paisAdivinarActionPerformed(evt);
            }
        });

        lbl_puntos.setFont(new java.awt.Font("Swis721 Ex BT", 1, 18)); // NOI18N
        lbl_puntos.setForeground(new java.awt.Color(71, 110, 110));
        lbl_puntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_puntos.setText("Puntos:");

        jLabel9.setFont(new java.awt.Font("Swis721 Ex BT", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(71, 110, 110));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Pistas 🔍:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_puntos)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_respuesta)
                            .addComponent(btn_comprobar, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_vidas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_pistas, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txt_paisAdivinar, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_puntos)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lbl_pistas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_vidas, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_paisAdivinar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_respuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_comprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_paisAdivinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_paisAdivinarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_paisAdivinarActionPerformed

    private void obtenerNumerodeLetras() {
        this.numeroLetras = this.paisNombre.length();
        String str = "";
        for (int x = 0; x < this.numeroLetras; x++) {
            if(this.paisNombre.charAt(x) != ' '){
                str = str.concat("X ");
            }
            else{
                str = str.concat("  ");
            }
        }
        txt_paisAdivinar.setText(str);
    }

    public void iniciarJuego() {
        obtenerNumerodeLetras();
        lbl_puntos.setText("Puntos: " + this.puntaje);
        lbl_pistas.setText(this.pista);
      
    }

    private void btn_comprobarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn_comprobarActionPerformed

        if (txt_respuesta.getText().toLowerCase().equals(this.paisNombre.toLowerCase())) {
            this.juego2.setPuntaje(10);
            this.puntaje += 10;
            lbl_puntos.setText("Puntos: "+this.puntaje);
            JOptionPane.showMessageDialog(null, "Victoria! Puntos Obtenidos: 10");
            txt_respuesta.setText("");
            this.juego2.getPaises();
            this.juego2.setPais();
            this.paisNombre = this.juego2.getPais();
            this.pista = this.juego2.getPista();
            lbl_pistas.setText(this.pista);
            obtenerNumerodeLetras();                    
            
        } else if (this.vidas == 1) {
            JOptionPane.showMessageDialog(null, "La Partida Ha Finalizado, No tienes mas Vidas");
            this.juego2.terminarPartida();
            this.dispose();
        } else {
            this.vidas -= 1;
            lbl_vidas.setText(String.valueOf(this.vidas));
            txt_respuesta.setText("");
            JOptionPane.showMessageDialog(null, "Has Fallado, Intenta de nuevo");

        }

    }// GEN-LAST:event_btn_comprobarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameJuego2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameJuego2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameJuego2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameJuego2.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        
        /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameJuego2().setVisible(true);

            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_comprobar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JEditorPane jEditorPane2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_pistas;
    private javax.swing.JLabel lbl_puntos;
    private javax.swing.JLabel lbl_vidas;
    private javax.swing.JTextField txt_paisAdivinar;
    private javax.swing.JTextField txt_respuesta;
    // End of variables declaration//GEN-END:variables
}
