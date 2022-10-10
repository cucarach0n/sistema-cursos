/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Servicios;

import com.rysoft.cursos.InterfaceModelos.ICurso;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Modelos.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class CursoService implements ICursoService {
    @Autowired
    private ICurso data;
    
    @Override
    public List<Curso> listarCursosCategoria() {
        return data.findCursoCategoria();
    }
    @Override
    public List<Curso> filtrarCursosByCategorias(int[] categorias) {
        return data.filtrarCursosByCategorias(categorias);
    }
    @Override
    public List<Curso> filtrarCursosByNombre(String nombreCurso) {
        return data.filtrarCursosByNombre(nombreCurso);
    }
    @Override
    public List<Curso> filtrarCursosByNombreCategoria(int[] categorias, String nombreCurso) {
        return data.filtrarCursosByNombreCategoria(categorias, nombreCurso);
    }
    @Override
    public List<Curso> filtrarCursosByPrograma(int id_programa) {
        return data.filtrarCursosByPrograma(id_programa);
    }
    @Override
    public List<Curso> filtrarCursosByCategoria(int id_categoria) {
        return data.filtrarCursosByCategoria(id_categoria);
    }
    @Override
    public Curso findCursoById(int id_curso) {
        return data.findCursoById(id_curso);
    }
}
