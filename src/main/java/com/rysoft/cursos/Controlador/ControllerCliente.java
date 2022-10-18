package com.rysoft.cursos.Controlador;

import com.rysoft.cursos.Interfaces.I_usuarioService;
import com.rysoft.cursos.Modelos.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping
public class ControllerCliente {
    
   /*
    @GetMapping("/registrar")
    public String Home()
    {
        return "index";
    }
    */

    @RequestMapping(value="/registrar", method=RequestMethod.POST)
    public String registrar(
                            @RequestParam("nombre")String name,
                            @RequestParam("direccion")String direc,
                            @RequestParam("correo")String email,
                            @RequestParam("telefono") String num,
                            @RequestParam("contraseña") String contra, 
                            Model model){
        //registrar
        
        
        Usuario p= new Usuario();
        
        p.setNombre_usuario(name);
        p.setDireccion_usuario(direc);        
        p.setCorreo_usuario(email);
        p.setTelefono_usuario(num);
        p.setContrasena_usuario(contra);
        
        
        service.Guardar(p);
        //listar
        List<Usuario> usuarios = service.listar();
        model.addAttribute("usuarios", usuarios);
        return "/dashboard/usuario";
    }
     @GetMapping("/usuarios")
    public String usuario(){
          
        return "/dashboard/usuario"; //editar.html
    }
     @Autowired 
    private I_usuarioService service;
   
    @GetMapping("/listarUsuario") //localhost/
    public String ver( Model model){
        List<Usuario> usuarios = service.listar(); //elige metodo para usar[ listar() ]
        
        model.addAttribute("usuarios", usuarios);
        return "/dashboard/usuario"; //index.html
    }
    @GetMapping("/eliminar")
    public String eliminar(@RequestParam(value="id_usuario") int infoid,
                            Model model){
        //Eliminar
       service.Eliminar(infoid);
        //listas
        List<Usuario> usuarios = service.listar();
        model.addAttribute("usuarios", usuarios);
    return "/dashboard/usuario";
    }
   
   
    @GetMapping("/editar")
    public String editar(@RequestParam(value="id_usuario") int infoid,
                            Model model){
        
        Optional<Usuario> usuarios =service.listarId(infoid);
                
        model.addAttribute("usuariodato", usuarios);
        return "/dashboard/EditarU"; //editar.html
    }
    
        @RequestMapping(value="/actualizar",method=RequestMethod.POST)
    public String Actualizar(@RequestParam("id_usuario")int infoid,
            @RequestParam("nombre_usuario")     String name,
            @RequestParam("direccion_usuario")   String direc,
            @RequestParam("correo_usuario")     String email,
            @RequestParam("telefono_usuario") String num,
            @RequestParam("contrasena_usuario")  String contra,
            Model model){
        
        //actualizar
        Usuario p = new Usuario();
        p.setId_usuario(infoid);
        p.setNombre_usuario(name);
        p.setDireccion_usuario(direc);
        p.setCorreo_usuario(email);
        p.setTelefono_usuario(num);
        p.setContrasena_usuario(contra);
            
        service.Guardar(p); //para este caso actualiza, porque envia el ID
         //listas
        List<Usuario> usuario = service.listar();
        model.addAttribute("usuarios", usuario);
        return "/dashboard/usuario";
    }
    
   

}
