package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.PlanificacionPuestos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorFechaSubsanado", urlPatterns = {"/ControladorFechaSubsanado"})
public class ControladorFechaSubsanado extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        String ide2= request.getParameter("id2");
        int idArea = Integer.parseInt(ide2);
        int idEvaluacionPuestos = Integer.parseInt(ide);
        
       if (action.equals("insertarfecha")) {
            DbConnection con = new DbConnection();
            PlanificacionPuestos datos = con.getPlanificacionPuestosById(idEvaluacionPuestos, idArea);
            
            if( datos.getIdEvaluacionPuestos() != 0 && datos.getIdArea() != 0){
                request.setAttribute("datos", datos);
                RequestDispatcher rd = request.getRequestDispatcher("detallePlanificacionPuestos.jsp");
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

  

}
