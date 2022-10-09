/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Modelos.Membresia;

@Controller
public class ControllerMembresia {

    @Autowired IMembresiaService membresiaService;

    @GetMapping("/membresias")
    public String Home(Model model) {
        List<Membresia> membresias = membresiaService.listarMembresias();

        model.addAttribute("membresias", membresias);
        return "membresias";
    }

    @GetMapping("/membership")
    public String MembresiaInfo(/*@RequestParam(value="id") int id, Model model*/) {
        //model.addAttribute("membrecia",membrecia);
        return "membership";
    }

}
