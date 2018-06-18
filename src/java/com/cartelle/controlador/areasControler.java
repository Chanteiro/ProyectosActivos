package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Area;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class areasControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        if (user.getRol().equals("ADMIN_ESCANO") || user.getRol().equals("SEGOP_ESCANO")) {
            DbConnection con = new DbConnection();
            List<Area> areas = con.obtenerAreas();
            if (areas.size() > 0) {
                request.setAttribute("areas", areas);
                RequestDispatcher rd = request.getRequestDispatcher("areastrabajo.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Area a = new Area(Integer.parseInt(request.getParameter("iden")));
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = sdf.parse(request.getParameter("fecha"));
            a.setFechaTomaDatos(fecha);
            a.setObservacionesArea(request.getParameter("observaciones"));
            a.setDescripcion(request.getParameter("descripcion"));
            a.setSuperficie(Integer.parseInt(request.getParameter("sup")));
            a.setActividadesRealizadas(request.getParameter("actividades"));
            a.setInstalacionesExistentes(request.getParameter("instalaciones"));
            a.setMedidasPreventivasExistentes(request.getParameter("medidas"));
            a.setObservacionesMedidasPreventivas(request.getParameter("observacionesmedidas"));

            DbConnection con = new DbConnection();
            if (con.actualizaArea(a, a.getId()) == 1) {
                doGet(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            };
        } catch (ParseException ex) {
            Logger.getLogger(detalleArea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
