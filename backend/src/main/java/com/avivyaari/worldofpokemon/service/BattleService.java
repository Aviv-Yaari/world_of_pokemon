package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.dto.BattleResult;
import com.avivyaari.worldofpokemon.dto.BattleStatus;
import com.avivyaari.worldofpokemon.entity.*;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BattleService implements IBattleService {
    private TrainerRepository trainerRepository;

    @Autowired
    public BattleService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    /** @return if type1 won, will return 1. if type2 won, will return 2. In case of a draw - will return 0. */
    public int getTypeWinner(PokemonType type1, PokemonType type2) {
        if (type1.equals(PokemonType.Water) && type2.equals(PokemonType.Fire)) {
            return 1;
        }
        if (type1.equals(PokemonType.Fire) && type2.equals(PokemonType.Grass)) {
            return 1;
        }
        if (type1.equals(PokemonType.Grass) && type2.equals(PokemonType.Water)) {
            return 1;
        }
        if (type1.equals(type2)) {
            return 0;
        }
        return 2;
    }
    
    @Override
    public BattleResult doBattle(String trainer1Name, String trainer2Name) {
        try {
            List<Trainer> trainers = trainerRepository.findTrainersByNameIn(Set.of(trainer1Name, trainer2Name));
            if (trainers.get(0).getBag().size() < 3 || trainers.get(1).getBag().size() < 3) {
                return new BattleResult(BattleStatus.Error, "Cancelled - both trainers must have at least 3 pokemon in the bag");
            }
            int trainer1Wins = 0;
            int trainer2Wins = 0;
            String message = "draw";
            for (int round = 0; round < 3; round++) {
                Pokemon trainer1sPokemon = trainers.get(0).getBag().get(round);
                Pokemon trainer2sPokemon = trainers.get(1).getBag().get(round);
                int winner = getTypeWinner(trainer1sPokemon.getType(), trainer2sPokemon.getType());
                if (winner == 1) {
                    trainer1Wins++;
                }
                else if (winner == 2) {
                    trainer2Wins++;
                }
            }
            if (trainer1Wins > trainer2Wins) {
                message = trainer1Name + " wins";
            }
            else if (trainer2Wins > trainer1Wins){
                message = trainer2Name + " wins";
            }
            return new BattleResult(trainer1Wins == trainer2Wins ? BattleStatus.Draw : BattleStatus.Success, message);
        } catch (Exception e) {
            return new BattleResult(BattleStatus.Error, "An unexpected error occurred");
        }
    }
}
