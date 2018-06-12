<%@page import="com.cartelle.modelo.ComboCodigoPeligro"%>
<%@page import="com.toedter.calendar.JCalendar"%>
<%@page import="com.cartelle.modelo.ComboPuestos"%>
<%@page import="java.util.ArrayList"%>
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
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title"> Nueva Evaluación</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" action="ControladorNuevaEvaluacion" method="post" >
                <div class="form-group">
                    <label for="cmbpuesto" class="col-lg-2 control-label">Código del Puesto</label>
                    <div class="col-lg-6">
                        <select name="cmbpuesto" id="cmbpuesto" class="selectpicker form-control">
                            <option>Selecciona Puesto</option>
                            <%
                                ArrayList<ComboPuestos> cmbPuesto = (ArrayList<ComboPuestos>) request.getAttribute("cmbPuesto");
                                for (ComboPuestos c : cmbPuesto) {
                            %>

                            <option value="<%= c.getIdPuesto()%>"><%= c.getCodPuesto()%>.-&nbsp;&nbsp;<%= c.getNombre()%></option>
                            <%
                                }
                            %>    

                        </select> 
                    </div>

                    <label for="tipoEvaluacion" class="col-lg-2 control-label">Tipo de Evaluación</label>
                    <div class="col-lg-2">
                        <select name="tipoEvaluacion" id="tipoEvaluacion" class="selectpicker form-control">
                            <option>Selecciona Tipo</option>
                            <option>INICIAL</option>
                            <option>REVISION</option>
                            <option>EXTRAORDINARIA</option>
                            <option>AUDITORIA</option>
                        </select> 
                    </div>
                </div>

                <div class="form-group">
                    <label for="fechaEvaluacion" class="col-lg-2 control-label">Fecha de Evaluación</label>
                    <div class="col-lg-2">
                        <input type="text" class="datepicker form-control" name="fechaEvaluacion" id="datepicker" size="12" /> 

                    </div>

                    <label for="codPeligroFK" class="col-lg-2 control-label">Código de Peligro</label>
                    <div class="col-lg-6">
                        <select name="codPeligroFK" id="codPeligroFK" class="selectpicker form-control">
                            <option>Selecciona Codigo de Peligro</option>
                            <%
                                ArrayList<ComboCodigoPeligro> cmbCodigoPeligro = (ArrayList<ComboCodigoPeligro>) request.getAttribute("cmbCodigoPeligro");
                                for (ComboCodigoPeligro c : cmbCodigoPeligro) {
                            %>

                            <option value="<%= c.getIdCodigo()%>"><%= c.getIdCodigo()%>.-&nbsp;&nbsp;<%= c.getCodPeligro()%></option>
                            <%
                                }
                            %>    

                        </select> 
                    </div>
                </div>



                <div class="form-group">
                    <label for="deficiencia" class="col-lg-1 control-label">ND</label>
                    <div class="col-lg-1">
                        <select name="deficiencia" id="deficiencia" class="selectpicker form-control">
                            <option>-</option>
                            <option>2</option>
                            <option>6</option>
                            <option>10</option>
                        </select>
                    </div>
                    <label for="exposicion" class="col-lg-1 control-label">NE</label>
                    <div class="col-lg-1">
                        <select name="exposicion" id="exposicion" class="selectpicker form-control">
                            <option>-</option>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <label for="probabilidad" class="col-lg-1 control-label">NP</label>
                    <div class="col-lg-1">
                        <select name="probabilidad" id="probabilidad" class="selectpicker form-control">
                            <option>-</option>
                            <option>2</option>
                            <option>4</option>
                            <option>6</option>
                            <option>8</option>
                            <option>10</option>
                            <option>12</option>
                            <option>18</option>
                            <option>20</option>
                            <option>24</option>
                            <option>30</option>
                            <option>40</option>
                        </select>
                    </div>
                    <label for="consecuencias" class="col-lg-1 control-label">NC</label>
                    <div class="col-lg-1">
                        <select name="consecuencias" id="consecuencias" class="selectpicker form-control">
                            <option>-</option>
                            <option>10</option>
                            <option>25</option>
                            <option>60</option>
                            <option>100</option>
                        </select>
                    </div>
                    <label for="riesgo" class="col-lg-1 control-label">NR</label>
                    <div class="col-lg-1">
                        <select name="riesgo" id="riesgo" class="selectpicker form-control">
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
                    <label for="intervencion" class="col-lg-1 control-label">NI</label>
                    <div class="col-lg-1">
                        <select name="intervencion" id="intervencion" class="selectpicker form-control">
                            <option>-</option>
                            <option>I</option>
                            <option>II</option>
                            <option>III</option>
                            <option>IV</option>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="factorRiesgo" class="col-lg-2 control-label">Factor de Riesgo</label>
                    <div class="col-lg-10">
                        <textarea name="factorRiesgo" class="form-control" rows="3" ></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="medidaPropuesta" class="col-lg-2 control-label">Medidas Propuestas</label>
                    <div class="col-lg-10">
                        <textarea name="medidas" class="form-control" id="medidaPropuesta" rows="3"></textarea>
                    </div>
                </div>

                <div class="form-group">
                    <label for="normativa" class="col-lg-2 control-label">Normativa</label>
                    <div class="col-lg-10">
                        <input name="normativa" type="text" class="form-control">
                    </div>
                </div>
                <div class="col-lg-5"></div>
                <input type="submit"  value="Guardar" class="btn btn-gray bg-info text-info" >
               <!-- <input type="reset" name="Volver" value="Volver" onclick="ControladorEvaluacionPuestos" class="btn btn-gray bg-info text-info" >-->
               <a href="ControladorEvaluacionPuestos" class="btn btn-gray bg-info text-info" >Volver</a>
            </form>
        </div>
    </div>
    <%@include file="jspf/pie.jspf"%>
