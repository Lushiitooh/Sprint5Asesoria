package com.example.modulo5.dao;

import com.example.modulo5.model.Tarea;

import java.util.List;

public interface ITarea {
    public boolean crearTarea(Tarea tarea);
    public List<Tarea> listarTarea();
    public List<Tarea> listarTareasTipos(int idTiposTareas);
    public List<Tarea> listarTareasAsesoria(int idAsesoria);
    public boolean actualizarTarea(Tarea tarea);
    public  boolean eliminarTarea(int idTarea);
}
