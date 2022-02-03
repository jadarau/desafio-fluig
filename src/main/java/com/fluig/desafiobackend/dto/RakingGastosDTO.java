package com.fluig.desafiobackend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RakingGastosDTO {

    @JsonProperty("Id")
    private long id;
    @JsonProperty("Valor total gasto")
    private double valorTotal;
}
