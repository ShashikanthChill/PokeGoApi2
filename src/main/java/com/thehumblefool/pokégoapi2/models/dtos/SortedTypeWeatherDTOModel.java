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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Type Weather Boost Data")
@JsonPropertyOrder(value = {"weather", "type"})
public class SortedTypeWeatherDTOModel implements Serializable {

    private String weather;

    private Set<String> type = new HashSet<>();

    public SortedTypeWeatherDTOModel() {
    }

    public SortedTypeWeatherDTOModel(Set<String> type, String weather) {
        this.type = type;
        this.weather = weather;
    }

    @JsonProperty(value = "Boosted Types")
    public Set<String> getType() {
        return type;
    }

    public void setType(Set<String> type) {
        this.type = type;
    }

    @JsonProperty(value = "Weather")
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "SortedTypeWeatherBoostDTOModel: {" + "weather=" + weather + ", type=" + type + '}';
    }

}
