package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findPokemonByNameIs(String name);
}
