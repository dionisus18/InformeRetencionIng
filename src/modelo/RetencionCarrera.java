/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kevin
 */
public class RetencionCarrera {
    int idCarrera;
    String nombre;
    int idRetencion;
    float porcentaje;
    int idRetencionCarrera;
    int año;

    public RetencionCarrera(int idCarrera, String nombre, int idRetencion, float porcentaje, int idRetencionCarrera, int año) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.idRetencion = idRetencion;
        this.porcentaje = porcentaje;
        this.idRetencionCarrera = idRetencionCarrera;
        this.año = año;
    }

    public RetencionCarrera() {
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdRetencion() {
        return idRetencion;
    }

    public void setIdRetencion(int idRetencion) {
        this.idRetencion = idRetencion;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getIdRetencionCarrera() {
        return idRetencionCarrera;
    }

    public void setIdRetencionCarrera(int idRetencionCarrera) {
        this.idRetencionCarrera = idRetencionCarrera;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    
}
