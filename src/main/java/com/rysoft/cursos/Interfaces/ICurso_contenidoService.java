package com.rysoft.cursos.Interfaces;

import java.util.List;

import com.rysoft.cursos.Modelos.Curso_contenido;

public interface ICurso_contenidoService {
    List<Curso_contenido> listarContenidoCurso(int id_curso);
}
