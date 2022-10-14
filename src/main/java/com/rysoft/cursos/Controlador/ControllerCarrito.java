package com.rysoft.cursos.Controlador;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ServicioCarrito;
import com.rysoft.cursos.InterfaceModelos.IMembresia;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Membresia;
import com.rysoft.cursos.Modelos.Programa;
import com.rysoft.cursos.Controlador.Util.SessionUtil;
import com.rysoft.cursos.Controlador.Util.CarritoUtil;
@Controller
public class ControllerCarrito {
    @Autowired
    private ICursoService cursoServicio;
    @Autowired
    private IMembresiaService membresiaServicio;
    @Autowired
    private IProgramaService programaServicio;
    
    @GetMapping("/carrito")
    public String Home(@RequestParam(value="idProducto", required = false) String idServicio,@RequestParam(value="tipoServicio", required = false) String tipoServicio,HttpSession session,Model model)
    {
        Carrito carrito = SessionUtil.getCarritoSession(session);
        if(idServicio != null && !idServicio.isBlank()){      
            SessionUtil.agregarServicioCarrito(session,CarritoUtil.obtenerServicio(Integer.parseInt(idServicio),Integer.parseInt(tipoServicio),cursoServicio,membresiaServicio,programaServicio));
        }
        model.addAttribute("carrito", carrito);
        return "carrito";
    }
    @PostMapping("/agregarItemCarrito")
    public String agregarItem(@RequestParam("idProducto") int idProducto,@RequestParam("tipoServicio") int tipoServicio,HttpSession session,Model model)
    {
       
        Carrito carrito = SessionUtil.getCarritoSession(session);

        //carrito.getServicios().add(servicioCarrito);
        SessionUtil.agregarServicioCarrito(session, CarritoUtil.obtenerServicio(idProducto, tipoServicio,cursoServicio,membresiaServicio,programaServicio));
        
        session.setAttribute("servicios", carrito.getServicios());
        model.addAttribute("servicios", carrito.getServicios());
        return "vistasParciales/modalCarrito";
    }
    @GetMapping("/eliminarItemCarrito")
    public String ElimirServicioItemCarrito(@RequestParam("idproducto") int idProducto,HttpSession session,Model model){
        Carrito carrito = SessionUtil.getCarritoSession(session);
        carrito.getServicios().removeIf(servicio -> servicio.getId_servicio() == idProducto);
        carrito.setCant_servicios_carrito(carrito.getServicios().size());
        model.addAttribute("carrito", carrito);
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
