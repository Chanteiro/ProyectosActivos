<%-- 
    Document   : loginAdmin
    Created on : 22-may-2018, 11:38:03
    Author     : Administrador
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="com.cartelle.modelo.LoginAdmin"%>
<%@include file="jspf/encabezado.jspf"%>

<section>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title col-lg-10">RELACIÓN DE USUARIOS</h3>
            <a class="btn btn-gray bg-info text-info" href='detalleLoginAdmin?action=nuevoUser'>Nuevo Usuario</a> 
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th class="text-center">USUARIO</th>
                    <th class="text-center">CONTRASEÑA</th>
                    <th class="text-center">ROL</th>
                    <th class="text-center">DETALLE</th>
                </tr>
                </thead>
                <tbody>
                <%
                   ArrayList<LoginAdmin> login  = (ArrayList<LoginAdmin>) request.getAttribute("login");
                    for (LoginAdmin l : login) {
                        out.println("<tr>");
                        out.println("<td class='text-center'>" + l.getUsuario()+ "</td>");
                        out.println("<td class='text-center'>" + l.getContrasena()+ "</td>");
                        out.println("<td class='text-center'>" + l.getRol()+ "</td>");
                        out.println("<td class='text-center'><a href='detalleLoginAdmin?action=Detalles&id="+l.getIdLogin()+"'>Detalles</a></td>");
                        out.println("</tr>");
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>
