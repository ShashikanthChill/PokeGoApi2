/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Raid Boss Data")
@JsonPropertyOrder(value = {"pokéDex", "raidBoss", "type1", "type2", "types", "boostedWeather", "gen", "tier", "raidBossCp", "minCpNonBoosted", "maxCpNonBoosted", "minCpBoosted", "maxCpBoosted", "groupSizeDifficulty", "shinyAailable"})
public class RaidDTOModel implements Serializable {

    @JsonProperty(value = "Poké Index")
    private int pokéDex;

    @JsonProperty(value = "Raid Boss")
    private String raidBoss;

    @JsonProperty(value = "Type(s)")
    private List<String> types;

    @JsonProperty(value = "Boosted Weather")
    private Set<String> boostedWeather;

    @JsonProperty(value = "Tier")
    private String tier;

    @JsonProperty(value = "Generation")
    private int gen;

    @JsonProperty(value = "Raid Cp")
    private int raidCp;

    @JsonProperty(value = "Min Cp(Non-Boosted)")
    private int minCpNonBoosted;

    @JsonProperty(value = "Max Cp(Non-Boosted)")
    private int maxCpNonBoosted;

    @JsonProperty(value = "Min Cp(Boosted)")
    private int minCpBoosted;

    @JsonProperty(value = "Max Cp(Boosted)")
    private int maxCpBoosted;

    @JsonProperty(value = "Recommended Group Size")
    private int recommendedGroupSize;

    @JsonProperty(value = "Shiny Availability")
    private boolean shinyAvailable;

    public RaidDTOModel() {
    }

    public RaidDTOModel(int pokéDex, String raidBoss, List<String> type, Set<String> boostedWeather, String tier, int gen, int raidBossCp, int minCpNonBoosted, int maxCpNonBoosted, int minCpBoosted, int maxCpBoosted, int groupSizeDifficulty, boolean shinyAvailable) {
        this.pokéDex = pokéDex;
        this.raidBoss = raidBoss;
        this.types = type;
        this.boostedWeather = boostedWeather;
        this.tier = tier;
        this.gen = gen;
        this.raidCp = raidBossCp;
        this.minCpNonBoosted = minCpNonBoosted;
        this.maxCpNonBoosted = maxCpNonBoosted;
        this.minCpBoosted = minCpBoosted;
        this.maxCpBoosted = maxCpBoosted;
        this.recommendedGroupSize = groupSizeDifficulty;
        this.shinyAvailable = shinyAvailable;
    }

    public int getPokéDex() {
        return pokéDex;
    }

    public void setPokéDex(int pokéDex) {
        this.pokéDex = pokéDex;
    }

    public String getRaidBoss() {
        return raidBoss;
    }

    public void setRaidBoss(String raidBoss) {
        this.raidBoss = raidBoss;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public Set<String> getBoostedWeather() {
        return boostedWeather;
    }

    public void setBoostedWeather(Set<String> boostedWeather) {
        this.boostedWeather = boostedWeather;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public int getRaidCp() {
        return raidCp;
    }

    public void setRaidCp(int raidCp) {
        this.raidCp = raidCp;
    }

    public int getMinCpNonBoosted() {
        return minCpNonBoosted;
    }

    public void setMinCpNonBoosted(int minCpNonBoosted) {
        this.minCpNonBoosted = minCpNonBoosted;
    }

    public int getMaxCpNonBoosted() {
        return maxCpNonBoosted;
    }

    public void setMaxCpNonBoosted(int maxCpNonBoosted) {
        this.maxCpNonBoosted = maxCpNonBoosted;
    }

    public int getMinCpBoosted() {
        return minCpBoosted;
    }

    public void setMinCpBoosted(int minCpBoosted) {
        this.minCpBoosted = minCpBoosted;
    }

    public int getMaxCpBoosted() {
        return maxCpBoosted;
    }

    public void setMaxCpBoosted(int maxCpBoosted) {
        this.maxCpBoosted = maxCpBoosted;
    }

    public int getRecommendedGroupSize() {
        return recommendedGroupSize;
    }

    public void setRecommendedGroupSize(int recommendedGroupSize) {
        this.recommendedGroupSize = recommendedGroupSize;
    }

    public boolean getShinyAvailable() {
        return shinyAvailable;
    }

    public void setShinyAvailable(boolean shinyAvailable) {
        this.shinyAvailable = shinyAvailable;
    }

    @Override
    public String toString() {
        return "RaidBossDTOModel: {" + "pokéDex=" + pokéDex + ", raidBoss=" + raidBoss + ", types=" + types + ", boostedWeather=" + boostedWeather + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", groupSizeDifficulty=" + recommendedGroupSize + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
