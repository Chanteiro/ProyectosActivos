package com.cartelle.modelo;

import com.cartelle.dao.DbConnection;
import java.util.List;

/**
 *
 * @author ANTONIO CARTELLE CASAS
 */
public class Usuario {

    private int id;
    private String nombre;
    private String rol;
    private String username;
    private String password;
    private List<Unidades> unidades;
    

   

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario validate() {

        DbConnection conexion=new DbConnection();
       return conexion.comprobarUsuario(this.getUsername(),this.getPassword());
    }

    public List<Unidades> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidades> unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", rol=" + rol + ", username=" + username + ", password=" + password + ", unidades=" + unidades + '}';
    }

  

}
