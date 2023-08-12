package com.example.modulo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Usuario {
    private int id;
    private int rut;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String correo_electronico;
    private int telefono;
    private String direccion;
    private int id_tipo_usuario;
    private String usuario_ingreso;
    private String password;
    private int id_cliente;
    private boolean estado;


}
