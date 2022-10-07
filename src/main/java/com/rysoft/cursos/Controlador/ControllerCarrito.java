package com.rysoft.cursos.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerCarrito {
    @GetMapping("/carrito")
    public String Home()
    {
        return "carrito";
    }
    @GetMapping("/pago1")
    public String ProcesoPagoUno()
    {
        return "detalle-pago";
    }
    @GetMapping("/pago2")
    public String ProcesoPagoDos()
    {
        return "detalle-pago2";
    }
    @GetMapping("/pagar")
    public String Pagar()
    {
        return "finish-shop";
    }
}
