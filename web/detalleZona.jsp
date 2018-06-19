<%-- 
    Document   : detalleZona
    Created on : 07-jun-2018, 8:44:16
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.Zona_medicion"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>
<%
    Zona_medicion z = (Zona_medicion) request.getAttribute("zona");
    String area = request.getParameter("id");
    String nombre, descripcion, luz, ruido, temp;
    if (z.getIdZona() != 0) {
        nombre = z.getNombre();
        descripcion = z.getDescripcion();
        luz = String.valueOf(z.getLuz());
        ruido = String.valueOf(z.getRuido());
        temp = String.valueOf(z.getTemp());
    } else {
        nombre = "";
        descripcion = "";
        luz = "";
        ruido = "";
        temp = "";
    }
%>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">ZONA DE MEDICIÓN</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" method="post" action="detalleZona">

                <div class="form-group">
                    <label for="nombre" class="col-lg-2 control-label">Zona</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="nombre" name="nombre" maxlength="10" placeholder="Nombre de la Zona" value="<%= nombre%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="descripcion" class="col-lg-2 control-label">Descripción</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="descripcion" name="descripcion" maxlength="20" placeholder="Descripción" value="<%=descripcion%>">
                    </div>
                </div>

                <div class="form-group">
                    <label for="luz" class="col-lg-2 control-label">Luz (lux)</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="luz" name= "luz" placeholder="Valores de Luz" value="<%=luz%>">
                    </div>
                    <label for="ruido" class="col-lg-2 control-label">Ruído (dB)</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="ruido" name="ruido" placeholder="Valores de Ruído" value="<%=ruido%>">
                    </div>
                    <label for="temp" class="col-lg-2 control-label">Temperatura (ºC)</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="temp" name="temp" placeholder="Valores de Temperatura" value="<%=temp%>">
                    </div>
                </div>    
                <div class="form-group">
                    <div class='col-lg-10'></div> 
                    
                    <%
                        if (request.getParameter("action").equals("nueva")) {
                            out.println("<input type='hidden' name='flag' value='no' />");
                            out.println("<input type='hidden' name='areaFK' value='" + area + "' />");
                            out.println("<input type='hidden' name='idZona' value='0' />");
                            out.println("<input type='hidden' name='id' value='" + area + "' />");
                            
                            out.println("<input type='hidden' name='action' value='irArea' />");
                            out.println("<button class='btn btn-gray bg-info text-info'>Guardar</button>");
                        } else {
                            out.println("<input type='hidden' name='flag' value='si' />");
                            out.println(" <input type='hidden' name='areaFK' value='" + z.getIdAreaFK() + "' />");
                            out.println("<input type='hidden' name='id' value='" + z.getIdAreaFK() + "' />");
                            out.println("<input type='hidden' name='idZona' value='" + z.getIdZona() + "' />");
                            
                            out.println("<input type='hidden' name='action' value='irArea' />");
                            out.println("<button class='btn btn-gray bg-info text-info'>Modificar</button>");
                            out.println("<a href='detalleZona?action=borrar&idZona=" + z.getIdZona() + "&areaFK=" + z.getIdAreaFK() + "&id=" + z.getIdAreaFK() + "' class='btn btn-gray bg-info text-info'>Eliminar</a>");
                        }


                    %>

                </div>
            </form>
        </div>


    </div>

</section>      
<%@include file="jspf/pie.jspf"%>     
