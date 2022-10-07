package com.rysoft.cursos.InterfaceModelos;
import com.rysoft.cursos.Modelos.Programa;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrograma extends CrudRepository<Programa, Integer> {

    @Query(value="select * from programa order by nom_programa desc",nativeQuery=true)
    List<Programa> listarProgramas();
}
    