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
import com.thehumblefool.pokégoapi2.models.dtos.RaidDTOModel;
import java.util.List;
import java.util.Map;

/**
 *
 * @author TheHumbleFool
 */
@JsonRootName(value = "Raids Data")
@JsonPropertyOrder(value = {"totalRaidCount", "totalTierCount", "totalRaidCountByTier", "shinyCount", "nonShinyCount", "raids"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RaidsApiModel {

    @JsonProperty(value = "Total Raid Bosses")
    private long totalRaidCount;
    @JsonProperty(value = "Raid Boss Levels")
    private int totalTierCount;
    @JsonProperty(value = "Raid Bosses Per Level")
    private Map<String, Integer> totalRaidCountByTier;
    @JsonProperty(value = "Shiny Raid Bosses")
    private int shinyCount;
    @JsonProperty(value = "Non-Shiny Raid Bosses")
    private int nonShinyCount;
    @JsonProperty(value = "Raid Boss Data")
    private List<RaidDTOModel> raids;

    public RaidsApiModel() {
    }

    public RaidsApiModel(long totalRaidCount, int totalTierCount, Map<String, Integer> totalRaidCountByTier, int shinyCount, int nonShinyCount, List<RaidDTOModel> raids) {
        this.totalRaidCount = totalRaidCount;
        this.totalTierCount = totalTierCount;
        this.totalRaidCountByTier = totalRaidCountByTier;
        this.shinyCount = shinyCount;
        this.nonShinyCount = nonShinyCount;
        this.raids = raids;
    }

    public long getTotalRaidCount() {
        return totalRaidCount;
    }

    public void setTotalRaidCount(long totalRaidCount) {
        this.totalRaidCount = totalRaidCount;
    }

    public int getTotalTierCount() {
        return totalTierCount;
    }

    public void setTotalTierCount(int totalTierCount) {
        this.totalTierCount = totalTierCount;
    }

    public Map<String, Integer> getTotalRaidCountByTier() {
        return totalRaidCountByTier;
    }

    public void setTotalRaidCountByTier(Map<String, Integer> totalRaidCountByTier) {
        this.totalRaidCountByTier = totalRaidCountByTier;
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

    public List<RaidDTOModel> getRaids() {
        return raids;
    }

    public void setRaids(List<RaidDTOModel> raids) {
        this.raids = raids;
    }

    @Override
    public String toString() {
        return "RaidBossApiModel: {" + "totalRaidCount=" + totalRaidCount + ", totalTierCount=" + totalTierCount + ", totalRaidCountByTier=" + totalRaidCountByTier + ", shinyCount=" + shinyCount + ", nonShinyCount=" + nonShinyCount + ", raids=" + raids + '}';
    }

}
