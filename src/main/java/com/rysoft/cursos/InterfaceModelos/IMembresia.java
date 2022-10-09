package com.rysoft.cursos.InterfaceModelos;
import com.rysoft.cursos.Modelos.Membresia;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMembresia extends CrudRepository<Membresia, Integer> {
    @Query(value="select * from membresia where act_membresia = 1 order by nom_membresia desc",nativeQuery=true)
    List<Membresia> listarMembresias();
}
