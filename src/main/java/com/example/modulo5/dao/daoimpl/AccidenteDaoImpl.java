package com.example.modulo5.dao.daoimpl;

import com.example.modulo5.conexion.Conexion;
import com.example.modulo5.dao.IAccidente;
import com.example.modulo5.model.Accidente;
import java.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
public class AccidenteDaoImpl implements IAccidente {

    @Override
    public Accidente crearAccidente(Accidente accidente) {
        String sql = "INSERT INTO accidentes (fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente) VALUES ('"
                + accidente.getFechaAccidente() + "', '"
                + accidente.getHoraAccidente() + "', "
                + accidente.getIdTrabajador() + ", '"
                + accidente.getLugarAccidente() + "', '"
                + accidente.getDescripcionAccidente() + "', '"
                + accidente.getTipoAccidente() + "', "
                + accidente.getIdCliente() + ")";

        Connection objConnection = null;
        Statement objStatement = null;
        ResultSet generatedKeys = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();

            int affectedRows = objStatement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

            if (affectedRows == 0) {
                throw new SQLException("Failed to create accidente, no rows affected.");
            }

            generatedKeys = objStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                accidente.setId(idGenerado);
            } else {
                throw new SQLException("Failed to create accidente, no ID obtained.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (objStatement != null) objStatement.close();
                if (objConnection != null) objConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accidente;
    }

    private List<Accidente> listarAccidentesPorConsulta(String sql) {
        List<Accidente> listaAccidentes = new ArrayList<>();
        Connection objConnection = null;
        Statement objStatement = null;
        ResultSet objResultSet = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objResultSet = objStatement.executeQuery(sql);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            while (objResultSet.next()) {
                Accidente accidente = new Accidente(
                        objResultSet.getInt(1),
                        objResultSet.getObject(2, LocalDate.class),
                        objResultSet.getObject(3, LocalTime.class),
                        objResultSet.getInt(4),
                        objResultSet.getString(5),
                        objResultSet.getString(6),
                        objResultSet.getString(7),
                        objResultSet.getString(8),
                        objResultSet.getInt(9),
                        objResultSet.getString(10),
                        LocalDateTime.parse(objResultSet.getString(11), formatter).toLocalDate()
                );
                listaAccidentes.add(accidente);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (objResultSet != null) objResultSet.close();
                if (objStatement != null) objStatement.close();
                if (objConnection != null) objConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listaAccidentes;
    }

    @Override
    public List<Accidente> listarAccidente() {
        String sql = "SELECT a.id, "
                + "a.fecha_accidente, "
                + "a.hora_accidente, "
                + "a.id_trabajador, "
                + "CONCAT(t.rut, ' ', t.nombres, ' ', t.apellido1, ' ', t.apellido2) AS nombreTrabajador, "
                + "a.lugar_accidente, "
                + "a.descripcion_accidente, "
                + "a.tipo_accidente, "
                + "a.id_cliente, "
                + "c.razon_social AS nombreCliente, "
                + "a.fecha_ingreso "
                + "FROM accidentes a "
                + "JOIN trabajadores t ON a.id_trabajador = t.id "
                + "JOIN clientes c ON a.id_cliente = c.id";
        return listarAccidentesPorConsulta(sql);
    }



    @Override
    public List<Accidente> listarAccidente(int idAccidente) {
        String sql = "select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes where id =" + idAccidente;
        return listarAccidentesPorConsulta(sql);
    }

    @Override
    public List<Accidente> listarAccidenteCliente(int idCliente) {
        String sql = "select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes where id_cliente =" + idCliente;
        return listarAccidentesPorConsulta(sql);
    }

    @Override
    public List<Accidente> listarAccidenteTrabajador(int idTrabajador) {
        String sql = "select id, fecha_accidente, hora_accidente, id_trabajador, lugar_accidente, descripcion_accidente, tipo_accidente, id_cliente, fecha_ingreso from accidentes where id_trabajador =" + idTrabajador;
        return listarAccidentesPorConsulta(sql);
    }

    @Override
    public boolean eliminarAccidente(int idAccidente) {
        return false;
    }

    @Override
    public boolean actualizarEstadoAccidente(int idAccidente) {
        return false;
    }

    @Override
    public void editarAccidente(Accidente accidente) {
        String sql = "UPDATE accidentes SET " +
                "fecha_accidente = '" + accidente.getFechaAccidente() + "', " +
                "hora_accidente = '" + accidente.getHoraAccidente() + "', " +
                "id_trabajador = " + accidente.getIdTrabajador() + ", " +
                "lugar_accidente = '" + accidente.getLugarAccidente() + "', " +
                "descripcion_accidente = '" + accidente.getDescripcionAccidente() + "', " +
                "tipo_accidente = '" + accidente.getTipoAccidente() + "', " +
                "id_cliente = " + accidente.getIdCliente() + " " +
                "WHERE id = " + accidente.getId();

        Connection objConnection = null;
        Statement objStatement = null;

        try {
            objConnection = Conexion.getConexion();
            objStatement = objConnection.createStatement();
            objStatement.executeUpdate(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (objStatement != null) objStatement.close();
                if (objConnection != null) objConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
