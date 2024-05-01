package com.soulcode.pizzacode2.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pizzasPedidas")
public class PizzaPedida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPizzaPedida;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTamanho", nullable = false)
    private Tamanho idTamanho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPedido", nullable = false)
    private Pedido pedidos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPizza", nullable = false)
    private Pizza pizzas;

    @ManyToMany
    @JoinTable(
            name = "PizzapedidaHasIngrediente",
            joinColumns = @JoinColumn(name = "idPizzaPedida"),
            inverseJoinColumns = @JoinColumn(name = "idIngrediente")
    )
    private Set<Ingrediente> pizzapedida;

}
