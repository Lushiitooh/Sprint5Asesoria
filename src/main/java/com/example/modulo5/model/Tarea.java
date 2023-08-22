package com.example.modulo5.model;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tarea {
    private int id;
    private String nombre_tarea;
    private String descripcion;
    private String entregable;
    private LocalDate fecha_ingreso;
    private LocalDateTime fecha_ejecucion;
    private int id_estado;
    private int id_tipo_tarea;
    private int id_asesoria;
}
