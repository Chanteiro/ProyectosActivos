<%-- 
    Document   : detallePuesto
    Created on : 22-may-2018, 12:21:00
    Author     : ANTONIO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cartelle.modelo.Puestos"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>
<%
  Puestos p=(Puestos)request.getAttribute("puesto");  
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MMMM-yyyy");
   String observaciones,tareas,equipos,trabajadores,medidas,obsmedidas;
   String fecha="";
   try{
       fecha=sdf.format(p.getFechaTomaDatos());
   }catch(Exception e){
       fecha="Sin datos"; 
   }
  
   if(p.getObservaciones()==null){
       observaciones="Sin datos";
   }else{
       observaciones=p.getObservaciones().trim();
   }
   if(p.getTareasRealizadas()==null){
       tareas="Sin datos";
   }else{
       tareas=p.getTareasRealizadas().trim();
   }
   if(p.getEquiposTrabajo()==null){
       equipos="Sin datos";
   }else{
       equipos=p.getEquiposTrabajo().trim();
   }
   if(p.getTrabajadoresCondicionEspecial()==null){
       trabajadores="Sin datos";
   }else{
       trabajadores=p.getTrabajadoresCondicionEspecial().trim();
   }
   if(p.getMedidasPreventivasExistentes()==null){
       medidas="Sin datos";
   }else{
       medidas=p.getMedidasPreventivasExistentes().trim();
   }
   if(p.getObservacionesMedidasPreventivas()==null){
       obsmedidas="Sin datos";
   }else{
       obsmedidas=p.getObservacionesMedidasPreventivas().trim();
   }

%>
	<section >
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">PUESTO DE TRABAJO:&nbsp; <%=p.getCodPuesto()%>&nbsp;<%=p.getPuesto() %></h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="codPuesto" class="col-lg-2 control-label">Código Puesto</label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control" id="codPuesto" value="<%=p.getCodPuesto()%>"> 
                    </div>
                    <label for="puesto" class="col-lg-1 control-label">Puesto</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" id="puesto" value="<%=p.getPuesto()%>">
                    </div>
					<label for="fecha" class="col-lg-2 control-label">Fecha toma de datos</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="fecha" value="<%=fecha%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="observaciones" class="col-lg-2 control-label">Observaciones</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="observaciones"rows="3"><%=observaciones%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tareasrealizadas" class="col-lg-2 control-label">Tareas Realizadas</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="descripcion"rows="3"><%=tareas%></textarea>
                    </div>
                </div>
                 <div class="form-group">
                    <label for="equipostrabajo" class="col-lg-2 control-label">Equipos Trabajo</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="descripcion"rows="3"><%=equipos%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="trabajadores" class="col-lg-2 control-label">Trabajadores Condición Especial</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="trabajadores"rows="3"><%=trabajadores%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="medidas" class="col-lg-2 control-label">Medidas Preventivas Existentes</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="medidas"rows="3"><%=medidas%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="observacionesmedidas" class="col-lg-2 control-label">Observaciones Medidas Preventivas</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="observacionesmedidas"rows="3"><%=obsmedidas%></textarea>
                    </div>
                </div>
            </form>
        </div>
    </div>
	</section>
        
        <%@include file="jspf/pie.jspf"%>  