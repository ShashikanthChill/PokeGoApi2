/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.thehumblefool.pokégoapi2.models.api.EggHatchesApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.EggHatchDTOModel;
import com.thehumblefool.pokégoapi2.models.entities.EggHatchEntityModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thehumblefool.pokégoapi2.repositories.EggHatchRepository;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class EggHatchesPublicService {

    private final EggHatchRepository repo;

    @Autowired
    public EggHatchesPublicService(EggHatchRepository repo) {
        this.repo = repo;
    }

    public EggHatchesApiModel loadAllHatchesMeta() {
        List<Integer> hatchDistances = repo.findDistinctHatchDistance();
        Map<String, Integer> hatchesPerPool = new TreeMap<>();
        hatchDistances.forEach((t) -> {
            hatchesPerPool.put(String.valueOf(t), repo.countByHatchDistance(t));
        });
        return new EggHatchesApiModel(repo.count(), repo.countDistinctHatchDistance(), hatchesPerPool, repo.countByShinyAvailable(true), repo.countByShinyAvailable(false), null);
    }

    public EggHatchesApiModel loadAllHatches() {
        List<EggHatchEntityModel> eggHatchEntityModels = repo.findAll();
        List<EggHatchDTOModel> eggHatchDTOModels = eggHatchEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        EggHatchesApiModel apiModel = loadAllHatchesMeta();
        apiModel.setHatches(eggHatchDTOModels);
        return apiModel;
    }

    public List<EggHatchDTOModel> loadHatchesByDistance(int distance) {
        List<EggHatchEntityModel> eggHatchEntityModels = repo.findByHatchDistance(distance);
        List<EggHatchDTOModel> eggHatchDTOModels = eggHatchEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return eggHatchDTOModels;
    }

    public List<EggHatchDTOModel> loadHatchesByShiny(boolean shiny) {
        List<EggHatchEntityModel> eggPoolEntityModels = repo.findByShinyAvailable(shiny);
        List<EggHatchDTOModel> eggHatchDTOModels = eggPoolEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        return eggHatchDTOModels;
    }

    private EggHatchDTOModel mapEntityToDto(EggHatchEntityModel entityModel) {
        List<String> types = new ArrayList<>();
        types.add(entityModel.getType1());
        if (!entityModel.getType2().isBlank() && entityModel.getType2() != null) {
            types.add(entityModel.getType2());
        }
        return new EggHatchDTOModel(entityModel.getPokéDex(), entityModel.getPokémon(), types, entityModel.getHatchDistance(), entityModel.getMinCp(), entityModel.getMaxCp(), entityModel.getShinyAvailable());
    }
}
