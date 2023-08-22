package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.ITarea;
import com.example.modulo5.model.Tarea;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TareaDaoImpl implements ITarea {

    @Override
    public boolean crearTarea(Tarea tarea) {
        Boolean creado = false;
        Statement objStatement = null;
        Connection objConnection = null;
        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("insert into tareas(nombre_tarea,descripcion,entregable,fecha_ejecucion,id_estado,id_tipo_tarea,id_asesoria,fecha_ingreso) values ("
                    +tarea.getNombre_tarea()+","
                    +tarea.getDescripcion()+","
                    +tarea.getEntregable()+","
                    +tarea.getFecha_ejecucion()+","
                    +tarea.getId_estado()+","
                    +tarea.getId_tipo_tarea()+","
                    +tarea.getId_asesoria()+","
                    +tarea.getFecha_ingreso()+
                    ")");
            creado = true;
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return creado;
    }

    @Override
    public List<Tarea> listarTarea() {
        List<Tarea> listatareas = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Tarea tarea;

        try {
            Connection objConnection = Conexion.getConexion();
            Statement objStatement = objConnection.createStatement();
            ResultSet objResultSet = objStatement.executeQuery("select id, nombre_tarea, descripcion, entregable, fecha_ejecucion, id_estado, id_tipo_tarea, id_asesoria, fecha_ingreso from tareas");
            while (objResultSet.next()){
                tarea = new Tarea(objResultSet.getInt(1), //id
                        objResultSet.getString(2), // nombre tarea
                        objResultSet.getString(3), // descripcion
                        objResultSet.getString(4), // entregable
                        LocalDate.parse(objResultSet.getString(5), formatter2), //fecha de ejecucion
                        LocalDateTime.parse(objResultSet.getString("fecha_ingreso"),formatter), //fecha de ingreso
                        objResultSet.getInt("id_estado"), //id estado
                        objResultSet.getInt(7), //id tipo tarea
                        objResultSet.getInt(8)//id asesoria

                        );
                listatareas.add(tarea);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listatareas;
    }

    @Override
    public List<Tarea> listarTareasTipos(int idTiposTareas) {
        List<Tarea> listatareas = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Tarea tarea;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, nombre_tarea, descripcion, entregable, fecha_ejecucion, id_estado, id_tipo_tarea, id_asesoria, fecha_ingreso from tareas where id_tipo_tarea ="+idTiposTareas);
            while (objResultSet.next()){
                tarea = new Tarea(objResultSet.getInt(1), //id
                        objResultSet.getString(2), // nombre tarea
                        objResultSet.getString(3), // descripcion
                        objResultSet.getString(4), // entregable
                        LocalDate.parse(objResultSet.getString(9)), //fecha de ingreso
                        LocalDateTime.parse(objResultSet.getString(5)), //fecha de ejecucion
                        objResultSet.getInt(6), //id estado
                        objResultSet.getInt(7), //id tipo tarea
                        objResultSet.getInt(8) //id asesoria
                );
                listatareas.add(tarea);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listatareas;
    }

    @Override
    public List<Tarea> listarTareasAsesoria(int idAsesoria) {
        List<Tarea> listatareas = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Tarea tarea;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, nombre_tarea, descripcion, entregable, fecha_ejecucion, id_estado, id_tipo_tarea, id_asesoria, fecha_ingreso from tareas where id_asesoria ="+idAsesoria);
            while (objResultSet.next()){
                tarea = new Tarea(objResultSet.getInt(1), //id
                        objResultSet.getString(2), // nombre tarea
                        objResultSet.getString(3), // descripcion
                        objResultSet.getString(4), // entregable
                        LocalDate.parse(objResultSet.getString(9)), //fecha de ingreso
                        LocalDateTime.parse(objResultSet.getString(5)), //fecha de ejecucion
                        objResultSet.getInt(6), //id estado
                        objResultSet.getInt(7), //id tipo tarea
                        objResultSet.getInt(8) //id asesoria
                );
                listatareas.add(tarea);
            }
            objResultSet.close();
            objStatement.close();
            //objConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listatareas;
    }

    @Override
    public boolean actualizarTarea(Tarea tarea) {

        Boolean actualizar = false;
        Statement objStatement = null;
        Connection objConnection = null;
        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("update tareas set " +
                    "nombre_tarea="+tarea.getNombre_tarea()+","+
                    "descripcion="+tarea.getDescripcion()+","+
                    "entregable="+tarea.getEntregable()+","+
                    "fecha_ejecucion="+tarea.getFecha_ejecucion()+","+
                    "id_estado="+tarea.getId_estado()+","+
                    "id_tipo_tarea="+tarea.getId_tipo_tarea()+","+
                    "id_asesoria="+tarea.getId_asesoria()+","+
                    "fecha_ingreso ="+tarea.getFecha_ingreso()+"where id="+tarea.getId());

            actualizar = true;
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return actualizar;
    }

    @Override
    public boolean eliminarTarea(int idTarea) {
        boolean eliminado = false;
        Statement objStatement = null;
        Connection objConnection = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("delete from tareas where id ="+idTarea);
            eliminado=true;

            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eliminado;

    }

}
