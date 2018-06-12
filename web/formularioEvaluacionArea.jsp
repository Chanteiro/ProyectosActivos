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
            <form class="form-horizontal" role="form" action="ControladorNuevaEvaluacionArea" method="post">
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
                            <center><label for="exampleFormControlSelect1">Código de Peligro</label></cente>
                        </div>
                        <div class="col-lg-2">
                            <select class="form-control" id="codPeligroFK" name="codPeligroFK">
                                <option></option>
                                <option>10</option>
                                <option>20</option>
                                <option>30</option>
                                <option>40</option>
                                <option>50</option>
                                <option>60</option>
                                <option>70</option>
                                <option>80</option>
                                <option>90</option>
                                <option>100</option>
                                <option>110</option>
                                <option>120</option>
                                <option>130</option>
                                <option>140</option>
                                <option>150</option>
                                <option>161</option>
                                <option>162</option>
                                <option>170</option>
                                <option>180</option>
                                <option>190</option>
                                <option>200</option>
                                <option>211</option>
                                <option>212</option>
                                <option>213</option>
                                <option>214</option>
                                <option>220</option>
                                <option>230</option>
                                <option>310</option>
                                <option>320</option>
                                <option>330</option>
                                <option>340</option>
                                <option>350</option>
                                <option>360</option>
                                <option>370</option>
                                <option>380</option>
                                <option>410</option>
                                <option>420</option>
                                <option>430</option>
                                <option>440</option>
                                <option>450</option>
                                <option>460</option>
                                <option>470</option>
                                <option>480</option>
                                <option>510</option>
                                <option>520</option>
                                <option>530</option>
                                <option>540</option>
                                <option>550</option>
                                <option>560</option>
                                <option>570</option>
                                <option>999</option>
                            </select>
                        </div>
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
                            <option>-</option>
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
                    <div class="row">
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
