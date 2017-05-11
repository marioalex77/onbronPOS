package com.maguzman.onbron.service;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.beans.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maguzman on 11/05/2017.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
            Usuario usuario = usuarioService.buscarPorCorreo(correo);
            if(usuario==null){
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
            return new org.springframework.security.core.userdetails.User(usuario.getCorreo(), usuario.getPassword(),
                    usuario.getEstado().equals("ACTIVO"), true, true,true,
                    getGrantedAuthorities(usuario));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Usuario usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(RolUsuario rolUsuario: usuario.getRolUsuario()){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rolUsuario.getTipo()));
        }
        return authorities;
    }
}
