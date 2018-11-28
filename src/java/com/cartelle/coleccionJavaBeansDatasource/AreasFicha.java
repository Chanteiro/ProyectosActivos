
package com.cartelle.coleccionJavaBeansDatasource;

import java.util.Date;

/**
 *
 * @author ANTONIO
 */
public class AreasFicha {
    private String codArea;
    private String nombreArea;
    private Date fechaTomaDatos;
    private String tipoEvaluacion;
    private String observaciones;
    private String descripcion;
    private Integer superficie;
    private String actividades;
    private String instalaciones;
    private String instalacionesPeligrosidad;
    private String medidasPreventivas;
    private String observacionesMedidas;
    private String rampas_de_circulacion;
    private String circulacion_interior;
    private String escaleras_fijas;
    private String escaleras_mano;
    private String almacenamiento_altura;
    private String conducciones_fluidos_presion;
    private String calderas;
    private String depositos_presion;
    private String botellas_presion;
    private String cintas_transportadoras;
    private String ascensores_montacargas;
    private String plataformas_elevadoras;
    private String gruas_polipastos;
    private String carretillas_elevadoras;
    private String area_carga_baterias;
    private String extintores;
    private String bie;
    private String deteccion_incendios;
    private String otros;

    public AreasFicha() {
    }

    public AreasFicha(String codArea, String nombreArea, Date fechaTomaDatos, String tipoEvaluacion, String observaciones, String descripcion, Integer superficie, String actividades, String instalaciones, String instalacionesPeligrosidad, String medidasPreventivas, String observacionesMedidas, String rampas_de_circulacion, String circulacion_interior, String escaleras_fijas, String escaleras_mano, String almacenamiento_altura, String conducciones_fluidos_presion, String calderas, String depositos_presion, String botellas_presion, String cintas_transportadoras, String ascensores_montacargas, String plataformas_elevadoras, String gruas_polipastos, String carretillas_elevadoras, String area_carga_baterias, String extintores, String bie, String deteccion_incendios, String otros) {
        this.codArea = codArea;
        this.nombreArea = nombreArea;
        this.fechaTomaDatos = fechaTomaDatos;
        this.tipoEvaluacion = tipoEvaluacion;
        this.observaciones = observaciones;
        this.descripcion = descripcion;
        this.superficie = superficie;
        this.actividades = actividades;
        this.instalaciones = instalaciones;
        this.instalacionesPeligrosidad = instalacionesPeligrosidad;
        this.medidasPreventivas = medidasPreventivas;
        this.observacionesMedidas = observacionesMedidas;
        this.rampas_de_circulacion = rampas_de_circulacion;
        this.circulacion_interior = circulacion_interior;
        this.escaleras_fijas = escaleras_fijas;
        this.escaleras_mano = escaleras_mano;
        this.almacenamiento_altura = almacenamiento_altura;
        this.conducciones_fluidos_presion = conducciones_fluidos_presion;
        this.calderas = calderas;
        this.depositos_presion = depositos_presion;
        this.botellas_presion = botellas_presion;
        this.cintas_transportadoras = cintas_transportadoras;
        this.ascensores_montacargas = ascensores_montacargas;
        this.plataformas_elevadoras = plataformas_elevadoras;
        this.gruas_polipastos = gruas_polipastos;
        this.carretillas_elevadoras = carretillas_elevadoras;
        this.area_carga_baterias = area_carga_baterias;
        this.extintores = extintores;
        this.bie = bie;
        this.deteccion_incendios = deteccion_incendios;
        this.otros = otros;
    }

    
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public Date getFechaTomaDatos() {
        return fechaTomaDatos;
    }

    public void setFechaTomaDatos(Date fechaTomaDatos) {
        this.fechaTomaDatos = fechaTomaDatos;
    }

    public String getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public void setTipoEvaluacion(String tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public void setSuperficie(Integer superficie) {
        this.superficie = superficie;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(String instalaciones) {
        this.instalaciones = instalaciones;
    }

    public String getInstalacionesPeligrosidad() {
        return instalacionesPeligrosidad;
    }

    public void setInstalacionesPeligrosidad(String instalacionesPeligrosidad) {
        this.instalacionesPeligrosidad = instalacionesPeligrosidad;
    }

    public String getMedidasPreventivas() {
        return medidasPreventivas;
    }

    public void setMedidasPreventivas(String medidasPreventivas) {
        this.medidasPreventivas = medidasPreventivas;
    }

    public String getObservacionesMedidas() {
        return observacionesMedidas;
    }

    public void setObservacionesMedidas(String observacionesMedidas) {
        this.observacionesMedidas = observacionesMedidas;
    }

    public String getRampas_de_circulacion() {
        return rampas_de_circulacion;
    }

    public void setRampas_de_circulacion(String rampas_de_circulacion) {
        this.rampas_de_circulacion = rampas_de_circulacion;
    }

    public String getCirculacion_interior() {
        return circulacion_interior;
    }

    public void setCirculacion_interior(String circulacion_interior) {
        this.circulacion_interior = circulacion_interior;
    }

    public String getEscaleras_fijas() {
        return escaleras_fijas;
    }

    public void setEscaleras_fijas(String escaleras_fijas) {
        this.escaleras_fijas = escaleras_fijas;
    }

    public String getEscaleras_mano() {
        return escaleras_mano;
    }

    public void setEscaleras_mano(String escaleras_mano) {
        this.escaleras_mano = escaleras_mano;
    }

    public String getAlmacenamiento_altura() {
        return almacenamiento_altura;
    }

    public void setAlmacenamiento_altura(String almacenamiento_altura) {
        this.almacenamiento_altura = almacenamiento_altura;
    }

    public String getConducciones_fluidos_presion() {
        return conducciones_fluidos_presion;
    }

    public void setConducciones_fluidos_presion(String conducciones_fluidos_presion) {
        this.conducciones_fluidos_presion = conducciones_fluidos_presion;
    }

    public String getCalderas() {
        return calderas;
    }

    public void setCalderas(String calderas) {
        this.calderas = calderas;
    }

    public String getDepositos_presion() {
        return depositos_presion;
    }

    public void setDepositos_presion(String depositos_presion) {
        this.depositos_presion = depositos_presion;
    }

    public String getBotellas_presion() {
        return botellas_presion;
    }

    public void setBotellas_presion(String botellas_presion) {
        this.botellas_presion = botellas_presion;
    }

    public String getCintas_transportadoras() {
        return cintas_transportadoras;
    }

    public void setCintas_transportadoras(String cintas_transportadoras) {
        this.cintas_transportadoras = cintas_transportadoras;
    }

    public String getAscensores_montacargas() {
        return ascensores_montacargas;
    }

    public void setAscensores_montacargas(String ascensores_montacargas) {
        this.ascensores_montacargas = ascensores_montacargas;
    }

    public String getPlataformas_elevadoras() {
        return plataformas_elevadoras;
    }

    public void setPlataformas_elevadoras(String plataformas_elevadoras) {
        this.plataformas_elevadoras = plataformas_elevadoras;
    }

    public String getGruas_polipastos() {
        return gruas_polipastos;
    }

    public void setGruas_polipastos(String gruas_polipastos) {
        this.gruas_polipastos = gruas_polipastos;
    }

    public String getCarretillas_elevadoras() {
        return carretillas_elevadoras;
    }

    public void setCarretillas_elevadoras(String carretillas_elevadoras) {
        this.carretillas_elevadoras = carretillas_elevadoras;
    }

    public String getArea_carga_baterias() {
        return area_carga_baterias;
    }

    public void setArea_carga_baterias(String area_carga_baterias) {
        this.area_carga_baterias = area_carga_baterias;
    }

    public String getExtintores() {
        return extintores;
    }

    public void setExtintores(String extintores) {
        this.extintores = extintores;
    }

    public String getBie() {
        return bie;
    }

    public void setBie(String bie) {
        this.bie = bie;
    }

    public String getDeteccion_incendios() {
        return deteccion_incendios;
    }

    public void setDeteccion_incendios(String deteccion_incendios) {
        this.deteccion_incendios = deteccion_incendios;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }
    
    
}
