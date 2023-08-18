package com.example.modulo5.dao;

import com.example.modulo5.model.Cliente;

import java.util.List;

public interface ICliente {
    public boolean crearCliente(Cliente cliente);
    public List<Cliente> listarCliente();
    public  Cliente listarClienteId(int idCliente);
    public Cliente actualizarCliente(Cliente cliente);
    public boolean eliminarCliente(int idCliente);
}
