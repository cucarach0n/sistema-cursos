/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rysoft.cursos.Modelos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author USER
 */

@Data
@Entity
@Table(name="Inscripciones")
public class Inscripciones {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id_inscripcion;
    public String nombres;
    public String apellidos;
    public String celular;
    public String email;

    public Inscripciones() {
    }

    public Inscripciones(String nombres, String apellidos, String celular, String email, Curso curso) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.email = email;
        this.curso = curso;
    }
    
    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;
}
