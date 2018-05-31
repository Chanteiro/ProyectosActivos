package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.LoginAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
public class detalleLoginAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("Detalles")) {
            String ide = request.getParameter("id");
            int idLogin = Integer.parseInt(ide);
            DbConnection cn = new DbConnection();
            LoginAdmin lg = cn.getLoginAdminById(idLogin);
            ArrayList<String> roles = new ArrayList();
            roles = cn.buscarRol();
            if (lg.getIdLogin() != 0) {
                request.setAttribute("action",action);
                request.setAttribute("Lg", lg);
                request.setAttribute("roles", roles);
                RequestDispatcher rd = request.getRequestDispatcher("detalleLoginAdmin.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                rd.forward(request, response);
            }

        }
        if(action.equals("nuevoUser")){
            request.setAttribute("action",action);
             DbConnection cn = new DbConnection();
            ArrayList<String> roles = new ArrayList();
            roles = cn.buscarRol();
            request.setAttribute("roles", roles);
            RequestDispatcher rd = request.getRequestDispatcher("detalleLoginAdmin.jsp");
                rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
