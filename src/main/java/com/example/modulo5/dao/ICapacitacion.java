package com.example.modulo5.dao;

import com.example.modulo5.model.Capacitacion;

import java.util.List;

public interface ICapacitacion {
    public Capacitacion crearCapacitacion(Capacitacion capacitacion);
    public List<Capacitacion> listarCapacitacion();
    public List<Capacitacion> listarCapacitacionUsuario(int idUsuario);
    public Capacitacion actualizarCapacitacion(Capacitacion capacitacion);
    public boolean eliminarCapacitacion (int idCapacitacion);
    public boolean actualizarEstadoCapacitacion(int idCapacitacion);

}
