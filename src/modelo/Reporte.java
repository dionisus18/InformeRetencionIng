/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author YAC
 */
public class Reporte {
    private int id;
    private Date fechaReporte;
    private String responsable;
    private String jefeArea;
    private int idAspecto;
    private String jornada;
    
    public Reporte(int id, Date fechaReporte,String responsable, String jefeArea, int idAspecto,String jornada){
        
      this.id=id;
      this.fechaReporte=fechaReporte;
      this.responsable=responsable;
      this.jefeArea=jefeArea;
      this.idAspecto=idAspecto;
      this.jornada=jornada;
      
        
    }
    
    public Reporte(){
        
    }
}
