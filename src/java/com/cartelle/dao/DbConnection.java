package com.cartelle.dao;

import com.cartelle.modelo.Area;
import com.cartelle.modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
//            initContext = new InitialContext();
//            datasource = (DataSource) initContext.lookup("java:comp/env/jdbc/AccesoDB");
            InitialContext ctx = new InitialContext();
            Context env = (Context) ctx.lookup("java:comp/env");
            datasource = (DataSource) env.lookup("jdbc/AccesoDB");
        } catch (NamingException ex) {
            System.out.println("Problemas en el acceso al recurso");
            ex.printStackTrace();
        }
    }

    public Usuario comprobarUsuario(String user, String pass) {
//        boolean resultado = false;
        Usuario usu = new Usuario();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "SELECT idLogin,nombreCompleto, rol, usuario, contrasena FROM LOGIN WHERE usuario='"
                    + user + "' and contrasena='" + pass + "';";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                usu.setId(rs.getInt("idLogin"));
                usu.setNombre(rs.getString("nombreCompleto"));
                usu.setRol(rs.getString("rol"));

            }
            return usu;
        } catch (Exception e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
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
        return usu;
    }

    public List<Area> obtenerAreas() {
        List<Area> areas = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
           
            String sql = "select * from areas_trabajo where unidadFK=442;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                 Area a = new Area(0);
                a.setId(rs.getInt("idArea"));
                a.setCodArea(rs.getString("codArea").trim());
                a.setNombre(rs.getString("nombre").trim());
                 a.setFechaTomaDatos(rs.getDate("fechaTomaDatos"));
                  a.setObservacionesArea(rs.getString("observacionesArea").trim());
                  a.setDescripcion(rs.getString("descripcion").trim());
                  a.setSuperficie(rs.getInt("superficie"));
                  a.setActividadesRealizadas(rs.getString("actividadesRealizadas").trim());
                  a.setInstalacionesExistentes(rs.getString("instalacionesExistentes").trim());
                  a.setMedidasPreventivasExistentes(rs.getString("medidasPreventivasExistentes").trim());
                  a.setObservacionesMedidasPreventivas(rs.getString("observacionesMedidasPreventivas").trim());
                  a.setUnidadFK(rs.getInt("unidadFK"));
                  a.setFichaInstalacionesFK(rs.getInt("ficha_instalacionFK"));
                  a.setCertificadoFK(rs.getInt("certificadoFK"));
                areas.add(a);
            }
            return areas;
        } catch (Exception e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
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

        return areas;
    }
}
