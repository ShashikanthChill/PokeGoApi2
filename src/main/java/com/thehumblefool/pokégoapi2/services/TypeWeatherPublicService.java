/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.thehumblefool.pokégoapi2.models.api.TypeWeathersApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.SortedTypeWeatherDTOModel;
import com.thehumblefool.pokégoapi2.models.dtos.TypeWeatherDTOModel;
import com.thehumblefool.pokégoapi2.models.entities.TypeWeatherEntityModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thehumblefool.pokégoapi2.repositories.TypeWeatherRepository;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class TypeWeatherPublicService {

    private final TypeWeatherRepository repo;

    @Autowired
    public TypeWeatherPublicService(TypeWeatherRepository repo) {
        this.repo = repo;
    }

    public TypeWeathersApiModel loadAllTypesWeatherMeta() {
        return new TypeWeathersApiModel(repo.count(), repo.countDistinctWeather(), repo.findDistinctWeather(), null, null);
    }

    public TypeWeathersApiModel loadAllTypesWeather() {
        List<TypeWeatherEntityModel> typeWeatherEntityModels = repo.findAll();
        List<TypeWeatherDTOModel> typeWeatherDTOModels = typeWeatherEntityModels.stream().map(this::mapEntityToDto).collect(Collectors.toList());
        TypeWeathersApiModel apiModel = loadAllTypesWeatherMeta();
        apiModel.setTypeWeathers(typeWeatherDTOModels);
        return apiModel;
    }

    private TypeWeatherDTOModel mapEntityToDto(TypeWeatherEntityModel entityModel) {
        TypeWeatherDTOModel typeWeatherDTOModel = new TypeWeatherDTOModel();
        typeWeatherDTOModel.setType(entityModel.getType());
        typeWeatherDTOModel.setWeather(entityModel.getWeather());
        return typeWeatherDTOModel;
    }

    public TypeWeathersApiModel loadSortedWeatherTypes() {
        List<TypeWeatherEntityModel> typeWeatherEntityModels = repo.findAll();
        Map<String, SortedTypeWeatherDTOModel> sortedTypeWeatherDTOModelsMap = new HashMap<>();
        typeWeatherEntityModels.forEach((t) -> {
            if (sortedTypeWeatherDTOModelsMap.containsKey(t.getWeather())) {
                sortedTypeWeatherDTOModelsMap.get(t.getWeather()).getType().add(t.getType());
            } else {
                SortedTypeWeatherDTOModel sortedModel = new SortedTypeWeatherDTOModel();
                sortedModel.setWeather(t.getWeather());
                sortedModel.getType().add(t.getType());
                sortedTypeWeatherDTOModelsMap.put(t.getWeather(), sortedModel);
            }
        });

        TypeWeathersApiModel apiModel = loadAllTypesWeatherMeta();
        apiModel.setSortedTypeWeathers(new ArrayList<>(sortedTypeWeatherDTOModelsMap.values()));
        return apiModel;
    }

}
