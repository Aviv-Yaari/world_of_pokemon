package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.dto.BattleStatus;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.exception.BattleException;

public interface IBattleService {
    int getTypeWinner(PokemonType type1, PokemonType type2);
    BattleStatus doBattle(String trainer1Name, String trainer2Name) throws BattleException;

}
