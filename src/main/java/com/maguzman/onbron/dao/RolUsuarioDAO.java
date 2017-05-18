package com.maguzman.onbron.dao;

import java.util.List;
import com.maguzman.onbron.beans.RolUsuario;

/**
 * Created by maguzman on 11/05/2017.
 */
public interface RolUsuarioDAO {
    List<RolUsuario> buscarTodos();
    RolUsuario buscarPorTipo(String tipo);
    RolUsuario buscarPorClave(Integer idRolUsuario);
    void salvar(RolUsuario rolUsuario);
    void borrar(Integer idRolUsuario);
    RolUsuario actualizar(RolUsuario rolUsuario);
}
