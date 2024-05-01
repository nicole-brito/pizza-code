package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tamanhos")
public class Tamanho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTamanho;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double desconto;

    @OneToMany(mappedBy = "idTamanho")
    private Set<PizzaPedida> idTamanhoPizzaPedida;
}
