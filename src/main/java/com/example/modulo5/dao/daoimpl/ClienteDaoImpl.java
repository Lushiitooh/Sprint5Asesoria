package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.ICliente;
import com.example.modulo5.model.Cliente;
import com.example.modulo5.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ICliente {


    @Override
    public Cliente crearCliente(Cliente cliente) {
        return null;
    }

    @Override
    public List<Cliente> listarCliente() {

        List<Cliente> listaCliente = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Cliente cliente;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from clientes");

            while (objResultSet.next()){
                cliente = new Cliente(objResultSet.getInt(1)
                );
                listaCliente.add(cliente);
            }

        }




        catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCliente;
    }

    @Override
    public Cliente listarClienteId(int idCliente) {
        return null;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public boolean eliminarCliente(int idCliente) {
        return false;
    }
}
