package com.maguzman.onbron.dao;

/**
 * Created by maguzman on 27/04/2017.
 */

import com.maguzman.onbron.beans.Categoria;
import java.util.List;

public interface CategoriaDAO {
    public abstract Categoria buscarPorClave(Integer id);
    public abstract List<Categoria> buscarTodos();
    public abstract void salvar(Categoria categoria);
    public abstract void borrar(Integer id);
    public abstract Categoria actualizar(Categoria categoria);
}
