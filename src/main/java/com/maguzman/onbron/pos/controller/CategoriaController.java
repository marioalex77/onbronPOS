package com.maguzman.onbron.pos.controller;

/**
 * Created by maguzman on 27/04/2017.
 */

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.maguzman.onbron.beans.Categoria;
import com.maguzman.onbron.service.CategoriaService;

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
        model.setViewName("productos/categorias");
        return model;
    }
    /*
    * @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("EmployeeForm");
        return model;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);

        return model;
    }


    * */
}
