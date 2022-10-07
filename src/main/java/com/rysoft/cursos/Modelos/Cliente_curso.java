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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cliente_curso")
public class Cliente_curso implements Serializable{
    
    public int act_clientecurso;
    @Id
    @ManyToOne()
    @JoinColumns({@JoinColumn(name="carrito_id_carrito"),@JoinColumn(name="carrito_id_factura")})
    private Carrito carrito;
    
    @Id
    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;
}
