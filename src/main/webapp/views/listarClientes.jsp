<%@ page import="com.example.modulo5.model.Cliente" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-primary d-flex flex-column justify-content-between vh-100">
<%@ include file="nav-inicio.jsp" %>


<div class="container mt-5">
    <div class="text-center fs-4 fw-bold">Lista de Clientes</div>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <form method="POST" action="<%= request.getContextPath() %>/ListarClienteSV">
                <button type="submit" class="btn btn-primary">Buscar</button>
            </form>
        </div>
    </div>

    <% List<Cliente> clientes = (List<Cliente>) request.getAttribute("clientes");
        if (clientes != null && !clientes.isEmpty()) { %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>RUT</th>
                    <th>Razón Social</th>
                    <th>Nombre de Contacto</th>
                    <th>Dirección</th>
                    <th>Telefono</th>
                    <th>Correo electronico</th>
                    <th>Fecha de ingreso</th>
                </tr>
                </thead>
                <tbody>
                <% for (Cliente cliente : clientes) { %>
                <tr>
                    <td><%= cliente.getId() %></td>
                    <td><%= cliente.getRut() %></td>
                    <td><%= cliente.getRazon_social() %></td>
                    <td><%= cliente.getNombre_contacto() %></td>
                    <td><%= cliente.getDireccion() %></td>
                    <td><%= cliente.getTelefono() %></td>
                    <td><%= cliente.getCorreo_electronico() %></td>
                    <td><%= cliente.getFechaingreso() %></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <% } else { %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <div class="alert alert-warning" role="alert">No se encontraron clientes en la base de datos.</div>
        </div>
    </div>
    <% } %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>