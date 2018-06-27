
package informeRetencion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Conexion;


public class CrudReporte {
     static Connection cn;
    static Statement s;
    static ResultSet rs;
    DefaultTableModel modelo= new DefaultTableModel();
  //creamos la operacion para mostrar datos en una jtable en el jform
    public DefaultTableModel lista(){
        
    try{
    cn = Conexion.Enlace(cn);
    Statement s= cn.createStatement();
    //consuta a mostrar
    String query = "select * from Reporte";
    rs = s.executeQuery(query);
   ResultSetMetaData rsmd=rs.getMetaData();
   //obtenemos numero de columnas 
   int CanColumns = rsmd.getColumnCount();
    //comprobamos 
   for(int i=1;i<=CanColumns;i++){
       //cargamos columnas en modelo
   modelo.addColumn(rsmd.getColumnLabel(i));
   }
   while (rs.next()){
   //creamos array 
       Object[] fila=new Object[CanColumns];
   //cargamos datos a modelo
   for(int i=0;i<CanColumns;i++){
   fila[i] = rs.getObject(i+1);
   }
   modelo.addRow(fila);
   }
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    //retornamos modelo para jtable
    return modelo;
    
    }
    
    //creamos metodo para insertar datos
 /*   public String  BuscarConsulta(String rut){
        try{
            
            Statement s = cn.createStatement();
           String query ="select * from AntPersonales where rut like '"+rut+"'";
           s.executeUpdate(query);
           s.close();
           rut = query;
           return rut;
           
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
       return null;
    }
     */
  /*  public void buscarConsulta(String rut){
        try{
            Statement s = cn.createStatement();
            String query ="select * from AntPersonales where rut like '"+rut+"'";
            s.executeUpdate(query);
            
            while (rs.next()) {
                int id = rs.getInt("id");
            
                String username = rs.getString("username");
              //  String password = rs.getString("password");
                int tipo = rs.getInt("type");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String run = rs.getString("rut");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                
                //lista[0]=nombre+" "+apellidoP+" "+apellidoM;
               // lista[1]= rut;
                //lista[2]= String.valueOf(tipo);
                //Usuario us = new Usuario(id, username, rut, tipo, nombre, apellidoP, apellidoM, correo, telefono,password);
                //System.out.println(username);
                //lista.add(us);
            }
           
           
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
        */
 /*   public static String[] BuscarDocente(String run) {
    
           cn = Conexion.Enlace(cn);
            String[] lista=new String[10];
            String query ="SELECT id,rut,nombre,apellidoP,apellidoM,fechaNac,direccion,tipoContrato,añoIngresoInacap,correo FROM AntPersonales; ";
           
                try{
                    s =cn.createStatement();
                    rs = s.executeQuery(query);
                    while (rs.next()) {
                int id = rs.getInt("id");
                String rut = rs.getString("rut");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String fechaNac = rs.getString("fechaNac");
                String direccion = rs.getString("direccion");
                int tipoContrato = rs.getInt("tipoContrato");
                int añoIngresoInacap = rs.getInt("añoIngresoInacap");
                String correo = rs.getString("correo");
                
              lista[0]=String.valueOf(id);
              lista[1]=rut;
              lista[2]=nombre;
              lista[3]=apellidoP;
              lista[4]=apellidoM;
              lista[5]=fechaNac;
              lista[6]=direccion;
              lista[7]=String.valueOf(tipoContrato);
              lista[8]=String.valueOf(añoIngresoInacap);
              lista[9]=correo;

             
                        
                    }
                    return lista;
           // JOptionPane.showMessageDialog(null, "ENCONTRADO CON EXITO");
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
                return lista;
    }*/
    public void AgregarReporte(String id,String fechaReporte, String Responsable,String jefeArea, String idAspecto,String jornada){
        
    //dentro de try cacht por si los errores
        try{
        Statement s=cn.createStatement();
        String query = "INSERT INTO Reporte (id,fechaReporte,responsable,jefeArea,idAspecto,jornada) VALUES ('"+id+"','"+fechaReporte+"','"+Responsable+"','"+jefeArea+"','"+idAspecto+"','"+jornada+"')";
        s.executeUpdate(query);
        s.close();
        cn.close();
        JOptionPane.showMessageDialog(null, "AGREGADO");
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
        //CREAMOS METODO PARA ELIMINAR DATOS
        public void EliminarReporte(String id){
       try{
       Statement s=cn.createStatement();
       String query="DELETE FROM Reporte WHERE id="+id+"";
       s.executeUpdate(query);
       s.close();
       cn.close();
       JOptionPane.showMessageDialog(null, "ELIMINADO");
       }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
        }
        //creamos metodo para modificar datos
        public void ModificarReporte(String fechaReporte, String responsable, String jefeArea,String idAspecto,String jornada, String id ){
        try{
        Statement s=cn.createStatement();
        String query="UPDATE Reporte SET  fechaReporte='"+fechaReporte+"',responsable='"+responsable+"',jefeArea='"+jefeArea+"',idAspecto='"+idAspecto+"', jornada='"+jornada+"' WHERE id="+id+" AND fechaReporte='"+fechaReporte+"'AND responsable='"+responsable+"' AND jefeArea='"+jefeArea+"' AND idAspecto ='"+idAspecto+"'AND jornada='"+jornada+"' ";
        s.executeUpdate(query);
        s.close();
        cn.close();
        JOptionPane.showMessageDialog(null, "MODIFICADO");
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
        
        }
        
}
