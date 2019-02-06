package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Puestos;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author ANTONIO
 */
public class detallePuesto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        Unidades uni = (Unidades) sesion.getAttribute("unidadSeleccionada");
        int unidad = uni.getIdUnidad();
        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        int id = Integer.parseInt(ide);
        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            Puestos puesto = con.getPuestobyId(id, unidad);
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            Date fecha = sdf.parse(request.getParameter("fecha"));
            p.setCodPuesto(request.getParameter("codPuesto"));
            p.setPuesto(request.getParameter("puesto"));
            p.setFechaTomaDatos(fecha);
            p.setObservaciones(request.getParameter("observaciones"));
            p.setTareasRealizadas(request.getParameter("tareasrealizadas"));
            p.setEquiposTrabajo(request.getParameter("equipostrabajo"));
            p.setTrabajadoresCondicionEspecial(request.getParameter("trabajadores"));
            p.setMedidasPreventivasExistentes(request.getParameter("medidas"));
            p.setObservacionesMedidasPreventivas(request.getParameter("observacionesmedidas"));
            String luz = request.getParameter("luz");
            String ruido = request.getParameter("ruido");
            String temp = request.getParameter("temp");

            if (luz.equals("") || luz.equals("Sin datos")) {
                p.setLuz(0);
            } else {
                p.setLuz(Float.parseFloat(luz));
            }
            if (ruido.equals("") || ruido.equals("Sin datos")) {
                p.setRuido(0);
            } else {
                p.setRuido(Float.parseFloat(ruido));
            }
            if (temp.equals("") || temp.equals("Sin datos")) {
                p.setTemp(0);
            } else {
                p.setTemp(Float.parseFloat(temp));
            }

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
