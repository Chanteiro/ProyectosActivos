package com.cartelle.dao;

import com.cartelle.modelo.Area;
import com.cartelle.modelo.FichaInstalaciones;
import com.cartelle.modelo.LoginAdmin;
import com.cartelle.modelo.Noticia;
import com.cartelle.modelo.Puestos;
import com.cartelle.modelo.Trabajador;
import com.cartelle.modelo.Usuario;
import com.cartelle.modelo.Zona_medicion;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            
            String sql = "select * from zonas_medicion where AreaFK=" + id + ";";
            rs = st.executeQuery(sql);
            List<Zona_medicion> lista = new ArrayList();
            while (rs.next()) {
                Zona_medicion zona = new Zona_medicion();
                zona.setLuz(rs.getInt("luz"));
                zona.setRuido(rs.getInt("ruido"));
                zona.setTemp(rs.getInt("temp"));
                zona.setNombre(rs.getString("nombre_zona"));
                zona.setDescripcion(rs.getString("descripción"));
                zona.setIdZona(rs.getInt("idZona"));
                zona.setIdAreaFK(rs.getInt("areaFK"));
                lista.add(zona);
                
            }
            
            sql = "select * from areas_trabajo where unidadFK=442 and idArea=" + id + ";";
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
            a.setZonas(lista);
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
                p.setLuz(rs.getInt("medicion_luz"));
                p.setRuido(rs.getInt("medicion_ruido"));
                p.setTemp(rs.getInt("medicion_temp"));
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
                    + " medicion_luz, medicion_ruido, medicion_temp,"
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
                p.setLuz(rs.getInt("medicion_luz"));
                p.setRuido(rs.getInt("medicion_ruido"));
                p.setTemp(rs.getInt("medicion_temp"));
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
    
    public LoginAdmin getLoginAdminById(int idLogin) {
        LoginAdmin logo = new LoginAdmin(0);
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            
            String sql = "select * from LOGIN where idLogin=" + idLogin + ";";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                logo.setIdLogin(rs.getInt("idLogin"));
                logo.setContrasena(rs.getString("contrasena").trim());
                logo.setNombrecompleto(rs.getString("nombreCompleto").trim());
                logo.setUsuario(rs.getString("usuario"));
                logo.setRol(rs.getString("rol").trim());
                
            }
            return logo;
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
        
        return logo;
    }
    
    public ArrayList<LoginAdmin> buscar(String sql) {
        ArrayList<LoginAdmin> lista = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                lista.add(new LoginAdmin(rs.getInt("idLogin"), rs.getString("nombreCompleto"), rs.getString("contrasena"), rs.getString("usuario"), rs.getString("rol")));
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
        }
        return lista;
    }
    
    public ArrayList<String> buscarRol() {
        ArrayList<String> roles = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "select distinct rol from login; ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                roles.add(rs.getString("rol"));
            }
            return roles;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
        }
        return roles;
    }
    
    public boolean insertaUsuario(Usuario u) {
        try {
            String sql = "insert into login values(?,?,?,?); ";
            cn = datasource.getConnection();
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getPassword());
            pst.setString(4, u.getRol());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return false;
        }
        
    }
    
    public int nuevaZona(Zona_medicion z){
         try {
            String sql = "insert into zonas_medicion values(?,?,?,?,?,?); ";
            cn = datasource.getConnection();
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, z.getLuz());
            pst.setInt(2, z.getRuido());
            pst.setInt(3, z.getTemp());
            pst.setString(4, z.getNombre());
            pst.setString(5, z.getDescripcion());
            pst.setInt(6, z.getIdAreaFK());
            int rows=pst.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return 0;
        }
    }
    
    public int borraUsuario(int id) {
        try {
            cn = datasource.getConnection();
            String sql = "delete from login where idLogin=?; ";
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
    
    public int actualizaUsuario(Usuario user, int id) {
        try {
            cn = datasource.getConnection();
            String sql = "update login set nombreCompleto=?,usuario=?, contrasena=?, rol=? where idLogin=?; ";
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, user.getNombre());
            pst.setString(2, user.getUsername());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getRol());
            pst.setInt(5, id);
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
    
     public int actualizaZona(Zona_medicion z) {
        try {
            cn = datasource.getConnection();
            String sql = "update Zonas_medicion set nombre_zona=?,descripción=?, luz=?, ruido=?, temp=? where idZona=?; ";
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, z.getNombre());
            pst.setString(2, z.getDescripcion());
            pst.setInt(3, z.getLuz());
            pst.setInt(4, z.getRuido());
            pst.setInt(5, z.getTemp());
            pst.setInt(6, z.getIdZona());
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
     
     public int borraZona(int id) {
        try {
            cn = datasource.getConnection();
            String sql = "delete from Zonas_medicion where idZona=?; ";
            pst = cn.prepareStatement(sql);
            
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
    
    public Noticia getNoticia() {
        Noticia n = new Noticia();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "select * from noticia; ";
            rs = st.executeQuery(sql);
            while (rs.next()) {
//                String tit = rs.getString("titulo");
//                byte ptext[] = tit.getBytes();
//                String titulo = new String(ptext, "UTF-8");
                n.setId(rs.getInt("idNoticia"));
                n.setTitulo(rs.getString("titulo"));
                n.setContenido(rs.getString("contenido"));
            }
            System.out.println(n.getTitulo());
            return n;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
        }
        
        return n;
        
    }
    
    public int actualizaNoticia(String titulo, String contenido, int id) {
        try {
            cn = datasource.getConnection();
            String sql = "update noticia set titulo=?,contenido=? where idNoticia=?; ";
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, titulo);
            pst.setString(2, contenido);
            pst.setInt(3, id);
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
    
    public int actualizaArea(Area a, int id) {
        try {
            cn = datasource.getConnection();
            String sql = "update areas_trabajo set fechaTomaDatos=?,observacionesArea=?, descripcion=?, superficie=?,"
                    + " actividadesRealizadas=?, instalacionesExistentes=?, medidasPreventivasExistentes=?,"
                    + " observacionesMedidasPreventivas=? where idArea=?; ";
            pst = cn.prepareStatement(sql);
            java.util.Date fecha = a.getFechaTomaDatos();
            java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
            pst.setDate(1, fecha2);
            pst.setString(2, a.getObservacionesArea());
            pst.setString(3, a.getDescripcion());
            pst.setInt(4, a.getSuperficie());
            pst.setString(5, a.getActividadesRealizadas());
            pst.setString(6, a.getInstalacionesExistentes());
            pst.setString(7, a.getMedidasPreventivasExistentes());
            pst.setString(8, a.getObservacionesMedidasPreventivas());
            pst.setInt(9, a.getId());
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
    
    public int actualizaFicha(FichaInstalaciones f, int id) {
        try {
            cn = datasource.getConnection();
            String sql = "update ficha_instalaciones set rampas_de_circulacion=?,circulacion_interior=?, escaleras_fijas=?,"
                    + " escaleras_mano=?, almacenamiento_altura=?,conducciones_fluidos_presion=?, calderas=?,"
                    + " depositos_presion=?, botellas_presion=?, cintas_transportadoras=?,"
                    + " ascensores_montacargas=?, plataformas_elevadoras=?, gruas_polipastros=?, carretillas_elevadoras=?,"
                    + " area_carga_baterias=?, extintores=?, bie=?, deteccion_incendios=?, otros=?"
                    + "  where idFicha=?; ";
            pst = cn.prepareStatement(sql);
            
            pst.setString(1, f.getRampas_de_circulacion());
            pst.setString(2, f.getCirculacion_interior());
            pst.setString(3, f.getEscaleras_fijas());
            pst.setString(4, f.getEscaleras_mano());
            pst.setString(5, f.getAlmacenamiento_altura());
            pst.setString(6, f.getConducciones_fluidos_presion());
            pst.setString(7, f.getCalderas());
            pst.setString(8, f.getDepositos_presion());
            pst.setString(9, f.getBotellas_presion());
            pst.setString(10, f.getCintas_transportadoras());
            pst.setString(11, f.getAscensores_montacargas());
            pst.setString(12, f.getPlataformas_elevadoras());
            pst.setString(13, f.getGruas_polipastos());
            pst.setString(14, f.getCarretillas_elevadoras());
            pst.setString(15, f.getArea_carga_baterias());
            pst.setString(16, f.getExtintores());
            pst.setString(17, f.getBie());
            pst.setString(18, f.getDeteccion_incendios());
            pst.setString(19, f.getOtros());
            pst.setInt(20, f.getIdFicha());
            
            int rows = pst.executeUpdate();
            return rows;
            
        } catch (SQLException ex) {
            System.out.println("Error borrando" + ex);
            return 0;
        }
        
    }
    
    public FichaInstalaciones getFichabyId(int id) {
        FichaInstalaciones fi = new FichaInstalaciones();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "select codArea, nombre,idFicha,rampas_de_circulacion,circulacion_interior, escaleras_fijas,"
                    + " escaleras_mano, almacenamiento_altura, conducciones_fluidos_presion, calderas, "
                    + "depositos_presion, botellas_presion, cintas_transportadoras, ascensores_montacargas, "
                    + "plataformas_elevadoras, gruas_polipastros, carretillas_elevadoras, area_carga_baterias, "
                    + "extintores, bie, deteccion_incendios, otros "
                    + "from FICHA_INSTALACIONES "
                    + "inner join AREAS_TRABAJO on FICHA_INSTALACIONES.idFicha=AREAS_TRABAJO.ficha_instalacionFK "
                    + "where AREAS_TRABAJO.idArea=" + id + ";";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
//                String texto;
                fi.setCodArea(rs.getString("codArea"));
                fi.setNombreArea(rs.getString("nombre"));
                fi.setIdFicha(rs.getInt("idFicha"));
                fi.setRampas_de_circulacion(rs.getString("rampas_de_circulacion"));
                fi.setCirculacion_interior(rs.getString("circulacion_interior"));
                fi.setEscaleras_fijas(rs.getString("escaleras_fijas"));
                fi.setEscaleras_mano(rs.getString("escaleras_mano"));
                fi.setAlmacenamiento_altura(rs.getString("almacenamiento_altura"));
                fi.setConducciones_fluidos_presion(rs.getString("conducciones_fluidos_presion"));
                fi.setCalderas(rs.getString("calderas"));
                fi.setDepositos_presion(rs.getString("depositos_presion"));
                fi.setBotellas_presion(rs.getString("botellas_presion"));
                fi.setCintas_transportadoras(rs.getString("cintas_transportadoras"));
                fi.setAscensores_montacargas(rs.getString("ascensores_montacargas"));
                fi.setPlataformas_elevadoras(rs.getString("plataformas_elevadoras"));
                fi.setGruas_polipastos(rs.getString("gruas_polipastros"));
                fi.setCarretillas_elevadoras(rs.getString("carretillas_elevadoras"));
                fi.setArea_carga_baterias(rs.getString("area_carga_baterias"));
                fi.setExtintores(rs.getString("extintores"));
                fi.setBie(rs.getString("bie"));
                fi.setDeteccion_incendios(rs.getString("deteccion_incendios"));
                fi.setOtros(rs.getString("otros"));
                
            }
            return fi;
        } catch (Exception e) {
            System.out.println("No se pudo conectar");
            System.out.println(e.getMessage());
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
        
        return fi;
    }

//    public int actualizaNoticia(Noticia noti, int id) {
//        try {
//            cn = datasource.getConnection();
//            String sql = "update noticias set titulo=?,contenido=? where id=?; ";
//            pst = cn.prepareStatement(sql);
//
//            pst.setString(1,noti.getTitulo());
//            pst.setString(2, noti.getContenido());
//            pst.setInt(3, id);
//            int rows = pst.executeUpdate();
//            return rows;
//
//        } catch (SQLException ex) {
//            System.out.println("Error borrando" + ex);
//            return 0;
//        }
//
//    }
}
