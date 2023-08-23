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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AsesoriaDaoImpl implements IAsesoria {
    @Override
    public boolean crearAsesoria(Asesoria asesoria) {
        Boolean creado = false;
        Statement objStatement = null;
        Connection objConnection = null;
        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("insert into asesoria(id, nombre_asesoria, id_tipo_riesgo, descripcion_asesoria, id_cliente_peticion, fecha_ingreso, estado) values (null," +
                    asesoria.getNombre_asesoria()+","
                    +asesoria.getId_tipo_riesgo()+","
                    +asesoria.getDescripcion_asesoria()+","
                    +asesoria.getId_cliente_peticion()+","
                    +asesoria.getFecha_ingreso()+","
                    +asesoria.isEstado()+
                    ")");
            creado = true;
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return creado;
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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while (objResultSet.next()){
                asesoria = new Asesoria(
                        objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getInt(3),
                        objResultSet.getString(4),
                        LocalDateTime.parse(objResultSet.getString(6), formatter),
                        objResultSet.getInt(5),
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
        Connection objConnection = null;
        Statement objStatement = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute(
                    "update asesorias set " +
                    "nombre_asesoria=" + asesoria.getNombre_asesoria() +
                    ", id_tipo_riesgo=" + asesoria.getId_tipo_riesgo() +
                    ", descripcion_asesoria=" + asesoria.getDescripcion_asesoria() +
                    ", id_cliente_peticion=" + asesoria.getId_cliente_peticion() +
                    ", fecha_ingreso=" + asesoria.getFecha_ingreso() +
                    ", estado=" + asesoria.isEstado() +
                    " where id=" + asesoria.getId()
            );

            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public boolean eliminarAsesoria(int idAsesoria) {
        boolean eliminar = false;
        Statement objStatement = null;
        Connection objConnection = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("delete from asesorias where id =" +idAsesoria);
            eliminar=true;

            objStatement.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eliminar;
    }

    @Override
    public boolean actualizarEstadoAsesoria(int idAsesoria) {
        Connection objConnection = null;
        Statement objStatement = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute(
                    "update asesorias set " +
                            "estado=" + true +
                            " where id=" + idAsesoria
            );

            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
