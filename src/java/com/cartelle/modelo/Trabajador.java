
package com.cartelle.modelo;

/**
 *
 * @author ANTONIO
 */
public class Trabajador {
    private int id;
    private String nombre;
    private String empleo;
    private String codTrabajador;
    private String puesto;
    private int puestoFK;
    private String area;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public String getCodTrabajador() {
        return codTrabajador;
    }

    public void setCodTrabajador(String codTrabajador) {
        this.codTrabajador = codTrabajador;
    }

    public int getPuestoFK() {
        return puestoFK;
    }

    public void setPuestoFK(int puestoFK) {
        this.puestoFK = puestoFK;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
}
