
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

@WebServlet(name = "ControladorActualizarAreasSubsanado", urlPatterns = {"/ControladorActualizarAreasSubsanado"})
public class ControladorActualizarAreasSubsanado extends HttpServlet {
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
        String ide = request.getParameter("idEvaluacionArea");
        int idEvaluacionArea = Integer.parseInt(ide);
        String subsanador= request.getParameter("subsanador");
        
       try{
          
       FechaSubsanado cd = new FechaSubsanado();
        cd.setFechaSubsanado(fecha);
        cd.setIdEvaluacionArea(idEvaluacionArea);
        cd.setSubsanador(subsanador);
        
        DbConnection con = new DbConnection();
        int i = con.nuevaFechaSubsanadoArea(cd);
           System.out.println(i);
        if(i==1){
        RequestDispatcher rd = request.getRequestDispatcher("ControladorPlanificacionAreas");
        rd.forward(request, response);
        }else{
          RequestDispatcher rd = request.getRequestDispatcher("#");
        rd.forward(request, response);   
        }
       }catch(Exception ex){
          
           System.out.println(ex.getMessage());
       }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
