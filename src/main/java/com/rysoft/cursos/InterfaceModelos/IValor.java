package com.rysoft.cursos.InterfaceModelos;
import com.rysoft.cursos.Modelos.Valor;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IValor extends CrudRepository<Valor, Integer> {
    @Query(value="select * from valor where act_valor = 1",nativeQuery=true)
    public List<Valor> listarValores();
}
