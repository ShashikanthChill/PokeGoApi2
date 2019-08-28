/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.services;

import com.thehumblefool.pokégoapi2.models.api.TypeEffectivenessApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.TypeEffectivenessDTOModel;
import com.thehumblefool.pokégoapi2.repositories.TypeEffectivenessRepository;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author The_Humble_Fool
 */
@Service
public class TypeEffectivenessPublicService {

    private final JdbcTemplate jdbcTemplate;
    private final TypeEffectivenessRepository repo;

    @Autowired
    public TypeEffectivenessPublicService(JdbcTemplate jdbcTemplate, TypeEffectivenessRepository repo) {
        this.jdbcTemplate = jdbcTemplate;
        this.repo = repo;
    }

    public TypeEffectivenessApiModel loadAllTypeEffectivesMeta() {
        return new TypeEffectivenessApiModel(repo.count(), Arrays.asList(new String[]{"Zero Effective", "Not Very Effective", "Normal Effective", "Super Effective"}), null);
    }

    public TypeEffectivenessApiModel loadAllTypeEffectives() {
        List<TypeEffectivenessDTOModel> typeEffectivenessDTOModels = new ArrayList<>();
        TypeEffectivenessPublicService.this.loadAllTypeEffectives(typeEffectivenessDTOModels);
        TypeEffectivenessApiModel apiModel = loadAllTypeEffectivesMeta();
        apiModel.setTypeEffectives(typeEffectivenessDTOModels);
        return apiModel;
    }

    private void loadAllTypeEffectives(List<TypeEffectivenessDTOModel> typeEffectivenessDTOModels) {
        jdbcTemplate.query("select * from type_effectiveness", (ResultSet rs, int rowNum) -> {
            ResultSetMetaData metaData = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) {
                List<String> noEffective = new ArrayList<>();
                List<String> notVeryEffective = new ArrayList<>();
                List<String> normalEffective = new ArrayList<>();
                List<String> superEffective = new ArrayList<>();
                for (int i = 3; i < metaData.getColumnCount(); i++) {
                    double aDouble = rs.getDouble(i);
                    if (aDouble == 0.0) {
                        noEffective.add(metaData.getColumnName(i));
                    } else if (aDouble == 0.5) {
                        notVeryEffective.add(metaData.getColumnName(i));
                    } else if (aDouble == 1.0) {
                        normalEffective.add(metaData.getColumnName(i));
                    } else if (aDouble == 2.0) {
                        superEffective.add(metaData.getColumnName(i));
                    }
                }
                TypeEffectivenessDTOModel typeEffectivenessDTOModel = new TypeEffectivenessDTOModel(rs.getString(2), superEffective, normalEffective, notVeryEffective, noEffective);
                typeEffectivenessDTOModels.add(typeEffectivenessDTOModel);
                typeEffectivenessDTOModels.add(typeEffectivenessDTOModel);
            }
            return null;
        });
    }

    private void loadTypeEffectivesByType(List<TypeEffectivenessDTOModel> typeEffectivenessDTOModels, String type) {
        jdbcTemplate.query("select * from type_effectiveness where type='" + type + "'", (ResultSet rs, int rowNum) -> {
            ResultSetMetaData metaData = rs.getMetaData();
            rs.beforeFirst();
            while (rs.next()) {
                List<String> noEffective = new ArrayList<>();
                List<String> notVeryEffective = new ArrayList<>();
                List<String> normalEffective = new ArrayList<>();
                List<String> superEffective = new ArrayList<>();
                for (int i = 3; i < metaData.getColumnCount(); i++) {
                    double aDouble = rs.getDouble(i);
                    if (aDouble == 0.0) {
                        noEffective.add(metaData.getColumnName(i));
                    } else if (aDouble == 0.5) {
                        notVeryEffective.add(metaData.getColumnName(i));
                    } else if (aDouble == 1.0) {
                        normalEffective.add(metaData.getColumnName(i));
                    } else if (aDouble == 2.0) {
                        superEffective.add(metaData.getColumnName(i));
                    }
                }
                TypeEffectivenessDTOModel typeEffectivenessDTOModel = new TypeEffectivenessDTOModel(rs.getString(2), superEffective, normalEffective, notVeryEffective, noEffective);
                typeEffectivenessDTOModels.add(typeEffectivenessDTOModel);
            }
            return null;
        });
    }

    public List<TypeEffectivenessDTOModel> loadTypeEffectivesByType(String type) {
        List<TypeEffectivenessDTOModel> typeEffectivenessDTOModels = new ArrayList<>();
        loadTypeEffectivesByType(typeEffectivenessDTOModels, type);
        return typeEffectivenessDTOModels;
    }
}
