package com.example.modulo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Capacitacion {
    private int id;
    private String nombre;
    private Double duracion;
    private String descripcion;
    private int estado;
    private int id_cliente;
}
