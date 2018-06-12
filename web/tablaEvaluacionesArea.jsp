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
                            <h3 class="panel-title">ÁREA:&nbsp;<%= ea.getCodArea() %>&nbsp;<%= ea.getNombreArea()%></h3>
			</div>
			<div class="panel-body">
    
   <div class="table-responsive-lg">
  
	<table class="table">
	  <thead class="thead-dark">
		<tr>
		  <th scope="col">EVALUACION</th>
		  <th scope="col">ND</th>
		  <th scope="col">NE</th>
		  <th scope="col">NP</th>
		  <th scope="col">NC</th>
		  <th scope="col">NR</th>
		  <th scope="col">NI</th>
		  <th scope="col">FECHA RIESGO</th>
		  <th scope="col">DETALLES</th>
		</tr>
	  </thead>
	  <tbody>
              <%--   <tr>
                  <th scope="row">AREA</th>
                  <td>ND</td>
                  <td>NE</td>
                  <td>NP</td>
                  <td>NC</td>
                  <td>NR</td>
                  <td>NI</td>
                  <td>FECHA RIESGO</th>
                  <td><a href="evaluacionesArea.jsp">Ver Detalles</a></td>
                </tr>
              --%>
                 <% for(EvaluacionesArea e:evaluaciones){
                     
                      String c= e.getnIntervencion();
                      String color="";
                         System.out.println(c);
                         if (c==null||c.equals("null")){
                             color= "w";
                         }else {
                         
                         switch(c){
                              case "I":
                                 color= "r";
                                 System.out.println(color);
                                 break;
                             case "II":
                                 color = "y";
                                 System.out.println(color);
                                 break;
                             case "III":
                                 color= "g";
                                 System.out.println(color);
                                 break;
                             case "IV":
                                 color = "b";
                                 System.out.println(color);
                                 break;
                            
                         }
                         }
                         
                    
                     out.println("<tr class='" + color + "'><td>"+e.getIdEvaluacionArea()+"</td><td>"+e.getnDeficiencia()+"</td><td>"+e.getnExposicion()+"</td><td>"+e.getnProbabilidad()+"</td><td>"+e.getnConsecuencias()+"</td><td>"+e.getnRiesgo()+"</td><td>"+e.getnIntervencion()+"</td><td>"+e.getFechaEvaluacion()+"</td><td><a href='fichaEvaluacionControler?action=verdetalle&id1="+e.getIdAreaFK()+"&id2="+e.getIdEvaluacionArea()+"'>ver detalle</a></td></tr>");
        }
       %>
	  </tbody>
	</table>
	
</div>
                        </div>
    
</section>             
<%@include file="jspf/pie.jspf"%> 
