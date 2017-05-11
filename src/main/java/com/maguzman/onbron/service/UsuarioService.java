package com.maguzman.onbron.service;

import com.maguzman.onbron.beans.Usuario;

import java.util.List;

/**
 * Created by maguzman on 11/05/2017.
 */
public interface UsuarioService {
    Usuario buscarPorClave(Integer idUsuario);
    Usuario buscarPorCorreo(String correo);
    List<Usuario> buscarTodos();
    void salvar(Usuario usuario);
    void borrar(Integer idUsuario);
    void borrarPorCorreo(String correo);
    Usuario actualizar(Usuario usuario);
}
