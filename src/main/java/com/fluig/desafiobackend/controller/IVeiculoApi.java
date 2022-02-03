package com.fluig.desafiobackend.controller;

import com.fluig.desafiobackend.dto.PrevisaoGastosDTO;
import com.fluig.desafiobackend.dto.VeiculoDTO;
import com.fluig.desafiobackend.model.Veiculo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/ficticius")
public interface IVeiculoApi {

    @PostMapping(value = "/veiculo", produces = {"application/json"})
    ResponseEntity<Veiculo> saveVeiculos(@RequestBody Veiculo veiculo);

    @PostMapping(value = "/previsao", produces = {"application/json"})
    ResponseEntity<List<Veiculo>> findVeiculosRankeados(@RequestBody PrevisaoGastosDTO previsaoGastosDTO);
}
