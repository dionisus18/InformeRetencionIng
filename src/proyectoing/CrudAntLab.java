/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoing;

import interfaz.antecedentesLaborales;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;
import static proyectoing.CrudAntPer.cn;

/**
 *
 * @author nikocid
 */
public class CrudAntLab {

    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();

    public DefaultTableModel lista() {

        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from AntLaborales";
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

    public void AgregarConsulta(String profesion, String licenciatura, String diplomado, String magister, String mba, String doctorado, String experienciaDoc, String experienciaLab, String cursoPad , String idDocente) {

        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            String query = "INSERT INTO AntLaborales(profesion,licenciatura,diplomado,magister,mba,doctorado,experienciaDoc,experienciaLab,cursoPad, id_docente)values ('" + profesion + "','" + licenciatura + "','" + diplomado + "','" + magister + "','" + mba + "','" + doctorado + "','" + experienciaDoc + "','" + experienciaLab + "','" + cursoPad + "','" + Integer.parseInt(idDocente) + "')";
            s.executeUpdate(query);
            System.out.println(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public String[] CargarAntecedentes(String id){
         String [] lista = new String[11];
        try {
           
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from AntLaborales where id_docente="+id;
            System.out.println(query);
            rs = s.executeQuery(query);
            antecedentesLaborales ant = new antecedentesLaborales();
             while (rs.next()) {
              lista[0] = rs.getString("id");
                lista[1] =rs.getString("profesion");              
                lista[2] =rs.getString("licenciatura");
                
                lista[3] =rs.getString("diplomado");
                lista[4] =rs.getString("magister");
                lista[5] =rs.getString("mba");
                lista[6] =rs.getString("doctorado");
                lista[7] =rs.getString("experienciaLab");
                lista[8] =rs.getString("experienciaDoc");
                lista[9] =rs.getString("cursoPad");
                lista[10] =rs.getString("id_docente");
                

               
                //Usuario us = new Usuario(id, username, rut, tipo, nombre, apellidoP, apellidoM, correo, telefono,password);
                //System.out.println(username);
                //lista.add(us);
            }
            System.out.println(lista[1]);
               
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
       return lista;
    }
    
    

    public DefaultTableModel BuscarConsulta(String param, String tipo) {

        try {
            switch (tipo) {

                case "Nombre":
                    cn = Conexion.Enlace(cn);
                    Statement s = cn.createStatement();
                    String query = "select * from AntPersonales where nombre like '" + param + "'";
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

                    s.close();
                    return modelo;

                case "Rut":
                    cn = Conexion.Enlace(cn);
                    s = cn.createStatement();
                    query = "select * from AntPersonales where rut like '" + param + "'";
                    rs = s.executeQuery(query);
                    rsmd = rs.getMetaData();
                    //obtenemos numero de columnas 
                    CanColumns = rsmd.getColumnCount();
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

                    s.close();
                    return modelo;

                case "Apellido Paterno":
                    cn = Conexion.Enlace(cn);
                    s = cn.createStatement();
                    query = "select * from AntPersonales where apellidoP like '" + param + "'";
                    rs = s.executeQuery(query);
                    rsmd = rs.getMetaData();
                    //obtenemos numero de columnas 
                    CanColumns = rsmd.getColumnCount();
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

                    s.close();
                    return modelo;

                default:
                    return null;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

    public void EliminarConsulta(String id) {
        try {
            Statement s = cn.createStatement();
            String query = "DELETE FROM AntLaborales WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ModificarConsulta(String profesion, String licenciatura, String diplomado, String magister, String mba, String doctorado, String experienciaDoc, String experienciaLab, String cursoPad, String id) {
        try {
            Statement s = cn.createStatement();
            String query = "UPDATE AntLaborales SET profesion='" + profesion + "',licenciatura='" + licenciatura + "',diplomado='" + diplomado + "',magister='" + magister + "',mba='" + mba + "',doctorado='" + doctorado + "',experienciaDoc='" + experienciaDoc + "',experienciaLab='" + experienciaLab + "',cursoPad='" + cursoPad + "' WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
