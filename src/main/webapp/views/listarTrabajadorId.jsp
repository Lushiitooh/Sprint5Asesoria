<%@ page import="com.example.modulo5.model.Trabajador" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-primary d-flex flex-column justify-content-between vh-100">
<%@ include file="nav-inicio.jsp" %>

<div class="container mt-5">
    <div class="text-center fs-4 fw-bold">Lista de Trabajadores por ID</div>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <form method="POST" action="<%= request.getContextPath() %>/listarTrabajadorIdSv">
                <div class="mb-3">
                    <label for="trabajadorId" class="form-label">Ingrese el ID del Trabajador:</label>
                    <input type="text" class="form-control" id="trabajadorId" name="trabajadorId" required>
                </div>
                <button type="submit" class="btn btn-primary">Buscar</button>
            </form>
        </div>
    </div>

    <% List<Trabajador> trabajadores = (List<Trabajador>) request.getAttribute("trabajadores");
        if (trabajadores != null && !trabajadores.isEmpty()) { %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>RUT</th>
                    <th>Nombres</th>
                    <th>Apellidos</th>
                    <th>Área</th>
                    <th>Correo Electrónico</th>
                    <th>Cargo</th>
                    <th>ID Cliente</th>
                    <th>Fecha de Ingreso</th>
                    <!-- Agrega más encabezados según tus necesidades -->
                </tr>
                </thead>
                <tbody>
                <% for (Trabajador trabajador : trabajadores) { %>
                <tr>
                    <td><%= trabajador.getId() %></td>
                    <td><%= trabajador.getRut() %></td>
                    <td><%= trabajador.getNombres() %></td>
                    <td><%= trabajador.getApellido1() %> <%= trabajador.getApellido2() %></td>
                    <td><%= trabajador.getArea() %></td>
                    <td><%= trabajador.getCorreoElectronico() %></td>
                    <td><%= trabajador.getCargo() %></td>
                    <td><%= trabajador.getIdCliente() %></td>
                    <td><%= trabajador.getFechaIngreso() %></td>
                    <!-- Agrega más celdas según tus necesidades -->
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <% } else if (trabajadores == null) { %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <div class="alert alert-danger" role="alert">Ocurrió un error al consultar la base de datos.</div>
        </div>
    </div>
    <% } else { %>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <div class="alert alert-warning" role="alert">No se encontraron trabajadores con ese ID.</div>
        </div>
    </div>
    <% } %>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
