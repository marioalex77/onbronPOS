package com.maguzman.onbron.service;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;
import com.maguzman.onbron.beans.Categoria;

public interface CategoriaService {
    Categoria buscarPorClave(Integer idCategoria);
    List<Categoria> buscarTodos();
    void salvar(Categoria categoria);
    void borrar(Integer idCategoria);
    Categoria actualizar(Categoria categoria);
}
