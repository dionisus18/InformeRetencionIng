/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author nikocid
 */
public class validar {
    
    public void validarSololetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int k = (int)e.getKeyChar();
                if (Character.isDigit(c) || k==64) {
                    e.consume();
                    System.out.println("car: " + c);
                }
            }
            
            
        });
        
    }
    
    public void validarSoloNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                    System.out.println("car: " + c);
                }
            }
            
            
        });
        
    }
    
    public void limitarCaracteres(JTextField campo, int cantidad){
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int tam = campo.getText().length();
                if (tam >=cantidad) {
                    e.consume();
                    System.out.println("car: " + c);
                }
            }
            
            
        });
        
    }
    
    public void ValidaCamposVacios(String nCedula, String nombre, String aPaterno,String aMaterno,String tContrato,String fNac,String aIngreso,String correo,String direccion){
        if (nCedula.equals("") || nombre.equals("")|| aPaterno.equals("")|| aMaterno.equals("")|| tContrato.equals("")|| fNac.equals("")|| aIngreso.equals("")|| correo.equals("")|| direccion.equals("")) {
            JOptionPane.showMessageDialog(null,"Asegurese de llenar todos los campos", "error al enviar el formulario", JOptionPane.ERROR_MESSAGE);
        }else{
             JOptionPane.showMessageDialog(null,"Se ha enviado Correctamente", "formulario enviado", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    
    
    
    
}
