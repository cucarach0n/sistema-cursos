package com.rysoft.cursos.Interfaces;

import java.util.List;
import com.rysoft.cursos.Modelos.Membresia;

public interface IMembresiaService {
    public List<Membresia> listarMembresias();
    public Membresia findMembresiaById(int id_membresia);
}
