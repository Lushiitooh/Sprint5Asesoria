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

@WebServlet ("/listarTrabajadorIdSv")
public class ListarTrabajadorIdSv extends HttpServlet {
    public ListarTrabajadorIdSv(){
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // Obtener el ID del parámetro del formulario
        String idTrabajador = request.getParameter("trabajadorId");

        if (idTrabajador != null && !idTrabajador.isEmpty()){
            // Convertir el ID a un entero
            int trabajadorID = Integer.parseInt(idTrabajador);

            // Crear una instancia de TrabajadorDaoImpl para acceder a la base de datos
            TrabajadorDaoImpl trabajadorDaoImpl = new TrabajadorDaoImpl();

            List<Trabajador> trabajador = trabajadorDaoImpl.listarTrabajadorId(trabajadorID);

            request.setAttribute("trabajadores", trabajador);

        }
        request.getRequestDispatcher("views/listarTrabajadorId.jsp").forward(request, response);
    }
}
