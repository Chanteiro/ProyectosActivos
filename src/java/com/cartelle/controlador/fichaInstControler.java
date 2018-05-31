
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.FichaInstalaciones;
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
@WebServlet(name = "fichaInstControler", urlPatterns = {"/fichaInstControler"})
public class fichaInstControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       String ide=request.getParameter("id");
       int id=Integer.parseInt(ide);
       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           FichaInstalaciones ficha=con.getFichabyId(id);
           if(ficha.getIdFicha()!= 0){
              System.out.println(id);
               request.setAttribute("ficha",ficha);
               RequestDispatcher rd = request.getRequestDispatcher("fichainstalacion.jsp");
            rd.forward(request, response);
           }
           
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}