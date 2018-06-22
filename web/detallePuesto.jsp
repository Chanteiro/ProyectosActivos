<%-- 
    Document   : detallePuesto
    Created on : 22-may-2018, 12:21:00
    Author     : ANTONIO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cartelle.modelo.Puestos"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
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
            dateFormat: 'dd-mm-yy',
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
    Puestos p = (Puestos) request.getAttribute("puesto");
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String observaciones, tareas, equipos, trabajadores, medidas, obsmedidas, luz, ruido, temp;
    String fecha = "";
    try {
        fecha = sdf.format(p.getFechaTomaDatos());
    } catch (Exception e) {
        fecha = "Sin datos";
    }

    if (p.getLuz() == 0) {
        luz = "Sin datos";
    } else {
        luz = String.valueOf(p.getLuz());
    }
    if (p.getRuido() == 0) {
        ruido = "Sin datos";
    } else {
        ruido = String.valueOf(p.getRuido());
    }
    if (p.getTemp() == 0) {
        temp = "Sin datos";
    } else {
        temp = String.valueOf(p.getTemp());
    }
    if (p.getObservaciones() == null) {
        observaciones = "Sin datos";
    } else {
        observaciones = p.getObservaciones().trim();
    }
    if (p.getTareasRealizadas() == null) {
        tareas = "Sin datos";
    } else {
        tareas = p.getTareasRealizadas().trim();
    }
    if (p.getEquiposTrabajo() == null) {
        equipos = "Sin datos";
    } else {
        equipos = p.getEquiposTrabajo().trim();
    }
    if (p.getTrabajadoresCondicionEspecial() == null) {
        trabajadores = "Sin datos";
    } else {
        trabajadores = p.getTrabajadoresCondicionEspecial().trim();
    }
    if (p.getMedidasPreventivasExistentes() == null) {
        medidas = "Sin datos";
    } else {
        medidas = p.getMedidasPreventivasExistentes().trim();
    }
    if (p.getObservacionesMedidasPreventivas() == null) {
        obsmedidas = "Sin datos";
    } else {
        obsmedidas = p.getObservacionesMedidasPreventivas().trim();
    }

%>


<section >
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">PUESTO DE TRABAJO:&nbsp; <%=p.getCodPuesto()%>&nbsp;<%=p.getPuesto()%></h3>
        </div>
        <div class="panel-body">

            <form class="form-horizontal" role="form" method="post" action="detallePuesto">

                <div class="form-group">
                    <div class="col-lg-9"></div>

                    <div class="col-lg-3  text-center">
                        <a  href="ControladorPeligro?action=verEva&id=<%=p.getIdArea()%>&id2=<%=p.getIdPuesto()%>"><span class="glyphicon glyphicon-search"></span>&nbsp;Consultar los riesgos de éste puesto</a>
                    </div>

                </div>
                <div class="form-group">
                    <label for="codPuesto" class="col-lg-2 control-label">Código Puesto</label>
                    <div class="col-lg-1">
                        <input type="text" class="form-control" id="codPuesto" name="codPuesto" required value="<%=p.getCodPuesto()%>"> 
                    </div>
                    <label for="puesto" class="col-lg-1 control-label">Puesto</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" id="puesto" name="puesto" required value="<%=p.getPuesto()%>">
                    </div>
                    <label for="fecha" class="col-lg-2 control-label" >Fecha toma de datos</label>
                    <div class="col-lg-2">
                        <input type="text" class="datepicker form-control" id="datepicker" name="fecha" required size="12"  value="<%=fecha%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="observaciones" class="col-lg-2 control-label">Observaciones</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="observaciones" name="observaciones" required rows="3"><%=observaciones%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tareasrealizadas" class="col-lg-2 control-label">Tareas Realizadas</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="tareasrealizadas" name="tareasrealizadas" required  rows="3"><%=tareas%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="equipostrabajo" class="col-lg-2 control-label">Equipos Trabajo</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="equipostrabajo" name="equipostrabajo" required rows="3"><%=equipos%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="trabajadores" class="col-lg-2 control-label">Trabajadores Condición Especial</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="trabajadores" name="trabajadores" required  rows="3"><%=trabajadores%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="medidas" class="col-lg-2 control-label">Medidas Preventivas Existentes</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="medidas" name="medidas" required  rows="3"><%=medidas%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="observacionesmedidas" class="col-lg-2 control-label">Observaciones Medidas Preventivas</label>
                    <div class="col-lg-10">
                        <textarea class="form-control" id="observacionesmedidas" name="observacionesmedidas" required  rows="3"><%=obsmedidas%></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="luz" class="col-lg-2 control-label">Mediciones luz (lux)</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="luz" name="luz" value="<%= luz%>"> 
                    </div>
                    <label for="ruido" class="col-lg-2 control-label">Mediciones ruído (db)</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="ruido" name="ruido" value="<%= ruido%>"> 
                    </div>
                    <label for="temp" class="col-lg-2 control-label">Mediciones temperatura (ºC)</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="temp" name="temp" value="<%= temp%>"> 
                    </div>
                </div>

                <div class="form-group">

                    <div class='col-lg-10'></div> 
                    <input type='hidden' name='id' value='<%=p.getIdPuesto()%>' />
                    <input type='hidden' name='action' value='verdetalle' />
                    
                    <button class='btn btn-gray bg-info text-info'>Modificar</button>
                </div>
            </form>
        </div>
    </div>
</section>

<%@include file="jspf/pie.jspf"%>  