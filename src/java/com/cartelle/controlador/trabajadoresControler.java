
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Trabajador;
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
public class trabajadoresControler extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
       
            DbConnection con=new DbConnection();
            List<Trabajador> trabajadores=con.obtenerTrabajadores();

            request.setAttribute("trabajadores",trabajadores);
            RequestDispatcher rd = request.getRequestDispatcher("trabajadores.jsp");
            rd.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        Trabajador t=new Trabajador();
        t.setId(Integer.parseInt(request.getParameter("id")));
        t.setNombre(request.getParameter("nombre"));
        t.setEmpleo(request.getParameter("empleo"));
       
         DbConnection con=new DbConnection();
         int i=con.actualizaTrabajador(t);
         if(i==1){
             doGet(request,response);
         }else{
             System.out.println("No se ha podido actualizar");
         }
         
    }catch(Exception e){
        e.printStackTrace();
    }

    } 
}
