package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Optional<Pokemon> findPokemonByNameIs(String name);
}
