package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.AccidenteDaoImpl;
import com.example.modulo5.model.Accidente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/listarAccidenteSv")
public class ListarAccidenteSv extends HttpServlet{
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarAccidenteSv() {
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
        AccidenteDaoImpl accidenteDaoImpl = new AccidenteDaoImpl();
        List<Accidente> accidentes = accidenteDaoImpl.listarAccidente();
        request.setAttribute("accidentes", accidentes);
        request.getRequestDispatcher("views/listarAccidentes.jsp").forward(request, response);
    }
}
