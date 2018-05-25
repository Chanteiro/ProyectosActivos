<%-- 
    Document   : detalleTrabajador
    Created on : 25-may-2018, 9:18:59
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.Trabajador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>
<%
  Trabajador t=(Trabajador)request.getAttribute("trabajador");  
  
%>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">CÓDIGO DE TRABAJADOR:&nbsp; <%=t.getCodTrabajador()%></h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
               
                <div class="form-group">
                    <label for="empleo" class="col-lg-2 control-label">Empleo</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="empleo" placeholder="Empleo" value="<%=t.getEmpleo()%>">
                    </div>
                     <label for="nombre" class="col-lg-2 control-label">Nombre</label>
                    <div class="col-lg-6">
                        <input type="text" class="form-control" id="nombre" placeholder="nombre" value="<%=t.getNombre()%>">
                    </div>
                   
                </div>
                
                    
               
                <div class="form-group">
                    <label for="puesto" class="col-lg-2 control-label">Puesto de trabajo</label>
                    <div class="col-lg-10">
                       <input type="text" class="form-control" id="puesto" placeholder="Puesto de trabajo" value="<%=t.getPuesto()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="area" class="col-lg-2 control-label">Área de trabajo</label>
                    <div class="col-lg-10">
                       <input type="text" class="form-control" id="area" placeholder="Área de trabajo" value="<%=t.getArea()%>">
                    </div>
                </div>
                
 
            </form>
        </div>
    </div>







</section>      





<%@include file="jspf/pie.jspf"%>  