package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Trainer findAllById(Long id);
    
    List<Trainer> findAllByNameIn(Set<String> names);
}
