/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.models.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author The_Humble_Fool
 */
@Entity
@Table(name = "encounters_list")
public class ResearchBreakthroughEncounterEntityModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "poké_dex")
    private int pokéDex;

    @Column(name = "pokémon")
    private String pokémon;

    @Column(name = "type_1")
    private String type1;

    @Column(name = "type_2")
    private String type2;

    @Column(name = "min_cp")
    private int minCp;

    @Column(name = "max_cp")
    private int maxCp;

    @Column(name = "shiny_available")
    private boolean shinyAvailable;

    public ResearchBreakthroughEncounterEntityModel() {
    }

    public ResearchBreakthroughEncounterEntityModel(Integer id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
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
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.pokéDex;
        hash = 37 * hash + Objects.hashCode(this.pokémon);
        hash = 37 * hash + Objects.hashCode(this.type1);
        hash = 37 * hash + Objects.hashCode(this.type2);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ResearchBreakthroughEncounterEntityModel other = (ResearchBreakthroughEncounterEntityModel) obj;
        if (this.pokéDex != other.pokéDex) {
            return false;
        }
        if (!Objects.equals(this.pokémon, other.pokémon)) {
            return false;
        }
        if (!Objects.equals(this.type1, other.type1)) {
            return false;
        }
        return Objects.equals(this.type2, other.type2);
    }

    @Override
    public String toString() {
        return "ResearchBreakthroughEncountersEntityModel: {" + "id=" + id + ", pokéDex=" + pokéDex + ", pokémon=" + pokémon + ", type1=" + type1 + ", type2=" + type2 + ", minCp=" + minCp + ", maxCp=" + maxCp + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
