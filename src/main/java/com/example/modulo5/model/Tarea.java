package com.example.modulo5.model;
import java.time.LocalDate;
import lombok.Data;

@Data
public class Tarea {
    private int id;
    private String nombre_tarea;
    private String descripcion;
    private String entregable;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_ejecucion;
    private int id_estado;
    private int id_tipo_tarea;
    private int id_asesoria;
}
