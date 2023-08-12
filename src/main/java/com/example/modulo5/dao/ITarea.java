package com.example.modulo5.dao;

import com.example.modulo5.model.Tarea;

import java.util.List;

public interface ITarea {
    public Tarea crearTarea(Tarea tarea);
    public List<Tarea> listarTarea();
    public List<Tarea> listarTareasTipos(int idTiposTareas);
    public List<Tarea> listarTareasAsesoria(int idAsesoria);
    public Tarea actualizarTarea(Tarea tarea);
    public  boolean eliminarTarea(int idTarea);

}
