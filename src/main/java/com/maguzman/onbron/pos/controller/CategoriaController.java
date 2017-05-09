package com.maguzman.onbron.pos.controller;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.MessageSource;
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
//import org.springframework.context.i18n.LocaleContextHolder;



@Controller
public class CategoriaController {
    private static final Logger logger = Logger.getLogger(CategoriaController.class);

    public CategoriaController(){
        System.out.println("CategoriaController");
    }

    @Autowired
    private CategoriaService categoriaService;

    //@Autowired
    //private MessageSource messageSource;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelAndView model) {
        //logger.debug("index()");
        return "redirect:/categoria";
    }

    //Listar Categorias
    @RequestMapping(value = "/categoria", method = RequestMethod.GET)
    public ModelAndView listarCategorias(ModelAndView model){
        //logger.debug("listaCategorias()");
        List<Categoria> listaCategorias= categoriaService.buscarTodos();
        model.addObject("categorias", listaCategorias);
        model.setViewName("products/categories");
        return model;
    }

    //Guardar o actualizar Usuario
    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public ModelAndView guardarCategoria(@Valid @ModelAttribute("categoria") Categoria categoria,
                                               BindingResult result) {
        logger.debugf("guardarCategoria() : {}", categoria);
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_categorie");
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
            return new ModelAndView("redirect:/categoria");
        }
    }

    //Mostrar formulario agregar categoria
    @RequestMapping(value = "/categoria/agregar", method = RequestMethod.GET)
    public ModelAndView mostrarFormulario(ModelAndView model) {
        //logger.debug("mostrarFormularioCategoria()");
        Categoria categoria = new Categoria();
        model.addObject("categoria", categoria);
        model.setViewName("/products/add_categorie");
        return model;
    }

    //borrar categoria
    @RequestMapping(value = "/categoria/borrar", method = RequestMethod.GET)
    public ModelAndView borrarCategoria(HttpServletRequest request) {
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        //logger.debugf("borrarCategoria()",categoriaId);
        categoriaService.borrar(categoriaId);
        return new ModelAndView("redirect:/categoria");
    }

    //editar categoria
    @RequestMapping(value = "/categoria/editar", method = RequestMethod.GET)
    public ModelAndView editarCategoria(HttpServletRequest request) {
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = categoriaService.buscarPorClave(categoriaId);
        //logger.debugf("editarCategoria()",categoria);
        ModelAndView model = new ModelAndView("/products/add_categorie");
        model.addObject("categoria", categoria);
        return model;
    }

    //mostrar categoria
    @RequestMapping(value = "/categoria/mostrar", method = RequestMethod.GET)
    public ModelAndView mostrarCategoria(HttpServletRequest request, Locale locale){
        int categoriaId = Integer.parseInt(request.getParameter("idCategoria"));
        Categoria categoria = categoriaService.buscarPorClave(categoriaId);
        //logger.debugf("mostrarCategoria()",categoria);
        ModelAndView model = new ModelAndView("/products/show_categorie");
        model.addObject("categoria", categoria);
        /*if (categoria==null) {
            String errorNotFound = messageSource.getMessage(
                    "add_categorie.error.notfound",
                    new Object[]{"Categoria no encontrada"},
                    locale);
            // obtain locale from LocaleContextHolder
            Locale currentLocale = LocaleContextHolder.getLocale();
            model.addObject("locale", currentLocale);
            model.addObject("message",errorNotFound);
        }*/
        return model;
    }
}
