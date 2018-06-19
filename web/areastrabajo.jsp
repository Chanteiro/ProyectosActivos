<%-- 
    Document   : newjspareastrabajo
    Created on : 15-may-2018, 12:42:47
    Author     : ANTONIO
--%>

<%@page import="java.util.List"%>
<%@page import="com.cartelle.modelo.Area"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>
<%
    List<Area> areas = (List<Area>) request.getAttribute("areas");
%>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            
            <%
                if (user.getRol().equals("ADMIN_ESCANO")) {
                    out.println("<h3 class='panel-title col-lg-10'>RELACIÓN DE ÁREAS DE TRABAJO</h3>");
                    out.println("<a class='btn btn-gray bg-info text-info' href='detalleVacante?action=nueva&id=0'>Nueva Área</a>");
                }else{
                     out.println("<h3 class='panel-title'>RELACIÓN DE ÁREAS DE TRABAJO</h3>");
                }
            %>

        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>CÓDIGO ÁREA</th>
                        <th>ÁREA</th>
                        <th>DETALLE</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Area a : areas) {
                            out.println("<tr><td>" + a.getCodArea() + "</td><td>" + a.getNombre() + "</td><td><a href='detalleVacante?action=verdetalle&id=" + a.getId() + "'>ver detalle</a></td></tr>");
                        }
                    %>

                </tbody>
            </table>
        </div>
    </div>


</section>             
<%@include file="jspf/pie.jspf"%> 