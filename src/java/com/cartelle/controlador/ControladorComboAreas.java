
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.ComboAreas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author ANTONIO
 */
public class ControladorComboAreas extends HttpServlet {
DataSource datasource = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DbConnection cn = null;
    ArrayList<ComboAreas> cmbArea = new ArrayList();

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
       try {
            String sql = "select idArea, codArea from areas_trabajo;";           

           DbConnection con = new DbConnection();
           cmbArea.clear();
           cmbArea= con.obtenerComboArea(sql);
           System.out.println(cmbArea);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        request.setAttribute("cmbArea", cmbArea);        
        RequestDispatcher rd = request.getRequestDispatcher("/formularioEvaluacionArea.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

}
