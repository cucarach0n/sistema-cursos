package com.rysoft.cursos.entidades;

import java.util.List;

import com.rysoft.cursos.Modelos.Curso;

public class CategoriaCursos {
    public int id_categoria;
    public String nom_categoria;
    public Integer act_categoria;
    public List<Curso> cursos;
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getNom_categoria() {
        return nom_categoria;
    }
    public void setNom_categoria(String nom_categoria) {
        this.nom_categoria = nom_categoria;
    }
    public Integer getAct_categoria() {
        return act_categoria;
    }
    public void setAct_categoria(Integer act_categoria) {
        this.act_categoria = act_categoria;
    }
    public List<Curso> getCursos() {
        return cursos;
    }
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
