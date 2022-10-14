package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.IUnidad;
import com.rysoft.cursos.Interfaces.IUnidadService;
import com.rysoft.cursos.Modelos.Unidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadService implements IUnidadService {
    @Autowired
    private IUnidad data;
    
    @Override
    public List<Unidad> listarUnidadesPorContenido(int id_curso_contenido) {
        return data.listarUnidadesPorContenido(id_curso_contenido);
    }
}