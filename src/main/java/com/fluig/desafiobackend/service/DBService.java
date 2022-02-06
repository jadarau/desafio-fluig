package com.fluig.desafiobackend.service;

import com.fluig.desafiobackend.model.Veiculo;
import com.fluig.desafiobackend.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void instaciaBancoDeDados() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formato.parse("1990-05-22");
        Date data2 = formato.parse("2020-03-04");
        Date data3 = formato.parse("2021-02-02");

        Veiculo veiculo = new Veiculo(1, "Creta", "Hiundai", "Trend", data3, 9, 14);
        Veiculo veiculo2 = new Veiculo(2, "EcoSport", "Ford", "Titanium", data2, 8, 12);
        Veiculo veiculo3 = new Veiculo(3, "Opala", "Chevrolet", "Classico", data, 4, 7);
        Veiculo veiculo4 = new Veiculo(4, "Toro", "Fiat", "Diesel", data2, 10, 15);

        this.veiculoRepository.saveAll(Arrays.asList(veiculo, veiculo2, veiculo3, veiculo4));
    }
}
