package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.CapacitacionDaoImpl;
import com.example.modulo5.model.Capacitacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/listarCapacitacionSv")
public class ListarCapacitacionSv extends HttpServlet{
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapacitacionSv() {
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
        CapacitacionDaoImpl capacitacionDaoImpl = new CapacitacionDaoImpl();
        List<Capacitacion> capacitaciones = capacitacionDaoImpl.listarCapacitacion();
        request.setAttribute("capacitaciones", capacitaciones);
        request.getRequestDispatcher("views/listarCapacitaciones.jsp").forward(request, response);
    }
}
