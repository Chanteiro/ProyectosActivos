package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.FichaInstalaciones;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
@WebServlet(name = "fichaInstControler", urlPatterns = {"/fichaInstControler"})
public class fichaInstControler extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String ide = request.getParameter("id");
        int id = Integer.parseInt(ide);
        if (action.equals("verdetalle")) {
            DbConnection con = new DbConnection();
            FichaInstalaciones ficha = con.getFichabyId(id);
            if (ficha.getIdFicha() != 0) {
                System.out.println(id);
                request.setAttribute("ficha", ficha);
                RequestDispatcher rd = request.getRequestDispatcher("fichainstalacion.jsp");
                rd.forward(request, response);
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FichaInstalaciones fi = new FichaInstalaciones();
        fi.setIdFicha(Integer.parseInt(request.getParameter("id")));
        fi.setRampas_de_circulacion(request.getParameter("rampas"));
        fi.setCirculacion_interior(request.getParameter("circulacion"));
        fi.setEscaleras_fijas(request.getParameter("escfijas"));
        fi.setEscaleras_mano(request.getParameter("escmano"));
        fi.setAlmacenamiento_altura(request.getParameter("almacenamiento"));
        fi.setConducciones_fluidos_presion(request.getParameter("fluidos"));
        fi.setCalderas(request.getParameter("calderas"));
        fi.setDepositos_presion(request.getParameter("depositos"));
        fi.setBotellas_presion(request.getParameter("botellas"));
        fi.setCintas_transportadoras(request.getParameter("cintas"));
        fi.setAscensores_montacargas(request.getParameter("ascensores"));
        fi.setPlataformas_elevadoras(request.getParameter("plataformas"));
        fi.setGruas_polipastos(request.getParameter("gruas"));
        fi.setCarretillas_elevadoras(request.getParameter("carretillas"));
        fi.setArea_carga_baterias(request.getParameter("baterias"));
        fi.setExtintores(request.getParameter("extintores"));
        fi.setBie(request.getParameter("bie"));
        fi.setDeteccion_incendios(request.getParameter("detincendios"));
        fi.setOtros(request.getParameter("otros"));
        DbConnection con = new DbConnection();
        if (con.actualizaFicha(fi, fi.getIdFicha()) == 1) {
           
            doGet(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
        
    }

}
