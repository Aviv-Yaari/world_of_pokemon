package com.avivyaari.worldofpokemon.service;


import com.avivyaari.worldofpokemon.entity.Trainer;

import java.util.List;
import java.util.Set;

public interface ITrainerService {
    List<Trainer> getTrainers();
    Trainer getTrainerById(Long id);
    List<Trainer> getTrainersForBattle(Set<String> names);

}
