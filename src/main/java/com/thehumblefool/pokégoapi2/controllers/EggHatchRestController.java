/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import com.thehumblefool.pokégoapi2.exceptions.EggHatchNotFoundException;
import com.thehumblefool.pokégoapi2.exceptions.InvalidRequestParamException;
import com.thehumblefool.pokégoapi2.exceptions.RequestParamFormatException;
import com.thehumblefool.pokégoapi2.models.api.EggHatchesApiModel;
import com.thehumblefool.pokégoapi2.models.dtos.EggHatchDTOModel;
import com.thehumblefool.pokégoapi2.services.EggHatchesPublicService;
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
//@Api(tags = {"Egg Hatches Info"})
@RequestMapping(path = "public-api/eggs")
public class EggHatchRestController {

    private final EggHatchesPublicService service;

    @Autowired
    public EggHatchRestController(EggHatchesPublicService service) {
        this.service = service;
    }

//    @ApiOperation(value = "This rest end point will provide list of all currently available egg hatches data, including meta data.",response = EggHatchesApiModel.class )
    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EggHatchesApiModel AllEggHatchesHandler() {
        return service.loadAllHatches();
    }

//    @ApiOperation(value = "This rest end point will provide metadata of currently available egg hatches. Metadata includes total no.of hatches available, distance(km) levels, no.of hatches per distance(km) level, e.t.c.",response = EggHatchApiModel.class )
    @RequestMapping(path = "meta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public EggHatchesApiModel AllEggHatchesMetaHandler() {
        return service.loadAllHatchesMeta();
    }

    @RequestMapping(path = "filter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<EggHatchDTOModel> FilteredEggHatchesHandler(@RequestParam Map<String, String> filterParams) {

        String filterParam = filterParams.keySet().iterator().next().trim();
        switch (filterParam) {
            case "distance": {
                try {
                    int distance = Integer.parseInt(filterParams.get(filterParam));
                    List<EggHatchDTOModel> hatchesByDistance = service.loadHatchesByDistance(distance);
                    if (hatchesByDistance == null || hatchesByDistance.isEmpty()) {
                        throw new EggHatchNotFoundException("No Egg hatches found in " + distance + "km distance pool.");
                    }
                    return hatchesByDistance;
                } catch (NumberFormatException nfe) {
                    throw new RequestParamFormatException("Unsupported value found for 'distance'=`" + filterParams.get(filterParam) + "`. Please refer to Api docs: http://localhost:8080/PokéApi/");
                }
            }

            case "shiny": {
                if (filterParams.get(filterParam).equalsIgnoreCase("true") || filterParams.get(filterParam).equalsIgnoreCase("false")) {
                    boolean shiny = Boolean.parseBoolean(filterParams.get(filterParam));
                    List<EggHatchDTOModel> hatchesByShiny = service.loadHatchesByShiny(shiny);
                    if (hatchesByShiny == null || hatchesByShiny.isEmpty()) {
                        throw new EggHatchNotFoundException("No Egg hatches found for shiny'=`" + shiny + "`");
                    }
                    return hatchesByShiny;
                }
                throw new RequestParamFormatException("Unsupported value found for 'shiny'=`" + filterParams.get(filterParam) + "`. Please refer to Api docs: http://localhost:8080/PokéApi/");

            }
            default:
                throw new InvalidRequestParamException("Invalid request parameter: '" + filterParam + "'. Please refer to Api docs: http://localhost:8080/PokéApi/");
        }

    }
}
