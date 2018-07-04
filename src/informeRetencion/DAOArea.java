/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informeRetencion;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;


/**
 *
 * @author Kevin
 */
public class DAOArea {

    private Connection cn;
    private Statement s;
    private ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel listaAreaTabla() {
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from Area";
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
    
    

    public LinkedList<String> consultar() {
        LinkedList<String> listaArea = new LinkedList();
        Connection conn;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM Area;";
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(Conexion.ruta);
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla Area y agregar objetos a la lista Area
            while (rs.next()) //mientras haya otra fila en la tabla, avanza al siguiente
            {
                listaArea.add(rs.getString("idArea"));
                listaArea.add(rs.getString("nombre"));
            }
            // una vez finalizado, cerar la conexion a la DB
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            //EXISTEN 2 exception (MULTICATCH)
        }
        return listaArea; //To change body of generated methods, choose Tools | Templates.
    }

    public void AgregarArea(String nombre) {

        try {
            cn = Conexion.Enlace(cn);
            try (Statement statement = cn.createStatement()) {
                String query = "INSERT INTO Area (nombre) VALUES ('"+nombre+"')";
                statement.executeUpdate(query);
            }
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
        } catch (HeadlessException | SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
