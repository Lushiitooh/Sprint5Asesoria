package com.example.modulo5.dao.daoimpl;


import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.IAsesoria;
import com.example.modulo5.model.Asesoria;
import com.example.modulo5.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AsesoriaDaoImpl implements IAsesoria {
    @Override
    public Asesoria crearAsesoria(Asesoria asesoria) {
        return null;
    }

    @Override
    public List<Asesoria> listarAsesoria() {
        List<Asesoria> listaAsesorias = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Asesoria asesoria;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from asesorias");
            while (objResultSet.next()){
                asesoria = new Asesoria(
                        objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getInt(3),
                        objResultSet.getString(4),
                        LocalDateTime.parse(objResultSet.getString(5)),
                        objResultSet.getInt(6),
                        objResultSet.getBoolean(7));
                listaAsesorias.add(asesoria);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAsesorias;
    }

    @Override
    public List<Asesoria> listarAsesoriaCliente(int idCliente) {
        List<Asesoria> listaAsesorias = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Asesoria asesoria;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, nombre_asesoria, id_tipo_riesgo, descripcion_asesoria, id_cliente_peticion, fecha_ingreso, estado from asesorias inner join cliente_asesoria ca on asesorias.id = ca.id_asesoria where id_cliente =" + idCliente);
            while (objResultSet.next()){
                asesoria = new Asesoria(
                        objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getInt(3),
                        objResultSet.getString(4),
                        LocalDateTime.parse(objResultSet.getString(5)),
                        objResultSet.getInt(6),
                        objResultSet.getBoolean(7));
                listaAsesorias.add(asesoria);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAsesorias;
    }

    @Override
    public Asesoria actualizarAsesoria(Asesoria asesoria) {
        return null;
    }

    @Override
    public boolean eliminarAsesoria(int idAsesoria) {
        return false;
    }

    @Override
    public boolean actualizarEstadoAsesoria(int idAsesoria) {
        return false;
    }
}
