package com.thehumblefool.pokégoapi2;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableSwagger2 
//Disabling Swagger docs for time being. Needs lot of configurations to be done.
@EnableBatchProcessing
public class PokéGoApi2Application {

    public static void main(String[] args) {
        SpringApplication.run(PokéGoApi2Application.class, args);
    }

}
