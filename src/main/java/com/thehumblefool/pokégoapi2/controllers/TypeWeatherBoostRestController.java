/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thehumblefool.pokégoapi2.controllers;

import com.thehumblefool.pokégoapi2.models.api.TypeWeathersApiModel;
import com.thehumblefool.pokégoapi2.services.TypeWeatherPublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author The_Humble_Fool
 */
@RestController
//@Api(tags = {"Type-Weather Info"})
@RequestMapping(path = "public-api/types")
public class TypeWeatherBoostRestController {

    private final TypeWeatherPublicService service;

    @Autowired
    public TypeWeatherBoostRestController(TypeWeatherPublicService service) {
        System.out.println("typ-wea const");
        this.service = service;
    }

    @RequestMapping(path = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeWeathersApiModel AllTypesHandler() {
        return service.loadAllTypesWeather();
    }

    @RequestMapping(path = "meta", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeWeathersApiModel AllTypesMetaHandler() {
        return service.loadAllTypesWeatherMeta();
    }

    @RequestMapping(path = "sorted", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeWeathersApiModel AllTypesSortedHandler() {
        return service.loadSortedWeatherTypes();
    }
}
