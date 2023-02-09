package com.avivyaari.worldofpokemon.entity;
import jakarta.persistence.*;

/**
 * Pokémon are creatures of all shapes and sizes who live in the wild or alongside humans.
 * For the most part, Pokémon do not speak except to utter their names.
 * There are currently more than 700 creatures that inhabit the Pokémon universe.
 */
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private PokemonType type;

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

