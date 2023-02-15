package com.avivyaari.worldofpokemon.service;

import com.avivyaari.worldofpokemon.entity.Battle;
import com.avivyaari.worldofpokemon.entity.Pokemon;
import com.avivyaari.worldofpokemon.entity.PokemonType;
import com.avivyaari.worldofpokemon.entity.Trainer;
import com.avivyaari.worldofpokemon.exception.BattleException;
import com.avivyaari.worldofpokemon.exception.CustomEntityNotFoundException;
import com.avivyaari.worldofpokemon.repository.BattleRepository;
import com.avivyaari.worldofpokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BattleService implements IBattleService {
    private final TrainerRepository trainerRepository;
    private final BattleRepository battleRepository;

    @Autowired
    public BattleService(TrainerRepository trainerRepository, BattleRepository battleRepository) {
        this.trainerRepository = trainerRepository;
        this.battleRepository = battleRepository;
    }

    /**
     * @return if type1 won, will return 1. if type2 won, will return 2. In case of a draw - will return 0.
     */
    public int getRoundWinner(PokemonType type1, PokemonType type2) {
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
    public Trainer doBattle(String trainer1Name, String trainer2Name) throws BattleException, CustomEntityNotFoundException {
        if (trainer1Name.equals(trainer2Name)) {
            throw new BattleException("A trainer can't fight himself/herself!", HttpStatus.BAD_REQUEST);
        }
        List<Trainer> trainers = trainerRepository.findTrainersByNameIn(Set.of(trainer1Name, trainer2Name));
        if (trainers.isEmpty() || trainers.size() < 2) {
            throw new CustomEntityNotFoundException("Trainers not found");
        }
        Trainer trainer1 = trainers.get(0);
        Trainer trainer2 = trainers.get(1);
        Battle battle = new Battle(trainer1, trainer2, null);
        if (trainer1.getBag().size() < 3 || trainer2.getBag().size() < 3) {
            throw new BattleException("Cancelled - both trainers must have at least 3 pokemon in the bag", HttpStatus.BAD_REQUEST);
        }
        int trainer1Wins = 0;
        int trainer2Wins = 0;
        for (int round = 0; round < 3; round++) {
            Pokemon trainer1sPokemon = battle.getTrainer1().getBag().get(round);
            Pokemon trainer2sPokemon = battle.getTrainer2().getBag().get(round);
            int roundWinner = getRoundWinner(trainer1sPokemon.getType(), trainer2sPokemon.getType());
            if (roundWinner == 1) {
                trainer1Wins++;
            } else if (roundWinner == 2) {
                trainer2Wins++;
            }
        }

        Trainer winner = null;
        if (trainer1Wins != trainer2Wins) {
            winner = trainer1Wins > trainer2Wins ? trainer1 : trainer2;
            winner.setLevel(winner.getLevel() + 1);
        }
        battle.setWinner(winner);
        battleRepository.save(battle);
        return winner;
    }
}
