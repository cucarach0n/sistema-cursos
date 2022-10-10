/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Controlador;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Modelos.Membresia;
import com.rysoft.cursos.entidades.Carrito;
import com.rysoft.cursos.entidades.ServicioCarrito;

@Controller
public class ControllerMembresia {

    @Autowired IMembresiaService membresiaService;

    @GetMapping("/membresias")
    public String Home(Model model,HttpSession session) {
        List<Membresia> membresias = membresiaService.listarMembresias();

        Carrito carrito = (Carrito)session.getAttribute("carrito");
        if(carrito== null)
        {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        if(carrito.getServicios() == null){
            carrito.setServicios(new ArrayList<ServicioCarrito>());
        }
        model.addAttribute("servicios", carrito.getServicios());
        model.addAttribute("membresias", membresias);

        return "membresias";
    }

    @GetMapping("/membership")
    public String MembresiaInfo(/*@RequestParam(value="id") int id, Model model*/Model model,HttpSession session) {
        //model.addAttribute("membrecia",membrecia);
        Carrito carrito = (Carrito)session.getAttribute("carrito");
        if(carrito== null)
        {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        if(carrito.getServicios() == null){
            carrito.setServicios(new ArrayList<ServicioCarrito>());
        }
        model.addAttribute("servicios", carrito.getServicios());
        return "membership";
    }

}
