package com.example.modulo5.model;

import lombok.*;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente{

    private int id;
    private int rut;
    private String razon_social;
    private String nombre_contacto;
    private String direccion;
    private int telefono;
    private String correo_electronico;
    private LocalDateTime fechaingreso;
    private boolean estado;

}
