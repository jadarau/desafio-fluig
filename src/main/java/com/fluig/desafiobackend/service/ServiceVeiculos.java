package com.fluig.desafiobackend.service;

import com.fluig.desafiobackend.dto.PrevisaoGastosDTO;
import com.fluig.desafiobackend.dto.RakingGastosDTO;
import com.fluig.desafiobackend.model.Veiculo;
import com.fluig.desafiobackend.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceVeiculos {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo create(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findVeiculos(){
        return veiculoRepository.findAll();
    }

    public List<RakingGastosDTO> ranking(List<Veiculo> veiculos, PrevisaoGastosDTO previsaoGastosDTO){
        List<RakingGastosDTO> finalRakingGastosDTO = new ArrayList<>();
        veiculos.forEach((veiculo -> {
            double percorridoCidade = previsaoGastosDTO.getPercorridoCidade() / veiculo.getConsumoCidade();
            double percorridoRodovias = previsaoGastosDTO.getPercorridoRodovias() / veiculo.getConsumoRodovias();
            double totalPercorrido = percorridoCidade + percorridoRodovias;
            double valorGato = totalPercorrido * previsaoGastosDTO.getPrecoGasolina();
            RakingGastosDTO rakingGastos = new RakingGastosDTO(veiculo.getId(), valorGato);
            finalRakingGastosDTO.add(rakingGastos);
        }));
        List<RakingGastosDTO> rakingGastosDTO = finalRakingGastosDTO.stream().sorted(Comparator.comparing(RakingGastosDTO::getValorTotal).reversed()).collect(Collectors.toList());
        return rakingGastosDTO;
    }
}
