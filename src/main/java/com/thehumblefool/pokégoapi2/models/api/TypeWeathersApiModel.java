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
import com.thehumblefool.pokégoapi2.models.dtos.SortedTypeWeatherDTOModel;
import com.thehumblefool.pokégoapi2.models.dtos.TypeWeatherDTOModel;
import java.util.List;

/**
 *
 * @author TheHumbleFool
 */
@JsonRootName(value = "Type Weather Boost Data")
@JsonPropertyOrder(value = {"totalTypeCount", "totalWeatherCount", "weatherTypes", "typeWeathers", "sortedTypeWeathers"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypeWeathersApiModel {

    @JsonProperty(value = "Total Pokémon Types")
    private long totalTypeCount;
    @JsonProperty(value = "Total Weather Types")
    private long totalWeatherCount;
    @JsonProperty(value = "Weather Types")
    private List<String> weatherTypes;
    @JsonProperty(value = "Type Weather Data")
    private List<TypeWeatherDTOModel> typeWeathers;
    @JsonProperty(value = "Sorted Type Weather Data")
    private List<SortedTypeWeatherDTOModel> sortedTypeWeathers;

    public TypeWeathersApiModel() {
    }

    public TypeWeathersApiModel(long totalTypeCount, long totalWeatherCount, List<String> weatherTypes, List<TypeWeatherDTOModel> typeWeathers, List<SortedTypeWeatherDTOModel> sortedTypeWeathers) {
        this.totalTypeCount = totalTypeCount;
        this.totalWeatherCount = totalWeatherCount;
        this.weatherTypes = weatherTypes;
        this.typeWeathers = typeWeathers;
        this.sortedTypeWeathers = sortedTypeWeathers;
    }

    public long getTotalTypeCount() {
        return totalTypeCount;
    }

    public void setTotalTypeCount(long totalTypeCount) {
        this.totalTypeCount = totalTypeCount;
    }

    public long getTotalWeatherCount() {
        return totalWeatherCount;
    }

    public void setTotalWeatherCount(long totalWeatherCount) {
        this.totalWeatherCount = totalWeatherCount;
    }

    public List<String> getWeatherTypes() {
        return weatherTypes;
    }

    public void setWeatherTypes(List<String> weatherTypes) {
        this.weatherTypes = weatherTypes;
    }

    public List<TypeWeatherDTOModel> getTypeWeathers() {
        return typeWeathers;
    }

    public void setTypeWeathers(List<TypeWeatherDTOModel> typeWeathers) {
        this.typeWeathers = typeWeathers;
    }

    public List<SortedTypeWeatherDTOModel> getSortedTypeWeathers() {
        return sortedTypeWeathers;
    }

    public void setSortedTypeWeathers(List<SortedTypeWeatherDTOModel> sortedTypeWeathers) {
        this.sortedTypeWeathers = sortedTypeWeathers;
    }

    @Override
    public String toString() {
        return "TypeWeatherBoostApiModel: {" + "totalTypeCount=" + totalTypeCount + ", totalWeatherCount=" + totalWeatherCount + ", weatherTypes=" + weatherTypes + ", typeWeathers=" + typeWeathers + ", sortedTypeWeathers=" + sortedTypeWeathers + '}';
    }

}
