/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informeRetencion;

import static informeRetencion.DAOCarrera.cn;
import static informeRetencion.DAORetencionArea.cn;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import modelo.Operaciones;
import modelo.RetencionCarrera;

/**
 *
 * @author Kevin
 */
public class DAORetencionCarrera implements Operaciones {

    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();

    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public DefaultTableModel listaRetencionTabla() {
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();

            String query = "Select c.idcarrera, c.nombre, r.idretencion, r.porcentaje, ra.idretencioncarrera, ra.año\n"
                    + "from carrera c, retencion r, retencion_carrera ra\n"
                    + "where (c.idcarrera = ra.carreraidcarrera and ra.retencionidretencion = r.idretencion);";
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

    public void EliminarRetencionCarrera(int idRetencionCarrera) {
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            String query = "DELETE FROM Retencion_Carrera WHERE idRetencionCarrera =" + idRetencionCarrera + ";";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "ELIMINADO");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    public void AgregarProncentajeRetencionCarrera(float porcentaje, int idCarrera, int año) {

        try {
            cn = Conexion.Enlace(cn);
            try (Statement statement = cn.createStatement()) {
                String s1 = "INSERT INTO Retencion (porcentaje)\n"
                        + "VALUES (" + porcentaje + ");";
                String s2 = "INSERT INTO Retencion_Carrera (retencionIdRetencion,carreraIdCarrera,año)\n"
                        + "VALUES ((SELECT MAX(idRetencion) FROM Retencion)," + idCarrera + "," + año + ");";
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

    @Override
    public LinkedList<RetencionCarrera> consultar() {
        LinkedList<RetencionCarrera> listaCarrera = new LinkedList();
        try {
            cn = Conexion.Enlace(cn);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement pst;
        ResultSet resultSet;
        String sql = "Select c.idcarrera, c.nombre, r.idretencion, r.porcentaje, ra.idretencioncarrera, ra.año\n"
                + "from carrera c, retencion r, retencion_carrera ra\n"
                + "where (c.idcarrera = ra.carreraidcarrera and ra.retencionidretencion = r.idretencion)\n"
                + "group by ra.año;";
        try {
            Class.forName(Conexion.driver);
            cn = DriverManager.getConnection(Conexion.url);
            pst = cn.prepareStatement(sql);
            resultSet = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (resultSet.next()) //mientras haya otra fila en la tabla, avanza al siguiente
            {
                listaCarrera.add(new RetencionCarrera(resultSet.getInt(DB.ID_CARRERA),
                        resultSet.getString(DB.NOMBRE_CARRERA),
                        resultSet.getInt(DB.ID_RETENCION),
                        resultSet.getFloat(DB.PROCENTAJE_RETENCION),
                        resultSet.getInt(DB.ID_RETENCION_CARRERA),
                        resultSet.getInt(DB.AÑO_RETENCION)
                ));
            }
            // 
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            //EXISTEN 2 exception (MULTICATCH)
        }
        return listaCarrera; //To change body of generated methods, choose Tools | Templates.
    }

    public void ModificarReporte(int idRetencionCarrera, int idCarrera, int IdRetencion, float porcentaje, int año) {
        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            String query = "UPDATE Retencion_Carrera SET carreraIdCarrera = " + idCarrera + ", año = " + año + " WHERE idRetencionCarrera = " + idRetencionCarrera + ";";
            String query2 = "UPDATE Retencion SET porcentaje = " + porcentaje + " WHERE idRetencion = " + IdRetencion + ";";
            s.addBatch(query);
            s.addBatch(query2);
            s.executeBatch();
            s.close();
            cn.close();

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
