<%-- 
    Document   : tablaDatos
    Created on : 21-may-2018, 11:46:56
    Author     : Administrador
--%>

<%@page import="com.cartelle.modelo.ConsultaEvaluacion"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<section>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title col-lg-10">Evaluaciones Puestos de Trabajo</h3>
            <button class="btn btn-gray bg-info text-info" onclick="document.location='ControladorComboPuestos'" name="nuevaEvaluacion">Nueva Evaluación</button>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="text-center">Codigo Area</th>
                    <th class="text-center">Codigo Puesto</th>
                    <th class="text-center">Tipo Evaluación</th>
                    <th class="text-center">Fecha Evaluación</th>
                    <th class="text-center"></th>
                </tr>
                </thead>
                <tbody>
                <%
                    ArrayList<ConsultaEvaluacion> datos = (ArrayList<ConsultaEvaluacion>) request.getAttribute("datos");
                    for (int i = 0; i < datos.size(); i++) {
                        
                        out.println("<tr>");
                        out.println("<td class='text-center'>" + datos.get(i).getCodigoarea() + "</td>");
                        out.println("<td class='text-center'>" + datos.get(i).getCodigopuesto() + "</td>");
                        out.println("<td class='text-center'>" + datos.get(i).getTipoevaluacion() + "</td>");
                        out.println("<td class='text-center'>" + datos.get(i).getFechaevaluacion() + "</td>");
                        out.println("<td class='text-center'><a href='ControladorPeligro?action=verdetalle&id=" + datos.get(i).getIdArea()+ "&id2=" + datos.get(i).getIdPuesto() + "'>ver detalle</a></td>");
                        out.println("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>