package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Puestos;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
public class detallePuesto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        int id = Integer.parseInt(ide);
        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            Puestos puesto = con.getPuestobyId(id);
            if (puesto.getIdPuesto() != 0) {
                request.setAttribute("puesto", puesto);
                RequestDispatcher rd = request.getRequestDispatcher("detallePuesto.jsp");
                rd.forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Puestos p = new Puestos();
            p.setIdPuesto(Integer.parseInt(request.getParameter("id")));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(request.getParameter("fecha"));
            System.out.println(request.getParameter("fecha"));
            p.setCodPuesto(request.getParameter("codPuesto"));
            p.setPuesto(request.getParameter("puesto"));
            p.setFechaTomaDatos(fecha);
            p.setObservaciones(request.getParameter("observaciones"));
            p.setTareasRealizadas(request.getParameter("tareasrealizadas"));
            p.setEquiposTrabajo(request.getParameter("equipostrabajo"));
            p.setTrabajadoresCondicionEspecial(request.getParameter("trabajadores"));
            p.setMedidasPreventivasExistentes(request.getParameter("medidas"));
            p.setObservacionesMedidasPreventivas(request.getParameter("observacionesmedidas"));
            p.setLuz(Integer.parseInt(request.getParameter("luz")));
            p.setRuido(Integer.parseInt(request.getParameter("ruido")));
            p.setTemp(Integer.parseInt(request.getParameter("temp")));
            
            DbConnection con = new DbConnection();
            if (con.actualizaPuesto(p, p.getIdPuesto()) == 1) {
                doGet(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(detalleArea.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
