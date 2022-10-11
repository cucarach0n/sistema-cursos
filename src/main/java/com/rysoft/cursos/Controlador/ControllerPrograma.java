/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;


import com.rysoft.cursos.Controlador.Util.SessionUtil;
import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ProgramasCursos;
import com.rysoft.cursos.Entidades.ServicioCarrito;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Modelos.Programa;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ControllerPrograma {

    @Autowired
    private IProgramaService programaServicio;
    @Autowired
    private ICursoService cursoServicio;

    @GetMapping("/programas")
    public String Home(Model model,HttpSession session) {
        Carrito carrito = SessionUtil.getCarritoSession(session);
        List<ProgramasCursos> programasCursos = new ArrayList<ProgramasCursos>();
        List<Programa> programas = programaServicio.listarProgramas();

        programas.forEach((programa) -> {
            ProgramasCursos pc = new ProgramasCursos();
            pc.setId_programa(programa.getId_programa());
            pc.setDesc_programa(programa.getDesc_programa());
            pc.setNom_programa(programa.getNom_programa());
            pc.setPrec_programa(programa.getPrec_programa());
            pc.setDescu_programa(programa.getDescu_programa());
            pc.setFoto_programa(programa.getFoto_programa());
            pc.setVigencia_programa(programa.getVigencia_programa());
            pc.setAct_programa(programa.getAct_programa());
            pc.setCantCurso_programa(cursoServicio.filtrarCursosByPrograma(programa.getId_programa()).size());
            programasCursos.add(pc);
        });
        model.addAttribute("programas", programasCursos);
        
        model.addAttribute("servicios", carrito.getServicios());
        return "programas";
    }

    @GetMapping("/programa")
    public String ProgramaInfo(/*@RequestParam(value="id") int id, Model model*/Model model,HttpSession session) {
        //model.addAttribute("programa",programa);
        Carrito carrito = SessionUtil.getCarritoSession(session);
        model.addAttribute("servicios", carrito.getServicios());
        return "programa";
    }
}
