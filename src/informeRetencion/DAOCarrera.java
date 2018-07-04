/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informeRetencion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Carrera;
import modelo.Conexion;
import modelo.Operaciones;

/**
 *
 * @author Kevin
 */
public class DAOCarrera implements Operaciones{
        static Connection cn;
        static Statement s;
        static ResultSet rs;
        Conexion db = new Conexion();

    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Connection conn = null;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "INSERT INTO "+DB.CARRERA+" ("+DB.ID_CARRERA+", "+DB.NOMBRE_CARRERA+", "+DB.ID_AREA_CARRERA+") VALUES(?,?,?);";
        Carrera miCarrera = (Carrera)obj;
        try{
            conn = Conexion.Enlace(conn);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, miCarrera.getIdCarrera());
            pst.setString(2, miCarrera.getNombre());
            pst.setInt(3, miCarrera.getAreaIdArea());
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            respuesta = "Se a guardado" + filas + " Carreras Nuevos";
            conn.close();
        } catch (SQLException e) {
            respuesta = "se cayo esta ve..." + e.toString();
        }
        return respuesta;
    }
    
    public void insertarDatos(int id){
        Connection conn = null;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "INSERT INTO "+DB.CARRERA+" ("+DB.ID_CARRERA+", "+DB.NOMBRE_CARRERA+", "+DB.ID_AREA_CARRERA+") VALUES(?,?,?);";
        try{
            conn = Conexion.Enlace(conn);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, id);
            pst.setInt(3, id);
            int filas = pst.executeUpdate();
            //independiente de lo que se haga, Create, Update, Delete , se 
            //realiza una actualizacion de la tabla
            pst.close();
            conn.close();
        } catch (SQLException e) {

        }
    }

    @Override
    public String eliminar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String modificar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String consultas(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Carrera> consultar() {
        LinkedList<Carrera> listaCarrera = new LinkedList();
            try {
                cn = Conexion.Enlace(cn);
            } catch (SQLException ex) {
                Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        PreparedStatement pst;
        ResultSet resultSet;
        String sql = "SELECT * FROM "+DB.CARRERA+";";
        try {
            Class.forName(Conexion.driver);
            cn = DriverManager.getConnection(Conexion.url);
            pst = cn.prepareStatement(sql);
            resultSet = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (resultSet.next()) //mientras haya otra fila en la tabla, avanza al siguiente
            {
                listaCarrera.add(new Carrera(resultSet.getInt(DB.ID_CARRERA),
                        resultSet.getString(DB.NOMBRE_CARRERA),
                        resultSet.getString(DB.CODIGO_CARRERA),
                        resultSet.getInt(DB.ID_AREA_CARRERA)
                ));
            }
            // una vez finalizado, cerar la conexion a la DB
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            //EXISTEN 2 exception (MULTICATCH)
        }
        return listaCarrera; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<Carrera> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
