
package com.cartelle.modelo;

import java.util.Date;
import java.util.List;

public class Area {
   private int id;
   private String codArea;
   private String nombre;
   private Date fechaTomaDatos;
   private String fechaUltimaEvaluacion;
   private String observacionesArea;
   private String descripcion;
   private int superficie;
   private String actividadesRealizadas;
   private String instalacionesExistentes;
   private String medidasPreventivasExistentes;
   private String observacionesMedidasPreventivas;
   private int unidadFK;
   private int fichaInstalacionesFK;
   private int certificadoFK;
   private List<Zona_medicion> zonas;
    public Area(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaUltimaEvaluacion() {
        return fechaUltimaEvaluacion;
    }

    public void setFechaUltimaEvaluacion(String fechaUltimaEvaluacion) {
        this.fechaUltimaEvaluacion = fechaUltimaEvaluacion;
    }

   
   
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public Date getFechaTomaDatos() {
        return fechaTomaDatos;
    }

    public void setFechaTomaDatos(Date fechaTomaDatos) {
        this.fechaTomaDatos = fechaTomaDatos;
    }

    public String getObservacionesArea() {
        return observacionesArea;
    }

    public void setObservacionesArea(String observacionesArea) {
        this.observacionesArea = observacionesArea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public String getActividadesRealizadas() {
        return actividadesRealizadas;
    }

    public void setActividadesRealizadas(String actividadesRealizadas) {
        this.actividadesRealizadas = actividadesRealizadas;
    }

    public String getInstalacionesExistentes() {
        return instalacionesExistentes;
    }

    public void setInstalacionesExistentes(String instalacionesExistentes) {
        this.instalacionesExistentes = instalacionesExistentes;
    }

    public String getMedidasPreventivasExistentes() {
        return medidasPreventivasExistentes;
    }

    public void setMedidasPreventivasExistentes(String medidasPreventivasExistentes) {
        this.medidasPreventivasExistentes = medidasPreventivasExistentes;
    }

    public String getObservacionesMedidasPreventivas() {
        return observacionesMedidasPreventivas;
    }

    public void setObservacionesMedidasPreventivas(String observacionesMedidasPreventivas) {
        this.observacionesMedidasPreventivas = observacionesMedidasPreventivas;
    }

    public int getUnidadFK() {
        return unidadFK;
    }

    public void setUnidadFK(int unidadFK) {
        this.unidadFK = unidadFK;
    }

    public int getFichaInstalacionesFK() {
        return fichaInstalacionesFK;
    }

    public void setFichaInstalacionesFK(int fichaInstalacionesFK) {
        this.fichaInstalacionesFK = fichaInstalacionesFK;
    }

    public int getCertificadoFK() {
        return certificadoFK;
    }

    public void setCertificadoFK(int certificadoFK) {
        this.certificadoFK = certificadoFK;
    }

    public List<Zona_medicion> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zona_medicion> zonas) {
        this.zonas = zonas;
    }
   
   
}
