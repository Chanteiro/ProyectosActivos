package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.ConsultaDetallesEvaluacion;
import java.io.IOException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ControladorNuevaEvaluacion", urlPatterns = {"/ControladorNuevaEvaluacion"})
public class ControladorNuevaEvaluacion extends HttpServlet {

    DataSource datasource = null;
    Statement st = null;
    DbConnection cn = null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ide = request.getParameter("cmbpuesto");
        int idPuestoFK = Integer.parseInt(ide);
        String tipoEvaluacion = request.getParameter("tipoEvaluacion");
        String fecha = request.getParameter("fechaEvaluacion");
        String ide2 = request.getParameter("codPeligroFK");
        int codPeligroFK = Integer.parseInt(ide2);
        String deficiencia = request.getParameter("deficiencia");
        String exposicion = request.getParameter("exposicion");
        String probabilidad = request.getParameter("probabilidad");
        String consecuencias = request.getParameter("consecuencias");
        String riesgo = request.getParameter("riesgo");
        String intervencion = request.getParameter("intervencion");
        String factorRiesgo = request.getParameter("factorRiesgo");
        String medidas = request.getParameter("medidas");
        String normativa = request.getParameter("normativa");

        try {

            ConsultaDetallesEvaluacion cd = new ConsultaDetallesEvaluacion();

            cd.setIdPuesto(idPuestoFK);
            cd.setTipoevaluacion(tipoEvaluacion);
            cd.setFechaevaluacion(fecha);
            cd.setCodPeligro(codPeligroFK);
            cd.setDeficiencia(deficiencia);
            cd.setExposicion(exposicion);
            cd.setProbabilidad(probabilidad);
            cd.setConsecuencias(consecuencias);
            cd.setRiesgo(riesgo);
            cd.setIntervencion(intervencion);
            cd.setFactorriesgo(factorRiesgo);
            cd.setMedidas(medidas);
            cd.setNormativa(normativa);
            DbConnection con = new DbConnection();
            int i = con.nuevaEvaluacion(cd);
          
            if (i == 1) {
                RequestDispatcher rd = request.getRequestDispatcher("ControladorEvaluacionPuestos");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("#");
                rd.forward(request, response);
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

   
}
