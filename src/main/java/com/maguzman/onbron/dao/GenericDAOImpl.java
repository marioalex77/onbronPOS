package com.maguzman.onbron.dao;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GenericDAOImpl <T,Id extends Serializable> implements GenericDAO <T,Id> {
    private Class<T> clasePersistencia;
    @Autowired
    private SessionFactory sessionFactory;


    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.clasePersistencia = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    @Override
    public T buscarPorClave(Id id) {
        return (T) sessionFactory.getCurrentSession().get(clasePersistencia, id);
    }

    @Override
    public List<T> buscarTodos() {
        String consulta = "from " + clasePersistencia.getSimpleName();
        return sessionFactory.getCurrentSession().createQuery(consulta).list();
    }

    @Override
    public void salvar(T objeto) {
        sessionFactory.getCurrentSession().saveOrUpdate(objeto);
    }

    @Override
    public void borrar(Id id) {
        T objeto = (T) sessionFactory.getCurrentSession().load(clasePersistencia, id);
        if (null != objeto) {
            this.sessionFactory.getCurrentSession().delete(objeto);
        }
    }

    @Override
    public T actualizar(T objeto) {
        sessionFactory.getCurrentSession().update(objeto);
        return objeto;
    }
}

