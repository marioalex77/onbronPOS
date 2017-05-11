package com.maguzman.onbron.service;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.dao.RolUsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by maguzman on 11/05/2017.
 */
@Service("rolUsuarioService")
@Transactional
public class RolUsuarioServiceImpl implements RolUsuarioService{
    @Autowired
    private RolUsuarioDAO dao;

    public RolUsuario buscarPorClave(Integer idRolUsuario){
        return dao.buscarPorClave(idRolUsuario);
    }
    public RolUsuario buscarPorTipo(String tipo){
        return dao.buscarPorTipo(tipo);
    }
    public List<RolUsuario> buscarTodos(){
        return (List<RolUsuario>) dao.buscarTodos();
    }
}
