package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Impuesto;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Repository("impuestoDAO")
public class ImpuestoDAOImpl extends AbstractDAO<Integer,Impuesto> implements ImpuestoDAO{
    @Override
    public List<Impuesto> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Impuesto>) criteria.list();
    }
}
