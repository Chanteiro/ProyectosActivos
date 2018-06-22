package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.PlanificacionPuestos;
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
import javax.sql.DataSource;

@WebServlet(name = "ControladorPlanificacionPuestos", urlPatterns = {"/ControladorPlanificacionPuestos"})
public class ControladorPlanificacionPuestos extends HttpServlet {

    DataSource datasource = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DbConnection cn = null;
    ArrayList<PlanificacionPuestos> datos = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ide = request.getParameter("action");

        System.out.println(ide);
        if (ide == null) {
            try {
                String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where fechaSubsanacion is NULL order by codArea;";
                DbConnection con = new DbConnection();
                datos.clear();
                datos = con.buscar3(sql);
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestos.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            if (ide.equals("todos")) {
                try {
                    String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar3(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestosTodos.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (ide.equals("historico")) {
                try {
                    String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where fechaSubsanacion is not NULL order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar3(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestosHistorico.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if(ide.equals("activos")) {
                try {
                    String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where fechaSubsanacion is NULL order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar3(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestos.jsp");
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
        String ide = request.getParameter("action");

        System.out.println(ide);
        if (ide == null) {
            try {
                String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where fechaSubsanacion is NULL order by codArea;";
                DbConnection con = new DbConnection();
                datos.clear();
                datos = con.buscar3(sql);
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestos.jsp");
                rd.forward(request, response);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            if (ide.equals("todos")) {
                try {
                    String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar3(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestosTodos.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if (ide.equals("historico")) {
                try {
                    String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where fechaSubsanacion is not NULL order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar3(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestosHistorico.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else if(ide.equals("activos")) {
                try {
                    String sql = "Select idEvaluacionPuesto, nIntervencion, normativa, factorRiesgo, medidaPropuesta, codArea, codPuesto, areas_trabajo.idArea, puestos_trabajo.idPuesto, codPeligroFK, fechaSubsanacion, subsanador from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea where fechaSubsanacion is NULL order by codArea;";
                    DbConnection con = new DbConnection();
                    datos.clear();
                    datos = con.buscar3(sql);
                    request.setAttribute("datos", datos);
                    RequestDispatcher rd = request.getRequestDispatcher("planificacionPuestos.jsp");
                    rd.forward(request, response);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

    }
}