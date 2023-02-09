package com.avivyaari.worldofpokemon.entity;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "trainer")
public class Trainer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
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

    public void addPokemon(Pokemon pokemon) {
        if (this.bag == null) {
            this.bag = new LinkedList<>();
        }
        this.bag.add(pokemon);
    }
}
