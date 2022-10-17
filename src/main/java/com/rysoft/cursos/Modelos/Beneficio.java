package com.rysoft.cursos.Modelos;
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
@Table(name="Beneficio")
public class Beneficio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_beneficio;
    public String nombre_beneficio;
    public String desc_beneficio;
    public String foto_beneficio;
    public int act_beneficio;

    @ManyToOne()
    @JoinColumn(name="id_membresia")
    private Membresia membresia;
}
