
package com.cartelle.modelo;

public class ConsultaEvaluacion {

    private String codigoarea;
    private String codigopuesto;
    private String tipoevaluacion;
    private String fechaevaluacion;
    private int idPuesto;
    private int idArea;
    

    public ConsultaEvaluacion( String codigoarea, String codigopuesto,  String tipoevaluacion, String fechaevaluacion, int idPuesto, int idArea) {

        this.codigoarea = codigoarea;
        this.codigopuesto = codigopuesto;
        this.tipoevaluacion = tipoevaluacion;
        this.fechaevaluacion = fechaevaluacion;
        this.idPuesto = idPuesto;
        this.idArea = idArea;

    }

    public ConsultaEvaluacion() {
    }
    

    public String getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(String codigoarea) {
        this.codigoarea = codigoarea;
    }

    public String getCodigopuesto() {
        return codigopuesto;
    }

    public void setCodigopuesto(String codigopuesto) {
        this.codigopuesto = codigopuesto;
    }

    public String getTipoevaluacion() {
        return tipoevaluacion;
    }

    public void setTipoevaluacion(String tipoevaluacion) {
        this.tipoevaluacion = tipoevaluacion;
    }

    public String getFechaevaluacion() {
        return fechaevaluacion;
    }

    public void setFechaevaluacion(String fechaevaluacion) {
        this.fechaevaluacion = fechaevaluacion;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }
    
    
  
}