package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.TareaDaoImpl;
import com.example.modulo5.dao.daoimpl.TrabajadorDaoImpl;
import com.example.modulo5.model.Tarea;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/TareaSv")
public class TareaSv extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        TareaDaoImpl dao = new TareaDaoImpl();
        List<Tarea> lista = dao.listarTarea();
        for (Tarea tarea : lista ) {
            System.out.println(tarea.getId());
            System.out.println(tarea.getNombre_tarea());

        }
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Hello, this is your TareaSv servlet!</h1>");
        response.getWriter().println("<h1>hay "+lista.size()+" tareas en base de datos </h1>");
        response.getWriter().println("</body></html>");
    }
}
