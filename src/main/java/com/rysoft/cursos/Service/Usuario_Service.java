package com.rysoft.cursos.Service;

import com.rysoft.cursos.InterfaceModelos.I_usuario;
import com.rysoft.cursos.Interfaces.I_usuarioService;
import com.rysoft.cursos.Modelos.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Usuario_Service implements I_usuarioService {
    
    @Autowired
    private I_usuario data;
    
    @Override
    public List<Usuario> listar() {
        return (List<Usuario>) data.findAll();
    }

    @Override
    public Optional<Usuario> listarId(int id) {
        return data.findById(id);
    }

    @Override
    public void Guardar(Usuario p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id);
    }

    @Override
    public List<Usuario> verificarLOGINdasboard(String correo, String contrasena) {
        return data.findbyverificarLOGINdasboard(correo, contrasena);
    }
    
}
