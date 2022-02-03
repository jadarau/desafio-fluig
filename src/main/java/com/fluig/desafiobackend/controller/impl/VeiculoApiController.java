package com.fluig.desafiobackend.controller.impl;

import com.fluig.desafiobackend.controller.IVeiculoApi;
import com.fluig.desafiobackend.dto.PrevisaoGastosDTO;
import com.fluig.desafiobackend.dto.RakingGastosDTO;
import com.fluig.desafiobackend.dto.VeiculoDTO;
import com.fluig.desafiobackend.model.Veiculo;
import com.fluig.desafiobackend.service.ServiceVeiculos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class VeiculoApiController implements IVeiculoApi {

    @Autowired
    private ServiceVeiculos serviceVeiculos;

    @Override
    public ResponseEntity<Veiculo> saveVeiculos(@RequestBody Veiculo veiculo) {
        veiculo = serviceVeiculos.create(veiculo);
        return ResponseEntity.ok(veiculo);
    }

    @Override
    public ResponseEntity<List<Veiculo>> findVeiculos(@RequestBody PrevisaoGastosDTO previsaoGastosDTO){
            List<RakingGastosDTO> rakingGastosDTO = new ArrayList<>();
            List<Veiculo> veiculos = serviceVeiculos.findVeiculos();
            rakingGastosDTO = serviceVeiculos.gastos(veiculos, previsaoGastosDTO);
            veiculos = serviceVeiculos.ranking(rakingGastosDTO, veiculos);

        return ResponseEntity.ok(veiculos);
    }
}
