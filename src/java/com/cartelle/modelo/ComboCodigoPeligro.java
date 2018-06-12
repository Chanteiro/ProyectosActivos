
package com.cartelle.modelo;

public class ComboCodigoPeligro {
    private int idCodigo;
    private String codPeligro;

    public ComboCodigoPeligro(int idCodigo, String codPeligro) {
        this.idCodigo = idCodigo;
        this.codPeligro = codPeligro;
    }

    public ComboCodigoPeligro() {
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getCodPeligro() {
        return codPeligro;
    }

    public void setCodPeligro(String codPeligro) {
        this.codPeligro = codPeligro;
    }
    
}
