/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rysoft.cursos.Modelos;

import java.sql.Date;

import javax.persistence.Column;
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
@Table(name="Cupon_descuento")
public class Cupon_descuento {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_cupondescuento;
    public String desc_cupondescuento;
    public Date fechaRegistro_cupondescuento;
    public Date fechaIni_cupondescuento;
    public Date fechaFin_cupondescuento;
    @Column(unique=true)
    public String codigo_cupondescuento;
    public int cantidadUso_cupondescuento;
    public Float valorDescuento_cupondescuento;
    public int tipoDescuento_cupondescuento;//1=descuento porcentaje, 2=descuento en soles
    public int act_cupondescuento;
    
}
