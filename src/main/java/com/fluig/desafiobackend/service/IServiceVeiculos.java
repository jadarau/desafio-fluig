package com.fluig.desafiobackend.service;

import com.fluig.desafiobackend.dto.PrevisaoGastosDTO;
import com.fluig.desafiobackend.dto.RakingGastosDTO;
import com.fluig.desafiobackend.dto.VeiculoDTO;
import com.fluig.desafiobackend.dto.VeiculoRankeadoDTO;
import com.fluig.desafiobackend.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServiceVeiculos {

    public Veiculo create(Veiculo veiculo);
    public List<Veiculo> findVeiculos();
    public List<RakingGastosDTO> gastos(List<Veiculo> veiculos, PrevisaoGastosDTO previsaoGastosDTO);
    public List<VeiculoRankeadoDTO> ranking(List<RakingGastosDTO> rakingGastosDTO, List<Veiculo> veiculos);
    public List<VeiculoDTO> getAll(List<Veiculo> veiculos);
}
