
package com.rysoft.cursos.Interfaces;

import com.rysoft.cursos.Modelos.Usuario;
import java.util.List;
import java.util.Optional;


public interface I_usuarioService {
    //Procedimiento para Mostrar la informacion de BD               
    public List<Usuario> listar();
    //Procedimiento para listar por ID de una persona con [OPTIONAL]
    public Optional<Usuario>listarId(int id);
    //Procedimiento para guardar una variable de tipo Persona
    public void Guardar(Usuario p);//tambien puede ser void o int devuelve
    //Procedimiento para eliminar con el ID
    public void Eliminar(int id);
    
    public List<Usuario> verificarLOGINdasboard(String correo, String contrasena);
}
