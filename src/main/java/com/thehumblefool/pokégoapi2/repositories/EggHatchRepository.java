/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.repositories;

import com.thehumblefool.pokégoapi2.models.entities.EggHatchEntityModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface EggHatchRepository extends JpaRepository<EggHatchEntityModel, Integer> {
    
    int countByHatchDistance(int distance);
    
    int countByShinyAvailable(boolean shiny);
    
    @Query("select count(distinct hatchDistance) from EggHatchEntityModel")
    int countDistinctHatchDistance();

    List<EggHatchEntityModel> findByHatchDistance(int eggDistance);

    List<EggHatchEntityModel> findByShinyAvailable(boolean shiny);
    
    @Query("select distinct hatchDistance from EggHatchEntityModel")
    List<Integer> findDistinctHatchDistance();

}
