package com.thehumblefool.pokégoapi2.services.v1;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokegoapi2.services;
//
//import com.the_humble_fool.PokeGoApi.jparepositories.ResearchBreakthroughEncountersJpaRepo;
//import com.the_humble_fool.PokeGoApi.models.entitymodels.ResearchBreakthroughEncountersEntityModel;
//import com.the_humble_fool.PokeGoApi.models.servicemodels.ResearchBreakthroughEncountersServiceModel;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Service
//public class ResearchBreakthroughEncountersAdminService
//{
//
//    @Autowired
//    ResearchBreakthroughEncountersJpaRepo repo;
//
//    public List<ResearchBreakthroughEncountersEntityModel> getAllResearchBreakthroughEncounters()
//    {
//        List<ResearchBreakthroughEncountersEntityModel> breakthroughEncountersEntityModels = repo.findAll();
//        return breakthroughEncountersEntityModels;
//    }
//
//    public void saveResearchBreakthroughEncounterInfo(ResearchBreakthroughEncountersServiceModel serviceModel)
//    {
//        ResearchBreakthroughEncountersEntityModel entityModel = mapServiceToEntity(serviceModel);
//        repo.saveAndFlush(entityModel);
//    }
//
//    public void updateResearchBreakthroughEncounterInfo(ResearchBreakthroughEncountersEntityModel entityModel)
//    {
//        ResearchBreakthroughEncountersEntityModel proxyModel = repo.getOne(entityModel.getId());
//        proxyModel = updateProxyEntity(proxyModel, entityModel);
//        ResearchBreakthroughEncountersEntityModel saveAndFlush = repo.saveAndFlush(proxyModel);
//    }
//
//    public void deleteResearchBreakthroughEncounterInfo(int id)
//    {
//        repo.deleteById(id);
//    }
//
//    private static ResearchBreakthroughEncountersEntityModel mapServiceToEntity(ResearchBreakthroughEncountersServiceModel serviceModel)
//    {
//        ResearchBreakthroughEncountersEntityModel entityModel = new ResearchBreakthroughEncountersEntityModel();
//
//        entityModel.setPokeDex(serviceModel.getPokeDex());
//        entityModel.setPokemon(serviceModel.getPokemon());
//        entityModel.setMinCp(serviceModel.getMinCp());
//        entityModel.setMaxCp(serviceModel.getMaxCp());
//        entityModel.setShinyAvailable(serviceModel.getShinyAvailable());
//
//        return entityModel;
//    }
//
//    private ResearchBreakthroughEncountersEntityModel updateProxyEntity(ResearchBreakthroughEncountersEntityModel proxyModel, ResearchBreakthroughEncountersEntityModel entityModel)
//    {
//        proxyModel.setPokeDex(entityModel.getPokeDex());
//        proxyModel.setPokemon(entityModel.getPokemon());
//        proxyModel.setMinCp(entityModel.getMinCp());
//        proxyModel.setMaxCp(entityModel.getMaxCp());
//        proxyModel.setShinyAvailable(entityModel.getShinyAvailable());
//
//        return proxyModel;
//    }
//}
