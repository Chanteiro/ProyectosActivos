<%-- 
    Document   : SeleccionUnidades
    Created on : 25-ene-2019, 10:49:20
    Author     : ANTONIO
--%>
<%@page import="com.cartelle.modelo.Unidades"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="jspf/encabezado_corto.jspf"%>

<section>
    <div class="panel panel-primary separar">
        <div class="panel-heading">
            <h3 class="panel-title">UNIDADES PERTENECIENTES AL SERVICIO DE PREVENCIÓN</h3>
        </div>
        <div class="panel-body">
            <form role="form" action="ControladorIdUnidad" method="post">
                <div class="form-group">
                    <div class="row">
                        <div class="col-lg-3">
                            <center><label for="exampleFormControlSelect1">Seleccione una Unidad</label></center>
                        </div>
                        <div class="col-lg-8">
                            <select class="form-control" id="unidades" name="idUnidad">
                                <!--<option>Selecciona Area</option>-->

                                <%  for (Unidades u : unidades) {
                                %>

                                <option value="<%= u.getIdUnidad()%>"><%= u.getUnidad()%></option>
                                <%
                                    }
                                %>   
                            </select>

                        </div>

                    </div> 
                </div>
                <div align="center">
                    <input type="submit"  value="Seleccionar" class="btn btn-gray bg-info text-info" >
                </div>
            </form>
        </div>
    </div>
</section>             
<%@include file="jspf/pie.jspf"%> 