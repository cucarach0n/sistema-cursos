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
@Table(name="Curso_contenido")
public class Curso_contenido {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_curso_contenido;
    public String nom_curso_contenido;
    public String desc_curso_contenido;
    public Integer act_curso_contenido;

    //agregando nuevos campos
    public int horas_contenido;
    public int cantVideos_contenido;
    public int cantEvaluaciones_contenido;
    public int cantMateriales_contenido;
    
    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;

    
    @OneToMany(mappedBy ="curso_contenido", fetch = FetchType.LAZY)
    private List<Unidad> unidades;
}
