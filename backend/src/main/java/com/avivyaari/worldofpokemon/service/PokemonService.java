package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService implements IPokemonService {

    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public List<Pokemon> getAllPokemon() throws CustomEntityNotFoundException {
        List<Pokemon> pokemon = pokemonRepository.findAll();
        if (pokemon.isEmpty()) {
            throw new CustomEntityNotFoundException("Pokemon not found");
        }
        return pokemon;
    }

    @Override
    public Pokemon getPokemon(String name) throws CustomEntityNotFoundException {
        Pokemon pokemon = pokemonRepository.findPokemonByNameIs(name)
                .orElseThrow(() -> new CustomEntityNotFoundException("Pokemon not found"));
        return pokemon;
    }
}
