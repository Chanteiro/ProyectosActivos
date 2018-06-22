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
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
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
            <h3 class="panel-title">NUEVA EVALUACI�N AREA</h3>
        </div>
        <div class="panel-body">
            <form role="form" action="ControladorNuevaEvaluacionArea" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlSelect1">C�digo de �rea</label></center>
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="idAreaFK" name="idAreaFK">

                                <!--<option>Selecciona Area</option>-->
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
                            <center><label for="exampleFormControlTextarea1">Tipos de Evaluaci�n</label></center> 
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="tipoEvaluacion" name="tipoEvaluacion">
                                
                                <option>INICIAL</option>
                                <option>ORDINARIA</option>
                                <option>EXTRAORDINARIA</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Fecha de Evaluaci�n</label></center> 
                        </div>

                        <div class="col-lg-2">
                            <input type="text" class="datepicker form-control" name="fechaEvaluacion" required id="datepicker" size="12" />
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlSelect1">C�digo de Peligro</label></center>
                        </div>
                        <div class="col-lg-5">
                            <select class="form-control" id="codPeligroFK" name="codPeligroFK">
                                <option value="999">Selecciona Peligro</option>
                                <option value="10">10 &nbsp;&nbsp; Ca�da de personas a distinto nivel</option>
                                <option value="20">20 &nbsp;&nbsp; Ca�da de personas al mismo nivel</option>
                                <option value="30">30 &nbsp;&nbsp; Ca�da de objetos de desplome o derrumbamiento</option>
                                <option value="40">40 &nbsp;&nbsp; Ca�da de objetos en manipulaci�n</option>
                                <option value="50">50 &nbsp;&nbsp; Ca�da de objetos desprendidos</option>
                                <option value="60">60 &nbsp;&nbsp; Pisadas sobre objetos</option>
                                <option value="70">70 &nbsp;&nbsp; Choques contra objetos inm�viles</option>
                                <option value="80">80 &nbsp;&nbsp; Choques contra objetos m�viles</option>
                                <option value="90">90 &nbsp;&nbsp; Golpes/cortes por objetos o herramientas</option>
                                <option value="100">100 &nbsp;&nbsp; Proyecci�n de fragmentos o part�culas</option>
                                <option value="110">110 &nbsp;&nbsp; Atrapamiento por o entre objetos</option>
                                <option value="120">120 &nbsp;&nbsp; Atrapamiento por vuelco de m�quinas o veh�culos</option>
                                <option value="130">130 &nbsp;&nbsp; Sobreesfuerzos</option>
                                <option value="140">140 &nbsp;&nbsp; Exposici�n a temperaturas ambientales extremas</option>
                                <option value="150">150 &nbsp;&nbsp; Contactos t�rmicos</option>
                                <option value="161">161 &nbsp;&nbsp; Contactos el�ctricos directos</option>
                                <option value="162">162 &nbsp;&nbsp; Contactos el�ctricos indirectos</option>
                                <option value="170">170 &nbsp;&nbsp; Exposici�n a sustancias nocivas o t�xicas</option>
                                <option value="180">180 &nbsp;&nbsp; Contactos con sustancias c�usticas y/o corrosivas</option>
                                <option value="190">190 &nbsp;&nbsp; Exposici�n a radiaciones</option>
                                <option value="200">200 &nbsp;&nbsp; Explosiones</option>
                                <option value="211">211 &nbsp;&nbsp; Incendios. Factores de inicio</option>
                                <option value="212">212 &nbsp;&nbsp; Incendios. Propagaci�n</option>
                                <option value="213">213 &nbsp;&nbsp; Incendios. Medios de lucha</option>
                                <option value="214">214 &nbsp;&nbsp; Incendios. Evacuaci�n</option>
                                <option value="220">220 &nbsp;&nbsp; Accidentes causados por seres vivos</option>
                                <option value="230">230 &nbsp;&nbsp; Atropellos o golpes con veh�culos</option>
                                <option value="310">310 &nbsp;&nbsp; Exposici�n a contaminantes qu�micos</option>
                                <option value="320">320 &nbsp;&nbsp; Exposici�n a contaminantes biol�gicos</option>
                                <option value="330">330 &nbsp;&nbsp; Ruido</option>
                                <option value="340">340 &nbsp;&nbsp; Vibraciones</option>
                                <option value="350">350 &nbsp;&nbsp; Estr�s t�rmico</option>
                                <option value="360">360 &nbsp;&nbsp; Radiaciones ionizantes</option>
                                <option value="370">370 &nbsp;&nbsp; Radiaciones no ionizantes</option>
                                <option value="380">380 &nbsp;&nbsp; Iluminaci�n</option>
                                <option value="410">410 &nbsp;&nbsp; F�sica. Posici�n</option>
                                <option value="420">420 &nbsp;&nbsp; F�sica. Desplazamiento</option>
                                <option value="430">430 &nbsp;&nbsp; F�sica. Esfuerzo</option>
                                <option value="440">440 &nbsp;&nbsp; F�sica. Manejos de cargas</option>
                                <option value="450">450 &nbsp;&nbsp; Mental. Recepci�n de la informaci�n</option>
                                <option value="460">460 &nbsp;&nbsp; Mental. Tratamiento de la informaci�n</option>
                                <option value="470">470 &nbsp;&nbsp; Mental. Respuesta</option>
                                <option value="480">480 &nbsp;&nbsp; Fatiga cr�nica</option>
                                <option value="510">510 &nbsp;&nbsp; Contenido</option>
                                <option value="520">520 &nbsp;&nbsp; Monoton�a</option>
                                <option value="530">530 &nbsp;&nbsp; Roles</option>
                                <option value="540">540 &nbsp;&nbsp; Autonom�a</option>
                                <option value="550">550 &nbsp;&nbsp; Comunicaciones</option>
                                <option value="560">560 &nbsp;&nbsp; Relaciones</option>
                                <option value="570">570 &nbsp;&nbsp; Tiempo de trabajo</option>
                                <option value="999">999 &nbsp;&nbsp; Otros</option>
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
                            <select class="form-control" id="nDeficiencia" required name="nDeficiencia">
                                
                                <option>0</option>
                                <option>2</option>
                                <option>6</option>
                                <option>10</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <center><label for="exampleFormControlTextarea1">Nivel de Exposici�n</label></center>
                        </div>

                        <div class="col-lg-2">
                            <select class="form-control" id="nExposicion" name="nExposicion">
                                
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <div class="col-lg-2">
                           <center><label for="exampleFormControlSelect1">Nivel de Intervenci�n</label></center>
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="nIntervencion" name="nIntervencion">
                                
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
                    <textarea class="form-control" id="factorRiesgo" required name="factorRiesgo" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Normativa</label>
                    <textarea class="form-control" id="normativa" required name="normativa" rows="3"></textarea>
                </div>
                <div class="form-group">
                    <label for="exampleFormControlTextarea1">Medidas Propuestas</label>
                    <textarea class="form-control" id="medidaPropuesta" required name="medidaPropuesta" rows="3"></textarea>
                </div>
                <div align="right">
                    <input type="submit"  value="Guardar" class="btn btn-gray bg-info text-info" >
                </div>
            </form>
        </div>
    </div>
</section>             
<%@include file="jspf/pie.jspf"%> 
