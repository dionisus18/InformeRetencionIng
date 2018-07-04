/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PC
 */
public class Antecedente {
    private int id;
    private String profesion;
    private String diplomado;
    private String magister;
    private String mba;
    private String doctorado;
    private String experienciaDoc;
    private String experienciaLab;
    private String cursoPad;
    private String areaPerteneciente;

    
public Antecedente () {
    
}

    public Antecedente(int id, String profesion, String diplomado, String magister, String mba, String doctorado, String experienciaDoc, String experienciaLab, String cursoPad, String areaPerteneciente) {
        this.id = id;
        this.profesion = profesion;
        this.diplomado = diplomado;
        this.magister = magister;
        this.mba = mba;
        this.doctorado = doctorado;
        this.experienciaDoc = experienciaDoc;
        this.experienciaLab = experienciaLab;
        this.cursoPad = cursoPad;
        this.areaPerteneciente = areaPerteneciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getDiplomado() {
        return diplomado;
    }

    public void setDiplomado(String diplomado) {
        this.diplomado = diplomado;
    }

    public String getMagister() {
        return magister;
    }

    public void setMagister(String magister) {
        this.magister = magister;
    }

    public String getMba() {
        return mba;
    }

    public void setMba(String mba) {
        this.mba = mba;
    }

    public String getDoctorado() {
        return doctorado;
    }

    public void setDoctorado(String doctorado) {
        this.doctorado = doctorado;
    }

    public String getExperienciaDoc() {
        return experienciaDoc;
    }

    public void setExperienciaDoc(String experienciaDoc) {
        this.experienciaDoc = experienciaDoc;
    }

    public String getExperienciaLab() {
        return experienciaLab;
    }

    public void setExperienciaLab(String experienciaLab) {
        this.experienciaLab = experienciaLab;
    }

    public String getCursoPad() {
        return cursoPad;
    }

    public void setCursoPad(String cursoPad) {
        this.cursoPad = cursoPad;
    }

    public String getAreaPerteneciente() {
        return areaPerteneciente;
    }

    public void setAreaPerteneciente(String areaPerteneciente) {
        this.areaPerteneciente = areaPerteneciente;
    }


    

}