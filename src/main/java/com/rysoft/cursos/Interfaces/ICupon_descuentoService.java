package com.rysoft.cursos.Interfaces;

import com.rysoft.cursos.Modelos.Cupon_descuento;

public interface ICupon_descuentoService {
    public Cupon_descuento validarCupon_descuentoByCodigoDescuento(String codigo_cupondescuento);
    public Cupon_descuento getLastCupon_descuento();
}
