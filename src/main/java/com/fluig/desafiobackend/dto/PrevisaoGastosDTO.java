package com.fluig.desafiobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PrevisaoGastosDTO {

    @JsonProperty(value = "Preço da Gasolina")
    private double precoGasolina;
    @JsonProperty(value = "Km total que será percorrido na cidade")
    private Integer percorridoCidade;
    @JsonProperty(value = "Km total que será percorrido nas rodovias")
    private Integer percorridoRodovias;

}
