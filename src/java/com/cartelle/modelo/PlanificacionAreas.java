
package com.cartelle.modelo;

public class PlanificacionAreas {
    private int idEvaluacionArea;
    private int idAreaFK;
    private String codArea;
    private String codPeligroFK;
    private String prioridad;
    private String factorRiesgo;
    private String normativa;
    private String medidaPropuesta;
    private String fechaSubsanado;

    public PlanificacionAreas(int idEvaluacionArea, int idAreaFK, String codArea, String codPeligroFK, String prioridad, String factorRiesgo, String normativa, String medidaPropuesta, String fechaSubsanado) {
        this.idEvaluacionArea = idEvaluacionArea;
        this.idAreaFK = idAreaFK;
        this.codArea = codArea;
        this.codPeligroFK = codPeligroFK;
        this.prioridad = prioridad;
        this.factorRiesgo = factorRiesgo;
        this.normativa = normativa;
        this.medidaPropuesta = medidaPropuesta;
        this.fechaSubsanado = fechaSubsanado;
    }

  

    public PlanificacionAreas() {
    }

    public int getIdEvaluacionArea() {
        return idEvaluacionArea;
    }

    public void setIdEvaluacionArea(int idEvaluacionArea) {
        this.idEvaluacionArea = idEvaluacionArea;
    }

    public int getIdAreaFK() {
        return idAreaFK;
    }

    public void setIdAreaFK(int idAreaFK) {
        this.idAreaFK = idAreaFK;
    }

    public String getCodPeligroFK() {
        return codPeligroFK;
    }

    public void setCodPeligroFK(String codPeligroFK) {
        this.codPeligroFK = codPeligroFK;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getFactorRiesgo() {
        return factorRiesgo;
    }

    public void setFactorRiesgo(String factorRiesgo) {
        this.factorRiesgo = factorRiesgo;
    }

    public String getNormativa() {
        return normativa;
    }

    public void setNormativa(String normativa) {
        this.normativa = normativa;
    }

    public String getMedidaPropuesta() {
        return medidaPropuesta;
    }

    public void setMedidaPropuesta(String medidaPropuesta) {
        this.medidaPropuesta = medidaPropuesta;
    }

    public String getFechaSubsanado() {
        return fechaSubsanado;
    }

    public void setFechaSubsanado(String fechaSubsanado) {
        this.fechaSubsanado = fechaSubsanado;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }
    
            
}
