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
import modelo.antDocente;
import java.util.ArrayList;

/**
 *
 * @author Lenovo-W530
 */
public class CrudAntDocente {
    static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo = new DefaultTableModel();
    //creamos la operacion para mostrar datos en una jtable en el jform
    
        public DefaultTableModel lista() {

        try {
            cn = Conexion.Enlace(cn);
            Statement s = cn.createStatement();
            //consuta a mostrar
            String query = "select * from AntDocente";
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
    
            //creamos metodo para insertar datos
    public DefaultTableModel BuscarConsulta(String param, String tipo) {

        try {
            switch (tipo) {

                case "Nombre":
                    cn = Conexion.Enlace(cn);
                    Statement s = cn.createStatement();
                    String query = "select * from AntDocente where nombre like '%" + param + "';";
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
                    query = "select * from AntDocente where rut like '" + param + "';";
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
                    query = "select * from AntDocente where apellidoP like '" + param + "';";
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
        
    public void BuscarDocenteID(String id){
        
    }
    
    //creamos metodo para insertar datos
    public void AgregarConsulta(String rut, String nombre, String apellidoP, String apellidoM, String fechaNac, String numeroTel ,String direccion,String correo,String añoIng, String inicioCon, String terminoCon) {
        //dentro de try cacht por si los errores
        try {
            Statement s = cn.createStatement();                                                                                                                                                                                            //ME FALTA ALGO ACÁ "','"
            String query = "INSERT INTO AntDocente(rut,nombre,apellidoP,apellidoM,fechaNac,numeroTel,direccion,correo,añoIng,iniCon,terCon)values ('" + rut + "','" + nombre + "','" + apellidoP + "','" + apellidoM + "','" + fechaNac + "','" + numeroTel + "','" + direccion + "','" + correo + "','" + añoIng + "','" + inicioCon + "','" + terminoCon + "')";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "AGREGADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
        //CREAMOS METODO PARA ELIMINAR DATOS

    public void EliminarConsulta(String id) {
        try {
            Statement s = cn.createStatement();
            String query = "DELETE FROM AntDocente WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "ELIMINADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    //creamos metodo para modificar datos

    public void ModificarConsulta(String rut, String nombre, String apellidoP, String apellidoM, String fechaNac, String numeroTel, String direccion, String correo, String añoIng, String inicioCon, String terminoCon, String id) {
        try {
            Statement s = cn.createStatement();
            String query = "UPDATE AntDocente SET rut='" + rut + "',nombre='" + nombre + "',apellidoP='" + apellidoP + "',apellidoM='" + apellidoM + "',fechaNac='" + fechaNac + "',numeroTel='" + numeroTel + "',direccion='" + direccion + "',correo='" + correo + "',añoIng='" + añoIng + "',iniCon='" + inicioCon + "',terCon='" + terminoCon + "' WHERE id=" + id + "";
            s.executeUpdate(query);
            s.close();
            cn.close();
            JOptionPane.showMessageDialog(null, "MODIFICADO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
}
