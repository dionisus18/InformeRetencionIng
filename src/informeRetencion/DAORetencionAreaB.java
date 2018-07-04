/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informeRetencion;

import static informeRetencion.DAOCarrera.cn;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Conexion;
import modelo.Operaciones;
import modelo.RetencionArea;

/**
 *
 * @author Kevin
 */
public class DAORetencionAreaB implements Operaciones{

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

    @Override
    public LinkedList<RetencionArea> consultar() {
         LinkedList<RetencionArea> listaArea = new LinkedList();
            try {
                cn = Conexion.Enlace(cn);
            } catch (SQLException ex) {
                Logger.getLogger(DAOCarrera.class.getName()).log(Level.SEVERE, null, ex);
            }
        PreparedStatement pst;
        ResultSet resultSet;
        String sql = "SELECT a.idArea, a.nombre, r.idRetencion, r.porcentaje, ra.idRetencionArea, ra.año\n" +
                     "FROM area a, retencion r, retencion_area ra\n" +
                     "WHERE (a.idarea = ra.areaidarea and ra.retencion_idretencion = r.idretencion);";
        try {
            Class.forName(Conexion.driver);
            cn = DriverManager.getConnection(Conexion.url);
            pst = cn.prepareStatement(sql);
            resultSet = pst.executeQuery(); // para ejecutar la consulta
            //recorrer la tabla persona y agregar objetos a la listaPersona
            while (resultSet.next()) //mientras haya otra fila en la tabla, avanza al siguiente
            {
                listaArea.add(new  RetencionArea(resultSet.getInt(DB.ID_AREA),
                        resultSet.getString(DB.NOMBRE_AREA),
                        resultSet.getInt(DB.ID_RETENCION),
                        resultSet.getFloat(DB.PROCENTAJE_RETENCION),
                        resultSet.getInt(DB.ID_RETENCION_AREA),
                        resultSet.getInt(DB.AÑO_RETENCION)
                ));
            }
            // una vez finalizado, cerar la conexion a la DB
            cn.close();
        } catch (ClassNotFoundException | SQLException e) {
            //EXISTEN 2 exception (MULTICATCH)
        }
        return listaArea; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedList<?> filtrar(String campo, String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
