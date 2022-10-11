package com.rysoft.cursos.Controlador.Util;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ServicioCarrito;

public class SessionUtil {
    public static Carrito getCarritoSession(HttpSession session){
        Carrito carrito = (Carrito)session.getAttribute("carrito");
        if(carrito== null)
        {
            carrito = new Carrito();
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
        for(ServicioCarrito s : carrito.getServicios()){
            if(s.getId_servicio() == servicio.getId_servicio()){
                existe = true;
            }
            montoTotal += s.getPrecioServicio();
        }
        if(existe){
            return;
        }
        
        carrito.getServicios().add(servicio);
        carrito.setCant_servicios_carrito(carrito.getServicios().size());
        carrito.setMonto_total_carrito(montoTotal + servicio.getPrecioServicio());
    }
}
