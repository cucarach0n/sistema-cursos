/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;

import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Modelos.Programa;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerPrograma {

    @Autowired
    private IProgramaService programaServicio;

    @GetMapping("/programas")
    public String Home(Model model) {
        List<Programa> programas = programaServicio.listarProgramas();
        model.addAttribute("programas", programas);
        return "programas";
    }

    @GetMapping("/programa")
    public String ProgramaInfo(/*@RequestParam(value="id") int id, Model model*/) {
        //model.addAttribute("programa",programa);
        return "programa";
    }
}
