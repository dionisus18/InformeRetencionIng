/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.justificacion;
import java.util.ArrayList;


/**
 *
 * @author edgar
 */
public class CRUDjustificacion {

 static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel lista(String nombre) {

        try {

            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from justificacion";
            rs = s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            //obtenemos numero de columnas 
            int CanColumns = rsmd.getColumnCount();
            //comprobamos 
            for (int i = 1; i <= CanColumns; i++) {
                //cargamos columnas en modelo
                modelo.addColumn(rsmd.getColumnLabel(i));
            }
            while (rs.next()) {
                //creamos array 
                Object[] fila = new Object[CanColumns];
                //cargamos datos a modelo
                for (int i = 0; i < CanColumns; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //retornamos modelo para jtable
        return modelo;

    }

    public void AgregarConsulta( String nombre, String horario, String seccion, String jornada, String incidente, String comentario) {
        //dentro de try cacht por si los errores
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            String query = "INSERT INTO justificacion (nombre, horario, seccion, jornada, incidente, comentario)values ('" + nombre + "','"
                    + horario + "','" + seccion + "','" + jornada + "','" + incidente + "','" + comentario + "')";
            s.executeUpdate(query);
            System.out.println(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NO REGISTRADO");
        }
    }

    public void EliminarConsulta(String id_justificacion) {
        try {
            Statement s = cn.createStatement();
            String query = "DELETE FROM justificacion WHERE id_justificacion='" + id_justificacion + "'";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void ModificarConsulta( String nombre, String horario, String seccion, String jornada, String incidente, String comentario, String id_justificacion) {
        try {
            Statement s = cn.createStatement();
             String query = "UPDATE justificacion SET nombre='" + nombre + "', horario='" + horario + "',seccion='"
                    + seccion + "', jornada='"+ jornada + "',incidente='"+incidente + "',comentario='"+ comentario+  "' WHERE id_justificacion=+" + id_justificacion +"";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public String[] cargarjustificacion(String id_justificacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void AgregarConsulta(String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void EliminarConsulta(String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void ModificarrConsulta(String text, String text0, String text1, String text2, String text3, String text4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
