/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.InterfaceModelos;

import com.rysoft.cursos.Modelos.Curso;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

@Repository
public interface ICurso extends CrudRepository<Curso, Integer> {
    @Query(value="select * from curso inner join categoria on curso.id_categoria = categoria.id_categoria order by curso.nom_curso desc",nativeQuery=true)
    List<Curso> findCursoCategoria();

    
    @Query(value="select * from curso inner join categoria on curso.id_categoria = categoria.id_categoria where curso.id_categoria IN (:categorias) order by curso.nom_curso desc",nativeQuery=true)
    List<Curso> filtrarCursosByCategoria(int[] categorias);

    @Query(value="select * from curso inner join categoria on curso.id_categoria = categoria.id_categoria where curso.nom_curso LIKE %:nombreCurso% order by curso.nom_curso desc",nativeQuery=true)
    List<Curso> filtrarCursosByNombre(String nombreCurso);

    @Query(value="select * from curso inner join categoria on curso.id_categoria = categoria.id_categoria where curso.id_categoria IN (:categorias) and curso.nom_curso LIKE %:nombreCurso% order by curso.nom_curso desc",nativeQuery=true)
    List<Curso> filtrarCursosByNombreCategoria(int[] categorias,String nombreCurso);
}
