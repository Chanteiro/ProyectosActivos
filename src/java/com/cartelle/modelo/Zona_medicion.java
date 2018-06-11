
package com.cartelle.modelo;

/**
 *
 * @author ANTONIO
 */
public class Zona_medicion {
    private int luz;
    private int ruido;
    private int temp;
    private String nombre;
    private String descripcion;
    private int idAreaFK;
    private int idZona;

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdAreaFK() {
        return idAreaFK;
    }

    public void setIdAreaFK(int idAreaFK) {
        this.idAreaFK = idAreaFK;
    }

    public int getIdZona() {
        return idZona;
    }

    public void setIdZona(int idZona) {
        this.idZona = idZona;
    }

    @Override
    public String toString() {
        return "Zona_medicion{" + "luz=" + luz + ", ruido=" + ruido + ", temp=" + temp + ", nombre=" + nombre + ", descripcion=" + descripcion + ", idAreaFK=" + idAreaFK + ", idZona=" + idZona + '}';
    }
    
    
}
