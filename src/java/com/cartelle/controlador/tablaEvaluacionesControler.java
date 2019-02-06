package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.EvaluacionesArea;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANTONIO
 */
@WebServlet(name = "tablaEvaluacionesControler", urlPatterns = {"/tablaEvaluacionesControler"})
public class tablaEvaluacionesControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        String action = request.getParameter("action");
        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            List<EvaluacionesArea> evaluaciones = con.getEvaluaciones(unidad);
            if (evaluaciones.size() > 0) {
                request.setAttribute("evaluaciones", evaluaciones);
                RequestDispatcher rd = request.getRequestDispatcher("tablaEvaluaciones.jsp");
                rd.forward(request, response);
            }

        }

        if (action.equals("verEva")) {
            DbConnection con = new DbConnection();
            List<EvaluacionesArea> evaluaciones = con.getEvaluacionesbyID(Integer.parseInt(request.getParameter("id")));
            if (evaluaciones.size() > 0) {
                request.setAttribute("evaluaciones", evaluaciones);
                RequestDispatcher rd = request.getRequestDispatcher("tablaEvaluaciones.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("ControladorComboAreas");
                rd.forward(request, response);
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
        String action = request.getParameter("action");
        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            List<EvaluacionesArea> evaluaciones = con.getEvaluaciones(unidad);
            if (evaluaciones.size() > 0) {
                request.setAttribute("evaluaciones", evaluaciones);
                RequestDispatcher rd = request.getRequestDispatcher("tablaEvaluaciones.jsp");
                rd.forward(request, response);
            }

        }
    }

}
