/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cartelle.controlador;

import com.cartelle.dao.DbConnection;
import com.cartelle.modelo.Area;
import com.cartelle.modelo.Puestos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANTONIO
 */
public class detallePuesto extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
       String ide=request.getParameter("id");
       int id=Integer.parseInt(ide);
       if(action.equals("verdetalle")){
           DbConnection con=new DbConnection();
           Puestos puesto=con.getPuestobyId(id);
           if(puesto.getIdPuesto()!=0){
               request.setAttribute("puesto",puesto);
               RequestDispatcher rd = request.getRequestDispatcher("detallePuesto.jsp");
            rd.forward(request, response);
           }
           
       }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
}
