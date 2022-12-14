/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_curso;
    public String nom_curso;
    public String desc_curso;
    public Float dur_curso;
    public Float prec_curso;
    public Float descto_curso;
    public String foto_curso;
    public Integer act_curso;

    //agregando nuevos campos
    public int cantMateriales_curso;
    public int horas_curso;
    public String video_curso;
    
    @ManyToOne()
    @JoinColumn(name="id_categoria")
    private Categoria categoria;

    @OneToMany(mappedBy ="curso", fetch = FetchType.LAZY)
    private List<Curso_contenido> contenidos;

    @OneToMany(mappedBy ="curso", fetch = FetchType.LAZY)
    private List<Curso_pregunta> preguntas;

    @OneToMany(mappedBy ="curso", fetch = FetchType.LAZY)
    private List<Docente_curso> docentesCursos;
}
