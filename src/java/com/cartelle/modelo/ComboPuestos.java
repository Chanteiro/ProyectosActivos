
package com.cartelle.modelo;

public class ComboPuestos {
    private int idPuesto;
    private String codPuesto;
    private String nombre;

    public ComboPuestos(int idPuesto, String codPuesto, String nombre) {
        this.idPuesto = idPuesto;
        this.codPuesto = codPuesto;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


//    public ComboPuestos() {
//    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(String codPuesto) {
        this.codPuesto = codPuesto;
    }

   
    
}
