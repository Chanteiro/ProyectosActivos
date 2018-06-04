package com.cartelle.modelo;

import java.util.Date;

/**
 *
 * @author ANTONIO
 */
public class Puestos {

    private int idPuesto;
    private String codArea;
    private String codPuesto;
    private Date fechaTomaDatos;
    private String puesto;
    private String observaciones;
    private String tareasRealizadas;
    private String equiposTrabajo;
    private int productosQuimicosFK;
    private String trabajadoresCondicionEspecial;
    private String medidasPreventivasExistentes;
    private String observacionesMedidasPreventivas;
    private int idArea;
    private int luz;
    private int ruido;
    private int temp;

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

    public Date getFechaTomaDatos() {
        return fechaTomaDatos;
    }

    public void setFechaTomaDatos(Date fechaTomaDatos) {
        this.fechaTomaDatos = fechaTomaDatos;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTareasRealizadas() {
        return tareasRealizadas;
    }

    public void setTareasRealizadas(String tareasRealizadas) {
        this.tareasRealizadas = tareasRealizadas;
    }

    public String getEquiposTrabajo() {
        return equiposTrabajo;
    }

    public void setEquiposTrabajo(String equiposTrabajo) {
        this.equiposTrabajo = equiposTrabajo;
    }

    public int getProductosQuimicosFK() {
        return productosQuimicosFK;
    }

    public void setProductosQuimicosFK(int productosQuimicosFK) {
        this.productosQuimicosFK = productosQuimicosFK;
    }

    public String getTrabajadoresCondicionEspecial() {
        return trabajadoresCondicionEspecial;
    }

    public void setTrabajadoresCondicionEspecial(String trabajadoresCondicionEspecial) {
        this.trabajadoresCondicionEspecial = trabajadoresCondicionEspecial;
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

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getLuz() {
        return luz;
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public int getRuido() {
        return ruido;
    }

    public void setRuido(int ruido) {
        this.ruido = ruido;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

}
