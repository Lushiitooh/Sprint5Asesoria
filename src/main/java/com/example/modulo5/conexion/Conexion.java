package com.example.modulo5.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
<<<<<<< HEAD
   private static Connection conexion = null;
   private Conexion() {
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgas_bd", "root", "VamosConTodo1234&");

       } catch (ClassNotFoundException exception) {
           exception.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    public static Connection getConexion(){
       if(conexion == null){
           new Conexion();
       }
       return conexion;

=======
    private static Connection conexion = null;
>>>>>>> mechavaa

    // Constructor privado para asegurarse de que sólo se pueda acceder desde dentro de la clase
    private Conexion() {
        try {
            // Cargando el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Estableciendo la conexión
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sgas_bd", "java", "admin");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();  // Esto se podría manejar mejor con un logger
        } catch (SQLException e) {
            e.printStackTrace();  // Esto se podría manejar mejor con un logger
        }
    }

    // Método público estático para obtener la conexión
    public static Connection getConexion() {
        try {
            // Si la conexión es nula o está cerrada, crea una nueva conexión
            if (conexion == null || conexion.isClosed()) {
                new Conexion();
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Esto se podría manejar mejor con un logger
        }
        return conexion;
    }
}

