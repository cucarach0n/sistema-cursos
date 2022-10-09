/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;


import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.ICategoriaService;
import com.rysoft.cursos.Modelos.Categoria;
import com.rysoft.cursos.Modelos.Curso;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class ControllerCurso {
    
    @Autowired
    private ICursoService cursoServicio;
    @Autowired
    private ICategoriaService categoriaServicio;
    //private ICursoService service1;
   
    @GetMapping("/cursos")
    public String Home(Model model) {
        List<Curso> cursos = cursoServicio.listarCursosCategoria();
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursos);
        
        return "cursos";
    }
    @PostMapping("/cursos")
    public String FiltraCursoByCategoria(@RequestParam(value = "categorias[]", required=false) int[] cats ,@RequestParam("nombrecurso") String cursoName,Model model) {
        List<Curso> cur = cursoServicio.listarCursosCategoria();
        if(cats != null && cursoName.isEmpty()){
            cur = cursoServicio.filtrarCursosByCategorias(cats);
        }
        else if(cats == null && !cursoName.isEmpty()){
            cur = cursoServicio.filtrarCursosByNombre(cursoName);
        }
        else if((cats != null && !cursoName.isEmpty())){
            cur=cursoServicio.filtrarCursosByNombreCategoria(cats,cursoName);
        }
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cur);
        
        return "cursos";
    }
    @GetMapping("/course")
    public String CursoInfo(/*@RequestParam(value="id") int id, Model model*/) {
        //model.addAttribute("curso",curso);
        return "course";
    }
}
