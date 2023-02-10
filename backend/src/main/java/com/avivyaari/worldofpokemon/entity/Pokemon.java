package com.avivyaari.worldofpokemon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private PokemonType type;

    @ManyToMany(mappedBy = "bag")
    @JsonIgnore
    private List<Trainer> owners;

    @JsonProperty("owners")
    public int getOwnerCount() {
        return owners.size();
    }

    public Pokemon() {
    }

    public Pokemon(String name, PokemonType type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokemonType getType() {
        return type;
    }

    public void setType(PokemonType type) {
        this.type = type;
    }

}

