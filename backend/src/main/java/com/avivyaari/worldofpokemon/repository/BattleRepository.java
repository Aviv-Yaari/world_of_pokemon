package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Battle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BattleRepository extends JpaRepository<Battle, Long> {
}
