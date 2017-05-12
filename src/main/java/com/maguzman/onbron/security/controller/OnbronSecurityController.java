package com.maguzman.onbron.security.controller;

import com.maguzman.onbron.beans.RolUsuario;
import com.maguzman.onbron.beans.Usuario;
import com.maguzman.onbron.service.RolUsuarioService;
import com.maguzman.onbron.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by maguzman on 11/05/2017.
 */
@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class OnbronSecurityController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolUsuarioService rolUsuarioService;

    @Autowired
    MessageSource messageSource;
/*
    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
*/
    @RequestMapping(value ={"/","/home"}, method = RequestMethod.GET)
    public ModelAndView homePage(ModelAndView model){
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/AccesoDenegado", method = RequestMethod.GET)
    public ModelAndView accesoDenegado(ModelAndView model){
        model.addObject("usuario", getPrincipal());
        model.setViewName("noAutorizado");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(ModelAndView model) {
        model.setViewName("/auth/login");
        return model;
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public ModelAndView forgotPassword(ModelAndView model) {
        model.setViewName("/auth/login");
        return model;
    }

    @RequestMapping(value = "/registrarse", method = RequestMethod.GET)
    public ModelAndView registrarse(ModelAndView model) {
        Usuario usuario = new Usuario();
        model.setViewName("/auth/signUp");
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null){
            new SecurityContextLogoutHandler().logout(request,response,authentication);
        }
        return new ModelAndView("redirect:/login?logout");
    }

    private String getPrincipal(){
        String nombreUsuario = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            nombreUsuario = ((UserDetails) principal).getUsername();
        }
        else {
            nombreUsuario = principal.toString();
        }
        return nombreUsuario;
    }
}
