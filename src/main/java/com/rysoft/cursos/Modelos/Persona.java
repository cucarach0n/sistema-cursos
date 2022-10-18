/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
    public String cel_persona;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    @ManyToOne()
    @JoinColumn(name="id_pais")
    private Pais pais;
    
    @Column(name = "verification_code", length = 64)
    public String verificationCode;
    private boolean enabled;

    public Persona() {
    }

    public Persona(String nom_persona, String ape_persona, String dni_persona, String foto_persona, String cel_persona, /*String verificationCode, boolean enabled, Pais pais,*/ Usuario usuario) {
        this.nom_persona = nom_persona;
        this.ape_persona = ape_persona;
        this.dni_persona = dni_persona;
        this.foto_persona = foto_persona;
        this.cel_persona = cel_persona;
        // this.verificationCode = verificationCode;
        //this.enabled = enabled;

        this.usuario = usuario;
    }

    public String getFullName() {
        return this.nom_persona + " " + this.ape_persona;
    }
    
}
