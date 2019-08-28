/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.repositories;

import com.thehumblefool.pokégoapi2.models.entities.ResearchBreakthroughEncounterEntityModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface ResearchBreakthroughEncounterRepository extends JpaRepository<ResearchBreakthroughEncounterEntityModel, Integer> {

    int countByShinyAvailable(boolean shiny);

    List<ResearchBreakthroughEncounterEntityModel> findByPokémonStartingWith(String pokémon);

    List<ResearchBreakthroughEncounterEntityModel> findByShinyAvailable(boolean shiny);
}
