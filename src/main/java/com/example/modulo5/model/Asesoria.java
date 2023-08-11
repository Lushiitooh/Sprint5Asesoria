package com.example.modulo5.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Asesoria {
    private String nombreAsesoria;
    private int idTipoRiesgo;
    private int rutCliente;
    private LocalDate dia;
    private LocalTime hora;
    private String lugar;
    private int duracionMinutos;
    private int cantAsistentes;

    // Constructor
    public  void Nombre_Asesoria(String nombreAsesoria, int idTipoRiesgo, int rutCliente,
                           LocalDate dia, LocalTime hora, String lugar,
                           int duracionMinutos, int cantAsistentes) {
        this.nombreAsesoria = nombreAsesoria;
        this.idTipoRiesgo = idTipoRiesgo;
        this.rutCliente = rutCliente;
        this.dia = dia;
        this.hora = hora;
        this.lugar = lugar;
        this.duracionMinutos = duracionMinutos;
        this.cantAsistentes = cantAsistentes;
    }

    public void MostrarDetalles() {
        System.out.println("La capacitación será en " + lugar +
                " a las " + hora + " del día " + dia +
                ", y durará " + duracionMinutos + " minutos.");
    }
}