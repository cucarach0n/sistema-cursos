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
@Table(name="Biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_biblioteca;
    public Integer diasSus_biblioteca;
    public Integer fechaSus_biblioteca;
    
    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;
    
    @ManyToOne()
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
}
