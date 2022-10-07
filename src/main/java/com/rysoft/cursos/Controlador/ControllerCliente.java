package com.rysoft.cursos.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCliente {
    @GetMapping("/registrar")
    public String Home()
    {
        return "index";
    }
    
}
