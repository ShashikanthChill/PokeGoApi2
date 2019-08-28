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
import com.thehumblefool.pokégoapi2.models.dtos.EggHatchDTOModel;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TheHumbleFool
 */
@JsonRootName(value = "Egg Hatches Data")
@JsonPropertyOrder(value = {"totalHatchCount", "totalHatchDistancePools", "totalHatchesPerPool", "shinyCount", "nonShinyCount", "hatches"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EggHatchesApiModel {

    @JsonProperty(value = "Total Hatches")
    private long totalHatchCount;
    @JsonProperty(value = "Hatch Distance Pools")
    private int totalHatchDistancePools;
    @JsonProperty(value = "Hatches Per Pool")
    private Map<String, Integer> totalHatchesPerPool;
    @JsonProperty(value = "Shiny Hatches")
    private int shinyCount;
    @JsonProperty(value = "Non-Shiny Hatches")
    private int nonShinyCount;
    @JsonProperty(value = "Hatch Data")
    private List<EggHatchDTOModel> hatches;

    public EggHatchesApiModel() {
    }

    public EggHatchesApiModel(long totalHatchCount, int totalHatchDistancePools, Map<String, Integer> totalHatchesPerPool, int shinyCount, int nonShinyCount, List<EggHatchDTOModel> hatches) {
        this.totalHatchCount = totalHatchCount;
        this.totalHatchDistancePools = totalHatchDistancePools;
        this.totalHatchesPerPool = totalHatchesPerPool;
        this.shinyCount = shinyCount;
        this.nonShinyCount = nonShinyCount;
        this.hatches = hatches;
    }

    public long getTotalHatchCount() {
        return totalHatchCount;
    }

    public void setTotalHatchCount(long totalHatchCount) {
        this.totalHatchCount = totalHatchCount;
    }

    public int getTotalHatchDistancePools() {
        return totalHatchDistancePools;
    }

    public void setTotalHatchDistancePools(int totalHatchDistancePools) {
        this.totalHatchDistancePools = totalHatchDistancePools;
    }

    public Map<String, Integer> getTotalHatchesPerPool() {
        return totalHatchesPerPool;
    }

    public void setTotalHatchesPerPool(Map<String, Integer> totalHatchesPerPool) {
        this.totalHatchesPerPool = totalHatchesPerPool;
    }

    public int getShinyCount() {
        return shinyCount;
    }

    public void setShinyCount(int shinyCount) {
        this.shinyCount = shinyCount;
    }

    public int getNonShinyCount() {
        return nonShinyCount;
    }

    public void setNonShinyCount(int nonShinyCount) {
        this.nonShinyCount = nonShinyCount;
    }

    public List<EggHatchDTOModel> getHatches() {
        return hatches;
    }

    public void setHatches(List<EggHatchDTOModel> hatches) {
        this.hatches = hatches;
    }

    @Override
    public String toString() {
        return "EggPoolApiModel: {" + "totalHatchCount=" + totalHatchCount + ", totalHatchDistancePools=" + totalHatchDistancePools + ", totalHatchesPerPool=" + totalHatchesPerPool + ", shinyCount=" + shinyCount + ", nonShinyCount=" + nonShinyCount + ", hatches=" + hatches + '}';
    }

}
