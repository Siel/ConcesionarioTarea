<%-- 
    Document   : index
    Created on : 6/03/2016, 05:55:30 PM
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
        <title>Tarea 1 - Sistema Concesionario</title>
    </head>
    <body>
        <!-- NavBar -->
        
        <!-- End NavBar -->
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
                    <li class="active">
                        <a href="/ConcesionarioTarea/">Buscador<span class="sr-only">(current)</span></a>
                    </li>
                    
                    <li>
                        <a href="/ConcesionarioTarea/clienteinfo.jsp">Clientes</a>
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
            <h1>Bienvenidos</h1>
            
            <div class="row">
            <form action="./BuscadorServlet" method="POST">
                <div class="col-lg-6">
                  <div class="input-group">
                    <input name="matricula" type="text" class="form-control" placeholder="Ingresa la Matricula a buscar..">
                    <span class="input-group-btn">
                      <input class="btn btn-default" type="submit">Buscar</button>
                    </span>
                  </div><!-- /input-group -->
                </div><!-- /.col-lg-6 -->
            </form>
          </div><!-- /.row -->
          <br>
          <br>
          <row>
              <div class="table-responsive">
                <table class="table">
                    <th>Matricula</th><!-- Ventas -->
                    <th>Modelo</th><!-- Vehiculo -->
                    <th>Fabricante</th><!-- Vehiculo -->
                    <th>Nombre Propietario</th><!-- Cliente -->
                    <th>Apellido Propietario</th><!-- Cliente -->
                    <th>Imagen</th><!-- Vehiculo -->
                    <tr>
                        <td>${venta.matricula}</td>
                        <td>${vehiculo.modelo}</td>
                        <td>${vehiculo.fabricante}</td>
                        <td>${cliente.nombre}</td>
                        <td>${cliente.apellido}</td>
                        <td>${vehiculo.imagen}</td>
                    </tr>
               </table>
           </div>
          </row>
        </div>
        
    </body>
</html>
