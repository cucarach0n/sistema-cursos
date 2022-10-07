/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;

import java.io.Serializable;
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
@Table(name="estudiante_programa")
public class Estudiante_programa implements Serializable{
    
    
    public String diasSus_estudiantePrograma;
    public String fechaSus_estudiantePrograma;
    
    @Id
    @ManyToOne()
    @JoinColumn(name="usuario_id_usaurio")
    private Usuario usuario;
    
    @Id
    @ManyToOne()
    @JoinColumn(name="programa_id_programa")
    private Programa programa;
}
