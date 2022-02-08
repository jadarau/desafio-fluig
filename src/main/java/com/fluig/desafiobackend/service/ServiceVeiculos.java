package com.fluig.desafiobackend.service;

import com.fluig.desafiobackend.dto.PrevisaoGastosDTO;
import com.fluig.desafiobackend.dto.RakingGastosDTO;
import com.fluig.desafiobackend.dto.VeiculoDTO;
import com.fluig.desafiobackend.dto.VeiculoRankeadoDTO;
import com.fluig.desafiobackend.model.Veiculo;
import com.fluig.desafiobackend.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceVeiculos implements IServiceVeiculos{

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Veiculo create(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> findVeiculos(){
        return veiculoRepository.findAll();
    }

    public List<VeiculoRankeadoDTO> ranking(List<Veiculo> veiculos, PrevisaoGastosDTO previsaoGastosDTO){
        List<VeiculoRankeadoDTO> veiculosRakeados = new ArrayList<>();
        veiculos.forEach((veiculo -> {
            double percorridoCidade = previsaoGastosDTO.getPercorridoCidade() / veiculo.getConsumoCidade();
            double percorridoRodovias = previsaoGastosDTO.getPercorridoRodovias() / veiculo.getConsumoRodovias();
            double totalPercorrido = percorridoCidade + percorridoRodovias;
            double valorGasto = totalPercorrido * previsaoGastosDTO.getPrecoGasolina();

            final var veiculosrankeados = VeiculoRankeadoDTO.builder()
                    .id(veiculo.getId())
                    .nome(veiculo.getNome())
                    .marca(veiculo.getMarca())
                    .modelo(veiculo.getModelo())
                    .fabricacao(veiculo.getFabricacao())
                    .consumoCidade(veiculo.getConsumoCidade())
                    .consumoRodovias(veiculo.getConsumoRodovias())
                    .totalgasto(valorGasto)
                    .build();
            veiculosRakeados.add(veiculosrankeados);

        }));
        List<VeiculoRankeadoDTO> rakingGastosDTO = veiculosRakeados.stream().sorted(Comparator.comparing(VeiculoRankeadoDTO::getTotalgasto).reversed()).collect(Collectors.toList());
        return rakingGastosDTO;
    }

    public List<VeiculoDTO> getAll(List<Veiculo> veiculos){
        List<VeiculoDTO> veiculoDTOS = new ArrayList<>();
        veiculos.forEach((veiculo -> {
            final var veiculoDTO = VeiculoDTO.builder()
                    .id(veiculo.getId())
                    .nome(veiculo.getNome())
                    .marca(veiculo.getMarca())
                    .modelo(veiculo.getModelo())
                    .fabricacao(veiculo.getFabricacao())
                    .consumoCidade(veiculo.getConsumoCidade())
                    .consumoRodovias(veiculo.getConsumoRodovias())
                    .build();
            veiculoDTOS.add(veiculoDTO);
        }));
        return veiculoDTOS;
    }
}
