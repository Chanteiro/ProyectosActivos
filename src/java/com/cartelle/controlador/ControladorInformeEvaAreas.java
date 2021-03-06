package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author ANTONIO
 */
public class ControladorInformeEvaAreas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sesion = request.getSession();
            Usuario user = (Usuario) sesion.getAttribute("user");
            Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
            int unidad = uni.getIdUnidad();
            String serviPreven = uni.getServicioPrevencion();
            File reportFile = new File(getServletContext().getRealPath("/WEB-INF/evaluacionAreas.jasper"));
            DbConnection con = new DbConnection();

            Map parameters = new HashMap();
            parameters.put("servicio", serviPreven);
            parameters.put("unidadActual", unidad);
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getAbsolutePath(), parameters, con.obtenerConexion());
            response.setHeader("Content-Disposition", "attachment; filename=\"InformeEvaluacionAreas.pdf\";");
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            ServletOutputStream ouputStream = response.getOutputStream();
            ouputStream.write(bytes, 0, bytes.length);
            ouputStream.flush();

        } catch (IOException | JRException e) {
            System.out.println(e.getMessage());
           
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
