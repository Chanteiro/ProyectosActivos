
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
    private int puestoFK;

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
    
}
