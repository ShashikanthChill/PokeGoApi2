/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.models.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.thehumblefool.pokégoapi2.models.dtos.TypeEffectivenessDTOModel;
import java.util.List;

/**
 *
 * @author TheHumbleFool
 */
@JsonRootName(value = "Type Effectiveness Data")
@JsonPropertyOrder(value = {"totalTypeCount", "effectivenessLevels", "typeEffectives"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeEffectivenessApiModel {

    @JsonProperty(value = "Total Types")
    private long totalTypeCount;
    @JsonProperty(value = "Effectiveness Levels")
    private List<String> effectivenessLevels;
    @JsonProperty(value = "Type Effective Data")
    private List<TypeEffectivenessDTOModel> typeEffectives;

    public TypeEffectivenessApiModel() {
    }

    public TypeEffectivenessApiModel(long totalTypeCount, List<String> effectivenessLevels, List<TypeEffectivenessDTOModel> typeEffectives) {
        this.totalTypeCount = totalTypeCount;
        this.effectivenessLevels = effectivenessLevels;
        this.typeEffectives = typeEffectives;
    }

    public long getTotalTypeCount() {
        return totalTypeCount;
    }

    public void setTotalTypeCount(long totalTypeCount) {
        this.totalTypeCount = totalTypeCount;
    }

    public List<String> getEffectivenessLevels() {
        return effectivenessLevels;
    }

    public void setEffectivenessLevels(List<String> effectivenessLevels) {
        this.effectivenessLevels = effectivenessLevels;
    }

    public List<TypeEffectivenessDTOModel> getTypeEffectives() {
        return typeEffectives;
    }

    public void setTypeEffectives(List<TypeEffectivenessDTOModel> typeEffectives) {
        this.typeEffectives = typeEffectives;
    }

    @Override
    public String toString() {
        return "TypeEffectivenessApiModel {" + "totalTypeCount=" + totalTypeCount + ", effectivenessLevels=" + effectivenessLevels + ", typeEffectives=" + typeEffectives + '}';
    }

    
}
