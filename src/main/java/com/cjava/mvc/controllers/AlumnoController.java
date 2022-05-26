package com.cjava.mvc.controllers;

import com.cjava.mvc.model.entities.Alumno;
import com.cjava.mvc.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.Map;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping(value = "/alistar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("alumnos", alumnoService.listar());
        return "alistar";
    }

    @RequestMapping(value = "/aform")
    public String crear(Map<String, Object> model) {

        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        return "aform";
    }

    @RequestMapping(value="/aform/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Alumno alumno = null;

        if(id > 0) {
            alumno = alumnoService.buscar(id);
        } else {
            return "redirect:/alistar";
        }
        model.put("alumno", alumno);
        return "aform";
    }

    @RequestMapping(value = "/aform", method = RequestMethod.POST)
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "aform";
        }

        alumnoService.grabar(alumno);
        status.setComplete();
        return "redirect:alistar";
    }

    @RequestMapping(value="/aeliminar/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            alumnoService.eliminar(id);
        }
        return "redirect:/alistar";
    }


}
