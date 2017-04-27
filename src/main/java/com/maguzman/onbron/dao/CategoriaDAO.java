package com.maguzman.onbron.dao;

/**
 * Created by maguzman on 27/04/2017.
 */

import com.maguzman.onbron.beans.Categoria;
import java.util.List;

public interface CategoriaDAO {
    Categoria buscarPorClave(Integer id);
    List<Categoria> buscarTodos();
    void salvar(Categoria categoria);
    void borrar(Integer id);
    Categoria actualizar(Categoria categoria);
}
