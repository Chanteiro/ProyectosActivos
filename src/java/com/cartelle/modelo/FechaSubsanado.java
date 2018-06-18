
package com.cartelle.modelo;


public class FechaSubsanado {
    private String fechaSubsanado;
    private int idEvaluacionPuesto;
    private int idEvaluacionArea;

    public FechaSubsanado(String fechaSubsanado, int idEvaluacionPuesto) {
        this.fechaSubsanado = fechaSubsanado;
        this.idEvaluacionPuesto = idEvaluacionPuesto;
    }
   
    public FechaSubsanado() {
    }

    public String getFechaSubsanado() {
        return fechaSubsanado;
    }

    public void setFechaSubsanado(String fechaSubsanado) {
        this.fechaSubsanado = fechaSubsanado;
    }

    public int getIdEvaluacionPuesto() {
        return idEvaluacionPuesto;
    }

    public void setIdEvaluacionPuesto(int idEvaluacionPuesto) {
        this.idEvaluacionPuesto = idEvaluacionPuesto;
    }

    public int getIdEvaluacionArea() {
        return idEvaluacionArea;
    }

    public void setIdEvaluacionArea(int idEvaluacionArea) {
        this.idEvaluacionArea = idEvaluacionArea;
    }
    
    
}
