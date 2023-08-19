package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.IAccidente;
import com.example.modulo5.model.Accidente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccidenteDaoImpl implements IAccidente {

    @Override
    public Accidente crearAccidente(Accidente accidente) {
        return null;
    }

    @Override
    public List<Accidente> listarAccidente() {
        List<Accidente> listaAccidentes = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Accidente accidente = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes");
            while (objResultSet.next()){
                accidente = new Accidente(objResultSet.getInt(1),
                        LocalDate.parse(objResultSet.getString(2)),
                        LocalTime.parse(objResultSet.getString(3)),
                        objResultSet.getInt(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getInt(8),
                        LocalDate.parse(objResultSet.getString(9)));
                listaAccidentes.add(accidente);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAccidentes;
    }

    @Override
    public List<Accidente> listarAccidente(int idAccidente) {
        List<Accidente> listaAccidentes = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Accidente accidente = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes where id ="+idAccidente);
            while (objResultSet.next()) {
                accidente = new Accidente(objResultSet.getInt(1),
                        LocalDate.parse(objResultSet.getString(2)),
                        LocalTime.parse(objResultSet.getString(3)),
                        objResultSet.getInt(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getInt(8),
                        LocalDate.parse(objResultSet.getString(9)));
                listaAccidentes.add(accidente);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAccidentes;
    }

    @Override
    public List<Accidente> listarAccidenteCliente(int idCliente) {
        List<Accidente> listaAccidentes = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Accidente accidente = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes where id_cliente ="+idCliente);
            while (objResultSet.next()) {
                accidente = new Accidente(objResultSet.getInt(1),
                        LocalDate.parse(objResultSet.getString(2)),
                        LocalTime.parse(objResultSet.getString(3)),
                        objResultSet.getInt(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getInt(8),
                        LocalDate.parse(objResultSet.getString(9)));
                listaAccidentes.add(accidente);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAccidentes;
    }

    @Override
    public List<Accidente> listarAccidenteTrabajador(int idTrabajador) {
        List<Accidente> listaAccidentes = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Accidente accidente = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes where id_trabajador ="+idTrabajador);
            while (objResultSet.next()) {
                accidente = new Accidente(objResultSet.getInt(1),
                        LocalDate.parse(objResultSet.getString(2)),
                        LocalTime.parse(objResultSet.getString(3)),
                        objResultSet.getInt(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getInt(8),
                        LocalDate.parse(objResultSet.getString(9)));
                listaAccidentes.add(accidente);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAccidentes;
    }

    @Override
    public Accidente actualizarAccidente(Accidente accidente) {
        return null;
    }

    @Override
    public boolean eliminarAccidente(int idAccidente) {
        return false;
    }

    @Override
    public boolean actualizarEstadoAccidente(int idAccidente) {
        return false;
    }
}
