<%@ page import="com.example.modulo5.model.Asesoria" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp"/>
<style>
  label.error {
    color: red;
    font-style: italic;
  }
</style>
<body>

<%@ include file='header.jsp' %>

<div class="container mt-5" style="min-height: 750px;">
  <div class="row mb-3">
    <h1 class="text-center mb-3">Listado de asesorías</h1>
    <div class="col-12 table-responsive">
      <div class="container mt-5">
        <div class="text-center fs-4 fw-bold">Lista de Trabajadores</div>
        <div class="row justify-content-center mt-4">
          <div class="col-md-12">
            <form method="POST" action="<%= request.getContextPath() %>/ListarAsesoriaSv">
              <button type="submit" class="btn btn-primary">Buscar</button>
            </form>
          </div>
        </div>
      <% List<Asesoria> listaAsesorias = (List) request.getAttribute("asesorias");
        if (listaAsesorias != null && !listaAsesorias.isEmpty() ) { %>

      <table class="table table-striped table-hover" id="tablaAsesorias">
        <thead>
        <tr>
          <th hidden>ID</th>
          <th>Nombre asesoría</th>
          <th>Id tipo riesgo</th>
          <th>Descripción asesoria</th>
          <th>Fecha Ingreso</th>
          <th>Id cliente petición</th>
          <th>Estado</th>
        </tr>
        </thead>
        <tbody>

        <%
          for (Asesoria asesoria : listaAsesorias) {
        %>
        <tr>
          <td hidden><%= asesoria.getId() %></td>
          <td><%= asesoria.getNombre_asesoria() %></td>
          <td><%= asesoria.getId_tipo_riesgo() %></td>
          <td><%= asesoria.getDescripcion_asesoria() %></td>
          <td><%= asesoria.getFecha_ingreso() %></td>
          <td><%= asesoria.getId_cliente_peticion() %></td>
          <td><%= asesoria.isEstado() %></td>
        </tr>
        <% } %>
        </tbody>
      </table>
    </div>
  </div>
    <% } else { %>
  <div class="alert alert-warning" role="alert">No se encontraron asesorías en la base de datos.</div>
    <% } %>

  <jsp:include page="footer.jsp"/>
</body>
</html>