package com.rysoft.cursos.InterfaceModelos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rysoft.cursos.Modelos.Cupon_descuento;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ICupon_descuento extends CrudRepository<Cupon_descuento, Integer>{
    @Query(value="select * from cupon_descuento where codigo_cupondescuento = :codigo_cupondescuento and act_cupondescuento = 1",nativeQuery=true)
    Cupon_descuento validarCupon_descuentoByCodigoDescuento(String codigo_cupondescuento);
}
