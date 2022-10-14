/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;

import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.ICurso_contenidoService;
import com.rysoft.cursos.Interfaces.IUnidadService;
import com.rysoft.cursos.Controlador.Util.SessionUtil;
import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ServicioCarrito;
import com.rysoft.cursos.Interfaces.ICategoriaService;
import com.rysoft.cursos.Modelos.Categoria;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Curso_contenido;
import com.rysoft.cursos.Modelos.Unidad;

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

import javax.servlet.http.HttpSession;

@Controller
public class ControllerCurso {

    @Autowired
    private ICursoService cursoServicio;
    @Autowired
    private ICategoriaService categoriaServicio;
    @Autowired
    private ICurso_contenidoService curso_contenidoServicio;

    //private ICursoService service1;

    @GetMapping("/cursos")
    public String Home(Model model, HttpSession session) {
        List<Curso> cursos = cursoServicio.listarCursosCategoria();
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cursos);

        Carrito carrito = SessionUtil.getCarritoSession(session);
        model.addAttribute("servicios", carrito.getServicios());
        return "cursos";
    }

    @PostMapping("/cursos")
    public String FiltraCursoByCategoria(@RequestParam(value = "categorias[]", required = false) int[] cats, @RequestParam("nombrecurso") String cursoName, Model model, HttpSession session) {
        Carrito carrito = SessionUtil.getCarritoSession(session);
        List<Curso> cur = cursoServicio.listarCursosCategoria();
        if (cats != null && cursoName.isEmpty()) {
            cur = cursoServicio.filtrarCursosByCategorias(cats);
        } else if (cats == null && !cursoName.isEmpty()) {
            cur = cursoServicio.filtrarCursosByNombre(cursoName);
        } else if ((cats != null && !cursoName.isEmpty())) {
            cur = cursoServicio.filtrarCursosByNombreCategoria(cats, cursoName);
        }
        List<Categoria> categorias = categoriaServicio.listarCategorias();
        model.addAttribute("categorias", categorias);
        model.addAttribute("cursos", cur);

        model.addAttribute("servicios", carrito.getServicios());
        return "cursos";
    }

    @GetMapping("/curso")
    public String CursoInfo(@RequestParam(value="id") int id, Model model, HttpSession session) {
        Carrito carrito = SessionUtil.getCarritoSession(session);
        Curso curso = cursoServicio.findCursoById(id);
        List<Curso> cursos = cursoServicio.filtrarCursosByCategoria(curso.getCategoria().getId_categoria());
        //List<Unidad> unidades = unidadServicio.listarUnidadesPorContenido(curso.getId_curso());
        //model.addAttribute("curso",curso);
        model.addAttribute("servicios", carrito.getServicios());
        model.addAttribute("curso", curso);
        model.addAttribute("cursosSugerencia", cursos);
        return "course";
    }

    public static Curso buscarCurs(List<Curso> cursos, String buscado) {
        Curso c = new Curso();
        for (Curso curso : cursos) {
            if (buscado.equals(curso.getNom_curso())) {
                c = curso;
                break;
            }
        }
        return c;
    }

}
