package com.example.modulo5.dao;
import com.example.modulo5.model.Accidente;
import java.util.List;

public interface IAccidente {
    public Accidente crearAccidente(Accidente accidente);
    public List<Accidente> listarAccidente();
    public List<Accidente> listarAccidente(int idAccidente);
    public List<Accidente> listarAccidenteCliente(int idCliente);
    public List<Accidente> listarAccidenteTrabajador(int idTrabajador);
    public Accidente actualizarAccidente(Accidente accidente);
    public boolean eliminarAccidente (int idAccidente);
    public boolean actualizarEstadoAccidente (int idAccidente);
}