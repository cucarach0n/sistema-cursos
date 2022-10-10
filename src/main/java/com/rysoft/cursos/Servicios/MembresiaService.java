package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.IMembresia;
import com.rysoft.cursos.Interfaces.IMembresiaService;
import com.rysoft.cursos.Modelos.Membresia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembresiaService implements IMembresiaService {
    @Autowired
    private IMembresia data;
    
    @Override
    public List<Membresia> listarMembresias() {
        return data.listarMembresias();
    }

    @Override
    public Membresia findMembresiaById(int id_membresia) {
        return data.findMembresiaById(id_membresia);
    }
    
}
