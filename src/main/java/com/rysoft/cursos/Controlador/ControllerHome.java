package com.rysoft.cursos.Controlador;


import com.rysoft.cursos.Interfaces.ICategoriaService;

import com.rysoft.cursos.Modelos.Categoria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerHome {
    

    @GetMapping("/")
    public String Home()
    {
        return "index";
    }
    @GetMapping("/terminos")
    public String Terminos()
    {
        return "termns";
    }
    
}
