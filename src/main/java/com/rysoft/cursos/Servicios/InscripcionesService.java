/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Servicios;

import com.rysoft.cursos.InterfaceModelos.Iinscripciones;
import com.rysoft.cursos.Interfaces.IinscripcionesService;
import com.rysoft.cursos.Modelos.Inscripciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class InscripcionesService implements IinscripcionesService {
    @Autowired
    private Iinscripciones data;
    
    @Override
    public void Guardar(Inscripciones p) {
        data.save(p);
    }
}
