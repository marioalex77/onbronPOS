package com.maguzman.onbron.service;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maguzman.onbron.dao.CategoriaDAO;
import com.maguzman.onbron.beans.Categoria;

@Service
@Transactional
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    @Transactional
    public Categoria buscarPorClave(Integer idCategoria){
        return categoriaDAO.buscarPorClave(idCategoria);
    }

    @Override
    @Transactional
    public List<Categoria> buscarTodos(){
        return categoriaDAO.buscarTodos();
    }
    @Override
    @Transactional
    public void salvar(Categoria categoria){
        categoriaDAO.salvar(categoria);
    }

    @Override
    @Transactional
    public void borrar(Integer idCategoria){
        categoriaDAO.borrar(idCategoria);
    }
    @Override
    @Transactional
    public Categoria actualizar(Categoria categoria){
        return categoriaDAO.actualizar(categoria);
    }
}
