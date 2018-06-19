<%-- 
    Document   : detalleVacante
    Created on : 16-may-2018, 8:56:13
    Author     : ANTONIO
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.cartelle.modelo.Zona_medicion"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cartelle.modelo.Area"%>
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
    Area a = (Area) request.getAttribute("area");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String fecha = "";
    List<Zona_medicion> zonas=new ArrayList();
    if (request.getParameter("action").equals("verdetalle")||request.getParameter("action").equals("irArea")||request.getParameter("action").equals("borrar")) {
        fecha = sdf.format(a.getFechaTomaDatos());
        zonas=a.getZonas();
    }
   
%>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <%
                if (request.getParameter("action").equals("nueva")) {
                    out.println("<h3 class='panel-title'>NUEVA ÁREA</h3>");
                    out.println("</div> <div class='panel-body'><form class='form-horizontal' role='form' method='post' action='areas'>");
                    out.println("<div class='form-group'><label for='cod' class='col-lg-2 control-label'>Código de área</label>");
                    out.println("<div class='col-lg-2'><input type='text' class='form-control' name='cod' id='cod' value='' placeholder='Código Área' required>");
                    out.println("</div> <label for='nombre' class='col-lg-2 control-label'>Nombre de área</label><div class='col-lg-6'>");
                    out.println("<input type='text' class='form-control' name='nombre' id='nombre' placeholder='Nombre del área' value=''></div></div>");
                }else{
                    out.println("<h3 class='panel-title'>CÓDIGO DE ÁREA:&nbsp; " + a.getCodArea() + "&nbsp;" + a.getNombre() + "</h3>");
                    out.println("</div> <div class='panel-body'><form class='form-horizontal' role='form' method='post' action='areas'>");
                   
                }
            %>




            <div class="form-group">
                <label for="fechaDatos" class="col-lg-2 control-label">Fecha toma de datos</label>
                <div class="col-lg-2">
                    <input type="text" class="datepicker form-control" name="fecha" id="datepicker"  value="<%=fecha%>">
                </div>
                <div class="col-lg-2"></div>
                
                <div class="col-lg-3  text-center">
                    <%
                       if (request.getParameter("action").equals("verdetalle")||request.getParameter("action").equals("irArea")||request.getParameter("action").equals("borrar")) { 
                           out.println("<a  href='tablaEvaluacionesControler?action=verEva&id="+a.getId()+"'><span class=\"glyphicon glyphicon-search\"></span>&nbsp;Consultar las evaluaciones de ésta área</a>");
                           
                       }
                        %>
                    
                </div>
                <div class="col-lg-3  text-center">
                     <%
                       if (request.getParameter("action").equals("verdetalle")||request.getParameter("action").equals("irArea")||request.getParameter("action").equals("borrar")) { 
                           out.println("<a  href='fichaInstControler?action=verdetalle&id="+a.getFichaInstalacionesFK()+"'><span class=\"glyphicon glyphicon-search\"></span>&nbsp;Consultar la ficha de instalación </a>");
                           
                       }
                        %>
                    
                </div>
            </div>


            <div class="form-group">
                <label for="observaciones" class="col-lg-2 control-label">Observaciones</label>
                <div class="col-lg-10">
                    <textarea class="form-control" name="observaciones" id="observaciones" rows="3"><%=a.getObservacionesArea()%></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="descripcion" class="col-lg-2 control-label">Breve descripción del área</label>
                <div class="col-lg-10">
                    <textarea class="form-control" name="descripcion" id="descripcion" rows="12"><%=a.getDescripcion()%></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="sup" class="col-lg-2 control-label">Superficie aproximada en m<sup>2</sup></label>
                <div class="col-lg-1">
                    <input type="text" class="form-control" name="sup" id="sup" value='<%=a.getSuperficie()%>'>
                </div>
                <label for="actividades" class="col-lg-2 control-label">Actividades realizadas</label>
                <div class="col-lg-7">
                    <input type="text" class="form-control" name="actividades" id="actividades" placeholder="Actividades realizadas en la misma" value='<%=a.getActividadesRealizadas()%>'>
                </div>
            </div>
            <div class="form-group">
                <label for="instalaciones" class="col-lg-2 control-label">Instalaciones existentes</label>
                <div class="col-lg-10">
                    <textarea class="form-control" name="instalaciones" id="instalaciones" rows="8"><%=a.getInstalacionesExistentes()%></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="medidas" class="col-lg-2 control-label">Medidas preventivas</label>
                <div class="col-lg-10">
                    <textarea class="form-control" name="medidas" id="medidas"rows="8"><%=a.getMedidasPreventivasExistentes()%></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="observacionesmedidas" class="col-lg-2 control-label">Observaciones</label>
                <div class="col-lg-10">
                    <textarea class="form-control" name="observacionesmedidas" id="observacionesmedidas"rows="8"><%=a.getObservacionesMedidasPreventivas()%></textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="zonas" class="col-lg-2 control-label">Zonas de medición</label>
                <div class="col-lg-10">
                    <div class="panel panel-primary">
                        <table class="table ">
                            <thead>
                                <tr>
                                    <th>ZONA</th>
                                    <th>DESCRIPCIÓN</th>
                                    <th>LUZ (lux)</th>
                                    <th>RUÍDO (db)</th>
                                    <th>TEMP (ºC)</th>
                                    <th>DETALLES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Zona_medicion z : zonas) {
                                        out.println("<tr><td>" + z.getNombre() + "</td><td>"
                                                + z.getDescripcion() + "</td><td>" + z.getLuz() + "</td><td>" + z.getRuido() + "</td><td>" + z.getTemp()
                                                + "</td><td><a  href='detalleZona?action=verdetalle&idZona=" + z.getIdZona() + "&id=" + a.getId() + "'>ver detalle</a>" + "</td><tr>");
                                    }
                                    out.println("<tr><td class='text-center' colspan=6><a  "
                                            + "href='detalleZona?action=nueva&id=" + a.getId() + "&idZona=0'>"
                                            + "<span class='glyphicon glyphicon-plus-sign'></span>&nbsp;Nueva Zona de Medición</a></td><tr>");
                                %>

                            </tbody>
                        </table>

                    </div>
                </div>
                <div class="form-group">

                    <div class='col-lg-10'></div> 
                    <input type='hidden' name='iden' value='<%=a.getId()%>' />
                    <input type='hidden' name='action' value='crearArea' />
                    
                    <%
                         if (request.getParameter("action").equals("nueva")) {
                        out.println("<button class='btn btn-gray bg-info text-info'>Guardar</button>");
                        }else{
                             out.println("<button class='btn btn-gray bg-info text-info'>Modificar</button>");
                         }
                        %>
                   
                </div>

           
                                    


    </div>
</form>
 </div>



</section>      





<%@include file="jspf/pie.jspf"%>  