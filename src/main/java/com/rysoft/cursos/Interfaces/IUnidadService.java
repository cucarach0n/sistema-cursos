package com.rysoft.cursos.Interfaces;

import java.util.List;

import com.rysoft.cursos.Modelos.Unidad;

public interface IUnidadService {
    public List<Unidad> listarUnidadesPorContenido(int id_curso_contenido);
}
