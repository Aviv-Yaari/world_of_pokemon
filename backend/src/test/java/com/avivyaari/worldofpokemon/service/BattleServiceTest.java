package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.BattleException;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.repository.PokemonRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import com.avivyaari.worldofpokemon.util.TrainerUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class BattleServiceTest {

    @Autowired
    TrainerRepository trainerRepository;
    @Autowired
    BattleService battleService;

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    TrainerUtils trainerUtils;

    @AfterEach
    void tearDown() {
        trainerRepository.deleteAll();
        pokemonRepository.deleteAll();
    }

    @Test
    public void whenTrainer1EqualsTrainer2_throwError() {
        Trainer trainer = new Trainer("trainer", 12, null);
        trainerRepository.save(trainer);
        Assertions.assertThrows(BattleException.class, () -> battleService.doBattle(trainer.getName(), trainer.getName()));
    }

    @Test
    public void whenTrainerDoesntExist_throwError() {
        Assertions.assertThrows(CustomEntityNotFoundException.class, () -> battleService.doBattle("IDontExist1", "IDontExist2"));
    }

    @Test
    @Transactional
    public void whenUsingValidData_returnExpectedResult() throws BattleException, CustomEntityNotFoundException {
        List<Pokemon> bag1 = trainerUtils.createBag("bag1", PokemonType.Water);
        List<Pokemon> bag2 = trainerUtils.createBag("bag2", PokemonType.Fire);
        Trainer trainer1 = trainerUtils.createTrainer("trainer1", bag1);
        Trainer trainer2 = trainerUtils.createTrainer("trainer2", bag2);
        Trainer winner = battleService.doBattle(trainer1.getName(), trainer2.getName());
        Assertions.assertEquals(trainer1.getName(), winner.getName()); // water beats fire, trainer1 should win.
    }
}
