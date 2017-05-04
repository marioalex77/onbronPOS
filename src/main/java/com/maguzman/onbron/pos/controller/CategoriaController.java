package com.maguzman.onbron.pos.controller;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maguzman.onbron.beans.Categoria;
import com.maguzman.onbron.service.CategoriaService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;
import org.springframework.context.i18n.LocaleContextHolder;



@Controller
public class CategoriaController {
    private static final Logger logger = Logger.getLogger(CategoriaController.class);

    public CategoriaController(){
        System.out.println("CategoriaController");
    }

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = {"/posAdmin/categoria/list","/categoria/list","/"}, method = RequestMethod.GET)
    public ModelAndView listaCategoria(ModelAndView model){
        List<Categoria> listaCategoria = categoriaService.buscarTodos();
        model.addObject("listaCategoria", listaCategoria);
        model.setViewName("products/categories");
        return model;
    }

    @RequestMapping(value = {"/posAdmin/categoria/agregar","/categoria/agregar"}, method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Categoria categoria = new Categoria();
        model.addObject("categoria", categoria);
        model.setViewName("AddCategories");
        return model;
    }

    @RequestMapping(value = "/categoria/guardar", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("AddCategories");
            model.addObject("categoria", categoria);
            return model;
        }
        else {
            if (categoria.getIdCategoria() == 0) { // Si categoria es 0 se crea nueva categoria
                // caso contrario se actualiza
                categoriaService.salvar(categoria);
            } else {
                categoriaService.actualizar(categoria);
            }
            return new ModelAndView("redirect:/categoria/list");
        }
    }

    @RequestMapping(value = "/categoria/borrar", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        categoriaService.borrar(categoriaId);
        return new ModelAndView("redirect:/categoria/list");
    }

    @RequestMapping(value = "/categoria/editar", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = categoriaService.buscarPorClave(categoriaId);
        ModelAndView model = new ModelAndView("AddCategories");
        model.addObject("categoria", categoria);
        return model;
    }
}
