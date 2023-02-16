package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import com.avivyaari.worldofpokemon.util.TrainerUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class PokemonServiceTest {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerRepository trainerRepository;

    @Autowired
    PokemonService pokemonService;

    @Autowired
    TrainerUtils trainerUtils;

    @BeforeEach
    void setUp() {
        trainerRepository.deleteAll();
        pokemonRepository.deleteAll();
    }

    @Test
    void whenGettingAllPokemonAndNoPokemonExist_throwNotFoundError() {
        Assertions.assertThrows(CustomEntityNotFoundException.class, () -> pokemonService.getAllPokemon());
    }

    @Test
    void whenGettingPokemon_returnListOfPokemon() throws CustomEntityNotFoundException {
        List<Pokemon> pokemons = trainerUtils.createBag("p", PokemonType.Grass);
        List<Pokemon> pokemonsResponse = pokemonService.getAllPokemon();
        for (int i = 0; i < 3; i++) {
            Pokemon pokemon = pokemons.get(i);
            Pokemon pokemonResponse = pokemonsResponse.get(i);
            Assertions.assertEquals(pokemon.getId(), pokemonResponse.getId());
            Assertions.assertEquals(pokemon.getType(), pokemonResponse.getType());
            Assertions.assertEquals(pokemon.getName(), pokemonResponse.getName());
        }
    }

    @Test
    void whenGettingOnePokemonAndNotFound_throwNotFoundError() {
        Assertions.assertThrows(CustomEntityNotFoundException.class, () -> pokemonService.getPokemon("Some name that doesnt exist"));
    }

    @Test
    void whenGettingOnePokemon_returnPokemon() throws CustomEntityNotFoundException {
        List<Pokemon> pokemon = trainerUtils.createBag("p", PokemonType.Grass);
        Pokemon pokemonResponse = pokemonService.getPokemon("p_1");
        Assertions.assertEquals(pokemon.get(0).getId(), pokemonResponse.getId());
        Assertions.assertEquals(pokemon.get(0).getType(), pokemonResponse.getType());
        Assertions.assertEquals(pokemon.get(0).getName(), pokemonResponse.getName());
    }
}