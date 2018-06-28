/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informeRetencion;

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
public class DAORegion {
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();
    
            public  DefaultTableModel lista() {

        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from Region";
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //retornamos modelo para jtable
        return modelo;

    }

}
