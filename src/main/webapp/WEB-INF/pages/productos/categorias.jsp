<%--
  Created by IntelliJ IDEA.
  User: maguzman
  Date: 27/04/2017
  Time: 01:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management Screen</title>
</head>
<body>
<div align="center">
    <h1>Categoria List</h1>
    <h3>
        <a href="">Nueva Categoria</a>
    </h3>
    <table border="1">
        <th>Codigo</th>
        <th>Nombre</th>
        <th>Action</th>

        <c:forEach var="categoria" items="${listaCategoria}">
            <tr>

                <td>${categoria.idCategoria}</td>
                <td>${categoria.nombre}</td>
                <td><a href="/categoria/editar?idCategoria=${categoria.idCategoria}">Edit</a>
                    <a
                            href="deleteEmployee?id=${categoria.idCategoria}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

