/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.alee.laf.WebLookAndFeel;
import vistas.dashboardAdmin;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import proyectoING.CRUDAnteAcade;
import modelo.Antecedente;
import modelo.ModeloExcel;

public class antecedenteAcademico extends javax.swing.JFrame {


    
    public antecedenteAcademico() {
        initComponents();
        DatosTabla();
        this.inputID.setEnabled(false);
    }
    
    public void DatosTabla() {
        CRUDAnteAcade Caa = new CRUDAnteAcade();
        DefaultTableModel model = new DefaultTableModel();
        model = Caa.lista();
        Table1.setModel(model);
    }
    
    public void Agregar() {
        CRUDAnteAcade Caa = new CRUDAnteAcade();
                Caa.AgregarConsulta(inputProf.getText(), inputDip.getText(), inputMag.getText(), inputMBA.getText(),inputDoc.getText() ,inputArea.getSelectedItem().toString() ,inputExpLab.getText(), inputExpDoc.getText(), inputCursoPad.getText());
    }

    public void Eliminar() {
        CRUDAnteAcade Caa = new CRUDAnteAcade();
        Caa.EliminarConsulta(inputID.getText());
    }

    public void Modificar() {
        CRUDAnteAcade Caa = new CRUDAnteAcade();
        Caa.ModificarConsulta(inputProf.getText(), inputDip.getText(), inputMag.getText(), inputMBA.getText(), inputDoc.getText(), inputArea.getSelectedItem().toString() ,inputExpLab.getText(), inputExpDoc.getText(), inputCursoPad.getText(), inputID.getText());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        inputProf = new javax.swing.JTextField();
        inputDip = new javax.swing.JTextField();
        inputMag = new javax.swing.JTextField();
        inputMBA = new javax.swing.JTextField();
        inputDoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        inputID = new javax.swing.JTextField();
        inputIDdoc = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        inputExpLab = new javax.swing.JTextField();
        inputExpDoc = new javax.swing.JTextField();
        inputCursoPad = new javax.swing.JTextField();
        inputArea = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1170, 685));
        setPreferredSize(new java.awt.Dimension(1170, 685));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel2.setText("ANTECEDENTES ACADÉMICOS DEL DOCENTE");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 10, 530, 40);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Profesión:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 120, 90, 17);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Diplomado:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 150, 80, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Magister:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 190, 100, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("MBA:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 230, 80, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Doctorado:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 270, 90, 20);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Área:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(70, 310, 80, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("ID:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(90, 80, 20, 17);

        inputProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputProfActionPerformed(evt);
            }
        });
        getContentPane().add(inputProf);
        inputProf.setBounds(120, 110, 370, 30);

        inputDip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDipActionPerformed(evt);
            }
        });
        getContentPane().add(inputDip);
        inputDip.setBounds(120, 150, 370, 30);

        inputMag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMagActionPerformed(evt);
            }
        });
        getContentPane().add(inputMag);
        inputMag.setBounds(120, 190, 370, 30);

        inputMBA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMBAActionPerformed(evt);
            }
        });
        getContentPane().add(inputMBA);
        inputMBA.setBounds(120, 230, 370, 30);

        inputDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputDocActionPerformed(evt);
            }
        });
        getContentPane().add(inputDoc);
        inputDoc.setBounds(120, 270, 370, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Experiencia Laboral:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(520, 70, 150, 17);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Experiencia Docente:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(520, 170, 150, 17);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Cursos & Certificaciones:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(520, 270, 180, 20);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(207, 15, 15));
        jLabel14.setText("Opciones Habilitadas");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(170, 360, 190, 20);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/voliendo.png"))); // NOI18N
        jButton1.setText("Volver al menú");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(970, 10, 170, 40);

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/goma.png"))); // NOI18N
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(360, 470, 140, 40);

        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-editar-propiedad-40.png"))); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(40, 470, 140, 40);

        jButton5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-eliminar-archivo-40.png"))); // NOI18N
        jButton5.setText("Eliminar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(200, 470, 140, 40);

        jButton6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/agregarantedec flex.png"))); // NOI18N
        jButton6.setText("Crear Antecedente");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(30, 410, 470, 40);

        jButton7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-actualizar-40.png"))); // NOI18N
        jButton7.setText("Cargar Datos");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(40, 530, 460, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 350, 500, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(10, 650, 500, 20);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(510, 350, 20, 300);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(10, 350, 10, 300);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(10, 70, 500, 20);

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator6);
        jSeparator6.setBounds(510, 70, 20, 280);

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator7);
        jSeparator7.setBounds(10, 70, 10, 280);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/registro.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(730, 10, 40, 40);

        inputID.setEnabled(false);
        inputID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputIDActionPerformed(evt);
            }
        });
        getContentPane().add(inputID);
        inputID.setBounds(120, 80, 370, 20);
        getContentPane().add(inputIDdoc);
        inputIDdoc.setBounds(460, 330, 0, 0);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(Table1);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(520, 380, 640, 250);
        getContentPane().add(inputExpLab);
        inputExpLab.setBounds(520, 90, 640, 70);
        getContentPane().add(inputExpDoc);
        inputExpDoc.setBounds(520, 200, 640, 70);
        getContentPane().add(inputCursoPad);
        inputCursoPad.setBounds(520, 300, 640, 70);

        inputArea.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        inputArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Área", "INFORMÁTICA Y TELECOMUNICACIONES", "ADMINISTRACIÓN Y NEGOCIOS", "AGROPECUARIA Y AGROINDUSTRIAL", "DISEÑO Y COMUNICACIÓN", "CONSTRUCCIÓN ELECTRICIDAD Y ELECTRÓNICA HOTELERÍA", "TURISMO Y GASTRONOMÍA", "HUMANIDADES Y EDUCACIÓN", "MECÁNICA", "MINERÍA Y METALURGIA", "PROCESOS INDUSTRIALES", "SALUD" }));
        getContentPane().add(inputArea);
        inputArea.setBounds(120, 310, 370, 21);

        jButton3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-ms-excel-48.png"))); // NOI18N
        jButton3.setText("Exportar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 590, 140, 50);

        jButton8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-maquina-de-copiar-40.png"))); // NOI18N
        jButton8.setText("Imprimir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(360, 590, 140, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/Wallpaper3.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1200, 710);

        setSize(new java.awt.Dimension(1186, 724));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Agregar();
        DatosTabla();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void inputProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputProfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputProfActionPerformed

    private void inputDipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDipActionPerformed

    private void inputMagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMagActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMagActionPerformed

    private void inputMBAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMBAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMBAActionPerformed

    private void inputDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputDocActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dashboardAdmin frm = new dashboardAdmin();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Modificar();
        DatosTabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Eliminar();
        DatosTabla();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DatosTabla();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.inputID.setText("");
        this.inputProf.setText("");
        this.inputDip.setText("");
        this.inputMag.setText("");
        this.inputMBA.setText("");
        this.inputDoc.setText("");
        this.inputArea.setSelectedIndex(0);
        this.inputExpLab.setText("");
        this.inputExpDoc.setText("");
        this.inputCursoPad.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        DefaultTableModel model = (DefaultTableModel) this.Table1.getModel();
            int i = Table1.getSelectedRow();
            //condicion si no se selecciono ninguno
            if (i == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione");
            } else {
              //mostramso los datos en los jtxt
              //convertimos en string el resultado
            inputID.setText(String.valueOf(Table1.getValueAt(i, 0)));
            inputProf.setText(String.valueOf(Table1.getValueAt(i, 1)));
            inputDip.setText(String.valueOf(Table1.getValueAt(i, 2)));
            inputMag.setText(String.valueOf(Table1.getValueAt(i, 3)));
            inputMBA.setText(String.valueOf(Table1.getValueAt(i, 4)));
            inputDoc.setText(String.valueOf(Table1.getValueAt(i,5)));
            inputArea.setSelectedItem(String.valueOf(Table1.getValueAt(i, 6)));
            inputExpLab.setText(String.valueOf(Table1.getValueAt(i, 7)));
            inputExpDoc.setText(String.valueOf(Table1.getValueAt(i, 8)));
            inputCursoPad.setText(String.valueOf(Table1.getValueAt(i, 9)));
        }
    }//GEN-LAST:event_Table1MouseClicked

    private void inputIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputIDActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
          // TODO add your handling code here:
       
        MessageFormat format = new MessageFormat("Antecedentes de Académicos: Page - {0}");
        MessageFormat format2 = new MessageFormat("CHSCRUM");
        try {
            Table1.print(JTable.PrintMode.FIT_WIDTH, format, format2);
        } catch (PrinterException ex) {
            Logger.getLogger(RegistroDocente.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                   JFileChooser fc = new JFileChooser();
                int option = fc.showSaveDialog(Table1);
                if(option == JFileChooser.APPROVE_OPTION){
                    String filename = fc.getSelectedFile().getName(); 
                    String path = fc.getSelectedFile().getParentFile().getPath();

					int len = filename.length();
					String ext = "";
					String file = "";

					if(len > 10){
						ext = filename.substring(len-4, len);
					}

					if(ext.equals(".xls")){
						file = path + "\\" + filename; 
					}else{
						file = path + "\\" + filename + ".xls"; 
					}
					//toExcel
                                        ModeloExcel me = new ModeloExcel();
                                        me.Exportar(new File(file),Table1);
                }        
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(antecedenteAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(antecedenteAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(antecedenteAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(antecedenteAcademico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new antecedenteAcademico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1;
    private javax.swing.JComboBox<String> inputArea;
    private javax.swing.JTextField inputCursoPad;
    private javax.swing.JTextField inputDip;
    private javax.swing.JTextField inputDoc;
    private javax.swing.JTextField inputExpDoc;
    private javax.swing.JTextField inputExpLab;
    private javax.swing.JTextField inputID;
    private javax.swing.JLabel inputIDdoc;
    private javax.swing.JTextField inputMBA;
    private javax.swing.JTextField inputMag;
    private javax.swing.JTextField inputProf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    // End of variables declaration//GEN-END:variables
}
