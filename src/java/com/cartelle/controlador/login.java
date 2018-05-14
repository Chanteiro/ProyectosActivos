package com.cartelle.controlador;

import com.cartelle.modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("username");
        String password = request.getParameter("password");
        Usuario usuario = new Usuario();
        usuario.setUsername(user);
        usuario.setPassword(password);
        Usuario usu = usuario.validate();
//        request.setAttribute("user", usuario);
        if (usu.getId()!=0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("user", usu);
            RequestDispatcher rd = request.getRequestDispatcher("succes.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

}
