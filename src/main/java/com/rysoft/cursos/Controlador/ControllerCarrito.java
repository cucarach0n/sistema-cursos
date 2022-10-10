package com.rysoft.cursos.Controlador;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rysoft.cursos.InterfaceModelos.IMembresia;
import com.rysoft.cursos.Interfaces.ICursoService;
import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Modelos.Curso;
import com.rysoft.cursos.Modelos.Membresia;
import com.rysoft.cursos.Modelos.Programa;
import com.rysoft.cursos.entidades.Carrito;
import com.rysoft.cursos.entidades.ServicioCarrito;

@Controller
public class ControllerCarrito {
    @Autowired
    private ICursoService cursoServicio;

    @Autowired
    private IProgramaService programaServicio;

    @Autowired
    private IMembresiaService membresiaServicio;
    
    @GetMapping("/carrito")
    public String Home()
    {
        return "carrito";
    }
    @GetMapping("/agregarItemCarrito")
    public String agregarItem(@RequestParam("idProducto") int idProducto,@RequestParam("tipoServicio") int tipoServicio,HttpSession session,Model model)
    {
        System.out.println("Entre!");
        Carrito carrito = (Carrito)session.getAttribute("carrito");
        if(carrito== null)
        {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        ServicioCarrito servicioCarrito = new ServicioCarrito();
        if(tipoServicio == 1){
            Curso curso = cursoServicio.findCursoById(idProducto);
            servicioCarrito.setId_servicio(curso.getId_curso());
            servicioCarrito.setNombreServicio(curso.getNom_curso());
            servicioCarrito.setPrecioServicio(curso.getPrec_curso());
            servicioCarrito.setTipoServicio(1);
            servicioCarrito.setFotoServicio(curso.getFoto_curso());
        }
        else if(tipoServicio == 2){
            Membresia membresia = membresiaServicio.findMembresiaById(idProducto);
            servicioCarrito.setId_servicio(membresia.getId_membresia());
            servicioCarrito.setNombreServicio(membresia.getNom_membresia());
            servicioCarrito.setPrecioServicio(membresia.getPrec_membresia());
            servicioCarrito.setTipoServicio(2);
            servicioCarrito.setFotoServicio(membresia.getFoto_membresia());
        }
        else if(tipoServicio == 3){
            Programa programa = programaServicio.findProgramaById(idProducto);
            servicioCarrito.setId_servicio(programa.getId_programa());
            servicioCarrito.setNombreServicio(programa.getNom_programa());
            servicioCarrito.setPrecioServicio(programa.getPrec_programa());
            servicioCarrito.setTipoServicio(3);
            servicioCarrito.setFotoServicio(programa.getFoto_programa());
        }
        
        if(carrito.getServicios() == null){
            carrito.setServicios(new ArrayList<ServicioCarrito>());
            carrito.getServicios().add(servicioCarrito);
        }
        else{
            carrito.getServicios().add(servicioCarrito);
        }
        System.out.println(carrito.getServicios().size());
        session.setAttribute("servicios", carrito.getServicios());
        model.addAttribute("servicios", carrito.getServicios());
        return "vistasParciales/modalCarrito";
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
