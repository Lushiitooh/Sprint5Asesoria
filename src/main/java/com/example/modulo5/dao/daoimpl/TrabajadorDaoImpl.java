package com.example.modulo5.dao.daoimpl;


import com.example.modulo5.dao.ITrabajador;
import com.example.modulo5.model.Trabajador;
import com.example.modulo5.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDaoImpl implements ITrabajador {

    @Override
    public Boolean crearTrabajador(Trabajador trabajador) {
        Boolean creado = false;
        Statement objStatement = null;
        Connection objConnection = null;
        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("insert into trabajadores(id, rut, nombres, apellido1, apellido2, area, correo_electronico, cargo, id_cliente, fecha_ingreso) values (null,"
                                         +trabajador.getRut()+","
                                         +trabajador.getNombres()+","
                                         +trabajador.getApellido1()+","
                                         +trabajador.getApellido2()+","
                                         +trabajador.getArea()+","
                                         +trabajador.getCorreoElectronico()+","
                                         +trabajador.getCargo()+","
                                         +trabajador.getIdCliente()+","
                                         +trabajador.getFechaIngreso()+
                                         ")");
            creado = true;
            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return creado;
    }

    @Override
    public List<Trabajador> listarTrabajador() {
        List<Trabajador> listaTrabajadores = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Trabajador trabajador;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from trabajadores");
            while (objResultSet.next()) {
                trabajador = new Trabajador(objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getString(3),
                        objResultSet.getString(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        LocalDateTime.parse(objResultSet.getString(10)));
                listaTrabajadores.add(trabajador);
            }
            objResultSet.close();
            objStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTrabajadores;
    }

    @Override
    public List<Trabajador> listarTrabajadorId(int idTrabajador) {
        List<Trabajador> listaTrabajadoresId = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Trabajador trabajadorId;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select * from trabajadores where id =" + idTrabajador);
            while (objResultSet.next()) {
                trabajadorId = new Trabajador(objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getString(3),
                        objResultSet.getString(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        LocalDateTime.parse(objResultSet.getString(10)));
                listaTrabajadoresId.add(trabajadorId);
            }
            objResultSet.close();
            objStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTrabajadoresId;
    }

    @Override
    public List<Trabajador> listarTrabajadorIdCliente(int idCliente) {
        List<Trabajador> listaTrabajadoresIdCliente = new ArrayList<>();
        Statement objStatement = null;
        Connection objConnection = null;
        ResultSet objResultSet = null;
        Trabajador trabajadorIdCliente;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery("select id, rut, nombres, apellido1, apellido2, area, correo_electronico, cargo, id_cliente, fecha_ingreso from trabajadores where id =" + idCliente);
            while (objResultSet.next()) {
                trabajadorIdCliente = new Trabajador(objResultSet.getInt(1),
                        objResultSet.getString(2),
                        objResultSet.getString(3),
                        objResultSet.getString(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        LocalDateTime.parse(objResultSet.getString(10)));
                listaTrabajadoresIdCliente.add(trabajadorIdCliente);

            }
            objResultSet.close();
            objStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaTrabajadoresIdCliente;
    }

    @Override
    public List<Trabajador> listarTrabajadorRut(String rutTrabajador) {
            List<Trabajador> listaTrabajadorRut = new ArrayList<>();
            Statement objStatement = null;
            Connection objConnection = null;
            ResultSet objResultSet = null;
            Trabajador trabajadorRut;

            try{
                objConnection = Conexion.getConexion();
                objStatement = objConnection.createStatement();
                objResultSet = objStatement.executeQuery("select id, rut, nombres, apellido1, apellido2, area, correo_electronico, cargo, id_cliente, fecha_ingreso from trabajadores where rut =" + rutTrabajador);
                while (objResultSet.next()) {
                    trabajadorRut = new Trabajador(objResultSet.getInt(1),
                            objResultSet.getString(2),
                            objResultSet.getString(3),
                            objResultSet.getString(4),
                            objResultSet.getString(5),
                            objResultSet.getString(6),
                            objResultSet.getString(7),
                            objResultSet.getString(8),
                            objResultSet.getInt(9),
                            LocalDateTime.parse(objResultSet.getString(10)));
                    listaTrabajadorRut.add(trabajadorRut);

                }
                objResultSet.close();
                objStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            return listaTrabajadorRut;
    }


    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajador) {
        return null;
    }

    @Override
    public boolean eliminarTrabajador(int idTrabajador) {

        boolean eliminado = false;
        Statement objStatement = null;
        Connection objConnection = null;

        try{
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.execute("delete from trabajador where id ="+idTrabajador);
            eliminado=true;

            objStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return eliminado;

    }
}
