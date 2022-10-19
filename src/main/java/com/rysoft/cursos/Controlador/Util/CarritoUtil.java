package com.rysoft.cursos.Controlador.Util;

import org.springframework.beans.factory.annotation.Autowired;

import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ServicioCarrito;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Modelos.Cupon_descuento;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Membresia;
import com.rysoft.cursos.Modelos.Programa;

public class CarritoUtil {

    public static ServicioCarrito obtenerServicio(int idProducto,int tipoServicio,ICursoService cursoServicio,IMembresiaService membresiaServicio,IProgramaService programaServicio){
        

        ServicioCarrito servicioCarrito = new ServicioCarrito();
        if(tipoServicio == 1){
            Curso curso = cursoServicio.findCursoById(idProducto);
            servicioCarrito.setId_servicio(curso.getId_curso());
            servicioCarrito.setNombreServicio(curso.getNom_curso());
            servicioCarrito.setPrecioServicio(curso.getPrec_curso());
            servicioCarrito.setTipoServicio(1);
            servicioCarrito.setDescServicio(curso.getDescto_curso());
            servicioCarrito.setFotoServicio(curso.getFoto_curso());
        }
        else if(tipoServicio == 2){
            Membresia membresia = membresiaServicio.findMembresiaById(idProducto);
            servicioCarrito.setId_servicio(membresia.getId_membresia());
            servicioCarrito.setNombreServicio(membresia.getNom_membresia());
            servicioCarrito.setPrecioServicio(membresia.getPrec_membresia());
            servicioCarrito.setTipoServicio(2);
            servicioCarrito.setDescServicio(membresia.getDscto_membresia());
            servicioCarrito.setFotoServicio(membresia.getFoto_membresia());
        }
        else if(tipoServicio == 3){
            
            Programa programa = programaServicio.findProgramaById(idProducto);
            servicioCarrito.setId_servicio(programa.getId_programa());
            servicioCarrito.setNombreServicio(programa.getNom_programa());
            servicioCarrito.setPrecioServicio(programa.getPrec_programa());
            servicioCarrito.setTipoServicio(3);
            servicioCarrito.setDescServicio(programa.getDescu_programa());
            servicioCarrito.setFotoServicio(programa.getFoto_programa());
        }
        return servicioCarrito;
    }
    public static double obtenerDescuento(Cupon_descuento cupon,Carrito carrito){
        double descuento = 0;
        if(cupon.getTipoDescuento_cupondescuento() == 1){
            descuento =  carrito.getMonto_total_carrito()*(cupon.getValorDescuento_cupondescuento() * 0.01) ;
        }
        else if(cupon.getTipoDescuento_cupondescuento() == 2){
            descuento = cupon.getValorDescuento_cupondescuento();
        }
        return descuento;
    }
}
