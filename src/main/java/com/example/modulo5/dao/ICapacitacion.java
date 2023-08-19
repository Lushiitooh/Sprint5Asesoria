package com.example.modulo5.dao;

import com.example.modulo5.model.Capacitacion;

import java.util.List;

public interface ICapacitacion {
    public Boolean crearCapacitacion(Capacitacion capacitacion);
    public List<Capacitacion> listarCapacitacion();
    public List<Capacitacion> listarCapacitacionUsuario(int idCliente);
    public Capacitacion actualizarCapacitacion(Capacitacion capacitacion);
    public boolean eliminarCapacitacion (int idCapacitacion);
    public boolean actualizarEstadoCapacitacion(int idCapacitacion);

}
