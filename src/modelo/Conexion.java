
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    public static String ruta = ".\\\\DataRetencion.db";
    static Connection cn = null;
    public static String driver = "org.sqlite.JDBC";
    public static String url = "jdbc:sqlite:.\\\\DataRetencion.db";
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

    public static String getRuta() {
        return ruta;
    }

    public static void setRuta(String ruta) {
        Conexion.ruta = ruta;
    }

    public static Connection getCn() {
        return cn;
    }

    public static void setCn(Connection cn) {
        Conexion.cn = cn;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        Conexion.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Conexion.url = url;
    }
    
}
