package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.ConsultaPeligro;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ControladorPeligro", urlPatterns = {"/ControladorPeligro"})
public class ControladorPeligro extends HttpServlet {

    DataSource datasource = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DbConnection cn = null;
    ArrayList<ConsultaPeligro> datos = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        String ide2 = request.getParameter("id2");
        int idArea = Integer.parseInt(ide);
        int idPuesto = Integer.parseInt(ide2);
        if (action.equals("verdetalle")||action.equals("verEva")) {
            DbConnection con = new DbConnection();
            ArrayList<ConsultaPeligro> datos = con.getPeligroById(idArea, idPuesto);

            request.setAttribute("datos", datos);
            RequestDispatcher rd = request.getRequestDispatcher("consultaPeligro.jsp");
            rd.forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }
}
