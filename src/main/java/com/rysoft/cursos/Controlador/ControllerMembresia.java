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
import org.springframework.web.bind.annotation.RequestParam;

import com.rysoft.cursos.Controlador.Util.SessionUtil;
import com.rysoft.cursos.Entidades.Carrito;
import com.rysoft.cursos.Entidades.ServicioCarrito;
import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Interfaces.IValorService;
import com.rysoft.cursos.Modelos.Membresia;
import com.rysoft.cursos.Modelos.Valor;

@Controller
public class ControllerMembresia {

    @Autowired 
    IMembresiaService membresiaService;
    @Autowired
    private IValorService valorService; 
    @GetMapping("/membresias")
    public String Home(Model model,HttpSession session) {
        List<Membresia> membresias = membresiaService.listarMembresias();

        Carrito carrito = SessionUtil.getCarritoSession(session);

        model.addAttribute("servicios", carrito.getServicios());
        model.addAttribute("membresias", membresias);

        return "membresias";
    }

    @GetMapping("/membresia")
    public String MembresiaInfo(@RequestParam(value="id") int id, Model model, HttpSession session) {
        //model.addAttribute("membrecia",membrecia);
        Carrito carrito = SessionUtil.getCarritoSession(session);
        Membresia membresia = membresiaService.findMembresiaById(id);
        List<Valor> valores = valorService.listarValores();
        model.addAttribute("valores", valores);
        model.addAttribute("servicios", carrito.getServicios());
        model.addAttribute("membresia", membresia);
        return "membership";
    }

}
