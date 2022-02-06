package com.fluig.desafiobackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Veiculo")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nome;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column
    private Date fabricacao;
    @Column
    private double consumoCidade;
    @Column
    private double consumoRodovias;
}
