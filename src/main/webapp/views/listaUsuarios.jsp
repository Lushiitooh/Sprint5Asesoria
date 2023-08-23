<%@ page import="com.example.modulo5.dao.daoimpl.UsuarioDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.modulo5.model.Usuario" %><%--
  Created by IntelliJ IDEA.
  User: lopez
  Date: 22/08/2023
  Time: 09:29 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
  UsuarioDaoImpl daoImpl = new UsuarioDaoImpl();

  List<Usuario> listaUsuarios = daoImpl.listarUsuarios();

  for (Usuario usuario : listaUsuarios) {
%>
<table>
<tr>
  <td hidden><%= usuario.getId()%></td>
  <td><%= usuario.getRun() %></td>
  <td><%= usuario.getNombres() %></td>
  <td><%= usuario.getApellido1() %></td>
  <td><%= usuario.getApellido2() %></td>
  <td><%= usuario.getCorreoElectronico() %></td>
  <td><%= usuario.getTelefono() %></td>
  <td><%= usuario.getDireccion() %></td>
  <td><%= usuario.getIdTipoUsuario()%></td>
  <td><%= usuario.getUsuarioIngreso() %></td>
  <td><%= usuario.getFechaRegistro() %></td>
  <td><%= usuario.getIdCliente() %></td>
</tr>
<% } %>
</table>
</body>
</html>
