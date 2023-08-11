package com.example.modulo5.dao;

import com.example.modulo5.model.Capacitacion;

import java.util.List;

public interface ICapacitacion {
    public Capacitacion crearCapacitacion(Capacitacion capacitacion);
    public List<Capacitacion> listarCapacitacion();
    public List<Capacitacion> listarCapacitacionCliente(int idCliente);
    public Capacitacion actualizarCapacitacion(Capacitacion capacitacion);
    public boolean eliminarCapacitacion (int idCapacitacion);

}
