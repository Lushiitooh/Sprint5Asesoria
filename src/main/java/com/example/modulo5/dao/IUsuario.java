package com.example.modulo5.dao;

import com.example.modulo5.model.Usuario;

import java.util.List;

public interface IUsuario {

    public boolean crearUsuario(Usuario usuario);
    public List<Usuario> listarUsuarios();
    public List<Usuario> listarUsuarioPorTipo(int tipoUsuario);
    public Usuario actualizarUsuario(Usuario usuario);
    public boolean eliminarUsuario(int idUsuario);
    public boolean actualizarEstadoUsuario(Usuario usuario);
}
