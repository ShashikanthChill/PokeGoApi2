/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import com.thehumblefool.pokégoapi2.exceptions.InvalidRequestParamException;
import com.thehumblefool.pokégoapi2.exceptions.PokémonNotFoundException;
import com.thehumblefool.pokégoapi2.exceptions.RequestParamFormatException;
import com.thehumblefool.pokégoapi2.models.api.ResearchBreakthroughEncountersApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.ResearchBreakthroughEncounterDTOModel;
import com.thehumblefool.pokégoapi2.services.ResearchBreakthroughEncountersPublicService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author The_Humble_Fool
 */
@RestController
//@Api(tags = {"Research Breakthrough Encounters Info"})
@RequestMapping(path = "public-api/encounters")
public class ResearchBreakthroughEncountersRestController {

    private final ResearchBreakthroughEncountersPublicService service;

    @Autowired
    public ResearchBreakthroughEncountersRestController(ResearchBreakthroughEncountersPublicService service) {
        System.out.println("rsrch-brk-enc const");
        this.service = service;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResearchBreakthroughEncountersApiModel AllEncoutersHandler() {
        return service.loadAllEncounters();
    }

    @RequestMapping(path = "meta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResearchBreakthroughEncountersApiModel AllEncoutersMetaHandler() {
        return service.loadAllEncountersMeta();
    }

    @RequestMapping(path = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ResearchBreakthroughEncounterDTOModel> AllFilteredEncountersHandler(@RequestParam Map<String, String> filterParams) {
        String filterParam = filterParams.keySet().iterator().next().trim();
        switch (filterParam) {
            case "name": {
                String name = filterParams.get(filterParam);
                List<ResearchBreakthroughEncounterDTOModel> namedEncounters = service.loadEncountersByName(name);
                if (namedEncounters == null || namedEncounters.isEmpty()) {
                    throw new PokémonNotFoundException("Reseach breakthrough encounter(s) not found for 'name'=`" + name + "`");
                }
                return namedEncounters;
            }
            case "shiny": {
                if (filterParams.get(filterParam).equalsIgnoreCase("true") || filterParams.get(filterParam).equalsIgnoreCase("false")) {
                    boolean shiny = Boolean.parseBoolean(filterParams.get(filterParam));
                    List<ResearchBreakthroughEncounterDTOModel> shinyEncounters = service.loadEncountersByShiny(shiny);
                    if (shinyEncounters == null || shinyEncounters.isEmpty()) {
                        throw new PokémonNotFoundException("Reseach breakthrough encounter(s) not found for 'shiny'=`" + shiny + "`");
                    }
                    return shinyEncounters;
                }
                throw new RequestParamFormatException("Unsupported value found for 'shiny'=`" + filterParams.get(filterParam) + "`. Please refer to Api docs: http://localhost:8080/PokéApi/");
            }
            default:
                throw new InvalidRequestParamException("Invalid request parameter: '" + filterParam + "'. Please refer to Api docs: http://localhost:8080/PokéApi/");
        }
    }
}
