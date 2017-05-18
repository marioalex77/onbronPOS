package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.Documento;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by maguzman on 18/05/2017.
 */
@Repository("documentoDAO")
public class DocumentoDAOImpl extends AbstractDAO<Integer,Documento> implements DocumentoDAO {
    @Override
    public List<Documento> buscarTodos() {
        Criteria criteria = createCriterioEntidad();
        return (List<Documento>) criteria.list();
    }
}
