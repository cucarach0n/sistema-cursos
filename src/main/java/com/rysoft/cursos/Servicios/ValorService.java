package com.rysoft.cursos.Servicios;
import com.rysoft.cursos.InterfaceModelos.IValor;
import com.rysoft.cursos.Interfaces.IValorService;
import com.rysoft.cursos.Modelos.Valor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValorService implements IValorService {
    @Autowired
    private IValor data;

    public List<Valor> listarValores() {
        return data.listarValores();
    }
}
