package com.thehumblefool.pokégoapi2.services.v1;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokegoapi2.services;
//
//import com.the_humble_fool.PokeGoApi.jparepositories.EggPoolJpaRepo;
//import com.the_humble_fool.PokeGoApi.models.entitymodels.EggPoolEntityModel;
//import com.the_humble_fool.PokeGoApi.models.servicemodels.EggPoolServiceModel;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Service
//public class EggPoolAdminService
//{
//
//    @Autowired
//    EggPoolJpaRepo repo;
//
//    public List<EggPoolEntityModel> getAllEggpools()
//    {
//        List<EggPoolEntityModel> eggPoolEntityModels = repo.findAll();
//        return eggPoolEntityModels;
//    }
//
//    public void saveEggInfo(EggPoolServiceModel serviceModel)
//    {
//        EggPoolEntityModel entityModel = mapServiceToEntity(serviceModel);
//        repo.saveAndFlush(entityModel);
//    }
//
//    public void updateEggInfo(EggPoolEntityModel entityModel)
//    {
//        EggPoolEntityModel proxyModel = repo.getOne(entityModel.getId());
//        proxyModel = updateProxyEntity(proxyModel, entityModel);
//        EggPoolEntityModel updated = repo.saveAndFlush(proxyModel);
//    }
//
//    public void deleteEggInfo(int id)
//    {
//        repo.deleteById(id);
//    }
//
//    private static EggPoolEntityModel mapServiceToEntity(EggPoolServiceModel serviceModel)
//    {
//        EggPoolEntityModel entityModel = new EggPoolEntityModel();
//
//        entityModel.setPokemon(serviceModel.getPokemon());
//        entityModel.setEggDistance(serviceModel.getEggDistance());
//        entityModel.setMinCp(serviceModel.getMinCp());
//        entityModel.setMaxCp(serviceModel.getMaxCp());
//        entityModel.setShinyAvailable(serviceModel.getShinyAvailable());
//
//        return entityModel;
//    }
//
//    private EggPoolEntityModel updateProxyEntity(EggPoolEntityModel proxyModel, EggPoolEntityModel entityModel)
//    {
//        proxyModel.setPokemon(entityModel.getPokemon());
//        proxyModel.setEggDistance(entityModel.getEggDistance());
//        proxyModel.setMinCp(entityModel.getMinCp());
//        proxyModel.setMaxCp(entityModel.getMaxCp());
//        proxyModel.setShinyAvailable(entityModel.getShinyAvailable());
//
//        return proxyModel;
//    }
//}
