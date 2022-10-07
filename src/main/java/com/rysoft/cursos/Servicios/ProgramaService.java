package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.IPrograma;
import com.rysoft.cursos.Interfaces.IProgramaService;
import com.rysoft.cursos.Modelos.Programa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramaService implements IProgramaService {
    @Autowired
    private IPrograma data;
    
    @Override
    public List<Programa> listarProgramas() {
        return data.listarProgramas();
    }
    
}
