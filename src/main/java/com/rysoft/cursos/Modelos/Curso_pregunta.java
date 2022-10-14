package com.rysoft.cursos.Modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Curso_pregunta")
public class Curso_pregunta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) /* Autoincremental */
    public int id_curso_pregunta;

    @ManyToOne()
    @JoinColumn(name="id_curso")
    private Curso curso;
    
    @ManyToOne()
    @JoinColumn(name="id_pregunta")
    private Pregunta pregunta;
}
