/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author snahu
 */
public class Conexion {
    //E:\\Kevin\\Desktop\\//BDreporte.db
    public static String ruta = "";
    static Connection cn = null;
//creamos la clase conexion
    public static Connection Enlace(Connection cn)throws SQLException{
    //ruta de la base de datos la cual crearemos
      
        try{
        Class.forName("org.sqlite.JDBC");
        cn = DriverManager.getConnection("jdbc:sqlite:"+ruta);        
        }catch(ClassNotFoundException e){
        JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }
}
