/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.alee.laf.WebLookAndFeel;
import informeRetencion.DAOArea;
import informeRetencion.DAOCarrera;
import informeRetencion.DAORetencionArea;
import informeRetencion.DAORetencionAreaB;
import informeRetencion.DAORetencionCarrera;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.print.PrinterException;
import java.io.File;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelo.Carrera;
import modelo.ModeloExcel;
import modelo.RetencionArea;
import modelo.RetencionCarrera;

/**
 *
 * @author Kevin
 */
public class dashboardRetencion extends javax.swing.JFrame {

    CustomDialog customDialog;

    public dashboardRetencion() {
        customDialog = new CustomDialog(this, "geisel", "Ingrese Datos De Carrera", this);
        customDialog.pack();
        initComponents();
        //DatosTablaArea();
        CargarDatosTablaArea();
        DatosTablaCarrera();
        DatosListArea();
        DatosListCarrera();
        DatosSpinerAños();
        DatosSpinerPorcentajes();

    }

    public void LimpiarCampos() {
        idretencionarea.setText("");
        listArea.setSelectedIndex(0);
        spinerAñosArea.setValue(2000);
        spinerPorcentajeArea.setValue(50);
        spinerPorcentajeCarrera.setValue(50);
        spinerAñosCarrera.setValue(2000);
        listCarrera.setSelectedItem(0);
        idretencioncarrera.setText("");
    }

    public final void CargarDatosTablaArea() {
        DAORetencionAreaB daoretencionarea = new DAORetencionAreaB();
        LinkedList<RetencionArea> listaRetencionArea = new LinkedList<>();
        listaRetencionArea = daoretencionarea.consultar();
        DefaultTableModel modelo = new DefaultTableModel();
        // Aqui cargamos la tabla manual en diferencia al ejemplo anterior que enviaba
        //una tabla completa ya cargada, la ventaja de este que es mas claro y mas 
        //personalizable
        modelo.addColumn("ID");
        modelo.addColumn("AREA INACAP");
        modelo.addColumn("PORCENTAJE");
        modelo.addColumn("AÑO");
        for (RetencionArea aux : listaRetencionArea) {
            Object fila[] = new Object[4];
            fila[0] = aux.getIdRetencionArea();
            fila[1] = aux.getNombre();
            fila[2] = aux.getPorcentaje();
            fila[3] = aux.getAño();

            modelo.addRow(fila);
        }
        tablaRetencionArea.setModel(modelo);
    }

    public final void DatosTablaArea() {
        DAORetencionArea daoaretencionarea = new DAORetencionArea();
        DefaultTableModel DatosTablaArea = new DefaultTableModel();
        DatosTablaArea = daoaretencionarea.listaRetencionTabla();
        tablaRetencionArea.setModel(DatosTablaArea);
    }

    public final void DatosTablaCarrera() {
        DAORetencionCarrera daocCarrera = new DAORetencionCarrera();
        LinkedList<RetencionCarrera> listaCarrera = new LinkedList<>();
        listaCarrera = daocCarrera.consultar();
        DefaultTableModel modelo = new DefaultTableModel();
        // Aqui cargamos la tabla manual en diferencia al ejemplo anterior que enviaba
        //una tabla completa ya cargada, la ventaja de este que es mas claro y mas 
        //personalizable
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Codigo");
        modelo.addColumn("IdArea");

        for (RetencionCarrera aux : listaCarrera) {
            Object fila[] = new Object[4];
            fila[0] = aux.getIdRetencionCarrera();
            fila[1] = aux.getNombre();
            fila[2] = aux.getPorcentaje();
            fila[3] = aux.getAño();
            modelo.addRow(fila);
        }
        tablaRetencionCarrera.setModel(modelo);
    }

    public final void DatosSpinerPorcentajes() {
        Float value = new Float(50.20);
        Float step = new Float(0.1);
        Float Min = new Float(0.1);
        Float Max = new Float(100.0);
        SpinnerNumberModel model = new SpinnerNumberModel(value, Min, Max, step);

        spinerPorcentajeArea.setModel(model);
        spinerPorcentajeCarrera.setModel(model);
        spinerPorcentajeSede.setModel(model);

    }

    public final void DatosSpinerAños() {
        Instant instant = Instant.now();
        ZoneId z = ZoneId.of("America/Santiago");
        ZonedDateTime zdt = instant.atZone(z);
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(z).toLocalDate();
        int year = localDate.getYear();
        /*
    int month = localDate.getMonthValue();
    int day   = localDate.getDayOfMonth();
         */
        SpinnerModel model;                //step
        model = new SpinnerNumberModel(year, //initial value
                year - 100, //min
                year + 100, //max
                1);

        spinerAñosArea.setModel(model);
        spinerAñosCarrera.setModel(model);
        spinerAñosSede.setModel(model);
    }

    public final void DatosListCarrera() {
        DAOCarrera daocarrera = new DAOCarrera();
        LinkedList<Carrera> listaCarrera = new LinkedList<>();
        listaCarrera = daocarrera.consultar();
        List<String> ls = new ArrayList<>();
        for (Carrera listaCarrera1 : listaCarrera) {
            ls.add(listaCarrera1.getNombre());
        }
        ls.add(0, "");
        listCarrera.setModel(new DefaultComboBoxModel(ls.toArray()));

    }

    public final void DatosListArea() {
        DAOArea daoarea = new DAOArea();
        DefaultTableModel DatosTablaArea = new DefaultTableModel();
        DatosTablaArea = daoarea.listaAreaTabla();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < DatosTablaArea.getRowCount(); i++) {

            ls.add((String) DatosTablaArea.getValueAt(i, 1));
        }
        ls.add(0, "");
        try {
            listArea.setModel(new DefaultComboBoxModel(ls.toArray()));
        } catch (Exception e) {
        }

    }

    public static String guardarArchivo(Frame frame) {
        String archivo = "";
        JFileChooser fc = new JFileChooser();
        int option = fc.showSaveDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION) {
            String filename = fc.getSelectedFile().getName();
            String path = fc.getSelectedFile().getParentFile().getPath();

            int len = filename.length();
            String ext = "";
            String file = "";

            if (len > 4) {
                ext = filename.substring(len - 4, len);
            }

            if (ext.equals(".xls")) {
                file = path + "\\" + filename;
            } else {
                file = path + "\\" + filename + ".xls";
            }
            archivo = file;
        }
        return archivo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuTabsDashboard = new javax.swing.JTabbedPane();
        Inicio = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        contenidoRetencionArea = new javax.swing.JPanel();
        divisionRArea = new javax.swing.JSplitPane();
        contenidoAreaInputs = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        listArea = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btnIngresarDatosReporteArea = new javax.swing.JButton();
        spinerAñosArea = new javax.swing.JSpinner();
        spinerPorcentajeArea = new javax.swing.JSpinner();
        idretencionarea = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnModificarRetencionArea = new javax.swing.JButton();
        ingresarAreaRapida = new javax.swing.JButton();
        contenidoAreaTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRetencionArea = new javax.swing.JTable();
        btnEliminarRetencionArea = new javax.swing.JButton();
        imprimirArea = new javax.swing.JButton();
        exportarArea = new javax.swing.JButton();
        contenidoRetencionSede = new javax.swing.JPanel();
        divisionRSede = new javax.swing.JSplitPane();
        contenidoSedeInputs = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        listSede = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        btnIngresarDatosReporteSede = new javax.swing.JButton();
        spinerAñosSede = new javax.swing.JSpinner();
        spinerPorcentajeSede = new javax.swing.JSpinner();
        idretencionsede = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnModificarRetencionSede = new javax.swing.JButton();
        contenidoSedeTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaRetencionSede = new javax.swing.JTable();
        btnEliminarRetencionSede = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        exportarArea2 = new javax.swing.JButton();
        contenidoRetencionCarrera = new javax.swing.JPanel();
        divisionRSede1 = new javax.swing.JSplitPane();
        contenidoSedeInputs1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        listCarrera = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btnIngresarDatosReporteCarrera = new javax.swing.JButton();
        spinerAñosCarrera = new javax.swing.JSpinner();
        spinerPorcentajeCarrera = new javax.swing.JSpinner();
        idretencioncarrera = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnModificarRetencionCarrera = new javax.swing.JButton();
        ingresarCarreraRapida = new javax.swing.JButton();
        contenidoSedeTabla1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRetencionCarrera = new javax.swing.JTable();
        btnEliminarRetencionCarrera = new javax.swing.JButton();
        imprimirCarrera = new javax.swing.JButton();
        exportarCarrera = new javax.swing.JButton();
        contenidoRetencionZona = new javax.swing.JPanel();
        contenidoRetencionAnual = new javax.swing.JPanel();
        contenidoRetencionJornada = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Informe de retencion");
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        menuTabsDashboard.setBackground(new java.awt.Color(255, 255, 255));
        menuTabsDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuTabsDashboard.setMinimumSize(new java.awt.Dimension(800, 600));
        menuTabsDashboard.setPreferredSize(new java.awt.Dimension(1280, 720));

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/voliendo.png"))); // NOI18N
        jButton2.setText("Volver al Lobby");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel19.setText("MENÚ PRINCIPAL: BIENVENID@");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/inacap.png"))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        jLabel21.setText("SOFTWARE INSTITUCIONAL");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/InterfazIconos/icons8-logotipo-de-java-coffee-cup-48.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(207, 15, 15));
        jLabel22.setText("DESARROLLADORES DE SOFTWARE:");

        javax.swing.GroupLayout InicioLayout = new javax.swing.GroupLayout(Inicio);
        Inicio.setLayout(InicioLayout);
        InicioLayout.setHorizontalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(InicioLayout.createSequentialGroup()
                .addContainerGap(486, Short.MAX_VALUE)
                .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(InicioLayout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(InicioLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(421, Short.MAX_VALUE))))
            .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InicioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(InicioLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        InicioLayout.setVerticalGroup(
            InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(402, 402, 402)
                .addComponent(jLabel22)
                .addGap(17, 17, 17)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(InicioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(InicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        menuTabsDashboard.addTab("Inicio", Inicio);

        contenidoRetencionArea.setBackground(new java.awt.Color(255, 255, 255));

        divisionRArea.setBorder(null);
        divisionRArea.setDividerLocation(350);
        divisionRArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        divisionRArea.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        contenidoAreaInputs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenidoAreaInputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setText("Porcentaje");

        jLabel2.setText("Area");

        jLabel3.setText("Año");

        listArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listArea.setMaximumSize(new java.awt.Dimension(200, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ingreso de Datos Area");

        btnIngresarDatosReporteArea.setText("Ingresar Datos");
        btnIngresarDatosReporteArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresarDatosReporteArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarDatosReporteAreaActionPerformed(evt);
            }
        });

        idretencionarea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idretencionarea.setText("Valor");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("ID");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Modificación de elemento:");

        btnModificarRetencionArea.setText("Modificar");
        btnModificarRetencionArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificarRetencionArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRetencionAreaActionPerformed(evt);
            }
        });

        ingresarAreaRapida.setText("...");
        ingresarAreaRapida.setMaximumSize(new java.awt.Dimension(41, 21));
        ingresarAreaRapida.setMinimumSize(new java.awt.Dimension(41, 21));

        javax.swing.GroupLayout contenidoAreaInputsLayout = new javax.swing.GroupLayout(contenidoAreaInputs);
        contenidoAreaInputs.setLayout(contenidoAreaInputsLayout);
        contenidoAreaInputsLayout.setHorizontalGroup(
            contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(172, Short.MAX_VALUE))
                    .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                        .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listArea, 0, 177, Short.MAX_VALUE)
                                    .addComponent(spinerPorcentajeArea)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenidoAreaInputsLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(51, 51, 51)
                                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIngresarDatosReporteArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                    .addComponent(spinerAñosArea, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingresarAreaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
            .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idretencionarea)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnModificarRetencionArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(68, 68, 68))
        );
        contenidoAreaInputsLayout.setVerticalGroup(
            contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoAreaInputsLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel5)
                .addGap(48, 48, 48)
                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(listArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresarAreaRapida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinerPorcentajeArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinerAñosArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnIngresarDatosReporteArea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoAreaInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(idretencionarea)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnModificarRetencionArea)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        divisionRArea.setLeftComponent(contenidoAreaInputs);

        tablaRetencionArea.setAutoCreateRowSorter(true);
        tablaRetencionArea.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaRetencionArea.setFillsViewportHeight(true);
        tablaRetencionArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaRetencionArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRetencionAreaMouseClicked(evt);
            }
        });
        tablaRetencionArea.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tablaRetencionAreaComponentMoved(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRetencionArea);

        btnEliminarRetencionArea.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarRetencionArea.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarRetencionArea.setForeground(new java.awt.Color(255, 0, 51));
        btnEliminarRetencionArea.setText("Eliminar");
        btnEliminarRetencionArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarRetencionArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRetencionAreaActionPerformed(evt);
            }
        });

        imprimirArea.setText("Imprimir");
        imprimirArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirAreaActionPerformed(evt);
            }
        });

        exportarArea.setText("Exportar Excel");
        exportarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoAreaTablaLayout = new javax.swing.GroupLayout(contenidoAreaTabla);
        contenidoAreaTabla.setLayout(contenidoAreaTablaLayout);
        contenidoAreaTablaLayout.setHorizontalGroup(
            contenidoAreaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoAreaTablaLayout.createSequentialGroup()
                .addGroup(contenidoAreaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoAreaTablaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarRetencionArea, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenidoAreaTablaLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(contenidoAreaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoAreaTablaLayout.createSequentialGroup()
                                .addComponent(imprimirArea)
                                .addGap(18, 18, 18)
                                .addComponent(exportarArea)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))))
                .addContainerGap())
        );
        contenidoAreaTablaLayout.setVerticalGroup(
            contenidoAreaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoAreaTablaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(contenidoAreaTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imprimirArea)
                    .addComponent(exportarArea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarRetencionArea)
                .addContainerGap())
        );

        divisionRArea.setRightComponent(contenidoAreaTabla);

        javax.swing.GroupLayout contenidoRetencionAreaLayout = new javax.swing.GroupLayout(contenidoRetencionArea);
        contenidoRetencionArea.setLayout(contenidoRetencionAreaLayout);
        contenidoRetencionAreaLayout.setHorizontalGroup(
            contenidoRetencionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoRetencionAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisionRArea)
                .addContainerGap())
        );
        contenidoRetencionAreaLayout.setVerticalGroup(
            contenidoRetencionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoRetencionAreaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisionRArea)
                .addContainerGap())
        );

        menuTabsDashboard.addTab("Retencion por Area", contenidoRetencionArea);

        contenidoRetencionSede.setBackground(new java.awt.Color(255, 255, 255));

        divisionRSede.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        divisionRSede.setDividerLocation(350);
        divisionRSede.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        contenidoSedeInputs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenidoSedeInputs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setText("Porcentaje");

        jLabel8.setText("Sede");

        jLabel9.setText("Año");

        listSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listSede.setMaximumSize(new java.awt.Dimension(200, 20));
        listSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listSedeActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Ingreso de Datos Sede");

        btnIngresarDatosReporteSede.setText("Ingresar Datos");
        btnIngresarDatosReporteSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarDatosReporteSedeActionPerformed(evt);
            }
        });

        idretencionsede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idretencionsede.setText("Valor");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Modificación de elemento:");

        btnModificarRetencionSede.setText("Modificar");
        btnModificarRetencionSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRetencionSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoSedeInputsLayout = new javax.swing.GroupLayout(contenidoSedeInputs);
        contenidoSedeInputs.setLayout(contenidoSedeInputsLayout);
        contenidoSedeInputsLayout.setHorizontalGroup(
            contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                        .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listSede, 0, 166, Short.MAX_VALUE)
                                    .addComponent(spinerPorcentajeSede)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenidoSedeInputsLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(51, 51, 51)
                                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnIngresarDatosReporteSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinerAñosSede, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(71, 71, 71))))
            .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2)
                .addContainerGap())
            .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idretencionsede)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoSedeInputsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnModificarRetencionSede, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        contenidoSedeInputsLayout.setVerticalGroup(
            contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeInputsLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel10)
                .addGap(49, 49, 49)
                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(listSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spinerPorcentajeSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(spinerAñosSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnIngresarDatosReporteSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoSedeInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(idretencionsede)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(btnModificarRetencionSede)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        divisionRSede.setLeftComponent(contenidoSedeInputs);

        tablaRetencionSede.setAutoCreateRowSorter(true);
        tablaRetencionSede.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaRetencionSede.setFillsViewportHeight(true);
        tablaRetencionSede.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaRetencionSede.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRetencionSedeMouseClicked(evt);
            }
        });
        tablaRetencionSede.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tablaRetencionSedeComponentMoved(evt);
            }
        });
        jScrollPane2.setViewportView(tablaRetencionSede);

        btnEliminarRetencionSede.setBackground(new java.awt.Color(232, 52, 22));
        btnEliminarRetencionSede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarRetencionSede.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminarRetencionSede.setText("Eliminar");
        btnEliminarRetencionSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRetencionSedeActionPerformed(evt);
            }
        });

        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        exportarArea2.setText("Exportar Excel");
        exportarArea2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarArea2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoSedeTablaLayout = new javax.swing.GroupLayout(contenidoSedeTabla);
        contenidoSedeTabla.setLayout(contenidoSedeTablaLayout);
        contenidoSedeTablaLayout.setHorizontalGroup(
            contenidoSedeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeTablaLayout.createSequentialGroup()
                .addGroup(contenidoSedeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoSedeTablaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarRetencionSede, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenidoSedeTablaLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(contenidoSedeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoSedeTablaLayout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(exportarArea2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE))))
                .addContainerGap())
        );
        contenidoSedeTablaLayout.setVerticalGroup(
            contenidoSedeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeTablaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(contenidoSedeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(exportarArea2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarRetencionSede))
        );

        divisionRSede.setRightComponent(contenidoSedeTabla);

        javax.swing.GroupLayout contenidoRetencionSedeLayout = new javax.swing.GroupLayout(contenidoRetencionSede);
        contenidoRetencionSede.setLayout(contenidoRetencionSedeLayout);
        contenidoRetencionSedeLayout.setHorizontalGroup(
            contenidoRetencionSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoRetencionSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisionRSede)
                .addContainerGap())
        );
        contenidoRetencionSedeLayout.setVerticalGroup(
            contenidoRetencionSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoRetencionSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisionRSede)
                .addContainerGap())
        );

        menuTabsDashboard.addTab("Retencion por Sede", contenidoRetencionSede);

        contenidoRetencionCarrera.setBackground(new java.awt.Color(255, 255, 255));

        divisionRSede1.setBorder(null);
        divisionRSede1.setDividerLocation(350);
        divisionRSede1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        contenidoSedeInputs1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contenidoSedeInputs1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setLabelFor(spinerPorcentajeCarrera);
        jLabel13.setText("Porcentaje");
        jLabel13.setToolTipText("");

        jLabel14.setLabelFor(listCarrera);
        jLabel14.setText("Carrera");

        jLabel15.setText("Año");

        listCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        listCarrera.setToolTipText("Listado de programas de estudio");
        listCarrera.setMaximumSize(new java.awt.Dimension(200, 20));
        listCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listCarreraActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Ingreso de datos de retencion PE");
        jLabel16.setToolTipText("Programa de estudio");

        btnIngresarDatosReporteCarrera.setText("Ingresar Datos");
        btnIngresarDatosReporteCarrera.setToolTipText("Registro de datos de retencion en base de datos");
        btnIngresarDatosReporteCarrera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresarDatosReporteCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarDatosReporteCarreraActionPerformed(evt);
            }
        });

        spinerAñosCarrera.setToolTipText("Año actual, Min -100 años, Max +100 años");

        spinerPorcentajeCarrera.setToolTipText("Valor Min 0.1 Max 100, Paso cada 0.1");

        idretencioncarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idretencioncarrera.setText("Valor");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("ID");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Modificación de elemento:");

        btnModificarRetencionCarrera.setText("Modificar");
        btnModificarRetencionCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRetencionCarreraActionPerformed(evt);
            }
        });

        ingresarCarreraRapida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ingresarCarreraRapida.setText("...");
        ingresarCarreraRapida.setToolTipText("Administracion de Programas de Estudio");
        ingresarCarreraRapida.setFocusPainted(false);
        ingresarCarreraRapida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarCarreraRapidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoSedeInputs1Layout = new javax.swing.GroupLayout(contenidoSedeInputs1);
        contenidoSedeInputs1.setLayout(contenidoSedeInputs1Layout);
        contenidoSedeInputs1Layout.setHorizontalGroup(
            contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                                .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                                        .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(listCarrera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spinerPorcentajeCarrera)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, contenidoSedeInputs1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(51, 51, 51)
                                        .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnIngresarDatosReporteCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spinerAñosCarrera))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ingresarCarreraRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3))
                    .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idretencioncarrera)
                        .addGap(0, 80, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(btnModificarRetencionCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34))
        );
        contenidoSedeInputs1Layout.setVerticalGroup(
            contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeInputs1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel16)
                .addGap(48, 48, 48)
                .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(listCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ingresarCarreraRapida, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spinerPorcentajeCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(spinerAñosCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnIngresarDatosReporteCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoSedeInputs1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(idretencioncarrera)
                    .addComponent(jLabel17))
                .addGap(41, 41, 41)
                .addComponent(btnModificarRetencionCarrera)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        divisionRSede1.setLeftComponent(contenidoSedeInputs1);

        tablaRetencionCarrera.setAutoCreateRowSorter(true);
        tablaRetencionCarrera.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaRetencionCarrera.setFillsViewportHeight(true);
        tablaRetencionCarrera.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaRetencionCarrera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRetencionCarreraMouseClicked(evt);
            }
        });
        tablaRetencionCarrera.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                tablaRetencionCarreraComponentMoved(evt);
            }
        });
        jScrollPane3.setViewportView(tablaRetencionCarrera);

        btnEliminarRetencionCarrera.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminarRetencionCarrera.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminarRetencionCarrera.setForeground(new java.awt.Color(255, 0, 0));
        btnEliminarRetencionCarrera.setText("Eliminar");
        btnEliminarRetencionCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarRetencionCarreraActionPerformed(evt);
            }
        });

        imprimirCarrera.setText("Imprimir");
        imprimirCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirCarreraActionPerformed(evt);
            }
        });

        exportarCarrera.setText("Exportar Excel");
        exportarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportarCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoSedeTabla1Layout = new javax.swing.GroupLayout(contenidoSedeTabla1);
        contenidoSedeTabla1.setLayout(contenidoSedeTabla1Layout);
        contenidoSedeTabla1Layout.setHorizontalGroup(
            contenidoSedeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeTabla1Layout.createSequentialGroup()
                .addGroup(contenidoSedeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenidoSedeTabla1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarRetencionCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contenidoSedeTabla1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(contenidoSedeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenidoSedeTabla1Layout.createSequentialGroup()
                                .addComponent(imprimirCarrera)
                                .addGap(18, 18, 18)
                                .addComponent(exportarCarrera)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE))))
                .addContainerGap())
        );
        contenidoSedeTabla1Layout.setVerticalGroup(
            contenidoSedeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoSedeTabla1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(contenidoSedeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imprimirCarrera)
                    .addComponent(exportarCarrera))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminarRetencionCarrera)
                .addContainerGap())
        );

        divisionRSede1.setRightComponent(contenidoSedeTabla1);

        javax.swing.GroupLayout contenidoRetencionCarreraLayout = new javax.swing.GroupLayout(contenidoRetencionCarrera);
        contenidoRetencionCarrera.setLayout(contenidoRetencionCarreraLayout);
        contenidoRetencionCarreraLayout.setHorizontalGroup(
            contenidoRetencionCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoRetencionCarreraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisionRSede1, javax.swing.GroupLayout.DEFAULT_SIZE, 1235, Short.MAX_VALUE)
                .addContainerGap())
        );
        contenidoRetencionCarreraLayout.setVerticalGroup(
            contenidoRetencionCarreraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoRetencionCarreraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(divisionRSede1)
                .addContainerGap())
        );

        menuTabsDashboard.addTab("Retencion por Carrera(PE)", contenidoRetencionCarrera);

        contenidoRetencionZona.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenidoRetencionZonaLayout = new javax.swing.GroupLayout(contenidoRetencionZona);
        contenidoRetencionZona.setLayout(contenidoRetencionZonaLayout);
        contenidoRetencionZonaLayout.setHorizontalGroup(
            contenidoRetencionZonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1255, Short.MAX_VALUE)
        );
        contenidoRetencionZonaLayout.setVerticalGroup(
            contenidoRetencionZonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        menuTabsDashboard.addTab("Retencion por Zona", contenidoRetencionZona);

        contenidoRetencionAnual.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenidoRetencionAnualLayout = new javax.swing.GroupLayout(contenidoRetencionAnual);
        contenidoRetencionAnual.setLayout(contenidoRetencionAnualLayout);
        contenidoRetencionAnualLayout.setHorizontalGroup(
            contenidoRetencionAnualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1255, Short.MAX_VALUE)
        );
        contenidoRetencionAnualLayout.setVerticalGroup(
            contenidoRetencionAnualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        menuTabsDashboard.addTab("Retencion Anual", contenidoRetencionAnual);

        contenidoRetencionJornada.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contenidoRetencionJornadaLayout = new javax.swing.GroupLayout(contenidoRetencionJornada);
        contenidoRetencionJornada.setLayout(contenidoRetencionJornadaLayout);
        contenidoRetencionJornadaLayout.setHorizontalGroup(
            contenidoRetencionJornadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1255, Short.MAX_VALUE)
        );
        contenidoRetencionJornadaLayout.setVerticalGroup(
            contenidoRetencionJornadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        menuTabsDashboard.addTab("Retencion por Jornada", contenidoRetencionJornada);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuTabsDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuTabsDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarDatosReporteAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarDatosReporteAreaActionPerformed
        DAOArea daoarea = new DAOArea();
        DAORetencionArea daoaretencionarea = new DAORetencionArea();
        DefaultTableModel DatosTablaArea = new DefaultTableModel();
        DatosTablaArea = daoarea.listaAreaTabla();
        int idArea = 0;
        float porcentaje = 0;
        int año = 0;
        boolean validador = false;
        if (spinerAñosArea.getValue().toString().isEmpty() || spinerPorcentajeArea.getValue().toString().isEmpty() || listArea.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Faltan campos por completar", "Informacion", 1);
        } else {

            for (int i = 0; i < DatosTablaArea.getRowCount(); i++) {
                if (DatosTablaArea.getValueAt(i, 1).toString().equals(listArea.getSelectedItem().toString())) {
                    idArea = (int) DatosTablaArea.getValueAt(i, 0);
                    validador = true;
                    break;
                } else {
                    validador = false;
                }
            }
            if (validador) {
                try {
                    spinerAñosArea.commitEdit();
                    spinerPorcentajeArea.commitEdit();
                    año = (int) spinerAñosArea.getValue();
                    porcentaje = (float) spinerPorcentajeArea.getValue();
                } catch (java.text.ParseException e) {
                };

                daoaretencionarea.AgregarProncentajeRetencionArea(porcentaje, idArea, año);
                //daoarea.AgregarArea(txtPorcentajeArea.getText().trim().toUpperCase());
                //DatosTablaArea();
                LimpiarCampos();
                DatosTablaCarrera();
            }
        }


    }//GEN-LAST:event_btnIngresarDatosReporteAreaActionPerformed

    private void tablaRetencionAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRetencionAreaMouseClicked
        tablaRetencionArea.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) this.tablaRetencionArea.getModel();
        int i = tablaRetencionArea.getSelectedRow();
        idretencionarea.setText(String.valueOf(tablaRetencionArea.getValueAt(i, 0)));
        listArea.setSelectedItem(String.valueOf(tablaRetencionArea.getValueAt(i, 1)));
        spinerAñosArea.setValue((int) (tablaRetencionArea.getValueAt(i, 3)));
        spinerPorcentajeArea.setValue((float) (tablaRetencionArea.getValueAt(i, 2)));

    }//GEN-LAST:event_tablaRetencionAreaMouseClicked

    private void btnEliminarRetencionAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRetencionAreaActionPerformed
        if (idretencionarea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun elemento selecionado", "Informacion", 1);
        } else {
            DAORetencionArea daoretencionarea = new DAORetencionArea();
            try {
                daoretencionarea.EliminarRetencionArea(Integer.parseInt(idretencionarea.getText()));
                //DatosTablaArea();
                CargarDatosTablaArea();
            } catch (NumberFormatException e) {
                System.out.println(e);
            }

            LimpiarCampos();
        }


    }//GEN-LAST:event_btnEliminarRetencionAreaActionPerformed

    private void btnModificarRetencionAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRetencionAreaActionPerformed
        if (idretencionarea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun elemento selecionado", "Informacion", 1);
        } else {
            //DEFINICION DE VARIABLES LOCALES PARA TRABAJAR
            DAORetencionAreaB daoretencionarea = new DAORetencionAreaB();
            LinkedList<RetencionArea> listaRetencionArea = new LinkedList<>();
            listaRetencionArea = daoretencionarea.consultar();
            int idRetencion = 0;
            int idRetencionArea = 0;
            int idArea = 0;
            float porcentaje = 0;
            int año = 0;
            //VALIDADOR PARA COMPROBAR ACCIONES
            boolean validador = false;

            //SE INTENTA OBTENER LA ID PRINCIPAL(LA DE LA TABLA) QUE SEA DE TIPO INT; DE NO SER EL CASO MUESTRA MENSAJE DE ERROR
            try {
                idRetencionArea = Integer.parseInt(idretencionarea.getText().trim());
            } catch (NumberFormatException e) {
                System.out.println(e);
                validador = true;
            }
            //SI ES VALIDADOR ES VERDADERO; EN ESTE CASO MUESTRA MENSAJE DE ERROR
            if (validador) {
                JOptionPane.showMessageDialog(this, "Error No es un int", "Informacion", 1);
                LimpiarCampos();
                CargarDatosTablaArea();
            } else {
                //SI LA PRIMERA VALIDACION ES CORRECTA PROCEDEMOS A CONSEGUIR LA ID SEGUNDARIA; EN ESTE CASO ID RETENCION PARA MODIFICAR 
                //EL PROCENTAJE DE RETENCION
                for (RetencionArea aux : listaRetencionArea) {
                    if (idRetencionArea == aux.getIdRetencionArea()) {
                        //SI EL ID PRINCIPAL ES IGUAL AL ID DEL LISTADO; ENTONCES SE ASIGNA
                        //LA ID SEGUNDARIA
                        idRetencion = aux.getIdRetencion();
                    }
                }
                //SI LA ID NO EXISTE SE MUESTRA ERROR
                if (idRetencion == 0) {
                    JOptionPane.showMessageDialog(this, "error", "Informacion", 1);
                    LimpiarCampos();
                    CargarDatosTablaArea();
                } else {
                    // AHORA SE PROCEDE A OBTENER LOS DATOS DE LOS INPUTS
                    DAOArea daoarea = new DAOArea();
                    DAORetencionArea daoaretencionarea = new DAORetencionArea();
                    DefaultTableModel DatosTablaArea2 = new DefaultTableModel();
                    DatosTablaArea2 = daoarea.listaAreaTabla();
                    if (spinerAñosArea.getValue().toString().isEmpty() || spinerPorcentajeArea.getValue().toString().isEmpty() || listArea.getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(this, "Faltan campos por completar", "Informacion", 1);
                    } else {
                        for (int i = 0; i < DatosTablaArea2.getRowCount(); i++) {
                            if (DatosTablaArea2.getValueAt(i, 1).toString().equals(listArea.getSelectedItem().toString())) {
                                idArea = (int) DatosTablaArea2.getValueAt(i, 0);
                                validador = true;
                                break;
                            } else {
                                validador = false;
                            }
                        }
                        if (validador) {
                            try {
                                spinerAñosArea.commitEdit();
                                spinerPorcentajeArea.commitEdit();
                                año = (int) spinerAñosArea.getValue();
                                porcentaje = (float) spinerPorcentajeArea.getValue();
                            } catch (java.text.ParseException e) {
                            }
                            try {
                                daoaretencionarea.ModificarReporte(idRetencionArea, idArea, idRetencion, porcentaje, año);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(this, "Error", "Informacion", 0);
                            }
                            JOptionPane.showMessageDialog(this, "Modificado", "Informacion", 1);
                            LimpiarCampos();
                            CargarDatosTablaArea();

                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarRetencionAreaActionPerformed

    private void tablaRetencionAreaComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaRetencionAreaComponentMoved

    }//GEN-LAST:event_tablaRetencionAreaComponentMoved

    private void listSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listSedeActionPerformed

    private void btnIngresarDatosReporteSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarDatosReporteSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresarDatosReporteSedeActionPerformed

    private void btnModificarRetencionSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRetencionSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarRetencionSedeActionPerformed

    private void tablaRetencionSedeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRetencionSedeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaRetencionSedeMouseClicked

    private void tablaRetencionSedeComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaRetencionSedeComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaRetencionSedeComponentMoved

    private void btnEliminarRetencionSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRetencionSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarRetencionSedeActionPerformed

    private void listCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listCarreraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listCarreraActionPerformed

    private void btnIngresarDatosReporteCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarDatosReporteCarreraActionPerformed
        DAOCarrera daocarrera = new DAOCarrera();
        DAORetencionCarrera daoretencioncarrera = new DAORetencionCarrera();
        LinkedList<Carrera> DatosTablaCarrera = new LinkedList<>();
        DatosTablaCarrera = daocarrera.consultar();
        int idCarrera = 0;
        float porcentaje = 0;
        int año = 0;
        boolean validador = false;
        if (spinerAñosCarrera.getValue().toString().isEmpty() || spinerPorcentajeCarrera.getValue().toString().isEmpty() || listCarrera.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(this, "Faltan campos por completar", "Informacion", 1);
        } else {

            for (Carrera miCarrera : DatosTablaCarrera) {
                if (miCarrera.getNombre().equals(listCarrera.getSelectedItem().toString().trim())) {
                    idCarrera = miCarrera.getIdCarrera();
                    validador = true;
                    break;
                } else {
                    validador = false;
                }
            }
            if (validador) {
                try {
                    spinerAñosCarrera.commitEdit();
                    spinerPorcentajeCarrera.commitEdit();
                    año = (int) spinerAñosCarrera.getValue();
                    porcentaje = (float) spinerPorcentajeCarrera.getValue();
                } catch (java.text.ParseException e) {
                    System.out.println(e.getMessage());
                }

                daoretencioncarrera.AgregarProncentajeRetencionCarrera(porcentaje, idCarrera, año);
                //daoarea.AgregarArea(txtPorcentajeArea.getText().trim().toUpperCase());
                //DatosTablaArea();
                LimpiarCampos();
                DatosTablaCarrera();
            }
        }
    }//GEN-LAST:event_btnIngresarDatosReporteCarreraActionPerformed

    private void btnModificarRetencionCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRetencionCarreraActionPerformed
        if (idretencionarea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun elemento selecionado", "Informacion", 1);
        } else {
            //DEFINICION DE VARIABLES LOCALES PARA TRABAJAR
            DAORetencionCarrera daoretencionacarrera = new DAORetencionCarrera();
            LinkedList<RetencionCarrera> listaRetencionCarrera = new LinkedList<>();
            listaRetencionCarrera = daoretencionacarrera.consultar();
            int idRetencion = 0;
            int idRetencionCarrera = 0;
            int idCarrera = 0;
            float porcentaje = 0;
            int año = 0;
            //VALIDADOR PARA COMPROBAR ACCIONES
            boolean validador = false;

            //SE INTENTA OBTENER LA ID PRINCIPAL(LA DE LA TABLA) QUE SEA DE TIPO INT; DE NO SER EL CASO MUESTRA MENSAJE DE ERROR
            try {
                idRetencionCarrera = Integer.parseInt(idretencioncarrera.getText().trim());
            } catch (NumberFormatException e) {
                System.out.println(e);
                validador = true;
            }
            //SI ES VALIDADOR ES VERDADERO; EN ESTE CASO MUESTRA MENSAJE DE ERROR
            if (validador) {
                JOptionPane.showMessageDialog(this, "Error No es un int", "Informacion", 1);
                LimpiarCampos();
                DatosTablaCarrera();
            } else {
                //SI LA PRIMERA VALIDACION ES CORRECTA PROCEDEMOS A CONSEGUIR LA ID SEGUNDARIA; EN ESTE CASO ID RETENCION PARA MODIFICAR 
                //EL PROCENTAJE DE RETENCION
                for (RetencionCarrera aux : listaRetencionCarrera) {
                    if (idRetencionCarrera == aux.getIdRetencionCarrera()) {
                        //SI EL ID PRINCIPAL ES IGUAL AL ID DEL LISTADO; ENTONCES SE ASIGNA
                        //LA ID SEGUNDARIA
                        idRetencion = aux.getIdRetencion();
                    }
                }
                //SI LA ID NO EXISTE SE MUESTRA ERROR
                if (idRetencion == 0) {
                    JOptionPane.showMessageDialog(this, "error", "Informacion", 1);
                    LimpiarCampos();
                    DatosTablaCarrera();
                } else {
                    // AHORA SE PROCEDE A OBTENER LOS DATOS DE LOS INPUTS
                    DAOCarrera daocarrera = new DAOCarrera();
                    DAORetencionCarrera daoaretencioncarrera = new DAORetencionCarrera();
                    LinkedList<Carrera> DatosTablaCarrera = new LinkedList<>();
                    DatosTablaCarrera = daocarrera.consultar();
                    if (spinerAñosCarrera.getValue().toString().isEmpty() || spinerPorcentajeCarrera.getValue().toString().isEmpty() || listCarrera.getSelectedItem().toString().equals("")) {
                        JOptionPane.showMessageDialog(this, "Faltan campos por completar", "Informacion", 1);
                    } else {

                        for (Carrera miCarrera : DatosTablaCarrera) {
                            if (miCarrera.getNombre().equals(listCarrera.getSelectedItem().toString().trim())) {
                                idCarrera = miCarrera.getIdCarrera();
                                validador = true;
                                break;
                            } else {
                                validador = false;
                            }
                        }
                        if (validador) {
                            boolean validador2 = false;
                            if (validador) {
                                try {
                                    spinerAñosCarrera.commitEdit();
                                    spinerPorcentajeCarrera.commitEdit();
                                    año = (int) spinerAñosCarrera.getValue();
                                    porcentaje = (float) spinerPorcentajeCarrera.getValue();
                                } catch (java.text.ParseException e) {
                                    System.out.println(e.getMessage());
                                    validador = true;
                                }
                                try {
                                daoaretencioncarrera.ModificarReporte(idRetencionCarrera, idCarrera, idRetencion, porcentaje, año);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, "Error", "Informacion", 0);
                                }
                            }
                            if (!validador2) {
                              JOptionPane.showMessageDialog(this, "Modificado", "Informacion", 1);  
                            }
                            
                            LimpiarCampos();
                            DatosTablaCarrera();

                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_btnModificarRetencionCarreraActionPerformed

    private void tablaRetencionCarreraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRetencionCarreraMouseClicked
        tablaRetencionCarrera.setEnabled(true);
        DefaultTableModel model = (DefaultTableModel) this.tablaRetencionCarrera.getModel();
        int i = tablaRetencionCarrera.getSelectedRow();
        idretencioncarrera.setText(String.valueOf(tablaRetencionCarrera.getValueAt(i, 0)));
        listCarrera.setSelectedItem(String.valueOf(tablaRetencionCarrera.getValueAt(i, 1)));
        spinerAñosCarrera.setValue((int) (tablaRetencionCarrera.getValueAt(i, 3)));
        spinerPorcentajeCarrera.setValue((float) (tablaRetencionCarrera.getValueAt(i, 2)));
    }//GEN-LAST:event_tablaRetencionCarreraMouseClicked

    private void tablaRetencionCarreraComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tablaRetencionCarreraComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaRetencionCarreraComponentMoved

    private void btnEliminarRetencionCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarRetencionCarreraActionPerformed
        if (idretencioncarrera.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay ningun elemento selecionado", "Informacion", 1);
        } else {
            DAORetencionCarrera daoretencioncarrera = new DAORetencionCarrera();
            try {
                daoretencioncarrera.EliminarRetencionCarrera(Integer.parseInt(idretencioncarrera.getText()));
                //DatosTablaArea();

            } catch (NumberFormatException e) {
                System.out.println(e);
            }
            DatosTablaCarrera();
            LimpiarCampos();
        }
    }//GEN-LAST:event_btnEliminarRetencionCarreraActionPerformed

    private void ingresarCarreraRapidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresarCarreraRapidaActionPerformed

        customDialog.setLocationRelativeTo(this);
        customDialog.setVisible(true);
    }//GEN-LAST:event_ingresarCarreraRapidaActionPerformed

    private void imprimirAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirAreaActionPerformed

        LocalDateTime ahora = LocalDateTime.now();

        MessageFormat format = new MessageFormat("Informe de retencion: Page - {0}");
        MessageFormat format2 = new MessageFormat("Retencion Area " + ahora);
        try {
            tablaRetencionArea.print(JTable.PrintMode.FIT_WIDTH, format, format2);
        } catch (PrinterException ex) {
            Logger.getLogger(dashboardRetencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imprimirAreaActionPerformed

    private void exportarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarAreaActionPerformed
        String guardarArchivo = guardarArchivo(this);

        ModeloExcel excel = new ModeloExcel();
        try {
            if (!guardarArchivo.equals("")) {
                excel.Exportar(new File(guardarArchivo), tablaRetencionArea);
                JOptionPane.showMessageDialog(this, "Se a guardado en: " + guardarArchivo + "", "Informacion", 1);

            } else {
                JOptionPane.showMessageDialog(this, "No se a seleccionado ningun archivo", "Mensaje", 1);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e, "Error", 0);
        }


    }//GEN-LAST:event_exportarAreaActionPerformed

    private void imprimirCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirCarreraActionPerformed
        LocalDateTime ahora = LocalDateTime.now();

        MessageFormat format = new MessageFormat("Informe de retencion: Page - {0}");
        MessageFormat format2 = new MessageFormat("Retencion Carrera " + ahora);
        try {
            tablaRetencionCarrera.print(JTable.PrintMode.FIT_WIDTH, format, format2);
        } catch (PrinterException ex) {
            Logger.getLogger(dashboardRetencion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_imprimirCarreraActionPerformed

    private void exportarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarCarreraActionPerformed
        String guardarArchivo = guardarArchivo(this);

        ModeloExcel excel = new ModeloExcel();
        try {
            if (!guardarArchivo.equals("")) {
                excel.Exportar(new File(guardarArchivo), tablaRetencionCarrera);
                JOptionPane.showMessageDialog(this, "Se a guardado en: " + guardarArchivo + "", "Informacion", 1);

            } else {
                JOptionPane.showMessageDialog(this, "No se a seleccionado ningun archivo", "Mensaje", 1);
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e, "Error", 0);
        }
    }//GEN-LAST:event_exportarCarreraActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void exportarArea2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportarArea2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exportarArea2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Lobby frm = new Lobby();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Programadores1 frm = new Programadores1();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(dashboardRetencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new dashboardRetencion().setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Inicio;
    private javax.swing.JButton btnEliminarRetencionArea;
    private javax.swing.JButton btnEliminarRetencionCarrera;
    private javax.swing.JButton btnEliminarRetencionSede;
    private javax.swing.JButton btnIngresarDatosReporteArea;
    private javax.swing.JButton btnIngresarDatosReporteCarrera;
    private javax.swing.JButton btnIngresarDatosReporteSede;
    private javax.swing.JButton btnModificarRetencionArea;
    private javax.swing.JButton btnModificarRetencionCarrera;
    private javax.swing.JButton btnModificarRetencionSede;
    private javax.swing.JPanel contenidoAreaInputs;
    private javax.swing.JPanel contenidoAreaTabla;
    private javax.swing.JPanel contenidoRetencionAnual;
    private javax.swing.JPanel contenidoRetencionArea;
    private javax.swing.JPanel contenidoRetencionCarrera;
    private javax.swing.JPanel contenidoRetencionJornada;
    private javax.swing.JPanel contenidoRetencionSede;
    private javax.swing.JPanel contenidoRetencionZona;
    private javax.swing.JPanel contenidoSedeInputs;
    private javax.swing.JPanel contenidoSedeInputs1;
    private javax.swing.JPanel contenidoSedeTabla;
    private javax.swing.JPanel contenidoSedeTabla1;
    private javax.swing.JSplitPane divisionRArea;
    private javax.swing.JSplitPane divisionRSede;
    private javax.swing.JSplitPane divisionRSede1;
    private javax.swing.JButton exportarArea;
    private javax.swing.JButton exportarArea2;
    private javax.swing.JButton exportarCarrera;
    private javax.swing.JLabel idretencionarea;
    private javax.swing.JLabel idretencioncarrera;
    private javax.swing.JLabel idretencionsede;
    private javax.swing.JButton imprimirArea;
    private javax.swing.JButton imprimirCarrera;
    private javax.swing.JButton ingresarAreaRapida;
    private javax.swing.JButton ingresarCarreraRapida;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JComboBox<String> listArea;
    private javax.swing.JComboBox<String> listCarrera;
    private javax.swing.JComboBox<String> listSede;
    private javax.swing.JTabbedPane menuTabsDashboard;
    private javax.swing.JSpinner spinerAñosArea;
    private javax.swing.JSpinner spinerAñosCarrera;
    private javax.swing.JSpinner spinerAñosSede;
    private javax.swing.JSpinner spinerPorcentajeArea;
    private javax.swing.JSpinner spinerPorcentajeCarrera;
    private javax.swing.JSpinner spinerPorcentajeSede;
    private javax.swing.JTable tablaRetencionArea;
    private javax.swing.JTable tablaRetencionCarrera;
    private javax.swing.JTable tablaRetencionSede;
    // End of variables declaration//GEN-END:variables
}
