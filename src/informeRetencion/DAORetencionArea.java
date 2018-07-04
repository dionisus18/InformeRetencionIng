/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informeRetencion;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;

/**
 *
 * @author Kevin
 */
public class DAORetencionArea {
        static Connection cn;
        static Statement s;
        static ResultSet rs;
        DefaultTableModel modelo = new DefaultTableModel();
        
        
        public DefaultTableModel listaRetencionTabla() {
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            
            String query =  "Select ra.idretencionarea as 'ID', a.nombre as 'AREA INACAP', r.porcentaje  as 'Retencion', ra.año as 'Año' from area a, retencion r, retencion_area ra where (a.idarea = ra.areaidarea and ra.retencion_idretencion = r.idretencion);";
            rs = s.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();

            int totalColumnas = rsmd.getColumnCount();

            for (int i = 1; i <= totalColumnas; i++) {

                modelo.addColumn(rsmd.getColumnLabel(i));
            }
            while (rs.next()) {

                Object[] fila = new Object[totalColumnas];

                for (int i = 0; i < totalColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return modelo;

    }
    



    public void AgregarProncentajeRetencionArea(float porcentaje, int idArea, int año) {

        try {
            cn = Conexion.Enlace(cn);
            try (Statement statement = cn.createStatement()) {
                String s1 = "INSERT INTO Retencion (porcentaje)\n" +
                        "VALUES ("+porcentaje+");";
                String s2 = "INSERT INTO Retencion_Area (retencion_IdRetencion,areaIdArea,año)\n" +
                        "VALUES ((SELECT MAX(idRetencion) FROM Retencion),"+idArea+","+año+");";
                statement.addBatch(s1);
                statement.addBatch(s2);
                statement.executeBatch();
            }
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
        } catch (HeadlessException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
       public void EliminarRetencionArea(int idRetencionArea){
       try{
           cn = Conexion.Enlace(cn);
       Statement s=cn.createStatement();
       String query="DELETE FROM Retencion_Area\n" +
                    "WHERE idRetencionArea ="+idRetencionArea+";";
       s.executeUpdate(query);
       s.close();
       cn.close();
       JOptionPane.showMessageDialog(null, "ELIMINADO");
       }catch(HeadlessException | SQLException e){JOptionPane.showMessageDialog(null, e);
       
       }
        
        }
        //creamos metodo para modificar datos
        public void ModificarReporte(int idRetencionArea,int areaId, int IdRetencion,float porcentaje, int año){
        try{
            cn = Conexion.Enlace(cn);
        Statement s=cn.createStatement();
        String query="UPDATE Retencion_Area SET areaIdArea = "+areaId+", año = "+año+" WHERE idRetencionArea = "+idRetencionArea+";";
        String query2 = "UPDATE Retencion SET porcentaje = "+porcentaje+" WHERE idRetencion = "+IdRetencion+";";
            s.addBatch(query);
            s.addBatch(query2);     
            s.executeBatch();
        s.close();
        cn.close();
        
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        
        }
        }
        
    
}
