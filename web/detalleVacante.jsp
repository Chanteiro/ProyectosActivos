<%-- 
    Document   : detalleVacante
    Created on : 16-may-2018, 8:56:13
    Author     : ANTONIO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cartelle.modelo.Area"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>
<%
  Area a=(Area)request.getAttribute("area");  
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy"); 
String fecha=sdf.format(a.getFechaTomaDatos());
%>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">CÓDIGO DE ÁREA:&nbsp; <%=a.getCodArea() %>&nbsp;<%=a.getNombre() %></h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="row">
                <div class="form-group">
                    <label for="fechaDatos" class="col-lg-2 control-label">Fecha toma de datos</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" id="fechaDatos" placeholder="Fecha toma datos" value="<%=fecha%>">
                    </div>
                    
                    <div class="col-lg-3  text-center">
                        <a  href="#"><span class="glyphicon glyphicon-search"></span>&nbsp;Consultar las evaluaciones de ésta área</a>
                    </div>
                    <div class="col-lg-3  text-center">
                        <a  href="#"><span class="glyphicon glyphicon-search"></span>&nbsp;Consultar la ficha de instalación </a>
                    </div>
                </div>
                </div>
                    
                <div class="form-group">
                    <label for="observaciones" class="col-lg-2 control-label">Observaciones</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="observaciones" rows="3"><%=a.getObservacionesArea() %></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripcion" class="col-lg-2 control-label">Breve descripción del área</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="descripcion"rows="12"><%=a.getDescripcion() %></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sup" class="col-lg-2 control-label">Superficie aproximada en m<sup>2</sup></label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control" id="sup" value='<%=a.getSuperficie() %>'>
                    </div>
                    <label for="actividades" class="col-lg-2 control-label">Actividades realizadas</label>
                    <div class="col-lg-7">
                        <input type="text" class="form-control" id="actividades" placeholder="Actividades realizadas en la misma" value='<%=a.getActividadesRealizadas() %>'>
                    </div>
                </div>
                <div class="form-group">
                    <label for="instalaciones" class="col-lg-2 control-label">Instalaciones existentes</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="instalaciones"rows="8"><%=a.getInstalacionesExistentes() %></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="medidas" class="col-lg-2 control-label">Medidas preventivas</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="medidas"rows="8"><%=a.getMedidasPreventivasExistentes() %></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="observacionesmedidas" class="col-lg-2 control-label">Observaciones</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="observacionesmedidas"rows="8"><%=a.getObservacionesMedidasPreventivas() %></textarea>
                    </div>
                </div>
 
            </form>
        </div>
    </div>







</section>      





<%@include file="jspf/pie.jspf"%>  