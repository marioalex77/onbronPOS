package com.maguzman.onbron.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by maguzman on 11/05/2017.
 */
@Controller
public class OnbronSecurityController {
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
