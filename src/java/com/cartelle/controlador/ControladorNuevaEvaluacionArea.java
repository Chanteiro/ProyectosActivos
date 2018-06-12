
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.EvaluacionesArea;
import java.io.IOException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ControladorNuevaEvaluacionArea", urlPatterns = {"/ControladorNuevaEvaluacionArea"})
public class ControladorNuevaEvaluacionArea extends HttpServlet {
    DataSource datasource = null;
    Statement st = null;
    DbConnection cn = null;

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        try {
        String ide0 = request.getParameter("idAreaFK");
         int idAreaFK = Integer.parseInt(ide0);
        String tipoEvaluacion = request.getParameter("tipoEvaluacion");
        String fecha = request.getParameter("fechaEvaluacion");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaEvaluacion = sdf.parse(fecha);
        String ide = request.getParameter("codPeligroFK");
        int codPeligroFK = Integer.parseInt(ide);
        String ide1= request.getParameter("nDeficiencia");
        int nDeficiencia = Integer.parseInt(ide1);
        String  ide2= request.getParameter("nExposicion");
        int nExposicion= Integer.parseInt(ide2);
        String ide3 = request.getParameter("nProbabilidad");
        int nProbabilidad= Integer.parseInt(ide3);
        String ide4 = request.getParameter("nConsecuencias");
        int nConsecuencias= Integer.parseInt(ide4);
        String ide5 = request.getParameter("nRiesgo");
        int nRiesgo= Integer.parseInt(ide5);
        String nIntervencion = request.getParameter("nIntervencion");
        String factorRiesgo = request.getParameter("factorRiesgo");
        String medidaPropuesta = request.getParameter("medidaPropuesta");
        String normativa = request.getParameter("normativa");
          
       EvaluacionesArea cd = new EvaluacionesArea ();
        
        cd.setIdAreaFK(idAreaFK);
        cd.setTipoEvaluacion(tipoEvaluacion);
        cd.setFechaEvaluacion(fechaEvaluacion);
        cd.setCodPeligroFK(codPeligroFK);
        cd.setnDeficiencia(nDeficiencia);
        cd.setnExposicion(nExposicion);
        cd.setnProbabilidad(nProbabilidad);
        cd.setnConsecuencias(nConsecuencias);
        cd.setnRiesgo(nRiesgo);
        cd.setnIntervencion(nIntervencion);
        cd.setFactorRiesgo(factorRiesgo);
        cd.setMedidaPropuesta(medidaPropuesta);
        cd.setNormativa(normativa);
        DbConnection con = new DbConnection();
        int i = con.nuevaEvaluacionArea(cd);
           System.out.println(i);
        if(i==1){
        RequestDispatcher rd = request.getRequestDispatcher("tablaEvaluacionesControler?action=verdetalle");
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
