package com.maguzman.onbron.dao;
/**
 * Created by maguzman on 27/04/2017.
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maguzman.onbron.beans.Categoria;

@Repository("categoriaDAO")
public class CategoriaDAOImpl implements CategoriaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Categoria buscarPorClave(int id) {
        return (Categoria) getSession().get(Categoria.class, id);
    }

    @Override
    public List<Categoria> buscarTodos() {
        String consulta = "from Categoria categoria";
        return (List<Categoria>)  getSession().createQuery(consulta).list();
    }

    @Override
    public void salvar(Categoria categoria) {
        getSession().persist(categoria);
    }

    @Override
    public void borrar(int idCategoria) {
        Categoria categoria = (Categoria) getSession().load(Categoria.class, idCategoria);
        if (null != categoria)
            getSession().delete(categoria);
    }

    @Override
    public Categoria actualizar(Categoria categoria) {
        getSession().update(categoria);
        return categoria;
    }
}
