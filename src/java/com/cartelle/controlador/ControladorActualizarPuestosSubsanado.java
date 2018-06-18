
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.FechaSubsanado;
import java.io.IOException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ControladorActualizarPuestosSubsanado", urlPatterns = {"/ControladorActualizarPuestosSubsanado"})
public class ControladorActualizarPuestosSubsanado extends HttpServlet {
    DataSource datasource = null;
    Statement st = null;
    DbConnection cn = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       

        String fecha = request.getParameter("fechaSubsanado");
        String ide = request.getParameter("idEvaluacionPuestos");
        int idEvaluacionPuestos = Integer.parseInt(ide);
       

        
       try{
          
       FechaSubsanado cd = new FechaSubsanado();
        cd.setFechaSubsanado(fecha);
        cd.setIdEvaluacionPuesto(idEvaluacionPuestos);
        
        DbConnection con = new DbConnection();
        int i = con.nuevaFechaSubsanado(cd);
          
        if(i==1){
        RequestDispatcher rd = request.getRequestDispatcher("ControladorPlanificacionPuestos");
        rd.forward(request, response);
        }else{
          RequestDispatcher rd = request.getRequestDispatcher("#");
        rd.forward(request, response);   
        }
       }catch(Exception ex){
          
           System.out.println(ex.getMessage());
       }
    }
   

}
