/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;


public class Usuario {
    
    private int id;
    private String username;
    private String rut;
    private int type;
    private String password;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String correo;
    private String telefono;

    public Usuario(int id, String username, String rut, int type, String nombre, String apellidoP, String apellidoM, String correo, String telefono,String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rut = rut;
        this.type = type;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Usuario(){
        
    }
    
    
            
    
}
