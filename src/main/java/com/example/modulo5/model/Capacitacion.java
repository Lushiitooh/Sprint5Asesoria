package com.example.modulo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Capacitacion {
    private int id;
    private String nombre;
    private Double duracion;
    private String descripcion;
    private LocalDateTime fechaIngreso;
    private Boolean estadoCapacitacion;
}
