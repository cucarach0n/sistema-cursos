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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Persona")
public class Persona implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_persona;
    public String nom_persona;
    public String ape_persona;
    public String dni_persona;
    public String desc_persona;
    public String foto_persona;
    public Integer cel_persona;
    
    @ManyToOne()
    @JoinColumn(name="id_pais")
    private Pais pais;
    
    
    @Id
    @OneToOne()
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
}
