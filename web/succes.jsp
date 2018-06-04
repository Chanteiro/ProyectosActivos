<%-- 
    Document   : succes
    Created on : 14-mar-2018, 8:18:25
    Author     : ANTONIO
--%>




<%@page import="com.cartelle.modelo.Noticia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>
<%
  Noticia n=(Noticia)request.getAttribute("noti");  
   
%>
<section >
    <br>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"><%= n.getTitulo() %></h3>
        </div>
        <div class="panel-body">
           <%= n.getContenido() %>
        </div>
    </div>
</section>             
<%@include file="jspf/pie.jspf"%>               
