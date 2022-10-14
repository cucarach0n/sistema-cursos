package com.rysoft.cursos.InterfaceModelos;
import com.rysoft.cursos.Modelos.Programa;
import com.rysoft.cursos.Modelos.Unidad;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUnidad extends CrudRepository<Unidad, Integer> {
    @Query(value="select * from unidad where id_curso_contenido = :id_curso_contenido",nativeQuery=true)
    public List<Unidad> listarUnidadesPorContenido(int id_curso_contenido);
}