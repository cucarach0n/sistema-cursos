package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.ICupon_descuento;
import com.rysoft.cursos.Interfaces.ICupon_descuentoService;
import com.rysoft.cursos.Modelos.Cupon_descuento;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class Cupon_descuentoService implements ICupon_descuentoService {
    @Autowired
    private ICupon_descuento data;
    
    @Override
    public Cupon_descuento validarCupon_descuentoByCodigoDescuento(String codigo_cupondescuento) {
        Cupon_descuento cupon_descuento = data.validarCupon_descuentoByCodigoDescuento(codigo_cupondescuento);
        if(cupon_descuento != null){
            if(cupon_descuento.getFechaIni_cupondescuento().before(new Date()) && cupon_descuento.getFechaFin_cupondescuento().after(new Date())){
                if(cupon_descuento.getCantidadUso_cupondescuento() > 0){
                    return cupon_descuento;
                }
            }
        }
        return null;
    }
}
