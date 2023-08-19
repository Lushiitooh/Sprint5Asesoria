package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.ILogin;
import com.example.modulo5.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class LoginDaoImpl implements ILogin {
    @Override
    public Usuario usuarioLogin(int run) {
        Usuario usuarioLogeado = new Usuario();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, rut, nombres, apellido1, apellido2, correo_electronico, telefono, direccion, id_tipo_usuario, usuario_ingreso, password, fecha_registro, id_cliente, estado_usuario from sgas_bd.usuarios where rut ="+run);

            if(objResultSet.next()) {
                usuarioLogeado = new Usuario(objResultSet.getInt("id"),
                        objResultSet.getInt(2),
                        objResultSet.getString("nombres"),
                        objResultSet.getString("apellido1"),
                        objResultSet.getString("apellido2"),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        objResultSet.getString(10),
                        objResultSet.getString("password"),
                        LocalDateTime.parse(objResultSet.getString(12)),
                        objResultSet.getInt(13),
                        objResultSet.getBoolean(14)
                );
            }
            System.out.println(usuarioLogeado);
        }catch(SQLException e) {
            System.out.println("Error al consultar la BD");
            e.printStackTrace();
        }
        return usuarioLogeado;
    }
}
