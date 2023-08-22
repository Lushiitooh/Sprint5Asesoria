package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.UsuarioDaoImpl;
import com.example.modulo5.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listarUsuarioSv")
public class ListarUsuarioSv extends HttpServlet{
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarUsuarioSv() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
        List<Usuario> usuarios = usuarioDaoImpl.listarUsuarios();
        request.setAttribute("usuarios", usuarios);
        request.getRequestDispatcher("views/listarUsuarios.jsp").forward(request, response);
    }
}
