package com.rysoft.cursos.entidades;

public class ServicioCarrito {
    public Integer id_servicio;
    public Integer tipoServicio;//1: curso, 2: membresia, 3: programa
    public String nombreServicio;
    public Float precioServicio;
    public String fotoServicio;
    public Integer getId_servicio() {
        return id_servicio;
    }
    public void setId_servicio(Integer id_servicio) {
        this.id_servicio = id_servicio;
    }
    public Integer getTipoServicio() {
        return tipoServicio;
    }
    public void setTipoServicio(Integer tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    public String getNombreServicio() {
        return nombreServicio;
    }
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }
    public Float getPrecioServicio() {
        return precioServicio;
    }
    public void setPrecioServicio(Float precioServicio) {
        this.precioServicio = precioServicio;
    }
    public String getFotoServicio() {
        return fotoServicio;
    }
    public void setFotoServicio(String fotoServicio) {
        this.fotoServicio = fotoServicio;
    }
}
