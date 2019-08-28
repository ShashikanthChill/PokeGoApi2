package com.thehumblefool.pokégoapi2.configs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package com.thehumblefool.pokégoapi2;

//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.Tag;
//import springfox.documentation.service.VendorExtension;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;

/**
 *
 * @author TheHumbleFool
 */
//@Configuration
//public class Swagger2Config {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.thehumblefool.pokégoapi2.controllers"))
//                .paths(PathSelectors.ant("/public-api/**"))
//                .build()
//                .apiInfo(apiInfo())
//                .tags(new Tag("Raids Info", "Information regarding currently available raids battles."),
//                        new Tag("Egg Hatches Info", "Information regarding currently available egg hatches."),
//                        new Tag("Research Breakthrough Encounters Info", "Information regarding currently available research breakthrough encounters."),
//                        new Tag("Type-Weather Info", "Information regarding currently available Pokémon types and related weather."),
//                        new Tag("Type-Effectiveness Info", "Information regarding currently available Pokémon types and effectiveness against other types.")
//                );
//    }
//
//    @Bean
//    public ApiInfo apiInfo() {
//        Contact contact = new Contact("TheHumbleFool", "https://github.com/The-Humble-Fool", "chillappagarishashikanth@gmail.com");
//        List<VendorExtension> vendorExtensions = new ArrayList<>();
//        ApiInfo apiInfo = new ApiInfo("PokéGo API", "The RESTful Pokémon GO In-game events info API", "2", "#", contact, "Free License", "#", vendorExtensions);
//        return apiInfo;
//    }
//}
