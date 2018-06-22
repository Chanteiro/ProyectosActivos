package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Area;
import com.cartelle.modelo.Zona_medicion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
public class detalleZona extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        String ide = request.getParameter("id");
        int zona = Integer.parseInt(request.getParameter("idZona"));
        int id = Integer.parseInt(ide);
        System.out.println(action);
       
        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            Area a = con.getAreabyId(id);
            if (a.getId() != 0) {
                for (Zona_medicion z : a.getZonas()) {
                    if (z.getIdZona() == zona) {
                        request.setAttribute("zona", z);
                        RequestDispatcher rd = request.getRequestDispatcher("detalleZona.jsp");
                        rd.forward(request, response);
                    }
                }
            }

        }
        if (action.equals("irArea")) {
//            request.setAttribute("action", "verdetalle");
//            request.setAttribute("id", ide);
            System.out.println("Aqui-->"+request.getParameter("action"));
            RequestDispatcher rd = request.getRequestDispatcher("detalleVacante");
            rd.forward(request, response);
        }
        if (action.equals("borrar")) {
            DbConnection con = new DbConnection();
            if (con.borraZona(zona) == 1) {
//                request.setAttribute("action", "verdetalle");
//                request.setAttribute("id", ide);
                RequestDispatcher rd = request.getRequestDispatcher("detalleVacante");
                rd.forward(request, response);
            }
        }
        if (action.equals("nueva")) {

            request.setAttribute("zona", new Zona_medicion());
            RequestDispatcher rd = request.getRequestDispatcher("detalleZona.jsp");
            rd.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("idZona");
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        String luz = request.getParameter("luz");
        String ruido = request.getParameter("ruido");
        String temp = request.getParameter("temp");
        String areaFK = request.getParameter("areaFK");
        Zona_medicion z = new Zona_medicion();
        if (request.getParameter("flag").equals("no")) {
            z.setIdZona(0);
        } else {
            z.setIdZona(Integer.parseInt(id));
        }
        z.setNombre(nombre);
        z.setDescripcion(descripcion);

        if (!luz.equals("")) {
            z.setLuz(Float.parseFloat(luz));
        }
        if (!ruido.equals("")) {
            z.setRuido(Float.parseFloat(ruido));
        }
        if (!temp.equals("")) {
            z.setTemp(Float.parseFloat(temp));
        }
        z.setIdAreaFK(Integer.parseInt(areaFK));
        System.out.println(z.toString());
        DbConnection con = new DbConnection();
        int r = 0;
        if (request.getParameter("flag").equals("no")) {
            r = con.nuevaZona(z);
            if (r == 1) {
                request.setAttribute("action2", "irArea");
                request.setAttribute("id", z.getIdAreaFK());
                doGet(request, response);

            }
        } else {
            r = con.actualizaZona(z);
            if (r == 1) {
                request.setAttribute("action2", "irArea");
                request.setAttribute("id", z.getIdAreaFK());
                doGet(request, response);

            }
        }

    }

}
