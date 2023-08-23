<%@ page import="java.util.List" %>
<%@ page import="com.example.modulo5.model.Usuario" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-primary d-flex flex-column justify-content-between vh-100">
<%@ include file="nav-inicio.jsp" %>

<div class="container mt-5">
    <div class="text-center fs-4 fw-bold">Lista de Usuarios</div>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <form method="POST" action="<%= request.getContextPath() %>/listarUsuarioSv">
                <button type="submit" class="btn btn-primary">Buscar</button>
            </form>
        </div>
    </div>

    <%
        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
        if (usuarios != null && !usuarios.isEmpty()) {
    %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th hidden>ID</th>
                    <th>Run</th>
                    <th>Nombres</th>
                    <th>Apellido 1</th>
                    <th>Apellido 2</th>
                    <th>Correo Electrónico</th>
                    <th>Teléfono</th>
                    <th>Dirección</th>
                    <th>Tipo de Usuario</th>
                    <th>Usuario de Ingreso</th>
                    <th>Fecha de Registro</th>
                    <th>ID Cliente</th>
                </tr>
                </thead>
                <tbody>
                <% for (Usuario usuario : usuarios) { %>
                <tr>
                    <td hidden><%= usuario.getId() %></td>
                    <td><%= usuario.getRun() %></td>
                    <td><%= usuario.getNombres() %></td>
                    <td><%= usuario.getApellido1() %></td>
                    <td><%= usuario.getApellido2() %></td>
                    <td><%= usuario.getCorreoElectronico() %></td>
                    <td><%= usuario.getTelefono() %></td>
                    <td><%= usuario.getDireccion() %></td>
                    <td><%= usuario.getIdTipoUsuario() %></td>
                    <td><%= usuario.getUsuarioIngreso() %></td>
                    <td><%= usuario.getFechaRegistro() %></td>
                    <td><%= usuario.getIdCliente() %></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <% } else { %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <div class="alert alert-warning" role="alert">No se encontraron usuarios en la base de datos.</div>
        </div>
    </div>
    <% } %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>