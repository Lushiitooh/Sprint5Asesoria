package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.ClienteDaoImpl;
import com.example.modulo5.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/CrearClienteSv")
public class CrearClienteSv extends HttpServlet {
    public CrearClienteSv() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        Cliente clienteNuevo = new Cliente();
        int rut = Integer.parseInt(request.getParameter("rutCliente"));
        String razonSocial = request.getParameter("razonSocial");
        String nombreContacto = request.getParameter("nombreContacto");
        String direccion = request.getParameter("direccion");
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        String correo = request.getParameter("correo");


        clienteNuevo.setRut(rut);
        clienteNuevo.setRazon_social(razonSocial);
        clienteNuevo.setNombre_contacto(nombreContacto);
        clienteNuevo.setDireccion(direccion);
        clienteNuevo.setTelefono(telefono);
        clienteNuevo.setCorreo_electronico(correo);
        clienteNuevo.setFechaingreso(LocalDateTime.now());

        clienteDaoImpl.crearCliente(clienteNuevo);
        request.setAttribute("Cliente nuevo", clienteNuevo);
        request.getRequestDispatcher("views/listarClientes.jsp").forward(request, response);
    }
}

