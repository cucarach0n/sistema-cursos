package com.rysoft.cursos.Controlador;

import com.rysoft.cursos.Modelos.Persona;
import com.rysoft.cursos.Modelos.Usuario;
import com.rysoft.cursos.Servicios.UserService;
import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerLogin {

    @Autowired
    private UserService Uservice;

    @RequestMapping(value = "/process_register", method = RequestMethod.POST)
    public String ProcesoRegistroCliente(@RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("nombre") String nombre,
            @RequestParam("apellidos") String apellidos,
            @RequestParam("dni") String dni,
            @RequestParam("telefono") String telefono,
            @RequestParam("direccion") String direccion,
            HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {

        Usuario usuario = new Usuario(nombre.toUpperCase(), direccion, email, telefono, password, 2, 1);
        Persona persona = new Persona(nombre.toUpperCase(), apellidos.toUpperCase(), dni, "", telefono, usuario);
        System.out.println("Entro al POST");
        Uservice.register(persona, getSiteURL(request));
        return "index";
    }

    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {
        if (Uservice.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        System.out.println("Entro HTTP URL");
        return siteURL.replace(request.getServletPath(), "");
    }
}
