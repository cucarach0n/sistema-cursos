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
@Table(name="Membresia")
public class Membresia {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_membresia;
    public String nom_membresia;
    public String desc_membresia;
    public Float prec_membresia;
    public Float dscto_membresia;
    public String foto_membresia;
    public Integer tiempo_membresia;
    public Integer tipoTiempo_membresia;
    public Integer act_membresia;
    @OneToMany(mappedBy ="membresia", fetch = FetchType.LAZY)
    private List<Beneficio> beneficios;
}
