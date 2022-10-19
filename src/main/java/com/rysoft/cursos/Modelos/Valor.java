package com.rysoft.cursos.Modelos;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Valor")
public class Valor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id_valor;
    public String nombre_valor;
    public String descripcion_valor;
    public String foto_valor;
    public int act_valor;
}
