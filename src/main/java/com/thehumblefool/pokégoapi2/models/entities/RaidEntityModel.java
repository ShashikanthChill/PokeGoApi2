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
@Table(name = "raids_list")
public class RaidEntityModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "poké_dex")
    private int pokéDex;

    @Column(name = "pokémon")
    private String pokémon;

    @Column(name = "type_1")
    private String type1;

    @Column(name = "type_2")
    private String type2;

    @Column(name = "tier")
    private int tier;

    @Column(name = "gen")
    private int gen;

    @Column(name = "raid_cp")
    private int raidCp;

    @Column(name = "min_cp_non_boosted")
    private int minCpNonBoosted;

    @Column(name = "max_cp_non_boosted")
    private int maxCpNonBoosted;

    @Column(name = "min_cp_boosted")
    private int minCpBoosted;

    @Column(name = "max_cp_boosted")
    private int maxCpBoosted;

    @Column(name = "recommended_group_size")
    private int recommendedGroupSize;

    @Column(name = "shiny_available")
    private boolean shinyAvailable;

    public RaidEntityModel() {
    }

    public RaidEntityModel(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
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
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.pokéDex;
        hash = 89 * hash + Objects.hashCode(this.pokémon);
        hash = 89 * hash + Objects.hashCode(this.type1);
        hash = 89 * hash + Objects.hashCode(this.type2);
        hash = 89 * hash + this.gen;
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
        final RaidEntityModel other = (RaidEntityModel) obj;
        if (this.pokéDex != other.pokéDex) {
            return false;
        }
        if (this.gen != other.gen) {
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
        return "RaidBossEntityModel: {" + "id=" + id + ", pokéDex=" + pokéDex + ", raidBoss=" + pokémon + ", type1=" + type1 + ", type2=" + type2 + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", recommendedGroupSize=" + recommendedGroupSize + ", shinyAvailable=" + shinyAvailable + '}';
    }

}
