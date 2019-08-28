/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author The_Humble_Fool
 */
@JsonRootName(value = "Type Effectiveness Data")
public class TypeEffectivenessDTOModel implements Serializable {

    private String type;

    private List<String> superEffective;

    private List<String> normalEffective;

    private List<String> notVeryEffective;

    private List<String> noEffective;

    public TypeEffectivenessDTOModel() {
    }

    public TypeEffectivenessDTOModel(String type) {
        this.type = type;
    }

    public TypeEffectivenessDTOModel(String type, List<String> superEffective, List<String> normalEffective, List<String> notVeryEffective, List<String> noEffective) {
        this.type = type;
        this.superEffective = superEffective;
        this.normalEffective = normalEffective;
        this.notVeryEffective = notVeryEffective;
        this.noEffective = noEffective;
    }

    public String getType() {
        return type;
    }

    @JsonProperty(value = "Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty(value = "Super Effective")
    public List<String> getSuperEffective() {
        return superEffective;
    }

    public void setSuperEffective(List<String> superEffective) {
        this.superEffective = superEffective;
    }

    @JsonProperty(value = "Nomal Effective")
    public List<String> getNormalEffective() {
        return normalEffective;
    }

    public void setNormalEffective(List<String> normalEffective) {
        this.normalEffective = normalEffective;
    }

    @JsonProperty(value = "Not Very Effective")
    public List<String> getNotVeryEffective() {
        return notVeryEffective;
    }

    public void setNotVeryEffective(List<String> notVeryEffective) {
        this.notVeryEffective = notVeryEffective;
    }

    @JsonProperty(value = "Zero Effective")
    public List<String> getNoEffective() {
        return noEffective;
    }

    public void setNoEffective(List<String> noEffective) {
        this.noEffective = noEffective;
    }

    @Override
    public String toString() {
        return "TypeEffectivenessDTOModel: {" + "type=" + type + ", superEffective=" + superEffective + ", normalEffective=" + normalEffective + ", notVeryEffective=" + notVeryEffective + ", noEffective=" + noEffective + '}';
    }

}
