package com.rysoft.cursos.Controlador;


import com.rysoft.cursos.Interfaces.ICategoriaService;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Interfaces.IinscripcionesService;

import com.rysoft.cursos.Modelos.Categoria;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Inscripciones;
import com.rysoft.cursos.Modelos.Programa;
import com.rysoft.cursos.entidades.CategoriaCursos;
import com.rysoft.cursos.entidades.ProgramasCursos;

import java.util.ArrayList;
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
    @Autowired
    private IProgramaService programaServicio;

    //private ICursoService service1;
    @GetMapping("/")
    public String Home(Model model)
    {
        List<Curso> cursos = cursoServicio.listarCursosCategoria();
        List<Categoria> categorias = categoriaServicio.listarCategoriasLimite(2);
        List<CategoriaCursos> categoriasCursos = new ArrayList<CategoriaCursos>();
        List<Programa> programas = programaServicio.listarProgramas();
        List<ProgramasCursos> programasCursos = new ArrayList<ProgramasCursos>();
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

        categorias.forEach(categoria ->{
            CategoriaCursos cc = new CategoriaCursos();
            cc.setId_categoria(categoria.getId_categoria());
            cc.setNom_categoria(categoria.getNom_categoria());
            cc.setAct_categoria(categoria.getAct_categoria());
            cc.setCursos(cursoServicio.filtrarCursosByCategoria(categoria.getId_categoria()));
            categoriasCursos.add(cc);
        });
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursos);
        model.addAttribute("categoriasCursos", categoriasCursos);
        model.addAttribute("programas", programasCursos);
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
