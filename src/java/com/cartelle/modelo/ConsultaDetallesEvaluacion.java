
package com.cartelle.modelo;


public class ConsultaDetallesEvaluacion {
    
    private int idEvaluacionPuesto;
    private String deficiencia;
    private String exposicion;
    private String probabilidad;
    private String consecuencias;
    private String riesgo;
    private String intervencion;
    private String tipoevaluacion;
    private String fechaevaluacion;
    private String factorriesgo;
    private String medidas;
    private String normativa;
    private String codigoarea;
    private String nombre;
    private String codigopuesto;
    private String puesto;
    private int idArea;
    private int idPuesto;
    private int codPeligro;

    public ConsultaDetallesEvaluacion(int idEvaluacionPuesto, String deficiencia, String exposicion, String probabilidad, String consecuencias, String riesgo, String intervencion, String tipoevaluacion, String fechaevaluacion, String factorriesgo, String medidas, String normativa, String codigoarea, String nombre, String codigopuesto, String puesto, int idArea, int idPuesto, int codPeligro) {
        this.idEvaluacionPuesto = idEvaluacionPuesto;
        this.deficiencia = deficiencia;
        this.exposicion = exposicion;
        this.probabilidad = probabilidad;
        this.consecuencias = consecuencias;
        this.riesgo = riesgo;
        this.intervencion = intervencion;
        this.tipoevaluacion = tipoevaluacion;
        this.fechaevaluacion = fechaevaluacion;
        this.factorriesgo = factorriesgo;
        this.medidas = medidas;
        this.normativa = normativa;
        this.codigoarea = codigoarea;
        this.nombre = nombre;
        this.codigopuesto = codigopuesto;
        this.puesto = puesto;
        this.idArea = idArea;
        this.idPuesto = idPuesto;
        this.codPeligro = codPeligro;
    }
   
    

    public ConsultaDetallesEvaluacion() {
    }

    public ConsultaDetallesEvaluacion(int idArea, int idEvaluacionPuesto) {
        this.idArea = idArea;
        this.idEvaluacionPuesto = idEvaluacionPuesto;
        
    }


    

    public int getIdEvaluacionPuesto() {
        return idEvaluacionPuesto;
    }

    public ConsultaDetallesEvaluacion(int idEvaluacionPuesto) {
        this.idEvaluacionPuesto = idEvaluacionPuesto;
    }
    

    public void setIdEvaluacionPuesto(int idEvaluacionPuesto) {
        this.idEvaluacionPuesto = idEvaluacionPuesto;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getExposicion() {
        return exposicion;
    }

    public void setExposicion(String exposicion) {
        this.exposicion = exposicion;
    }

    public String getProbabilidad() {
        return probabilidad;
    }

    public void setProbabilidad(String probabilidad) {
        this.probabilidad = probabilidad;
    }

    public String getConsecuencias() {
        return consecuencias;
    }

    public void setConsecuencias(String consecuencias) {
        this.consecuencias = consecuencias;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getIntervencion() {
        return intervencion;
    }

    public void setIntervencion(String intervencion) {
        this.intervencion = intervencion;
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

    public String getFactorriesgo() {
        return factorriesgo;
    }

    public void setFactorriesgo(String factorriesgo) {
        this.factorriesgo = factorriesgo;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public String getNormativa() {
        return normativa;
    }

    public void setNormativa(String normativa) {
        this.normativa = normativa;
    }

    public String getCodigoarea() {
        return codigoarea;
    }

    public void setCodigoarea(String codigoarea) {
        this.codigoarea = codigoarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigopuesto() {
        return codigopuesto;
    }

    public void setCodigopuesto(String codigopuesto) {
        this.codigopuesto = codigopuesto;
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

    public int getCodPeligro() {
        return codPeligro;
    }

    public void setCodPeligro(int codPeligro) {
        this.codPeligro = codPeligro;
    }
      
}
