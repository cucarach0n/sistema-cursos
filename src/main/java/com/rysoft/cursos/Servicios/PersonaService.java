/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Servicios;

import com.rysoft.cursos.InterfaceModelos.IPersona;
import com.rysoft.cursos.Interfaces.IPersonaService;
import com.rysoft.cursos.Modelos.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private IPersona data;
    
    @Override
    public void Guardar(Persona p) {
        data.save(p);
    }

    @Override
    public Persona findByVerificationCode(String code) {
       return data.findByVerificationCode(code); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona findByEmailEnable(String email, int enable) {
         return data.findByEmailEnable(email, enable);
    }
}
