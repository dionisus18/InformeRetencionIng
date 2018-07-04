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
public class Carrera {
    int idCarrera;
    String nombre;
    String codigo;
    int areaIdArea;

    public Carrera(int idCarrera, String nombre, String codigo, int areaIdArea) {
        this.idCarrera = idCarrera;
        this.nombre = nombre;
        this.codigo = codigo;
        this.areaIdArea = areaIdArea;
    }

    public Carrera() {
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getAreaIdArea() {
        return areaIdArea;
    }

    public void setAreaIdArea(int areaIdArea) {
        this.areaIdArea = areaIdArea;
    }
    
    
    
}
