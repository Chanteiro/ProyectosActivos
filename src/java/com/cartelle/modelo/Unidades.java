
package com.cartelle.modelo;

/**
 *
 * @author ANTONIO
 */
public class Unidades {
    private int idUnidad;
    private String unidad;
    private String ciu;
    private String servicioPrevencion;
    private String organoAsesoramiento;

    public Unidades() {
    }

    public Unidades(int idUnidad, String unidad, String ciu, String servicioPrevencion, String organoAsesoramiento) {
        this.idUnidad = idUnidad;
        this.unidad = unidad;
        this.ciu = ciu;
        this.servicioPrevencion = servicioPrevencion;
        this.organoAsesoramiento = organoAsesoramiento;
    }

    public String getOrganoAsesoramiento() {
        return organoAsesoramiento;
    }

    public void setOrganoAsesoramiento(String organoAsesoramiento) {
        this.organoAsesoramiento = organoAsesoramiento;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCiu() {
        return ciu;
    }

    public void setCiu(String ciu) {
        this.ciu = ciu;
    }

    public String getServicioPrevencion() {
        return servicioPrevencion;
    }

    public void setServicioPrevencion(String servicioPrevencion) {
        this.servicioPrevencion = servicioPrevencion;
    }

    @Override
    public String toString() {
        return "Unidades{" + "idUnidad=" + idUnidad + ", unidad=" + unidad + ", ciu=" + ciu + ", servicioPrevencion=" + servicioPrevencion + ", organoAsesoramiento=" + organoAsesoramiento + '}';
    }
    
}
