
package com.cartelle.modelo;


public class ComboAreas {
  private int idArea;
  private String codArea;


    public ComboAreas(int idArea, String codArea) {
        this.idArea = idArea;
        this.codArea = codArea;

    }

    public ComboAreas() {
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getCodArea() {
        return codArea;
    }

    public void setCodArea(String codArea) {
        this.codArea = codArea;
    } 
}
