
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.EvaluacionesArea;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
@WebServlet(name = "tablaEvaluacionesControler", urlPatterns = {"/tablaEvaluacionesControler"})
public class tablaEvaluacionesControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           List<EvaluacionesArea> evaluaciones=con.getEvaluaciones();
           if(evaluaciones.size()>0){
               request.setAttribute("evaluaciones",evaluaciones);
               RequestDispatcher rd = request.getRequestDispatcher("tablaEvaluaciones.jsp");
            rd.forward(request, response);
           }
           
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           List<EvaluacionesArea> evaluaciones=con.getEvaluaciones();
           if(evaluaciones.size()>0){
               request.setAttribute("evaluaciones",evaluaciones);
               RequestDispatcher rd = request.getRequestDispatcher("tablaEvaluaciones.jsp");
            rd.forward(request, response);
           }
           
       }
    }

   

}