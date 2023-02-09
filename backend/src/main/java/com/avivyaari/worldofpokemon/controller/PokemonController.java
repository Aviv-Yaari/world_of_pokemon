package com.avivyaari.worldofpokemon.controller;


import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }
    

    @GetMapping("/list")
    public List<Pokemon> getAllPokemon() throws CustomEntityNotFoundException {
        return pokemonService.getAllPokemon();
    }
}
