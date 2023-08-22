package com.example.modulo5.controller;

import com.example.modulo5.dao.IAsesoria;
import com.example.modulo5.dao.daoimpl.AsesoriaDaoImpl;
import com.example.modulo5.model.Asesoria;
import com.example.modulo5.model.Trabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/crearAsesoriasSv")
public class CrearAsesoriaSv extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearAsesoriaSv() {
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
        IAsesoria asesoriaDaoImpl = new AsesoriaDaoImpl();
        Asesoria asesoria = new Asesoria(
                0,
                request.getParameter("nombre_asesoria"),
                Integer.parseInt(request.getParameter("id_tipo_riesgo")),
                request.getParameter("descripcion_asesoria"),
                LocalDateTime.now(),
                0,
                true

        );
        asesoriaDaoImpl.crearAsesoria(asesoria);
        //response.sendRedirect(request.getContextPath() + "/listarAsesorias.jsp");
    }
}
