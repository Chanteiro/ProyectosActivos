
package com.cartelle.modelo;

/**
 *
 * @author ANTONIO
 */
public class Zona_medicion {
    private float luz;
    private float ruido;
    private float temp;
    private String nombre;
    private String descripcion;
    private int idAreaFK;
    private int idZona;

    public float getLuz() {
        return luz;
    }

    public void setLuz(float luz) {
        this.luz = luz;
    }

    public float getRuido() {
        return ruido;
    }

    public void setRuido(float ruido) {
        this.ruido = ruido;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
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
