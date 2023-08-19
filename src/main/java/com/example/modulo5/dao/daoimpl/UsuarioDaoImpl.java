package com.example.modulo5.dao.daoimpl;


import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.IUsuario;
import com.example.modulo5.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoImpl implements IUsuario {

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Usuario usuario;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, rut, nombres, apellido1, apellido2, correo_electronico, telefono, direccion, id_tipo_usuario, usuario_ingreso, password, fecha_registro, id_cliente, estado_usuario from usuarios");
            while (objResultSet.next()){
                usuario = new Usuario(objResultSet.getInt(1),
                        objResultSet.getInt(2),
                        objResultSet.getString(3),
                        objResultSet.getString(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        objResultSet.getString(10),
                        objResultSet.getString(11),
                        LocalDateTime.parse(objResultSet.getString(12)),
                        objResultSet.getInt(13),
                        objResultSet.getBoolean(14));
                listaUsuarios.add(usuario);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    @Override
    public List<Usuario> listarUsuarioPorTipo(int tipoUsuario) {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Usuario usuario;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, rut, nombres, apellido1, apellido2, correo_electronico, telefono, direccion, id_tipo_usuario, usuario_ingreso, password, fecha_registro, id_cliente, estado_usuario from usuarios where id_tipo_usuario ="+tipoUsuario);
            while (objResultSet.next()){
                usuario = new Usuario(objResultSet.getInt(1),
                        objResultSet.getInt(2),
                        objResultSet.getString(3),
                        objResultSet.getString(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        objResultSet.getString(10),
                        objResultSet.getString(11),
                        LocalDateTime.parse(objResultSet.getString(12)),
                        objResultSet.getInt(13),
                        objResultSet.getBoolean(14));
                listaUsuarios.add(usuario);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaUsuarios;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public boolean eliminarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean actualizarEstadoUsuario(Usuario usuario) {
        return false;
    }
}
