package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bebidas")
public class Bebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBebida;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;
}
