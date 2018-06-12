<%-- 
    Document   : tablaEvaluacionesArea
    Created on : 15-may-2018, 12:42:47
    Author     : ANTONIO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.awt.Color"%>
<%@page import="com.cartelle.modelo.EvaluacionesArea"%>
<%@page import="com.cartelle.modelo.FichaInstalaciones"%>
<%@page import="java.util.List"%>
<%@page import="com.cartelle.modelo.Area"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<%
 List<EvaluacionesArea> evaluaciones=(List<EvaluacionesArea>)request.getAttribute("evaluaciones"); 
EvaluacionesArea ea=new EvaluacionesArea();
ea= evaluaciones.get(0);
%>

<section >
    
    <div class="panel panel-primary">
			<div class="panel-heading">
                            <h3 class="panel-title col-lg-10">EVALUACIONES POR ÁREA</h3>
                            <a class="btn btn-gray bg-info text-info" href="ControladorComboAreas">Nueva Evaluación</a>
			</div>
			<div class="panel-body">
    
   <div class="table-responsive-lg">
  
	<table class="table">
	  <thead class="thead-dark">
		<tr>
		  <th scope="col">CÓDIGO ÁREA</th>
		  <th scope="col">TIPO EVALUACIÓN</th>
		  <th scope="col">NIVEL DE INTERVENCIÓN</th>
		  <th scope="col">FECHA DE EVALUACIÓN</th>
		  <th scope="col">DETALLES</th>
		</tr>
	  </thead>
	  <tbody>
                 <% for(EvaluacionesArea e:evaluaciones){        
                     out.println("<tr><td>"+e.getCodArea()+"</td><td>"+e.getTipoEvaluacion()+"</td><td>"+e.getnIntervencion()+"</td><td>"+e.getFechaEvaluacion()+"</td><td><a href='fichaEvaluacionControler?action=verdetalle&id1="+e.getIdAreaFK()+"&id2="+e.getIdEvaluacionArea()+"'>ver detalle</a></td></tr>");
        }
       %>
	  </tbody>
	</table>
	
</div>
                        </div>
    
</section>             
<%@include file="jspf/pie.jspf"%> 
