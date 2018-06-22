

<%@page import="java.awt.Color"%>
<%@page import="com.cartelle.modelo.PlanificacionPuestos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>


<section>
    <div class="panel panel-primary">
        <div class="panel-heading col-lg-12">
            <h3 class="panel-title col-lg-10">Planificación Puestos de Trabajo</h3>
            <div>
                <ul class="col-lg-2">
                <li class="btn btn-gray bg-info text-info">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">TODOS
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu ">
                        <li><a href="ControladorPlanificacionPuestos?action=activos">ACTIVOS</a></li>
                        <li><a href="ControladorPlanificacionPuestos?action=historico">HISTORICO</a></li>
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
                        <th class="text-center">Código Puesto</th>
                        <th class="text-center">Código Peligro</th>
                        <th class="text-center">Factor Riesgo</th>
                        <th class="text-center">Nivel Prioridad</th>
                        <th class="text-center">Medidas Propuestas</th>
                        <th class="text-center">Normativa</th>
                        <th class="text-center">&nbsp;&nbsp;&nbsp;Detalle&nbsp;&nbsp;&nbsp;</th>
                    </tr>
                </thead>

                <%
                    ArrayList<PlanificacionPuestos> datos = (ArrayList<PlanificacionPuestos>) request.getAttribute("datos");

                    for (PlanificacionPuestos a : datos) {
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
                        out.println("<td class='hidden'>" + a.getIdEvaluacionPuestos() + "</td>");
                        out.println("<td class='text-center'>" + a.getCodArea() + "</td>");
                        out.println("<td class='text-center'>" + a.getCodPuesto() + "</td>");
                        out.println("<td class='text-center'>" + a.getCodPeligroFK() + "</td>");
                        out.println("<td class='text-center'>" + a.getFactorRiesgo() + "</td>");
                        out.println("<td class='text-center'>" + a.getPrioridad() + "</td>");
                        out.println("<td class='text-center'>" + a.getMedidasPropuestas() + "</td>");
                        out.println("<td class='text-center'>" + a.getNormativa() + "</td>");
                        if (a.getFechaSubsanado() == null) {
                            out.println("<td class='text-center'><a href='ControladorFechaSubsanado?action=insertarfecha&id=" + a.getIdEvaluacionPuestos() + "&id2=" + a.getIdArea() + "'>Cerrar Peligro</a></td>");
                        } else {
                            out.println("<td class='text-center'><a href='ControladorVerPeligroSubsanado?action=insertarfecha&id=" + a.getIdEvaluacionPuestos() + "&id2=" + a.getIdArea() + "'>" + a.getFechaSubsanado() + "</a></td>");
                        }
                        out.println("</tr>");
                    }
                %>

            </table>
        </div>  
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>