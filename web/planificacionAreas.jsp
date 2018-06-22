

<%@page import="com.cartelle.modelo.PlanificacionAreas"%>
<%@page import="java.awt.Color"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<section>
    <div class="panel panel-primary">

        <div class="panel-heading col-lg-12">
            <h3 class="panel-title col-lg-10">Planificación Areas de Trabajo</h3>
            <div>
                <ul class="col-lg-2">
                    <li class="btn btn-gray bg-info text-info">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">ACTIVOS
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu ">
                            <li><a href="ControladorPlanificacionAreas?action=historico">HISTORICO</a></li>
                            <li><a href="ControladorPlanificacionAreas?action=todos">TODOS</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>

        <div class="panel-body">
            <table class="table">
                <thead>
                    <tr>
                        <th class="text-center">Código Area</th>
                        <th class="text-center">Código Peligro</th>
                        <th class="text-center">Factor Riesgo</th>
                        <th class="text-center">Nivel Prioridad</th>
                        <th class="text-center">Medidas Propuestas</th>
                        <th class="text-center">&nbsp;&nbsp;Normativa&nbsp;&nbsp;</th>
                        <th class="text-center">&nbsp;&nbsp;&nbsp;&nbsp;Detalle&nbsp;&nbsp;&nbsp;&nbsp;</th>
                    </tr>
                </thead>

                <%
                    ArrayList<PlanificacionAreas> datos = (ArrayList<PlanificacionAreas>) request.getAttribute("datos");

                    for (PlanificacionAreas a : datos) {
                        String c = a.getPrioridad();
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
                        out.println("<td class='text-center'>" + a.getCodPeligroFK() + "</td>");
                        out.println("<td class='text-center'>" + a.getFactorRiesgo() + "</td>");
                        out.println("<td class='text-center'>" + a.getPrioridad() + "</td>");
                        out.println("<td class='text-center'>" + a.getMedidaPropuesta() + "</td>");
                        out.println("<td class='text-center'>" + a.getNormativa() + "</td>");
                        if (a.getFechaSubsanado() == null) {
                            out.println("<td class='text-center'><a href='ControladorFechaSubsanadoAreas?action=insertarfecha&id=" + a.getIdEvaluacionArea() + "'>Cerrar Peligro</a></td>");
                        } else {
                            out.println("<td class='text-center'>" + a.getFechaSubsanado() + "</td>");
                        }
                        out.println("</tr>");
                    }
                %>

            </table>
        </div>  
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>