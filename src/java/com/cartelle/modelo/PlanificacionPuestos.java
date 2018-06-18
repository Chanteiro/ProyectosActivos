
package com.cartelle.modelo;

public class PlanificacionPuestos {
    private int idArea;
    private int idPuesto;
    private int idEvaluacionPuestos;
    private String codArea;
    private String codPuesto;
    private String codPeligroFK;
    private String factorRiesgo;
    private String prioridad;
    private String normativa;
    private String medidasPropuestas;
    private String fechaSubsanado;

    public PlanificacionPuestos(int idArea, int idPuesto, int idEvaluacionPuestos, String codArea, String codPuesto, String codPeligroFK, String factorRiesgo, String prioridad, String normativa, String medidasPropuestas, String fechaSubsanado) {
        this.idArea = idArea;
        this.idPuesto = idPuesto;
        this.idEvaluacionPuestos = idEvaluacionPuestos;
        this.codArea = codArea;
        this.codPuesto = codPuesto;
        this.codPeligroFK = codPeligroFK;
        this.factorRiesgo = factorRiesgo;
        this.prioridad = prioridad;
        this.normativa = normativa;
        this.medidasPropuestas = medidasPropuestas;
        this.fechaSubsanado = fechaSubsanado;
    }



    public PlanificacionPuestos() {
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

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(String codPuesto) {
        this.codPuesto = codPuesto;
    }

    public String getCodPeligroFK() {
        return codPeligroFK;
    }

    public void setCodPeligroFK(String codPeligroFK) {
        this.codPeligroFK = codPeligroFK;
    }

    public String getFactorRiesgo() {
        return factorRiesgo;
    }

    public void setFactorRiesgo(String factorRiesgo) {
        this.factorRiesgo = factorRiesgo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getNormativa() {
        return normativa;
    }

    public void setNormativa(String normativa) {
        this.normativa = normativa;
    }

    public String getMedidasPropuestas() {
        return medidasPropuestas;
    }

    public void setMedidasPropuestas(String medidasPropuestas) {
        this.medidasPropuestas = medidasPropuestas;
    }


    public int getIdEvaluacionPuestos() {
        return idEvaluacionPuestos;
    }

    public void setIdEvaluacionPuestos(int idEvaluacionPuestos) {
        this.idEvaluacionPuestos = idEvaluacionPuestos;
    }

    public String getFechaSubsanado() {
        return fechaSubsanado;
    }

    public void setFechaSubsanado(String fechaSubsanado) {
        this.fechaSubsanado = fechaSubsanado;
    }
    
    
    
}
