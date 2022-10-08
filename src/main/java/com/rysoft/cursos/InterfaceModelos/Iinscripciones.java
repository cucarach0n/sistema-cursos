/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.InterfaceModelos;

import com.rysoft.cursos.Modelos.Inscripciones;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface Iinscripciones extends CrudRepository<Inscripciones,Integer> {
    
}
