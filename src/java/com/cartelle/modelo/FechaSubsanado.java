
package com.cartelle.modelo;


public class FechaSubsanado {
    private String fechaSubsanado;
    private int idEvaluacionPuesto;
    private int idEvaluacionArea;
    private String subsanador;

    public FechaSubsanado(String fechaSubsanado, int idEvaluacionPuesto, String subsanador) {
        this.fechaSubsanado = fechaSubsanado;
        this.idEvaluacionPuesto = idEvaluacionPuesto;
        this.subsanador= subsanador;
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

    public String getSubsanador() {
        return subsanador;
    }

    public void setSubsanador(String subsanador) {
        this.subsanador = subsanador;
    }
    
    
    
}
