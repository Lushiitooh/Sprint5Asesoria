<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <%@ include file="head.jsp" %>
</head>
<body class="bg-primary d-flex flex-column justify-content-between vh-100">
<%@ include file="nav-inicio.jsp" %>

<div class="container mt-5">
    <div class="text-center fs-4 fw-bold">Trabajador Creado Exitosamente</div>
    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <div class="alert alert-success" role="alert">El trabajador se ha creado exitosamente.</div>
        </div>
    </div>

    <div class="row justify-content-center mt-4">
        <div class="col-md-12">
            <a href="<%= request.getContextPath() %>/views/crearTrabajador.jsp" class="btn btn-primary">Agregar Nuevo Trabajador</a>
        </div>
    </div>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>