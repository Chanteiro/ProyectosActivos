package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Noticia;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
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
        DbConnection con = new DbConnection();
       
        if (request.getParameter("titulo")==null|| request.getParameter("contenido")==null) {
            Noticia n = con.getNoticia();
            request.setAttribute("noti", n);
            RequestDispatcher rd = request.getRequestDispatcher("succes.jsp");
            rd.forward(request, response);
        }else{
             String tit = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
            if (con.actualizaNoticia(tit, contenido, 1) == 1) {
            Noticia n = con.getNoticia();
            request.setAttribute("noti", n);
            RequestDispatcher rd = request.getRequestDispatcher("succes.jsp");
            rd.forward(request, response);
        }
        }
        
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
        if (usu.getId() != 0) {
            HttpSession sesion = request.getSession();
            sesion.setAttribute("user", usu);
            DbConnection con = new DbConnection();
            Noticia n = con.getNoticia();
            request.setAttribute("noti", n);
            RequestDispatcher rd = request.getRequestDispatcher("succes.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

}
