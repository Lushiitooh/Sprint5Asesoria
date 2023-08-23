package com.example.modulo5.controller;

import com.example.modulo5.dao.daoimpl.AccidenteDaoImpl;
import com.example.modulo5.model.Accidente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/EditarAccidenteSv")
public class EditarAccidenteSv extends HttpServlet {

    public EditarAccidenteSv() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AccidenteDaoImpl accidenteDao = new AccidenteDaoImpl();

        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        int idTrabajador = Integer.parseInt(request.getParameter("trabajador"));
        String lugarAccidente = request.getParameter("lugar");
        String descripcionAccidente = request.getParameter("descripcion");
        String tipoAccidente = request.getParameter("tipoAccidente");
        int idCliente = Integer.parseInt(request.getParameter("cliente"));

        Accidente accidente = new Accidente();
        accidente.setId(id);
        accidente.setFechaAccidente(LocalDate.parse(fecha));
        accidente.setHoraAccidente(LocalTime.parse(hora));
        accidente.setIdTrabajador(idTrabajador);
        accidente.setLugarAccidente(lugarAccidente);
        accidente.setDescripcionAccidente(descripcionAccidente);
        accidente.setTipoAccidente(tipoAccidente);
        accidente.setIdCliente(idCliente);

        accidenteDao.editarAccidente(accidente);

        response.sendRedirect("/MODULO5_war/listarAccidenteSv");
    }
}

