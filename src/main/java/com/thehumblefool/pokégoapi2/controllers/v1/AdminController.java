package com.thehumblefool.pokégoapi2.controllers;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.thehumblefool.pokegoapi2.controllers;
//
//import com.the_humble_fool.PokeGoApi.services.ResearchBreakthroughEncountersAdminService;
//import com.the_humble_fool.PokeGoApi.models.entitymodels.EggPoolEntityModel;
//import com.the_humble_fool.PokeGoApi.models.entitymodels.ResearchBreakthroughEncountersEntityModel;
//import com.the_humble_fool.PokeGoApi.models.servicemodels.RaidBossServiceModel;
//import com.the_humble_fool.PokeGoApi.services.EggPoolAdminService;
//import com.the_humble_fool.PokeGoApi.services.RaidBossAdminService;
//import com.thehumblefool.pokegoapi2.models.dtomodels.EggPoolServiceModel;
//import com.thehumblefool.pokegoapi2.models.dtomodels.ResearchBreakthroughEncountersServiceModel;
//import com.thehumblefool.pokegoapi2.models.entitymodels.RaidBossEntityModel;
//import java.util.List;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author The_Humble_Fool
// */
//@Controller
//@RequestMapping(path = "admin/")
//public class AdminController
//{
//
//    @Autowired
//    RaidBossAdminService raidBossAdminService;
//
//    @Autowired
//    EggPoolAdminService eggPoolAdminService;
//
//    @Autowired
//    ResearchBreakthroughEncountersAdminService breakthroughEncountersAdminService;
//
//    //landing url
//    @RequestMapping(path = "")
//    public String greetAdmin(HttpServletRequest hsr)
//    {
//        return "adminpage";
//    }
//
//    @RequestMapping(path = "submitegginfo", method = RequestMethod.POST)
//    public String saveResearchBreakthroughEncounterInfo(EggPoolServiceModel serviceModel)
//    {
//        System.out.println("Received model for insert: " + serviceModel);
//        eggPoolAdminService.saveEggInfo(serviceModel);
//        return "redirect:eggpoollist";
//    }
//
//    @RequestMapping(path = "updateegginfo", method = RequestMethod.POST)
//    public String updateEggInfo(EggPoolEntityModel entityModel)
//    {
//        System.out.println("Received model for update: " + entityModel);
//        eggPoolAdminService.updateEggInfo(entityModel);
//        return "redirect:eggpoollist";
//    }
//
//    @RequestMapping(path = "deleteegginfo", method = RequestMethod.POST)
//    public String deleteEggInfo(@RequestParam("id") int id)
//    {
//        System.out.println("Received Id for delete: " + id);
//        eggPoolAdminService.deleteEggInfo(id);
//        return "empty";
//    }
//
//    @RequestMapping(path = "eggpoollist", method = RequestMethod.GET)
//    public ModelAndView returnEggPoolList()
//    {
//        List<EggPoolEntityModel> allEggpools = eggPoolAdminService.getAllEggpools();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("entitymodels", allEggpools);
//        mv.setViewName("eggpoolpage_1");
//        return mv;
//    }
//
//    @RequestMapping(path = "submitraidbossinfo", method = RequestMethod.POST)
//    public String saveRaidBossInfo(RaidBossServiceModel serviceModel)
//    {
//        System.out.println("Received model for insert: " + serviceModel);
//        raidBossAdminService.saveRaidBossInfo(serviceModel);
//        return "redirect:raidbosslist";
//    }
//
//    @RequestMapping(path = "updateraidbossinfo", method = RequestMethod.POST)
//    public String updateRaidBossInfo(RaidBossEntityModel entityModel)
//    {
//        System.out.println("Received model for update: " + entityModel);
//        raidBossAdminService.updateRaidBossInfo(entityModel);
//        return "redirect:raidbosslist";
//    }
//
//    @RequestMapping(path = "deleteraidbossinfo", method = RequestMethod.POST)
//    public String deleteRaidBossInfo(@RequestParam("id") int id)
//    {
//        System.out.println("Received Id for delete: " + id);
//        raidBossAdminService.deleteRaidBossInfo(id);
//        return "empty";
//    }
//
//    @RequestMapping(path = "raidbosslist", method = RequestMethod.GET)
//    public ModelAndView returnRaidBossList()
//    {
//        List<RaidBossEntityModel> allRaidBosses = raidBossAdminService.getAllRaidBosses();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("entitymodels", allRaidBosses);
//        mv.setViewName("raidbosspage_1");
//        return mv;
//    }
//
//    //Research Breakthrough Encounters related urls
//    //==================
//    @RequestMapping(path = "submitencounterinfo", method = RequestMethod.POST)
//    public String saveResearchBreakthroughEncounterInfo(ResearchBreakthroughEncountersServiceModel serviceModel)
//    {
//        System.out.println("Received model for insert: " + serviceModel);
//        breakthroughEncountersAdminService.saveResearchBreakthroughEncounterInfo(serviceModel);
//        return "redirect:encounterslist";
//    }
//
//    @RequestMapping(path = "updateencounterinfo", method = RequestMethod.POST)
//    public String updateResearchBreakthroughEncounterInfo(ResearchBreakthroughEncountersEntityModel entityModel)
//    {
//        System.out.println("Received model for update: " + entityModel);
//        breakthroughEncountersAdminService.updateResearchBreakthroughEncounterInfo(entityModel);
//        return "redirect:encounterslist";
//    }
//
//    @RequestMapping(path = "deleteencounterinfo", method = RequestMethod.POST)
//    public String deleteResearchBreakthroughEncounterInfo(@RequestParam("id") int id)
//    {
//        System.out.println("Received Id for delete: " + id);
//        breakthroughEncountersAdminService.deleteResearchBreakthroughEncounterInfo(id);
//        return "empty";
//    }
//
//    @RequestMapping(path = "encounterslist", method = RequestMethod.GET)
//    public ModelAndView returnBreakthroughEncountersList()
//    {
//        List<ResearchBreakthroughEncountersEntityModel> allbreakthroughEncounters = breakthroughEncountersAdminService.getAllResearchBreakthroughEncounters();
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("entitymodels", allbreakthroughEncounters);
//        mv.setViewName("breakthroughencounterspage_1");
//        return mv;
//    }
//}
