
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Puestos;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
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
public class puestosController extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        if(user.getRol().equals("ADMIN_ESCANO")||user.getRol().equals("SEGOP_ESCANO")){
            DbConnection con=new DbConnection();
            List<Puestos> puestos=con.obtenerPuestos();
            if(puestos.size()>0){
            request.setAttribute("puestos",puestos);
            RequestDispatcher rd = request.getRequestDispatcher("puestoTrabajo.jsp");
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
      
    }

 
}
