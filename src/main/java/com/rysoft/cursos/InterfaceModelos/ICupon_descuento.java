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
    @Query(value="select * from cupon_descuento where UPPER(codigo_cupondescuento) = UPPER(:codigo_cupondescuento) and act_cupondescuento = 1",nativeQuery=true)
    Cupon_descuento validarCupon_descuentoByCodigoDescuento(String codigo_cupondescuento);
    @Query(value="select * from cupon_descuento where now() between fecha_ini_cupondescuento  and fecha_fin_cupondescuento  and cantidad_uso_cupondescuento > 0 order by fecha_registro_cupondescuento desc limit 1",nativeQuery=true)
    Cupon_descuento getLastCupon_descuento();
}
