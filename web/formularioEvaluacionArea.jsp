<%-- 
    Document   : formularioEvaluacionArea
    Created on : 15-may-2018, 12:42:47
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.ComboAreas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.awt.Color"%>
<%@page import="com.cartelle.modelo.EvaluacionesArea"%>
<%@page import="com.cartelle.modelo.FichaInstalaciones"%>
<%@page import="java.util.List"%>
<%@page import="com.cartelle.modelo.Area"%>
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
<section>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">NUEVA EVALUACIÓN AREA</h3>
        </div>
        <div class="panel-body">
            <form role="form" action="ControladorNuevaEvaluacionArea" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlSelect1">Código de Área</label></center>
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="idAreaFK" name="idAreaFK">

                                <option>Selecciona Area</option>
                                <%
                                    ArrayList<ComboAreas> cmbArea = (ArrayList<ComboAreas>) request.getAttribute("cmbArea");
                                    for (ComboAreas c : cmbArea) {
                                %>

                                <option value="<%= c.getIdArea()%>"><%= c.getCodArea()%></option>
                                <%
                                    }
                                %>    


                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Tipos de Evaluación</label></center> 
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="tipoEvaluacion" name="tipoEvaluacion">
                                <option></option>
                                <option>INICIAL</option>
                                <option>ORDINARIA</option>
                                <option>EXTRAORDINARIA</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Fecha de Evaluación</label></center> 
                        </div>

                        <div class="col-lg-2">
                            <input type="text" class="datepicker form-control" name="fechaEvaluacion" id="datepicker" size="12" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlSelect1">Código de Peligro</label></center>
                        </div>
                        <div class="col-lg-5">
                            <select class="form-control" id="codPeligroFK" name="codPeligroFK">
                                <option>Selecciona Peligro</option>
                                <option>10 &nbsp;&nbsp; Caída de personas a distinto nivel</option>
                                <option>20 &nbsp;&nbsp; Caída de personas al mismo nivel</option>
                                <option>30 &nbsp;&nbsp; Caída de objetos de desplome o derrumbamiento</option>
                                <option>40 &nbsp;&nbsp; Caída de objetos en manipulación</option>
                                <option>50 &nbsp;&nbsp; Caída de objetos desprendidos</option>
                                <option>60 &nbsp;&nbsp; Pisadas sobre objetos</option>
                                <option>70 &nbsp;&nbsp; Choques contra objetos inmóviles</option>
                                <option>80 &nbsp;&nbsp; Choques contra objetos móviles</option>
                                <option>90 &nbsp;&nbsp; Golpes/cortes por objetos o herramientas</option>
                                <option>100 &nbsp;&nbsp; Proyección de fragmentos o partículas</option>
                                <option>110 &nbsp;&nbsp; Atrapamiento por o entre objetos</option>
                                <option>120 &nbsp;&nbsp; Atrapamiento por vuelco de máquinas o vehículos</option>
                                <option>130 &nbsp;&nbsp; Sobreesfuerzos</option>
                                <option>140 &nbsp;&nbsp; Exposición a temperaturas ambientales extremas</option>
                                <option>150 &nbsp;&nbsp; Contactos térmicos</option>
                                <option>161 &nbsp;&nbsp; Contactos eléctricos directos</option>
                                <option>162 &nbsp;&nbsp; Contactos eléctricos indirectos</option>
                                <option>170 &nbsp;&nbsp; Exposición a sustancias nocivas o tóxicas</option>
                                <option>180 &nbsp;&nbsp; Contactos con sustancias cáusticas y/o corrosivas</option>
                                <option>190 &nbsp;&nbsp; Exposición a radiaciones</option>
                                <option>200 &nbsp;&nbsp; Explosiones</option>
                                <option>211 &nbsp;&nbsp; Incendios. Factores de inidio</option>
                                <option>212 &nbsp;&nbsp; Incendios. Propagación</option>
                                <option>213 &nbsp;&nbsp; Incendios. Medios de lucha</option>
                                <option>214 &nbsp;&nbsp; Incendios. Evacuación</option>
                                <option>220 &nbsp;&nbsp; Accidentes causados por seres vivos</option>
                                <option>230 &nbsp;&nbsp; Atropellos o golpes con vehículos</option>
                                <option>310 &nbsp;&nbsp; Exposición a contaminantes químicos</option>
                                <option>320 &nbsp;&nbsp; Exposición a contaminantes biológicos</option>
                                <option>330 &nbsp;&nbsp; Ruido</option>
                                <option>340 &nbsp;&nbsp; Vibraciones</option>
                                <option>350 &nbsp;&nbsp; Estrés térmico</option>
                                <option>360 &nbsp;&nbsp; Radiaciones ionizantes</option>
                                <option>370 &nbsp;&nbsp; Radiaciones no ionizantes</option>
                                <option>380 &nbsp;&nbsp; Iluminación</option>
                                <option>410 &nbsp;&nbsp; Física. Posición</option>
                                <option>420 &nbsp;&nbsp; Física. Desplazamiento</option>
                                <option>430 &nbsp;&nbsp; Física. Esfuerzo</option>
                                <option>440 &nbsp;&nbsp; Física. Manejos de cargas</option>
                                <option>450 &nbsp;&nbsp; Mental. Recepción de la información</option>
                                <option>460 &nbsp;&nbsp; Mental. Tratamiento de la información</option>
                                <option>470 &nbsp;&nbsp; Mental. Respuesta</option>
                                <option>480 &nbsp;&nbsp; Fatiga crónica</option>
                                <option>510 &nbsp;&nbsp; Contenido</option>
                                <option>520 &nbsp;&nbsp; Monotonía</option>
                                <option>530 &nbsp;&nbsp; Roles</option>
                                <option>540 &nbsp;&nbsp; Autonomía</option>
                                <option>550 &nbsp;&nbsp; Comunicaciones</option>
                                <option>560 &nbsp;&nbsp; Relaciones</option>
                                <option>570 &nbsp;&nbsp; Tiempo de trabajo</option>
                                <option>999 &nbsp;&nbsp; Otros</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">             
                    <div class="row">
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Nivel de Deficiencia</label></center> 
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="nDeficiencia" name="nDeficiencia">
                                <option></option>
                                <option>0</option>
                                <option>2</option>
                                <option>6</option>
                                <option>10</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Nivel de Exposición</label></center>
                        </div>

                        <div class="col-lg-2">
                            <select class="form-control" id="nExposicion" name="nExposicion">
                                <option></option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                           <center><label for="exampleFormControlSelect1">Nivel de Intervención</label></center>
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="nIntervencion" name="nIntervencion">
                                <option></option>
                                <option>I</option>
                                <option>II</option>
                                <option>III</option>
                                <option>IV</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlSelect1">Nivel de Probabilidad</label></center>
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="nProbabilidad"  name="nProbabilidad">
                                <option></option>
                                <option>2</option>
                                <option>4</option>
                                <option>6</option>
                                <option>8</option>
                                <option>10</option>
                                <option>20</option>
                                <option>40</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Nivel de Consecuencias</label></center> 
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="nConsecuencias" name="nConsecuencias">
                                <option></option>
                                <option>10</option>
                                <option>25</option>
                                <option>60</option>
                                <option>100</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Nivel de Riesgo</label></center>
                        </div>

                        <div class="col-lg-2">
                            <select name="nRiesgo" id="nRiesgo" class="selectpicker form-control">
                                <option></option>
                                <option>20</option>
                                <option>40</option>
                                <option>50</option>
                                <option>60</option>
                                <option>80</option>
                                <option>100</option>
                                <option>120</option>
                                <option>150</option>
                                <option>180</option>
                                <option>200</option>
                                <option>240</option>
                                <option>250</option>
                                <option>300</option>
                                <option>360</option>
                                <option>400</option>
                                <option>450</option>
                                <option>500</option>
                                <option>540</option>
                                <option>600</option>
                                <option>720</option>
                                <option>750</option>
                                <option>800</option>
                                <option>1000</option>
                                <option>1080</option>
                                <option>1200</option>
                                <option>1440</option>
                                <option>1800</option>
                                <option>2000</option>
                                <option>2400</option>
                                <option>3000</option>
                                <option>4000</option>
                            </select>
                        </div>
                    </div>
                </div>



                <div class="form-group">

                    <label for="exampleFormControlTextarea1">Factor de Riesgo</label>
                    <textarea class="form-control" id="factorRiesgo" name="factorRiesgo" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Normativa</label>
                    <textarea class="form-control" id="normativa" name="normativa" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Medidas Propuestas</label>
                    <textarea class="form-control" id="medidaPropuesta" name="medidaPropuesta" rows="3"></textarea>
                </div>
                <div align="right">
                    <input type="submit"  value="Guardar" class="btn btn-gray bg-info text-info" >
                </div>
            </form>
        </div>
    </div>
</section>             
<%@include file="jspf/pie.jspf"%> 
