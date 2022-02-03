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

    @JsonProperty
    private double precoGasolina;
    @JsonProperty
    private Integer percorridoCidade;
    @JsonProperty
    private Integer percorridoRodovias;

}
