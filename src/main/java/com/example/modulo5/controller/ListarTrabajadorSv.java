package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.TrabajadorDaoImpl;
import com.example.modulo5.model.Trabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
@WebServlet("/listarTrabajadorSv")
public class ListarTrabajadorSv extends HttpServlet{

        /**
         * @see HttpServlet#HttpServlet()
         */
        public ListarTrabajadorSv() {
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
            TrabajadorDaoImpl trabajadorDaoImpl = new TrabajadorDaoImpl();
            List<Trabajador> trabajadores = trabajadorDaoImpl.listarTrabajador();
            request.setAttribute("trabajadores", trabajadores);
            request.getRequestDispatcher("views/listarTrabajadores.jsp").forward(request, response);
        }
    }
