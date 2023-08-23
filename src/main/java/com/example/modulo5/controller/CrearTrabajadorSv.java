package com.example.modulo5.controller;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.daoimpl.TrabajadorDaoImpl;
import com.example.modulo5.model.Trabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/CrearTrabajadorSv")

public class CrearTrabajadorSv extends HttpServlet {
    public CrearTrabajadorSv(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rut = request.getParameter("rut");
        TrabajadorDaoImpl trabajadorDaoImpl = new TrabajadorDaoImpl();
        List<Trabajador> trabajadoresConRut = trabajadorDaoImpl.listarTrabajadorRut(rut);

        if (!trabajadoresConRut.isEmpty()) {
            // Mostrar mensaje de error indicando que el RUT ya está en uso
            request.setAttribute("error", "El RUT ya está registrado para otro trabajador.");
            request.getRequestDispatcher("views/crearTrabajador.jsp").forward(request, response);
            return;
        }

        String nombres = request.getParameter("nombres");
        String apellido1 = request.getParameter("apellido1");
        String apellido2 = request.getParameter("apellido2");
        String area = request.getParameter("area");
        String correoElectronico = request.getParameter("correoElectronico");
        String cargo = request.getParameter("cargo");
        //int idCliente = Integer.parseInt(request.getParameter("idCliente"));

        Trabajador nuevoTrabajador = new Trabajador();
        nuevoTrabajador.setRut(rut);
        nuevoTrabajador.setNombres(nombres);
        nuevoTrabajador.setApellido1(apellido1);
        nuevoTrabajador.setApellido2(apellido2);
        nuevoTrabajador.setArea(area);
        nuevoTrabajador.setCorreoElectronico(correoElectronico);
        nuevoTrabajador.setCargo(cargo);
        //nuevoTrabajador.setIdCliente(idCliente);
        nuevoTrabajador.setFechaIngreso(LocalDateTime.now());

        Connection connection = Conexion.getConexion();

        String sql = "INSERT INTO trabajadores (rut, nombres, apellido1, apellido2, area, correo_electronico, cargo, fecha_ingreso) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nuevoTrabajador.getRut());
            preparedStatement.setString(2, nuevoTrabajador.getNombres());
            preparedStatement.setString(3, nuevoTrabajador.getApellido1());
            preparedStatement.setString(4, nuevoTrabajador.getApellido2());
            preparedStatement.setString(5, nuevoTrabajador.getArea());
            preparedStatement.setString(6, nuevoTrabajador.getCorreoElectronico());
            preparedStatement.setString(7, nuevoTrabajador.getCargo());
            preparedStatement.setTimestamp(8, java.sql.Timestamp.valueOf(nuevoTrabajador.getFechaIngreso()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect(request.getContextPath() + "/views/exito.jsp");
    }
}
