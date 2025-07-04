package com.ana.herosbackend.domain.model;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Superpoderes")
public class Superpoderes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String superpoder;

    @Column(length = 250)
    private String descricao;

    @ManyToMany(mappedBy = "superpoderes")
    private List<Herois> herois = new ArrayList<>();


    public Superpoderes(Long id, String superpoder, String descricao, List<Herois> herois) {
        this.id = id;
        this.superpoder = superpoder;
        this.descricao = descricao;
        this.herois = herois;
    }

    public Superpoderes() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Herois> getHerois() {
        return herois;
    }

    public void setHerois(List<Herois> herois) {
        this.herois = herois;
    }
}
