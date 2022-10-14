package com.rysoft.cursos.Modelos;
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
@Table(name="Unidad")
public class Unidad {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_unidad;
    public String nombre_unidad;
    public String descripcion_unidad;
    public Date fechaCreacion_unidad;
    public Integer act_unidad;

    @ManyToOne()
    @JoinColumn(name="id_curso_contenido")
    private Curso_contenido curso_contenido;
}
