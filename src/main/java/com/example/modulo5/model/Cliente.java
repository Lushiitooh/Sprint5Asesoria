package com.example.modulo5.model;

import lombok.*;

import java.time.LocalDate;


@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario{

    private int id;
    private int rut;
    private String razon_social;
    private String nombre_contacto;
    private String direccion;
    private int telefono;
    private String correo_electronico;
    private LocalDate fechaingreso;



}
