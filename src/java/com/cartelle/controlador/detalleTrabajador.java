
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Trabajador;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
public class detalleTrabajador extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       String ide=request.getParameter("id");
       int id=Integer.parseInt(ide);
       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           Trabajador trabajador=con.getTrabajadorbyId(id);
           if(trabajador.getId()!=0){
               request.setAttribute("trabajador",trabajador);
               RequestDispatcher rd = request.getRequestDispatcher("detalleTrabajador.jsp");
            rd.forward(request, response);
           }
           
       }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

  
}
