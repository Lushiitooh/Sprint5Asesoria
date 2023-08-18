package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.ITarea;
import com.example.modulo5.model.Tarea;
import com.example.modulo5.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TareaDaoImpl implements ITarea {

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return null;
    }

    @Override
    public List<Tarea> listarTarea() {
        List<Tarea> listatareas = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Tarea tarea;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from tareas");
            while (objResultSet.next()){
                tarea = new Tarea(objResultSet.getInt(1), //id
                        objResultSet.getString(2), // nombre tarea
                        objResultSet.getString(3), // descripcion
                        objResultSet.getString(4), // entregable
                        LocalDate.parse(objResultSet.getString(9)), //fecha de ingreso
                        LocalDate.parse(objResultSet.getString(5)), //fecha de ejecucion
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
    public List<Tarea> listarTareasTipos(int idTiposTareas) {
        List<Tarea> listatareas = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Tarea tarea;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from tareas where id_tipo_tarea ="+idTiposTareas);
            while (objResultSet.next()){
                tarea = new Tarea(objResultSet.getInt(1), //id
                        objResultSet.getString(2), // nombre tarea
                        objResultSet.getString(3), // descripcion
                        objResultSet.getString(4), // entregable
                        LocalDate.parse(objResultSet.getString(9)), //fecha de ingreso
                        LocalDate.parse(objResultSet.getString(5)), //fecha de ejecucion
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
            objResultSet = objStatement.executeQuery("select * from tareas where id_asesoria ="+idAsesoria);
            while (objResultSet.next()){
                tarea = new Tarea(objResultSet.getInt(1), //id
                        objResultSet.getString(2), // nombre tarea
                        objResultSet.getString(3), // descripcion
                        objResultSet.getString(4), // entregable
                        LocalDate.parse(objResultSet.getString(9)), //fecha de ingreso
                        LocalDate.parse(objResultSet.getString(5)), //fecha de ejecucion
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
    public Tarea actualizarTarea(Tarea tarea) {
        return null;
    }

    @Override
    public boolean eliminarTarea(int idTarea) {
        return false;
    }
}
