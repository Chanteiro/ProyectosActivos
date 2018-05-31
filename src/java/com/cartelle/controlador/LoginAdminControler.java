package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.LoginAdmin;
import com.cartelle.modelo.Usuario;
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
public class LoginAdminControler extends HttpServlet {

    ArrayList<LoginAdmin> login = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DbConnection con = new DbConnection();
        String accion = request.getParameter("accion");
        if (accion != null) {
            if (accion.equals("borrar")) {
                con.borraUsuario(Integer.parseInt(request.getParameter("id")));
                try {
                    String sql = "Select idLogin, usuario, contrasena, nombreCompleto, rol from LOGIN;";

                    login.clear();
                    login = con.buscar(sql);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                request.setAttribute("login", login);

                RequestDispatcher rd = request.getRequestDispatcher("/loginAdmin.jsp");
                rd.forward(request, response);
            }
        } else {
            try {
                String sql = "Select idLogin, usuario, contrasena, nombreCompleto, rol from LOGIN;";

                login.clear();
                login = con.buscar(sql);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            request.setAttribute("login", login);

            RequestDispatcher rd = request.getRequestDispatcher("/loginAdmin.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = new Usuario();
        if(request.getParameter("iden")==null){
            System.out.println("true id=0");
             usuario.setId(0);
        }else{
             System.out.println("false id="+usuario.getId());
             usuario.setId(Integer.parseInt(request.getParameter("iden")));
        }
       
        usuario.setNombre(request.getParameter("name"));
        usuario.setUsername(request.getParameter("usuario"));
        usuario.setPassword(request.getParameter("contrasena"));
        if (request.getParameter("rol").equals("Seleccione")) {
            usuario.setRol("SEGOP_ESCANO");
        } else {
            usuario.setRol(request.getParameter("rol"));
        }
        if (usuario.getId() == 0) {//Si id=0 inserto nuevo usuario...
            DbConnection con = new DbConnection();
            if (con.insertaUsuario(usuario)) {
                doGet(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            };
        }else{//Si id>0 hay que actualizar...
            DbConnection con = new DbConnection();
            if(con.actualizaUsuario(usuario,usuario.getId())==1){
                doGet(request, response); 
            }else{
                 RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            };
            
        }
    }

}
