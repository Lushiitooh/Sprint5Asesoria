package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.ICliente;
import com.example.modulo5.model.Cliente;
import com.example.modulo5.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ICliente {


    @Override
    public boolean crearCliente(Cliente cliente) {
        Boolean creado = false;
        Statement objStatement = null;
        Connection objConnection = null;
        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("insert into clientes(id,rut,razon_social,nombre_contacto,direccion,telefono,correo_electronico,fecha_ingreso) values (null," +
                    cliente.getRut()+","
                    +cliente.getRazon_social()+","
                    +cliente.getNombre_contacto()+","
                    +cliente.getDireccion()+","
                    +cliente.getTelefono()+","
                    +cliente.getCorreo_electronico()+","
                    +cliente.getFechaingreso()+
                    ")");
            creado = true;
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return creado;
    }

    @Override
    public List<Cliente> listarCliente() {

        List<Cliente> listaCliente = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Cliente cliente = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from clientes");

            while (objResultSet.next()){
                cliente = new Cliente(objResultSet.getInt(1),
                objResultSet.getInt(2),
                objResultSet.getString(3),
                objResultSet.getString(4),
                objResultSet.getString(5),
                objResultSet.getInt(6),
                objResultSet.getString(7),
                LocalDateTime.parse(objResultSet.getString(8)),
                objResultSet.getBoolean(9));

                listaCliente.add(cliente);
            }
            objResultSet.close();
            objStatement.close();


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaCliente;
    }

    @Override
    public Cliente listarClienteId(int idCliente) {
        Cliente cliente;
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, rut, razon_social, nombre_contacto, direccion, telefono, correo_electronico, fecha_ingreso, estado from clientes where id ="+idCliente);
            while (objResultSet.next()){
                cliente = new Cliente(objResultSet.getInt(1),
                        objResultSet.getInt(2),
                        objResultSet.getString(3),
                        objResultSet.getString(4),
                        objResultSet.getString(5),
                        objResultSet.getInt(6),
                        objResultSet.getString(7),
                        LocalDateTime.parse(objResultSet.getString(8)),
                        objResultSet.getBoolean(9));
                objResultSet.close();
                objStatement.close();
                return cliente;
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return null;
    }





    @Override
    public Cliente actualizarCliente(Cliente cliente) {
        return null;
    }

    @Override
    public boolean eliminarCliente(int idCliente) {

        boolean eliminado = false;
        Statement objStatement = null;
        Connection objConnection = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("delete from clientes where id ="+idCliente);
            eliminado=true;

            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eliminado;

    }


}
