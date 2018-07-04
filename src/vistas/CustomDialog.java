/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import informeRetencion.DAOArea;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */

/* 1.4 example used by DialogDemo.java. */
class CustomDialog extends JDialog
                   implements ActionListener,
                              PropertyChangeListener {
    private String typedText = null;
    private String typedText2 = null;
    private String typedText3 = null;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox listArea;
    private JLabel NombreVentana = new JLabel();
    
    

    private dashboardRetencion dd;

    private String magicWord;
    private JOptionPane optionPane;

    private String btnString1 = "Emviar";
    private String btnString2 = "Cancelar";

    /**
     * Returns null if the typed string was invalid;
     * otherwise, returns the string as the user entered it.
     */
    public String getValidatedText() {
        return typedText;
    }
            


    /** Creates the reusable dialog. */
    public CustomDialog(Frame aFrame, String aWord, String jlabeltitle, dashboardRetencion parent) {
        super(aFrame, true);
        dd = parent;
        NombreVentana.setText("<html><span style='font-size:18px'>"+jlabeltitle+"</span></html>");
        
        magicWord = aWord.toUpperCase();
        setTitle("Registrar Carrera");

        textField = new JTextField(10);
        textField2 = new JTextField(10);
        textField3 = new JTextField(10);
        listArea = new JComboBox();
        try {
        DAOArea daoarea = new DAOArea();
        DefaultTableModel DatosTablaArea = new DefaultTableModel();
        DatosTablaArea = daoarea.listaAreaTabla();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < DatosTablaArea.getRowCount(); i++) {
          
          ls.add((String) DatosTablaArea.getValueAt(i, 1));
          
        }
        ls.add(0,"");
        listArea.setModel(new DefaultComboBoxModel(ls.toArray()));
        } catch (Exception e) {
        }
        

        //Create an array of the text and components to be displayed.
        String msgString1 = "Ingrese Datos de Carrera";
        String msgString2 = "Nombre";
        String msgString3 = "Codigo";
        String msgString4 = "Area";

        Object[] array = {NombreVentana,  msgString2,textField, msgString3, textField2,msgString4, listArea};

        //Create an array specifying the number of dialog buttons
        //and their text.
        Object[] options = {btnString1, btnString2};

        //Create the JOptionPane.
        optionPane = new JOptionPane(array,
                                    JOptionPane.PLAIN_MESSAGE,
                                    JOptionPane.YES_NO_OPTION,
                                    null,
                                    options,
                                    options[0]);

        //Make this dialog display it.
        setContentPane(optionPane);

        //Handle window closing correctly.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent we) {
                /*
                 * Instead of directly closing the window,
                 * we're going to change the JOptionPane's
                 * value property.
                 */
                    optionPane.setValue(JOptionPane.CLOSED_OPTION);
            }
        });

        //Ensure the text field always gets the first focus.
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent ce) {
                textField.requestFocusInWindow();
            }
        });

        //Register an event handler that puts the text into the option pane.
        textField.addActionListener(this);
        textField2.addActionListener(this);
        textField3.addActionListener(this);

        //Register an event handler that reacts to option pane state changes.
        optionPane.addPropertyChangeListener(this);
    }

    /** This method handles events for the text field. */
    @Override
    public void actionPerformed(ActionEvent e) {
        optionPane.setValue(btnString1);
    }

    /** This method reacts to state changes in the option pane. */
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        String prop = e.getPropertyName();

        if (isVisible()
         && (e.getSource() == optionPane)
         && (JOptionPane.VALUE_PROPERTY.equals(prop) ||
             JOptionPane.INPUT_VALUE_PROPERTY.equals(prop))) {
            Object value = optionPane.getValue();

            if (value == JOptionPane.UNINITIALIZED_VALUE) {
                //ignore reset
                return;
            }

            //Reset the JOptionPane's value.
            //If you don't do this, then if the user
            //presses the same button next time, no
            //property change event will be fired.
            optionPane.setValue(
                    JOptionPane.UNINITIALIZED_VALUE);

            if (btnString1.equals(value)) {
                    typedText = textField.getText();
                    typedText= textField2.getText();
                    typedText = textField3.getText();
                String ucText = typedText.toUpperCase();
                if (magicWord.equals(ucText)) {
                    //we're done; clear and dismiss the dialog
                    clearAndHide();
                } else {
                    //text was invalid
                    textField.selectAll();
                    JOptionPane.showMessageDialog(
                                    CustomDialog.this,
                                    "Sorry, \"" + typedText + "\" "
                                    + "isn't a valid response.\n"
                                    + "Please enter "
                                    + magicWord + ".",
                                    "Try again",
                                    JOptionPane.ERROR_MESSAGE);
                    typedText = null;
                    textField.requestFocusInWindow();
                }
            } else { //user closed dialog or clicked cancel
                System.out.println("asdasdasda");
                typedText = null;
                clearAndHide();
            }
        }
    }

    /** This method clears the dialog and hides it. */
    public void clearAndHide() {
        textField.setText(null);
        textField2.setText(null);
        textField3.setText(null);
        setVisible(false);
    }


}