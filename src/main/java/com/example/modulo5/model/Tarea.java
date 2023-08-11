package com.example.modulo5.model;
import java.time.LocalDate;

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

    // Constructor
    public Tarea(int id, String nombre_tarea, String descripcion, String entregable,
                 LocalDate fecha_ingreso, LocalDate fecha_ejecucion, int id_estado,
                 int id_tipo_tarea, int id_asesoria) {
        this.id = id;
        this.nombre_tarea = nombre_tarea;
        this.descripcion = descripcion;
        this.entregable = entregable;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_ejecucion = fecha_ejecucion;
        this.id_estado = id_estado;
        this.id_tipo_tarea = id_tipo_tarea;
        this.id_asesoria = id_asesoria;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEntregable() {
        return entregable;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public LocalDate getFecha_ejecucion() {
        return fecha_ejecucion;
    }

    public int getId_estado() {
        return id_estado;
    }

    public int getId_tipo_tarea() {
        return id_tipo_tarea;
    }

    public int getId_asesoria() {
        return id_asesoria;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEntregable(String entregable) {
        this.entregable = entregable;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setFecha_ejecucion(LocalDate fecha_ejecucion) {
        this.fecha_ejecucion = fecha_ejecucion;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public void setId_tipo_tarea(int id_tipo_tarea) {
        this.id_tipo_tarea = id_tipo_tarea;
    }

    public void setId_asesoria(int id_asesoria) {
        this.id_asesoria = id_asesoria;
    }
}
