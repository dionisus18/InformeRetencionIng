/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoing;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import static proyectoing.CrudAntPer.cn;

/**
 *
 * @author nikocid
 */
public class CrudAntAca {

    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel lista(String id) {

        try {

            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from AntAcademicos Where id_docente=" + id;
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

    public void AgregarConsulta(String periodo, String evaluacion, String area, String id_docente) {
        //dentro de try cacht por si los errores
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            String query = "INSERT INTO AntAcademicos(evaDoc, AreaPerteneciente, periodo, id_docente)values ('" + evaluacion + "','" + area + "','"
                    + periodo + "','" + id_docente + "')";
            s.executeUpdate(query);
            System.out.println(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void EliminarConsulta(String id) {
        try {
            Statement s = cn.createStatement();
            String query = "DELETE FROM AntAcademicos WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void ModificarConsulta(String id,String periodo, String evaluacion, String area) {
        try {
            Statement s = cn.createStatement();
            String query = "UPDATE AntPersonales SET evaDoc='" + evaluacion + "', AreaPerteneciente='" + area + "',periodo='"
                    + periodo +  "' WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}
