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
@Table(name="factura_detalle")
public class Factura_detalle {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_factura;
    public String email_factura;
    public String direccion_factura;
    public String localidad_factura;
    public String nombres_factura;
    public String apellidos_factura;
    public String telefono_factura;
    public Integer act_factura;
}
