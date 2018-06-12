package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.ComboCodigoPeligro;
import com.cartelle.modelo.ComboPuestos;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author ANTONIO
 */
public class ControladorComboPuestos extends HttpServlet {

    DataSource datasource = null;
    Statement st = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    DbConnection cn = null;
    ArrayList<ComboPuestos> cmbPuesto = new ArrayList();
    ArrayList<ComboCodigoPeligro> cmbCodigoPeligro = new ArrayList();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String sql = "select idPuesto, codPuesto, puesto from puestos_trabajo;";

            DbConnection con = new DbConnection();
            cmbPuesto.clear();
            cmbPuesto = con.obtenerComboPuestos(sql);

            String sql2 = "select idCodigo, codigo from codigos_peligro;";
            DbConnection cn = new DbConnection();
            cmbCodigoPeligro.clear();
            cmbCodigoPeligro = cn.obtenerComboCodigoPeligro(sql2);

            request.setAttribute("cmbPuesto", cmbPuesto);
            request.setAttribute("cmbCodigoPeligro", cmbCodigoPeligro);
            RequestDispatcher rd = request.getRequestDispatcher("nuevaEvaluacion.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
