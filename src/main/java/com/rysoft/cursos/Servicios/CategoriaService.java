package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.ICategoria;
import com.rysoft.cursos.Interfaces.ICategoriaService;
import com.rysoft.cursos.Modelos.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoria data;
    
    @Override
    public List<Categoria> listarCategorias() {
        return data.listarCategorias();
    }
    @Override
    public List<Categoria> listarCategoriasLimite( int limite){
        return data.listarCategoriasLimite(limite);
    }
    
}