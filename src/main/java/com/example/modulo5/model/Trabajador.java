package com.example.modulo5.model;

import jakarta.ejb.Local;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador {
    private int id;
    private String rut;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String area;
    private String correoElectronico;
    private String cargo;
    private int idCliente;
    private LocalDateTime fechaIngreso;


}
