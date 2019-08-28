/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.repositories;

import com.thehumblefool.pokégoapi2.models.entities.RaidEntityModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface RaidRepository extends JpaRepository<RaidEntityModel, Integer> {

    int countByTier(int tier);

    int countByShinyAvailable(boolean shiny);

    @Query("select count(distinct tier) from RaidEntityModel")
    int countDistinctTier();

    List<RaidEntityModel> findByTier(int tier);

    List<RaidEntityModel> findByPokémonStartingWith(String pokémon);

    List<RaidEntityModel> findByGen(int gen);

    List<RaidEntityModel> findByShinyAvailable(boolean shiny);

    @Query("select raids from RaidEntityModel raids where ':type' IN (type_1,type_2)")
    List<RaidEntityModel> findInType1Type2(String type);

    @Query("select distinct tier from RaidEntityModel")
    List<Integer> findDistinctTier();
}
