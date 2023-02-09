package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.dto.BattleResult;
import com.avivyaari.worldofpokemon.entity.PokemonType;

public interface IBattleService {
    int getTypeWinner(PokemonType type1, PokemonType type2);
    BattleResult doBattle(String trainer1Name, String trainer2Name);

}
