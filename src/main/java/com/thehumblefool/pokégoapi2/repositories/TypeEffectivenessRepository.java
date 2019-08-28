/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.repositories;

import com.thehumblefool.pokégoapi2.models.entities.TypeEffectivenessEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author The_Humble_Fool
 */

@Repository
public interface TypeEffectivenessRepository extends JpaRepository<TypeEffectivenessEntityModel, Integer>
{

    public TypeEffectivenessEntityModel findByType(String type);
}
