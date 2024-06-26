package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizza;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double precoBase;

    @Column
    private Boolean personalizada;

    @OneToMany(mappedBy = "pizzas")
    private Set<PizzaPedida> IdPizzaPizzasPedidas;
}
