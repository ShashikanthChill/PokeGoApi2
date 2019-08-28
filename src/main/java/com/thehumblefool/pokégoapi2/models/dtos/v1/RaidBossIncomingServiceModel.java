///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokégoapi2.models.dtos;
//
//import java.io.Serializable;
//
///**
// *
// * @author The_Humble_Fool
// */
////@JsonRootName(value = "Raid Boss Data")
////@JsonPropertyOrder(value = {"pokéDex", "raidBoss", "type", "boostedWeather", "gen", "tier", "raidBossCp", "minCpNonBoosted", "maxCpNonBoosted", "minCpBoosted", "maxCpBoosted", "groupSizeDifficulty", "catchRate", "shinyAailable"})
//public class RaidBossIncomingServiceModel implements Serializable
//{
//
//    private int pokéDex;
//
//    private String raidBoss;
//
//    private String type1;
//
//    private String type2;
//
////    private List<String> type = new ArrayList<>();
////
////    private Set<String> boostedWeather = new HashSet<>();
//    private String tier;
//
//    private int gen;
//
//    private int raidBossCp;
//
//    private int minCpNonBoosted;
//
//    private int maxCpNonBoosted;
//
//    private int minCpBoosted;
//
//    private int maxCpBoosted;
//
//    private int groupSizeDifficulty;
//
//    private double catchRate;
//
//    private boolean shinyAvailable;
//
//    public RaidBossIncomingServiceModel()
//    {
//    }
//
//    public RaidBossIncomingServiceModel(int pokeDex, String raidBoss, String type1, String type2, String tier, int gen, int raidBossCp, int minCpNonBoosted, int maxCpNonBoosted, int minCpBoosted, int maxCpBoosted, int groupSizeDifficulty, double catchRate, boolean shinyAvailable)
//    {
//        this.pokéDex = pokeDex;
//        this.raidBoss = raidBoss;
//        this.type1 = type1;
//        this.type2 = type2;
//        this.tier = tier;
//        this.gen = gen;
//        this.raidBossCp = raidBossCp;
//        this.minCpNonBoosted = minCpNonBoosted;
//        this.maxCpNonBoosted = maxCpNonBoosted;
//        this.minCpBoosted = minCpBoosted;
//        this.maxCpBoosted = maxCpBoosted;
//        this.groupSizeDifficulty = groupSizeDifficulty;
//        this.catchRate = catchRate;
//        this.shinyAvailable = shinyAvailable;
//    }
//
////    @JsonProperty(value = "Poke Index")
//    public int getPokéDex()
//    {
//        return pokéDex;
//    }
//
//    public void setPokéDex(int pokéDex)
//    {
//        this.pokéDex = pokéDex;
//    }
//
////    @JsonProperty(value = "Raid Boss")
//    public String getRaidBoss()
//    {
//        return raidBoss;
//    }
//
//    public void setRaidBoss(String raidBoss)
//    {
//        this.raidBoss = raidBoss;
//    }
//
////    @JsonProperty(value = "Type")
////    public List<String> getType()
////    {
////        return type;
////    }
////
////    public void setType(List<String> type)
////    {
////        this.type = type;
////    }
////
////    @JsonProperty(value = "Boosted Weather")
////    public Set<String> getBoostedWeather()
////    {
////        return boostedWeather;
////    }
////
////    public void setBoostedWeather(Set<String> boostedWeather)
////    {
////        this.boostedWeather = boostedWeather;
////    }
////    @JsonProperty(value = "Tier")
//    public String getTier()
//    {
//        return tier;
//    }
//
//    public void setTier(String tier)
//    {
//        this.tier = tier;
//    }
//
////    @JsonProperty(value = "Generation")
//    public int getGen()
//    {
//        return gen;
//    }
//
//    public void setGen(int gen)
//    {
//        this.gen = gen;
//    }
//
////    @JsonProperty(value = "Boss Cp")
//    public int getRaidBossCp()
//    {
//        return raidBossCp;
//    }
//
//    public void setRaidBossCp(int raidBossCp)
//    {
//        this.raidBossCp = raidBossCp;
//    }
//
////    @JsonProperty(value = "Min Cp(Non-Boosted)")
//    public int getMinCpNonBoosted()
//    {
//        return minCpNonBoosted;
//    }
//
//    public void setMinCpNonBoosted(int minCpNonBoosted)
//    {
//        this.minCpNonBoosted = minCpNonBoosted;
//    }
//
////    @JsonProperty(value = "Max Cp(Non-Boosted)")
//    public int getMaxCpNonBoosted()
//    {
//        return maxCpNonBoosted;
//    }
//
//    public void setMaxCpNonBoosted(int maxCpNonBoosted)
//    {
//        this.maxCpNonBoosted = maxCpNonBoosted;
//    }
//
////    @JsonProperty(value = "Min Cp(Boosted)")
//    public int getMinCpBoosted()
//    {
//        return minCpBoosted;
//    }
//
//    public void setMinCpBoosted(int minCpBoosted)
//    {
//        this.minCpBoosted = minCpBoosted;
//    }
//
////    @JsonProperty(value = "Max Cp(Boosted)")
//    public int getMaxCpBoosted()
//    {
//        return maxCpBoosted;
//    }
//
//    public void setMaxCpBoosted(int maxCpBoosted)
//    {
//        this.maxCpBoosted = maxCpBoosted;
//    }
//
////    @JsonProperty(value = "Recommended Group Size")
//    public int getGroupSizeDifficulty()
//    {
//        return groupSizeDifficulty;
//    }
//
//    public void setGroupSizeDifficulty(int groupSizeDifficulty)
//    {
//        this.groupSizeDifficulty = groupSizeDifficulty;
//    }
//
////    @JsonProperty(value = "Catch Rate")
//    public double getCatchRate()
//    {
//        return catchRate;
//    }
//
//    public void setCatchRate(double catchRate)
//    {
//        this.catchRate = catchRate;
//    }
//
////    @JsonProperty(value = "Shiny Availability")
//    public boolean getShinyAvailable()
//    {
//        return shinyAvailable;
//    }
//
//    public void setShinyAvailable(boolean shinyAvailable)
//    {
//        this.shinyAvailable = shinyAvailable;
//    }
//
//    @Override
//    public String toString()
//    {
//        return "RaidBossIncomingServiceModel{" + "pokeDex=" + pokéDex + ", raidBoss=" + raidBoss + ", type1=" + type1 + ", type2=" + type2 + ", tier=" + tier + ", gen=" + gen + ", raidBossCp=" + raidBossCp + ", minCpNonBoosted=" + minCpNonBoosted + ", maxCpNonBoosted=" + maxCpNonBoosted + ", minCpBoosted=" + minCpBoosted + ", maxCpBoosted=" + maxCpBoosted + ", groupSizeDifficulty=" + groupSizeDifficulty + ", catchRate=" + catchRate + ", shinyAvailable=" + shinyAvailable + '}';
//    }
//
//}
