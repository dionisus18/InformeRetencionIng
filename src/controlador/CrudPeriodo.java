/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;

/**
 *
 * @author snahu
 */
public class CrudPeriodo {

    static Connection cn;
    static Statement s;
    static ResultSet rs;

    public static ArrayList<String> CargarDatos() {
        ArrayList<String> lista = new ArrayList<>();
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from periodo";
            rs = s.executeQuery(query);
             int i=0;
             while (rs.next()) {
              lista.add(rs.getString("descripcion"));
             
            
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrudPeriodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;

    }

}
