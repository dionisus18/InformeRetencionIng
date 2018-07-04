
package modelo;


public class RetencionArea {
    int idArea;
    String nombre;
    int idRetencion;
    float porcentaje;
    int idRetencionArea;
    int año;

    public RetencionArea(int idArea, String nombre, int idRetencion, float porcentaje, int idRetencionArea, int año) {
        this.idArea = idArea;
        this.nombre = nombre;
        this.idRetencion = idRetencion;
        this.porcentaje = porcentaje;
        this.idRetencionArea = idRetencionArea;
        this.año = año;
    }

    public RetencionArea() {
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
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

    public int getIdRetencionArea() {
        return idRetencionArea;
    }

    public void setIdRetencionArea(int idRetencionArea) {
        this.idRetencionArea = idRetencionArea;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
    
    
    
    
    
}
