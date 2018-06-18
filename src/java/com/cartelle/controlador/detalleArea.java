
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Area;
import java.io.IOException;
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
@WebServlet(name = "detalleVacante", urlPatterns = {"/detalleVacante"})
public class detalleArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       String ide=request.getParameter("id");
       int id=Integer.parseInt(ide);
       if(action.equals("verdetalle")||action.equals("borrar")){
           DbConnection con=new DbConnection();
           Area area=con.getAreabyId(id);
           if(area.getId()!=0){
               request.setAttribute("area",area);
               RequestDispatcher rd = request.getRequestDispatcher("detalleVacante.jsp");
            rd.forward(request, response);
           }
           
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//       String action=request.getParameter("action");
//        System.out.println(action);
       String ide=request.getParameter("id");
//        System.out.println(ide);
       int id=Integer.parseInt(ide);
//       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           Area area=con.getAreabyId(id);
           System.out.println(id);
           if(area.getId()!=0){
               request.setAttribute("area",area);
               RequestDispatcher rd = request.getRequestDispatcher("detalleVacante.jsp");
            rd.forward(request, response);
           }
           
//       }
       
    }

   

}
