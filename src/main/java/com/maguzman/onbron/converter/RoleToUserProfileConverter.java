    package com.maguzman.onbron.converter;



import org.jboss.logging.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.service.RolUsuarioService;


/**
 * Created by maguzman on 12/05/2017.
 */
@Component
public class RoleToUserProfileConverter implements Converter <Object, RolUsuario> {
    static final Logger logger = LoggerFactory.logger(RoleToUserProfileConverter.class);

    @Autowired
    RolUsuarioService rolUsuarioService;


        public RolUsuario convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        RolUsuario profile= rolUsuarioService.buscarPorClave(id);
        logger.infof("Rol Usuario : {}",profile);
        return profile;
    }
}
