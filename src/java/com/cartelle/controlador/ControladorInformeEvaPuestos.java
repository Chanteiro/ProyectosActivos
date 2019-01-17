
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author ANTONIO
 */
public class ControladorInformeEvaPuestos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            File reportFile = new File(getServletContext().getRealPath("/WEB-INF/EvaluacionPuestos.jasper"));
            DbConnection con = new DbConnection();

            Map parameters = new HashMap();
            parameters.put("servicio", "ESCAÑO-ESENGRA");
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getAbsolutePath(), parameters, con.obtenerConexion());
            response.setHeader("Content-Disposition", "attachment; filename=\"InformeEvaluacionPuestos.pdf\";");
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();

        } catch (IOException | JRException e) {
            System.out.println(e.getMessage());
            //System.out.println(reportFile.exists());
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   

}
