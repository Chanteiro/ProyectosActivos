<%-- 
    Document   : puestoTrabajo
    Created on : 21-may-2018, 12:13:27
    Author     : ANTONIO
--%>

<%@page import="java.util.List"%>
<%@page import="com.cartelle.modelo.Puestos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@include file="jspf/encabezado.jspf"%>
<%
    List<Puestos> puestos = (List<Puestos>) request.getAttribute("puestos");
%>

<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">PUESTOS DE TRABAJO</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>CÓDIGO PUESTO</th>
                        <th>PUESTO</th>
                        <th>ÁREA</th>
                        <th>DETALLE</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Puestos p : puestos) {
                            out.println("<tr><td>" + p.getCodPuesto() + "</td><td>" + 
                                    p.getPuesto() + "</td><td><a href='detalleVacante?action=verdetalle&id=" + p.getIdArea()+ "'>"+ p.getCodArea() + "</a>" 
                                     +"</td><td><a href='detallePuesto?action=verdetalle&id=" + p.getIdPuesto()+ "'>ver detalle</a></td></tr>");
                        }
                    %> 
                </tbody>
            </table>
        </div>
    </div>
</section>

<%@include file="jspf/pie.jspf"%>	