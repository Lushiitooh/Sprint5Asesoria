package com.example.modulo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Trabajador {
    private int id;
    private int idCliente;
    private String rut;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private String area;
    private String correoElectronico;
    private String cargo;

}
