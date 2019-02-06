package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.PlanificacionAreas;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

@WebServlet(name = "ControladorPlanificacionAreas", urlPatterns = {"/ControladorPlanificacionAreas"})
public class ControladorPlanificacionAreas extends HttpServlet {

    DataSource datasource = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DbConnection cn = null;
    ArrayList<PlanificacionAreas> datos = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        String ide = request.getParameter("action");

        if (ide == null) {
            try {
                String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, nIntervencion, "
                        + "factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, subsanador "
                        + "from EVALUACION_AREA "
                        + "inner join areas_trabajo on idArea=idAreaFK  "
                        + "where fechaSubsanacion is NULL and AREAS_TRABAJO.unidadFK=" + unidad + "order by codArea;";
                DbConnection con = new DbConnection();
                datos.clear();
                datos = con.buscar4(sql);
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("planificacionAreas.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            if (ide.equals("todos")) {
                try {
                    String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, "
                            + "nIntervencion, factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, "
                            + "subsanador from EVALUACION_AREA "
                            + "inner join areas_trabajo on idArea=idAreaFK "
                            + "where AREAS_TRABAJO.unidadFK=" + unidad + " order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar4(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionAreasTodos.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (ide.equals("historico")) {
                try {
                    String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, "
                            + "nIntervencion, factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, "
                            + "subsanador from EVALUACION_AREA "
                            + "inner join areas_trabajo on idArea=idAreaFK "
                            + " where fechaSubsanacion is not NULL and AREAS_TRABAJO.unidadFK=" + unidad + " order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar4(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionAreasHistorico.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (ide.equals("activos")) {
                try {
                    String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, nIntervencion, "
                            + "factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, subsanador "
                            + "from EVALUACION_AREA inner join areas_trabajo on idArea=idAreaFK  "
                            + "where fechaSubsanacion is NULL and AREAS_TRABAJO.unidadFK=" + unidad + "order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar4(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionAreas.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        String ide = request.getParameter("action");

        if (ide == null) {
            try {
                String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, nIntervencion, "
                        + "factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, subsanador "
                        + "from EVALUACION_AREA "
                        + "inner join areas_trabajo on idArea=idAreaFK  "
                        + "where fechaSubsanacion is NULL and AREAS_TRABAJO.unidadFK=" + unidad + " order by codArea;";
                DbConnection con = new DbConnection();
                datos.clear();
                datos = con.buscar4(sql);
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("planificacionAreas.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            if (ide.equals("todos")) {
                try {
                    String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, "
                            + "nIntervencion, factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, subsanador "
                            + "from EVALUACION_AREA inner join areas_trabajo on idArea=idAreaFK "
                            + "where AREAS_TRABAJO.unidadFK=" + unidad + " order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar4(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionAreasTodos.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (ide.equals("historico")) {
                try {
                    String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, "
                            + "nIntervencion, factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, subsanador "
                            + "from EVALUACION_AREA inner join areas_trabajo on idArea=idAreaFK  "
                            + "where fechaSubsanacion is not NULL and AREAS_TRABAJO.unidadFK=" + unidad + " order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar4(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionAreasHistorico.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (ide.equals("activos")) {
                try {
                    String sql = "Select idEvaluacionArea, idAreaFK, areas_trabajo.codArea, codPeligroFK, "
                            + "nIntervencion, factorRiesgo, normativa, medidaPropuesta, fechaSubsanacion, subsanador "
                            + "from EVALUACION_AREA inner join areas_trabajo on idArea=idAreaFK  "
                            + "where fechaSubsanacion is NULL and AREAS_TRABAJO.unidadFK=" + unidad + " order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar4(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionAreas.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
