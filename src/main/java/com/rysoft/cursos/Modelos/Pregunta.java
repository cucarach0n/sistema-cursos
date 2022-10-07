/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Pregunta")
public class Pregunta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_programa;
    public String pregunta_pregunta;
    public String respuesta_pregunta;
    public Integer act_programa;
}
