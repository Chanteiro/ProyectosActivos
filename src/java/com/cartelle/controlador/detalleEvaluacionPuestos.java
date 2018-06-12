package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.ConsultaDetallesEvaluacion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "detalleEvaluacionPuestos", urlPatterns = {"/detalleEvaluacionPuestos"})
public class detalleEvaluacionPuestos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        String ide2 = request.getParameter("id2");
        int idArea = Integer.parseInt(ide);
        int idEvaluacionPuesto = Integer.parseInt(ide2);

        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            ConsultaDetallesEvaluacion datos = con.getConsultaEvaluacionById(idArea, idEvaluacionPuesto);
            if (datos.getIdArea() != 0 && datos.getIdEvaluacionPuesto() != 0) {
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("detalleEvaluacionPuestos.jsp");
                rd.forward(request, response);

            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
