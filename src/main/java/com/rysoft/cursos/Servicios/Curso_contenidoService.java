package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.ICurso_contenido;
import com.rysoft.cursos.Interfaces.ICurso_contenidoService;
import com.rysoft.cursos.Modelos.Curso_contenido;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class Curso_contenidoService implements ICurso_contenidoService {
    @Autowired
    private ICurso_contenido data;
    
    @Override
    public List<Curso_contenido> listarContenidoCurso(int id_curso) {
        return data.listarContenidoCurso(id_curso);
    }
}