<%-- 
    Document   : trabajadores
    Created on : 24-may-2018, 13:15:51
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.Trabajador"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>
<%
 List<Trabajador> trab=(List<Trabajador>)request.getAttribute("trabajadores");
%>
<section >
    
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">RELACIÓN DE TRABAJADORES</h3>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
    <thead>
      <tr>
        <th>CÓDIGO TRABAJADOR</th>
        <th>EMPLEO</th>
        <th>NOMBRE</th>
        <th>PUESTO DE TRABAJO</th>
        <th>DETALLES</th>
      </tr>
    </thead>
    <tbody>
        <% for(Trabajador t:trab){
          out.println("<tr><td>"+t.getCodTrabajador()+"</td><td>"+t.getEmpleo()+"</td><td>"+t.getNombre()+"</td><td>"+t.getPuesto()+"</td><td><a href='detalleTrabajador?action=verdetalle&id="+t.getId()+"'>ver detalle</a></td></tr>");
        }
       %>
     
    </tbody>
  </table>
        </div>
    </div>
   
    
</section>             
<%@include file="jspf/pie.jspf"%> 