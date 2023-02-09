package com.avivyaari.worldofpokemon.dto;

import com.avivyaari.worldofpokemon.entity.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class TrainerResponse {
    private String name;
    private int level;
    private List<String> bag;
    
    public TrainerResponse(String name, int level, List<Pokemon> bag) {
        this.name = name;
        this.level = level;
        this.bag = bag.stream().map(Pokemon::getName).collect(Collectors.toList());
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

    public List<String> getBag() {
        return bag;
    }

    public void setBag(List<String> bag) {
        this.bag = bag;
    }
}
