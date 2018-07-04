/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.alee.laf.WebLookAndFeel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelo.Conexion;

/**
 *
 * @author Lenovo-W530
 */
public class dashboardAdmin extends javax.swing.JFrame {
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
 
    
    public dashboardAdmin() {
        initComponents();
        
        lblDB.setVisible(false);
    }

    public String AbrirArchivo(File archivo){
        String documento="";
        try{
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read())!=-1){
                char character=(char)ascci;
                documento+=character;
            }
        }catch(Exception ex){
            
        }
        return documento;
    }
    
    public String GuardarArchivos(File archivom ,String documento){
        String mensaje = null;
        try{
            salida = new FileOutputStream(archivo);
            byte[] bytex= documento.getBytes();
            mensaje = "Archivo Guardado";
            
        }catch(Exception e){
            
        }
        return mensaje;
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnRegDocente = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        lblDB = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(997, 598));
        setPreferredSize(new java.awt.Dimension(997, 598));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 600));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/inacap.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 20, 110, 70);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setText("MENÚ PRINCIPAL: BIENVENID@");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(300, 30, 370, 30);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel5.setText("SOFTWARE INSTITUCIONAL");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 20, 180, 19);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel4.setText("Cargar archivo BD:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(790, 20, 140, 19);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(207, 15, 15));
        jLabel6.setText("GESTIONAMIENTO DE DOCENTES:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 170, 280, 20);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 120, 1000, 10);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(240, 0, 10, 120);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(720, 0, 10, 120);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(20, 380, 950, 10);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(20, 150, 950, 2);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(20, 150, 10, 230);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(970, 150, 10, 230);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/databaseeee.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(800, 50, 100, 60);

        btnRegDocente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnRegDocente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/agregarflex.png"))); // NOI18N
        btnRegDocente.setText("Registrar Docente");
        btnRegDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegDocenteActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegDocente);
        btnRegDocente.setBounds(80, 220, 180, 50);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/encontrarflex.png"))); // NOI18N
        jButton3.setText("Buscar Docente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(360, 220, 180, 50);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/agregarantedec flex.png"))); // NOI18N
        jButton4.setText("Registrar Antecedentes Académicos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(600, 220, 310, 50);

        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/antedecflex.png"))); // NOI18N
        jButton5.setText("Registro de Justificación de Inasistencia");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(290, 310, 310, 50);
        getContentPane().add(lblDB);
        lblDB.setBounds(910, 70, 30, 20);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(207, 15, 15));
        jLabel8.setText("DESARROLLADORES DE SOFTWARE:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(330, 430, 290, 23);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-logotipo-de-java-coffee-cup-48.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(440, 470, 90, 70);
        getContentPane().add(jSeparator12);
        jSeparator12.setBounds(30, 420, 940, 10);
        getContentPane().add(jSeparator13);
        jSeparator13.setBounds(30, 550, 940, 10);

        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator14);
        jSeparator14.setBounds(970, 420, 20, 130);

        jSeparator15.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator15);
        jSeparator15.setBounds(30, 420, 10, 130);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/voliendo.png"))); // NOI18N
        jButton2.setText("Volver al Lobby");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 70, 180, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-660, 0, 1680, 740);

        setSize(new java.awt.Dimension(1013, 637));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
               if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
            archivo= seleccionar.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("db")){

                    String documento = archivo.getPath();

                    documento = documento.replaceAll("\\\\","//");
                        
                            Conexion.ruta =documento;
                            this.lblDB.setText(documento);
                            JOptionPane.showMessageDialog(null, "Base de datos local carga correctamente", "", 1);
                            dashboardAdmin frm = new dashboardAdmin();
                            frm.setLocationRelativeTo(null);
                            frm.setVisible(true);
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "Archivo no compatible");
                        }
                    }
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
              this.setVisible(false);
justificacionInasistencia dash = new justificacionInasistencia();
   dash.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        antecedenteAcademico frm = new antecedenteAcademico();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnRegDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegDocenteActionPerformed
        RegistroDocente frm = new RegistroDocente();

        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegDocenteActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        buscarDocente frm = new buscarDocente();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();  
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Programadores frm = new Programadores();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lobby frm = new Lobby();

        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
                    UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegDocente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblDB;
    // End of variables declaration//GEN-END:variables
}
