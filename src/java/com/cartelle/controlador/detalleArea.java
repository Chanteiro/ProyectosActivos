package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Area;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
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
@WebServlet(name = "detalleVacante", urlPatterns = {"/detalleVacante"})
public class detalleArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        int id = Integer.parseInt(ide);
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        if (action.equals("verdetalle") || action.equals("borrar")) {
            DbConnection con = new DbConnection();
            Area area = con.getAreabyId(id, unidad);
            if (area.getId() != 0) {
                request.setAttribute("area", area);
                RequestDispatcher rd = request.getRequestDispatcher("detalleVacante.jsp");
                rd.forward(request, response);
            }

        }

        if (action.equals("nueva")) {

            Area area = new Area(0);

            request.setAttribute("area", area);
            RequestDispatcher rd = request.getRequestDispatcher("detalleVacante.jsp");
            rd.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        String ide = request.getParameter("id");

        int id = Integer.parseInt(ide);

        DbConnection con = new DbConnection();
        Area area = con.getAreabyId(id, unidad);
        System.out.println(id);
        if (area.getId() != 0) {
            request.setAttribute("area", area);
            RequestDispatcher rd = request.getRequestDispatcher("detalleVacante.jsp");
            rd.forward(request, response);
        }

    }

}
