/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoING;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;


public class CRUDAnteAcade {
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();

        public DefaultTableModel lista() {

        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from AnteAcademico";
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


    public void BuscarDocenteID(String id){
    }
    
    
    public void AgregarConsulta(String profesion, String diplomado, String magister, String mba, String doctorado, String experienciaDoc, String experienciaLab, String cursoPad, String areaPerteneciente) {
        try {
            Statement s = cn.createStatement();
            String query = "INSERT INTO AnteAcademico(profesion,diplomado,magister,mba,doctorado,experienciaDoc,experienciaLab,cursoPad,areaPerteneciente)values ('" + profesion + "','" + diplomado + "','" + magister + "','" + mba + "','" + doctorado + "','" + experienciaDoc + "','" + experienciaLab + "','" + cursoPad + "','" + areaPerteneciente + "')";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "Agregado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
        
    public void EliminarConsulta(String id) {
        try {
            Statement s = cn.createStatement();
            String query = "DELETE FROM AnteAcademico WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "Eliminado con éxito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    //creamos metodo para modificar datos

    public void ModificarConsulta(String profesion, String diplomado, String magister, String mba, String doctorado, String experienciaDoc, String experienciaLab, String cursoPad, String areaPerteneciente, String id) {
        try {
            Statement s = cn.createStatement();
            String query = "UPDATE AnteAcademico SET profesion='" + profesion + "',diplomado='" + diplomado + "',magister='" + magister + "',mba='" + mba + "',doctorado='" + doctorado + "',experienciaDoc='" + experienciaDoc + "',experienciaLab='" + experienciaLab + "',cursoPad='" + cursoPad + "',areaPerteneciente='" + areaPerteneciente + "' WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}


