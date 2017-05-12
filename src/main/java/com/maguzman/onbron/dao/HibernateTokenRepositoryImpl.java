package com.maguzman.onbron.dao;

import com.maguzman.onbron.beans.PersistentLogins;
import org.hibernate.Criteria;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by maguzman on 12/05/2017.
 */
@Repository("tokenRepository")
public class HibernateTokenRepositoryImpl extends AbstractDAO<String, PersistentLogins> implements PersistentTokenRepository{

    static final Logger logger = LoggerFactory.logger(HibernateTokenRepositoryImpl.class);

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        logger.infof("Creating Token for user : {}", token.getUsername());
        PersistentLogins persistentLogins = new PersistentLogins();
        persistentLogins.setCorreo(token.getUsername());
        persistentLogins.setSeries(token.getSeries());
        persistentLogins.setToken(token.getTokenValue());
        persistentLogins.setUltimoIngreso(token.getDate());
        salvar(persistentLogins);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        logger.infof("Fetch Token if any for seriesId : {}", seriesId);
        try {
            Criteria crit = createCriterioEntidad();
            crit.add(Restrictions.eq("series", seriesId));
            PersistentLogins persistentLogins = (PersistentLogins) crit.uniqueResult();

            return new PersistentRememberMeToken(persistentLogins.getCorreo(), persistentLogins.getSeries(),
                    persistentLogins.getToken(), persistentLogins.getUltimoIngreso());
        } catch (Exception e) {
            logger.info("Token not found...");
            return null;
        }
    }

    @Override
    public void removeUserTokens(String username) {
        logger.infof("Removing Token if any for user : {}", username);
        Criteria crit = createCriterioEntidad();
        crit.add(Restrictions.eq("username", username));
        PersistentLogins persistentLogins = (PersistentLogins) crit.uniqueResult();
        if (persistentLogins != null) {
            logger.info("rememberMe was selected");
            borrar(persistentLogins.getSeries());
        }
    }


    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        logger.infof("Updating Token for seriesId : {}", seriesId);
        PersistentLogins persistentLogins = buscarPorClave(seriesId);
        persistentLogins.setToken(tokenValue);
        persistentLogins.setUltimoIngreso(lastUsed);
        actualizar(persistentLogins);
    }
}
