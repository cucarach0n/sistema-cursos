/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;

import java.io.Serializable;
import java.sql.Date;
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
@Table(name="estudiante_membresia")
public class Estudiante_membresia implements Serializable {
    public Date fechaIni_estudiantemembresia;
    @Id
    @ManyToOne()
    @JoinColumn(name="usuario_id_usuario")
    private Usuario usuario;
    
    @Id
    @ManyToOne()
    @JoinColumn(name="membresia_id_membresia")
    private Membresia membresia;
}
