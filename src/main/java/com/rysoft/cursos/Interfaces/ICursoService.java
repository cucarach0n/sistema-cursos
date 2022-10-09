/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Interfaces;

import com.rysoft.cursos.Modelos.Curso;
import java.util.List;

/**
 *
 * @author USER
 */
public interface ICursoService {
    public List<Curso> listarCursosCategoria();
    public List<Curso> filtrarCursosByCategorias(int[] categorias);

    public List<Curso> filtrarCursosByCategoria(int id_categoria);

    public List<Curso> filtrarCursosByNombre(String nombreCurso);
    List<Curso> filtrarCursosByNombreCategoria(int[] categorias,String nombreCurso);

    public List<Curso> filtrarCursosByPrograma(int id_programa);
}
