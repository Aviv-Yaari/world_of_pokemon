package com.avivyaari.worldofpokemon.dto;

import com.avivyaari.worldofpokemon.entity.Pokemon;

import java.util.List;

public class BagResponse {
    private List<Pokemon> bag;
    public BagResponse(List<Pokemon> bag) {
        this.bag = bag;
    }

    public List<Pokemon> getBag() {
        return bag;
    }

    public void setBag(List<Pokemon> bag) {
        this.bag = bag;
    }
}
