package com.cartelle.dao;

import com.cartelle.modelo.Area;
import com.cartelle.modelo.Puestos;
import com.cartelle.modelo.Trabajador;
import com.cartelle.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    PreparedStatement pst = null;
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
//                a.setFechaUltimaEvaluacion(rs.getString("fechaEvaluacion"));
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

    public List<Trabajador> obtenerTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "SELECT  idTrabajador,codigoTrabajador,empleo, trabajadores.nombre, puestos_trabajo.puesto FROM dbo.TRABAJADORES inner join puestos_trabajo "
                    + "on trabajadores.puestoTrabajoFK=puestos_trabajo.idPuesto "
                    + "inner join area_puesto on puestos_trabajo.idPuesto=area_puesto.idPuesto "
                    + "inner join areas_trabajo on areas_trabajo.idArea=area_puesto.idArea "
                    + "where unidadFK=442 "
                    + "order by codigoTrabajador;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Trabajador t = new Trabajador();
                t.setId(rs.getInt("idTrabajador"));
                t.setCodTrabajador(rs.getString("codigoTrabajador"));
                t.setNombre(rs.getString("nombre"));
                t.setEmpleo(rs.getString("empleo"));
                t.setPuesto(rs.getString("puesto"));
                trabajadores.add(t);
            }
            return trabajadores;
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

        return trabajadores;
    }

    public Area getAreabyId(int id) {
        Area a = new Area(0);
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select * from areas_trabajo where unidadFK=442 and idArea=" + id + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {

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

            }
            return a;
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

        return a;
    }

    public Trabajador getTrabajadorbyId(int id) {
        Trabajador t = new Trabajador();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "SELECT  idTrabajador,codigoTrabajador,empleo, trabajadores.nombre, puestos_trabajo.puesto, areas_trabajo.nombre as area "
                    + "FROM dbo.TRABAJADORES inner join puestos_trabajo "
                    + "on trabajadores.puestoTrabajoFK=puestos_trabajo.idPuesto "
                    + "inner join area_puesto on puestos_trabajo.idPuesto=area_puesto.idPuesto "
                    + "inner join areas_trabajo on areas_trabajo.idArea=area_puesto.idArea "
                    + "where idTrabajador=" + id + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                    t.setId(rs.getInt("idTrabajador"));
                    t.setCodTrabajador(rs.getString("codigoTrabajador"));
                    t.setEmpleo(rs.getString("empleo"));
                    t.setNombre(rs.getString("nombre"));
                    t.setPuesto(rs.getString("puesto"));
                    t.setArea(rs.getString("area"));
            }
            return t;
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

        return t;
    }

    public Puestos getPuestobyId(int id) {
        Puestos p = new Puestos();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select * from puestos_trabajo where idPuesto=" + id + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                p.setIdPuesto(rs.getInt("idPuesto"));
                p.setPuesto(rs.getString("puesto"));
                p.setCodPuesto(rs.getString("codPuesto"));
                p.setFechaTomaDatos(rs.getDate("fechaTomaDatos"));
                p.setObservaciones(rs.getString("observaciones"));
                p.setTareasRealizadas(rs.getString("tareasRealizadas"));
                p.setEquiposTrabajo(rs.getString("equiposTrabajo"));
                p.setProductosQuimicosFK(rs.getInt("productosQuimicosFK"));
                p.setTrabajadoresCondicionEspecial(rs.getString("trabajadoresCondicionEspecial"));
                p.setMedidasPreventivasExistentes(rs.getString("medidasPreventivasExistentes"));
                p.setObservacionesMedidasPreventivas(rs.getString("observacionesmedidasPreventivas"));

            }
            return p;
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

        return p;
    }

    public List<Puestos> obtenerPuestos() {
        List<Puestos> puestos = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "Select puestos_trabajo.idPuesto,codPuesto, puesto, puestos_trabajo.fechaTomaDatos,observaciones,tareasRealizadas,"
                    + "equiposTrabajo, productosQuimicosFK,trabajadoresCondicionEspecial,"
                    + "puestos_trabajo.medidasPreventivasExistentes, puestos_trabajo.observacionesmedidasPreventivas,"
                    + " codArea, areas_trabajo.idArea "
                    + "from puestos_trabajo inner join area_puesto on area_puesto.idPuesto=puestos_trabajo.idPuesto "
                    + "inner join areas_trabajo on areas_trabajo.idArea=area_puesto.idArea where unidadFK=442 "
                    + "order by codPuesto;";

            rs = st.executeQuery(sql);
            while (rs.next()) {
                Puestos p = new Puestos();
                p.setIdPuesto(rs.getInt("idPuesto"));
                p.setCodArea(rs.getString("codArea"));
                p.setPuesto(rs.getString("puesto"));
                p.setCodPuesto(rs.getString("codPuesto"));
                p.setFechaTomaDatos(rs.getDate("fechaTomaDatos"));
                p.setObservaciones(rs.getString("observaciones"));
                p.setTareasRealizadas(rs.getString("tareasRealizadas"));
                p.setEquiposTrabajo(rs.getString("equiposTrabajo"));
                p.setProductosQuimicosFK(rs.getInt("productosQuimicosFK"));
                p.setTrabajadoresCondicionEspecial(rs.getString("trabajadoresCondicionEspecial"));
                p.setMedidasPreventivasExistentes(rs.getString("medidasPreventivasExistentes"));
                p.setObservacionesMedidasPreventivas(rs.getString("observacionesmedidasPreventivas"));
                p.setIdArea(rs.getInt("idArea"));

                puestos.add(p);
            }
            return puestos;
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

        return puestos;
    }
}
