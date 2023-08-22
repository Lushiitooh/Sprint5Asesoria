package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.ClienteDaoImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;

@WebServlet("/EliminarClienteSV")
public class EliminarClienteSV extends HttpServlet {

    public EliminarClienteSV() {
    }



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ClienteDaoImpl clienteDaoImpl = new ClienteDaoImpl();
            int clienteId = 0;
            clienteId = Integer.parseInt(request.getParameter("idCliente"));
            boolean eliminado = false;
            eliminado = clienteDaoImpl.eliminarCliente(clienteId);
            request.setAttribute("esta eliminado", eliminado);
            request.getRequestDispatcher("views/listarClientes.jsp").forward(request, response);
       }

}
