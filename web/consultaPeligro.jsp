

<%@page import="java.awt.Color"%>
<%@page import="com.cartelle.modelo.ConsultaPeligro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<section>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Riesgos del Puesto de Trabajo</h3>
        </div>
        <div class="panel-body">
            <table class="table">
                <thead>
                    <tr>
                        <th class="text-center">Codigo Area</th>
                        <th class="text-center">Area</th>
                        <th class="text-center">Codigo Puesto</th>
                        <th class="text-center">Puesto</th>
                        <th class="text-center">Factor Riesgo</th>
                        <th class="text-center">Nivel Prioridad</th>
                        <th class="text-center"></th>
                    </tr>
                </thead>

                <%
                    ArrayList<ConsultaPeligro> datos = (ArrayList<ConsultaPeligro>) request.getAttribute("datos");

                    for (ConsultaPeligro a : datos) {
                        String c = a.getnIntervencion();
                        System.out.println(c);
                        String color = "";
                        switch (c) {
                            case "I":
                                color = "r";
                                break;
                            case "II":
                                color = "y";
                                break;
                            case "III":
                                color = "g";
                                break;
                            case "IV":
                                color = "b";
                                break;
                        }

                        out.println("<tr class='" + color + "'>");
                        out.println("<td class='text-center'>" + a.getCodArea() + "</td>");
                        out.println("<td class='text-center'>" + a.getNombre() + "</td>");
                        out.println("<td class='text-center'>" + a.getCodPuesto() + "</td>");
                        out.println("<td class='text-center'>" + a.getPuesto() + "</td>");
                        out.println("<td class='text-center'>" + a.getFactorRiesgo() + "</td>");
                        out.println("<td class='text-center'>" + a.getnIntervencion() + "</td>");
                        out.println("<td class='text-center'><a class='text-black w' href='detalleEvaluacionPuestos?action=verdetalle&id=" + a.getIdArea() + "&id2=" + a.getIdEvaluacionPuesto() + "'>ver detalle</a></td>");
                        out.println("</tr>");
                    }
                %>

            </table>
            <div class="col-lg-11"></div>

            <%
                String volver="";
                if(request.getParameter("action").equals("verdetalle")){
                     volver="ControladorEvaluacionPuestos";
                    
                }
                if(request.getParameter("action").equals("verEva")){
                    volver="puestos";
                }
                
                %>
          <a href="<%=volver %>" class="btn btn-gray bg-info text-info" >Volver</a>
        </div>
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>