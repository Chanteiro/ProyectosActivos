package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.ConsultaEvaluacion;
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

@WebServlet(name = "ControladorEvaluacionPuestos", urlPatterns = {"/ControladorEvaluacionPuestos"})
public class ControladorEvaluacionPuestos extends HttpServlet {

    DataSource datasource = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DbConnection cn = null;
    ArrayList<ConsultaEvaluacion> datos = new ArrayList();

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String sql = ("Select  codArea, codPuesto, tipoEvaluacion, fechaEvaluacion, puestos_trabajo.idPuesto, areas_trabajo.idArea from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea group by codPuesto, codArea, tipoEvaluacion, fechaEvaluacion, puestos_trabajo.idPuesto, areas_trabajo.idArea order by codArea;");
            DbConnection con = new DbConnection();
            datos.clear();
            datos = con.buscar2(sql);
            request.setAttribute("datos", datos);
            RequestDispatcher rd = request.getRequestDispatcher("evaluacionPuestos.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String sql = ("Select  codArea, codPuesto, tipoEvaluacion, fechaEvaluacion, puestos_trabajo.idPuesto, areas_trabajo.idArea from EVALUACION_PUESTO inner join PUESTOS_TRABAJO on EVALUACION_PUESTO.idPuestoFK=PUESTOS_TRABAJO.idPuesto inner join AREA_PUESTO on AREA_PUESTO.idPuesto= PUESTOS_TRABAJO.idPuesto inner join AREAS_TRABAJO on AREA_PUESTO.idArea=AREAS_TRABAJO.idArea group by codPuesto, codArea, tipoEvaluacion, fechaEvaluacion, puestos_trabajo.idPuesto, areas_trabajo.idArea order by codArea;");
            DbConnection con = new DbConnection();
            datos.clear();
            datos = con.buscar2(sql);
            request.setAttribute("datos", datos);
            RequestDispatcher rd = request.getRequestDispatcher("evaluacionPuestos.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   
}
