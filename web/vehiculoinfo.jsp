<%-- 
    Document   : vehiculoinfo
    Created on : 6/03/2016, 03:14:26 PM
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
        <title>Vehiculo Information</title>
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
                        <a href="/ConcesionarioTarea/">Buscador<span class="sr-only">(current)</span></a>
                    </li>
                    
                    <li>
                        <a href="/ConcesionarioTarea/clienteinfo.jsp">Clientes</a>
                    </li>
                    <li class="active">
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
        <h1>Informacion Vehiculo</h1>
        <form action="./VehiculoServlet" method="POST">
        <table class="table input-group">
            <tr>
                <th>Vehiculo ID</th>
                <th><input type="text" class="form-control" name="vehiculoId" placeholder="Opcional" value="${vehiculo.vehiculoId}"/> </th>
            </tr>
            <tr>
                <th>Fabricante</th>
                <th> <input type="text" class="form-control" name="fabricante" value="${vehiculo.fabricante}"/></th>
            </tr>
             <tr>
                <th>Fecha</th>
                <th><input type="text" class="form-control" name="fecha" value="${vehiculo.fecha}"/> </th>
            </tr>
            <tr>
                <th>Cilindraje</th>
                <th><input type="text" class="form-control" name="cilindraje" value="${vehiculo.cilindraje}"/> </th>
            </tr>
            <tr>
                <th>Potencia</th>
                 <th><input type="text" class="form-control" name="potencia" value="${vehiculo.potencia}"/> </th>
            </tr>
            <tr>
                <th>Precio</th>
                <th><input type="text" class="form-control" name="precio" value="${vehiculo.precio}"/> </th>
            </tr>
            <tr>
                <th>Transmision</th>
                <th><input type="text" class="form-control" name="transmision" value="${vehiculo.transmision}"/> </th>
            </tr>
             <tr>
                <th>Imagen</th>
                <th><input type="text" class="form-control" name="imagen" value="${vehiculo.imagen}"/> </th>
            </tr>
            <tr>
                <th>Modelo</th>
                <th><input type="text" class="form-control" name="modelo" value="${vehiculo.modelo}"/> </th>
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
                    <th>Vehiculo ID</th>
                    <th>Fabricante</th>
                    <th>Fecha</th>
                    <th>Cilindraje</th>
                    <th>Potencia</th>
                    <th>Precio</th>
                    <th>Transmision</th>
                    <th>Imagen</th>
                    <th>Modelo</th>

                    <c:forEach items="${allVehiculos}" var="vehi">
                        <tr>
                            <td>${vehi.vehiculoId}</td>
                            <td>${vehi.fabricante}</td>
                            <td>${vehi.fecha}</td>
                            <td>${vehi.cilindraje}</td>
                            <td>${vehi.potencia}</td>
                            <td>${vehi.precio}</td>
                            <td>${vehi.transmision}</td>
                            <td>${vehi.imagen}</td>
                            <td>${vehi.modelo}</td>
                        </tr>
                    </c:forEach>
               </table>
           </div>
        </div>
    </body>
</html>
