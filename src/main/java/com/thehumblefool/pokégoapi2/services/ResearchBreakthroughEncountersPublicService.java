/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.thehumblefool.pokégoapi2.models.api.ResearchBreakthroughEncountersApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.ResearchBreakthroughEncounterDTOModel;
import com.thehumblefool.pokégoapi2.models.entities.ResearchBreakthroughEncounterEntityModel;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thehumblefool.pokégoapi2.repositories.ResearchBreakthroughEncounterRepository;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class ResearchBreakthroughEncountersPublicService {

    private final ResearchBreakthroughEncounterRepository repo;

    @Autowired
    public ResearchBreakthroughEncountersPublicService(ResearchBreakthroughEncounterRepository repo) {
        this.repo = repo;
    }

    public ResearchBreakthroughEncountersApiModel loadAllEncountersMeta() {
        return new ResearchBreakthroughEncountersApiModel(repo.count(), repo.countByShinyAvailable(true), repo.countByShinyAvailable(false), null);
    }

    public ResearchBreakthroughEncountersApiModel loadAllEncounters() {
        List<ResearchBreakthroughEncounterEntityModel> researchBreakthroughEncounterEntityModels = repo.findAll();
        List<ResearchBreakthroughEncounterDTOModel> researchBreakthroughEncounterDTOModels = researchBreakthroughEncounterEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        ResearchBreakthroughEncountersApiModel apiModel = loadAllEncountersMeta();
        apiModel.setEncounters(researchBreakthroughEncounterDTOModels);
        return apiModel;
    }

    public List<ResearchBreakthroughEncounterDTOModel> loadEncountersByName(String pokémon) {
        List<ResearchBreakthroughEncounterEntityModel> researchBreakthroughEncounterEntityModels = repo.findByPokémonStartingWith(pokémon);
        List<ResearchBreakthroughEncounterDTOModel> researchBreakthroughEncounterDTOModels = researchBreakthroughEncounterEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return researchBreakthroughEncounterDTOModels;
    }

    public List<ResearchBreakthroughEncounterDTOModel> loadEncountersByShiny(boolean shiny) {
        List<ResearchBreakthroughEncounterEntityModel> researchBreakthroughEncounterEntityModels = repo.findByShinyAvailable(shiny);
        List<ResearchBreakthroughEncounterDTOModel> researchBreakthroughEncounterDTOModels = researchBreakthroughEncounterEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return researchBreakthroughEncounterDTOModels;
    }

    private ResearchBreakthroughEncounterDTOModel mapEntityToDto(ResearchBreakthroughEncounterEntityModel entityModel) {
        List<String> types = new ArrayList<>();
        types.add(entityModel.getType1());
        if (!entityModel.getType2().isBlank() && entityModel.getType2() != null) {
            types.add(entityModel.getType2());
        }
        return new ResearchBreakthroughEncounterDTOModel(entityModel.getPokéDex(), entityModel.getPokémon(), types, entityModel.getMinCp(), entityModel.getMaxCp(), entityModel.getShinyAvailable());
    }
}
