package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Noticia;
import com.cartelle.modelo.Unidades;
import java.io.IOException;
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
public class ControladorIdUnidad extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

        try {
            String id = request.getParameter("idUnidad");
            int idUnidad = Integer.parseInt(id);
            System.out.println(id);
            DbConnection con = new DbConnection();
            Noticia n = con.getNoticia();
            request.setAttribute("noti", n);
            Unidades unidadSeleccionada = con.obtenerUnidadesById(idUnidad);
            HttpSession sesion = request.getSession();
            sesion.setAttribute("unidadSeleccionada", unidadSeleccionada);
            RequestDispatcher rd = request.getRequestDispatcher("succes.jsp");

            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
