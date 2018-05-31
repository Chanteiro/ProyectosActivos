<%-- 
    Document   : index
    Created on : 13-mar-2018, 12:30:46
    Author     : ANTONIO
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>.:Servicio de Prevención de Riesgos. Entrar al sistema:.</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <div class="login">
            <h1><span class="glyphicon glyphicon-user"></span>&nbsp;Login</h1>
            <form action="login" method="post">
                <input type="text" name="username" placeholder="Usuario" required="required" />
                <input type="password" name="password" placeholder="Contraseña" required="required" />
                <button type="submit" class="btn btn-primary btn-block btn-large"><span class="glyphicon glyphicon-check"></span>&nbsp;Entrar a PRL.</button>
            </form>
        </div>
    </body>
</html>

