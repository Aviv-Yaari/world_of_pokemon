package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.BattleException;

public interface IBattleService {
    int getRoundWinner(PokemonType type1, PokemonType type2);
    Trainer doBattle(String trainer1Name, String trainer2Name) throws BattleException;

}
