package com.rysoft.cursos.InterfaceModelos;
import com.rysoft.cursos.Modelos.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ICategoria extends CrudRepository<Categoria, Integer> {

    @Query(value="select * from categoria order by nom_categoria desc",nativeQuery=true)
    List<Categoria> listarCategorias();

    @Query(value="select * from categoria order by nom_categoria LIMIT :limite",nativeQuery=true)
    List<Categoria> listarCategoriasLimite( int limite);
}
