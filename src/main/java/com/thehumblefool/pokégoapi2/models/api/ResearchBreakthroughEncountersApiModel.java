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
import com.thehumblefool.pokégoapi2.models.dtos.ResearchBreakthroughEncounterDTOModel;
import java.util.List;

/**
 *
 * @author TheHumbleFool
 */
@JsonRootName(value = "Research Breakthrough Encounter Data")
@JsonPropertyOrder(value = {"totalEncounterCount", "shinyCount", "nonShinyCount", "encounters"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResearchBreakthroughEncountersApiModel {

    @JsonProperty(value = "Total Encounters")
    private long totalEncounterCount;
    @JsonProperty(value = "Shiny Encounters")
    private int shinyCount;
    @JsonProperty(value = "Non-Shiny Encounters")
    private int nonShinyCount;
    @JsonProperty(value = "Encounter Data")
    private List<ResearchBreakthroughEncounterDTOModel> encounters;

    public ResearchBreakthroughEncountersApiModel() {
    }

    public ResearchBreakthroughEncountersApiModel(long totalEncounterCount, int shinyCount, int nonShinyCount, List<ResearchBreakthroughEncounterDTOModel> encounters) {
        this.totalEncounterCount = totalEncounterCount;
        this.shinyCount = shinyCount;
        this.nonShinyCount = nonShinyCount;
        this.encounters = encounters;
    }

    public long getTotalEncounterCount() {
        return totalEncounterCount;
    }

    public void setTotalEncounterCount(long totalEncounterCount) {
        this.totalEncounterCount = totalEncounterCount;
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

    public List<ResearchBreakthroughEncounterDTOModel> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<ResearchBreakthroughEncounterDTOModel> encounters) {
        this.encounters = encounters;
    }

    @Override
    public String toString() {
        return "ResearchBreakthroughEncounterApiModel: {" + "totalEncounterCount=" + totalEncounterCount + ", shinyCount=" + shinyCount + ", nonShinyCount=" + nonShinyCount + ", encounters=" + encounters + '}';
    }

}
