<%-- 
    Document   : ventainfo
    Created on : 6/03/2016, 03:14:14 PM
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
        <title>Venta Information</title>
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
                    
                    <li>
                        <a href="/ConcesionarioTarea/clienteinfo.jsp">Clientes</a>
                    </li>
                    <li>
                        <a href="/ConcesionarioTarea/vehiculoinfo.jsp">Vehículos</a>
                    </li>
                    <li class="active">
                        <a href="/ConcesionarioTarea/ventainfo.jsp">Ventas<span class="sr-only">(current)</span></a>
                    </li>
                    
                  </ul>
                  
                  
                </div><!-- /.navbar-collapse -->
            </div>
        </nav>
        <!-- End NavBar -->
        <div class="container">
        <h1>Informacion Venta</h1>
        <form action="./VentaServlet" method="POST">
        <table class="table input-group">
            <tr>
                <th> Venta ID</th>
                <th><input type="text" class="form-control" name="ventaId" placeholder="Opcional" value="${venta.ventaId}"/> </th>
            </tr>
            <tr>
                <th> Identificacion</th>
                <th> <input type="text" class="form-control" name="clienteId" value="${venta.cliente.clienteId}"/></th>
            </tr>
             <tr>
                <th>Modelo</th>
                <th><input type="text" class="form-control" name="modelo" value="${venta.vehiculo.modelo}"/> </th>
            </tr>
            <tr>
                <th>Matricula</th>
                <th><input type="text" class="form-control" name="matricula" value="${venta.matricula}"/> </th>
            </tr>
            <tr>
                <th>Fecha</th>
                <th><input type="text" class="form-control" name="fecha" value="${venta.fecha}"/> </th>
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
                <th>Venta ID</th>
                <th>Identificacion</th>
                <th>Modelo</th>
                <th>Matricula</th>
                <th>Fecha</th>
                
                <c:forEach items="${allVentas}" var="vent">
                    <tr>
                        <td>${vent.ventaId}</td>
                        <td>${vent.cliente.clienteId}</td>
                        <td>${vent.vehiculo.modelo}</td>
                        <td>${vent.matricula}</td>
                        <td>${vent.fecha}</td>
                    </tr>
                </c:forEach>
           </table>
            </div>
        </div>
    </body>
</html>
