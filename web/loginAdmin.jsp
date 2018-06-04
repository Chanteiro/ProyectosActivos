<%-- 
    Document   : loginAdmin
    Created on : 22-may-2018, 11:38:03
    Author     : Administrador
--%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="com.cartelle.modelo.LoginAdmin"%>
<%@include file="jspf/encabezado.jspf"%>

<section>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title  ">&nbsp;&nbsp;AVISOS / NOTICIAS</h3>

        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" method="get" action="login">
                <div class="form-group">

                    <div class="col-lg-2 control-label">
                        <label for="titulo">Título</label>
                    </div>
                    <div class="col-lg-8">
                        <input type="text" class="form-control" name="titulo" id="titulo" placeholder="Título de mensaje">
                    </div>

                </div>
                <div class="form-group">

                    <div class="col-lg-2 control-label">
                        <label for="contenido">Contenido</label>
                    </div>
                    <div class="col-lg-8">
                        <textarea class="form-control" name="contenido" id="contenido" rows="6"></textarea>
                    </div>

                </div>
                <div class="form-group">
                    <div class='col-lg-9'></div> 
                    
                    <button class='btn btn-gray bg-info text-info'>Publicar</button>
                </div>
            </form>
        </div>
    </div>

</section>

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
                        ArrayList<LoginAdmin> login = (ArrayList<LoginAdmin>) request.getAttribute("login");
                        for (LoginAdmin l : login) {
                            out.println("<tr>");
                            out.println("<td class='text-center'>" + l.getUsuario() + "</td>");
                            out.println("<td class='text-center'>" + l.getContrasena() + "</td>");
                            out.println("<td class='text-center'>" + l.getRol() + "</td>");
                            out.println("<td class='text-center'><a href='detalleLoginAdmin?action=Detalles&id=" + l.getIdLogin() + "'>Detalles</a></td>");
                            out.println("</tr>");
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>  
</section>
<%@include file="jspf/pie.jspf"%>
