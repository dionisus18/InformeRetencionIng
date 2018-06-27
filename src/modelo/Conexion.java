
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static String ruta = "";
    static Connection cn = null;
    //E:\\Kevin\\Desktop\\//BDreporte.db
    public static Connection Enlace(Connection cn)throws SQLException{
    
      
        try{
        Class.forName("org.sqlite.JDBC");
        cn = DriverManager.getConnection("jdbc:sqlite:"+ruta);        
        }catch(ClassNotFoundException e){
        JOptionPane.showMessageDialog(null, e);
        }
        return cn;
    }
}
