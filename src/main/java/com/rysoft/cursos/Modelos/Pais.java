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
@Table(name="Pais")
public class Pais {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_pais;
    public String nom_pais;
    public String foto_pais;
    public Integer act_pais;
}
