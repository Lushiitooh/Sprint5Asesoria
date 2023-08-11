package com.example.modulo5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trabajador {
    private int id,idCliente;
    private String rut,nombres, apellido1,apellido2,area,correoElectronico,cargo;

}
