package com.fluig.desafiobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeiculoRankeadoDTO {

    @JsonProperty("Id")
    private long id;
    @JsonProperty("Nome")
    private String nome;
    @JsonProperty("Marca")
    private String marca;
    @JsonProperty("Modelo")
    private String modelo;
    @JsonProperty("Data de fabricação")
    private Date fabricacao;
    @JsonProperty("Consumo na cidade")
    private double consumoCidade;
    @JsonProperty("Consumo em rodovias")
    private double consumoRodovias;
    @JsonProperty("Valor total gasto")
    private double totalgasto;
}
