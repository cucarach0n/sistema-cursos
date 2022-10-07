/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

@Data
@Entity
@Table(name="programa_curso")
public class Programa_curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_programa_curso;
    public int act_programa_curso;
    @ManyToOne()
    @JoinColumn(name="id_programa")
    private Programa programa;
    
    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;
}
