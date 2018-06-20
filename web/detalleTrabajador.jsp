<%-- 
    Document   : detalleTrabajador
    Created on : 25-may-2018, 9:18:59
    Author     : ANTONIO
--%>

<%@page import="com.cartelle.modelo.Trabajador"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@include file="jspf/encabezado.jspf"%>
<%
  Trabajador t=(Trabajador)request.getAttribute("trabajador");  
  
%>
<section >

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">CÓDIGO DE TRABAJADOR:&nbsp; <%=t.getCodTrabajador()%></h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" method="post" action="trabajadores">
               
                <div class="form-group">
                    <label for="empleo" class="col-lg-2 control-label">Empleo</label>
                    <div class="col-lg-2">
                        <input type="text" class="form-control" id="empleo" name="empleo" placeholder="Empleo" value="<%=t.getEmpleo()%>">
                    </div>
                     <label for="nombre" class="col-lg-2 control-label">Nombre</label>
                    <div class="col-lg-6">
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="nombre" value="<%=t.getNombre()%>">
                    </div>
                   
                </div>
                
                    
               
                <div class="form-group">
                    <label for="puesto" class="col-lg-2 control-label">Puesto de trabajo</label>
                    <div class="col-lg-10">
                       <input type="text" class="form-control" id="puesto" name="puesto" readonly placeholder="Puesto de trabajo" value="<%=t.getPuesto()%>">
                    </div>
                </div>
                <div class="form-group">
                    <label for="area" class="col-lg-2 control-label">Área de trabajo</label>
                    <div class="col-lg-10">
                       <input type="text" class="form-control" id="area" readonly placeholder="Área de trabajo" value="<%=t.getArea()%>">
                    </div>
                </div>
                
  <div class="form-group">

                    <div class='col-lg-10'></div> 
                    <input type='hidden' name='id' value='<%=t.getId()%>' />
                    <input type='hidden' name='codigo' value='<%=t.getCodTrabajador()%>' />
                    <button class='btn btn-gray bg-info text-info'>Modificar</button>
  </div>
            </form>
        </div>
    </div>







</section>      





<%@include file="jspf/pie.jspf"%>  