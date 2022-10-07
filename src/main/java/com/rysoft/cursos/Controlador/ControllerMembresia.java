/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerMembresia {

    @GetMapping("/membresias")
    public String Home() {
        return "membresias";
    }

    @GetMapping("/membership")
    public String MembresiaInfo(/*@RequestParam(value="id") int id, Model model*/) {
        //model.addAttribute("membrecia",membrecia);
        return "membership";
    }

}
