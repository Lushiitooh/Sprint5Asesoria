package com.example.modulo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int id;
    private int run;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String correoElectronico;
    private String telefono;
    private String direccion;
    private int idTipoUsuario;
    private String usuarioIngreso;
    private String password;
    private LocalDateTime fechaRegistro;
    private int idCliente;
    private boolean estado;
}
