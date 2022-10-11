package com.rysoft.cursos.Entidades;

import java.util.List;

public class Carrito {
    public int id_carrito;
    public String fecha_compra_carrito;
    public String metodo_pago_carrito;
    public Float monto_total_carrito;
    public int cant_servicios_carrito;
    public Float dsco_carrito;
    public Integer act_carrito;
    public Integer id_usuario;
    public Integer id_cuponDescuento;
    public Integer id_factura;
    List<ServicioCarrito> servicios;
    public int getId_carrito() {
        return id_carrito;
    }
    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }
    public String getFecha_compra_carrito() {
        return fecha_compra_carrito;
    }
    public void setFecha_compra_carrito(String fecha_compra_carrito) {
        this.fecha_compra_carrito = fecha_compra_carrito;
    }
    public String getMetodo_pago_carrito() {
        return metodo_pago_carrito;
    }
    public void setMetodo_pago_carrito(String metodo_pago_carrito) {
        this.metodo_pago_carrito = metodo_pago_carrito;
    }
    public Float getMonto_total_carrito() {
        return monto_total_carrito;
    }
    public void setMonto_total_carrito(Float monto_total_carrito) {
        this.monto_total_carrito = monto_total_carrito;
    }
    public Float getDsco_carrito() {
        return dsco_carrito;
    }
    public void setDsco_carrito(Float dsco_carrito) {
        this.dsco_carrito = dsco_carrito;
    }
    public Integer getAct_carrito() {
        return act_carrito;
    }
    public void setAct_carrito(Integer act_carrito) {
        this.act_carrito = act_carrito;
    }
    public Integer getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Integer getId_cuponDescuento() {
        return id_cuponDescuento;
    }
    public void setId_cuponDescuento(Integer id_cuponDescuento) {
        this.id_cuponDescuento = id_cuponDescuento;
    }
    public Integer getId_factura() {
        return id_factura;
    }
    public void setId_factura(Integer id_factura) {
        this.id_factura = id_factura;
    }
    public List<ServicioCarrito> getServicios() {
        return servicios;
    }
    public void setServicios(List<ServicioCarrito> servicios) {
        this.servicios = servicios;
    }
    public int getCant_servicios_carrito() {
        return cant_servicios_carrito;
    }
    public void setCant_servicios_carrito(int cant_servicios_carrito) {
        this.cant_servicios_carrito = cant_servicios_carrito;
    }
}
