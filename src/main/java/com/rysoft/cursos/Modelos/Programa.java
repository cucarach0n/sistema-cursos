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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Programa")
public class Programa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_programa;
    public float descu_programa;
    public String nom_programa;
    public Float prec_programa;
    public String desc_programa;
    public String foto_programa;
    public Float vigencia_programa;

    public String video_programa;

    public Integer act_programa;

    @OneToMany(mappedBy ="programa", fetch = FetchType.LAZY)
    private List<Programa_curso> cursos;

    @OneToMany(mappedBy ="programa", fetch = FetchType.LAZY)
    private List<Programa_pregunta> preguntas;
}
