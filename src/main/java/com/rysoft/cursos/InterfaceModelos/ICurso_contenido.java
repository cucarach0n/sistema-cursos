package com.rysoft.cursos.InterfaceModelos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rysoft.cursos.Modelos.Curso_contenido;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICurso_contenido extends CrudRepository<Curso_contenido, Integer> {
    @Query(value="select * from curso_contenido where id_curso = :id_curso",nativeQuery=true)
    List<Curso_contenido> listarContenidoCurso(int id_curso);
}
