<%-- 
    Document   : Producto
    Created on : 7/10/2021, 12:14:46 PM
    Author     : yiver
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
        <body>
            <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">                    
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${producto.getNom()}" name="txtNombres" class="form-control">
                        </div>
                        <div class="form-qroup">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}" name="txtPre" class="form-control">
                        </div>
                         <div class="form-qroup">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStock()}" name="txtStock" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" value="${producto.getEstado()}" name="txtEstado" class="form-control">
                        </div>                    
                        <input type="submit"  name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit"  name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>                        
                            <th>NOMBRES</th>
                            <th>PEECIO</th>
                            <th>STOCK</th>  
                            <th>ESTADO</th>                       
                            <th>ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${productos}">   
                        <tr>
                            <td>${em.getId()}</td>                        
                            <td>${em.getNom()}</td>
                            <td>${em.getPrecio()}</td>
                            <td>${em.getStock()}</td>
                            <td>${em.getEstado()}</td>                        
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Editar&id=${em.getId()}">Editar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Delete&id=${em.getId()}"> Delete</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>



            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </body>
</html>
