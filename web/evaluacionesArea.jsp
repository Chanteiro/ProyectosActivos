<%-- 
    Document   : evaluacionesArea
    Created on : 15-may-2018, 12:42:47
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.EvaluacionesArea"%>
<%@page import="com.cartelle.modelo.FichaInstalaciones"%>
<%@page import="java.util.List"%>
<%@page import="com.cartelle.modelo.Area"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<% EvaluacionesArea evaluacion=(EvaluacionesArea)request.getAttribute("evaluacion"); 
String c= evaluacion.getnIntervencion();
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

%>

<section >
    <div class="panel panel-primary">
			<div class="panel-heading">
                            <h3 class="panel-title">EVALUACIÓN AREA:&nbsp;<%= evaluacion.getCodArea()%>&nbsp;<%= evaluacion.getNombreArea()%></h3>
			</div>
			<div class="panel-body">
        <div class="form-group">
		<div class="col-lg 6">
           <div class="row">
              <div class="col-lg-2 ">
                <label for="firstName">NUM. DEFICIENCIA</label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="<%=evaluacion.getnDeficiencia()%>" required>
                <div class="invalid-feedback">
           
                </div>
              </div>
              <div class="col-lg-2">
                <label for="lastName">NUM. EXPOSICIÓN</label>
                <input type="text" class="form-control" id="lastName" placeholder="" value="<%=evaluacion.getnExposicion() %>" required>
              </div>
			  <div class="col-lg-2 ">
                <label for="firstName">NIVEL PROBABILIDAD </label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="<%=evaluacion.getnProbabilidad() %>" required>
                <div class="invalid-feedback">
                </div>
              </div>
              <div class="col-lg-2">
                <label for="lastName">NIVEL CONSECUENCIA</label>
                <input type="text" class="form-control" id="lastName" placeholder="" value="<%=evaluacion.getnConsecuencias() %>" required>
              </div>
			  <div class="col-lg-2 ">
                <label for="firstName">NIVEL RIESGO</label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="<%=evaluacion.getnRiesgo() %>" required>
                <div class="invalid-feedback">
                </div>
              </div>
              <div class="col-lg-2">
                <label for="lastName">NIVEL INTERVENCIÓN</label>
                <input type="text" class="form-control <%= color %>" id="lastName" placeholder="" value="<%=evaluacion.getnIntervencion() %>" required>
              </div>
           </div>
                </div>
	  </div>
	  
	  <div class="form-group">
	  <div class="col-lg 6">
            <div class="row">
              <div class="col-lg-9 ">
                <label for="firstName">TIPO EVALUACIÓN</label>
                <input type="text" class="form-control" id="firstName" placeholder="" value="<%=evaluacion.getTipoEvaluacion() %>" required>
                <div class="invalid-feedback">
                </div>
              </div>
              <div class="col-lg-3">
                <label for="lastName">FECHA EVALUACIÓN</label>
                <input type="text" class="form-control" id="lastName" placeholder="" value="<%=evaluacion.getFechaEvaluacion() %>" required> 
                </div>
              </div>
	  </div>
              
          </div>
        <div class="form-group">
	    
      <div class="row">
          <div class="col-lg-12">
              <label for="address">FACTOR RIESGO</label>
              <input type="text" class="form-control" id="address" placeholder="" value="<%=evaluacion.getFactorRiesgo() %>" required>   
      </div>
      </div>
	  
        </div>
        <div class="form-group">
      <div class="row">
          <div class="col-lg-12">
              <label for="address">NORMATIVA</label>
              <input type="text" class="form-control" id="address" placeholder="" value="<%=evaluacion.getNormativa() %>" required>       
      </div>
      </div>
        </div>
	  
	  <div class="form-group">
	  <div class="row">
              <div class="col-lg-12">
              <label for="address">MEDIDAS PROPUESTAS</label>
              <input type="text" class="form-control" id="address" placeholder="" value="<%=evaluacion.getMedidaPropuesta() %>" required>  
      </div>
          </div>
        
    </div>
    </div>
   
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
   
    
</section>             
<%@include file="jspf/pie.jspf"%> 
