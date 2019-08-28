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

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Research Breakthrough Encounters Data")
@JsonPropertyOrder(value = {"pokédex", "pokémon", "types", "minCp", "maxCp", "shinyAvailable"})
public class ResearchBreakthroughEncounterDTOModel implements Serializable {

    @JsonProperty(value = "Poké Index")
    private int pokéDex;

    @JsonProperty(value = "Pokémon")
    private String pokémon;

    @JsonProperty(value = "Type(s)")
    private List<String> types;

    @JsonProperty(value = "Min Cp")
    private int minCp;

    @JsonProperty(value = "Max Cp")
    private int maxCp;

    @JsonProperty(value = "Shiny Availability")
    private boolean shinyAvailable;

    public ResearchBreakthroughEncounterDTOModel() {
    }

    public ResearchBreakthroughEncounterDTOModel(int pokéDex, String pokémon, List<String> types, int minCp, int maxCp, boolean shinyAvailable) {
        this.pokéDex = pokéDex;
        this.pokémon = pokémon;
        this.types = types;
        this.minCp = minCp;
        this.maxCp = maxCp;
        this.shinyAvailable = shinyAvailable;
    }

    public int getPokéDex() {
        return pokéDex;
    }

    public void setPokéDex(int pokéDex) {
        this.pokéDex = pokéDex;
    }

    public String getPokémon() {
        return pokémon;
    }

    public void setPokémon(String pokémon) {
        this.pokémon = pokémon;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public int getMinCp() {
        return minCp;
    }

    public void setMinCp(int minCp) {
        this.minCp = minCp;
    }

    public int getMaxCp() {
        return maxCp;
    }

    public void setMaxCp(int maxCp) {
        this.maxCp = maxCp;
    }

    public boolean getShinyAvailable() {
        return shinyAvailable;
    }

    public void setShinyAvailable(boolean shinyAvailable) {
        this.shinyAvailable = shinyAvailable;
    }

    @Override
    public String toString() {
        return "ResearchBreakthroughEncountersDTOModel: {" + "pokéDex=" + pokéDex + ", pokémon=" + pokémon + ", types=" + types + ", minCp=" + minCp + ", maxCp=" + maxCp + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
