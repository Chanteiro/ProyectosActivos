
package com.cartelle.controlador;
import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.EvaluacionesArea;
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
@WebServlet(name = "fichaEvaluacionControler", urlPatterns = {"/fichaEvaluacionControler"})
public class fichaEvaluacionControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String action=request.getParameter("action");
       String ide1=request.getParameter("id1");
       String ide2=request.getParameter("id2");
       int id1=Integer.parseInt(ide1);
       int id2=Integer.parseInt(ide2);
       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           EvaluacionesArea evaluacion=con.getEvaluacionbyID(id1,id2);
           if(evaluacion.getIdEvaluacionArea()!=0){
              System.out.println(id1+id2);
               request.setAttribute("evaluacion",evaluacion);
               RequestDispatcher rd = request.getRequestDispatcher("evaluacionesArea.jsp");
            rd.forward(request, response);
           }
           
       }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
