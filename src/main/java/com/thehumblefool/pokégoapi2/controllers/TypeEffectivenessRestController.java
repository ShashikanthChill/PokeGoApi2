/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import com.thehumblefool.pokégoapi2.exceptions.InvalidRequestParamException;
import com.thehumblefool.pokégoapi2.exceptions.PokémonTypeNotFoundException;
import com.thehumblefool.pokégoapi2.models.api.TypeEffectivenessApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.TypeEffectivenessDTOModel;
import com.thehumblefool.pokégoapi2.services.TypeEffectivenessPublicService;
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
//@Api(tags = {"Type-Effectiveness Info"})
@RequestMapping(path = "public-api/effectiveness")
public class TypeEffectivenessRestController {

    private final TypeEffectivenessPublicService service;

    @Autowired
    public TypeEffectivenessRestController(TypeEffectivenessPublicService service) {
        this.service = service;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeEffectivenessApiModel AllTypesHandler() {
        return service.loadAllTypeEffectives();
    }

    @RequestMapping(path = "meta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeEffectivenessApiModel AllTypesMetaHandler() {
        return service.loadAllTypeEffectivesMeta();
    }

    @RequestMapping(path = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeEffectivenessDTOModel> SpecificTypeHandler(@RequestParam Map<String, String> filterParams, HttpServletRequest request) {
        String filterParam = filterParams.keySet().iterator().next().trim();
        switch (filterParam) {
            case "type": {
                String type = filterParams.get(filterParam);
                List<TypeEffectivenessDTOModel> specificTypeEffectives = service.loadTypeEffectivesByType(type);
                if (specificTypeEffectives == null || specificTypeEffectives.isEmpty()) {
                    throw new PokémonTypeNotFoundException("Pokémon Type: `" + type + "` not found.");
                }
                return specificTypeEffectives;
            }
            default:
                throw new InvalidRequestParamException("Invalid request parameter: '" + filterParam + "'. Please refer to Api docs at: " + request.getHeader("host"));
        }
    }
}
