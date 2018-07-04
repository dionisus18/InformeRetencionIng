/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author edgar
 */
public class justificacion {
    
    private int id_justificacion;
    private String nombre;
    private String horario;
    private String seccion; 
    private String jornada;
    private String incidente;
    private String comentario;

    public justificacion(int id_justificacion, String nombre, String horario, String seccion, String jornada, String incidente, String comentario) {
        this.id_justificacion = id_justificacion;
        this.nombre = nombre;
        this.horario = horario;
        this.seccion = seccion;
        this.jornada = jornada;
        this.incidente = incidente;
        this.comentario = comentario;
    }

    public justificacion() {
    }

    public int getId_justificacion() {
        return id_justificacion;
    }

    public void setId_justificacion(int id_justificacion) {
        this.id_justificacion = id_justificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getIncidente() {
        return incidente;
    }

    public void setIncidente(String incidente) {
        this.incidente = incidente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    
    
    
    
    
}
