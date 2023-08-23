package com.example.modulo5.controller;


import com.example.modulo5.dao.daoimpl.ClienteDaoImpl;
import com.example.modulo5.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/ListarClienteIdSV")
public class ListarClienteIdSV extends HttpServlet {

    public ListarClienteIdSV() { super(); }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        int clienteId = 0;
        clienteId = Integer.parseInt(request.getParameter("idCliente"));
        Cliente clienteEncontrado = clienteDaoImpl.listarClienteId(clienteId);
        request.setAttribute("cliente", clienteEncontrado);
        request.getRequestDispatcher("views/listarClientesId.jsp").forward(request, response);
    }
}
