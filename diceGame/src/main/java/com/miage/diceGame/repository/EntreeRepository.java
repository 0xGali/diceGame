package com.miage.diceGame.repository;

import com.miage.diceGame.model.Entree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntreeRepository extends JpaRepository<Entree,Integer> {

    @Query(value = "SELECT * FROM entree DESC score LIMIT 10", nativeQuery = true)
    public List<Entree> getHighscore();
}
