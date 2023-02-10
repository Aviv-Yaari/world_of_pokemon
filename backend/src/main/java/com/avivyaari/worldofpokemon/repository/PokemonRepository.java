package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findPokemonByNameIs(String name);
}
