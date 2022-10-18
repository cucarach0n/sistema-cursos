package com.rysoft.cursos.Entidades;

public class ProgramasCursos {
    public int id_programa;
    public float descu_programa;
    public String nom_programa;
    public Float prec_programa;
    public String desc_programa;
    public String foto_programa;
    public Float vigencia_programa;
    public Integer act_programa;
    public int cantCurso_programa;

    public ProgramasCursos() {
    }

    public ProgramasCursos(int id_programa, float descu_programa, String nom_programa, Float prec_programa, String desc_programa, String foto_programa, Float vigencia_programa, Integer act_programa, int cantCurso_programa) {
        this.id_programa = id_programa;
        this.descu_programa = descu_programa;
        this.nom_programa = nom_programa;
        this.prec_programa = prec_programa;
        this.desc_programa = desc_programa;
        this.foto_programa = foto_programa;
        this.vigencia_programa = vigencia_programa;
        this.act_programa = act_programa;
        this.cantCurso_programa = cantCurso_programa;
    }
    
    public int getId_programa() {
        return id_programa;
    }
    public void setId_programa(int id_programa) {
        this.id_programa = id_programa;
    }
    public float getDescu_programa() {
        return descu_programa;
    }
    public void setDescu_programa(float descu_programa) {
        this.descu_programa = descu_programa;
    }
    public String getNom_programa() {
        return nom_programa;
    }
    public void setNom_programa(String nom_programa) {
        this.nom_programa = nom_programa;
    }
    public Float getPrec_programa() {
        return prec_programa;
    }
    public void setPrec_programa(Float prec_programa) {
        this.prec_programa = prec_programa;
    }
    public String getDesc_programa() {
        return desc_programa;
    }
    public void setDesc_programa(String desc_programa) {
        this.desc_programa = desc_programa;
    }
    public String getFoto_programa() {
        return foto_programa;
    }
    public void setFoto_programa(String foto_programa) {
        this.foto_programa = foto_programa;
    }
    public Float getVigencia_programa() {
        return vigencia_programa;
    }
    public void setVigencia_programa(Float vigencia_programa) {
        this.vigencia_programa = vigencia_programa;
    }
    public Integer getAct_programa() {
        return act_programa;
    }
    public void setAct_programa(Integer act_programa) {
        this.act_programa = act_programa;
    }
    public int getCantCurso_programa() {
        return cantCurso_programa;
    }
    public void setCantCurso_programa(int cantCurso_programa) {
        this.cantCurso_programa = cantCurso_programa;
    }
}
