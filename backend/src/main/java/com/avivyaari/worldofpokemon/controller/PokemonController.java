package com.avivyaari.worldofpokemon.controller;


import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Pokemon controller
 */
@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private

    @Autowired
    PokemonRepository pokemonRepository;

    @GetMapping("/list")
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();
    }
}
