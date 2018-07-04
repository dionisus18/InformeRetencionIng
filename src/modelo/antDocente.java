/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



public class antDocente {
    
private int id;
private String rut;
private String nombre;
private String apellidoP;
private String apellidoM;
private String fechaNac;
private String numeroTel;
private String direccion;
private String correo;
private String añoIng;
private String inicioCon;
private String terminoCon;

public antDocente() {
    
}

    public antDocente(int id, String rut, String nombre, String apellidoP, String apellidoM, String fechaNac, String numeroTel, String direccion, String correo, String añoIng, String inicioCon, String terminoCon) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNac = fechaNac;
        this.numeroTel = numeroTel;
        this.direccion = direccion;
        this.correo = correo;
        this.añoIng = añoIng;
        this.inicioCon = inicioCon;
        this.terminoCon = terminoCon;
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

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAñoIng() {
        return añoIng;
    }

    public void setAñoIng(String añoIng) {
        this.añoIng = añoIng;
    }

    public String getInicioCon() {
        return inicioCon;
    }

    public void setInicioCon(String inicioCon) {
        this.inicioCon = inicioCon;
    }

    public String getTerminoCon() {
        return terminoCon;
    }

    public void setTerminoCon(String terminoCon) {
        this.terminoCon = terminoCon;
    }



}
