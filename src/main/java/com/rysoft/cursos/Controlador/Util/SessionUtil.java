package com.rysoft.cursos.Controlador.Util;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ServicioCarrito;
import com.rysoft.cursos.Modelos.Cupon_descuento;

public class SessionUtil {
    public static Carrito getCarritoSession(HttpSession session){
        Carrito carrito = (Carrito)session.getAttribute("carrito");
        if(carrito== null)
        {
            carrito = new Carrito();
            carrito.setMonto_total_carrito(0f);
            carrito.setMonto_subtotal_carrito(0f);
            carrito.setDsco_carrito(0f);
            carrito.setCant_servicios_carrito(0);
            session.setAttribute("carrito", carrito);
        }
        if(carrito.getServicios() == null){
            carrito.setServicios(new ArrayList<ServicioCarrito>());
        }
        return carrito;
    }
    public static void agregarServicioCarrito(HttpSession session, ServicioCarrito servicio){
        Carrito carrito = getCarritoSession(session);
        boolean existe = false;
        float montoTotal = 0;
        float subTotal = 0;
        float descuento = 0;
        for(ServicioCarrito s : carrito.getServicios()){
            if(s.getId_servicio() == servicio.getId_servicio() && s.getTipoServicio() == servicio.getTipoServicio()){
                existe = true;
            }
            descuento = (s.getPrecioServicio() * (s.getDescServicio() * 0.01f));
            subTotal += s.getPrecioServicio();
            montoTotal +=  s.getPrecioServicio() - descuento;
            
        }
        if(existe){
            return;
        }
        //${#numbers.formatDecimal(curs.prec_curso, 1, 'COMMA', 1, 'POINT')} * (${#numbers.formatDecimal(curs.descto_curso, 1, 'COMMA', 1, 'POINT')} * 0.01)
        descuento = (servicio.getPrecioServicio() * (servicio.getDescServicio() * 0.01f));
        servicio.setPrecioFinalServicio(servicio.getPrecioServicio() - descuento);
        carrito.getServicios().add(servicio);
        carrito.setCant_servicios_carrito(carrito.getServicios().size());
        
        carrito.setMonto_subtotal_carrito(subTotal  + servicio.getPrecioServicio());
        carrito.setMonto_total_carrito(montoTotal + ( servicio.getPrecioServicio() - descuento));
    }
    public static void agregarCuponCarrito(HttpSession session, Cupon_descuento cupon){
        Carrito carrito = getCarritoSession(session);
        carrito.setCuponDescuento(cupon);
        
    }
}
