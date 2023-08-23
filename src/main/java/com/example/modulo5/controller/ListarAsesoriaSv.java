package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.AsesoriaDaoImpl;
import com.example.modulo5.model.Asesoria;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ListarAsesoriaSv")
public class ListarAsesoriaSv extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAsesoriaSv() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AsesoriaDaoImpl asesoriaDaoImpl = new AsesoriaDaoImpl();
        List<Asesoria> asesorias = asesoriaDaoImpl.listarAsesoria();
        request.setAttribute("asesorias", asesorias);
        request.getRequestDispatcher("views/listarAsesorias.jsp").forward(request, response);
    }
}
