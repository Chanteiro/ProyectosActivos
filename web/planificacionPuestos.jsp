

<%@page import="java.awt.Color"%>
<%@page import="com.cartelle.modelo.PlanificacionPuestos"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="jspf/encabezado.jspf"%>

<section>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Planificación Puestos de Trabajo</h3>
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
                        <th class="text-center">Fecha Subsanado</th>
                    </tr>
                </thead>

                <%
                    ArrayList<PlanificacionPuestos> datos = (ArrayList<PlanificacionPuestos>) request.getAttribute("datos");

                    for (PlanificacionPuestos a : datos) {
                        String c = a.getPrioridad();
                       
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
                        out.println("<td class='hidden'>" + a.getIdEvaluacionPuestos()+ "</td>");
                        out.println("<td class='text-center'>" + a.getCodArea() + "</td>");
                        out.println("<td class='text-center'>" + a.getCodPuesto() + "</td>");
                        out.println("<td class='text-center'>" + a.getCodPeligroFK() + "</td>");
                        out.println("<td class='text-center'>" + a.getFactorRiesgo() + "</td>");
                        out.println("<td class='text-center'>" + a.getPrioridad()+ "</td>");
                        out.println("<td class='text-center'>" + a.getMedidasPropuestas() + "</td>");
                        out.println("<td class='text-center'>" + a.getNormativa() + "</td>");
                        if(a.getFechaSubsanado()==null){
                        out.println("<td class='text-center'><a href='ControladorFechaSubsanado?action=insertarfecha&id=" + a.getIdEvaluacionPuestos()+ "&id2=" + a.getIdArea() + "'>Insertar Fecha</a></td>");                          
                        }else{
                        out.println("<td class='text-center'>" + a.getFechaSubsanado() + "</td>");
                        }
                        out.println("</tr>");
                    }
                %>

            </table>
            
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>