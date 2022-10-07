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
@Table(name="Carrito")
public class Carrito implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_carrito;
    public String fecha_compra_carrito;
    public String metodo_pago_carrito;
    public Float monto_total_carrito;
    public Float dsco_carrito;
    public Integer act_carrito;
    
    @ManyToOne()
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    
    @ManyToOne()
    @JoinColumn(name="id_cuponDescuento")
    private Cupon_descuento cupon_descuento;
    
    @Id
    @OneToOne()
    @JoinColumn(name="id_factura")
    private Factura_detalle factura;
    
}
