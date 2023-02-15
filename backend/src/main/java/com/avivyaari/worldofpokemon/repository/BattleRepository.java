package com.avivyaari.worldofpokemon.repository;

import com.avivyaari.worldofpokemon.entity.Battle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Long> {
}
