package com.fluig.desafiobackend.config;

import com.fluig.desafiobackend.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.ParseException;

@Configuration
@Profile("desafio")
public class DesafioConfig {

    @Autowired
    private DBService DBService;

    @Bean
    public void instaciaDB() throws ParseException {
        this.DBService.instaciaBancoDeDados();
    }
}
