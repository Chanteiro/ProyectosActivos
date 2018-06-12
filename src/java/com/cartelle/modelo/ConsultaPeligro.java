
package com.cartelle.modelo;

public class ConsultaPeligro {

    private String codArea;
    private String nombre;
    private String codPuesto;
    private String puesto;
    private int idArea;
    private int idPuesto;
    private int idEvaluacionPuesto;
    private String nIntervencion;
    private String factorRiesgo;

    public ConsultaPeligro(String codArea, String nombre, String codPuesto, String puesto, int idArea, int idPuesto, int idEvaluacionPuesto, String nIntervencion, String factorRiesgo) {
        this.codArea = codArea;
        this.nombre = nombre;
        this.codPuesto = codPuesto;
        this.puesto = puesto;
        this.idArea = idArea;
        this.idPuesto = idPuesto;
        this.idEvaluacionPuesto = idEvaluacionPuesto;
        this.nIntervencion = nIntervencion;
        this.factorRiesgo = factorRiesgo;
    }

    public ConsultaPeligro(int idArea, int idPuesto) {
        this.idArea = idArea;
        this.idPuesto = idPuesto;
    }
   

    public ConsultaPeligro() {
    }

    public ConsultaPeligro(ConsultaPeligro d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(String codPuesto) {
        this.codPuesto = codPuesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdEvaluacionPuesto() {
        return idEvaluacionPuesto;
    }

    public void setIdEvaluacionPuesto(int idEvaluacionPuesto) {
        this.idEvaluacionPuesto = idEvaluacionPuesto;
    }

    public String getnIntervencion() {
        return nIntervencion;
    }

    public void setnIntervencion(String nIntervencion) {
        this.nIntervencion = nIntervencion;
    }

    public String getFactorRiesgo() {
        return factorRiesgo;
    }

    public void setFactorRiesgo(String factorRiesgo) {
        this.factorRiesgo = factorRiesgo;
    }

    @Override
    public String toString() {
        return "ConsultaPeligro{" + "codArea=" + codArea + ", nombre=" + nombre + ", codPuesto=" + codPuesto + ", puesto=" + puesto + ", idArea=" + idArea + ", idPuesto=" + idPuesto + ", idEvaluacionPuesto=" + idEvaluacionPuesto + ", nIntervencion=" + nIntervencion + ", factorRiesgo=" + factorRiesgo + '}';
    }
    
    

 
    
    
}