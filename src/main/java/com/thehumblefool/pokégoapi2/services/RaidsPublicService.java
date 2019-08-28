/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.thehumblefool.pokégoapi2.models.dtos.RaidDTOModel;
import com.thehumblefool.pokégoapi2.models.api.RaidsApiModel;
import com.thehumblefool.pokégoapi2.models.entities.RaidEntityModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thehumblefool.pokégoapi2.repositories.RaidRepository;
import com.thehumblefool.pokégoapi2.repositories.TypeWeatherRepository;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class RaidsPublicService {

    private final RaidRepository repo;

    private final TypeWeatherRepository typeWeatherRepository;

    @Autowired
    public RaidsPublicService(RaidRepository repo, TypeWeatherRepository typeWeatherRepository) {
        this.repo = repo;
        this.typeWeatherRepository = typeWeatherRepository;
    }

    public RaidsApiModel loadAllRaidsMeta() {
        List<Integer> tiers = repo.findDistinctTier();
        Map<String, Integer> raidCountByTiers = new TreeMap<>();
        tiers.forEach((x) -> {
            if (x == 6) {
                raidCountByTiers.put("EX", repo.countByTier(x));

            } else {
                raidCountByTiers.put(String.valueOf(x), repo.countByTier(x));
            }
        });
        return new RaidsApiModel(repo.count(), repo.countDistinctTier(), raidCountByTiers, repo.countByShinyAvailable(true), repo.countByShinyAvailable(false), null);
    }

    public RaidsApiModel loadAllRaids() {
        List<RaidEntityModel> raidEntityModels = repo.findAll();
        List<RaidDTOModel> raidDTOModels = raidEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        RaidsApiModel finalModel = loadAllRaidsMeta();
        finalModel.setRaids(raidDTOModels);
        return finalModel;
    }

    public List<RaidDTOModel> loadRaidsByTier(int tier) {
        List<RaidEntityModel> raidEntityModels = repo.findByTier(tier);
        List<RaidDTOModel> raidDTOModels = raidEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return raidDTOModels;
    }

    public List<RaidDTOModel> loadRaidsByName(String pokémon) {
        List<RaidEntityModel> raidEntityModels = repo.findByPokémonStartingWith(pokémon);
        List<RaidDTOModel> raidDTOModels = raidEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return raidDTOModels;
    }

    public List<RaidDTOModel> loadRaidsByType(String type) {
        List<RaidEntityModel> raidEntityModels = repo.findInType1Type2(type);
        List<RaidDTOModel> raidDTOModels = raidEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return raidDTOModels;
    }

    public List<RaidDTOModel> loadRaidsByShiny(boolean shiny) {
        List<RaidEntityModel> raidEntityModels = repo.findByShinyAvailable(shiny);
        List<RaidDTOModel> raidDTOModels = raidEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return raidDTOModels;
    }

    public long loadAllRaidsCount() {
        return repo.count();
    }

    public int loadRaidCountByTier(int tier) {
        return repo.countByTier(tier);
    }

    public int loadRaidCountByShiny(boolean shiny) {
        return repo.countByShinyAvailable(shiny);
    }

    private RaidDTOModel mapEntityToDto(RaidEntityModel entityModel) {
        List<String> types = new ArrayList<>();
        types.add(entityModel.getType1());
        if (!entityModel.getType2().isBlank() && entityModel.getType2() != null) {
            types.add(entityModel.getType2());
        }
        Set<String> weather = addWeathers(types);
        return new RaidDTOModel(
                entityModel.getPokéDex(), entityModel.getPokémon(), types, weather, entityModel.getTier() == 6 ? "EX" : String.valueOf(entityModel.getTier()),
                entityModel.getGen(), entityModel.getRaidCp(), entityModel.getMinCpNonBoosted(),
                entityModel.getMaxCpNonBoosted(), entityModel.getMinCpBoosted(), entityModel.getMaxCpBoosted(),
                entityModel.getRecommendedGroupSize(), entityModel.getShinyAvailable());
    }

    private Set<String> addWeathers(List<String> types) {
        Set<String> weather = new HashSet<>();
        types.forEach((x) -> {
            weather.add(typeWeatherRepository.findWeatherByType(x));
        });
        return weather;
    }

}
