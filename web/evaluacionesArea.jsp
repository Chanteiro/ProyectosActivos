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

<% EvaluacionesArea evaluacion = (EvaluacionesArea) request.getAttribute("evaluacion");
    String c = evaluacion.getnIntervencion();
    String color = "";
    System.out.println(c);
    if (c == null || c.equals("null")) {
        color = "w";
    } else {

        switch (c) {
            case "I":
                color = "r";
                System.out.println(color);
                break;
            case "II":
                color = "y";
                System.out.println(color);
                break;
            case "III":
                color = "g";
                System.out.println(color);
                break;
            case "IV":
                color = "b";
                System.out.println(color);
                break;
            default:
                color = "";
        }
    }

%>

<section >
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Evaluación Área de Trabajo:&nbsp;<%= evaluacion.getCodArea()%>&nbsp;<%= evaluacion.getNombreArea()%></h3>
        </div>
        <div class="panel-body">
             <form class="form-horizontal" role="form">
                  <div class="form-group">
                       <label for="deficiencia" class="col-lg-2 control-label">N. DEFICIENCIA</label>
                       <div class="col-lg-2">
                           <input type="text" class="form-control" id="deficiencia" value="<%=evaluacion.getnDeficiencia()%>" required>
                       </div>
                       <label for="exposicion" class="col-lg-2 control-label">N. EXPOSICIÓN</label> 
                       <div class="col-lg-2">
                            <input type="text" class="form-control" id="exposicion" value="<%=evaluacion.getnExposicion()%>" required>
                       </div>                 
                       <label for="probabilidad" class="col-lg-2 control-label">N. PROBABILIDAD </label>
                       <div class="col-lg-2">
                            <input type="text" class="form-control" id="probabilidad" value="<%=evaluacion.getnProbabilidad()%>" required>
                       </div>
                  </div>
                  <div class="form-group">
                       <label for="consecuencia" class="col-lg-2 control-label">N. CONSECUENCIA</label>
                       <div class="col-lg-2">
                            <input type="text" class="form-control" id="consecuencia" value="<%=evaluacion.getnConsecuencias()%>" required>
                        </div>
                        <label for="riesgo" class="col-lg-2 control-label">N. RIESGO</label>
                        <div class="col-lg-2 ">
                            <input type="text" class="form-control" id="riesgo" value="<%=evaluacion.getnRiesgo()%>" required>
                        </div>
                        <label for="intervencion" class="col-lg-2 control-label">N. INTERVENCIÓN</label>
                        <div class="col-lg-2">
                             <input type="text" class="form-control <%= color%>" id="intervencion" value="<%=evaluacion.getnIntervencion()%>" required>
                        </div>
                   </div>
                   <div class="form-group"> 
                         <label for="tipoEvaluacion" class="col-lg-2 control-label">TIPO EVALUACIÓN</label>
                         <div class="col-lg-6 ">
                            <input type="text" class="form-control" id="tipoEvaluacion" value="<%=evaluacion.getTipoEvaluacion()%>" required>
                         </div>             
                         <label for="fechaEvaluacion" class="col-lg-2 control-label">FECHA EVALUACIÓN</label>
                         <div class="col-lg-2">
                            <input type="text" class="form-control" id="fechaEvaluacion" value="<%=evaluacion.getFechaEvaluacion()%>" required> 
                        </div>
                   </div>
                   <div class="form-group">
                        <label for="factorRiesgo" class="col-lg-2 control-label">FACTOR RIESGO</label>
                        <div class="col-lg-10">
                             <input type="text" class="form-control" id="factorRiesgo" value="<%=evaluacion.getFactorRiesgo()%>" required>   
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="normativa" class="col-lg-2 control-label">NORMATIVA</label>
                        <div class="col-lg-10">
                             <input type="text" class="form-control" id="normativa" placeholder="" value="<%=evaluacion.getNormativa()%>" required>       
                        </div>
                    </div>
                    <div class="form-group">     
                         <label for="medidasPropuestas" class="col-lg-2 control-label">MEDIDAS PROPUESTAS</label>
                         <div class="col-lg-10">
                              <input type="text" class="form-control" id="medidasPropuestas" placeholder="" value="<%=evaluacion.getMedidaPropuesta()%>" required>  
                         </div>
                    </div>
             </form>   
        </div>
    </div> 
</section>             
<%@include file="jspf/pie.jspf"%> 
