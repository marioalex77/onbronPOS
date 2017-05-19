package com.maguzman.onbron.pos.controller;

import com.maguzman.onbron.beans.Producto;
import com.maguzman.onbron.service.DocumentoService;
import com.maguzman.onbron.service.ProductoService;
import com.maguzman.onbron.util.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by maguzman on 18/5/2017.
 */
@Controller
public class ProductoController extends GenericController implements InterfaceController<Producto> {
    @Autowired
    ProductoService productoService;

    @Autowired
    DocumentoService documentoService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    FileValidator filevalidator;

    @RequestMapping(value="/producto", method = RequestMethod.GET)
    public ModelAndView listar(ModelAndView model) {
        Producto producto = new Producto();
        model.addObject("producto", producto);
        model.setViewName("/products/products");
        return model;
    }
    @RequestMapping(value = "/producto", method = RequestMethod.POST)
    public ModelAndView guardar(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
        if(result.hasErrors()){
            ModelAndView model =  new ModelAndView("/products/add_product");
            model.addObject("producto", producto);
            return model;
        }
        else{
            if(producto.getIdProducto()==0){
                productoService.salvar(producto);
            }
            else{
                productoService.actualizar(producto);
            }
            return new ModelAndView("redirect:/producto");
        }
    }

    @Override
    public ModelAndView mostrarFormulario(ModelAndView model) {
        return null;
    }

    @Override
    public ModelAndView borrar(HttpServletRequest request) {
        return null;
    }

    @Override
    public ModelAndView editar(HttpServletRequest request) {
        return null;
    }

    @Override
    public ModelAndView mostrar(HttpServletRequest request) {
        return null;
    }
}
