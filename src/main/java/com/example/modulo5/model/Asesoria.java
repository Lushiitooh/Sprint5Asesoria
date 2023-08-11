package com.example.modulo5.model;
import java.time.LocalDate;
import java.time.LocalTime;

public class Asesoria {
    private int id;
    private String nombre_asesoria;
    private int id_tipo_riesgo;
    private String descripcion_asesoria;
    private LocalDate fecha_ingreso;
    private int id_cliente_peticion;
    private int estado;

    // Constructor
    public Asesoria(int id, String nombre_asesoria, int id_tipo_riesgo, String descripcion_asesoria,
                    LocalDate fecha_ingreso, int id_cliente_peticion, int estado) {
        this.id = id;
        this.nombre_asesoria = nombre_asesoria;
        this.id_tipo_riesgo = id_tipo_riesgo;
        this.descripcion_asesoria = descripcion_asesoria;
        this.fecha_ingreso = fecha_ingreso;
        this.id_cliente_peticion = id_cliente_peticion;
        this.estado = estado;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre_asesoria() {
        return nombre_asesoria;
    }

    public int getId_tipo_riesgo() {
        return id_tipo_riesgo;
    }

    public String getDescripcion_asesoria() {
        return descripcion_asesoria;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public int getId_cliente_peticion() {
        return id_cliente_peticion;
    }

    public int getEstado() {
        return estado;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_asesoria(String nombre_asesoria) {
        this.nombre_asesoria = nombre_asesoria;
    }

    public void setId_tipo_riesgo(int id_tipo_riesgo) {
        this.id_tipo_riesgo = id_tipo_riesgo;
    }

    public void setDescripcion_asesoria(String descripcion_asesoria) {
        this.descripcion_asesoria = descripcion_asesoria;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public void setId_cliente_peticion(int id_cliente_peticion) {
        this.id_cliente_peticion = id_cliente_peticion;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}