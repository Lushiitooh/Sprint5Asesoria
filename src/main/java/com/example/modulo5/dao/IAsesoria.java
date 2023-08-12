package com.example.modulo5.dao;

import com.example.modulo5.model.Asesoria;

import java.util.List;

public interface IAsesoria {
    public Asesoria crearAsesoria(Asesoria asesoria);
    public List<Asesoria> listarAsesoria();
    public List<Asesoria> listarAsesoriaCliente(int idCliente);
    public Asesoria actualizarAsesoria(Asesoria asesoria);
    public boolean eliminarAsesoria(int idAsesoria);
    public boolean actualizarEstadoAsesoria(int idAsesoria);
}
