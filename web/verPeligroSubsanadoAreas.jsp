
<%@page import="com.cartelle.modelo.PlanificacionAreas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<%
    PlanificacionAreas datos = (PlanificacionAreas) request.getAttribute("datos");
    String c= datos.getPrioridad();  
     String color="";
    if(c!=null){
   
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
        }
    }else{
        c="No requiere Intervención";
    }
 %>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Planificación del Area:&nbsp;<%=datos.getCodArea()%></h3>
			
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" action="ControladorActualizarAreasSubsanado" method="post">
                <input type="hidden" name="idEvaluacionArea" value="<%=datos.getIdEvaluacionArea()%>">
				<input type="hidden" name="subsanador" value="<%=username%>">
                <div class="form-group">
                     <label for="codPeligro" class="col-lg-2 control-label">Codigo Peligro</label>
                    <div class="col-lg-2">
                      <input type="text" class="form-control" id="codPeligroFk" value="<%=datos.getCodPeligroFK()%>">
                    </div>
                    <label for="factorRiesgo" class="col-lg-2 control-label">Factor de Riesgo</label>
                    <div class="col-lg-6">
                       <textarea class="form-control" id="factorRiesgo"><%=datos.getFactorRiesgo()%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="prioridad" class="col-lg-2 control-label">Nivel Prioridad</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control <%= color %>" id="prioridad" value="<%=c%>">
                    </div>
                    <label for="normativa" class="col-lg-2 control-label">Normativa</label>
                    <div class="col-lg-6">
                        <input type="text" class="form-control" id="Normativa" value="<%=datos.getNormativa()%>">
                    </div>
                </div>
                    
                <div class="form-group">
                    <label for="medidaPropuesta" class="col-lg-2 control-label">Medidas Propuestas</label>
                    <div class="col-lg-6">
                        <textarea class="form-control" id="medidaPropuesta"><%=datos.getMedidaPropuesta()%></textarea>
                     </div>
                    <label for="fechaSubsanado" class="col-lg-2 control-label">Fecha de Subsanado</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" name="fechaSubsanado" id="fechaSubsanado" value="<%=datos.getFechaSubsanado()%>"> 
                    </div>
                </div>
            
            <div class="form-group">
                <label for="subsanador" class="col-lg-2 control-label">Subsanador</label>
                    <div class="col-lg-6">
                        <input type="text" class="form-control" name="subsanador" id="subsanador" value="<%=datos.getSubsanador()%>"> 
                    </div>
                    <div class="col-lg-3"></div>
                <a class="btn btn-gray bg-info text-info" href='ControladorPlanificacionAreas'>Volver</a>
                 
            </div>
         </form>
        </div>
    </div>
    <%@include file="jspf/pie.jspf"%>