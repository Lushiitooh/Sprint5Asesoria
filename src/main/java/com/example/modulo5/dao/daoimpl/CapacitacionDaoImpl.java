package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.ICapacitacion;
import com.example.modulo5.model.Capacitacion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionDaoImpl implements ICapacitacion {
    @Override
    public Boolean crearCapacitacion(Capacitacion capacitacion) {
        Boolean creado = false;
        Statement objStatement = null;
        Connection objConnection = null;
        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("insert into capacitaciones(id, nombre, duracion, descripcion, fecha_ingreso, estado) values (null,"
                    +capacitacion.getNombre()+","
                    +capacitacion.getDuracion()+","
                    +capacitacion.getDescripcion()+","
                    +capacitacion.getFechaIngreso()+","
                    +capacitacion.getEstadoCapacitacion()+
            ")");
            creado = true;
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return creado;
    }

    @Override
    public List<Capacitacion> listarCapacitacion() {
        List<Capacitacion> listaCapacitaciones = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Capacitacion capacitacion;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, nombre, duracion, descripcion, fecha_ingreso, estado from capacitaciones");
            while (objResultSet.next()){
                capacitacion = new Capacitacion(
                        objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getDouble(3),
                        objResultSet.getString(4),
                        LocalDateTime.parse(objResultSet.getString(5)),
                        objResultSet.getBoolean(6));

                listaCapacitaciones.add(capacitacion);

            }
            objResultSet.close();
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCapacitaciones;
    }

    @Override
    public List<Capacitacion> listarCapacitacionUsuario(int idCliente) {
        List<Capacitacion> listaCapacitaciones = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Capacitacion capacitacion;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, nombre, duracion, descripcion, fecha_ingreso, estado from clilente_capacitacion inner join capacitaciones c on clilente_capacitacion.id_capacitacion = c.id where id_cliente ="+idCliente);
            while (objResultSet.next()){
                capacitacion = new Capacitacion(
                        objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getDouble(3),
                        objResultSet.getString(4),
                        LocalDateTime.parse(objResultSet.getString(5)),
                        objResultSet.getBoolean(6));

                listaCapacitaciones.add(capacitacion);

            }
            objResultSet.close();
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCapacitaciones;
    }

    @Override
    public Capacitacion actualizarCapacitacion(Capacitacion capacitacion) {
        return null;
    }

    @Override
    public boolean eliminarCapacitacion(int idCapacitacion) {
        boolean eliminar = false;
        Statement objStatement = null;
        Connection objConnection = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("delete from capacitaciones where id =" +idCapacitacion);
            eliminar=true;

            objStatement.close();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eliminar;
    }

    @Override
    public boolean actualizarEstadoCapacitacion(int idCapacitacion) {


        return false;
    }
}
