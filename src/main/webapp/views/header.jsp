<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<header>
  <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #7952b3;">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">SGAS</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse  pe-5" id="navbarNav">
        <ul class="navbar-nav ms-md-auto">
          <li class="nav-item">
            <a class="nav-link active" href="usuario">Listar usuarios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href="#">Crear usuarios</a>
          </li>

          <li class="nav-item">
            <a class="nav-link active" href="SVListarCapacitacion">Listar capacitación</a>
          </li>

          <%--<%
            int perfilUsuario = (int) session.getAttribute("tipoUsuario");
            if(perfilUsuario == 1){ %>--%>
          <li class="nav-item">
            <a class="nav-link active" href=#>Crear capacitación</a>
          </li>
          <%--<% }%>--%>
          <li class="nav-item">
            <a class="nav-link active" href=#>Contacto</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active" href=#>Cerrar sesión</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>