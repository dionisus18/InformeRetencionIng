/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.Usuario;

/**
 *
 * @author snahu
 */
public class controladorInicioSesion {

    static Connection cn;
    static Statement s;
    static ResultSet rs;

    public static String[] IniciarSesion(String user, String pass) throws SQLException {
        //PreparedStatement ps=null;
        //Conexion con base de datos
        cn= Conexion.Enlace(cn);
        //Lista donde se almacena el usuario
        //ArrayList<Usuario> lista = new ArrayList<>();
        String[] lista= new String[3]; 
        String query = "SELECT * FROM Usuario WHERE username='" + user + "' and password='" + pass+"'";
        //dentro de try cacht por si los errores
        try {
            
            
            //System.out.println(query);
            s = cn.createStatement();
            rs = s.executeQuery(query);
            //ResultSetMetaData rsmd = rs.getMetaData();

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int tipo = rs.getInt("type");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String rut = rs.getString("rut");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");

                lista[0]=nombre+" "+apellidoP;
                lista[1]= rut;
                lista[2]= String.valueOf(tipo);
                //Usuario us = new Usuario(id, username, rut, tipo, nombre, apellidoP, apellidoM, correo, telefono,password);
                //System.out.println(username);
                //lista.add(us);
            }
           
                return lista;
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return lista;
    }

}
