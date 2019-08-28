package com.thehumblefool.pokégoapi2.services.v1;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokegoapi2.services;
//
//import com.the_humble_fool.PokeGoApi.jparepositories.RaidBossJpaRepo;
//import com.the_humble_fool.PokeGoApi.models.entitymodels.RaidBossEntityModel;
//import com.the_humble_fool.PokeGoApi.models.servicemodels.RaidBossServiceModel;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Service
//public class RaidBossAdminService
//{
//
//    @Autowired
//    RaidBossJpaRepo repo;
//
//    public List<RaidBossEntityModel> getAllRaidBosses()
//    {
//        List<RaidBossEntityModel> entityModels = repo.findAll();
//        return entityModels;
//    }
//
//    public void saveRaidBossInfo(RaidBossServiceModel serviceModel)
//    {
//        RaidBossEntityModel entityModel = mapServiceToEntity(serviceModel);
//        repo.saveAndFlush(entityModel);
//    }
//
//    public void updateRaidBossInfo(RaidBossEntityModel entityModel)
//    {
//        RaidBossEntityModel proxyModel = repo.getOne(entityModel.getId());
//        proxyModel = updateProxyEntity(proxyModel, entityModel);
//        repo.saveAndFlush(proxyModel);
//    }
//
//    public void deleteRaidBossInfo(int id)
//    {
//        repo.deleteById(id);
//    }
//
//    private  static RaidBossEntityModel mapServiceToEntity(RaidBossServiceModel serviceModel)
//    {
//        RaidBossEntityModel entityModel = new RaidBossEntityModel();
//
//        entityModel.setPokeDex(serviceModel.getPokeDex());
//        entityModel.setRaidBoss(serviceModel.getRaidBoss());
//        entityModel.setType1(serviceModel.getType1());
//        entityModel.setType2(serviceModel.getType2().equalsIgnoreCase("pick a type") ? null : serviceModel.getType2());
//
//        entityModel.setTier(Integer.parseInt(serviceModel.getTier()));
//        entityModel.setGen(serviceModel.getGen());
//        entityModel.setRaidBossCp(serviceModel.getRaidBossCp());
//        entityModel.setMinCpNonBoosted(serviceModel.getMinCpNonBoosted());
//        entityModel.setMaxCpNonBoosted(serviceModel.getMaxCpNonBoosted());
//        entityModel.setMinCpBoosted(serviceModel.getMinCpBoosted());
//        entityModel.setMaxCpBoosted(serviceModel.getMaxCpBoosted());
//        entityModel.setGroupSizeDifficulty(serviceModel.getGroupSizeDifficulty());
//        entityModel.setCatchRate(serviceModel.getCatchRate());
//        entityModel.setShinyAvailable(serviceModel.getShinyAvailable());
//
//        return entityModel;
//    }
//
//    private RaidBossEntityModel updateProxyEntity(RaidBossEntityModel proxyModel, RaidBossEntityModel entityModel)
//    {
//        proxyModel.setPokeDex(entityModel.getPokeDex());
//        proxyModel.setRaidBoss(entityModel.getRaidBoss());
//        proxyModel.setType1(entityModel.getType1());
//        proxyModel.setType2(entityModel.getType2());
//        proxyModel.setTier(entityModel.getTier());
//        proxyModel.setGen(entityModel.getGen());
//        proxyModel.setRaidBossCp(entityModel.getRaidBossCp());
//        proxyModel.setMinCpNonBoosted(entityModel.getMinCpNonBoosted());
//        proxyModel.setMaxCpNonBoosted(entityModel.getMaxCpNonBoosted());
//        proxyModel.setMinCpBoosted(entityModel.getMinCpBoosted());
//        proxyModel.setMaxCpBoosted(entityModel.getMaxCpBoosted());
//        proxyModel.setGroupSizeDifficulty(entityModel.getGroupSizeDifficulty());
//        proxyModel.setCatchRate(entityModel.getCatchRate());
//        proxyModel.setShinyAvailable(entityModel.getShinyAvailable());
//
//        return proxyModel;
//    }
//}
