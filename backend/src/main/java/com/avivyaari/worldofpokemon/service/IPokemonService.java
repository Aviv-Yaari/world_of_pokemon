package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;

import java.util.List;

public interface IPokemonService {
    List<Pokemon> getAllPokemon() throws CustomEntityNotFoundException;
}
