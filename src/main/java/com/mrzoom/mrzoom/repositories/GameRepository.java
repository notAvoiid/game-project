package com.mrzoom.mrzoom.repositories;

import com.mrzoom.mrzoom.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
