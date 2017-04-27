package com.maguzman.onbron.dao;

/**
 * Created by maguzman on 27/04/2017.
 */
import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maguzman.onbron.beans.Categoria;

import static javafx.scene.input.KeyCode.T;


@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Categoria buscarPorClave(Integer id) {
        return (Categoria) sessionFactory.getCurrentSession().get(Categoria.class, id);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Categoria> buscarTodos() {
        String consulta = "from Categoria categoria";
        List <Categoria> listaCategorias = sessionFactory.getCurrentSession().createQuery(consulta).list();
        return listaCategorias;
    }

    @Override
    public void salvar(Categoria categoria) {

        sessionFactory.getCurrentSession().saveOrUpdate(categoria);
    }

    @Override
    public void borrar(Integer idCategoria) {
        Categoria categoria = (Categoria) sessionFactory.getCurrentSession().load(Categoria.class, idCategoria);
        if (null != categoria) {
            this.sessionFactory.getCurrentSession().delete(categoria);
}
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        sessionFactory.getCurrentSession().update(categoria);
        return categoria;
    }
}
