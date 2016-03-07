<%-- 
    Document   : clienteinfo
    Created on : 6/03/2016, 03:14:01 PM
    Author     : Siel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Cliente Information</title>
    </head>
    <body>
        <!-- NavBar -->
        <nav class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">@Concesionario</a>
                 </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                  <ul class="nav navbar-nav">
                    <li >
                        <a href="/ConcesionarioTarea/">Buscador</a>
                    </li>
                    
                    <li class="active">
                        <a href="/ConcesionarioTarea/clienteinfo.jsp">Clientes<span class="sr-only">(current)</span></a>
                    </li>
                    <li>
                        <a href="/ConcesionarioTarea/vehiculoinfo.jsp">Vehículos</a>
                    </li>
                    <li>
                        <a href="/ConcesionarioTarea/ventainfo.jsp">Ventas</a>
                    </li>
                    
                  </ul>
                  
                  
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>
        <!-- End NavBar -->
        <div class="container">
        <h1>Informacion Cliente</h1>
        <form action="./ClienteServlet" method="POST">
        <table class="table input-group">
            
            <tr>
                <th> Identificacion</th>
                <th> <input type="text" class="form-control" name="identificacion" value="${cliente.identificacion}"/></th>
            </tr>
             <tr>
                <th>Nombre</th>
                <th><input type="text" class="form-control" name="nombre" value="${cliente.nombre}"/> </th>
            </tr>
            <tr>
                <th>Apellido</th>
                <th><input type="text" class="form-control" name="apellido" value="${cliente.apellido}"/> </th>
            </tr>
            <tr>
                <th>Edad</th>
                 <th><input type="text" class="form-control" name="edad" value="${cliente.edad}"/> </th>
            </tr>
            <tr>
                <th>Direccion</th>
                <th><input type="text" class="form-control" name="direccion" value="${cliente.direccion}"/> </th>
            </tr>
            <tr>
                <th>Telefono</th>
                <th><input type="text" class="form-control" name="telefono" value="${cliente.telefono}"/> </th>
            </tr>
             <tr>
                <td colspan="2">
                <input type="submit" name="action" value="Add"/>
                <input type="submit" name="action" value="Edit"/>
                <input type="submit" name="action" value="Delete"/>
                <input type="submit" name="action" value="Search"/>
                </td>
             </tr>
            
        </table>
            </form>
            <br>
            <div class="table-responsive">
            <table class="table">
                <th>Identificacion</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Edad</th>
                <th>Direccion</th>
                <th>Telefono</th>
                
                <c:forEach items="${allClientes}" var="client">
                    <tr>
                        <td>${client.identificacion}</td>
                        <td>${client.nombre}</td>
                        <td>${client.apellido}</td>
                        <td>${client.edad}</td>
                        <td>${client.direccion}</td>
                        <td>${client.telefono}</td>
                    </tr>
                </c:forEach>
           </table>
            </div>
        </div>
    </body>
</html>
