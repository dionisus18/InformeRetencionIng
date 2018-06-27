/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author snahu
 */
public class AntPerson {
    
    private int id;
    private String rut;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String fechaNac;
    private String direccion;
    private int tipoContrato;
    private int añoIngresoInacap;
    private String correo;

    public AntPerson() {
    }

    public AntPerson(int id, String rut, String nombre, String apellidoP, String apellidoM, String fechaNac, String direccion, int tipoContrato, int añoIngresoInacap, String correo) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.tipoContrato = tipoContrato;
        this.añoIngresoInacap = añoIngresoInacap;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(int tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public int getAñoIngresoInacap() {
        return añoIngresoInacap;
    }

    public void setAñoIngresoInacap(int añoIngresoInacap) {
        this.añoIngresoInacap = añoIngresoInacap;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
}
