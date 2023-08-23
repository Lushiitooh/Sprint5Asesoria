<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-primary d-flex flex-column justify-content-between vh-100">
<%@ include file="nav-inicio.jsp" %>

<div class="container mt-5">
    <div class="text-center fs-4 fw-bold">Crear Trabajador</div>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <%-- Mostrar el mensaje de error si existe --%>
            <% String error = (String) request.getAttribute("error");
                if (error != null && !error.isEmpty()) { %>
            <div class="alert alert-danger" role="alert">
                <%= error %>
            </div>
            <% } %>

            <form method="POST" action="<%= request.getContextPath() %>/CrearTrabajadorSv">
                <div class="mb-3">
                    <label for="rut" class="form-label">RUT:</label>
                    <input type="text" class="form-control" id="rut" name="rut" required>
                </div>
                <div class="mb-3">
                    <label for="nombres" class="form-label">Nombres:</label>
                    <input type="text" class="form-control" id="nombres" name="nombres" required>
                </div>
                <div class="mb-3">
                    <label for="apellido1" class="form-label">Primer Apellido:</label>
                    <input type="text" class="form-control" id="apellido1" name="apellido1" required>
                </div>
                <div class="mb-3">
                    <label for="apellido2" class="form-label">Segundo Apellido:</label>
                    <input type="text" class="form-control" id="apellido2" name="apellido2" required>
                </div>
                <div class="mb-3">
                    <label for="area" class="form-label">Área:</label>
                    <input type="text" class="form-control" id="area" name="area" required>
                </div>
                <div class="mb-3">
                    <label for="correoElectronico" class="form-label">Correo Electrónico:</label>
                    <input type="email" class="form-control" id="correoElectronico" name="correoElectronico" required>
                </div>
                <div class="mb-3">
                    <label for="cargo" class="form-label">Cargo:</label>
                    <input type="text" class="form-control" id="cargo" name="cargo" required>
                </div>
                <!-- Eliminamos el campo IDCliente -->
                <button type="submit" class="btn btn-primary">Crear Trabajador</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>