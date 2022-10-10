package com.rysoft.cursos.Interfaces;
import com.rysoft.cursos.Modelos.Programa;
import java.util.List;
public interface IProgramaService {
    public List<Programa> listarProgramas();
    public Programa findProgramaById(int id_programa);
}
