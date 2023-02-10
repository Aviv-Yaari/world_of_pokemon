package com.avivyaari.worldofpokemon.entity;

import com.avivyaari.worldofpokemon.exception.CustomEntityExistsException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    int level;
    @ManyToMany
    @JoinTable(name = "trainer_pokemon", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    List<Pokemon> bag;

    public Trainer(String name, int level, List<Pokemon> bag) {
        this.name = name;
        this.level = level;
        this.bag = bag;
    }

    public Trainer() {

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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Pokemon> getBag() {
        return bag;
    }

    public void setBag(List<Pokemon> bag) {
        this.bag = bag;
    }

    public void addPokemon(Pokemon pokemon) throws CustomEntityExistsException {
        if (this.bag == null) {
            this.bag = new LinkedList<>();
        }
        if (this.bag.stream().anyMatch(p -> p.getId().equals(pokemon.getId()))) {
            throw new CustomEntityExistsException(pokemon.getName() + " already exists in the bag");
        }
        if (this.bag.size() == 3) {
            this.bag.remove(2);
        }
        this.bag.add(0, pokemon);
    }
}
