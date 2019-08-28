/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author The_Humble_Fool
 */
@Controller
public class MainController {

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String welcomePage(Model model) {

        Map<String, String> raidParams = new HashMap<>();
        raidParams.put("name", "String");
        raidParams.put("tier", "Number");
        raidParams.put("type", "String");
        raidParams.put("shiny", "Boolean");

        Map<String, String> eggHatchParams = new HashMap<>();
        eggHatchParams.put("distance", "Number");
        eggHatchParams.put("shiny", "Boolean");

        Map<String, String> encounterParams = new HashMap<>();
        encounterParams.put("name", "String");
        encounterParams.put("shiny", "Boolean");

        Map<String, String> effectivenessParams = new HashMap<>();
        effectivenessParams.put("type", "String");

        model.addAttribute("raidParams", raidParams);
        model.addAttribute("eggHatchParams", eggHatchParams);
        model.addAttribute("encounterParams", encounterParams);
        model.addAttribute("effectivenessParams", effectivenessParams);
        return "welcome_page";
    }

}
