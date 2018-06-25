
<%@page import="com.cartelle.modelo.PlanificacionAreas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>
<script type="text/javascript">

    jQuery(function ($) {
        $.datepicker.regional['es'] = {
            closeText: 'Cerrar',
            prevText: '&#x3c;Ant',
            nextText: 'Sig&#x3e;',
            currentText: 'Hoy',
            monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
                'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
            monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
                'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
            dayNames: ['Domingo', 'Lunes', 'Martes', 'Mi&eacute;rcoles', 'Jueves', 'Viernes', 'S&aacute;bado'],
            dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mi&eacute;', 'Juv', 'Vie', 'S&aacute;b'],
            dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'S&aacute;'],
            weekHeader: 'Sm',
            dateFormat: 'dd/mm/yy',
            firstDay: 1,
            isRTL: false,
            showMonthAfterYear: false,
            yearSuffix: ''};
        $.datepicker.setDefaults($.datepicker.regional['es']);
    });
    $(document).ready(function () {
        $("#datepicker").datepicker();
        showAnim: 'fadeIn';
    });

</script>
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
                        <input type="text" class="datepicker form-control" name="fechaSubsanado" id="datepicker" size="12" /> 

                    </div>
                </div>
            
            <div class="form-group">
                <div class="col-lg-10"></div>
               
                <input type="submit"  value="Guardar" class="btn btn-gray bg-info text-info" >
                <a class="btn btn-gray bg-info text-info" href='ControladorPlanificacionAreas'>Volver</a>
                 
            </div>
         </form>
        </div>
    </div>
    <%@include file="jspf/pie.jspf"%>