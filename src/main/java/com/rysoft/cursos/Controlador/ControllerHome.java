package com.rysoft.cursos.Controlador;


import com.rysoft.cursos.Interfaces.ICategoriaService;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IinscripcionesService;

import com.rysoft.cursos.Modelos.Categoria;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Inscripciones;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerHome {
    @Autowired
    private ICursoService cursoServicio;
    @Autowired
    private ICategoriaService categoriaServicio;
    @Autowired
    private IinscripcionesService InscripcionesServicio;
    //private ICursoService service1;
    @GetMapping("/")
    public String Home(Model model)
    {
        List<Curso> cursos = cursoServicio.listarCursosCategoria();
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursos);
        return "index";
    }
    
    @RequestMapping(value = "/guardarIns", method = RequestMethod.POST)
    public String guardarIns(@RequestParam("nombres") String nombres, 
                             @RequestParam("apellidos") String apellidos,
                             @RequestParam("celular") String celular,
                             @RequestParam("email") String email,
                             @RequestParam("curso") String curso,
                             Model model){
        
        List<Curso> cursosList = cursoServicio.listarCursosCategoria();
        Inscripciones p = new Inscripciones(nombres,apellidos,celular,email,buscarCurs(cursosList,curso));
        InscripcionesServicio.Guardar(p);
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursosList);
        
        return "index";
        
    }
    
    @GetMapping("/terminos")
    public String Terminos()
    {
        return "termns";
    }
     private Curso buscarCurs(List<Curso> cursos, String buscado) {
        Curso c= new Curso();
        for (int i = 0; i < cursos.size(); i++) {
            if ( buscado.equals( cursos.get(i).getNom_curso() ) ) {
                c = cursos.get(i);
                break;
            }
        }
         return c;
    }
}
