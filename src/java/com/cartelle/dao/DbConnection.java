package com.cartelle.dao;

import com.cartelle.coleccionJavaBeansDatasource.AreasFicha;
import com.cartelle.modelo.Area;
import com.cartelle.modelo.ComboAreas;
import com.cartelle.modelo.ComboCodigoPeligro;
import com.cartelle.modelo.ComboPuestos;
import com.cartelle.modelo.ConsultaDetallesEvaluacion;
import com.cartelle.modelo.ConsultaEvaluacion;
import com.cartelle.modelo.ConsultaPeligro;
import com.cartelle.modelo.EvaluacionesArea;
import com.cartelle.modelo.FechaSubsanado;
import com.cartelle.modelo.FichaInstalaciones;
import com.cartelle.modelo.LoginAdmin;
import com.cartelle.modelo.Noticia;
import com.cartelle.modelo.PlanificacionAreas;
import com.cartelle.modelo.PlanificacionPuestos;
import com.cartelle.modelo.Puestos;
import com.cartelle.modelo.Trabajador;
import com.cartelle.modelo.Usuario;
import com.cartelle.modelo.Zona_medicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            InitialContext ctx = new InitialContext();
            Context env = (Context) ctx.lookup("java:comp/env");
            datasource = (DataSource) env.lookup("jdbc/AccesoDB");
//            datasource = (DataSource) env.lookup("jdbc/AccesoDBLocal");
        } catch (NamingException ex) {
            System.out.println("Problemas en el acceso al recurso");
            ex.printStackTrace();
        }
    }

    public Connection obtenerConexion(){
        try {
            cn = datasource.getConnection();
            return cn;
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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

    public List<AreasFicha> obtenerAreasFicha() {
        List<AreasFicha> areasFicha = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select codArea,nombre, fechaTomaDatos, convert(varchar(max),observacionesArea)AS OBSERVACIONES, convert(varchar(max),descripcion) AS DESCRIPCION ,\n"
                    + " superficie, convert(varchar(max),actividadesRealizadas)AS ACTIVIDADES, \n"
                    + " convert(varchar(max),instalacionesExistentes)AS INSTALACIONES ,convert(varchar(max),medidasPreventivasExistentes)AS MPE ,\n"
                    + " convert(varchar(max),observacionesMedidasPreventivas)AS OMP,convert(varchar(max),rampas_de_circulacion)AS RAMPAS ,\n"
                    + " convert(varchar(max),circulacion_interior)AS CI, convert(varchar(max),escaleras_fijas)AS EFIJAS ,\n"
                    + " convert(varchar(max),escaleras_mano)AS EMANO, convert(varchar(max),almacenamiento_altura)AS ALTURA,\n"
                    + " convert(varchar(max),conducciones_fluidos_presion)AS CFP, convert(varchar(max),calderas)AS CALDERAS,\n"
                    + " convert(varchar(max),depositos_presion) AS DEPOSITOS, convert(varchar(max),botellas_presion)AS BOTELLAS ,\n"
                    + " convert(varchar(max),cintas_transportadoras)AS CINTAS ,convert(varchar(max),ascensores_montacargas)AS ASCENSORES ,\n"
                    + " convert(varchar(max),plataformas_elevadoras)AS PLATAFORMAS ,convert(varchar(max),gruas_polipastros)AS GRUAS,\n"
                    + " convert(varchar(max),carretillas_elevadoras) AS CARRETILLAS,convert(varchar(max),area_carga_baterias)AS BATERIAS ,\n"
                    + " convert(varchar(max),extintores)AS EXTINTORES ,convert(varchar(max),bie)AS BIE,convert(varchar(max),deteccion_incendios)AS DINCENDIOS ,\n"
                    + " convert(varchar(max),otros)AS OTROS , tipoEvaluacion\n"
                    + " from areas_trabajo\n"
                    + " left join ficha_instalaciones on areas_trabajo.ficha_instalacionFK=ficha_instalaciones.idFicha\n"
                    + " left join evaluacion_area on areas_trabajo.idArea=evaluacion_area.idAreaFK\n"
                    + " where unidadfk=442\n"
                    + "	\n"
                    + " GROUP BY codArea,nombre, fechaTomaDatos, convert(varchar(max),observacionesArea), convert(varchar(max),descripcion) ,\n"
                    + " superficie, convert(varchar(max),actividadesRealizadas), \n"
                    + " convert(varchar(max),instalacionesExistentes) ,convert(varchar(max),medidasPreventivasExistentes) ,\n"
                    + " convert(varchar(max),observacionesMedidasPreventivas),convert(varchar(max),rampas_de_circulacion) ,\n"
                    + " convert(varchar(max),circulacion_interior), convert(varchar(max),escaleras_fijas) ,\n"
                    + " convert(varchar(max),escaleras_mano), convert(varchar(max),almacenamiento_altura),\n"
                    + " convert(varchar(max),conducciones_fluidos_presion), convert(varchar(max),calderas),\n"
                    + " convert(varchar(max),depositos_presion) , convert(varchar(max),botellas_presion) ,\n"
                    + " convert(varchar(max),cintas_transportadoras) ,convert(varchar(max),ascensores_montacargas) ,\n"
                    + " convert(varchar(max),plataformas_elevadoras) ,convert(varchar(max),gruas_polipastros),\n"
                    + " convert(varchar(max),carretillas_elevadoras) ,convert(varchar(max),area_carga_baterias) ,\n"
                    + " convert(varchar(max),extintores) ,convert(varchar(max),bie),convert(varchar(max),deteccion_incendios) ,\n"
                    + " convert(varchar(max),otros), tipoEvaluacion;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                AreasFicha a = new AreasFicha();
                a.setCodArea(rs.getString("codArea").trim());
                a.setNombreArea(rs.getString("nombre").trim());
                a.setFechaTomaDatos(rs.getDate("fechaTomaDatos"));
                a.setTipoEvaluacion(rs.getString("tipoEvaluacion"));
                a.setObservaciones(rs.getString("OBSERVACIONES").trim());
                a.setDescripcion(rs.getString("DESCRIPCION").trim());
                a.setSuperficie(rs.getInt("superficie"));
                a.setActividades(rs.getString("ACTIVIDADES").trim());
                a.setInstalaciones(rs.getString("INSTALACIONES").trim());
                a.setMedidasPreventivas(rs.getString("MPE").trim());
                a.setObservacionesMedidas(rs.getString("OMP").trim());
                a.setRampas_de_circulacion(rs.getString("RAMPAS"));
                a.setCirculacion_interior(rs.getString("CI"));
                a.setEscaleras_fijas(rs.getString("EFIJAS"));
                a.setEscaleras_mano(rs.getString("EMANO"));
                a.setAlmacenamiento_altura(rs.getString("ALTURA"));
                a.setConducciones_fluidos_presion(rs.getString("CFP"));
                a.setCalderas(rs.getString("CALDERAS"));
                a.setDepositos_presion(rs.getString("DEPOSITOS"));
                a.setBotellas_presion(rs.getString("BOTELLAS"));
                a.setCintas_transportadoras(rs.getString("CINTAS"));
                a.setAscensores_montacargas(rs.getString("ASCENSORES"));
                a.setPlataformas_elevadoras(rs.getString("PLATAFORMAS"));
                a.setGruas_polipastos(rs.getString("GRUAS"));
                a.setCarretillas_elevadoras(rs.getString("CARRETILLAS"));
                a.setArea_carga_baterias(rs.getString("BATERIAS"));
                a.setExtintores(rs.getString("EXTINTORES"));
                a.setBie(rs.getString("BIE"));
                a.setDeteccion_incendios(rs.getString("DINCENDIOS"));
                a.setOtros(rs.getString("OTROS"));

                areasFicha.add(a);
            }
            return areasFicha;
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

        return null;
    }

    public List<Trabajador> obtenerTrabajadores() {
        List<Trabajador> trabajadores = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "SELECT  idTrabajador,codigo,empleo, trabajadores.nombreTrabajador, puestos_trabajo.puesto FROM dbo.TRABAJADORES inner join puestos_trabajo "
                    + "on trabajadores.puestoTrabajoFK=puestos_trabajo.idPuesto "
                    + "inner join area_puesto on puestos_trabajo.idPuesto=area_puesto.idPuesto "
                    + "inner join areas_trabajo on areas_trabajo.idArea=area_puesto.idArea "
                    + "where unidadFK=442 "
                    + "order by codigo;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Trabajador t = new Trabajador();
                t.setId(rs.getInt("idTrabajador"));
                t.setCodTrabajador(rs.getString("codigo"));
                t.setNombre(rs.getString("nombreTrabajador"));
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
                zona.setLuz(rs.getFloat("luz"));
                zona.setRuido(rs.getFloat("ruido"));
                zona.setTemp(rs.getFloat("temp"));
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

    public int insertaArea(Area a) {
        try {
            int i = insertaFichaInstalacion();
            int z = 0;
            st = cn.createStatement();

            String sql2 = "select max(idFicha) as m from ficha_instalaciones";
            rs = st.executeQuery(sql2);
            while (rs.next()) {
                z = rs.getInt("m");
            }
            String sql = "insert into areas_trabajo (codArea, nombre,fechaTomaDatos,observacionesArea,descripcion,superficie,"
                    + "actividadesRealizadas,instalacionesExistentes,medidasPreventivasExistentes,"
                    + "observacionesMedidasPreventivas, unidadFK,ficha_instalacionFK) values(?,?,?,?,?,?,?,?,?,?,?,?); ";
            cn = datasource.getConnection();
            pst = cn.prepareStatement(sql);
            java.util.Date fecha = a.getFechaTomaDatos();
            java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
            pst.setString(1, a.getCodArea());
            pst.setString(2, a.getNombre());
            pst.setDate(3, fecha2);
            pst.setString(4, a.getObservacionesArea());
            pst.setString(5, a.getDescripcion());
            pst.setInt(6, a.getSuperficie());
            pst.setString(7, a.getActividadesRealizadas());
            pst.setString(8, a.getInstalacionesExistentes());
            pst.setString(9, a.getMedidasPreventivasExistentes());
            pst.setString(10, a.getObservacionesMedidasPreventivas());
            pst.setInt(11, a.getUnidadFK());
            pst.setInt(12, z);
            int rows = pst.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return 0;
        }
    }

    public int insertaFichaInstalacion() {
        try {
            String sql = "insert into ficha_instalaciones (bie) values(?); ";
            cn = datasource.getConnection();
            pst = cn.prepareStatement(sql);

            pst.setString(1, null);

            int rows = pst.executeUpdate();
            return rows;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return 0;
        }
    }

    public Trabajador getTrabajadorbyId(int id) {
        Trabajador t = new Trabajador();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "SELECT  idTrabajador,codigo,empleo, trabajadores.nombreTrabajador, puestos_trabajo.puesto, areas_trabajo.nombre as area "
                    + "FROM dbo.TRABAJADORES inner join puestos_trabajo "
                    + "on trabajadores.puestoTrabajoFK=puestos_trabajo.idPuesto "
                    + "inner join area_puesto on puestos_trabajo.idPuesto=area_puesto.idPuesto "
                    + "inner join areas_trabajo on areas_trabajo.idArea=area_puesto.idArea "
                    + "where idTrabajador=" + id + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                t.setId(rs.getInt("idTrabajador"));
                t.setCodTrabajador(rs.getString("codigo"));
                t.setEmpleo(rs.getString("empleo"));
                t.setNombre(rs.getString("nombreTrabajador"));
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

    public int actualizaTrabajador(Trabajador t) {
        try {
            cn = datasource.getConnection();
            String sql = "update trabajadores set nombreTrabajador=?,empleo=? where idTrabajador=?; ";
            pst = cn.prepareStatement(sql);

            pst.setString(1, t.getNombre());
            pst.setString(2, t.getEmpleo());

            pst.setInt(3, t.getId());

            int rows = pst.executeUpdate();
            return rows;

        } catch (SQLException ex) {
            System.out.println("Error actualizando" + ex);
            return 0;
        }

    }

    public Puestos getPuestobyId(int id) {
        Puestos p = new Puestos();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select puestos_trabajo.idPuesto, puesto,codPuesto,fechaTomaDatos,observaciones,tareasRealizadas,"
                    + "equiposTrabajo,productosQuimicosFK,trabajadoresCondicionEspecial,medidasPreventivasExistentes,"
                    + "observacionesmedidasPreventivas,medicion_luz,medicion_ruido,medicion_temp,"
                    + "idArea from puestos_trabajo inner join area_puesto on area_puesto.idPuesto= puestos_trabajo.idPuesto"
                    + " where puestos_trabajo.idPuesto=" + id + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                p.setIdArea(rs.getInt("idArea"));
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
                p.setLuz(rs.getFloat("medicion_luz"));
                p.setRuido(rs.getFloat("medicion_ruido"));
                p.setTemp(rs.getFloat("medicion_temp"));
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
                p.setLuz(rs.getFloat("medicion_luz"));
                p.setRuido(rs.getFloat("medicion_ruido"));
                p.setTemp(rs.getFloat("medicion_temp"));
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

    public int nuevaZona(Zona_medicion z) {
        try {
            String sql = "insert into zonas_medicion values(?,?,?,?,?,?); ";
            cn = datasource.getConnection();
            pst = cn.prepareStatement(sql);

            pst.setFloat(1, z.getLuz());
            pst.setFloat(2, z.getRuido());
            pst.setFloat(3, z.getTemp());
            pst.setString(4, z.getNombre());
            pst.setString(5, z.getDescripcion());
            pst.setInt(6, z.getIdAreaFK());
            int rows = pst.executeUpdate();
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

    public int borraArea(int id) {
        try {
            cn = datasource.getConnection();
            String sql = "delete from Area_Puesto where idArea=?; ";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            sql = "delete from Zonas_medicion where AreaFK=?;";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            rows = pst.executeUpdate();
            sql = "delete from areas_trabajo where idArea=?;";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, id);
            rows = pst.executeUpdate();
            System.out.println("Exito para Joseluis");
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
            pst.setFloat(3, z.getLuz());
            pst.setFloat(4, z.getRuido());
            pst.setFloat(5, z.getTemp());
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

    public int actualizaPuesto(Puestos p, int id) {
        try {
            cn = datasource.getConnection();
            String sql = "update puestos_trabajo set codPuesto=?,puesto=?, observaciones=?,fechaTomaDatos=? ,tareasRealizadas=?,"
                    + " equiposTrabajo=?, trabajadoresCondicionEspecial=?, medidasPreventivasExistentes=?,"
                    + " observacionesMedidasPreventivas=?,medicion_luz=?, medicion_ruido=?, medicion_temp=? where idPuesto=?; ";
            pst = cn.prepareStatement(sql);
            java.util.Date fecha = p.getFechaTomaDatos();
            java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
            pst.setString(1, p.getCodPuesto());
            pst.setString(2, p.getPuesto());
            pst.setString(3, p.getObservaciones());
            pst.setDate(4, fecha2);
            pst.setString(5, p.getTareasRealizadas());
            pst.setString(6, p.getEquiposTrabajo());
            pst.setString(7, p.getTrabajadoresCondicionEspecial());
            pst.setString(8, p.getMedidasPreventivasExistentes());
            pst.setString(9, p.getObservacionesMedidasPreventivas());
            pst.setFloat(10, p.getLuz());
            pst.setFloat(11, p.getRuido());
            pst.setFloat(12, p.getTemp());
            pst.setInt(13, p.getIdPuesto());
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
                    + "where FICHA_INSTALACIONES.idFicha=" + id + ";";
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

    public ArrayList<ConsultaEvaluacion> buscar2(String sql) {
        ArrayList<ConsultaEvaluacion> datos = new ArrayList();

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                datos.add(new ConsultaEvaluacion(rs.getString("codArea").trim(), rs.getString("codPuesto").trim(), rs.getString("tipoEvaluacion"), rs.getString("fechaEvaluacion"), rs.getInt("idPuesto"), rs.getInt("idArea")));
            }
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return null;
        }

    }

    public ArrayList<ConsultaPeligro> getPeligroById(int idArea, int idPuesto) {
        ArrayList<ConsultaPeligro> datos = new ArrayList<ConsultaPeligro>();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "Select codArea, nombre, codPuesto, puesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, idEvaluacionPuesto, nIntervencion, factorRiesgo from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where PUESTOS_TRABAJO.idPuesto=" + idPuesto + " and FechaSubsanacion is null;";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ConsultaPeligro d = new ConsultaPeligro();
                d.setCodArea(rs.getString("codArea").trim());
                d.setNombre(rs.getString("nombre").trim());
                d.setCodPuesto(rs.getString("codPuesto").trim());
                d.setPuesto(rs.getString("puesto").trim());
                d.setIdArea(rs.getInt("idArea"));
                d.setIdPuesto(rs.getInt("idPuesto"));
                d.setIdEvaluacionPuesto(rs.getInt("idEvaluacionPuesto"));
                d.setnIntervencion(rs.getString("nIntervencion").trim());
                d.setFactorRiesgo(rs.getString("factorRiesgo").trim());
                datos.add(d);
            }
            System.out.println(datos.toString());
            return datos;
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

        return datos;
    }

    public ConsultaPeligro getPeligroByIdObj(int idArea, int idPuesto) {
        ConsultaPeligro d = new ConsultaPeligro();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "Select codArea, nombre, codPuesto, puesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, idEvaluacionPuesto, nIntervencion, factorRiesgo from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where AREAS_TRABAJO.idArea=" + idArea + " and PUESTOS_TRABAJO.idPuesto=" + idPuesto + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                d.setCodArea(rs.getString("codArea").trim());
                d.setNombre(rs.getString("nombre").trim());
                d.setCodPuesto(rs.getString("codPuesto").trim());
                d.setPuesto(rs.getString("puesto").trim());
                d.setIdArea(rs.getInt("idArea"));
                d.setIdPuesto(rs.getInt("idPuesto"));
                d.setIdEvaluacionPuesto(rs.getInt("idEvaluacionPuesto"));
                d.setnIntervencion(rs.getString("nIntervencion").trim());
                d.setFactorRiesgo(rs.getString("factorRiesgo").trim());

            }
//            System.out.println(datos.toString());
            return d;
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

        return d;
    }

    public ConsultaDetallesEvaluacion getConsultaEvaluacionById(int idArea, int idEvaluacionPuesto) {
        ConsultaDetallesEvaluacion datos = new ConsultaDetallesEvaluacion();

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "Select idEvaluacionPuesto, nDeficiencia, nExposicion, nProbabilidad, nConsecuencias, nRiesgo, nIntervencion, tipoEvaluacion, fechaEvaluacion, normativa, factorRiesgo, medidaPropuesta, codArea, nombre, codPuesto, puesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where areas_trabajo.idArea=" + idArea + " and idEvaluacionPuesto=" + idEvaluacionPuesto + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                //datos.add(new ConsultaEvaluacion(res.getInt("idEvaluacionPuesto"), res.getString("nDeficiencia").trim(), res.getString("nExposicion").trim(), res.getString("nProbabilidad"), res.getString("nConsecuencias").trim(), res.getString("nRiesgo").trim(), res.getString(" nIntervencion").trim(), res.getString("tipoEvaluacion"), res.getString("fechaEvaluacion").trim(), res.getString("normativa").trim(), res.getString("factorRiesgo").trim(), res.getString("medidaPropuesta"), res.getString("codArea").trim(), res.getString("nombre").trim(), res.getString("codPuesto").trim(), res.getString("puesto")));
                datos.setIdEvaluacionPuesto(rs.getInt("idEvaluacionPuesto"));
                datos.setDeficiencia(rs.getString("nDeficiencia").trim());
                datos.setExposicion(rs.getString("nExposicion").trim());
                datos.setProbabilidad(rs.getString("nProbabilidad"));
                datos.setConsecuencias(rs.getString("nConsecuencias").trim());
                datos.setRiesgo(rs.getString("nRiesgo").trim());
                datos.setIntervencion(rs.getString("nIntervencion").trim());
                datos.setTipoevaluacion(rs.getString("tipoEvaluacion"));
                if (rs.getString("fechaEvaluacion") == null) {
                    datos.setFechaevaluacion("Sin datos");
                } else {
                    datos.setFechaevaluacion(rs.getString("fechaEvaluacion").trim());
                }
                datos.setNormativa(rs.getString("normativa").trim());
                datos.setFactorriesgo(rs.getString("factorRiesgo").trim());
                datos.setMedidas(rs.getString("medidaPropuesta"));
                datos.setCodigoarea(rs.getString("codArea").trim());
                datos.setNombre(rs.getString("nombre").trim());
                datos.setCodigopuesto(rs.getString("codPuesto").trim());
                datos.setPuesto(rs.getString("puesto"));
                datos.setIdArea(rs.getInt("idArea"));
                datos.setIdPuesto(rs.getInt("idPuesto"));
                datos.setCodPeligro(rs.getInt("codPeligroFK"));

            }

            return datos;
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

        return datos;
    }

    public int nuevaEvaluacion(ConsultaDetallesEvaluacion cd) {

        try {

            String sql = "Insert into evaluacion_puesto (codPeligroFK, idPuestoFK, nDeficiencia, nExposicion, nProbabilidad, nConsecuencias, nRiesgo, nIntervencion, tipoEvaluacion, fechaEvaluacion, factorRiesgo, normativa, medidaPropuesta) values ('" + cd.getCodPeligro() + "','" + cd.getIdPuesto() + "','" + cd.getDeficiencia() + "','" + cd.getExposicion() + "','" + cd.getProbabilidad() + "','" + cd.getConsecuencias() + "','" + cd.getRiesgo() + "','" + cd.getIntervencion() + "','" + cd.getTipoevaluacion() + "','" + cd.getFechaevaluacion() + "','" + cd.getFactorriesgo() + "','" + cd.getNormativa() + "','" + cd.getMedidas() + "')";
            cn = datasource.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);

            return 1;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
            return 0;
        } finally {

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

    }

    public ArrayList<ComboPuestos> obtenerComboPuestos(String sql) {
        ArrayList<ComboPuestos> cmbPuesto = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                cmbPuesto.add(new ComboPuestos(rs.getInt("idPuesto"), rs.getString("codPuesto").trim(), rs.getString("puesto").trim()));
            }
            return cmbPuesto;
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
        return cmbPuesto;
    }

    public ArrayList<ComboCodigoPeligro> obtenerComboCodigoPeligro(String sql2) {
        ArrayList<ComboCodigoPeligro> cmbCodigoPeligro = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql2);
            while (rs.next()) {
                cmbCodigoPeligro.add(new ComboCodigoPeligro(rs.getInt("idCodigo"), rs.getString("codigo").trim()));
            }
            return cmbCodigoPeligro;
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

        return cmbCodigoPeligro;
    }

    public List<EvaluacionesArea> getEvaluacionesbyID(int id) {
        List<EvaluacionesArea> evaluaciones = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select * from (select codArea,nombre from AREAS_TRABAJO where idArea=" + id + ")as Areas, (select * from EVALUACION_AREA where idAreaFK=" + id + " and fechaSubsanacion is null)as Evaluaciones;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                EvaluacionesArea ea = new EvaluacionesArea();
                ea.setCodArea(rs.getString("codArea"));
                ea.setNombreArea(rs.getString("nombre"));
                ea.setIdEvaluacionArea(rs.getInt("idEvaluacionArea"));
                ea.setnDeficiencia(rs.getInt("nDeficiencia"));
                ea.setnExposicion(rs.getInt("nExposicion"));
                ea.setnProbabilidad(rs.getInt("nProbabilidad"));
                ea.setnConsecuencias(rs.getInt("nConsecuencias"));
                ea.setnRiesgo(rs.getInt("nRiesgo"));
                ea.setnIntervencion(rs.getString("nIntervencion"));
                ea.setTipoEvaluacion(rs.getString("tipoEvaluacion"));
                ea.setFechaEvaluacion(rs.getDate("fechaEvaluacion"));
                ea.setFactorRiesgo(rs.getString("factorRiesgo"));
                ea.setNormativa(rs.getString("normativa"));
                ea.setMedidaPropuesta(rs.getString("medidaPropuesta"));
                ea.setIdAreaFK(rs.getInt("idAreaFK"));
                evaluaciones.add(ea);
            }
            return evaluaciones;
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

        return evaluaciones;
    }

    public EvaluacionesArea getEvaluacionbyID(int id1, int id2) {
        EvaluacionesArea ea = new EvaluacionesArea();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select * from (select *  from (select codArea,nombre from AREAS_TRABAJO where idArea=" + id1 + ") as Area, (select * from EVALUACION_AREA where idAreaFK=" + id1 + ")as Evaluaciones)as EvporArea where EvporArea.idEvaluacionArea=" + id2 + ";";
            rs = st.executeQuery(sql);
            while (rs.next()) {

                ea.setCodArea(rs.getString("codArea"));
                ea.setNombreArea(rs.getString("nombre"));
                ea.setIdEvaluacionArea(rs.getInt("idEvaluacionArea"));
                ea.setnDeficiencia(rs.getInt("nDeficiencia"));
                ea.setnExposicion(rs.getInt("nExposicion"));
                ea.setnProbabilidad(rs.getInt("nProbabilidad"));
                ea.setnConsecuencias(rs.getInt("nConsecuencias"));
                ea.setnRiesgo(rs.getInt("nRiesgo"));
                ea.setnIntervencion(rs.getString("nIntervencion"));
                ea.setTipoEvaluacion(rs.getString("tipoEvaluacion"));
                ea.setFechaEvaluacion(rs.getDate("fechaEvaluacion"));
                ea.setFactorRiesgo(rs.getString("factorRiesgo"));
                ea.setNormativa(rs.getString("normativa"));
                ea.setMedidaPropuesta(rs.getString("medidaPropuesta"));
                ea.setIdAreaFK(rs.getInt("idAreaFK"));

            }
            return ea;
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

        return ea;
    }

    public List<EvaluacionesArea> getEvaluaciones() {
        List<EvaluacionesArea> evaluaciones = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();

            String sql = "select * from (select codArea,nombre,idArea from AREAS_TRABAJO)as Areas, (select * from EVALUACION_AREA)as Evaluaciones where idArea=idAreaFK and fechaSubsanacion is null;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                EvaluacionesArea ea = new EvaluacionesArea();
                ea.setCodArea(rs.getString("codArea"));
                ea.setNombreArea(rs.getString("nombre"));
                ea.setIdEvaluacionArea(rs.getInt("idEvaluacionArea"));
                ea.setnDeficiencia(rs.getInt("nDeficiencia"));
                ea.setnExposicion(rs.getInt("nExposicion"));
                ea.setnProbabilidad(rs.getInt("nProbabilidad"));
                ea.setnConsecuencias(rs.getInt("nConsecuencias"));
                ea.setnRiesgo(rs.getInt("nRiesgo"));
                ea.setnIntervencion(rs.getString("nIntervencion"));
                ea.setTipoEvaluacion(rs.getString("tipoEvaluacion"));
                ea.setFechaEvaluacion(rs.getDate("fechaEvaluacion"));
                ea.setFactorRiesgo(rs.getString("factorRiesgo"));
                ea.setNormativa(rs.getString("normativa"));
                ea.setMedidaPropuesta(rs.getString("medidaPropuesta"));
                ea.setIdAreaFK(rs.getInt("idAreaFK"));
                evaluaciones.add(ea);
            }
            return evaluaciones;
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

        return evaluaciones;
    }

    public int nuevaEvaluacionArea(EvaluacionesArea cd) {

        try {
            java.util.Date fecha = cd.getFechaEvaluacion();
            java.sql.Date fecha2 = new java.sql.Date(fecha.getTime());
            String sql = "Insert into evaluacion_area (idAreaFK, codPeligroFK,nDeficiencia, nExposicion, nProbabilidad, nConsecuencias, nRiesgo, nIntervencion, tipoEvaluacion, fechaEvaluacion, factorRiesgo, normativa, medidaPropuesta) values ('" + cd.getIdAreaFK() + "','" + cd.getCodPeligroFK() + "','" + cd.getnDeficiencia() + "','" + cd.getnExposicion() + "','" + cd.getnProbabilidad() + "','" + cd.getnConsecuencias() + "','" + cd.getnRiesgo() + "','" + cd.getnIntervencion() + "','" + cd.getTipoEvaluacion() + "','" + fecha2 + "','" + cd.getFactorRiesgo() + "','" + cd.getNormativa() + "','" + cd.getMedidaPropuesta() + "')";
            cn = datasource.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);

            return 1;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
            return 0;
        } finally {

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
    }

    public ArrayList<ComboAreas> obtenerComboArea(String sql) {
        ArrayList<ComboAreas> cmbArea = new ArrayList();
        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                cmbArea.add(new ComboAreas(rs.getInt("idArea"), rs.getString("codArea").trim()));
            }
            System.out.println(cmbArea);
            return cmbArea;
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

        return cmbArea;
    }

    public int nuevaFechaSubsanado(FechaSubsanado cd) {

        try {

            //String sql = "Insert into evaluacion_puesto (fechaSubsanacion) values ('" + cd.getFechaSubsanado() + "') where idEvaluacionPuesto = '" + cd.getIdEvaluacionPuesto() + "';";
            String sql = "update evaluacion_puesto set fechaSubsanacion =('" + cd.getFechaSubsanado() + "') where idEvaluacionPuesto = ('" + cd.getIdEvaluacionPuesto() + "');";
            String sql1 = "update evaluacion_puesto set subsanador=('" + cd.getSubsanador() + "') where idEvaluacionPuesto = ('" + cd.getIdEvaluacionPuesto() + "');";
            cn = datasource.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            st.executeUpdate(sql1);

            return 1;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
            return 0;
        } finally {

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

    }

    public int nuevaFechaSubsanadoArea(FechaSubsanado cd) {

        try {

            String sql = "update evaluacion_area set fechaSubsanacion =('" + cd.getFechaSubsanado() + "')  where idEvaluacionArea = ('" + cd.getIdEvaluacionArea() + "');";
            String sql1 = "update evaluacion_area set subsanador =('" + cd.getSubsanador() + "')  where idEvaluacionArea = ('" + cd.getIdEvaluacionArea() + "');";
            cn = datasource.getConnection();
            st = cn.createStatement();
            st.executeUpdate(sql);
            st.executeUpdate(sql1);

            return 1;
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
            e.printStackTrace();
            return 0;
        } finally {

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

    }

    public ArrayList<PlanificacionPuestos> buscar3(String sql) {
        ArrayList<PlanificacionPuestos> datos = new ArrayList();

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                datos.add(new PlanificacionPuestos(rs.getInt("idArea"), rs.getInt("idPuesto"), rs.getInt("idEvaluacionPuesto"), rs.getString("codArea"), rs.getString("codPuesto"), rs.getString("codPeligroFK"), rs.getString("factorRiesgo"), rs.getString("nIntervencion").trim(), rs.getString("normativa"), rs.getString("medidaPropuesta"), rs.getString("fechaSubsanacion"), rs.getString("subsanador")));
            }
            System.out.println(datos);
            return datos;
        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return null;
        }

    }

    public ArrayList<PlanificacionAreas> buscar4(String sql) {
        ArrayList<PlanificacionAreas> datos = new ArrayList();

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            String r = "";
            String s = "";

            while (rs.next()) {
                if (rs.getString("nIntervencion") == null) {
                    r = "No Requiere Intervención";
                } else {
                    r = rs.getString("nIntervencion");
                }
                if (rs.getString("medidaPropuesta") == null) {
                    s = "";
                } else {
                    s = rs.getString("medidaPropuesta");
                }
                datos.add(new PlanificacionAreas(rs.getInt("idEvaluacionArea"), rs.getInt("idAreaFK"), rs.getString("codArea"), rs.getString("codPeligroFK"), r, rs.getString("factorRiesgo"), rs.getString("normativa"), s, rs.getString("fechaSubsanacion"), rs.getString("subsanador")));
            }

            System.out.println(datos);

            return datos;

        } catch (SQLException ex) {
            System.out.println("Error con el resultset" + ex);
            return null;
        }

    }

    public PlanificacionPuestos getPlanificacionPuestosById(int idEvaluacionPuestos, int idArea) {
        PlanificacionPuestos datos = new PlanificacionPuestos();

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where idEvaluacionPuesto=" + idEvaluacionPuestos + " and areas_trabajo.idArea=" + idArea + ";";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                //datos.add(new ConsultaEvaluacion(res.getInt("idEvaluacionPuesto"), res.getString("nDeficiencia").trim(), res.getString("nExposicion").trim(), res.getString("nProbabilidad"), res.getString("nConsecuencias").trim(), res.getString("nRiesgo").trim(), res.getString(" nIntervencion").trim(), res.getString("tipoEvaluacion"), res.getString("fechaEvaluacion").trim(), res.getString("normativa").trim(), res.getString("factorRiesgo").trim(), res.getString("medidaPropuesta"), res.getString("codArea").trim(), res.getString("nombre").trim(), res.getString("codPuesto").trim(), res.getString("puesto")));
                datos.setIdEvaluacionPuestos(rs.getInt("idEvaluacionPuesto"));
                datos.setPrioridad(rs.getString("nIntervencion").trim());
                datos.setNormativa(rs.getString("normativa").trim());
                datos.setFactorRiesgo(rs.getString("factorRiesgo").trim());
                datos.setMedidasPropuestas(rs.getString("medidaPropuesta"));
                datos.setCodArea(rs.getString("codArea").trim());
                datos.setCodPuesto(rs.getString("codPuesto").trim());
                datos.setIdArea(rs.getInt("idArea"));
                datos.setIdPuesto(rs.getInt("idPuesto"));
                datos.setCodPeligroFK(rs.getString("codPeligroFK"));
                datos.setFechaSubsanado(rs.getString("fechaSubsanacion"));

                if (rs.getString("subsanador") == null) {
                    datos.setSubsanador("");
                } else {
                    datos.setSubsanador(rs.getString("subsanador"));
                }

            }

            return datos;
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

        return datos;
    }

    public PlanificacionAreas getPlanificacionAreasById(int idAreaFK) {
        PlanificacionAreas datos = new PlanificacionAreas();

        try {
            cn = datasource.getConnection();
            st = cn.createStatement();
            String sql = "Select idEvaluacionArea, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, areas_trabajo.idArea, codPeligroFK, fechaSubsanacion, subsanador from Evaluacion_Area inner join AREAS_TRABAJO on idArea=idAreaFK where idEvaluacionArea='" + idAreaFK + "';";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                datos.setIdEvaluacionArea(rs.getInt("idEvaluacionArea"));
                datos.setPrioridad(rs.getString("nIntervencion"));
                datos.setNormativa(rs.getString("normativa").trim());
                datos.setFactorRiesgo(rs.getString("factorRiesgo").trim());
                datos.setMedidaPropuesta(rs.getString("medidaPropuesta"));
                datos.setCodArea(rs.getString("codArea").trim());
                datos.setIdAreaFK(rs.getInt("idArea"));
                datos.setCodPeligroFK(rs.getString("codPeligroFK"));
                datos.setFechaSubsanado(rs.getString("fechaSubsanacion"));
                if (rs.getString("subsanador") == null) {
                    datos.setSubsanador("");
                } else {
                    datos.setSubsanador(rs.getString("subsanador"));
                }

            }

            return datos;
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

        return datos;
    }
}
