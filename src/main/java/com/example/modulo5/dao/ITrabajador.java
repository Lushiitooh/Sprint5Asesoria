package com.example.modulo5.dao;

import com.example.modulo5.model.Trabajador;

import java.util.List;

public interface ITrabajador {
    public Boolean crearTrabajador(Trabajador trabajador);
    public List<Trabajador> listarTrabajador();
    public List<Trabajador> listarTrabajadorId(int idTrabajador);
    public List<Trabajador> listarTrabajadorIdCliente(int idCliente);
    public List<Trabajador> listarTrabajadorRut(String rutTrabajador);
    public Trabajador actualizarTrabajador(Trabajador trabajador);
    public boolean eliminarTrabajador(int idTrabajador);
}
