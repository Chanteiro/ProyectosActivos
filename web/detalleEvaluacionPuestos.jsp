
<%@page import="com.cartelle.modelo.ConsultaDetallesEvaluacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>
<%
    ConsultaDetallesEvaluacion datos = (ConsultaDetallesEvaluacion) request.getAttribute("datos");
    System.out.println(datos.toString());
    String c= datos.getIntervencion();                         
    String color="";
         switch(c){
            case "I":
                color= "r";
                break;
            case "II":
                color = "y";
                break;
            case "III":
                color= "g";
                break;
            case "IV":
                color = "b";
                break;
            default:
            color="";
        }
         System.out.println("aqui "+color);
 %>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Evaluación del Puesto de Trabajo:&nbsp;<%=datos.getCodigopuesto()%>&nbsp;&nbsp;Area:&nbsp;<%=datos.getCodigoarea()%></h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form">
                
                <div class="form-group">
                    <label for="tipoEvaluacion" class="col-lg-2 control-label">Tipo de Evaluación</label>
                    <div class="col-lg-2">
                      <input type="text" class="form-control" id="tipoEvaluacion" value="<%=datos.getTipoevaluacion()%>">
                    </div>
                    <label for="fechaEvaluacion" class="col-lg-2 control-label">Fecha de Evaluación</label>
                    <div class="col-lg-2">
                      <input type="text" class="form-control" id="fechaEvaluacion" value="<%=datos.getFechaevaluacion()%>">
                    </div>
                     <label for="codPeligro" class="col-lg-2 control-label">Codigo Peligro</label>
                    <div class="col-lg-2">
                      <input type="text" class="form-control" id="codPeligroFk" value="<%=datos.getCodPeligro()%>">
                    </div>        
                </div>
                
                <div class="form-group">
                    <label for="factorRiesgo" class="col-lg-2 control-label">Factor de Riesgo</label>
                    <div class="col-lg-10">
                       <textarea class="form-control" id="factorRiesgo" rows="3" ><%=datos.getFactorriesgo()%></textarea>
                    </div>
                </div>
                    
                    
                <div class="form-group">
                    <label for="nDeficiencia" class="col-lg-1 control-label">ND</label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control" id="nDeficiencia" value="<%=datos.getDeficiencia()%>">
                    </div>
                    <label for="nExposicion" class="col-lg-1 control-label">NE</label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control" id="nExposicion" value="<%=datos.getExposicion()%>">
                    </div>
                    
                    <label for="nProbabilidad" class="col-lg-1 control-label">NP</label>
                    <div class="col-lg-1">
                      <input type="text" class="form-control" id="nProbabilidad" value="<%=datos.getProbabilidad()%>">
                    </div>
                    <label for="nConsecuencias" class="col-lg-1 control-label">NC</label>
                    <div class="col-lg-1">
                       <input type="text" class="form-control" id="nConsecuencias" value="<%=datos.getConsecuencias()%>">
                    </div>
                    <label for="nRiesgo" class="col-lg-1 control-label">NR</label>
                    <div class="col-lg-1">
                      <input type="text" class="form-control" id="nRiesgo" value="<%=datos.getRiesgo()%>">
                    </div>
                    <label for="nIntervencion" class="col-lg-1 control-label">NI</label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control <%= color %>" id="nIntervencion" value="<%=datos.getIntervencion()%>">
                    </div>
                </div>
                
                <div class="form-group">
                    <label for="normativa" class="col-lg-2 control-label">Normativa</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="Normativa" value="<%=datos.getNormativa()%>">
                    </div>
                </div>
                    
                <div class="form-group">
                    <label for="medidaPropuesta" class="col-lg-2 control-label">Medidas Propuestas</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="medidaPropuesta" rows="3"><%=datos.getMedidas()%></textarea>
                    </div>
                </div>
            </form>
            <div class="form-group">
                <div class="col-lg-11"></div>
                <%
                    String urlAntes = request.getHeader("Referer");
                    System.out.println(urlAntes);
                    %>
               <!-- <input type="reset" name="Volver" value="Volver" onclick="history.back()" class="btn btn-gray bg-info text-info">-->
                <!--<a class="btn btn-gray bg-info text-info" href='ControladorPeligro?action=verdetalle&vuelta=si&id=<%=datos.getIdArea()%>&id2=<%=datos.getIdPuesto()%>'>Volver</a>-->
                 <a class="btn btn-gray bg-info text-info" href='<%=urlAntes  %>'>Volver</a>
            </div>
        </div>
    </div>
    <%@include file="jspf/pie.jspf"%>