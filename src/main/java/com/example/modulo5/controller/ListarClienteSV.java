package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.CapacitacionDaoImpl;
import com.example.modulo5.dao.daoimpl.ClienteDaoImpl;
import com.example.modulo5.model.Capacitacion;
import com.example.modulo5.model.Cliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ListarClienteSV")
public class ListarClienteSV extends HttpServlet {

    public ListarClienteSV() {super();}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
        List<Cliente> clientes = clienteDaoImpl.listarCliente();
        request.setAttribute("clientes", clientes);
        request.getRequestDispatcher("views/listarClientes.jsp").forward(request, response);
    }



}
