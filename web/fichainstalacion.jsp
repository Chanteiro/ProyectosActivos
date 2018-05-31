<%-- 
    Document   : fichainstalacion
    Created on : 15-may-2018, 12:42:47
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.FichaInstalaciones"%>
<%@page import="java.util.List"%>
<%@page import="com.cartelle.modelo.Area"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>
<%
    FichaInstalaciones ficha = (FichaInstalaciones) request.getAttribute("ficha");
    
%>
<section >
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">CÓDIGO DE ÁREA:&nbsp; <%=ficha.getCodArea() %>&nbsp;<%=ficha.getNombreArea() %></h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" method="post" action="areas">
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="rampas">Rampas de Circulación</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="rampas" id="rampas" rows="2"><%= ficha.eliminarNull(ficha.getRampas_de_circulacion())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="circulacion">Circulación Interior</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="circulacion" id="circulacion" rows="2"><%= ficha.eliminarNull(ficha.getCirculacion_interior())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="escfijas">Escaleras Fijas</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="escfijas" id="escfijas" rows="2"><%= ficha.eliminarNull(ficha.getEscaleras_fijas())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="escmano">Escaleras de Mano</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="escmano" id="escmano" rows="2"><%= ficha.eliminarNull(ficha.getEscaleras_mano())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="almacenamiento">Almacenamiento en Altura</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="almacenamiento"id="almacenamiento" rows="2"><%= ficha.eliminarNull(ficha.getAlmacenamiento_altura())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="fluidos">Conducción de Fluídos a Presión</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="fluidos" id="fluidos" rows="2"><%= ficha.eliminarNull(ficha.getConducciones_fluidos_presion())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="calderas">Calderas</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="calderas" id="calderas" rows="2"><%= ficha.eliminarNull(ficha.getCalderas())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="depositos">Depósitos a Presión</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="depositos" id="depositos" rows="2"><%= ficha.eliminarNull(ficha.getDepositos_presion())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="botellas">Botellas a Presión</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="botellas" id="botellas" rows="2"><%= ficha.eliminarNull(ficha.getBotellas_presion())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="cintas">Cintas Transportadoras</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="cintas" id="cintas" rows="2"><%= ficha.eliminarNull(ficha.getCintas_transportadoras())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="ascensores">Ascensores/Montacargas</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="ascensores" id="ascensores" rows="2"><%= ficha.eliminarNull(ficha.getAscensores_montacargas())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="plataformas">Plataformas Elevadoras</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="plataformas" id="plataformas" rows="2"><%= ficha.eliminarNull(ficha.getPlataformas_elevadoras())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="gruas">Grúas/Polipastros</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="gruas" id="gruas" rows="2"><%= ficha.eliminarNull(ficha.getGruas_polipastos())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="carretillas">Carretillas Elevadoras</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="carretillas" id="carretillas" rows="2"><%= ficha.eliminarNull(ficha.getCarretillas_elevadoras())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="baterias">Área de Carga de Baterías</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="baterias" id="baterias" rows="2"><%= ficha.eliminarNull(ficha.getArea_carga_baterias())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="extintores">Extintores</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="extintores" id="extintores" rows="2"><%= ficha.eliminarNull(ficha.getExtintores())%></textarea>
                    </div>
                
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="bie">BIE</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="bie" id="bie" rows="2"><%= ficha.eliminarNull(ficha.getBie())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
               
                    <div class="col-lg-3 control-label">
                        <label for="detincendios">Detección de Incendios</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="detincendios" id="detincendios" rows="2"><%= ficha.eliminarNull(ficha.getDeteccion_incendios())%></textarea>
                    </div>
               
            </div>
            <div class="form-group">
                
                    <div class="col-lg-3 control-label">
                        <label for="otros">Otros</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="otros" id="otros" rows="3"><%= ficha.eliminarNull(ficha.getOtros())%></textarea>
                    </div>
               
            </div>
            </form>
        </div>
    </div>
   

</section>             
<%@include file="jspf/pie.jspf"%> 
