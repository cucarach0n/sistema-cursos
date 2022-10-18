/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* Autoincremental */
    public int id_usuario;
    public String nombre_usuario;
    public String direccion_usuario;
    public String correo_usuario;
    public String telefono_usuario;
    public String contrasena_usuario;

    public Date fechaAct_usuario;

    public Integer tipoUsuario_usuario;
    public Integer act_usuario;

    @OneToOne(mappedBy = "usuario")
    private Persona persona;

    public Usuario() {
    }

    public Usuario(String nombre_usuario, String direccion_usuario, String correo_usuario, String telefono_usuario, String contrasena_usuario, Integer tipoUsuario_usuario, Integer act_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.direccion_usuario = direccion_usuario;
        this.correo_usuario = correo_usuario;
        this.telefono_usuario = telefono_usuario;
        this.contrasena_usuario = contrasena_usuario;
        this.tipoUsuario_usuario = tipoUsuario_usuario;
        this.act_usuario = act_usuario;
    }
}
