package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.PlanificacionAreas;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorFechaSubsanadoAreas", urlPatterns = {"/ControladorFechaSubsanadoAreas"})
public class ControladorFechaSubsanadoAreas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        int idAreaFK = Integer.parseInt(ide);
        
       if (action.equals("insertarfecha")) {
            DbConnection con = new DbConnection();
            PlanificacionAreas datos = con.getPlanificacionAreasById(idAreaFK);
            if( datos.getIdAreaFK() != 0){
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("detallePlanificacionAreas.jsp");
                rd.forward(request, response);
                
            }else{
              RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
              rd.forward(request, response);  
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
