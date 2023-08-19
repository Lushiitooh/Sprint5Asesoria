package com.example.modulo5.model;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Asesoria {
    private int id;
    private String nombre_asesoria;
    private int id_tipo_riesgo;
    private String descripcion_asesoria;
    private LocalDateTime fecha_ingreso;
    private int id_cliente_peticion;
    private boolean estado;
}