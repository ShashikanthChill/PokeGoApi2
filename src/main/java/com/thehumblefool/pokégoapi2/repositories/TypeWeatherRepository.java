/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.repositories;

import com.thehumblefool.pokégoapi2.models.entities.TypeWeatherEntityModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */
@Repository
public interface TypeWeatherRepository extends JpaRepository<TypeWeatherEntityModel, Integer> {

    @Query("select weather from TypeWeatherEntityModel where type=:type")
    String findWeatherByType(String type);

    @Query("select count (distinct weather) from TypeWeatherEntityModel")
    int countDistinctWeather();

    @Query("select distinct weather from TypeWeatherEntityModel")
    List<String> findDistinctWeather();
}
