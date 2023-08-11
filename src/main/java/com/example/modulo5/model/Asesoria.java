package com.example.modulo5.model;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
public class Asesoria {
    private int id;
    private String nombre_asesoria;
    private int id_tipo_riesgo;
    private String descripcion_asesoria;
    private LocalDate fecha_ingreso;
    private int id_cliente_peticion;
    private int estado;
}