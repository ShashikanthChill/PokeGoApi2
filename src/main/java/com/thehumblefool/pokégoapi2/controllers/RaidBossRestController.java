/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import com.thehumblefool.pokégoapi2.exceptions.InvalidRequestParamException;
import com.thehumblefool.pokégoapi2.exceptions.PokémonNotFoundException;
import com.thehumblefool.pokégoapi2.exceptions.RequestParamFormatException;
import com.thehumblefool.pokégoapi2.models.dtos.RaidDTOModel;
import com.thehumblefool.pokégoapi2.models.api.RaidsApiModel;
import com.thehumblefool.pokégoapi2.services.RaidsPublicService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
//@Api(tags = {"Raids Info"})
@RequestMapping(path = "public-api/raids")
public class RaidBossRestController {

    private final RaidsPublicService service;

    @Autowired
    public RaidBossRestController(RaidsPublicService service) {
        this.service = service;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RaidsApiModel AllRaidBossesHandler() {
        return service.loadAllRaids();
    }

    @RequestMapping(path = "meta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RaidsApiModel RaidBossesMetaHandler() {
        return service.loadAllRaidsMeta();
    }

    @RequestMapping(path = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RaidDTOModel> FilteredRaidBossesHandler(@RequestParam Map<String, String> filterParams, HttpServletRequest request) {
        String filterParam = filterParams.keySet().iterator().next().trim();
        switch (filterParam) {
            case "tier": {
                try {
                    int tier = Integer.parseInt(filterParams.get(filterParam));
                    List<RaidDTOModel> tieredRaidBosses = service.loadRaidsByTier(tier);
                    if (tieredRaidBosses == null || tieredRaidBosses.isEmpty()) {
                        throw new PokémonNotFoundException("Raid boss(s) not found for 'tier'=`" + tier + "`");
                    }
                    return tieredRaidBosses;
                } catch (NumberFormatException nfe) {
                    throw new RequestParamFormatException("Unsupported value found for 'tier'=`" + filterParams.get(filterParam) + "`. Please refer to Api docs at http://" + request.getLocalName());
                }
            }

            case "name": {
                String name = filterParams.get(filterParam);
                List<RaidDTOModel> namedRaidBoss = service.loadRaidsByName(name);
                if (namedRaidBoss == null || namedRaidBoss.isEmpty()) {
                    throw new PokémonNotFoundException("Raid boss(s) not found for 'name'=`" + name + "`");
                }
                return namedRaidBoss;

            }

            case "type": {
                String type = filterParams.get(filterParam);
                List<RaidDTOModel> raidBossesByType = service.loadRaidsByType(type);
                if (raidBossesByType == null || raidBossesByType.isEmpty()) {
                    throw new PokémonNotFoundException("Raid boss(s) not found for 'type'=`" + type + "`");
                }
                return raidBossesByType;

            }

            case "shiny": {

                if (filterParams.get(filterParam).equalsIgnoreCase("true") || filterParams.get(filterParam).equalsIgnoreCase("false")) {
                    boolean shiny = Boolean.parseBoolean(filterParams.get(filterParam));
                    List<RaidDTOModel> raidBossesByShiny = service.loadRaidsByShiny(shiny);
                    if (raidBossesByShiny == null || raidBossesByShiny.isEmpty()) {
                        throw new PokémonNotFoundException("Raid boss(s) not found for 'shiny'=`" + shiny + "`");
                    }
                    return raidBossesByShiny;
                }
                throw new RequestParamFormatException("Unsupported value found for 'shiny'=`" + filterParams.get(filterParam) + "`. Please refer to Api docs at http://" + request.getLocalName());

            }
            default:
                throw new InvalidRequestParamException("Invalid request parameter: '" + filterParam + "'. Please refer to Api docs at http://" + request.getLocalName());
        }
    }
}
