package com.maguzman.onbron.dao;

/**
 * Created by maguzman on 27/04/2017.
 */

import com.maguzman.onbron.beans.Categoria;
import java.util.List;

public interface CategoriaDAO {
    Categoria buscarPorClave(int idCategoria);
    List<Categoria> buscarTodos();
    void salvar(Categoria categoria);
    void borrar(int idCategoria);
    Categoria actualizar(Categoria categoria);
}
