package com.example.registrocomunidad.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cormobilidad")
public class Cormobilidad implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Boolean diabetes;

    private Boolean cardio;

    private Boolean cerebro;

    private Boolean vih;

    private Boolean cancer;

    private Boolean corticoides;

    private Boolean epoc;

    private Boolean nutricion;

    private Boolean fumador;

    @Column(name="fechareg")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechareg;
    
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Basico basico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(Boolean diabetes) {
        this.diabetes = diabetes;
    }

    public Boolean getCardio() {
        return cardio;
    }

    public void setCardio(Boolean cardio) {
        this.cardio = cardio;
    }

    public Boolean getCerebro() {
        return cerebro;
    }

    public void setCerebro(Boolean cerebro) {
        this.cerebro = cerebro;
    }

    public Boolean getVih() {
        return vih;
    }

    public void setVih(Boolean vih) {
        this.vih = vih;
    }

    public Boolean getCancer() {
        return cancer;
    }

    public void setCancer(Boolean cancer) {
        this.cancer = cancer;
    }

    public Boolean getCorticoides() {
        return corticoides;
    }

    public void setCorticoides(Boolean corticoides) {
        this.corticoides = corticoides;
    }

    public Boolean getEpoc() {
        return epoc;
    }

    public void setEpoc(Boolean epoc) {
        this.epoc = epoc;
    }

    public Boolean getNutricion() {
        return nutricion;
    }

    public void setNutricion(Boolean nutricion) {
        this.nutricion = nutricion;
    }

    public Boolean getFumador() {
        return fumador;
    }

    public void setFumador(Boolean fumador) {
        this.fumador = fumador;
    }

    public Date getFechareg() {
        return fechareg;
    }

    public void setFechareg(Date fechareg) {
        this.fechareg = fechareg;
    }

    public Basico getBasico() {
        return basico;
    }

    public void setBasico(Basico basico) {
        this.basico = basico;
    }

    
}
