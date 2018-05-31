package com.cartelle.modelo;

/**
 *
 * @author ANTONIO
 */
public class LoginAdmin {

    private String nombrecompleto;
    private String contrasena;
    private String usuario;
    private String rol;
    private int idLogin;

    public LoginAdmin(int idLogin, String nombrecompleto, String contrasena, String usuario, String rol) {
        this.nombrecompleto = nombrecompleto;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.idLogin = idLogin;
        this.rol = rol;
    }

    public LoginAdmin(int idLogin) {
        this.idLogin = idLogin;
    }

    public LoginAdmin() {
    }

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

}
