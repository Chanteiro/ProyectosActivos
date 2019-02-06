package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Noticia;
import com.cartelle.modelo.Unidades;
import com.cartelle.modelo.Usuario;
import java.io.IOException;
import java.util.List;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DbConnection con = new DbConnection();
        String servicio = null;
        String ciu = null;
        HttpSession sesion = request.getSession(true);
        Usuario usuario = new Usuario();
        Usuario usu = new Usuario();
        String destino = null;

        if (request.getParameter("titulo") == null || request.getParameter("contenido") == null) {
            Noticia n = con.getNoticia();
            request.setAttribute("noti", n);

        } else {
            String tit = request.getParameter("titulo");
            String contenido = request.getParameter("contenido");
            if (con.actualizaNoticia(tit, contenido, 1) == 1) {
                Noticia n = con.getNoticia();
                request.setAttribute("noti", n);
            }
        }

        if (sesion.getAttribute("user") == null) {
            String user = request.getParameter("username");
            String password = request.getParameter("password");
            usuario.setUsername(user);
            usuario.setPassword(password);
            usu = usuario.validate();//Aqui ya tengo el usario completo con su rol
        } else {
            usu = (Usuario) sesion.getAttribute("user");
        }

        if (usu.getId() != 0) {

            Noticia n = con.getNoticia();
            request.setAttribute("noti", n);
            //Aqui con un swich determino el rol del usuario.
            /*
            Si el rol es ADMIN_ESCAÑO lo hay que redirigir a un jsp con un formulario en donde seleccione la unidad 
            sobre la que quiere  trabajar.
            Si el rol es SEGOP_ESCAÑO se le redirige a "succes.jsp"
             */
//            RequestDispatcher rd = null;
            System.out.println(usu.getRol());
            switch (usu.getRol()) {

                case "ADMIN_ESCANO":
                    servicio = "SP FERROL (ESCAÑO - ESENGRA)";
                    try {
                        List<Unidades> unidades = con.obtenerUnidades(servicio);
                        usu.setUnidades(unidades);
                        sesion.setAttribute("user", usu);
                        destino = "SeleccionUnidades.jsp";

                    } catch (Exception e) {
                        System.out.println("No se pudo enviar ADMIN");

                        e.printStackTrace();
                    }
                    break;
                case "SEGOP_ESCANO":
                    servicio = "SP FERROL (ESCAÑO - ESENGRA)";
                    ciu = "63206402";

                    try {
                        usu.setUnidades(con.obtenerUnidadesByIdAndCiu(servicio, ciu));
                        Unidades unidadSeleccionada=usu.getUnidades().get(0);
                        sesion.setAttribute("user", usu);
                        sesion.setAttribute("unidadSeleccionada",unidadSeleccionada);
                        destino = "succes.jsp";

                    } catch (Exception e) {
                        System.out.println("No se pudo enviar SEGOP");
                        e.printStackTrace();
                    }
                    break;

            }

            RequestDispatcher rd = request.getRequestDispatcher(destino);
            rd.include(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
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
