
package com.cartelle.modelo;

import java.util.Date;

/**
 *
 * @author admin
 */
public class EvaluacionesArea {
   
    private int idEvaluacionArea;
    private int idAreaFK;
    private int nDeficiencia;
    private int nExposicion;
    private int nProbabilidad;
    private int nConsecuencias;
    private int nRiesgo;
    private int codPeligroFK;
    private String nIntervencion;
    private String tipoEvaluacion;
    private Date fechaEvaluacion;
    private String factorRiesgo;
    private String normativa;
    private String medidaPropuesta;
    private String nombreArea;
    private String codArea;

    public int getCodPeligroFK() {
        return codPeligroFK;
    }

    public void setCodPeligroFK(int codPeligroFK) {
        this.codPeligroFK = codPeligroFK;
    }
   
    public int getIdEvaluacionArea() {
        return idEvaluacionArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public int getIdAreaFK() {
        return idAreaFK;
    }

    public void setIdAreaFK(int idAreaFK) {
        this.idAreaFK = idAreaFK;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public void setIdEvaluacionArea(int idEvaluacionArea) {
        this.idEvaluacionArea = idEvaluacionArea;
    }

    public int getnDeficiencia() {
        return nDeficiencia;
    }

    public void setnDeficiencia(int nDeficiencia) {
        this.nDeficiencia = nDeficiencia;
    }

    public int getnExposicion() {
        return nExposicion;
    }

    public void setnExposicion(int nExposicion) {
        this.nExposicion = nExposicion;
    }

    public int getnProbabilidad() {
        return nProbabilidad;
    }

    public void setnProbabilidad(int nProbabilidad) {
        this.nProbabilidad = nProbabilidad;
    }

    public int getnConsecuencias() {
        return nConsecuencias;
    }

    public void setnConsecuencias(int nConsecuencias) {
        this.nConsecuencias = nConsecuencias;
    }

    public int getnRiesgo() {
        return nRiesgo;
    }

    public void setnRiesgo(int nRiesgo) {
        this.nRiesgo = nRiesgo;
    }

    public String getnIntervencion() {
        return nIntervencion;
    }

    public void setnIntervencion(String nIntervencion) {
        this.nIntervencion = nIntervencion;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public Date getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(Date fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
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
   
    
   
}
