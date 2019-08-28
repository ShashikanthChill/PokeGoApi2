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

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Type Weather Boost Data")
@JsonPropertyOrder(value = {"type", "weather"})
public class TypeWeatherDTOModel implements Serializable {

    private String type;

    private String weather;

    public TypeWeatherDTOModel() {
    }

    public TypeWeatherDTOModel(String type, String weather) {
        this.type = type;
        this.weather = weather;
    }

    @JsonProperty(value = "Pokémon Type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty(value = "Boosted Weather")
    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "TypeWeatherBoostDTOModel: {" + "type=" + type + ", weather=" + weather + '}';
    }

}
