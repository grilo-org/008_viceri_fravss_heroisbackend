package com.ana.herosbackend.domain.model;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "Herois")
public class Herois implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 120)
    private String nome;

    @Column(unique=true, length = 120)
    private String nomeHeroi;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    @ManyToMany
    @JoinTable(
            name = "heroisSuperpoderes",
            joinColumns = @JoinColumn(name = "heroiId"),
            inverseJoinColumns = @JoinColumn(name = "superpoderId")
    )
    private List<Superpoderes> superpoderes;

    private float altura;

    private float peso;

    public Herois(Long id, String nome, String nomeHeroi, Date dataNascimento, List<Superpoderes> superpoderes, float altura, float peso) {
        this.id = id;
        this.nome = nome;
        this.nomeHeroi = nomeHeroi;
        this.dataNascimento = dataNascimento;
        this.superpoderes = superpoderes;
        this.altura = altura;
        this.peso = peso;
    }

    public Herois() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Superpoderes> getSuperpoderes() {
        return superpoderes;
    }

    public void setSuperpoderes(List<Superpoderes> superpoderes) {
        this.superpoderes = superpoderes;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
}
