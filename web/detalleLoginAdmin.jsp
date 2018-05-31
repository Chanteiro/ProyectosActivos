<%-- 
    Document   : detalleLoginAdmin
    Created on : 28-may-2018, 9:28:42
    Author     : ANTONIO
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="com.cartelle.modelo.LoginAdmin"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>

<%
    String name, us, pass, role;
    name = "";
    us = "";
    pass = "";
    role = "Seleccione uno...";
    ArrayList<String> roles = (ArrayList<String>) request.getAttribute("roles");
    String action = request.getParameter("action");
    if (action.equals("Detalles")) {
        LoginAdmin login = (LoginAdmin) request.getAttribute("Lg");

        name = login.getNombrecompleto();
        us = login.getUsuario();
        pass = login.getContrasena();
        role = login.getRol();
    }
    if (action.equals("nuevoUser")) {
        name = "";
        us = "";
        pass = "";
        role = "Seleccione uno...";
    }
%>

<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">DATOS DE USUARIOS</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" method='post' action="LoginAdmin">
                <div class="form-group">
                    <label for="nombreCompleto" class="col-lg-3 control-label">Nombre</label>
                    <div class="col-lg-6">
                        <input type="text" class="form-control" name="name" id="nombreCompleto" required='required' value='<%=name%>'>
                    </div>

                </div>
                <div class="form-group">
                    <label for="usuario" class="col-lg-3 control-label">Usuario</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" name="usuario" id="usuario" maxlength="10" required='required' value='<%=us%>'>
                    </div>

                    <label for="contrasena" class="col-lg-2 control-label">Contraseña</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" name="contrasena" id="contrasena" maxlength="10" required='required' value='<%=pass%>'>
                    </div>

                </div>
                <div class="form-group">

                    <label for="rol" class="col-lg-3 control-label">Rol</label>
                    <div class="col-lg-2">
                        <select id='rol' name="rol" class="selectpicker form-control" required='required' >
                            <% out.println("<option value=" + role + ">" + role + "</option>");
                                for (String r : roles) {
                                    if (!r.equals(role)) {
                                        out.println("<option value=" + r + ">" + r + "</option>");
                                    }

                                }%>

                        </select> 
                    </div>
                </div>
        </div>
        <div class="form-group">
            <div class='col-lg-10'></div>   
            <%
                if(action.equals("Detalles")){
                     LoginAdmin login = (LoginAdmin) request.getAttribute("Lg");
                    out.println("<input type='hidden' name='iden' value='"+login.getIdLogin()+"' />"); 
                    out.println("<button class='btn btn-gray bg-info text-info'>Modificar</button>");
                    out.println("<a href='LoginAdmin?accion=borrar&id="+login.getIdLogin()+"' class='btn btn-gray bg-info text-info'>Eliminar</a>");
                }else{
                    out.println("<button class='btn btn-gray bg-info text-info'>Registrar</button>");
                }
                
                
                
                
                
                %>
            
        </div>  

        </form>
    </div>
</div>
<%@include file="jspf/pie.jspf"%>
