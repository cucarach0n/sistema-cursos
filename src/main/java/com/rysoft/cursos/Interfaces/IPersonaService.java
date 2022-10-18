/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Interfaces;

import com.rysoft.cursos.Modelos.Persona;

/**
 *
 * @author USER
 */
public interface IPersonaService {
    public void Guardar(Persona p);
    public Persona findByVerificationCode(String code);
    public Persona findByEmailEnable(String email,int enable);
}
