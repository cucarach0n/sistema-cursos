/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.InterfaceModelos;

import com.rysoft.cursos.Modelos.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer> {
    @Query(value="SELECT * FROM persona inner join usuario on persona.id_usuario=usuario.id_usuario WHERE persona.verification_code=?1",nativeQuery = true)
    public Persona findByVerificationCode(String code);
    
    @Query(value="SELECT * FROM persona inner join usuario on persona.id_usuario=usuario.id_usuario WHERE usuario.correo_usuario=?1 AND persona.enabled=?2",nativeQuery = true)
    public Persona findByEmailEnable(String email,int enable);
}