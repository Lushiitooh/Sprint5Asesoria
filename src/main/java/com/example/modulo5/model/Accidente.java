package com.example.modulo5.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public  class Accidente {
 private int id;
 private LocalDate fechaAccidente;
 private LocalTime horaAccidente;
 private int idTrabajador;
 private String lugarAccidente;
 private String descripcionAccidente;
 private String tipoAccidente;
 private int idCliente;
 private LocalDate fechaIngreso;

}
