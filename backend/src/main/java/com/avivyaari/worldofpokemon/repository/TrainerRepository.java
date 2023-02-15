package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    Optional<Trainer> findTrainerByNameIs(String name);

    List<Trainer> findTrainersByNameIn(Set<String> names);
}
