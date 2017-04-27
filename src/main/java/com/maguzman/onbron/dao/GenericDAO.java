package com.maguzman.onbron.dao;

/**
 * Created by maguzman on 27/04/2017.
 */
import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T,Id extends Serializable> {
    T buscarPorClave(Id id);
    List <T> buscarTodos();
    void salvar(T objeto);
    void borrar(Id id);
    T actualizar(T objeto);
}
