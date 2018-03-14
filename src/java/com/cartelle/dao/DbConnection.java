package com.cartelle.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author ANTONIO
 */
public class DbConnection {

    Context initContext;
    DataSource datasource = null;
    Connection cn = null;
    Statement st = null;
    ResultSet rs = null;

    public DbConnection() {
        try {
            initContext = new InitialContext();
            datasource = (DataSource) initContext.lookup("java:comp/env/jdbc/AccesoDB");
        } catch (NamingException ex) {
            System.out.println("Problemas en el acceso al recurso");
            ex.printStackTrace();
        }
    }

    public boolean comprobarUsuario(String user, String pass) {
        boolean resultado = false;

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "SELECT nombre, rol, usuario, pass FROM LOGIN WHERE usuario='"
                    + user + "' and pass='" + pass + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                resultado = true;
            }
            return resultado;
        } catch (Exception e) {
            System.out.println("No se pudo conectar");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    System.out.println("Error (" + ex.getErrorCode() + "): " + ex.getMessage());
                }
            }

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    System.out.println("Error (" + ex.getErrorCode() + "): " + ex.getMessage());
                }
            }

            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println("Error (" + ex.getErrorCode() + "): " + ex.getMessage());
                }
            }

        }
        return resultado;
    }
}
