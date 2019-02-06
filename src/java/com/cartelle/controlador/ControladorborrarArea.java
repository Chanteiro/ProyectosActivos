package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Area;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANTONIO
 */
public class ControladorborrarArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        int id = Integer.parseInt(request.getParameter("id"));
        if (user.getRol().equals("ADMIN_ESCANO")) {
            DbConnection con = new DbConnection();
            int i = con.borraArea(id);
            System.out.println(""+i);
            if (i == 1) {
                List<Area> areas = con.obtenerAreas(unidad);
                System.out.println(areas.size());
                if (areas.size() > 0) {
                    
                    request.setAttribute("areas", areas);
                    System.out.println(request.getParameter("act"));
                    RequestDispatcher rd = request.getRequestDispatcher("areastrabajo.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                    rd.forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
