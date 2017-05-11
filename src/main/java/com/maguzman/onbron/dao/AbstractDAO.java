package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Categoria;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.lang.reflect.ParameterizedType;
/**
 * Created by maguzman on 11/05/2017.
 */
public abstract class AbstractDAO <PK extends Serializable, T> {

    private final Class<T> clasePersistencia;

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDAO(){
        this.clasePersistencia = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T buscarPorClave(PK id) {
        return (T) getSession().get(clasePersistencia, id);
    }

    public void salvar(T entidad) {
        getSession().persist(entidad);
    }

    @SuppressWarnings("unchecked")
    public void borrar(PK id) {
        T entidad = (T) getSession().load(clasePersistencia, id);
        if (null != entidad)
            getSession().delete(entidad);
    }

    public T actualizar(T entidad) {
        getSession().update(entidad);
        return entidad;
    }

    protected Criteria createCriterioEntidad(){
        return getSession().createCriteria(clasePersistencia);
    }
}
